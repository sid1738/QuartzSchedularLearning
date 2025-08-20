package com.example.quartz.QuartzLearning.jobs;

import java.io.Serializable;

import org.quartz.Job;
import org.springframework.stereotype.Component;


@Component
public class ForeverJob implements Job {
    @Override
    public void execute(org.quartz.JobExecutionContext jobExecutionContext) {
        System.out.println("ForeverJob is executing...");
        // Add logic for the job that runs indefinitely
        // This could include logging, processing data, etc.
    }
    
}
