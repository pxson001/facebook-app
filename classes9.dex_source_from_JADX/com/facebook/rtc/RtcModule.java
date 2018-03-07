package com.facebook.rtc;

import android.hardware.Camera;
import com.facebook.device.CpuCapabilities;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.rtc.annotations.IsVoipVideoEnabled;

@InjectorModule
/* compiled from: awareness_nux_impressions */
public class RtcModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsVoipVideoEnabled
    static Boolean m19086a(Boolean bool, CpuCapabilities cpuCapabilities) {
        boolean z = true;
        boolean z2;
        if (cpuCapabilities.a() || cpuCapabilities.b()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!(bool.booleanValue() && Camera.getNumberOfCameras() > 0 && r0)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
