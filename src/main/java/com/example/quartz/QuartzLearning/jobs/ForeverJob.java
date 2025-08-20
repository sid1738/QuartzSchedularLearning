package com.example.quartz.QuartzLearning.jobs;

import org.quartz.Job;

public class ForeverJob implements Job {
    @Override
    public void execute(org.quartz.JobExecutionContext jobExecutionContext) {
        System.out.println("ForeverJob is executing...");
        // Add logic for the job that runs indefinitely
        // This could include logging, processing data, etc.
    }
    
}
