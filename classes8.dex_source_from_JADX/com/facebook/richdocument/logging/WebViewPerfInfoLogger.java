package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.device.DeviceMemoryInfoReader;
import com.facebook.device.DeviceMemoryInfoReaderMethodAutoProvider;
import com.facebook.device.MemoryInfoCompat;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placeRatingCount */
public class WebViewPerfInfoLogger {
    private static WebViewPerfInfoLogger f5597g;
    private static final Object f5598h = new Object();
    public final Map<String, WebViewPerfEventInfo> f5599a = new HashMap();
    private final RichDocumentAnalyticsLogger f5600b;
    public final MonotonicClock f5601c;
    private final DeviceMemoryInfoReader f5602d;
    private final GatekeeperStoreImpl f5603e;
    private final boolean f5604f;

    /* compiled from: placeRatingCount */
    enum MemorySnapshotTime {
        LOAD_START,
        LOAD_FINISH
    }

    /* compiled from: placeRatingCount */
    public class WebViewPerfEventInfo {
        final int f5581a;
        final GraphQLDocumentWebviewPresentationStyle f5582b;
        boolean f5583c;
        boolean f5584d;
        long f5585e;
        long f5586f;
        long f5587g;
        public long f5588h;
        public long f5589i;
        public long f5590j;
        long f5591k;
        long f5592l;
        long f5593m;
        long f5594n;
        boolean f5595o;
        boolean f5596p;

        public WebViewPerfEventInfo(int i, GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle) {
            this.f5581a = i;
            this.f5582b = graphQLDocumentWebviewPresentationStyle;
        }

        final boolean m5417a() {
            return this.f5587g == 0;
        }

        public final boolean m5418b() {
            return this.f5585e > 0 && this.f5586f > 0 && this.f5587g > 0;
        }

        final float m5419c() {
            return (1.0f * ((float) (this.f5586f - this.f5585e))) / 1000.0f;
        }

        final float m5420d() {
            return (1.0f * ((float) (this.f5587g - this.f5586f))) / 1000.0f;
        }

        final float m5421e() {
            return (1.0f * ((float) (this.f5589i - this.f5588h))) / 1000.0f;
        }

        final float m5416a(long j) {
            if (this.f5588h <= 0) {
                return 0.0f;
            }
            if (this.f5590j <= 0) {
                return m5415a((((float) (j - this.f5588h)) * 1.0f) / 1000.0f);
            }
            return m5415a((((float) (this.f5590j - this.f5588h)) * 1.0f) / 1000.0f);
        }

        private static float m5415a(float f) {
            return f < 0.0f ? 0.0f : f;
        }
    }

    private static WebViewPerfInfoLogger m5424b(InjectorLike injectorLike) {
        return new WebViewPerfInfoLogger(RichDocumentAnalyticsLogger.m5360a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), DeviceMemoryInfoReaderMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public WebViewPerfInfoLogger(RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, MonotonicClock monotonicClock, DeviceMemoryInfoReader deviceMemoryInfoReader, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f5600b = richDocumentAnalyticsLogger;
        this.f5601c = monotonicClock;
        this.f5602d = deviceMemoryInfoReader;
        this.f5603e = gatekeeperStoreImpl;
        this.f5604f = this.f5603e.a(705, false);
    }

    public final void m5425a(String str) {
        if (!StringUtil.c(str) && this.f5599a.containsKey(str)) {
            WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) this.f5599a.get(str);
            if (webViewPerfEventInfo.m5417a()) {
                webViewPerfEventInfo.f5585e = this.f5601c.now();
            }
        }
    }

