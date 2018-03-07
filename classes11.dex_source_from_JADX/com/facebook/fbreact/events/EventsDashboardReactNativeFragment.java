package com.facebook.fbreact.events;

import android.content.Context;
import android.os.Bundle;
import com.facebook.catalyst.modules.persistedqueries.RelayPersistedQueriesPreloader;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.fbreact.eventsperf.EventsPerfLogger;
import com.facebook.fbreact.fb4a.Fb4aReactMarkerListener;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.persistedqueries.Fb4aPersistedQueryRequestSender;
import com.facebook.fbreact.persistedqueries.RelayPersistedQueriesPreloaderMethod;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.react.ReactInstanceManager.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fade */
public class EventsDashboardReactNativeFragment extends ImmersiveReactFragment {
    private boolean al;
    @Inject
    public Fb4aReactMarkerListener f7254f;
    @Inject
    public EventsPerfLogger f7255g;
    @Inject
    public QeAccessor f7256h;
    @Inject
    public Fb4aPersistedQueryRequestSender f7257i;

    /* compiled from: fade */
    class C09221 implements ReactInstanceEventListener {
        final /* synthetic */ EventsDashboardReactNativeFragment f7252a;

        C09221(EventsDashboardReactNativeFragment eventsDashboardReactNativeFragment) {
            this.f7252a = eventsDashboardReactNativeFragment;
        }

        public final void m8467a(ReactContext reactContext) {
            ((FBEventsNativeModule) reactContext.b(FBEventsNativeModule.class)).f7278n = EventsDashboardReactNativeFragment.av(this.f7252a);
            this.f7252a.au().b(this);
        }
    }

    /* compiled from: fade */
    public class Builder extends com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder {
        @Nullable
        public String f7253l;

        public final Bundle m8468a() {
            Bundle a = super.a();
            a.putString("extra_ref_module", this.f7253l);
            return a;
        }

        protected final ImmersiveReactFragment m8469c() {
            if ("EventsDashboardApp".equals(this.c)) {
                return new EventsDashboardReactNativeFragment();
            }
            return super.c();
        }
    }

    public static void m8470a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        EventsDashboardReactNativeFragment eventsDashboardReactNativeFragment = (EventsDashboardReactNativeFragment) obj;
        Fb4aReactMarkerListener a = Fb4aReactMarkerListener.a(injectorLike);
        EventsPerfLogger a2 = EventsPerfLogger.m8493a(injectorLike);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        Fb4aPersistedQueryRequestSender fb4aPersistedQueryRequestSender = new Fb4aPersistedQueryRequestSender(new RelayPersistedQueriesPreloaderMethod(), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
        eventsDashboardReactNativeFragment.f7254f = a;
        eventsDashboardReactNativeFragment.f7255g = a2;
        eventsDashboardReactNativeFragment.f7256h = qeAccessor;
        eventsDashboardReactNativeFragment.f7257i = fb4aPersistedQueryRequestSender;
    }

    public final void m8474c(Bundle bundle) {
        Class cls = EventsDashboardReactNativeFragment.class;
        m8470a(this, getContext());
        super.c(bundle);
        Fb4aReactMarkerListener fb4aReactMarkerListener = this.f7254f;
        fb4aReactMarkerListener.a.add(this.f7255g);
        if (bundle != null) {
            this.al = bundle.getBoolean("forceRefresh");
        }
        if (!this.f7256h.a(Liveness.Live, ExperimentsForEventsGatingModule.R, false)) {
            return;
        }
        if (bundle == null || this.al) {
            Map hashMap = new HashMap();
            hashMap.put("count", Integer.valueOf(10));
            RelayPersistedQueriesPreloader.a().a(getContext(), "WildePersistedQueries.json", "UpcomingEventsDashboard", hashMap, this.f7257i, false);
        }
    }

    public final void m8471G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -778624383);
        super.G();
        if (this.al) {
            ReactContext j = au().j();
            if (j != null) {
                ((RCTNativeAppEventEmitter) j.a(RCTNativeAppEventEmitter.class)).emit("EventsDashboardRefresh", null);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -943677595, a);
    }

    public final void m8472H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1388525527);
        super.H();
        this.al = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1464658097, a);
    }

    public final void m8475e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("forceRefresh", true);
    }

    protected final void aq() {
        this.f7255g.f7281b.b(393240);
    }

    protected final void ar() {
        EventsPerfLogger eventsPerfLogger = this.f7255g;
        eventsPerfLogger.f7281b.markerStart(393241, 0, eventsPerfLogger.f7280a.now());
        ReactContext j = au().j();
        if (j != null) {
            ((FBEventsNativeModule) j.b(FBEventsNativeModule.class)).f7278n = av(this);
            return;
        }
        au().a(new C09221(this));
    }

    public final void m8473I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -777857978);
        Fb4aReactMarkerListener fb4aReactMarkerListener = this.f7254f;
        fb4aReactMarkerListener.a.remove(this.f7255g);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 336208272, a);
    }

    public static String av(EventsDashboardReactNativeFragment eventsDashboardReactNativeFragment) {
        String string = eventsDashboardReactNativeFragment.s.getString("extra_ref_module");
        return string != null ? string : "unknown";
    }
}
