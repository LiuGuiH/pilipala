package controller;

import factory.Factory;
import pojo.Admin;
import service.IAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.action")
public class AdminServlet extends HttpServlet {
    IAdminService adminService;

    public AdminServlet() {
        adminService = Factory.getInstance("adminService", IAdminService.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if (servletPath.contains("addAdmin")) {
            doAddAdmin(request, response);
        } else if (servletPath.contains("deleteAdmin")) {
            doDeleteAdmin(request, response);
        } else if (servletPath.contains("updateAdmin")) {
            doUpdateAdmin(request, response);
        } else if (servletPath.contains("addUser")) {
            doAddUser(request, response);
        } else if (servletPath.contains("deleteUser")) {
            doDeleteUser(request, response);
        } else if (servletPath.contains("updateUser")) {
            doUpdateUser(request, response);
        } else if (servletPath.contains("addVideo")) {
            doAddVideo(request, response);
        } else if (servletPath.contains("updateVideo")) {
            doUpdateVideo(request, response);
        } else if (servletPath.contains("deleteVideo")) {
            doDeleteVideo(request, response);
        } else if (servletPath.contains("deleteMessage")) {
            doDeleteMessage(request, response);
        }
    }

    protected void doDeleteMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doDeleteVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doUpdateVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doAddVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID=Integer.parseInt(request.getParameter("userID"));
        adminService.deleteUser(userID);
        LoginServlet.ListAll(request,adminService);
        request.getRequestDispatcher("manager/user-list.jsp").forward(request,response);
    }

    protected void doAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doUpdateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int admin_id = Integer.parseInt(request.getSession().getAttribute("admin_id1").toString());
        Admin admin = adminService.findByAdminId(admin_id);
        admin.setAdmin_name(request.getParameter("admin_name2"));
        admin.setAdmin_password(request.getParameter("admin_password1"));
        admin.setAdmin_id(admin_id);
        adminService.updateAdmin(admin);
        LoginServlet.ListAll(request, adminService);
        request.getRequestDispatcher("manager/admin-list.jsp").forward(request, response);
    }

    protected void doAddAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admin_name = request.getParameter("admin_name1");
        String admin_password = request.getParameter("admin_password");
        Admin admin = new Admin();
        admin.setAdmin_name(admin_name);
        admin.setAdmin_password(admin_password);
        adminService.addAdmin(admin);
        LoginServlet.ListAll(request, adminService);
        request.getRequestDispatcher("manager/admin-list.jsp").forward(request, response);
    }

    protected void doDeleteAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("admin_id"));
        adminService.deleteAdmin(id);
        LoginServlet.ListAll(request, adminService);
        request.getRequestDispatcher("manager/admin-list.jsp").forward(request, response);
    }
}
