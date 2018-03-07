package com.facebook.messaging.threads.util;

import android.content.res.Resources;
import javax.inject.Inject;

/* compiled from: com.facebook.Session$StatusCallback */
public class ThreadSourceUtil {
    private final Resources f17841a;

    @Inject
    public ThreadSourceUtil(Resources resources) {
        this.f17841a = resources;
    }

    public final String m17843a(String str) {
        if ("mobile".equals(str)) {
            return this.f17841a.getString(2131231536);
        }
        if ("messenger".equals(str)) {
            return this.f17841a.getString(2131231535);
        }
        if ("chat:orca".equals(str)) {
            return this.f17841a.getString(2131231535);
        }
        if ("chat".equals(str)) {
            return this.f17841a.getString(2131231537);
        }
        if ("email".equals(str)) {
            return this.f17841a.getString(2131231538);
        }
        if ("quickcam video".equals(str)) {
            return this.f17841a.getString(2131231539);
        }
        if ("quickcam photo".equals(str)) {
            return this.f17841a.getString(2131231540);
        }
        return this.f17841a.getString(2131231537);
    }
}
