package com.example02.demo.dao;
//绑了Mybatis之后就用mapper

import com.example02.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao

//加上@Repository使被spring托管
@Repository
public class DepartmentDao {
    //初始化数据，模拟数据库中的数据

    //用map模拟一个库
    //integer是键
    private static Map<Integer,Department> departments=null;
    static {
        //赋初值
        departments =new HashMap<Integer, Department>();//创建一个部门表

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    //数据库的增删改查，写dao接口

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id得到部门
    public  Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
