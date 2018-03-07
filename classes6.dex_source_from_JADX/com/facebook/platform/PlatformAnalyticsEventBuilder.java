package com.facebook.platform;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: finish */
public class PlatformAnalyticsEventBuilder {
    private HoneyClientEvent f14831a;
    public String f14832b;
    public String f14833c;
    private String f14834d;
    private String f14835e;
    public String f14836f;
    public String f14837g;
    public String f14838h;
    public int f14839i;
    public boolean f14840j;
    private int f14841k;
    private boolean f14842l;
    public boolean f14843m;

    public PlatformAnalyticsEventBuilder(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = str2;
        this.f14831a = honeyClientEvent;
    }

    public final PlatformAnalyticsEventBuilder m22462a(Throwable th) {
        if (th != null) {
            if (th instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) th;
                this.f14834d = serviceException.errorCode.toString();
                this.f14835e = serviceException.getMessage();
            } else {
                this.f14835e = th.getMessage();
            }
        }
        return this;
    }

    public final HoneyClientEvent m22461a() {
        if (this.f14833c == null || this.f14838h == null) {
            return null;
        }
        this.f14831a.b("app_id", this.f14833c);
        this.f14831a.b("type", this.f14838h);
        if (this.f14832b != null) {
            this.f14831a.b("action_id", this.f14832b);
        }
        if (this.f14839i != Integer.MIN_VALUE) {
            this.f14831a.a("num_photos", this.f14839i);
        }
        if (this.f14840j) {
            this.f14831a.a("has_video", this.f14840j);
        }
        if (this.f14834d != null) {
            this.f14831a.b("error_code", this.f14834d);
        }
        if (this.f14835e != null) {
            this.f14831a.b("error", this.f14835e);
        }
        if (this.f14836f != null) {
            this.f14831a.b("error_response", this.f14836f);
        }
        if (this.f14837g != null) {
            this.f14831a.b("method", this.f14837g);
        }
        if (this.f14841k != 0) {
            this.f14831a.a("num_recipients", this.f14841k);
        }
        if (this.f14842l) {
            this.f14831a.a("has_message", this.f14842l);
        }
        if (this.f14843m) {
            this.f14831a.a("is_native_intent", this.f14843m);
        }
        return this.f14831a;
    }
}
