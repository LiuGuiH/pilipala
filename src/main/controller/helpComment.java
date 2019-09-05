package controller;

import dao.impl.MessageDaolml;
import pojo.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("*.do1")
public class helpComment extends HttpServlet {
    MessageDaolml messageDaolml=new MessageDaolml();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int messageVideoID=2;
        int messageuserID=1;
        String messageuserName="lz";
        String servletPath=request.getServletPath();
        if (servletPath.contains("view")) {
            MessageByVideoID(request, response,messageVideoID);
            response.sendRedirect("comment.jsp");
        }
        if (servletPath.contains("helpComment")){
          String message=request.getParameter("message");
          Submit(request,response,messageVideoID,messageuserID,messageuserName,message);
          MessageByVideoID(request, response,messageVideoID);
          request.getRequestDispatcher("comment.jsp").forward(request,response);
        }
    }


    protected void MessageByVideoID(HttpServletRequest request, HttpServletResponse response,int id) throws ServletException, IOException {
      List<Message> list=messageDaolml.messageByVideo(id);
        request.setAttribute("list",list);
    }
    protected  void  Submit(HttpServletRequest request,HttpServletResponse response,int messageVideoID,int messageuserID,String messageuserName,String message) throws  ServletException,IOException{
        messageDaolml.addMessage(messageVideoID,messageuserID,messageuserName,message);
    }
}
