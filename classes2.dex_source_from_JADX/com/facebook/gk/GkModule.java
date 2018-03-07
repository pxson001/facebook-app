package com.facebook.gk;

import android.content.Context;
import com.facebook.gk.store.GatekeeperStoreConfig;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperStoreImpl.Builder;
import com.facebook.gk.storelogger.TraceGatekeeperStoreLogger;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: view_server_enabled */
public class GkModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static GatekeeperStoreConfig m2134a() {
        return new UserGatekeeperStoreConfig();
    }

    @ProviderMethod
    @Singleton
    static TraceGatekeeperStoreLogger m2136b() {
        return new TraceGatekeeperStoreLogger("GatekeeperStore");
    }

    @ProviderMethod
    @Singleton
    static GatekeeperStoreImpl m2135a(Context context, GatekeeperStoreConfig gatekeeperStoreConfig, TraceGatekeeperStoreLogger traceGatekeeperStoreLogger) {
        Builder builder = new Builder(context);
        builder.f1056b = gatekeeperStoreConfig;
        builder = builder;
        builder.f1059e = traceGatekeeperStoreLogger;
        return builder.m2148b();
    }
}
