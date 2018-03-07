package com.facebook.push.c2dm.configs;

import com.facebook.xconfig.core.XConfigReader;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: html */
public class GcmTokenRefreshConfig {
    public final long f11233a;
    public final long f11234b;
    public final String f11235c;
    public final String f11236d;

    GcmTokenRefreshConfig() {
        this.f11233a = 172800;
        this.f11234b = 43200;
        this.f11235c = null;
        this.f11236d = null;
    }

    GcmTokenRefreshConfig(XConfigReader xConfigReader) {
        this.f11233a = xConfigReader.a(GcmTokenRefreshXConfig.c, 172800);
        this.f11234b = xConfigReader.a(GcmTokenRefreshXConfig.d, 43200);
        this.f11235c = xConfigReader.a(GcmTokenRefreshXConfig.e, null);
        this.f11236d = xConfigReader.a(GcmTokenRefreshXConfig.f, null);
    }
}
