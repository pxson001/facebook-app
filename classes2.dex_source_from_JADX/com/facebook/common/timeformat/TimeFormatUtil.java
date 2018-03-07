package com.facebook.common.timeformat;

/* compiled from: request_name */
public interface TimeFormatUtil {

    /* compiled from: request_name */
    public enum TimeFormatStyle {
        HOUR_MINUTE_STYLE,
        WEEK_DAY_STYLE,
        STREAM_RELATIVE_STYLE,
        NOTIFICATIONS_STREAM_RELATIVE_STYLE,
        EXACT_STREAM_RELATIVE_STYLE,
        MONTH_DAY_YEAR_STYLE,
        MONTH_DAY_YEAR_SHORT_STYLE,
        NUMERIC_MONTH_DAY_YEAR_STYLE,
        EVENTS_RELATIVE_STYLE,
        EVENTS_RELATIVE_DATE_STYLE,
        FUZZY_RELATIVE_DATE_STYLE,
        EXACT_TIME_DATE_STYLE,
        EXACT_TIME_DATE_DOT_STYLE,
        DATE_PICKER_STYLE,
        SHORT_DATE_STYLE,
        THREAD_DATE_STYLE,
        SHORTEST_RELATIVE_PAST_STYLE,
        SHORTEST_RELATIVE_FUTURE_STYLE,
        DAY_HOUR_FUTURE_STYLE,
        RFC1123_STYLE,
        DURATION_LARGEST_UNIT_STYLE
    }

    String mo1649a(TimeFormatStyle timeFormatStyle, long j);
}
