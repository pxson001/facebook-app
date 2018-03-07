package com.facebook.oxygen.preloads.sdk.common;

import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: reaction_android_mentions */
public class PreloadSdkModule extends AbstractLibraryModule {
    @ProviderMethod
    public static PreloadSdkPresence m12692a(Context context) {
        return new PreloadSdkPresence(context.getPackageManager());
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
