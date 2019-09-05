package service;

import pojo.Admin;
import pojo.Message;
import pojo.User;
import pojo.Video;

import java.util.List;

public interface IAdminService {
    //管理员对普通用户的操作
    int addUser(User user);

    int deleteUser(int userID);

    int updateUser(User user);

    User findByUserID(int userID);

    User findByUserName(String userName);

    List<User> getAllUser();

    //管理员对视频文件的操作
    int addVideo(Video video);

    int deleteVideo(int videoID);

    int updateVideo(Video video);

    Video findByVideoID(int videoID);

    Video findByVideoName(String videoName);

    List<Video> getAllVideo();

    //管理员对评论的操作
    int addMessage(Message message);

    int deleteMessage(int messageID);

    int updateMessage(Message message);

    List<Message> getAllMessage();

    //验证管理员登录
    Admin getAdmin(String admin_name, String admin_password);

    int addAdmin(Admin admin);

    int deleteAdmin(int admin_id);

    int updateAdmin(Admin admin);

    Admin findByAdminName(String admin_name);

    Admin findByAdminId(int admin_id);

    List<Admin> getAllAdmin();

}
