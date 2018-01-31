package com.practise.util;

import com.tc.tsp.dcm.models.v1.DateTimeType;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTypeBuilder {

    private DateTimeTypeBuilder(){}

    private static final String UTC = "UTC";

    public static DateTimeType getCurrentDateTime() {
        DateTimeType dateTime = new DateTimeType();
        dateTime.setFormat(UTC);
        ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of(UTC));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd'T'HHmmssVV");
        dateTime.setValue(formatter.format(currentDateTime));

        return dateTime;
    }
}
