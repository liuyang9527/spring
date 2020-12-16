package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = {"/UserExistServlet/", "/userexist"})
public class UserExistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取值
        String username = request.getParameter("username");
        //处理
        IUserService userService = (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res res = userService.userExist(username);
        //反馈
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String resJson = JSON.toJSONString(res);
        out.println(resJson);
        out.close();
    }
}
