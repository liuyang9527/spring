package com.abc.demo;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * 存储过程
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Connection con = DBUtil.getConnection();
        CallableStatement cs = con.prepareCall("CALL proc_transfer_money(?,?,?)");
        cs.setString(1,"zhang");
        cs.setString(2,"zhu");
        cs.setBigDecimal(3,new BigDecimal("1000"));
        cs.executeUpdate();
        DBUtil.close(null,cs,con);
    }
}
