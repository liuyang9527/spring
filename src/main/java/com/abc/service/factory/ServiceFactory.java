package com.abc.service.factory;

import com.abc.common.Comm;
import com.abc.dao.impl.DeptEmpServiceImpl;
import com.abc.service.impl.DeptServiceImpl;
import com.abc.service.impl.EmpServiceImpl;
import com.abc.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static Object getInstance(String serviceName){
        switch ((serviceName)){
            case Comm.USER:
                return new UserServiceImpl();
            case Comm.EMP:
                return new EmpServiceImpl();
            case Comm.DEPT:
                return new DeptServiceImpl();
            case Comm.DEPT_EMP_REPORT:
                return new DeptEmpServiceImpl();
            default:
                return null;
        }
    }
}
