package com.facebook.pages.hours;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: task_key_load_initial_data */
public class PageDayHourRanges {
    public String f1729a = null;
    private ImmutableList<String> f1730b;

    public PageDayHourRanges(String[] strArr, String str) {
        this.f1730b = ImmutableList.copyOf(strArr);
        this.f1729a = str;
    }

    public final List<String> m1906a() {
        return this.f1730b;
    }
}
