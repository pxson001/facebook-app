package com.facebook.tigon.httpclientadapter;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.tigon.iface.FacebookLoggingRequestInfo;
import javax.annotation.Nullable;

/* compiled from: num_inflight_items */
public class FacebookLoggingInfoWithCallerContext implements FacebookLoggingRequestInfo {
    private final String f4907a;
    public final CallerContext f4908b;

    public FacebookLoggingInfoWithCallerContext(String str, @Nullable CallerContext callerContext) {
        this.f4907a = str;
        if (callerContext == null) {
            callerContext = CallerContext.a;
        }
        this.f4908b = callerContext;
    }

    public String logName() {
        return this.f4907a;
    }

    public String logNamespace() {
        return this.f4908b.c() == null ? "unknown" : this.f4908b.c();
    }
}