    public static WebViewPerfInfoLogger m5422a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WebViewPerfInfoLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5598h) {
                WebViewPerfInfoLogger webViewPerfInfoLogger;
                if (a2 != null) {
                    webViewPerfInfoLogger = (WebViewPerfInfoLogger) a2.a(f5598h);
                } else {
                    webViewPerfInfoLogger = f5597g;
                }
                if (webViewPerfInfoLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5598h, b3);
                        } else {
                            f5597g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = webViewPerfInfoLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5427b(String str) {
        if (!StringUtil.c(str) && this.f5599a.containsKey(str)) {
            WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) this.f5599a.get(str);
            if (webViewPerfEventInfo.m5417a()) {
                webViewPerfEventInfo.f5586f = this.f5601c.now();
                m5423a(MemorySnapshotTime.LOAD_START, webViewPerfEventInfo);
            }
        }
    }

    public final void m5428c(String str) {
        if (!StringUtil.c(str) && this.f5599a.containsKey(str)) {
            WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) this.f5599a.get(str);
            if (webViewPerfEventInfo.m5417a()) {
                webViewPerfEventInfo.f5587g = this.f5601c.now();
                m5423a(MemorySnapshotTime.LOAD_FINISH, webViewPerfEventInfo);
            }
        }
    }

    public final void m5429g(String str) {
        if (!StringUtil.c(str) && this.f5599a.containsKey(str)) {
            ((WebViewPerfEventInfo) this.f5599a.get(str)).f5583c = true;
        }
    }

    public final void m5430h(String str) {
        if (!StringUtil.c(str) && this.f5599a.containsKey(str)) {
            ((WebViewPerfEventInfo) this.f5599a.get(str)).f5584d = true;
        }
    }

    private void m5423a(MemorySnapshotTime memorySnapshotTime, WebViewPerfEventInfo webViewPerfEventInfo) {
        if (this.f5604f) {
            MemoryInfoCompat a = this.f5602d.a();
            if (memorySnapshotTime == MemorySnapshotTime.LOAD_START) {
                webViewPerfEventInfo.f5591k = a.a();
                webViewPerfEventInfo.f5593m = a.b;
                webViewPerfEventInfo.f5594n = a.c();
                webViewPerfEventInfo.f5595o = a.d();
            } else if (memorySnapshotTime == MemorySnapshotTime.LOAD_FINISH) {
                webViewPerfEventInfo.f5592l = a.a();
                webViewPerfEventInfo.f5596p = a.d();
            }
        }
    }

    public final void m5426b() {
        for (Entry entry : this.f5599a.entrySet()) {
            WebViewPerfEventInfo webViewPerfEventInfo = (WebViewPerfEventInfo) entry.getValue();
            String str = (String) entry.getKey();
            if (webViewPerfEventInfo.m5418b() && !webViewPerfEventInfo.f5584d) {
                Map hashMap = new HashMap();
                hashMap.put("block_id", str);
                hashMap.put("block_index_in_article", Integer.valueOf(webViewPerfEventInfo.f5581a));
                hashMap.put("webview_type", webViewPerfEventInfo.f5582b);
                hashMap.put("queue_time", Float.valueOf(webViewPerfEventInfo.m5419c()));
                hashMap.put("download_time", Float.valueOf(webViewPerfEventInfo.m5420d()));
                hashMap.put("onscreen_time", Float.valueOf(webViewPerfEventInfo.m5421e()));
                hashMap.put("user_wait_time_seconds", Float.valueOf(webViewPerfEventInfo.m5416a(this.f5601c.now())));
                hashMap.put("did_see_content", Boolean.valueOf(webViewPerfEventInfo.f5590j > 0));
                hashMap.put("onscreen_time", Float.valueOf(webViewPerfEventInfo.m5421e()));
                hashMap.put("failures_occurred", Boolean.valueOf(webViewPerfEventInfo.f5583c));
                hashMap.put("queue_start_timestamp", Long.valueOf(webViewPerfEventInfo.f5585e));
                hashMap.put("download_start_timestamp", Long.valueOf(webViewPerfEventInfo.f5586f));
                hashMap.put("finished_downloading_raw_time", Long.valueOf(webViewPerfEventInfo.f5587g));
                hashMap.put("onscreen_raw_time", Long.valueOf(webViewPerfEventInfo.f5588h));
                hashMap.put("offscreen_raw_time", Long.valueOf(webViewPerfEventInfo.f5589i));
                if (webViewPerfEventInfo.f5590j > 0) {
                    hashMap.put("first_frame_render_time", Long.valueOf(webViewPerfEventInfo.f5590j));
                }
                if (this.f5604f) {
                    hashMap.put("load_start_available_memory", Long.valueOf(webViewPerfEventInfo.f5591k));
                    hashMap.put("load_finish_available_memory", Long.valueOf(webViewPerfEventInfo.f5592l));
                    hashMap.put("total_memory", Long.valueOf(webViewPerfEventInfo.f5593m));
                    hashMap.put("low_memory_threshold", Long.valueOf(webViewPerfEventInfo.f5594n));
                    hashMap.put("load_start_low_memory", Boolean.valueOf(webViewPerfEventInfo.f5595o));
                    hashMap.put("load_finish_low_memory", Boolean.valueOf(webViewPerfEventInfo.f5596p));
                }
                this.f5600b.m5371c("android_native_article_webview_perf", hashMap);
            }
        }
        this.f5599a.clear();
    }
}
