package service.impl;

import dao.IVideoDao;
import dao.impl.VideoDaoImpl;
import pojo.Video;
import service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
IVideoDao iVideoDao=new VideoDaoImpl();
    @Override
    public List<Video> videolistimit6MAD() {
        return iVideoDao.videolistimit6MAD();
    }

    @Override
    public List<Video> videolist(String videocAtegory) {
        return iVideoDao.videolist(videocAtegory);
    }

    @Override
    public int uploadVideo(Video video) {
        return iVideoDao.uploadVideo(video);
    }
}
