package com.tropogo.controller;

import com.tropogo.model.Job;
import com.tropogo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
@RestController
@RequestMapping(value = "/jobogo")
public class JobController {
    @Autowired
    JobService jobService;

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public ResponseEntity<Object> getJob() {
        try {
            var jobs = (List<Job>) jobService.findAll();
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public ResponseEntity<Object> createJob(@RequestBody Job job) {
        try {
            jobService.addJob(job);
            return new ResponseEntity<>("Job is posted successfully", HttpStatus.CREATED);
        }catch(Exception e){
            if (e instanceof HttpMessageNotReadableException){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
