package com.example.lesson_30_08_21;

import com.example.lesson_30_08_21.dao.UserDao;
import com.example.lesson_30_08_21.entity.User;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        UserDao userDao = UserDao.getInstance();
        Optional<User> qwerty = userDao.findByEmailAndPassword("test@mail.ru", "qwey");
        System.out.println(qwerty);


    }
}
