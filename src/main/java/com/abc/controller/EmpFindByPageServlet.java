package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpFindByPageServlet", urlPatterns = {"/empbypage"})
public class EmpFindByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        if (session.getAttribute(Comm.CURRENT_USER) == null){
//            session.setAttribute("errMsg","请您登录");
//            response.sendRedirect(request.getContextPath()+"/error.jsp");
//        }

        int page = 1;
        int size = 100;
        String pageParam = request.getParameter("page");
        String sizeParam = request.getParameter("size");
        if (pageParam != null && "".equals(sizeParam.trim())){
            page = Integer.parseInt(pageParam);
        }
        if (sizeParam != null && "".equals(sizeParam.trim())){
            size = Integer.parseInt(sizeParam);
        }

        //处理
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        List<Emp> emps = empService.findByPage(page,size);

        //反馈
        if (emps != null && emps.size()>0){
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else {
            session.setAttribute("errMsg","分页查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
