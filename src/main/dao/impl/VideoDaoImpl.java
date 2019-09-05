package dao.impl;

import dao.IVideoDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Video;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDaoImpl implements IVideoDao {
    QueryRunner qr;

    public VideoDaoImpl() {
        qr=new QueryRunner(C3P0Util.getDataSource());
    }
    @Override
    public List<Video> videolistimit6MAD() {
        String sql="select * from video order by rand() limit 6";
        List<Video> list=new ArrayList<Video>();
        try {
            list=qr.query(sql,new BeanListHandler<Video>(Video.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Video> videolist(String videocAtegory) {
        //将全部视频查询出来
        String sql="select * from video where videocAtegory=? order by rand() limit 8";//将视频标记为1的正常视频全部查询出
        List<Video> list=new ArrayList<>();
        try {
            list= qr.query(sql,new BeanListHandler<Video>(Video.class),videocAtegory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int uploadVideo(Video video) {
        String sql="insert into video(videoImage,videoAddress,videoTime,videoState,videocAtegory) values (?,?,?,?,?)";
        int a=0;
        try {
            a=qr.update(sql,new Object[]{video.getVideoImage(),video.getVideoAddress(),video.getVideoTime(),1,1});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
