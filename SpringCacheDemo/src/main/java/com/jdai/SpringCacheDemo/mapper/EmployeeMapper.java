package com.jdai.SpringCacheDemo.mapper;

import com.jdai.SpringCacheDemo.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee set name=#{name}, email=#{email}, gender=#{gender}, deptId=#{deptId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(name, email, gender, deptId) VALUES(#{name}, #{email}, #{gender}, #{deptId})")
    public void insertEmployee(Employee employee);
}
