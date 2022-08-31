package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    public void createTable();

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void removeUser(long id);
}