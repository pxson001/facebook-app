package com.facebook.common.time;

import com.facebook.inject.AbstractProvider;
import java.util.GregorianCalendar;

/* compiled from: should_show_recent_reviews_entry_point */
public class GregorianCalendarMethodAutoProvider extends AbstractProvider<GregorianCalendar> {
    public Object get() {
        return TimeModule.e();
    }
}
