package com.facebook.gk.listeners;

import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.concurrent.Executor;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: updateStorySavedStateParamsKey */
public class GkListenersModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static GatekeeperListenersImpl m3650a(GatekeeperStoreImpl gatekeeperStoreImpl, Executor executor) {
        GatekeeperListenersImpl gatekeeperListenersImpl = new GatekeeperListenersImpl(executor);
        gatekeeperStoreImpl.m2188a(gatekeeperListenersImpl);
        return gatekeeperListenersImpl;
    }

    @ProviderMethod
    @Singleton
    @Sessionless
    static GatekeeperListenersImpl m3651b(GatekeeperStoreImpl gatekeeperStoreImpl, Executor executor) {
        GatekeeperListenersImpl gatekeeperListenersImpl = new GatekeeperListenersImpl(executor);
        gatekeeperStoreImpl.m2188a(gatekeeperListenersImpl);
        return gatekeeperListenersImpl;
    }
}
