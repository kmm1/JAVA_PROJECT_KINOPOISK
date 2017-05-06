package service;


import dao.ActorDao;
import dao.ProducerDao;
import dao.UserDao;
import entity.Actor;
import entity.Producer;
import entity.User;

import java.util.List;
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

    public List<Producer> getAllProducers() {
        return ProducerDao.getInstance().findAllProducers();
    }

}
