package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.ThirdPartyTrackerHandler.TrackerType;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentBlocksAppendedSubscriber;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFirstRenderSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFirstRenderEvent;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.WebViewBlockDataImpl;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.json.JSONObject;

@ContextScoped
/* compiled from: place_picked */
public class RichDocumentPerfInfoLogger {
    public static boolean f5526w = true;
    private static RichDocumentPerfInfoLogger f5527y;
    private static final Object f5528z = new Object();
    public final GatekeeperStoreImpl f5529a;
    public final MonotonicClock f5530b;
    private final RichDocumentAnalyticsLogger f5531c;
    public final RichDocumentEventBus f5532d;
    private final RichDocumentScrollDepthLogger f5533e;
    public final HashMap<GraphQLDocumentWebviewPresentationStyle, Integer> f5534f = new HashMap();
    private final Map<String, TrackerInfo> f5535g = new HashMap();
    private final RichDocumentBlocksAppendedSubscriber f5536h = new C07111(this);
    private final RichDocumentFirstRenderSubscriber f5537i = new C07122(this);
    public long f5538j;
    private boolean f5539k = false;
    public String f5540l;
    public long f5541m;
    public long f5542n = -1;
    public DataFreshnessResult f5543o;
    public boolean f5544p;
    public int f5545q;
    public long f5546r;
    public final ConnectionQuality f5547s;
    public boolean f5548t = false;
    public boolean f5549u;
    private long f5550v;
    public String f5551x;

    /* compiled from: place_picked */
    class C07111 extends RichDocumentBlocksAppendedSubscriber {
        final /* synthetic */ RichDocumentPerfInfoLogger f5519a;

        C07111(RichDocumentPerfInfoLogger richDocumentPerfInfoLogger) {
            this.f5519a = richDocumentPerfInfoLogger;
        }

        public final void m5386b(FbEvent fbEvent) {
            boolean z;
            RichDocumentBlocksAppendedEvent richDocumentBlocksAppendedEvent = (RichDocumentBlocksAppendedEvent) fbEvent;
            this.f5519a.f5543o = richDocumentBlocksAppendedEvent.f5168b;
            RichDocumentPerfInfoLogger richDocumentPerfInfoLogger = this.f5519a;
            RichDocumentBlocksImpl richDocumentBlocksImpl = richDocumentBlocksAppendedEvent.f5167a;
            richDocumentPerfInfoLogger.f5534f.clear();
            richDocumentPerfInfoLogger.f5545q = 0;
            int c = richDocumentBlocksImpl.m5459c();
            for (int i = 0; i < c; i++) {
                BlockData a = richDocumentBlocksImpl.m5457a(i);
                if (a.mo272n() == 8 && (a instanceof WebViewBlockDataImpl)) {
                    GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle = ((WebViewBlockDataImpl) a).f5803g;
                    if (graphQLDocumentWebviewPresentationStyle != null) {
                        int intValue;
                        if (richDocumentPerfInfoLogger.f5534f.containsKey(graphQLDocumentWebviewPresentationStyle)) {
                            intValue = ((Integer) richDocumentPerfInfoLogger.f5534f.get(graphQLDocumentWebviewPresentationStyle)).intValue();
                        } else {
                            intValue = 0;
                        }
                        richDocumentPerfInfoLogger.f5534f.put(graphQLDocumentWebviewPresentationStyle, Integer.valueOf(intValue + 1));
                        richDocumentPerfInfoLogger.f5545q++;
                    }
                }
            }
            RichDocumentPerfInfoLogger richDocumentPerfInfoLogger2 = this.f5519a;
            if (this.f5519a.f5543o != DataFreshnessResult.FROM_SERVER) {
                z = true;
            } else {
                z = false;
            }
            richDocumentPerfInfoLogger2.f5544p = z;
            this.f5519a.f5548t = richDocumentBlocksAppendedEvent.f5169c;
            this.f5519a.f5532d.b(this);
        }
    }

    /* compiled from: place_picked */
    class C07122 extends RichDocumentFirstRenderSubscriber {
        final /* synthetic */ RichDocumentPerfInfoLogger f5520a;

        C07122(RichDocumentPerfInfoLogger richDocumentPerfInfoLogger) {
            this.f5520a = richDocumentPerfInfoLogger;
        }

        public final void m5387b(FbEvent fbEvent) {
            RichDocumentFirstRenderEvent richDocumentFirstRenderEvent = (RichDocumentFirstRenderEvent) fbEvent;
            TracerDetour.a("RichDocumentPerfInfoLogger#recordTTI", 1022164234);
            this.f5520a.f5542n = richDocumentFirstRenderEvent.f5174b;
            this.f5520a.f5541m = richDocumentFirstRenderEvent.f5173a - this.f5520a.f5538j;
            this.f5520a.f5549u = RichDocumentPerfInfoLogger.f5526w;
            RichDocumentPerfInfoLogger.f5526w = false;
            TracerDetour.a(1469793290);
        }
    }

    /* compiled from: place_picked */
    class TrackerInfo {
        int f5521a;
        final long f5522b;
        final TrackerType f5523c;
        final /* synthetic */ RichDocumentPerfInfoLogger f5524d;
        public TrackerState f5525e = TrackerState.LOADING;

        public TrackerInfo(RichDocumentPerfInfoLogger richDocumentPerfInfoLogger, TrackerType trackerType) {
            this.f5524d = richDocumentPerfInfoLogger;
            this.f5522b = richDocumentPerfInfoLogger.f5530b.now();
            this.f5523c = trackerType;
        }

