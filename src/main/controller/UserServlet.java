package controller;

import dao.impl.UserDaoImpl;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.do2")
public class UserServlet extends HttpServlet {
    User user;
    UserDaoImpl userDaoImpl =new UserDaoImpl();
    //boolean flag=false;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        if (path.contains("register")){
            doRegister(request,response);
        }
/*        if (path.contains("login")){
            String message="账号或密码错误！";

            doLogin(request,response);
            if (flag){
                request.getSession().removeAttribute("mes");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                //response.sendRedirect("index.jsp");
            }else {
                request.getSession().setAttribute("mes",message);
                request.getRequestDispatcher("login.jsp").forward(request,response);
                //response.sendRedirect("login.jsp");
            }
        }*/
        if (path.contains("showUserInfo")){
            doShowUserInfo(request,response);
            request.getRequestDispatcher("web-jsp/showUserInfo.jsp").forward(request,response);
        }
        if (path.contains("insert_user_info")){
            doInsertUserInfo(request,response);
            request.getRequestDispatcher("web-jsp/index.jsp").forward(request,response);
        }
        if (path.contains("modifyPassword")){
            doModifyPassword(request,response);
        }
        if (path.contains("exitLogin")){
            request.getSession().invalidate();
            request.getRequestDispatcher("web-jsp/index.jsp").forward(request,response);
        }
    }

    protected void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String register_mes="该用户名已被使用";
        String phone=request.getParameter("userPhone");
        String email=request.getParameter("userEmail");
        String password=request.getParameter("passWord");
        String name=request.getParameter("userNickName");
        user=new User(name,password,phone,email);
        List<User> users= userDaoImpl.getAllUsers();
        List<String> names=new ArrayList<>();
        for (User user:users){
            names.add(user.getNickName());
        }
        if (names.contains(name)){
            request.getSession().setAttribute("register_mes",register_mes);
            request.getRequestDispatcher("web-jsp/register.jsp").forward(request,response);
        }else {
            if (userDaoImpl.saveUser(user)>0){
                request.getRequestDispatcher("web-jsp/index.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("web-jsp/register.jsp").forward(request,response);
            }
        }
    }

    /*protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("login_userName");
        request.getSession().setAttribute("userName",name);
        String password = request.getParameter("login_passWord");
        List<User> users = userDaoImpl.getAllUsers();
        for (User user : users) {
            if (user.getNickName().equals(name) && user.getPassword().equals(password)) {
                flag = true;
                break;
            }
        }
    }*/
    protected void doModifyPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=((User)request.getSession().getAttribute("user")).getName();
        String mes="";
        String password1=request.getParameter("modifyPassword1");
        String password2=request.getParameter("modifyPassword2");
        if(password1.equals(password2)){
           userDaoImpl.modifyPassword(name,password1);
            request.getRequestDispatcher("web-jsp/index.jsp").forward(request,response);
        }else {
            mes="两次密码不相同！";
            request.getSession().setAttribute("modify_mes",mes);
            request.getRequestDispatcher("web-jsp/modifyPassword.jsp").forward(request,response);
        }
    }

    protected void doShowUserInfo(HttpServletRequest request, HttpServletResponse response){
        String name=((User)request.getSession().getAttribute("user")).getName();
        user= userDaoImpl.showUserInfo(name);
        request.getSession().setAttribute("userInfo",user);
    }

    protected void doInsertUserInfo(HttpServletRequest request, HttpServletResponse response){
        String nickName=((User)request.getSession().getAttribute("user")).getName();
        String name=request.getParameter("newName");
        String sex=request.getParameter("sex");
        String QQ=request.getParameter("newQQ");
        String address=request.getParameter("newAddress");
        String birthTime=request.getParameter("newDate");
        user=new User(nickName,name,sex,birthTime,address,QQ);
        userDaoImpl.insert_user_info(user);
    }
}
