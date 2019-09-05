package dao;

import pojo.User;

import java.util.List;

public interface IUserDao {
    int saveUser(User user);
    List<User> getAllUsers();
    int modifyPassword(String name, String password);
    User showUserInfo(String name);
    int insert_user_info(User user);
}