        public final JSONObject m5389a() {
            Map hashMap = new HashMap();
            hashMap.put("progress", Integer.valueOf(this.f5521a));
            hashMap.put("time_spent_loading", Long.valueOf(this.f5524d.f5530b.now() - this.f5522b));
            hashMap.put("tracker_type", this.f5523c.name());
            return new JSONObject(hashMap);
        }
    }

    /* compiled from: place_picked */
    enum TrackerState {
        LOADING,
        FAILED,
        SUCCESS
    }

    private static RichDocumentPerfInfoLogger m5391b(InjectorLike injectorLike) {
        return new RichDocumentPerfInfoLogger(RichDocumentEventBus.m5130a(injectorLike), (Context) injectorLike.getInstance(Context.class), RichDocumentAnalyticsLogger.m5360a(injectorLike), RichDocumentScrollDepthLogger.m5398a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ConnectionQualityMonitor.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public static RichDocumentPerfInfoLogger m5390a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentPerfInfoLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5528z) {
                RichDocumentPerfInfoLogger richDocumentPerfInfoLogger;
                if (a2 != null) {
                    richDocumentPerfInfoLogger = (RichDocumentPerfInfoLogger) a2.a(f5528z);
                } else {
                    richDocumentPerfInfoLogger = f5527y;
                }
                if (richDocumentPerfInfoLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5391b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5528z, b3);
                        } else {
                            f5527y = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentPerfInfoLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RichDocumentPerfInfoLogger(RichDocumentEventBus richDocumentEventBus, Context context, RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, RichDocumentScrollDepthLogger richDocumentScrollDepthLogger, MonotonicClock monotonicClock, ConnectionQualityMonitor connectionQualityMonitor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f5530b = monotonicClock;
        this.f5532d = richDocumentEventBus;
        this.f5531c = richDocumentAnalyticsLogger;
        this.f5533e = richDocumentScrollDepthLogger;
        this.f5532d.a(this.f5537i);
        this.f5532d.a(this.f5536h);
        this.f5547s = connectionQualityMonitor.a();
        this.f5529a = gatekeeperStoreImpl;
    }

    public final synchronized void m5395a(String str, TrackerType trackerType) {
        this.f5535g.put(str, new TrackerInfo(this, trackerType));
    }

    public final synchronized void m5394a(String str) {
        if (this.f5535g.containsKey(str)) {
            ((TrackerInfo) this.f5535g.get(str)).f5525e = TrackerState.SUCCESS;
            for (Entry value : this.f5535g.entrySet()) {
                if (((TrackerInfo) value.getValue()).f5525e != TrackerState.SUCCESS) {
                    break;
                }
            }
            this.f5550v = this.f5530b.now() - this.f5538j;
        }
    }

    public final synchronized void m5396b(String str) {
        if (this.f5535g.containsKey(str)) {
            ((TrackerInfo) this.f5535g.get(str)).f5525e = TrackerState.FAILED;
        }
    }

    public final void m5393a() {
        boolean z = false;
        if (!this.f5539k && !StringUtil.a(this.f5540l)) {
            Map hashMap = new HashMap();
            hashMap.put("TTI", Long.valueOf(this.f5541m));
            hashMap.put("render_time", Long.valueOf(this.f5542n));
            hashMap.put("did_generate_story_view", Boolean.valueOf(this.f5542n != -1));
            hashMap.put("webview_breakdown", this.f5534f);
            hashMap.put("webview_total", Integer.valueOf(this.f5545q));
            hashMap.put("data_freshness", this.f5543o);
            if (this.f5543o != DataFreshnessResult.FROM_SERVER) {
                z = this.f5544p;
            }
            hashMap.put("cached", Boolean.valueOf(z));
            hashMap.put("percent_scrolled", Float.valueOf(this.f5533e.m5401b()));
            hashMap.put("total_time_open", Long.valueOf(this.f5530b.now() - this.f5546r));
            hashMap.put("connection_quality_at_start", this.f5547s);
            hashMap.put("fetched_from_memory_cache", Boolean.valueOf(this.f5548t));
            if (this.f5529a.a(687, false)) {
                hashMap.putAll(m5392f());
            }
            hashMap.put("first_open_since_start", Boolean.valueOf(this.f5549u));
            hashMap.put("click_source", this.f5551x);
            this.f5531c.m5371c("android_native_article_perf", hashMap);
            this.f5539k = true;
        }
    }

    private Map<String, Object> m5392f() {
        Map<String, Object> hashMap = new HashMap();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Map hashMap2 = new HashMap();
        boolean z = true;
        for (Entry entry : this.f5535g.entrySet()) {
            String str = (String) entry.getKey();
            TrackerInfo trackerInfo = (TrackerInfo) entry.getValue();
            if (trackerInfo.f5525e == TrackerState.FAILED) {
                arrayList.add(str);
                z = false;
            } else {
                boolean z2;
                if (trackerInfo.f5525e == TrackerState.LOADING) {
                    arrayList2.add(str);
                    hashMap2.put(str, trackerInfo.m5389a());
                    z2 = false;
                } else {
                    z2 = z;
                }
                z = z2;
            }
        }
        hashMap.put("tracker_count", Integer.valueOf(this.f5535g.size()));
        hashMap.put("trackers_all_loaded", Boolean.valueOf(z));
        hashMap.put("trackers_that_failed", arrayList);
        hashMap.put("unfinished_trackers", arrayList2);
        hashMap.put("trackers_finished_duration", Long.valueOf(this.f5550v));
        hashMap.put("unfinished_tracker_info", hashMap2);
        return hashMap;
    }
}
