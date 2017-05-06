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
public class ProducerDao {
    private static final Object LOCK = new Object();
    private static ProducerDao INSTANCE = null;

    public static ProducerDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ProducerDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<Producer> addProducer(Producer producer) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO producers (name, lastname, year_of_birth) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, producer.getName());
                preparedStatement.setString(2, producer.getLastname());
                preparedStatement.setInt(3, producer.getYearOfBirth());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    producer.setId(generatedKeys.getLong(1));
                    return Optional.of(producer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Producer> selectProducerByNameLastname(String name, String lastname) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM producers WHERE name = ? AND lastname = ?")) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastname);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Producer
                            (resultSet.getString("name"),
                                    resultSet.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Producer> getProducerById(long id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM producers WHERE id = ?")) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Producer
                            (id, resultSet.getString("name"), resultSet.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Producer> getProducerByLastname(String lastname) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM producers WHERE lastname = ?")) {
                preparedStatement.setString(1, lastname);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Producer
                            (resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("lastname")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Producer> findAllProducers() {
        List<Producer> producer = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM producers")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        producer.add(new Producer(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("lastname")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producer;
    }
}