package com.example.quartz.QuartzLearning.jobs;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;


@Component
public class ScheduleJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       System.out.println("The job started executing ....");
    }
}
