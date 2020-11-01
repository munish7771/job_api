package com.tropogo.dao;

import com.tropogo.model.Job;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository

public interface JobRepository extends CrudRepository<Job, Integer>{
}

