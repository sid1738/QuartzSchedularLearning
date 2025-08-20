package com.example.quartz.QuartzLearning.service;

import org.quartz.JobDetail;
import org.springframework.stereotype.Service;

import com.example.quartz.QuartzLearning.commonUtils.commonUtils;
import com.example.quartz.QuartzLearning.jobs.ScheduleJob;
import com.example.quartz.QuartzLearning.model.TriggerInfo;
import com.example.quartz.QuartzLearning.scheduler.MainSchedular;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleJobRun {
    private final MainSchedular mainSchedular;
    private final commonUtils commonUtils;

    @PostConstruct
    public void init(){
        try{
            TriggerInfo triggerInfo = new TriggerInfo(5, true, 1000L, 0L, "This is a test job");
            mainSchedular.ScheduleJob(ScheduleJob.class, triggerInfo);
       // System.out.println("Job scheduled successfully with the following info: " + triggerInfo);
        } catch (Exception e) {
            System.err.println("Error scheduling job: " + e.getMessage());
        }
    }
}
