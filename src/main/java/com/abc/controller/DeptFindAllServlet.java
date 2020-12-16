package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.Dept;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IDeptService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/deptall"})
public class DeptFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDeptService deptService = (IDeptService) ServiceFactory.getInstance(Comm.DEPT);
        Res<List<Dept>> res = deptService.findAll();
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(res));
        out.close();
    }
}
