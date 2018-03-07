package com.facebook.backstage.data;

import java.util.Date;

/* compiled from: resource_size_in_bytes */
public class TimezoneDate extends Date {
    public final long mTimezoneOffset;

    public TimezoneDate(long j, long j2) {
        super(j);
        this.mTimezoneOffset = j2;
    }
}
