package dao;

import entity.Movie;
import entity.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by icons on 11.4.17.
 */
public class JDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/movie_base";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //1
        //  printReviewById(1L);
        //2
        //Review reviewFromDatabase = getRewiewById(1L);
        //System.out.println(reviewFromDatabase);
        //3
        //List<Review> reviews = getReviewsByMovieId(1L);
        //reviews.stream().forEach(System.out::println);

    }

    //1
    private static void printReviewById(long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT text, name " +
                            "FROM reviews " +
                            "LEFT JOIN movies ON movies.id = reviews.movies_id " +
                            "WHERE reviews.id = ?")) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Фильм: " + resultSet.getString("name"));
                        System.out.println("Отзыв: " + resultSet.getString("text"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //2
    private static Review getRewiewById(long reviewId) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT reviews.id, name, text " +
                            "FROM reviews " +
                            "LEFT JOIN movies ON movies.id = reviews.movies_id " +
                            "WHERE reviews.id = ?")) {
                preparedStatement.setLong(1, reviewId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        long id = resultSet.getLong("reviews.id");
                        String text = resultSet.getString("text");
                        String moviesName = resultSet.getString("name");
                        Movie movie = new Movie(moviesName);
                        return new Review(id, text, movie);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //3
    private static List<Review> getReviewsByMovieId(long movieIdToFind) {
        List<Review> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT reviews.id AS reviews_id, text, name, movies.id AS movies_id " +
                            "FROM reviews " +
                            "LEFT JOIN movies ON movies.id = reviews.movies_id " +
                            "WHERE movies.id  = ?")) {
                preparedStatement.setLong(1, movieIdToFind);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        long id = resultSet.getLong("reviews_id");
                        String text = resultSet.getString("text");
                        String name = resultSet.getString("name");
                        long movieId = resultSet.getLong("movies_id");
                        Movie movie = new Movie(movieId, name);
                        Review review = new Review(id, text, movie);
                        result.add(review);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}



