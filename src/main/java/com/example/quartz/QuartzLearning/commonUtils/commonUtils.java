package com.example.quartz.QuartzLearning.commonUtils;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Simple;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import com.example.quartz.QuartzLearning.model.TriggerInfo;

@Service
public class commonUtils {


    public Trigger getTrigger(Class jobClassName, TriggerInfo triggerInfo) {

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMilliseconds(triggerInfo.getTimeInterval());

        if (triggerInfo.isRunningForEver()) {
            simpleScheduleBuilder.repeatForever();
        } else {
            simpleScheduleBuilder.withRepeatCount(triggerInfo.getTriggerCount());
        }
        
        return TriggerBuilder.
                newTrigger()
                .startAt(new Date(System.currentTimeMillis() + triggerInfo.getInitialOffset()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMilliseconds(triggerInfo.getTimeInterval())
                        .withRepeatCount(triggerInfo.getTriggerCount()))
                .build();
    }

    public JobDetail getJobDetail(Class jobClassName, TriggerInfo triggerInfo) {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClassName.getSimpleName(), triggerInfo);

        JobDetail jobDetail = JobBuilder.newJob(jobClassName)
                .withIdentity(jobClassName.getSimpleName(), "grp1")
                .usingJobData(jobDataMap)
                .storeDurably(true)
                .build();
        return jobDetail;
    }
}
