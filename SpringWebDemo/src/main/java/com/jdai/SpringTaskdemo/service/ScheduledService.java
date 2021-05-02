package com.jdai.SpringTaskdemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     * second, minute, hour, day of month, month, day of week
     * [0 0/5 14,18 * * ?] 每天14点和18点整，每隔5分钟执行一次
     * [0 15 10 ? * 1-6]每个月的周一至周六10:15执行一次
     * 【0 0 2 ？ * 6L】每个月的最后一个周六凌晨2点执行一次
     * 【0 0 2 LW * ？】每个月的最后一个工作日凌晨2点执行一次
     * 【0 0 2-4 ？ * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次
     */
    //@Scheduled(cron = "0 15 10 15 * ?")//10:15 AM on the 15th day of every month
    //@Scheduled(cron = "${cron.expression}") //from config file
    //@Scheduled(cron="0 * * * * MON-SUN") //every 00 second, all minute,hour,dayOfMonth, month, MON to SUN day
    //@Scheduled(fixedRate = 2000) //every 2 seconds
    public void hello(){
        System.out.println("            ------scheduled task print out....");
    }

}
