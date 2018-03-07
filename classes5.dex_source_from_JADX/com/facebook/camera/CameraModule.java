package com.facebook.camera;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.camera.gating.ForceCameraInLandscape;
import com.facebook.camera.gating.UseCustomVideoRecorder;
import com.facebook.camera.ipc.CameraActivityAction;
import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: android.hardware.touchscreen.multitouch.distinct */
public class CameraModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @CameraActivityAction
    @ProviderMethod
    public static String m18806a(Context context) {
        return context.getPackageName() + ".OPEN_DEFAULT_CAMERA";
    }

    @ProviderMethod
    @UseCustomVideoRecorder
    public static Boolean m18804a() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @ForceCameraInLandscape
    public static Boolean m18805a(Provider<TriState> provider) {
        return Boolean.valueOf(((TriState) provider.get()).asBoolean(VERSION.SDK_INT < 11));
    }
}
