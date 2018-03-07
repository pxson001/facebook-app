package com.facebook.http.observer;

import android.os.Process;
import com.facebook.common.callercontext.CallerContext;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: num_days_until_show_photo_reminder_prompt_again */
public class RequestContext {
    public final String f11977a;
    public final String f11978b;
    public final long f11979c;
    private final long f11980d;
    private final int f11981e;
    @Nullable
    public final CallerContext f11982f;
    @Nullable
    public final String f11983g;

    public RequestContext(String str, String str2, long j, int i, @Nullable CallerContext callerContext, @Nullable String str3) {
        this.f11981e = i;
        this.f11977a = (String) Preconditions.checkNotNull(str);
        this.f11978b = (String) Preconditions.checkNotNull(str2);
        Preconditions.checkArgument(j >= 0);
        this.f11979c = j;
        this.f11982f = callerContext;
        this.f11983g = str3;
        this.f11980d = Process.getElapsedCpuTime();
    }

    public final String m17675a() {
        return this.f11977a;
    }

    @Nullable
    public final CallerContext m17677d() {
        return this.f11982f;
    }

    public static RequestContext m17674a(HttpContext httpContext) {
        return (RequestContext) Preconditions.checkNotNull((RequestContext) httpContext.getAttribute("fb_http_request_context"));
    }

    public final void m17676b(HttpContext httpContext) {
        if (httpContext.getAttribute("fb_http_request_context") != null) {
            throw new RuntimeException("The HttpContext instance already has an RequestContext object attached to it.");
        }
        httpContext.setAttribute("fb_http_request_context", this);
    }
}
