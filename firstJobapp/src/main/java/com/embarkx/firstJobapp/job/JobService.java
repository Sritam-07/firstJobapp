package com.embarkx.firstJobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    Boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
