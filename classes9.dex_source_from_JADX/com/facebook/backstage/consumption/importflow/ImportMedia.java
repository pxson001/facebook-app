package com.facebook.backstage.consumption.importflow;

import com.facebook.backstage.data.DefaultMediaItemImpl;
import com.facebook.backstage.data.TimezoneDate;

/* compiled from: ride_types */
public class ImportMedia extends DefaultMediaItemImpl {
    public boolean f4822b;
    public String f4823c;

    public ImportMedia(String str, String str2, TimezoneDate timezoneDate, boolean z) {
        String str3;
        String str4 = "file://" + str;
        if (z) {
            str3 = "file://" + str;
        } else {
            str3 = "";
        }
        super(str4, str3, str2, timezoneDate);
        this.f4822b = true;
        this.f4823c = str;
    }
}
