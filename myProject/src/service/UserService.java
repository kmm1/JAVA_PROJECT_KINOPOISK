package service;


import dao.MovieDao;
import dao.UserDao;
import entity.Movie;
import entity.User;

import java.util.Optional;

/**
 * Created by icons on 10.4.17.
 */


public class UserService {

    private static final Object LOCK = new Object();
    private static UserService INSTANCE = null;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }


    public String user(long userId) {
        Optional<User> user = UserDao.getInstance().getUserById(userId);
        if (user.isPresent()) {
            return user.get().getName();
        }
        return null;

    }


}
