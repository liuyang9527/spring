package com.abc.dao.impl;

import com.abc.common.Comm;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements IEmpDao {
    @Override
    public List<Emp> findByPage(int start, int size) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno, ename, hiredate, sal from emp limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,start);
        ps.setInt(2,size);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public List<Emp> findByName(String name) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno, ename, hiredate, sal from emp where ename like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"%" + name + "%");
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno, ename, hiredate, sal from emp where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Emp emp = null;
        if (rs.next()){
            emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
        }
        DBUtil.close(rs,ps,con);
        return emp;
    }

    @Override
    public String delete(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "delete from emp where empno = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        int rs = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        if (rs > 0){
            return Comm.SUCCESS;
        }else {
            return Comm.ERROR;
        }
    }

    @Override
    public String save(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "insert into emp(ename,hiredate,sal) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        int rs = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        if (rs > 0){
            return Comm.SUCCESS;
        }else {
            return Comm.ERROR;
        }
    }

    @Override
    public String update(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.setInt(4,emp.getEmpno());
        int rs = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        if (rs > 0){
            return Comm.SUCCESS;
        }else {
            return Comm.ERROR;
        }
    }

    @Override
    public List<Emp> findByDept(int deptno) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno,ename,hiredate,sal from emp where deptno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,deptno);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public void delBatch(List<DelVO> delVOList) throws Exception {
        Connection con = DBUtil.getConnection();
        StringBuffer buffer = new StringBuffer("delete from emp where empno in (");
        for (int i = 0; i < delVOList.size(); i++){
            if (i == delVOList.size() - 1){
                buffer.append(delVOList.get(i).getEmpno() + ")");
            }else {
                buffer.append(delVOList.get(i).getEmpno() + ",");
            }
        }
        String sql = buffer.toString();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

}
