package dao;

import connection.ConnectionManager;
import entity.Movie;
import entity.Review;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by icons on 9.4.17.
 */
public class ReviewDao {
    private static final Object LOCK = new Object();
    private static ReviewDao INSTANCE = null;

    public static ReviewDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewDao();
                }
            }
        }
        return INSTANCE;
    }

    public void saveReview(Review review) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO reviews (text, users_id, movies_id) VALUES (?, ?, ?);")) {
                preparedStatement.setString(1, review.getText());
                preparedStatement.setLong(2, review.getUser().getId());
                preparedStatement.setLong(3, review.getMovie().getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Review> getReviewByMovieId(Long movieIdToFind) {
        List<Review> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT reviews.id AS reviews_id, text, u.name, u.lastname, m.name " +
                            "FROM reviews " +
                            "LEFT JOIN movies AS m ON m.id = reviews.movies_id " +
                            "LEFT JOIN users AS u ON u.id = reviews.users_id " +
                            "WHERE m.id   = ?")) {
                preparedStatement.setLong(1, movieIdToFind);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        long id = resultSet.getLong("reviews_id");
                        String text = resultSet.getString("text");
                        String MovName = resultSet.getString("m.name");
                        String UserName = resultSet.getString("u.name");
                        String UserLastname = resultSet.getString("u.lastname");
                        Movie movie = new Movie(MovName);
                        User user = new User(id, UserName, UserLastname);
                        Review review = new Review(id, text, user, movie);
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

