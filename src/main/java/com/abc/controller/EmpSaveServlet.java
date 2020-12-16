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
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

@WebServlet(urlPatterns = {"/EmpSaveServlet","/empsave"})
public class EmpSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ename = request.getParameter("ename");
//        System.out.println(ename);
        Date hiredate = null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BigDecimal sal = new BigDecimal(request.getParameter("sal"));

        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp = new Emp(ename,hiredate,sal);
        String msg = empService.save(emp);

        if (Comm.SUCCESS.equals(msg)){
            response.sendRedirect(request.getContextPath()+"/empbypage");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","添加失败");
            response.sendRedirect(request.getContextPath()+"/empbypage");
        }
    }
}