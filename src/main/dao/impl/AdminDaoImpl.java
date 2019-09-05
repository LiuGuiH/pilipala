package dao.impl;

import dao.IAdminDao;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Admin;
import pojo.Message;
import pojo.User;
import pojo.Video;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminDaoImpl implements IAdminDao {
    QueryRunner qr;

    public AdminDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDataSource());
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int userID) {
        int result=0;
        try {
            result=qr.update("delete from user where ID=?",userID);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public User findByUserID(int userID) {
        User user;
        try {
            user=qr.query("select * from user where ID=?",new BeanHandler<>(User.class),userID);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        User user;
        try {
            user=qr.query("select * from user where nickName=?",new BeanHandler<>(User.class),userName);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<User> getAllUser() {
        String sql="select * from user order by ID asc ";
        try {
            return qr.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addVideo(Video video) {
        return 0;
    }

    @Override
    public int deleteVideo(int videoID) {
        int result=0;
        try {
            result=qr.update("delete from video where videoID=?",videoID);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public int updateVideo(Video video) {
        return 0;
    }

    @Override
    public Video findByVideoID(int videoID) {
        Video video=null;
        try {
            video=qr.query("select * from video where videoID=?",new BeanHandler<>(Video.class),videoID);
            return video;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return video;
    }

    @Override
    public Video findByVideoName(String videoName) {
        Video video;
        try {
            video=qr.query("select * from video where videoName=?",new BeanHandler<>(Video.class),videoName);
            return video;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Video> getAllVideo() {
        String sql="select * from video order by videoID asc ";
        try {
            return qr.query(sql,new BeanListHandler<>(Video.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public int addMessage(Message message) {
        return 0;
    }

    @Override
    public int deleteMessage(int messageID) {
        int result=0;
        try {
            result=qr.update("delete from message where messageID=?",messageID);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public int updateMessage(Message message) {
        return 0;
    }

    @Override
    public List<Message> getAllMessage() {
        String sql="select * from message order by messageID asc";
        try {
            return qr.query(sql,new BeanListHandler<>(Message.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Admin getAdmin(String admin_name, String admin_password) {
        String sql = "select * from admin where admin_name=? and admin_password=? ";
        Object[] params = {admin_name, admin_password};
        try {
            Admin admin = qr.query(sql, new BeanHandler<>(Admin.class), params);
            if (admin != null) {
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addAdmin(Admin admin) {
        String sql="insert into admin(admin_name,admin_password) values(?,?)";
        Object[] params={admin.getAdmin_name(),admin.getAdmin_password()};
        int result=0;
        try {
            result=qr.update(sql,params);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteAdmin(int admin_id) {
        String sql="delete from admin where admin_id=? ";
        int result=0;
        try {
            result=qr.update(sql,new Object[]{admin_id});
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateAdmin(Admin admin) {
        int result=0;
        Object[] params={admin.getAdmin_name(),admin.getAdmin_password(),admin.getAdmin_id()};
        try {
            result=qr.update("update admin set admin_name=?,admin_password=? where admin_id=?",params);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Admin findByAdminId(int admin_id) {
        Admin admin;
        try {
            admin=qr.query("select * from admin where admin_id=?",new BeanHandler<>(Admin.class),admin_id);
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Admin findByAdminName(String admin_name) {
        Admin admin;
        try {
            admin=qr.query("select * from admin where admin_name=?",new BeanHandler<>(Admin.class),admin_name);
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmin() {
        String sql="select * from admin order by admin_id asc ";
        List<Admin> list=new ArrayList<>();
        try {
            list=qr.query(sql,new BeanListHandler<>(Admin.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }
}
