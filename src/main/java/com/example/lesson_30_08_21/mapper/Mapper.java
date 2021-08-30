package com.example.lesson_30_08_21.mapper;

public interface Mapper <F,T>{
    T mapFrom(F object);
}
