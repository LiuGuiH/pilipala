package controller;

import factory.Factory;
import pojo.Admin;
import pojo.User;
import pojo.Video;
import service.IAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.edit")
public class EditServlet extends HttpServlet {
    IAdminService adminService;

    public EditServlet() {
        adminService = Factory.getInstance("adminService", IAdminService.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if (servletPath.contains("editAdmin")) {
            doEditAdmin(request, response);
        } else if (servletPath.contains("editUser")) {
            doEditUser(request, response);
        } else if (servletPath.contains("editVideo")) {
            doEditVideo(request, response);
        }
    }

    protected void doEditVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("editID")!=null) {
            int editId = Integer.parseInt(request.getParameter("editId"));
            Video video = adminService.findByVideoID(editId);
            System.out.println(video);
            request.getSession().setAttribute("videoId", editId);
            request.getSession().setAttribute("videoName", video.getVideoName());
            request.getRequestDispatcher("web-jsp/videoFileTop.jsp").forward(request, response);
        }
        if ("add".equals(request.getParameter("op"))){
            request.getRequestDispatcher("web-jsp/videoFileTop.jsp").forward(request,response);
        }
    }

    protected void doEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("editId")!=null) {
            int editId = Integer.parseInt(request.getParameter("editId"));
            User user = adminService.findByUserID(editId);
            System.out.println(user);
            request.getSession().setAttribute("userID", editId);
            request.getSession().setAttribute("userName", user.getName());
            request.getRequestDispatcher("manager/user-edit.jsp").forward(request, response);
        }
        if ("add".equals(request.getParameter("op"))) {
            request.getRequestDispatcher("web-jsp/register.jsp").forward(request,response);
        }

    }

    protected void doEditAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("editId")!=null){
            int editId = Integer.parseInt(request.getParameter("editId"));
            Admin admin = adminService.findByAdminId(editId);
            System.out.println(admin);
            request.getSession().setAttribute("admin_id1", editId);
            request.getSession().setAttribute("admin_name1", admin.getAdmin_name());
            request.getRequestDispatcher("manager/admin-edit.jsp").forward(request, response);
        }
        if ("add".equals(request.getParameter("op"))){
            request.getRequestDispatcher("manager/admin-add.jsp").forward(request, response);
        }
    }
}
