package com.facebook.reportaproblem.fb;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.reportaproblem.base.ReportAProblem;

@InjectorModule
/* compiled from: setNotificationPreference */
public class FbReportAProblemModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static ReportAProblem m7133a() {
        return new ReportAProblem();
    }
}
