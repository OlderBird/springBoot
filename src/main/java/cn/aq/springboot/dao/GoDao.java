package cn.aq.springboot.dao;

import cn.aq.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoDao {
    Employee getEmp();
}
