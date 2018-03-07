package com.facebook.qe.module;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.UniqueDeviceIdentityProvider;
import com.facebook.qe.api.factory.QeImplFactory;
import com.facebook.qe.api.impl.QeInternalImpl;
import com.facebook.qe.observer.QeAccessorObserver;
import com.facebook.qe.schema.SchemaFactory;
import com.facebook.qe.store.StoreFs;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: unknown_state */
public class QeModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @SuppressLint({"ProviderUsage"})
    static QeInternalImpl m3853a(Context context, QeLoggedInUserIdentityProvider qeLoggedInUserIdentityProvider, QeRecentUserIdentitiesProvider qeRecentUserIdentitiesProvider, QeExposureLogger qeExposureLogger, QeMigratedExperimentProvider qeMigratedExperimentProvider, DefaultProcessUtil defaultProcessUtil, QeAccessorObserver qeAccessorObserver) {
        boolean z = !defaultProcessUtil.m2389a().e();
        QeImplFactory qeImplFactory = new QeImplFactory();
        qeImplFactory.f1936g = new UniqueDeviceIdentityProvider(context);
        qeImplFactory = qeImplFactory;
        qeImplFactory.f1935f = qeLoggedInUserIdentityProvider;
        qeImplFactory = qeImplFactory;
        qeImplFactory.f1937h = qeRecentUserIdentitiesProvider;
        qeImplFactory = qeImplFactory;
        qeImplFactory.f1934e = qeExposureLogger;
        qeImplFactory = qeImplFactory;
        qeImplFactory.f1930a = new StoreFs(context.getDir("qe_sessioned", 0), z);
        qeImplFactory = qeImplFactory;
        qeImplFactory.f1931b = new StoreFs(context.getDir("qe_sessionless", 0), z);
        QeImplFactory qeImplFactory2 = qeImplFactory;
        qeImplFactory2.f1932c = SchemaFactory.m3884b(context);
        qeImplFactory2 = qeImplFactory2;
        qeImplFactory2.f1933d = SchemaFactory.m3881a(context);
        qeImplFactory2 = qeImplFactory2;
        qeImplFactory2.f1938i = qeMigratedExperimentProvider;
        qeImplFactory2 = qeImplFactory2;
        qeImplFactory2.f1939j = Boolean.valueOf(z);
        QeImplFactory qeImplFactory3 = qeImplFactory2;
        qeImplFactory3.f1940k = Boolean.valueOf(true);
        qeImplFactory3 = qeImplFactory3;
        qeImplFactory3.f1941l = qeAccessorObserver;
        return qeImplFactory3.m3855a();
    }

    @ProviderMethod
    @Singleton
    static QeAccessorObserver m3854a() {
        return null;
    }
}
