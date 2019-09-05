package service;

import pojo.Video;

import java.util.List;

public interface VideoService {
     List<Video> videolistimit6MAD();
    List<Video> videolist(String videocAtegory);
    int uploadVideo(Video video);
}
