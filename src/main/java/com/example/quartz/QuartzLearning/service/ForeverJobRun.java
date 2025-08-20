package com.example.quartz.QuartzLearning.service;

import org.quartz.Trigger;
import org.springframework.stereotype.Service;

import com.example.quartz.QuartzLearning.commonUtils.commonUtils;
import com.example.quartz.QuartzLearning.jobs.ForeverJob;
import com.example.quartz.QuartzLearning.model.TriggerInfo;
import com.example.quartz.QuartzLearning.scheduler.MainSchedular;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ForeverJobRun {
    private final MainSchedular mainSchedular;
    private final commonUtils commonUtils;

    @PostConstruct
    public void init() {
        Trigger trigger = commonUtils.getTrigger(ForeverJob.class, new TriggerInfo(0, true, 1000L, 0L, "This is a forever job"));

        try {
            mainSchedular.ScheduleJob(ForeverJob.class, new TriggerInfo(0, true, 1000L, 0L, "This is a forever job"));
            System.out.println("Forever job scheduled successfully with the following info: " + trigger);
        } catch (Exception e) {
            System.err.println("Error scheduling forever job: " + e.getMessage());
        }
    }
    
}
