package com.jdai.SpringCacheDemo;

import com.jdai.SpringCacheDemo.bean.Employee;
import com.jdai.SpringCacheDemo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCacheDemoApplicationTests {
	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate; //k-v are both string

	@Autowired
	RedisTemplate redisTemplate;//k-v are both object

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

	@Test
	public void contextLoads(){
		Employee empById =  employeeMapper.getEmpById(1);
		System.out.println(" employee found:" + empById);
	}

	/** Redis 五大数据类型
	 * String,list, set, hash, ZSet（有序集合）
	 * stringRedisTemplate.opsForValue() --操作字符串
	 * stringRedisTemplate.opsForHash()
	 * stringRedisTemplate.opsForList()
	 */
	@Test
	public void testRedis1(){
		//stringRedisTemplate.opsForValue().append("msg", "testssss");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println("			redis message:"+ msg);

		stringRedisTemplate.opsForList().leftPush("mylist", "20");
	}

	@Test
	public void testRedis2(){
		Employee empById =  employeeMapper.getEmpById(1);
		//默认保存对象， 使用JDK序列化机制，序列化后的数据保存到redis中
		//查源码， RedisAutoConfiguration ->RedisTemplate.defaultSerializer
		//redisTemplate.opsForValue().set("emp01", empById);

		//替换serializer
		empRedisTemplate.opsForValue().set("emp01", empById);

		//1.将数据以json方式保存
		//1)自己写代码转换, jackson api
		//2)使用Redis
	}
}
