package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.Dept;
import com.abc.dao.entity.Emp;

import java.util.List;

public interface IDeptService {
    Res<List<Dept>> findAll();
}
