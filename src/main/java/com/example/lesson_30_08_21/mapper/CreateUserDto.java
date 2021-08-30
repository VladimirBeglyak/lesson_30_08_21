package com.example.lesson_30_08_21.mapper;

import com.example.lesson_30_08_21.dao.UserDao;
import com.example.lesson_30_08_21.dto.UserDto;
import com.example.lesson_30_08_21.entity.User;

public class CreateUserDto implements Mapper<User,UserDto>{

    private static CreateUserDto INSTANCE=null;
    private CreateUserDto(){}

    public static CreateUserDto getInstance() {
        if (INSTANCE==null){
            synchronized (CreateUserDto.class){
                if (INSTANCE==null){
                    INSTANCE=new CreateUserDto();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public UserDto mapFrom(User object) {
        return new UserDto(object.getEmail(),object.getPassword());
    }
}
