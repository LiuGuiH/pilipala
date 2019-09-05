package service.impl;

import dao.IAdminDao;
import factory.Factory;
import pojo.Admin;
import pojo.Message;
import pojo.User;
import pojo.Video;
import service.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    IAdminDao adminDao;

    public AdminServiceImpl() {
        adminDao = Factory.getInstance("adminDao", IAdminDao.class);
    }

    @Override
    public int addUser(User user) {
        return adminDao.addUser(user);
    }

    @Override
    public int deleteUser(int userID) {
        return adminDao.deleteUser(userID);
    }

    @Override
    public int updateUser(User user) {
        return adminDao.updateUser(user);
    }

    @Override
    public User findByUserID(int userID) {
        return adminDao.findByUserID(userID);
    }

    @Override
    public User findByUserName(String userName) {
        return adminDao.findByUserName(userName);
    }

    @Override
    public List<User> getAllUser() {
        return adminDao.getAllUser();
    }

    @Override
    public int addVideo(Video video) {
        return adminDao.addVideo(video);
    }

    @Override
    public int deleteVideo(int videoID) {
        return adminDao.deleteVideo(videoID);
    }

    @Override
    public int updateVideo(Video video) {
        return adminDao.updateVideo(video);
    }

    @Override
    public Video findByVideoID(int videoID) {
        return adminDao.findByVideoID(videoID);
    }

    @Override
    public Video findByVideoName(String videoName) {
        return adminDao.findByVideoName(videoName);
    }

    @Override
    public List<Video> getAllVideo() {
        return adminDao.getAllVideo();
    }

    @Override
    public int addMessage(Message message) {
        return adminDao.addMessage(message);
    }

    @Override
    public int deleteMessage(int messageID) {
        return adminDao.deleteMessage(messageID);
    }

    @Override
    public int updateMessage(Message message) {
        return adminDao.updateMessage(message);
    }

    @Override
    public List<Message> getAllMessage() {
        return adminDao.getAllMessage();
    }

    @Override
    public Admin getAdmin(String admin_name, String admin_password) {
        return adminDao.getAdmin(admin_name, admin_password);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int deleteAdmin(int admin_id) {
        return adminDao.deleteAdmin(admin_id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Admin findByAdminName(String admin_name) {
        return adminDao.findByAdminName(admin_name);
    }

    @Override
    public Admin findByAdminId(int admin_id) {
        return adminDao.findByAdminId(admin_id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }
}
