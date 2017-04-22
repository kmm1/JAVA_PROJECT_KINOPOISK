package service;


import dao.ProducerDao;
import dao.UserDao;
import entity.Producer;
import entity.User;

import java.util.Optional;

public class ProducerService {

    private static final Object LOCK = new Object();
    private static ProducerService INSTANCE = null;

    public static ProducerService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ProducerService();
                }
            }
        }
        return INSTANCE;
    }


}
