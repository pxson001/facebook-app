package com.facebook.bugreporter;

import com.facebook.bugreporter.RageShakeDetector.ActivityListener;
import com.facebook.bugreporter.annotations.IsNotSendBugReportEnabled;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: succeed_on_fourth_onward_try */
public class BugReporterModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static ActivityListener m6462a(RageShakeDetector rageShakeDetector) {
        return rageShakeDetector.f3868c;
    }

    @ProviderMethod
    @IsNotSendBugReportEnabled
    public static Boolean m6463a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.m2189a(208, false));
    }
}
