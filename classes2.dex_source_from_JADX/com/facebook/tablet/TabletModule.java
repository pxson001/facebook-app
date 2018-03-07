package com.facebook.tablet;

import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: speed_meters_per_second */
public class TabletModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ContextScoped
    @IsTablet
    static Boolean m7866a(Context context) {
        return Boolean.valueOf(context.getResources().getBoolean(2131296265));
    }

    @ProviderMethod
    @IsTabletLandscape
    @ContextScoped
    static Boolean m7867b(Context context) {
        return Boolean.valueOf(context.getResources().getBoolean(2131296266));
    }
}
