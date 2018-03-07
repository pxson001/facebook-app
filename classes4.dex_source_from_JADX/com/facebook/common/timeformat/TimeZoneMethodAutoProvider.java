package com.facebook.common.timeformat;

import com.facebook.inject.AbstractProvider;
import java.util.TimeZone;

/* compiled from: vpv_duration */
public class TimeZoneMethodAutoProvider extends AbstractProvider<TimeZone> {
    public Object get() {
        return TimeFormatModule.a();
    }
}
