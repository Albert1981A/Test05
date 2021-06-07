package com.AlbertAbuav.Test05.utils;

import com.AlbertAbuav.Test05.beans.Job;

import java.sql.Date;
import java.time.LocalDate;

public class FactoryUtils {

    private static int COUNT = 1;

    public static Job createJob() {
        Job job = Job.builder()
                .description("Description - " + COUNT)
                .endDate(Date.valueOf(LocalDate.now().plusDays(COUNT++)))
                .build();
        return job;
    }
}
