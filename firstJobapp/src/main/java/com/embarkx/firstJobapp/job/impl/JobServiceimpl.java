package com.embarkx.firstJobapp.job.impl;

import com.embarkx.firstJobapp.job.Job;
import com.embarkx.firstJobapp.job.JobRepository;
import com.embarkx.firstJobapp.job.JobService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceimpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

//    private long nextId = 1l;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job : jobs){
//            if(job.getId() == id){
//                return job;
//            }
//        }
//        return null;
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId() == id) {
//                iterator.remove();  // Safe removal via iterator
//                return true;
//            }
//        }
//        return false;
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
        }
        return false;
    }
//        for(Job job : jobs){
//            if (job.getId() == (id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
//        return false;
//    }

}
