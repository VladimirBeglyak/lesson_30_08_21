package com.example.lesson_30_08_21.service;

import com.example.lesson_30_08_21.dao.UserDao;
import com.example.lesson_30_08_21.dto.UserDto;
import com.example.lesson_30_08_21.entity.User;
import com.example.lesson_30_08_21.exception.UserNotExist;
import com.example.lesson_30_08_21.mapper.CreateUserDto;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class UserService {

    private static UserService INSTANCE=null;
    private UserService(){}

    public static UserService getInstance() {
        if (INSTANCE==null){
            synchronized (UserService.class){
                if (INSTANCE==null){
                    INSTANCE=new UserService();
                }
            }
        }
        return INSTANCE;
    }

    private final UserDao userDao=UserDao.getInstance();

    private final CreateUserDto createUserDto=CreateUserDto.getInstance();

    public List<UserDto> findAll(){
        return userDao.findAll().stream()
                .map(user -> createUserDto.mapFrom(user))
                .collect(toList());
    }

    public User login(String email,String password){
            return userDao.findByEmailAndPassword(email, password).orElse(null);
    }

    public User findById(Integer id){
        return userDao.findById(id).orElse(null);

    }
}