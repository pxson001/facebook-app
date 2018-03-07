package com.facebook.gk.sessionless;

import android.content.Context;
import com.facebook.gk.store.GatekeeperStoreConfig;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperStoreImpl.Builder;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.gk.storelogger.TraceGatekeeperStoreLogger;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Singleton;

@DoNotStrip
@InjectorModule
/* compiled from: user_statuses */
public class GkSessionlessModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @Sessionless
    static GatekeeperStoreConfig m2717a() {
        return new SessionlessGKStoreConfig();
    }

    @ProviderMethod
    @Singleton
    @Sessionless
    static GatekeeperStoreImpl m2718a(Context context, GatekeeperStoreConfig gatekeeperStoreConfig, TraceGatekeeperStoreLogger traceGatekeeperStoreLogger) {
        Builder builder = new Builder(context.getApplicationContext());
        builder.f1057c = true;
        Builder builder2 = builder;
        builder2.f1056b = gatekeeperStoreConfig;
        builder2 = builder2;
        builder2.f1059e = traceGatekeeperStoreLogger;
        return builder2.m2148b();
    }

    @ProviderMethod
    @Singleton
    @Sessionless
    static TraceGatekeeperStoreLogger m2719b() {
        return new TraceGatekeeperStoreLogger("SessionlessGatekeeperStore");
    }

    @DoNotStrip
    public static GatekeeperWriter getInstanceForTest_GatekeeperWriter(FbInjector fbInjector) {
        return GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(fbInjector);
    }
}
