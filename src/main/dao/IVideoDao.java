package dao;

import pojo.Video;

import java.util.List;

public interface IVideoDao {
     List<Video> videolistimit6MAD();
     List<Video> videolist(String videocAtegory);
     int uploadVideo(Video video);
}
