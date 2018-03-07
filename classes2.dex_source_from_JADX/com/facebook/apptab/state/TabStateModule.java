package com.facebook.apptab.state;

import com.facebook.apptab.dummystate.IsHarrisonEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.work.groupstab.annotations.ShouldShowWorkGroupTab;

@InjectorModule
/* compiled from: sponsored_impressions_waterfall_enabled */
public class TabStateModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsHarrisonEnabled
    static Boolean m7795a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @ShouldShowWorkGroupTab
    public static Boolean m7796b() {
        return Boolean.valueOf(false);
    }
}
