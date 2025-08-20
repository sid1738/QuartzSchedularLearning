package com.example.quartz.QuartzLearning.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class TriggerInfo implements Serializable {

    private int triggerCount;
    private boolean isRunningForEver;
    private Long timeInterval;
    private Long initialOffset;
    private String info;
}
