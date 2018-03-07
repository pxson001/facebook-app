package com.facebook.http.common.prioritization;

import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpUtils;
import com.google.common.base.Preconditions;

/* compiled from: display_duration */
public class UnblockableRequestChecker$RequestFilter {
    public final String f4998a;
    public final String f4999b;

    public UnblockableRequestChecker$RequestFilter(String str, String str2) {
        this.f4998a = str;
        this.f4999b = str2;
    }

    public final boolean m9928a(FbHttpRequest<?> fbHttpRequest) {
        Preconditions.checkNotNull(fbHttpRequest);
        return this.f4998a.equals(fbHttpRequest.c) && this.f4999b.equals(FbHttpUtils.m9866b(fbHttpRequest));
    }
}
