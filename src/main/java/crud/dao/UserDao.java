package crud.dao;

import crud.model.User;

import java.util.List;


public interface UserDao {
    User getUserById(Long id);

    List<User> getAllUsers();

    void addUser(User user);

    User readUser(long id);

    void updateUser(User user);

    void removeUser(long id);
}
