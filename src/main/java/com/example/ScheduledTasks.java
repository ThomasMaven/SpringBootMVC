package com.example;

import com.example.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ttomaka on 12.04.2017.
 */
@Component
public class ScheduledTasks {

    @Autowired
    ContactService cs;

    @Scheduled(cron = "10 * * * * *")
    public void doSomething() {
        System.out.println(new Date().toString()+"    I just did something!");
    }

}
