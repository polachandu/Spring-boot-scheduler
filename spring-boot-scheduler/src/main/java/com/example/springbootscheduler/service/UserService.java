package com.example.springbootscheduler.service;

import com.example.springbootscheduler.dao.UserRepository;
import com.example.springbootscheduler.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    //add a job to db for every 5 sec
    @Scheduled(fixedRate = 5000)
    public void addToDbJob() {
        User user = new User();
        user.setName("user" + new Random().nextInt(360000));
        userRepository.save(user);
        System.out.println("add service call in : " + new Date().toString());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDbJob() {
        List<User> users = userRepository.findAll();
        System.out.println("fetch service call in : " + new Date().toString());
        System.out.println("No of records fetched : " + users.size());
        log.info("users : {}", users);
    }
}

