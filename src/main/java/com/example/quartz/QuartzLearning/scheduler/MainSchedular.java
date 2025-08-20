package com.example.quartz.QuartzLearning.scheduler;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

import com.example.quartz.QuartzLearning.commonUtils.commonUtils;
import com.example.quartz.QuartzLearning.model.TriggerInfo;

@Service
@AllArgsConstructor
public class MainSchedular {

    private Scheduler scheduler;

    @PostConstruct()
    public void startSchedule(){
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void ScheduleJob(Class jobClassName, TriggerInfo triggerInfo) {
        try {
            commonUtils commonUtils = new commonUtils();
            JobDetail jobDetail = commonUtils.getJobDetail(jobClassName, triggerInfo);
            Trigger trigger = commonUtils.getTrigger(jobClassName, triggerInfo);
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }

    @PreDestroy()
    public void shutdown() throws SchedulerException {
        scheduler.shutdown();
    }
}
