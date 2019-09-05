package dao.impl;

import dao.MessageDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Message;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaolml implements MessageDao {
    QueryRunner qr;
    public MessageDaolml(){
        qr=new QueryRunner(C3P0Util.getDataSource());
    }



    @Override
    public List<Message> messageByVideo(int messageVideoID) {
        List<Message> list=new ArrayList<>();
        String sql="select * from message where messagevideoID=?";
        try {
            list=qr.query(sql,new BeanListHandler<Message>(Message.class),new Object[]{messageVideoID});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addMessage(int messageVideoID,int messageuserID,String messageuserName,String message) {
        String sql="insert into message(messagevideoID,messageuserID,messageuserName,message) values(?,?,?,?)";
        try {
            qr.insert(sql,new BeanListHandler<Message>(Message.class),new Object[]{messageVideoID,messageuserID,messageuserName,message});
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
