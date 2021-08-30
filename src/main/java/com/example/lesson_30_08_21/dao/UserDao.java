package com.example.lesson_30_08_21.dao;

import com.example.lesson_30_08_21.entity.User;
import com.example.lesson_30_08_21.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User,Integer>{

    private static UserDao INSTANCE=null;
    private UserDao(){}
    public static UserDao getInstance() {
        if (INSTANCE==null){
            synchronized (UserDao.class){
                if (INSTANCE==null){
                    INSTANCE=new UserDao();
                }
            }
        }
        return INSTANCE;
    }


    private static final String FIND_ALL= """
    SELECT * FROM users
    """;

    private static final String FIND_BY_EMAIL_AND_PASSWORD= """
    SELECT * FROM users
    WHERE email=? AND
    password=?
    """;

    private static final String SAVE_USER= """
    INSERT INTO users (email, password, role) VALUES (?,?,0)
    """;
    private static final String UPDATE_USER= """
    UPDATE users 
    SET email=?,
    password=?
    WHERE id=?
    """;
    private static final String DELETE_USER= """
    DELETE FROM users WHERE id=?
    """;
    private static final String FIND_BY_ID= """
    SELECT * FROM users WHERE id=?
    """;

    @Override
    public boolean save(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1,user.getEmail());
            preparedStatement.setObject(2,user.getPassword());
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                user.setId(generatedKeys.getObject(1,Integer.class));
            }
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public boolean update(Integer id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setObject(1,String.class);
            preparedStatement.setObject(2,String.class);
            preparedStatement.setObject(3,id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            return false;
        }

    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setObject(1,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user=null;
            if (resultSet.next()){
                user=buildUser(resultSet);
            }
            return Optional.ofNullable(user);

        } catch (SQLException throwables) {
        }
        return Optional.empty();
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setObject(1,email);
            preparedStatement.setObject(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user=null;
            if (resultSet.next()){
                user=buildUser(resultSet);
            }
            return Optional.ofNullable(user);

        } catch (SQLException throwables) {
        }
        return Optional.empty();
    }


    @Override
    public List<User> findAll() {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users=new ArrayList<>();
            while (resultSet.next()){
                users.add(buildUser(resultSet));
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return Collections.emptyList();
        }
    }

    private User buildUser(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id",Integer.class))
                .email(resultSet.getObject("email",String.class))
                .password(resultSet.getObject("password",String.class))
                .role(resultSet.getObject("role",Integer.class))
                .build();


    }
}
