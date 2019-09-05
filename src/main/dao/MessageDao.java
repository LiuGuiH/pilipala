package dao;

import pojo.Message;

import java.util.List;

public interface MessageDao {
    List<Message> messageByVideo(int messageVideoID);
    void addMessage(int messageVideoID, int messageuserID, String messageuserName, String message);
}
