package com.facebook.debug.fps;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;
import com.facebook.debug.fps.frameblame.GcFrameBlameMarker;
import com.facebook.feed.rows.FeedFrameRateLogger.C04701;
import com.facebook.inject.Assisted;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: old_like_count */
public class FrameRateLogger implements FpsListener {
    public static final String[] f11256a = new String[]{"percent_time_dropped_frames_0", "percent_time_dropped_frames_1", "percent_time_dropped_frames_2+"};
    @VisibleForTesting
    public WeakReference<Object> f11257b;
    private final ExecutorService f11258c;
    private final AnalyticsLogger f11259d;
    private final FPSController f11260e;
    private final DisplayUtil f11261f;
    private final ScrollPerfRunnable f11262g;
    private final FrameRateBlameMarkers f11263h;
    public final String f11264i;
    public final String f11265j;
    public final SkippedFrameData f11266k = new SkippedFrameData();
    public final String[] f11267l = new String[(Priority.values().length * 2)];
    public final TimeSinceTTI f11268m;
    public BaseFrameRateLoggerCallback f11269n = new C04701(this);
    public HoneyClientEventFast f11270o;
    public long f11271p;
    public boolean f11272q = false;
    private int f11273r = 0;
    public float f11274s = 0.0f;
    public float f11275t = 0.0f;
    public int f11276u;
    public long f11277v;
    public Map<Marker, Integer> f11278w;
    public Map<Marker, Integer> f11279x;
    public Map<Marker, Integer> f11280y;
    private Future f11281z;

    /* compiled from: old_like_count */
    public class SkippedFrameData {
        public int f11284a;
        public float f11285b;
        public float f11286c;
        public float f11287d;
        public long f11288e;
        public final long[] f11289f = new long[FrameRateLogger.f11256a.length];

        static /* synthetic */ float m16580a(SkippedFrameData skippedFrameData, double d) {
            float f = (float) (((double) skippedFrameData.f11286c) + d);
            skippedFrameData.f11286c = f;
            return f;
        }

        static /* synthetic */ float m16581a(SkippedFrameData skippedFrameData, float f) {
            float f2 = skippedFrameData.f11285b + f;
            skippedFrameData.f11285b = f2;
            return f2;
        }

        static /* synthetic */ long m16582a(SkippedFrameData skippedFrameData, long j) {
            long j2 = skippedFrameData.f11288e + j;
            skippedFrameData.f11288e = j2;
            return j2;
        }

        static /* synthetic */ float m16583b(SkippedFrameData skippedFrameData, double d) {
            float f = (float) (((double) skippedFrameData.f11287d) + d);
            skippedFrameData.f11287d = f;
            return f;
        }
    }

    /* compiled from: old_like_count */
    public class ScrollPerfRunnable extends NamedRunnable {
        public final /* synthetic */ FrameRateLogger f11308c;

        public ScrollPerfRunnable(FrameRateLogger frameRateLogger) {
            this.f11308c = frameRateLogger;
            super(ScrollPerfRunnable.class, "ScrollPerfRunnable");
        }

        public void run() {
            HoneyClientEventFast honeyClientEventFast = this.f11308c.f11270o;
            honeyClientEventFast.m17379a(this.f11308c.f11265j);
            honeyClientEventFast.m17385a("action", this.f11308c.f11264i);
            honeyClientEventFast.m17382a("total_time_spent", this.f11308c.f11271p);
            String str = "time_since_startup";
            TimeSinceTTI timeSinceTTI = this.f11308c.f11268m;
            long j = 0;
            if (timeSinceTTI.f9597a != 0) {
                j = (timeSinceTTI.f9598b.now() - timeSinceTTI.f9597a) / 1000;
            }
            honeyClientEventFast.m17382a(str, j);
            m16604d(this.f11308c.f11270o);
            m16601a(this.f11308c.f11270o);
            honeyClientEventFast = this.f11308c.f11270o;
            if (this.f11308c.f11274s != this.f11308c.f11275t) {
                honeyClientEventFast.m17386a("fps_guessed", true);
            }
            honeyClientEventFast.m17381a("display_refresh_rate", (int) Math.floor((double) this.f11308c.f11274s));
            honeyClientEventFast.m17381a("sanitized_display_refresh_rate", (int) Math.floor((double) this.f11308c.f11275t));
            m16602a(this.f11308c.f11270o, 2);
            m16602a(this.f11308c.f11270o, 5);
            m16603c(this.f11308c.f11270o);
            honeyClientEventFast = this.f11308c.f11270o;
            if (DexLibLoader.deoptTaint) {
                honeyClientEventFast.m17385a("trace_tags", "dex_unopt");
            }
            if (this.f11308c.f11269n != null) {
                this.f11308c.f11269n.mo2126a(this.f11308c.f11270o);
            }
            this.f11308c.f11270o.m17390b();
            this.f11308c.f11270o = null;
            FrameRateLogger.m16570g(this.f11308c);
        }

