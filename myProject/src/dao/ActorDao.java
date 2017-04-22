package dao;

import connection.ConnectionManager;
import entity.*;

import java.sql.*;
import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class ActorDao {


    private static final Object LOCK = new Object();
    private static ActorDao INSTANCE = null;

    public static ActorDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ActorDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Actor> addActor(Actor actor) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO actors (name, lastname, year_of_birth) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, actor.getName());
                preparedStatement.setString(2, actor.getLastname());
                preparedStatement.setInt(3, actor.getYearOfBirth());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    actor.setId(generatedKeys.getLong(1));
                    return Optional.of(actor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Actor> selectActorByNameLastname(String name, String lastname) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM actors WHERE name = ? AND lastname = ?")) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastname);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Actor
                            (resultSet.getString("name"),
                                    resultSet.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Actor> getActorById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM actors WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Actor
                            (id, resultSet.getString("name"), resultSet.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Actor> getActorByLastname(String lastname) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM actors WHERE lastname = ?")) {
                preparedStatement.setString(1, lastname);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Actor
                            (resultSet.getLong("id"), resultSet.getString("name"),
                                    resultSet.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}