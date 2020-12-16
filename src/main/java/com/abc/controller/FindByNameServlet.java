package com.abc.controller;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindByNameServlet",urlPatterns = {"/FindByNameServlet","/findbyname"})
public class FindByNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        List<Emp> emps = empService.findByName(ename);
        if (emps != null && emps.size()>0){
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","模糊查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}