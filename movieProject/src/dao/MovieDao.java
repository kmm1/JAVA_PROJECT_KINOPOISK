package dao;

import connection.ConnectionManager;
import entity.Actor;
import entity.Movie;
import entity.Review;

import java.sql.*;
import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class MovieDao {


    private static final Object LOCK = new Object();
    private static MovieDao INSTANCE = null;

    public static MovieDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Movie> saveMovie(Movie movie) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies (name, year, country, genre) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, movie.getName());
                preparedStatement.setInt(2, movie.getYear());
                preparedStatement.setString(3, movie.getCountry());
                preparedStatement.setString(4, movie.getGenre());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    movie.setId(generatedKeys.getLong(1));
                    return Optional.of(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public Optional<Movie> getMovieById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Movie
                            (id, resultSet.getString("name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> addActor(Movie movie, Actor actor) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO actors (name_lastname) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, actor.getNameLastname());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    actor.setId(generatedKeys.getLong(1));
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies_actors (movies_id, actors_id) VALUES (?, ?)")) {
                preparedStatement.setLong(1, movie.getId());
                preparedStatement.setLong(2, actor.getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();
            movie.addSetActor(actor);
            return Optional.of(movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public Optional<Movie> selectMovieByYear(int year) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT name FROM movies WHERE year = ?")) {
                preparedStatement.setInt(1, year);
                ResultSet resultSet = preparedStatement.executeQuery();
                Movie movie = new Movie(year);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                }
                return Optional.of(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> getFullInfo(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT mov.name AS mov_name, a.id AS actor_id, a.name_lastname AS actor_lastname, "
                            + "rev.id AS rev_id, rev.text "
                            + "FROM movies AS mov "
                            +"LEFT JOIN movies_actors AS ma ON mov.id = ma.movies_id "
                            +"LEFT JOIN actors AS a ON a.id = ma.actors_id "
                            + "LEFT JOIN reviews AS rev ON mov.id = rev.movies_id "
                            + "WHERE mov.id = ?")) {

                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                Movie movie = new Movie(id);
                while (resultSet.next()) {
                    movie.setName(resultSet.getString("mov_name"));
                    Actor actor = new Actor(resultSet.getLong("actor_id"), resultSet.getString("actor_lastname"));
                    movie.addSetActor(actor);
                    Review review = new Review(resultSet.getLong("rev_id"), resultSet.getString("text"), movie);
                    movie.addSetReview(review);
                }
                return Optional.of(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /*public Optional<Movie> selectActors(long id) {
        try(Connection connection = ConnectionManager.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT a.name_lastname " +
                            "FROM actors AS a " +
                            "JOIN movies_actors AS ma ON ma.actors_id = a.id " +
                            "JOIN movies AS m ON ma.actors_id=m.id " +
                            "WHERE m.name = 'From dusk till dawn movie';")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                Movie movie = new Movie(id);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nameLastname"));
                }
                return Optional.of(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }*/


}