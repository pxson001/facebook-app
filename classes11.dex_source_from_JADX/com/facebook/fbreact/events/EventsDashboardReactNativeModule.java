package com.facebook.fbreact.events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.events.annotation.EventsDashboardReactFragment;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.fbreact.events.EventsDashboardReactNativeFragment.Builder;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;

@InjectorModule
/* compiled from: facepile_pic_size */
public class EventsDashboardReactNativeModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @EventsDashboardReactFragment
    public static Fragment m8476a(QeAccessor qeAccessor, CurrentModuleHolder currentModuleHolder) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("cacheEnabled", qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForEventsGatingModule.O, false));
        bundle.putBoolean("usePersistedQueries", qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForEventsGatingModule.R, false));
        Builder builder = new Builder();
        builder.f7253l = currentModuleHolder.a("unknown");
        ImmersiveReactFragment.Builder builder2 = builder;
        builder2.a = "/events";
        builder2 = builder2;
        builder2.c = "EventsDashboardApp";
        builder2 = builder2;
        builder2.d = 2131237122;
        builder2 = builder2;
        builder2.e = true;
        builder2 = builder2;
        builder2.f = bundle;
        ImmersiveReactFragment.Builder builder3 = builder2;
        builder3.h = 1;
        return builder3.b();
    }
}
