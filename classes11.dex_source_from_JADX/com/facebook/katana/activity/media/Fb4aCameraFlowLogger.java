package com.facebook.katana.activity.media;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.camera.analytics.CameraFlowLogger;
import com.facebook.camera.analytics.CameraUsageData;
import com.facebook.camera.utils.Orientation;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.WaterfallIdGenerator;
import javax.inject.Inject;

/* compiled from: {west} */
public class Fb4aCameraFlowLogger implements AnalyticsActivity, CameraFlowLogger {
    final DefaultPhotoFlowLogger f0a;
    final PerformanceLogger f1b;
    final WaterfallIdGenerator f2c;
    private String f3d;
    private boolean f4e = false;
    private long f5f;

    @Inject
    public Fb4aCameraFlowLogger(DefaultPhotoFlowLogger defaultPhotoFlowLogger, PerformanceLogger performanceLogger, WaterfallIdGenerator waterfallIdGenerator) {
        this.f0a = defaultPhotoFlowLogger;
        this.f1b = performanceLogger;
        this.f2c = waterfallIdGenerator;
    }

    public final void m5a(Bundle bundle, String str) {
        this.f1b.d(2424833, am_().toString());
        this.f4e = true;
        if (bundle != null) {
            this.f3d = bundle.getString("camera_session_id");
        }
        if (this.f3d == null) {
            this.f3d = WaterfallIdGenerator.a();
        }
        this.f0a.a(this.f3d);
        this.f0a.h(str);
    }

    public final void m6a(CameraUsageData cameraUsageData) {
        this.f1b.a(2424833, am_().toString());
        this.f0a.a(cameraUsageData.l(), cameraUsageData.a, cameraUsageData.b, cameraUsageData.c, cameraUsageData.d);
    }

    public final void m0a() {
        if (this.f4e) {
            this.f1b.c(2424833, am_().toString());
            this.f4e = false;
        }
    }

    public final void m7a(CameraUsageData cameraUsageData, int i) {
        this.f0a.b(i);
    }

    public final void m17c() {
        this.f0a.f();
        this.f5f = SystemClock.uptimeMillis();
    }

    public final void m18d() {
        this.f0a.b(SystemClock.uptimeMillis() - this.f5f);
    }

    public final void m12a(boolean z) {
        this.f0a.c(z);
    }

    public final void m9a(String str) {
        this.f0a.i(str);
    }

    public final void m2a(Intent intent) {
        intent.putExtra("camera_session_id", this.f3d);
    }

    public final void m4a(Bundle bundle) {
        bundle.putString("camera_session_id", this.f3d);
    }

    public final void m15b(String str) {
        this.f3d = str;
    }

    public final void m3a(Uri uri) {
        this.f0a.a(uri);
    }

    public final void m13b(Uri uri) {
        this.f0a.b(uri);
    }

    public final void m8a(Orientation orientation) {
        this.f0a.l = orientation.toString();
    }

    public final void m14b(Orientation orientation) {
        this.f0a.m = orientation.toString();
    }

    public final void m1a(int i, boolean z) {
        this.f0a.a(i, z);
    }

    public final void m19e() {
        this.f0a.a(-1, false);
    }

    public final void m11a(String str, boolean z) {
        this.f0a.a(str, z);
    }

    public final void m10a(String str, Exception exception) {
        this.f0a.a(str, exception);
    }

    public final void m16b(boolean z) {
    }

    public final String am_() {
        return "camera";
    }
}
