package com.facebook.feed.quickcam;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.video.engine.IsPausedBitmapEnabled;

@InjectorModule
/* compiled from: previous_advertising_id */
public class QuickCamActivityModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsPausedBitmapEnabled
    static Boolean m13974a() {
        return Boolean.valueOf(true);
    }
}
