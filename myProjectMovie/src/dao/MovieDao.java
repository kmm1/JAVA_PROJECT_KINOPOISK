package dao;

import connection.ConnectionManager;
import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public Optional<Movie> addMovie(Movie movie) {
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

    public List<Movie> findAllMovies() {
        List<Movie> movie = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        movie.add(new Movie(resultSet.getLong("id"),
                                resultSet.getString("name")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }


    public Optional<Movie> addMovieWithProducerActor(Movie movie, Producer producer, Actor actor) {
        try (Connection connection = ConnectionManager.getConnection()) {
            connection.setAutoCommit(false);
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
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies_producers (movies_id, producers_id) VALUES (?, ?)")) {
                preparedStatement.setLong(1, movie.getId());
                preparedStatement.setLong(2, producer.getId());
                preparedStatement.executeUpdate();
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies_actors (movies_id, actors_id) VALUES (?, ?)")) {
                preparedStatement.setLong(1, movie.getId());
                preparedStatement.setLong(2, actor.getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();
            movie.addSetProducer(producer);
            movie.addSetActor(actor);
            return Optional.of(movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> addMovieWithActor(long movieId, long actorId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies_actors (movies_id, actors_id) VALUES (?, ?)")) {
                preparedStatement.setLong(1, movieId);
                preparedStatement.setLong(2, actorId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> addMovieWithProducer(long movieId, long producerId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies_producers (movies_id, producers_id) VALUES (?, ?)")) {
                preparedStatement.setLong(1, movieId);
                preparedStatement.setLong(2, producerId);
                preparedStatement.executeUpdate();
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

    public Optional<Movie> getMovieByName(String name) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies WHERE name = ?")) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                Movie movie = new Movie(name);
                if (resultSet.next()) {
                    return Optional.of(new Movie
                            (resultSet.getLong("id"), name));
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
                    "SELECT mov.name AS mov_name, mov.genre AS mov_genre, mov.year AS mov_year, mov.country AS mov_country, "
                            + "a.id AS actor_id, a.lastname AS actor_lastname, a.name AS actor_name, a.year_of_birth AS actor_year, "
                            + "p.id AS prod_id, p.lastname AS prod_lastname, p.name AS prod_name, p.year_of_birth AS prod_year, "
                            + "rev.id AS rev_id, rev.text "
                            + "FROM movies AS mov "
                            + "LEFT JOIN movies_actors AS ma ON mov.id = ma.movies_id "
                            + "LEFT JOIN actors AS a ON a.id = ma.actors_id "
                            + "LEFT JOIN movies_producers AS mp ON mov.id = mp.movies_id "
                            + "LEFT JOIN producers AS p ON p.id = mp.producers_id "
                            + "LEFT JOIN reviews AS rev ON mov.id = rev.movies_id "
                            + "WHERE mov.id = ?")) {

                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                Movie movie = new Movie(id);
                while (resultSet.next()) {
                    movie.setName(resultSet.getString("mov_name"));
                    movie.setGenre(resultSet.getString("mov_genre"));
                    movie.setCountry(resultSet.getString("mov_country"));
                    movie.setYear(resultSet.getInt("mov_year"));
                    Actor actor = new Actor(resultSet.getLong("actor_id"),
                            resultSet.getString("actor_lastname"),
                            resultSet.getString("actor_name"),
                            resultSet.getInt("actor_year"));
                    movie.addSetActor(actor);
                    Producer producer = new Producer(resultSet.getLong("prod_id"),
                            resultSet.getString("prod_lastname"),
                            resultSet.getString("prod_name"),
                            resultSet.getInt("prod_year"));
                    movie.addSetProducer(producer);
                    Review review = new Review(resultSet.getLong("rev_id"),
                            resultSet.getString("text"));
                    //movie.addSetReview(review);  //do not take off comment!!!!!!
                }
                return Optional.of(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> getMovieInfoByYear(int year) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT mov.id AS mov_id, mov.name AS mov_name, mov.year AS mov_year, " +
                            "mov.country AS mov_country, mov.genre AS mov_genre, " +
                            "a.id AS actor_id, a.name AS actor_name, a.lastname AS actor_lastname, a.year_of_birth AS actor_year, " +
                            "p.id AS producer_id, p.name AS producer_name, p.lastname AS producer_lastname, p.year_of_birth AS producer_year " +
                            "FROM movies AS mov " +
                            "LEFT JOIN movies_actors AS ma ON mov.id = ma.movies_id " +
                            "LEFT JOIN actors AS a ON a.id = ma.actors_id " +
                            "LEFT JOIN movies_producers AS mp ON mov.id = mp.movies_id " +
                            "LEFT JOIN producers AS p ON p.id = mp.producers_id " +
                            "WHERE mov.year = ?")) {
                preparedStatement.setLong(1, year);
                ResultSet resultSet = preparedStatement.executeQuery();
                Movie movie = new Movie(year);
                while (resultSet.next()) {
                    movie.setId(resultSet.getLong("mov_id"));
                    movie.setName(resultSet.getString("mov_name"));
                    movie.setYear(resultSet.getInt("mov_year"));
                    movie.setCountry(resultSet.getString("mov_country"));
                    movie.setGenre(resultSet.getString("mov_genre"));
                    Actor actor = new Actor(resultSet.getLong("actor_id"),
                            resultSet.getString("actor_name"),
                            resultSet.getString("actor_lastname"),
                            resultSet.getInt("actor_year"));
                    movie.addSetActor(actor);
                    Producer producer = new Producer(resultSet.getLong("producer_id"),
                            resultSet.getString("producer_name"),
                            resultSet.getString("producer_lastname"),
                            resultSet.getInt("producer_year"));
                    movie.addSetProducer(producer);

                }
                return Optional.of(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<Movie> movieInfoByName(long name) {
        List<Movie> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT mov.id AS mov_id, mov.name AS mov_name, mov.year AS mov_year, " +
                            "mov.country AS mov_country, mov.genre AS mov_genre, " +
                            "a.id AS actor_id, a.name AS actor_name, a.lastname AS actor_lastname, a.year_of_birth AS actor_year, " +
                            "p.id AS producer_id, p.name AS producer_name, p.lastname AS producer_lastname, p.year_of_birth AS producer_year " +
                            "FROM movies AS mov " +
                            "LEFT JOIN movies_actors AS ma ON mov.id = ma.movies_id " +
                            "LEFT JOIN actors AS a ON a.id = ma.actors_id " +
                            "LEFT JOIN movies_producers AS mp ON mov.id = mp.movies_id " +
                            "LEFT JOIN producers AS p ON p.id = mp.producers_id " +
                            "WHERE mov.id = ?")) {
                preparedStatement.setLong(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        long mov_id = resultSet.getLong("mov_id");
                        String mov_name = resultSet.getString("mov_name");
                        int mov_year = resultSet.getInt("mov_year");
                        String mov_country = resultSet.getString("mov_country");
                        String mov_genre = resultSet.getString("mov_genre");

                        long actor_id = resultSet.getLong("actor_id");
                        String actor_name = resultSet.getString("actor_name");
                        String actor_lastname = resultSet.getString("actor_lastname");
                        int actor_year = resultSet.getInt("actor_year");

                        Actor actor = new Actor(actor_id, actor_name, actor_lastname, actor_year);
                        long producer_id = resultSet.getLong("producer_id");
                        String producer_name = resultSet.getString("producer_name");
                        String producer_lastname = resultSet.getString("producer_lastname");
                        int producer_year = resultSet.getInt("producer_year");

                        Producer producer = new Producer(producer_id, producer_name, producer_lastname, producer_year);
                        Movie movie = new Movie(mov_id, mov_name, mov_year, mov_country, mov_genre, actor, producer);
                        result.add(movie);
                    }
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return result;
    }

    public static List<Producer> movieInfoByName2(long name) {
        List<Producer> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT mov.id AS mov_id, mov.name AS mov_name, mov.year AS mov_year, " +
                            "mov.country AS mov_country, mov.genre AS mov_genre, " +
                            "p.id AS producer_id, p.name AS producer_name, p.lastname AS producer_lastname, p.year_of_birth AS producer_year " +
                            "FROM movies AS mov " +
                            "LEFT JOIN movies_producers AS mp ON mov.id = mp.movies_id " +
                            "LEFT JOIN producers AS p ON p.id = mp.producers_id " +
                            "WHERE mov.id = ?")) {
                preparedStatement.setLong(1, name);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {

                        long producer_id = resultSet.getLong("producer_id");
                        String producer_name = resultSet.getString("producer_name");
                        String producer_lastname = resultSet.getString("producer_lastname");
                        int producer_year = resultSet.getInt("producer_year");
                        Producer producer = new Producer(producer_id, producer_name, producer_lastname, producer_year);
                        result.add(producer);
                    }
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return result;
    }

    /*public static List<String> movieNameByYear(int year) {
        List<String> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT name FROM movies WHERE year = ?")) {
                preparedStatement.setLong(1, year);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        Movie movie = new Movie(name);
                        result.add(name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }*/

    public static List<Movie> movieNameByYear(int year) {
        List<Movie> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM movies WHERE year = ?")) {
                preparedStatement.setInt(1, year);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        long id = resultSet.getLong("id");
                        String name = resultSet.getString("name");
                        String country = resultSet.getString("country");
                        String genre = resultSet.getString("genre");
                        Movie movie = new Movie(id, name, year, country, genre);
                        result.add(movie);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}