package com.jdai.SpringCacheDemo;

import com.jdai.SpringCacheDemo.bean.Employee;
import com.jdai.SpringCacheDemo.mapper.EmployeeMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1. 建库，建表
 * 2. 创建 Java bean 对应表
 * 3. 整合Mybatis
 * 	1. 配置数据源
 * 	2. 使用注解版的Mybatis:
 * 		1) @MapperScan指定需要扫描的mapper接口所在的包
 *
 * 	缓存
 * 	1. 开启缓存
 * 	2. 标注缓存
 *
 * 	缓存工作原理
 * 	1. 自动配置类：Shift key twice to find a class
 * 		CacheAutoConfiguration
 * 	2. 缓存配置类( 10个，支持不同的缓存provider)
 * 	org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
 *
 * 	3. 哪个缓存配置类生效?
 * 	   turn on debug=true
 * 	   SimpleCacheConfiguration matched [默认]
 *  4. 注册了一个 ConcurrentMapCacheManager 到spring 容器
 *  5. ConcurrentMapCacheManager 管理一个 ConcurrentMap<String, Cache> cacheMap
 *
 *  运行流程
 *  1. before call service method, goes to ConcurrentMapCacheManager.getCache
 *      if cache not found, create a new cache
 *      singleton pattern to create cache(put into the concurrentmap)
 *      return cache isntanceof ConcurrentMapCache
 *  2.ConcurrentMapCache.lookup- search by key
 *    key是按照某种策略生成的， 默认是用方法参数生成 keyGenerator, SimpleKeyGenerator
 *
 *
 * 整合redis
 * 1.安装redis， 使用docker
 * 2. 引入redis starter
 * 3. 配置redis
 * 4. 测试redis 缓存
 *   原理， CacheAutoConfiguration 按照顺序导入所有的缓存配置
 *  顺序: JcacheCacheConfiguration -> EhCacheCacheCOnfiguration
 *        ->...RedisCacheConfiguration
 *        -> ... SimpleCacheConfiguration
 *        -> NoOpCacheConfiguration
 *   RedisCacheConfiguration
 *    @ConditionalOnClass(RedisConnectionFactory.class)
 * @AutoConfigureAfter(RedisAutoConfiguration.class)
 * @ConditionalOnBean(RedisConnectionFactory.class)
 * @ConditionalOnMissingBean(CacheManager.class)
 *
 * SimpleCacheConfiguration
 *  @ConditionalOnMissingBean(CacheManager.class)  --only if previous doesn't create the cachemanager
 *
 *  then the final match is RedisCacheConfiguration( cacheManager after redis will not match)
 *  RedisCacheManager
 */
@MapperScan("com.jdai.SpringCacheDemo.mapper")
@SpringBootApplication
@EnableCaching
public class SpringCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheDemoApplication.class, args);
	}

}
