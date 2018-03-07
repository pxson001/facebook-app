package com.facebook.richdocument.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
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
/* compiled from: place_review_ego_launched_review_composer */
public class NativeAdsPerfInfoLogger {
    private static NativeAdsPerfInfoLogger f5481d;
    private static final Object f5482e = new Object();
    public final Map<String, NativeAdsPerfEventInfo> f5483a = new HashMap();
    private final RichDocumentAnalyticsLogger f5484b;
    public final MonotonicClock f5485c;

    /* compiled from: place_review_ego_launched_review_composer */
    public class NativeAdsPerfEventInfo {
        public boolean f5473a;
        public long f5474b;
        public long f5475c;
        public long f5476d;
        public long f5477e;
        public long f5478f;
        public long f5479g;
        public long f5480h;

        public final boolean m5352a() {
            return this.f5475c == 0;
        }

        public final boolean m5353b() {
            return this.f5474b > 0 && this.f5475c > 0;
        }

        final float m5354c() {
            return (1.0f * ((float) (this.f5475c - this.f5474b))) / 1000.0f;
        }

        final float m5355d() {
            return (1.0f * ((float) (this.f5479g - this.f5478f))) / 1000.0f;
        }
    }

    private static NativeAdsPerfInfoLogger m5357b(InjectorLike injectorLike) {
        return new NativeAdsPerfInfoLogger(RichDocumentAnalyticsLogger.m5360a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NativeAdsPerfInfoLogger(RichDocumentAnalyticsLogger richDocumentAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f5484b = richDocumentAnalyticsLogger;
        this.f5485c = monotonicClock;
    }

    public final void m5359a(String str) {
        if (!StringUtil.c(str)) {
            this.f5483a.put(str, new NativeAdsPerfEventInfo());
        }
    }

    public static NativeAdsPerfInfoLogger m5356a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NativeAdsPerfInfoLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5482e) {
                NativeAdsPerfInfoLogger nativeAdsPerfInfoLogger;
                if (a2 != null) {
                    nativeAdsPerfInfoLogger = (NativeAdsPerfInfoLogger) a2.a(f5482e);
                } else {
                    nativeAdsPerfInfoLogger = f5481d;
                }
                if (nativeAdsPerfInfoLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5357b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5482e, b3);
                        } else {
                            f5481d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nativeAdsPerfInfoLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5358a() {
        for (Entry entry : this.f5483a.entrySet()) {
            NativeAdsPerfEventInfo nativeAdsPerfEventInfo = (NativeAdsPerfEventInfo) entry.getValue();
            String str = (String) entry.getKey();
            if (nativeAdsPerfEventInfo.m5353b()) {
                Map hashMap = new HashMap();
                hashMap.put("block_id", str);
                hashMap.put("download_time", Float.valueOf(nativeAdsPerfEventInfo.m5354c()));
                hashMap.put("onscreen_time", Float.valueOf(nativeAdsPerfEventInfo.m5355d()));
                hashMap.put("did_see_content", Boolean.valueOf(nativeAdsPerfEventInfo.f5480h > 0));
                hashMap.put("onscreen_time", Float.valueOf(nativeAdsPerfEventInfo.m5355d()));
                hashMap.put("failures_occurred", Boolean.valueOf(nativeAdsPerfEventInfo.f5473a));
                hashMap.put("started_loading_raw_time", Long.valueOf(nativeAdsPerfEventInfo.f5474b));
                hashMap.put("finished_loading_raw_time", Long.valueOf(nativeAdsPerfEventInfo.f5475c));
                hashMap.put("download_start_timestamp", Long.valueOf(nativeAdsPerfEventInfo.f5476d));
                hashMap.put("finished_downloading_raw_time", Long.valueOf(nativeAdsPerfEventInfo.f5477e));
                hashMap.put("onscreen_raw_time", Long.valueOf(nativeAdsPerfEventInfo.f5478f));
                hashMap.put("offscreen_raw_time", Long.valueOf(nativeAdsPerfEventInfo.f5479g));
                if (nativeAdsPerfEventInfo.f5480h > 0) {
                    hashMap.put("first_frame_render_time", Long.valueOf(nativeAdsPerfEventInfo.f5480h));
                }
                this.f5484b.m5371c("android_native_article_native_ad_perf", hashMap);
            }
        }
        this.f5483a.clear();
    }
}
