package com.example.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by lbb on 2017/5/3.
 */
public class DateUtils {

    /**
     * 将LocalDateTime转成Date
     *
     * @param dateTime
     * @return
     */
    public static Date convert2Date(LocalDateTime dateTime) {
        return new Date(dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
