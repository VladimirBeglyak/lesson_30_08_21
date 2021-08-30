package com.example.lesson_30_08_21.exception;

public class UserNotExist extends Throwable {
    public UserNotExist(String user_not_found) {
        System.out.println(user_not_found);
    }
}
