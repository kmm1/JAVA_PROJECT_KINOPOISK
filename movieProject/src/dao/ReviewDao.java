package dao;

import connection.ConnectionManager;
import entity.Review;

import java.sql.*;

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
}
