package com.facebook.location;

import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logging_client_events */
public class FbLocationStatusMonitor implements INeedInit {
    public static final String f16097a = (FbLocationStatusMonitor.class.getCanonicalName() + ".ACTION_STATUS_STATE_CHANGED");
    public static final String f16098b = (FbLocationStatusMonitor.class.getCanonicalName() + ".ACTION_STATUS_CHANGED");
    private static final ZeroFeatureKey f16099c;
    public static final PrefKey f16100d;
    private static volatile FbLocationStatusMonitor f16101o;
    private final FbLocationStatusUtil f16102e;
    private final BaseFbBroadcastManager f16103f;
    public final BaseFbBroadcastManager f16104g;
    private final FbSharedPreferences f16105h;
    private final ListeningScheduledExecutorService f16106i;
    private final AnalyticsLogger f16107j;
    private SelfRegistrableReceiverImpl f16108k;
    @Nullable
    private FbLocationStatus f16109l;
    public ListenableFuture<?> f16110m;
    private final OnSharedPreferenceChangeListener f16111n = new 1(this);

    public static com.facebook.location.FbLocationStatusMonitor m22927a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16101o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.FbLocationStatusMonitor.class;
        monitor-enter(r1);
        r0 = f16101o;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22931b(r0);	 Catch:{ all -> 0x0035 }
        f16101o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16101o;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.FbLocationStatusMonitor.a(com.facebook.inject.InjectorLike):com.facebook.location.FbLocationStatusMonitor");
    }

    private static FbLocationStatusMonitor m22931b(InjectorLike injectorLike) {
        return new FbLocationStatusMonitor(FbLocationStatusUtil.m8253a(injectorLike), GlobalFbBroadcastManager.m4507a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    static {
        ZeroFeatureKey zeroFeatureKey = ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL;
        f16099c = zeroFeatureKey;
        f16100d = ZeroPrefKeys.m4712a(zeroFeatureKey);
    }

    @Inject
    public FbLocationStatusMonitor(FbLocationStatusUtil fbLocationStatusUtil, BaseFbBroadcastManager baseFbBroadcastManager, BaseFbBroadcastManager baseFbBroadcastManager2, FbSharedPreferences fbSharedPreferences, ListeningScheduledExecutorService listeningScheduledExecutorService, AnalyticsLogger analyticsLogger) {
        this.f16102e = fbLocationStatusUtil;
        this.f16103f = baseFbBroadcastManager;
        this.f16104g = baseFbBroadcastManager2;
        this.f16105h = fbSharedPreferences;
        this.f16106i = listeningScheduledExecutorService;
        this.f16107j = analyticsLogger;
    }

    public void init() {
        if (this.f16109l != null) {
            m22930a(this, this.f16109l);
        } else {
            this.f16109l = this.f16102e.m8259b();
        }
        this.f16108k = this.f16103f.m2951a().mo506a("android.location.PROVIDERS_CHANGED", new 2(this)).mo503a();
        this.f16108k.m3296b();
        this.f16105h.mo279a(f16100d, this.f16111n);
    }

    public static void m22933d(FbLocationStatusMonitor fbLocationStatusMonitor) {
        FbLocationStatus fbLocationStatus = fbLocationStatusMonitor.f16109l;
        fbLocationStatusMonitor.f16109l = fbLocationStatusMonitor.f16102e.m8259b();
        if (fbLocationStatusMonitor.f16110m == null) {
            fbLocationStatusMonitor.f16110m = fbLocationStatusMonitor.f16106i.mo310a(new 3(fbLocationStatusMonitor, fbLocationStatus), 500, TimeUnit.MILLISECONDS);
        }
    }

    public static void m22930a(@Nullable FbLocationStatusMonitor fbLocationStatusMonitor, FbLocationStatus fbLocationStatus) {
        Object obj = null;
        fbLocationStatusMonitor.f16109l = fbLocationStatusMonitor.f16102e.m8259b();
        boolean z = fbLocationStatus == null || fbLocationStatusMonitor.f16109l.f15655a != fbLocationStatus.f15655a;
        if (z) {
            fbLocationStatusMonitor.f16104g.m2955a(f16097a);
        }
        if (fbLocationStatus == null || !fbLocationStatusMonitor.f16109l.equals(fbLocationStatus)) {
            obj = 1;
        }
        if (obj != null) {
            Intent intent = new Intent(f16098b);
            intent.putExtra("state_changed", z);
            fbLocationStatusMonitor.f16104g.mo406a(intent);
            fbLocationStatusMonitor.m22929a(fbLocationStatus, fbLocationStatusMonitor.f16109l);
        }
    }

    private void m22929a(@Nullable FbLocationStatus fbLocationStatus, FbLocationStatus fbLocationStatus2) {
        HoneyClientEventFast a = this.f16107j.mo535a("location_providers_changed", false);
        if (a.m17388a()) {
            a.m17379a("location").m17383a("old_status", m22932b(fbLocationStatus)).m17383a("new_status", m22932b(fbLocationStatus2));
            a.m17390b();
        }
    }

    private JsonNode m22932b(@Nullable FbLocationStatus fbLocationStatus) {
        if (fbLocationStatus == null) {
            return null;
        }
        JsonNode c = JsonNodeFactory.f3121a.m5233c();
        c.m5137a("state", fbLocationStatus.f15655a.name());
        c.m5143c("user_enabled_providers", m22928a(fbLocationStatus.f15656b));
        c.m5143c("user_disabled_providers", m22928a(fbLocationStatus.f15657c));
        return c;
    }

    private static ArrayNode m22928a(ImmutableSet<String> immutableSet) {
        ArrayNode b = JsonNodeFactory.f3121a.m5232b();
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            b.m13394h((String) it.next());
        }
        return b;
    }
}
