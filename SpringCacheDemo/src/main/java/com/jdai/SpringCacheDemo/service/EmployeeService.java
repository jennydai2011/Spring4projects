package com.jdai.SpringCacheDemo.service;

import com.jdai.SpringCacheDemo.bean.Employee;
import com.jdai.SpringCacheDemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * key and keyGenerator 二选一，不能同时设
     * cacheManager:指定缓存管理器
     * CacheResolver: 缓存解析器，与cacheManager 二选一
     * condition: 指定符合条件才缓存 , condition = "#id>0"
     * unless: 否定缓存，满足条件不缓存
     * sync: 是否使用异步
     * @param id
     * @return
     */
    //@Cacheable(cacheNames = {"emp"}, key="#root.methodName+#id")
    //@Cacheable(cacheNames = {"emp"}, keyGenerator="myKeyGenerator")
    @Cacheable(cacheNames = {"emp"}, keyGenerator="myKeyGenerator", condition = "#a0>1")
//    @Cacheable(cacheNames = {"emp"}, keyGenerator="myKeyGenerator", condition = "#a0>1", unless="#a0==2")
    public Employee getEmp(Integer id){
        System.out.println("                -------------- call service ,  search by id:" + id);
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    //@CachePut --- get value first, then put into cache, different from @Cacheable( hit cache first, then put value)
    //先执行更新数据库方法， 再同步更新缓存, 但是注意key必须和@Cacheable中用到的key 一致
    //key = "#employee.id" -- input param name
    //key = "result.id"

    //@CacheEvict ---默认先执行方法，再清除缓存（方法执行后才清除缓存，如果方法有异常，缓存不清除）
    //allEntries=true, --清除所有记录
    // beforeInvocation=true --先清除，再执行方法

    //@Caching ( == @Cacheable + @CachePut + @CacheEvict)

}
