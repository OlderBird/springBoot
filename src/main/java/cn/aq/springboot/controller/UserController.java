package cn.aq.springboot.controller;

import cn.aq.springboot.bean.Department;
import cn.aq.springboot.bean.Employee;
import cn.aq.springboot.dao.DepartmentDao;
import cn.aq.springboot.dao.EmployeeDao;
import cn.aq.springboot.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

//    员工列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("EMPS",employees);
        return "emp/list";
    }

//    来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
//    员工添加
//    SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的额
    @PostMapping("/emp")
    public String addUser(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
//        来到员工列表页面
//        forward：转发
//        redirect：重定向
        return "redirect:/emps";
    }

//    来到员工修改页面（修改和添加是一个合二为一的页面）
    @GetMapping("/emp/{id}")
    public String toAlterPage(@PathVariable("id")Integer id, Model model) {
        //查所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        Employee employee = employeeDao.get(id);
        model.addAttribute("EMP",employee);
//        来到员工修改页面
        return "emp/add";
    }
//  员工修改
    @PutMapping("/emp")
    public String alterUser(Employee employee){
        return "redirect:/emps";
    }

//  员工删除，解析异常
    @GetMapping("/delemp/{id}")
    public String deleteUser(@PathVariable("id")Integer id) {
        employeeDao.delete(id);
/*        if(...) {
            throw new UserNotExistException();
        }*/
        return "redirect:/emps";
    }


}
