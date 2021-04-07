package com.example02.demo.controller;

import com.example02.demo.dao.DepartmentDao;
import com.example02.demo.dao.EmployeeDao;
import com.example02.demo.pojo.Department;
import com.example02.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

//    查询所有员工
//     2，用model把获取的所有员工返回给前端
    @RequestMapping("/emps")//    请求写好了加一个@RequestMapping
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();//       1， 获取所有的员工
        model.addAttribute("emps",employees);//       3，所有的员工放在emps里面返回给前端
        return "emp/tables";//        4，到emp下的tables页面
    }

    // 跳转到员工添加界面
    @GetMapping("/emp")
    public String toAddPage(Model model){//    用model来传递参数
//      因为添加页面的department是一个下拉框,所以在跳转到add.html页面时，要查出所有department的数据
        Collection<Department> departments=departmentDao.getDepartments();//        查出所有部门数据
        model.addAttribute("departments",departments);
        return "emp/add";
    }

//    点击添加就可以提交完毕
    @PostMapping("/emp")
    public String addEmp(Employee employee){//    用employee来接收前端添加的数据
//        添加的操作
//        他讲了一下，我没听懂，随他去吧，forward和redirect 区别，可以自己去ThymeleafViewResolver.class里看
//        EmployeeDao里面定义了一个添加员工的函数save()
        //为了保险可以输出一下
        System.out.println("save=>"+employee);
        // 调用底层业务方法保存员工信息
        employeeDao.save(employee);
        return "redirect:/emps";//跳转到首页,这个没问题测试过了
    }

    //去员工修改页面
    @GetMapping("/emp/{id}")
    //查出原来的数据，这里就要和前端的链接交互，链接形式都是用@GetMapping
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){//    用model给前端返回数据
        System.out.println(id);
        Employee employee=employeeDao.getEmployeeById(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);//        把查出来的数据返回到前端

        //查出所有部门数据
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }


//    修改员工信息
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        //根据id保存信息（修改）
        employeeDao.save(employee);
        return "redirect:/emps";
    }


//    删除员工
    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
