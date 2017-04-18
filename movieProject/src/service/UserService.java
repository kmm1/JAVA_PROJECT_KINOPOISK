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
    public static void main(String[] args) {

        Optional<User> userOptional = UserDao.getInstance().saveUser(
                new User("k", "m", "k@gmail.com", "q"));
        if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
        }


    }
}