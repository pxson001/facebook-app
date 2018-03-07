package com.facebook.common.init;

import android.content.Context;
import com.facebook.api.feedcache.FeedCacheHelper;
import com.facebook.api.feedcache.OmnistoreUpdateInitializer;
import com.facebook.api.feedcache.resync.NewsFeedCacheSyncInitializer;
import com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplManager;
import com.facebook.backgroundlocation.reporting.BackgroundLocationReportingSettingsManager;
import com.facebook.bugreporter.scheduler.BugReportRetryInitializer;
import com.facebook.common.netchecker.NetChecker;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.gk.internal.GatekeeperStoreLoadTimeLogger;
import com.facebook.http.common.ActiveRequestsOverlayController;
import com.facebook.http.config.NetworkConfigUpdater;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.location.FbLocationStatusMonitor;
import com.facebook.location.foreground.ForegroundLocationController;
import com.facebook.messaging.captiveportal.CaptivePortalNotificationManager;
import com.facebook.messaging.send.client.StartupRetryInitializer;
import com.facebook.orca.notify.MessagesNotificationManager;
import com.facebook.orca.server.MessagesServiceManager;
import com.facebook.prefs.shared.FbSharedPreferencesWriteLatch;
import com.facebook.push.PushInitializer;
import com.facebook.push.mqtt.MqttGateKeepersMonitor;
import com.facebook.push.mqtt.service.ClientSubscriptionAutoSubscriber;
import com.facebook.push.mqtt.service.MqttClientStateManager;
import com.facebook.push.mqtt.service.MqttPushServiceManager;
import com.facebook.rti.orca.FbnsLiteInitializer;
import com.facebook.rti.orca.MqttLiteInitializer;
import com.facebook.selfupdate.remotepushtrigger.RemotePushTriggerWifiChangeMonitor;
import java.util.NoSuchElementException;
import javax.inject.Inject;

@ContextScoped
/* compiled from: name_entries */
public final class NeedsLowPriUIThreadInitIterator implements INeedInitIterator {
    private static NeedsLowPriUIThreadInitIterator f7305c;
    private static final Object f7306d = new Object();
    private final Lazy<? extends INeedInit>[] f7307a;
    private int f7308b = -1;

    private static NeedsLowPriUIThreadInitIterator m7644b(InjectorLike injectorLike) {
        return new NeedsLowPriUIThreadInitIterator(IdBasedLazy.a(injectorLike, 251), IdBasedSingletonScopeProvider.b(injectorLike, 228), IdBasedSingletonScopeProvider.b(injectorLike, 229), IdBasedSingletonScopeProvider.b(injectorLike, 379), IdBasedSingletonScopeProvider.b(injectorLike, 381), IdBasedLazy.a(injectorLike, 427), IdBasedSingletonScopeProvider.b(injectorLike, 583), IdBasedSingletonScopeProvider.b(injectorLike, 585), IdBasedLazy.a(injectorLike, 2110), IdBasedSingletonScopeProvider.b(injectorLike, 2212), IdBasedSingletonScopeProvider.b(injectorLike, 2240), IdBasedSingletonScopeProvider.b(injectorLike, 2492), IdBasedSingletonScopeProvider.b(injectorLike, 2482), IdBasedSingletonScopeProvider.b(injectorLike, 2573), IdBasedLazy.a(injectorLike, 2697), IdBasedSingletonScopeProvider.b(injectorLike, 2899), IdBasedSingletonScopeProvider.b(injectorLike, 2916), IdBasedSingletonScopeProvider.b(injectorLike, 3080), IdBasedSingletonScopeProvider.b(injectorLike, 3156), IdBasedSingletonScopeProvider.b(injectorLike, 3185), IdBasedSingletonScopeProvider.b(injectorLike, 3195), IdBasedSingletonScopeProvider.b(injectorLike, 3202), IdBasedSingletonScopeProvider.b(injectorLike, 3209), IdBasedSingletonScopeProvider.b(injectorLike, 3359), IdBasedSingletonScopeProvider.b(injectorLike, 3361), IdBasedSingletonScopeProvider.b(injectorLike, 3418));
    }

    @Inject
    public NeedsLowPriUIThreadInitIterator(Lazy<NewsFeedCacheSyncInitializer> lazy, Lazy<FeedCacheHelper> lazy2, Lazy<OmnistoreUpdateInitializer> lazy3, Lazy<BackgroundLocationReportingNewImplManager> lazy4, Lazy<BackgroundLocationReportingSettingsManager> lazy5, Lazy<BugReportRetryInitializer> lazy6, Lazy<NetChecker> lazy7, Lazy<FbNetworkManager> lazy8, Lazy<GatekeeperStoreLoadTimeLogger> lazy9, Lazy<ActiveRequestsOverlayController> lazy10, Lazy<NetworkConfigUpdater> lazy11, Lazy<ForegroundLocationController> lazy12, Lazy<FbLocationStatusMonitor> lazy13, Lazy<CaptivePortalNotificationManager> lazy14, Lazy<StartupRetryInitializer> lazy15, Lazy<MessagesNotificationManager> lazy16, Lazy<MessagesServiceManager> lazy17, Lazy<FbSharedPreferencesWriteLatch> lazy18, Lazy<PushInitializer> lazy19, Lazy<MqttGateKeepersMonitor> lazy20, Lazy<ClientSubscriptionAutoSubscriber> lazy21, Lazy<MqttClientStateManager> lazy22, Lazy<MqttPushServiceManager> lazy23, Lazy<FbnsLiteInitializer> lazy24, Lazy<MqttLiteInitializer> lazy25, Lazy<RemotePushTriggerWifiChangeMonitor> lazy26) {
        this.f7307a = new Lazy[]{lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11, lazy12, lazy13, lazy14, lazy15, lazy16, lazy17, lazy18, lazy19, lazy20, lazy21, lazy22, lazy23, lazy24, lazy25, lazy26};
    }

    public static NeedsLowPriUIThreadInitIterator m7643a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NeedsLowPriUIThreadInitIterator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7306d) {
                NeedsLowPriUIThreadInitIterator needsLowPriUIThreadInitIterator;
                if (a2 != null) {
                    needsLowPriUIThreadInitIterator = (NeedsLowPriUIThreadInitIterator) a2.a(f7306d);
                } else {
                    needsLowPriUIThreadInitIterator = f7305c;
                }
                if (needsLowPriUIThreadInitIterator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7644b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7306d, b3);
                        } else {
                            f7305c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = needsLowPriUIThreadInitIterator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean hasNext() {
        return this.f7308b + 1 < this.f7307a.length;
    }

    public final Object next() {
        if (hasNext()) {
            this.f7308b++;
            return (INeedInit) this.f7307a[this.f7308b].get();
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        this.f7307a[this.f7308b] = null;
    }
}
