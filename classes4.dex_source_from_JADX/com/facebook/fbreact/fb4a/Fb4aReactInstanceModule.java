package com.facebook.fbreact.fb4a;

import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.fbreact.annotations.IsFb4aReactNativePreloadEnabled;
import com.facebook.fbreact.annotations.IsFb4aReactNativePreloadInAppForegroundEnabled;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;

@InjectorModule
/* compiled from: http.socket.timeout */
public class Fb4aReactInstanceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsFb4aReactNativePreloadEnabled
    public static Boolean m11130a(QeAccessor qeAccessor) {
        boolean z = false;
        if (qeAccessor.a(ExperimentsForFb4aReactInstanceModule.f10603a, false) || qeAccessor.a(ExperimentsForEventsGatingModule.f10622S, false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsFb4aReactNativePreloadInAppForegroundEnabled
    public static Boolean m11131b(QeAccessor qeAccessor) {
        return Boolean.valueOf(qeAccessor.a(ExperimentsForEventsGatingModule.f10615L, false));
    }
}
