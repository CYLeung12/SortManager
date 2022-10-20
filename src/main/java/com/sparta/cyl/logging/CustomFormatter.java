package com.sparta.cyl.logging;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE) +  " " + LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + " ["+ record.getSourceClassName().replace("com.sparta.cyl.sorter.","") + "." + record.getSourceMethodName()
                + "] " + record.getLevel()
                + ": " + record.getMessage()
                + "\n";
    }
}
