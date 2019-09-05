package test;

import dao.impl.AdminDaoImpl;
import org.junit.Test;
import pojo.Admin;

import pojo.User;
import service.impl.AdminServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AdminTest {
    @Test
    public void testAutoAdd(){
        Admin a1=new Admin();
        Admin a2=new Admin();
        System.out.println(a1.getAdmin_id());
        System.out.println(a2.getAdmin_id());
    }

    @Test
    public void t1(){
        AdminDaoImpl adminDao=new AdminDaoImpl();
        System.out.println(adminDao.getAllAdmin().size());
    }

    @Test
    public void t2(){
        List<User> list=new ArrayList<>();
        System.out.println(list);
    }

    @Test
    public void t3(){
        AdminServiceImpl adminService=new AdminServiceImpl();
        System.out.println(adminService.getAllAdmin());
        System.out.println("admin"+adminService.getAllAdmin().size());
        System.out.println(adminService.getAllUser());
        System.out.println("user"+adminService.getAllUser().size());
        System.out.println(adminService.getAllVideo());
        System.out.println("video"+adminService.getAllVideo().size());
        System.out.println(adminService.getAllMessage());
        System.out.println("message"+adminService.getAllMessage().size());
    }

    @Test
    public void t4(){
        AdminDaoImpl adminDao=new AdminDaoImpl();
        System.out.println(adminDao.findByUserName("夸张的一"));
        System.out.println(adminDao.findByAdminName("admin"));
        System.out.println(adminDao.findByVideoID(1));
    }
}
