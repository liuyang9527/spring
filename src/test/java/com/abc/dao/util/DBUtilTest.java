package com.abc.dao.util;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * ctrl shift t
 */
public class DBUtilTest {

    @Test
    public void getConnection() throws Exception {
        Connection con = DBUtil.getConnection();
        System.out.println("******\n"+DBUtil.getDs()+"\n"+con+"\n******");
        Connection con1 = DBUtil.getConnection();
        System.out.println("******\n"+DBUtil.getDs()+"\n"+con1+"\n******");
        Connection con2 = DBUtil.getConnection();
        System.out.println("******\n"+DBUtil.getDs()+"\n"+con2+"\n******");
    }
}