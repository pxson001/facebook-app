package com.facebook.rtcpresence;

import android.os.Build.VERSION;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.device.CpuCapabilities;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.rtcpresence.annotations.IsVoipEnabledConsts;
import com.facebook.rtcpresence.annotations.IsVoipEnabledForUser;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: first_name */
public class RtcPresenceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @IsVoipEnabledConsts
    static Boolean m32023a(CpuCapabilities cpuCapabilities) {
        boolean z = cpuCapabilities.m32013a() || cpuCapabilities.m32014b();
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsVoipEnabledForUser
    public static Boolean m32024a(Boolean bool, TriState triState, FbAppType fbAppType) {
        boolean z = true;
        if (VERSION.SDK_INT < 9) {
            return Boolean.valueOf(false);
        }
        if (fbAppType.j != Product.MESSENGER && fbAppType.j != Product.PHONE) {
            return Boolean.valueOf(false);
        }
        boolean asBoolean;
        if (triState.isSet()) {
            asBoolean = triState.asBoolean();
        } else {
            asBoolean = true;
        }
        if (!(bool.booleanValue() && r0)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
