package com.facebook.config.server;

import android.net.Uri.Builder;
import com.facebook.http.config.PlatformAppHttpConfig;

/* compiled from: sentiment */
public abstract class DelegatingPlatformAppHttpConfig implements PlatformAppHttpConfig {
    private final PlatformAppHttpConfig f5571a;

    public DelegatingPlatformAppHttpConfig(PlatformAppHttpConfig platformAppHttpConfig) {
        this.f5571a = platformAppHttpConfig;
    }

    public final Builder mo1359a() {
        return this.f5571a.mo1359a();
    }

    public final Builder mo1360b() {
        return this.f5571a.mo1360b();
    }

    public final Builder mo1363e() {
        return this.f5571a.mo1363e();
    }

    public final Builder mo1364f() {
        return this.f5571a.mo1364f();
    }

    public final Builder mo1361c() {
        return this.f5571a.mo1361c();
    }

    public final Builder mo1362d() {
        return this.f5571a.mo1362d();
    }

    public final Builder mo1365g() {
        return this.f5571a.mo1365g();
    }

    public String mo1366h() {
        return this.f5571a.mo1366h();
    }

    public final String mo1367i() {
        return this.f5571a.mo1367i();
    }
}
