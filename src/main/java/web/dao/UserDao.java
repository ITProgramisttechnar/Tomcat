package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    User save (User user);
    List<User> getAllUsers();
    User getUserById(int id);
    void deleteUser(int id);
    User update(int id, User updatedUser);
}
