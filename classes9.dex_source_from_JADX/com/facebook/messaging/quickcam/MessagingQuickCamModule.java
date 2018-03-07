package com.facebook.messaging.quickcam;

import android.hardware.Camera;
import android.os.Build.VERSION;
import com.facebook.common.quickcam.CameraUtil;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.quickcam.annotations.IsForceFullscreenQuickCamEnabled;
import com.facebook.messaging.quickcam.annotations.IsQuickCamKeyboardEnabled;
import com.facebook.messaging.quickcam.annotations.IsQuickCamVideoEnabled;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: delta_sent_message_handling_error */
public class MessagingQuickCamModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsQuickCamKeyboardEnabled
    public static Boolean m16476a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @IsQuickCamVideoEnabled
    public static Boolean m16478a(Provider<Boolean> provider, CameraUtil cameraUtil) {
        if (!((Boolean) provider.get()).booleanValue()) {
            return Boolean.valueOf(false);
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras <= 0) {
            return Boolean.valueOf(false);
        }
        boolean z = true;
        for (int i = 0; i < numberOfCameras; i++) {
            if (!cameraUtil.m6333a(i)) {
                z = false;
                break;
            }
        }
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @Singleton
    static QuickCamPermissionsHolder m16479b() {
        return new QuickCamPermissionsHolder(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    @ProviderMethod
    @IsForceFullscreenQuickCamEnabled
    public static Boolean m16477a(Provider<Boolean> provider) {
        boolean z = VERSION.SDK_INT < 16 && !((Boolean) provider.get()).booleanValue();
        return Boolean.valueOf(z);
    }
}
