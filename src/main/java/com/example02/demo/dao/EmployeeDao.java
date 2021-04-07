package com.example02.demo.dao;

import com.example02.demo.pojo.Department;
import com.example02.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees=null;

    //员工所属的部门--外表
    @Autowired
    private DepartmentDao departmentDao;
    static {
        //赋初值
        employees =new HashMap<Integer, Employee>();//创建一个部门表

        employees.put(101,new Employee(1001,"aa","2205601179@qq.com",1,new Department(101,"教学部"),new Date()));
        employees.put(102,new Employee(1002,"bb", "2205601169@qq.com",0,new Department(102,"市场部"),new Date()));
        employees.put(103,new Employee(1003,"cc", "2205601159@qq.com",1,new Department(103,"教研部"),new Date()));
        employees.put(104,new Employee(1004,"dd", "2205601149@qq.com",0,new Department(104,"运营部"),new Date()));
        employees.put(105,new Employee(1005,"ee", "2205601139@qq.com",1,new Department(105,"后勤部"),new Date()));
    }


    //正常的应该有mapper对应的sql
    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId())); // 设置部门

        //员工id有了，员工信息有了，增加员工就搞定了
        employees.put(employee.getId(),employee);// 放入 Map (数据库)
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
