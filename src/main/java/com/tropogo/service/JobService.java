package com.tropogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tropogo.dao.JobRepository;
import com.tropogo.model.Job;
import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

    public List<Job> findAll(){
        return (List<Job>) repository.findAll();
    }

    public boolean addJob(Job job){
        try {
            if (job.getPostedBy() != null && job.getPostedBy().isEmpty()) {
                // posted by default
                job.setPostedBy("default");
            }
            repository.save(job);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
