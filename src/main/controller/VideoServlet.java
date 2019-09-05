package controller;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Video;
import service.VideoService;
import service.impl.VideoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.regex.Pattern;


@WebServlet("*.do")
public class VideoServlet extends HttpServlet {
    VideoService videoService=new VideoServiceImpl();
    private static final String REGEX="(.*\\.(jpg|gif|bmp|bnp|png))";
    private static final long serialVersionUID = 1L;
    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 30;  // 30MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 80; // 80MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 100; // 100MB
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().contains("index")) {
            doShow(request, response);
        }
        if (request.getServletPath().contains("video")) {
            doVideo(request, response);
        }
        if (request.getServletPath().contains("tougao")) {
            dovideoFileTop(request, response);
        }
    }
    protected void dovideoFileTop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Video video=new Video();
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("UTF-8");
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = "D:\\WorkSpace\\team\\src\\main\\webapp\\static\\videolook";
        String uploadPathPic = "D:\\WorkSpace\\team\\src\\main\\webapp\\static\\videolook\\videolookimg";
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        File uploadPic=new File(uploadPathPic);
        if (!uploadDir.exists()||!uploadPic.exists()) {
            uploadDir.mkdir();
            uploadPic.mkdir();
        }
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        Pattern p=Pattern.compile(REGEX);
                        if (p.matcher(fileName).lookingAt()){
                            String filePath = uploadPathPic + File.separator + fileName;
                            File storeFile = new File(filePath);
                            String a="static/videolook/videolookimg"+fileName;
                            video.setVideoImage(a);////////////////////////////////
                            item.write(storeFile);
                            continue;
                        }
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        String a="static/videolook"+fileName;
                        video.setVideoAddress(a);/////////////////////////
                        item.write(storeFile);
                        Encoder encoder = new Encoder();
                        try {
                            it.sauronsoftware.jave.MultimediaInfo m = null;
                            try {
                                m = encoder.getInfo(storeFile);
                            } catch (EncoderException e) {
                                e.printStackTrace();
                            }
                            long ls = m.getDuration();
                            String length=ls/60000+":"+(ls)/10000;
                            video.setVideoTime(length);/////////////////////////////////
                            System.out.println("此视频时长为:" + ls / 60000 + "分" + (ls) / 10000 + "秒！");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                videoService.uploadVideo(video);
                request.setAttribute("message", "上传成功");
            }
        } catch (Exception ex) {
            request.setAttribute("message", "错误信息: " + ex.getMessage());
        }
       request.getRequestDispatcher("web-jsp/showUploadMess.jsp").forward(request,response);
    }
    protected void doVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dizhi=request.getParameter("dizhi");
        System.out.println(dizhi);
        request.getSession().setAttribute("dizhi1",dizhi);
        String shipingID=request.getParameter("shipingID");
        System.out.println(shipingID);
        request.getSession().setAttribute("shinpingID",shipingID);
        request.getRequestDispatcher("web-jsp/Video.jsp").forward(request,response);
    }
    protected void doShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 随机查6条数据出来
        List<Video> fuck = videoService.videolistimit6MAD();
        List<Video> list=videoService.videolist("1");
        request.getSession().setAttribute("list",list);
        List<Video> list2=videoService.videolist("2");
        request.getSession().setAttribute("list",list);
        List<Video> list3=videoService.videolist("3");
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("list2",list2);
        request.getSession().setAttribute("list3",list3);
        request.getSession().setAttribute("fuck",fuck);
        request.getRequestDispatcher("web-jsp/index.jsp").forward(request,response);
    }
}
