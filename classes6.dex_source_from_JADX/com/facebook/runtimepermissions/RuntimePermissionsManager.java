package com.facebook.runtimepermissions;

import com.facebook.runtimepermissions.RequestPermissionsConfig.RationaleBehavior;

/* compiled from: write ONE byte?! */
public interface RuntimePermissionsManager {
    public static final RequestPermissionsConfig f4772a;

    /* compiled from: write ONE byte?! */
    public interface RuntimePermissionsListener {
        void mo6a();

        void mo7a(String[] strArr, String[] strArr2);

        void mo8b();
    }

    void mo334a(String[] strArr, RequestPermissionsConfig requestPermissionsConfig, RuntimePermissionsListener runtimePermissionsListener);

    void mo335a(String[] strArr, RuntimePermissionsListener runtimePermissionsListener);

    boolean mo336a(String[] strArr);

    static {
        RequestPermissionsConfigBuilder requestPermissionsConfigBuilder = new RequestPermissionsConfigBuilder();
        requestPermissionsConfigBuilder.f4788c = RationaleBehavior.ALWAYS_SHOW;
        f4772a = requestPermissionsConfigBuilder.m7562e();
    }
}
