package com.facebook.placetips.logging;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.bootstrap.data.BleBroadcastSummary;
import com.facebook.placetips.bootstrap.data.BleScanResult;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceChangedEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceStayedTheSameEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.EnumMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_story_freshness_delta_minutes */
public class PlaceTipsAnalyticsLogger {
    private static volatile PlaceTipsAnalyticsLogger f14837g;
    private final Lazy<AnalyticsLogger> f14838a;
    private final Clock f14839b;
    private final MonotonicClock f14840c;
    private final PlaceTipsLocalLogger f14841d;
    private final EnumMap<PresenceSourceType, Session> f14842e = Maps.m811a(PresenceSourceType.class);
    private long f14843f = 0;

    public static com.facebook.placetips.logging.PlaceTipsAnalyticsLogger m21246a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14837g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.logging.PlaceTipsAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f14837g;	 Catch:{ all -> 0x003a }
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
        r0 = m21251b(r0);	 Catch:{ all -> 0x0035 }
        f14837g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14837g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.logging.PlaceTipsAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.placetips.logging.PlaceTipsAnalyticsLogger");
    }

    private static PlaceTipsAnalyticsLogger m21251b(InjectorLike injectorLike) {
        return new PlaceTipsAnalyticsLogger(IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), SystemClockMethodAutoProvider.m1498a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), PlaceTipsLocalLoggerImpl.m4594a(injectorLike));
    }

    @Inject
    public PlaceTipsAnalyticsLogger(Lazy<AnalyticsLogger> lazy, Clock clock, MonotonicClock monotonicClock, PlaceTipsLocalLogger placeTipsLocalLogger) {
        this.f14838a = lazy;
        this.f14839b = clock;
        this.f14840c = monotonicClock;
        this.f14841d = placeTipsLocalLogger;
    }

    public final void m21256a(PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent, PresenceSourceType presenceSourceType) {
        m21258a(placeTipsAnalyticsEvent, presenceSourceType, null);
    }

    public final void m21258a(PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent, PresenceSourceType presenceSourceType, @Nullable Throwable th) {
        HoneyClientEvent createHoneyClientEvent = placeTipsAnalyticsEvent.createHoneyClientEvent();
        if (th != null) {
            createHoneyClientEvent.m5090b("fail_exception", th.getClass().getName());
            createHoneyClientEvent.m5090b("fail_exception_message", th.getMessage());
            createHoneyClientEvent.m5090b("fail_exception_stack_trace", ExceptionUtil.a(th));
        }
        m21250a(placeTipsAnalyticsEvent, createHoneyClientEvent, presenceSourceType);
        if (th == null) {
            return;
        }
        if (th instanceof PlaceTipsEmptyResponseException) {
            this.f14841d.mo654a("%s event included throwable: %s", placeTipsAnalyticsEvent, th.getMessage());
            return;
        }
        this.f14841d.mo656a(th, "%s event included throwable", placeTipsAnalyticsEvent);
    }

    public final void m21259a(String str, PresenceSourceType presenceSourceType) {
        m21245a(presenceSourceType, false, this.f14840c.now()).c = str;
        this.f14841d.mo654a("Updated logging id for %s to %s", presenceSourceType, str);
    }

    public final void m21257a(PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent, PresenceSourceType presenceSourceType, String str, boolean z) {
        HoneyClientEvent createHoneyClientEvent = placeTipsAnalyticsEvent.createHoneyClientEvent();
        createHoneyClientEvent.m5090b("page_id", str);
        createHoneyClientEvent.m5087a("has_question", z);
        m21250a(placeTipsAnalyticsEvent, createHoneyClientEvent, presenceSourceType);
    }

    public final void m21254a(BleScanResult bleScanResult) {
        PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent = PlaceTipsAnalyticsEvent.END_BLE_SCAN_SUCCESS;
        HoneyClientEvent createHoneyClientEvent = placeTipsAnalyticsEvent.createHoneyClientEvent();
        createHoneyClientEvent.m5085a("ble_scan_result", m21252b(bleScanResult));
        m21250a(placeTipsAnalyticsEvent, createHoneyClientEvent, PresenceSourceType.BLE);
    }

    public final void m21255a(PlaceTipsPresenceEvent placeTipsPresenceEvent, PresenceSourceType presenceSourceType) {
        if (placeTipsPresenceEvent instanceof PlaceTipsPresenceStayedTheSameEvent) {
            m21249a((PlaceTipsPresenceStayedTheSameEvent) placeTipsPresenceEvent, presenceSourceType);
        } else if (placeTipsPresenceEvent instanceof PlaceTipsPresenceChangedEvent) {
            m21248a((PlaceTipsPresenceChangedEvent) placeTipsPresenceEvent, presenceSourceType);
        } else {
            throw new IllegalArgumentException("Unknown PlaceTipsPresenceEvent");
        }
        if (placeTipsPresenceEvent.mo658d().isPresent()) {
            this.f14841d.mo654a("Confidence Level: %s", ((PresenceDescription) placeTipsPresenceEvent.mo658d().get()).q());
        }
    }

    public final void m21260b(String str, PresenceSourceType presenceSourceType) {
        PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent = PlaceTipsAnalyticsEvent.START_PAGE_LOOKUP;
        HoneyClientEvent createHoneyClientEvent = placeTipsAnalyticsEvent.createHoneyClientEvent();
        createHoneyClientEvent.m5090b("input_params", str);
        m21250a(placeTipsAnalyticsEvent, createHoneyClientEvent, presenceSourceType);
    }

    public final void m21253a(PresenceSourceType presenceSourceType) {
        PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent = PlaceTipsAnalyticsEvent.END_PAGE_LOOKUP_SUCCESS;
        m21250a(placeTipsAnalyticsEvent, placeTipsAnalyticsEvent.createHoneyClientEvent(), presenceSourceType);
    }

    private void m21249a(PlaceTipsPresenceStayedTheSameEvent placeTipsPresenceStayedTheSameEvent, PresenceSourceType presenceSourceType) {
        PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent = PlaceTipsAnalyticsEvent.PRESENCE_STAYED_THE_SAME;
        HoneyClientEvent createHoneyClientEvent = placeTipsAnalyticsEvent.createHoneyClientEvent();
        createHoneyClientEvent.m5085a("current_presence", m21247a(placeTipsPresenceStayedTheSameEvent.mo658d()));
        m21250a(placeTipsAnalyticsEvent, createHoneyClientEvent, presenceSourceType);
    }

    private void m21248a(PlaceTipsPresenceChangedEvent placeTipsPresenceChangedEvent, PresenceSourceType presenceSourceType) {
        PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent = PlaceTipsAnalyticsEvent.PRESENCE_CHANGED;
        HoneyClientEvent createHoneyClientEvent = placeTipsAnalyticsEvent.createHoneyClientEvent();
        createHoneyClientEvent.m5085a("previous_presence", m21247a(placeTipsPresenceChangedEvent.f2415a));
        createHoneyClientEvent.m5085a("current_presence", m21247a(placeTipsPresenceChangedEvent.f2416b));
        m21250a(placeTipsAnalyticsEvent, createHoneyClientEvent, presenceSourceType);
    }

    private static JsonNode m21252b(BleScanResult bleScanResult) {
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5130a("scan_start_time", bleScanResult.b);
        objectNode.m5130a("scan_end_time", bleScanResult.c);
        objectNode.m5130a("scan_duration", bleScanResult.d);
        ImmutableList immutableList = bleScanResult.a;
        if (immutableList.isEmpty()) {
            objectNode.m5129a("total_ble_devices_found", 0);
            objectNode.m5129a("total_ble_detection_events", 0);
            objectNode.m5152l("ble_devices_found");
        } else {
            objectNode.m5129a("total_ble_devices_found", immutableList.size());
            objectNode.m5129a("total_ble_detection_events", bleScanResult.e);
            ArrayNode j = objectNode.m5148j("ble_devices_found");
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                BleBroadcastSummary bleBroadcastSummary = (BleBroadcastSummary) immutableList.get(i);
                ObjectNode I = j.m13375I();
                I.m5137a("mac_address", bleBroadcastSummary.a.a.getAddress());
                I.m5137a("broadcast_data", bleBroadcastSummary.a.c);
                I.m5129a("detection_event_count", bleBroadcastSummary.c());
                I.m5129a("avg_rssi", bleBroadcastSummary.b());
            }
        }
        return objectNode;
    }

    private static JsonNode m21247a(Optional<PresenceDescription> optional) {
        if (!optional.isPresent()) {
            return null;
        }
        PresenceDescription presenceDescription = (PresenceDescription) optional.get();
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("page_id", presenceDescription.i());
        objectNode.m5137a("page_name", presenceDescription.h());
        return objectNode;
    }

    private void m21250a(PlaceTipsAnalyticsEvent placeTipsAnalyticsEvent, HoneyClientEvent honeyClientEvent, PresenceSourceType presenceSourceType) {
        long now = this.f14840c.now();
        Session a = m21245a(presenceSourceType, placeTipsAnalyticsEvent.shouldResetSession(), now);
        honeyClientEvent.m5090b("session_token", a.a.toString());
        honeyClientEvent.m5084a("wall_time", this.f14839b.mo211a());
        honeyClientEvent.m5084a("up_time", now);
        honeyClientEvent.m5090b("trigger", presenceSourceType.getNameForAnalytics());
        honeyClientEvent.m5084a("time_since_session_start", now - this.f14843f);
        if (a.c != null) {
            honeyClientEvent.m5090b("logging_id", a.c);
        }
        ((AnalyticsLogger) this.f14838a.get()).mo526a((HoneyAnalyticsEvent) honeyClientEvent);
        this.f14841d.mo654a("Logged analytics event: %s, source: %s", placeTipsAnalyticsEvent, presenceSourceType);
    }

    private synchronized Session m21245a(PresenceSourceType presenceSourceType, boolean z, long j) {
        Session session;
        session = (Session) this.f14842e.get(presenceSourceType);
        if (z || session == null) {
            session = new Session(j);
            this.f14842e.put(presenceSourceType, session);
            this.f14841d.mo654a("New analytics session for source: %s", presenceSourceType);
        }
        return session;
    }
}
