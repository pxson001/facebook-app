package com.facebook.common.hardware;

import android.content.pm.PackageManager;
import javax.inject.Inject;

/* compiled from: split_flow_landing_page_hint_text */
public class CameraDetectionUtil {
    private PackageManager f2603a;

    @Inject
    public CameraDetectionUtil(PackageManager packageManager) {
        this.f2603a = packageManager;
    }

    public final boolean m3711a() {
        return this.f2603a.hasSystemFeature("android.hardware.camera") || this.f2603a.hasSystemFeature("android.hardware.camera.front");
    }
}
