package dao.impl;

import dao.IUserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.User;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements IUserDao {
    QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());

    @Override
    public int saveUser(User user) {
        int result=0;
        String sql="insert into user(nickName,password,phone,email) values(?,?,?,?)";
        try {
            result=qr.update(sql,new Object[]{user.getNickName(),user.getPassword(),user.getPhone(),user.getEmail()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=new ArrayList<>();
        String sql="select * from user";
        try {
            users=qr.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public int modifyPassword(String name,String password) {
        int result=0;
        String sql="update user set passWord=? where nickName=?";
        try {
            result=qr.update(sql,new Object[]{password,name});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User showUserInfo(String name) {
        User user = new User();
        String sql="select * from user where nickName=?";
        try {
            user=qr.query(sql,new BeanHandler<User>(User.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int insert_user_info(User user) {
        String sql="update user set name=?,sex=?,birthTime=?,address=?,QQ=? where nickName=?";
        int result=0;
        try {
            result=qr.update(sql,new Object[]{user.getName(),user.getSex(),user.getBirthTime(),user.getAddress(),user.getQQ(),user.getNickName()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