        private void m16601a(HoneyClientEventFast honeyClientEventFast) {
            if (this.f11308c.f11276u > 0) {
                honeyClientEventFast.m17382a("avg_gc_time", (this.f11308c.f11277v * 10000) / ((long) this.f11308c.f11276u));
            }
            honeyClientEventFast.m17382a("percent_time_gc", (this.f11308c.f11277v * 10000) / this.f11308c.f11271p);
        }

        private void m16602a(HoneyClientEventFast honeyClientEventFast, int i) {
            Map map = i == 2 ? this.f11308c.f11278w : this.f11308c.f11279x;
            for (Marker marker : map.keySet()) {
                int ordinal = marker.mo2657b().ordinal() + ((i == 2 ? 0 : 1) * Priority.values().length);
                if (this.f11308c.f11267l[ordinal] == null) {
                    this.f11308c.f11267l[ordinal] = (i == 2 ? "percent_time_2+_dropped_with_" : "percent_time_5+_dropped_with_") + marker.mo2656a();
                }
                honeyClientEventFast.m17382a(this.f11308c.f11267l[ordinal], m16600a((long) ((Integer) map.get(marker)).intValue(), i));
            }
        }

        private void m16603c(HoneyClientEventFast honeyClientEventFast) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i = this.f11308c.f11266k.f11284a;
                int i2 = i;
                for (Marker marker : this.f11308c.f11280y.keySet()) {
                    int intValue = ((Integer) this.f11308c.f11280y.get(marker)).intValue();
                    jSONObject.put(marker.mo2656a(), intValue);
                    i2 -= intValue;
                }
                if (i2 > 0) {
                    jSONObject.put("unknown", i2);
                }
                honeyClientEventFast.m17385a("frame_drop_by_autoblame", jSONObject.toString());
            } catch (JSONException e) {
            }
        }

        private void m16604d(HoneyClientEventFast honeyClientEventFast) {
            honeyClientEventFast.m17381a("total_skipped_frames", this.f11308c.f11266k.f11284a);
            honeyClientEventFast.m17380a("1_frame_drop", (double) this.f11308c.f11266k.f11285b);
            honeyClientEventFast.m17380a("2_frame_drop", (double) this.f11308c.f11266k.f11286c);
            honeyClientEventFast.m17380a("4_frame_drop", (double) this.f11308c.f11266k.f11287d);
            honeyClientEventFast.m17382a("percent_time_dropped_frames_5+", (this.f11308c.f11266k.f11288e * 10000) / this.f11308c.f11271p);
            for (int i = 0; i < this.f11308c.f11266k.f11289f.length; i++) {
                honeyClientEventFast.m17382a(FrameRateLogger.f11256a[i], (this.f11308c.f11266k.f11289f[i] * 10000) / this.f11308c.f11271p);
            }
        }

        private long m16600a(long j, int i) {
            return (10000 * j) / (i == 2 ? this.f11308c.f11266k.f11289f[2] : this.f11308c.f11266k.f11288e);
        }
    }

    @DoNotStrip
    @Inject
    public FrameRateLogger(ExecutorService executorService, AnalyticsLogger analyticsLogger, FPSControllerProvider fPSControllerProvider, DisplayUtil displayUtil, FrameRateBlameMarkers frameRateBlameMarkers, TimeSinceTTI timeSinceTTI, @Assisted Boolean bool, @Assisted String str, @Assisted Optional<String> optional) {
        Preconditions.checkNotNull(str);
        this.f11258c = executorService;
        this.f11259d = analyticsLogger;
        this.f11260e = fPSControllerProvider.m16576a(bool);
        this.f11264i = str;
        if (optional.isPresent()) {
            str = ((String) optional.get()) + "_" + str;
        }
        this.f11265j = str;
        this.f11262g = new ScrollPerfRunnable(this);
        this.f11260e.f11295f = this;
        this.f11261f = displayUtil;
        this.f11263h = frameRateBlameMarkers;
        this.f11278w = new HashMap();
        this.f11279x = new HashMap();
        this.f11280y = new HashMap();
        this.f11268m = timeSinceTTI;
    }

    public final void m16572a() {
        if (!m16571h()) {
            this.f11270o = this.f11259d.mo535a("feed_scroll_perf", false);
            if (this.f11270o.m17388a() && !this.f11272q) {
                this.f11263h.m16549b();
                this.f11272q = true;
                FPSController fPSController = this.f11260e;
                if (FPSController.f11290a) {
                    fPSController.f11291b.m1649a();
                    fPSController.f11294e.mo2122a();
                }
                this.f11257b = new WeakReference(new Object());
                if (this.f11269n != null) {
                    this.f11269n.mo2124a();
                }
            }
        }
    }

    public final void m16574b() {
        if (this.f11272q) {
            if (!m16571h()) {
                m16569f();
            }
            FPSController fPSController = this.f11260e;
            if (FPSController.f11290a) {
                fPSController.f11291b.m1649a();
                fPSController.f11294e.mo2123b();
            }
            this.f11272q = false;
            this.f11263h.m16551c();
            if (this.f11269n != null) {
                this.f11269n.mo2127b();
            }
        }
    }

    public final void mo2121a(int i) {
        double d = 0.0d;
        if (this.f11272q) {
            int max = Math.max(1, i);
            int d2 = m16567d();
            int min = Math.min(Math.max(Math.round(((float) max) / ((float) d2)) - 1, 0), 15);
            SkippedFrameData skippedFrameData = this.f11266k;
            skippedFrameData.f11284a += min;
            SkippedFrameData.m16581a(this.f11266k, (float) min);
            SkippedFrameData.m16580a(this.f11266k, min >= 2 ? ((double) Math.round((((double) min) * 100.0d) / 2.0d)) / 100.0d : 0.0d);
            skippedFrameData = this.f11266k;
            if (min >= 4) {
                d = ((double) Math.round((((double) min) * 100.0d) / 4.0d)) / 100.0d;
            }
            SkippedFrameData.m16583b(skippedFrameData, d);
            max = (min + 1) * d2;
            int min2 = Math.min(min, this.f11266k.f11289f.length - 1);
            long[] jArr = this.f11266k.f11289f;
            jArr[min2] = jArr[min2] + ((long) max);
            if (min >= 5) {
                SkippedFrameData.m16582a(this.f11266k, (long) max);
            }
            this.f11271p += (long) max;
            m16568e();
            m16565b(max);
            m16562a(min, max);
            if (this.f11269n != null && min >= 2) {
                this.f11269n.mo2128c();
            }
            if (this.f11269n != null) {
                this.f11269n.mo2125a(max);
            }
            this.f11263h.m16553d();
        }
    }

    private int m16567d() {
        if (this.f11273r == 0) {
            this.f11274s = this.f11261f.f11283a.getDefaultDisplay().getRefreshRate();
            this.f11275t = m16561a(this.f11274s);
            this.f11273r = m16564b(this.f11275t);
        }
        return this.f11273r;
    }

    private void m16568e() {
        if (this.f11257b.get() == null) {
            FrameRateBlameMarkers frameRateBlameMarkers = this.f11263h;
            if (GcFrameBlameMarker.a == null) {
                GcFrameBlameMarker.a = new GcFrameBlameMarker();
            }
            frameRateBlameMarkers.m16552c(GcFrameBlameMarker.a);
        }
    }

    private void m16565b(int i) {
        if (this.f11257b.get() == null) {
            this.f11257b = new WeakReference(new Object());
            this.f11277v += (long) i;
            this.f11276u++;
        }
    }

    private void m16562a(int i, int i2) {
        if (i > 0) {
            Marker a = this.f11263h.m16547a();
            if (a != null) {
                TracerDetour.a("FrameRateLogger.updateBlameMarker", 321363932);
                try {
                    m16563a(i, a, this.f11280y);
                    if (i >= 2) {
                        m16566b(i2, a, this.f11278w);
                        if (i < 5) {
                            TracerDetour.a(-331260189);
                            return;
                        }
                        m16566b(i2, a, this.f11279x);
                        TracerDetour.a(2134475166);
                    }
                } finally {
                    TracerDetour.a(-1061945952);
                }
            }
        }
    }

    private static void m16563a(int i, Marker marker, Map<Marker, Integer> map) {
        Integer num = (Integer) map.get(marker);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        map.put(marker, Integer.valueOf(num.intValue() + i));
    }

    private static void m16566b(int i, Marker marker, Map<Marker, Integer> map) {
        Integer num = (Integer) map.get(marker);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        map.put(marker, Integer.valueOf(num.intValue() + i));
    }

    private void m16569f() {
        if (!m16571h() && this.f11271p > 0) {
            this.f11281z = ExecutorDetour.a(this.f11258c, this.f11262g, -1779108056);
        }
    }

    public static void m16570g(FrameRateLogger frameRateLogger) {
        frameRateLogger.f11271p = 0;
        frameRateLogger.f11277v = 0;
        frameRateLogger.f11276u = 0;
        frameRateLogger.f11278w.clear();
        frameRateLogger.f11279x.clear();
        frameRateLogger.f11280y.clear();
        SkippedFrameData skippedFrameData = frameRateLogger.f11266k;
        skippedFrameData.f11284a = 0;
        skippedFrameData.f11285b = 0.0f;
        skippedFrameData.f11286c = 0.0f;
        skippedFrameData.f11287d = 0.0f;
        skippedFrameData.f11288e = 0;
        Arrays.fill(skippedFrameData.f11289f, 0);
        if (frameRateLogger.f11269n != null) {
            frameRateLogger.f11269n.mo2129d();
        }
    }

    private boolean m16571h() {
        return (this.f11281z == null || this.f11281z.isDone()) ? false : true;
    }

    private static float m16561a(float f) {
        if (f <= 0.0f) {
            return 60.0f;
        }
        if (f < 30.0f) {
            return 30.0f;
        }
        if (f > 80.0f) {
            return 80.0f;
        }
        return f;
    }

    @VisibleForTesting
    private static int m16564b(float f) {
        return (int) Math.ceil((double) (1000.0f / f));
    }
}
