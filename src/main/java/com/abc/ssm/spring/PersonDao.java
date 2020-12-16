package com.abc.ssm.spring;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    public void print(){
        System.out.println("hello world");
    }
}
