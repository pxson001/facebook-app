package com.facebook.placetips.upsell;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_crash_count_before_feed_reset */
public class PlaceTipsUpsellAnalyticsLogger {
    private static volatile PlaceTipsUpsellAnalyticsLogger f14886e;
    private final Lazy<AnalyticsLogger> f14887a;
    private final Clock f14888b;
    private final MonotonicClock f14889c;
    public final SessionWatcher f14890d = new SessionWatcher();

    /* compiled from: max_crash_count_before_feed_reset */
    public class SessionWatcher {
        @Nullable
        private PlaceTipsUpsellAnalyticsEvent f14891a;
        @Nullable
        private String f14892b;
        private boolean f14893c = false;

        public final synchronized String m21337a(PlaceTipsUpsellAnalyticsEvent placeTipsUpsellAnalyticsEvent) {
            PlaceTipsUpsellAnalyticsEvent placeTipsUpsellAnalyticsEvent2 = this.f14891a;
            this.f14891a = placeTipsUpsellAnalyticsEvent;
            if (this.f14892b == null || !(!placeTipsUpsellAnalyticsEvent.doesEventResetSession() || placeTipsUpsellAnalyticsEvent == placeTipsUpsellAnalyticsEvent2 || this.f14893c)) {
                this.f14892b = SafeUUIDGenerator.m2795a().toString();
            }
            return this.f14892b;
        }

        public final synchronized boolean m21339a() {
            return this.f14893c;
        }

        public final synchronized void m21338a(boolean z) {
            this.f14893c = z;
        }
    }

    public static com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsLogger m21331a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14886e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f14886e;	 Catch:{ all -> 0x003a }
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
        r0 = m21332b(r0);	 Catch:{ all -> 0x0035 }
        f14886e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14886e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.placetips.upsell.PlaceTipsUpsellAnalyticsLogger");
    }

    private static PlaceTipsUpsellAnalyticsLogger m21332b(InjectorLike injectorLike) {
        return new PlaceTipsUpsellAnalyticsLogger(IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), SystemClockMethodAutoProvider.m1498a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public PlaceTipsUpsellAnalyticsLogger(Lazy<AnalyticsLogger> lazy, Clock clock, MonotonicClock monotonicClock) {
        this.f14887a = lazy;
        this.f14888b = clock;
        this.f14889c = monotonicClock;
    }

    public final void m21336b() {
        this.f14890d.m21338a(false);
    }

    public final void m21334a(PlaceTipsUpsellAnalyticsEvent placeTipsUpsellAnalyticsEvent) {
        m21335a(placeTipsUpsellAnalyticsEvent, null, null);
    }

    public final void m21333a(GoogleLocationDialogResult googleLocationDialogResult) {
        switch (1.a[googleLocationDialogResult.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m21334a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_SUCCESS);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m21334a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_FAILED);
                return;
            case 3:
                m21334a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_NOT_NEEDED);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                m21334a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_NOT_POSSIBLE);
                return;
            default:
                return;
        }
    }

    public final void m21335a(PlaceTipsUpsellAnalyticsEvent placeTipsUpsellAnalyticsEvent, @Nullable Throwable th, @Nullable Map<String, String> map) {
        if (placeTipsUpsellAnalyticsEvent != PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_FEED_UNIT_VPV || !this.f14890d.m21339a()) {
            HoneyAnalyticsEvent createHoneyClientEvent = placeTipsUpsellAnalyticsEvent.createHoneyClientEvent();
            long now = this.f14889c.now();
            createHoneyClientEvent.m5090b("session_id", this.f14890d.m21337a(placeTipsUpsellAnalyticsEvent));
            createHoneyClientEvent.m5084a("wall_time", this.f14888b.mo211a());
            createHoneyClientEvent.m5084a("up_time", now);
            createHoneyClientEvent.m5088a((Map) map);
            if (th != null) {
                createHoneyClientEvent.m5090b("fail_exception", th.getClass().getName());
                createHoneyClientEvent.m5090b("fail_exception_message", th.getMessage());
                createHoneyClientEvent.m5090b("fail_exception_stack_trace", ExceptionUtil.a(th));
            }
            ((AnalyticsLogger) this.f14887a.get()).mo526a(createHoneyClientEvent);
        }
    }
}
