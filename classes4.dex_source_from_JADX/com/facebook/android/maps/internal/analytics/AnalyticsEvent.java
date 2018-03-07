package com.facebook.android.maps.internal.analytics;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.maps.MapAnalyticsLogger;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/* compiled from: dst_THREADVIEW */
public class AnalyticsEvent {
    public static final AnalyticsEvent f13508A = new AnalyticsEvent("oxygen_map_dynamic_map_warm_tti_ns", false);
    public static final AnalyticsEvent f13509B = new AnalyticsEvent("oxygen_map_dynamic_map_cold_tti_ns", false);
    public static final AnalyticsEvent f13510C = new AnalyticsEvent("oxygen_map_static_map_render_time_ns", false);
    public static final AnalyticsEvent f13511D = new AnalyticsEvent("oxygen_map_dynamic_map_stats_per_impression", false);
    private static MapAnalyticsLogger f13512E;
    private static final Random f13513F = new Random();
    public static final AnalyticsEvent f13514a = new AnalyticsEvent("oxygen_map_draw_time_ns", false);
    public static final AnalyticsEvent f13515b = new AnalyticsEvent("oxygen_map_layout_time_ns", false);
    public static final AnalyticsEvent f13516c = new AnalyticsEvent("oxygen_map_touch_event_time_ns", false);
    public static final AnalyticsEvent f13517d = new AnalyticsEvent("oxygen_map_tile_download_time_ns", true);
    public static final AnalyticsEvent f13518e = new AnalyticsEvent("oxygen_map_tile_download_size", true);
    public static final AnalyticsEvent f13519f = new AnalyticsEvent("oxygen_map_tree_compaction_time", true);
    public static final AnalyticsEvent f13520g = new AnalyticsEvent("oxygen_map_marker_draw_time", false);
    public static final AnalyticsEvent f13521h = new AnalyticsEvent("oxygen_map_marker_touch_detection_time", false);
    public static final AnalyticsEvent f13522i = new AnalyticsEvent("oxygen_map_info_window_draw_time", false);
    public static final AnalyticsEvent f13523j = new AnalyticsEvent("oxygen_map_tile_overlay_draw_time_ns", false);
    public static final AnalyticsEvent[] f13524k = new AnalyticsEvent[]{f13514a, f13515b, f13517d, f13518e, f13519f, f13520g, f13521h, f13522i};
    public static final AnalyticsEvent f13525l = new AnalyticsEvent("oxygen_map_bitmap_reuse_error", true);
    public static final AnalyticsEvent f13526m = new AnalyticsEvent("oxygen_map_disk_cache_null_key_error", true);
    public static final AnalyticsEvent f13527n = new AnalyticsEvent("oxygen_map_disk_cache_write_error", true);
    public static final AnalyticsEvent f13528o = new AnalyticsEvent("oxygen_map_disk_cache_read_error", true);
    public static final AnalyticsEvent f13529p = new AnalyticsEvent("oxygen_map_disk_cache_init_error", true);
    public static final AnalyticsEvent f13530q = new AnalyticsEvent("oxygen_map_config_fetch_error", true);
    public static final AnalyticsEvent f13531r = new AnalyticsEvent("oxygen_map_tile_download_error", true);
    public static final AnalyticsEvent f13532s = new AnalyticsEvent("oxygen_map_empty_cluster_error", true);
    public static final AnalyticsEvent f13533t = new AnalyticsEvent("oxygen_map_static_map_image_download_error", true);
    public static final AnalyticsEvent f13534u = new AnalyticsEvent("oxygen_map_suppressed_drain_to_byte_array_error", true);
    public static final AnalyticsEvent f13535v = new AnalyticsEvent("oxygen_map_runtime_permission_error", true);
    public static final AnalyticsEvent f13536w = new AnalyticsEvent("oxygen_map_static_map_report_button_clicked", false);
    public static final AnalyticsEvent f13537x = new AnalyticsEvent("oxygen_map_default_reporter_dialog_clicked", false);
    public static final AnalyticsEvent f13538y = new AnalyticsEvent("oxygen_map_static_map_view_impression", false);
    public static final AnalyticsEvent f13539z = new AnalyticsEvent("oxygen_map_dynamic_map_view_impression", false);
    private final boolean f13540G;
    private final String f13541H;
    private int f13542I = 0;
    private long[] f13543J;
    private long f13544K = Long.MIN_VALUE;
    private long f13545L = Long.MAX_VALUE;
    private long f13546M = 0;

    public static synchronized void m14383a(MapAnalyticsLogger mapAnalyticsLogger) {
        synchronized (AnalyticsEvent.class) {
            if (f13512E != mapAnalyticsLogger) {
                f13512E = mapAnalyticsLogger;
            }
        }
    }

    private AnalyticsEvent(String str, boolean z) {
        this.f13541H = str;
        this.f13540G = z;
    }

    public static long m14382a() {
        return System.nanoTime();
    }

    public static void m14386b() {
        for (AnalyticsEvent e : f13524k) {
            e.m14389e();
        }
    }

    public final boolean m14395c() {
        if (f13512E != null) {
            MapAnalyticsLogger mapAnalyticsLogger = f13512E;
            if (((BaseAnalyticsConfig) mapAnalyticsLogger.f13403a.get()).a(this.f13541H)) {
                return true;
            }
        }
        return false;
    }

    public final void m14394a(Map<String, ?> map) {
        if (f13512E != null) {
            MapAnalyticsLogger mapAnalyticsLogger = f13512E;
            HoneyClientEventFast a = ((AnalyticsLogger) mapAnalyticsLogger.f13404b.get()).a(this.f13541H, false);
            if (a.a()) {
                a.a("oxygen_map").a(map);
                a.b();
            }
        }
    }

    public final void m14393a(Throwable th) {
        m14384a("", th);
    }

    public final void m14392a(String str) {
        m14384a(str, null);
    }

    private void m14384a(String str, Throwable th) {
        if (this.f13540G) {
            synchronized (this) {
                m14388b(str, th);
            }
            return;
        }
        m14388b(str, th);
    }

    public final void m14391a(long j) {
        if (this.f13540G) {
            synchronized (this) {
                m14387b(j);
            }
            return;
        }
        m14387b(j);
    }

    private void m14389e() {
        if (this.f13540G) {
            synchronized (this) {
                m14390f();
            }
            return;
        }
        m14390f();
    }

    private void m14388b(String str, Throwable th) {
        if (f13512E != null) {
            MapAnalyticsLogger mapAnalyticsLogger = f13512E;
            String str2 = this.f13541H;
            if (th == null) {
                mapAnalyticsLogger.f13405c.a(str2, str);
            } else {
                mapAnalyticsLogger.f13405c.a(str2, str, th);
            }
        }
    }

    private void m14387b(long j) {
        long j2;
        if (this.f13543J == null) {
            this.f13543J = new long[256];
        }
        this.f13544K = this.f13544K > j ? this.f13544K : j;
        if (this.f13545L < j) {
            j2 = this.f13545L;
        } else {
            j2 = j;
        }
        this.f13545L = j2;
        this.f13546M += j;
        if (this.f13542I < 256) {
            this.f13543J[this.f13542I] = j;
        } else {
            int nextInt = f13513F.nextInt(this.f13542I + 1);
            if (nextInt < 256) {
                this.f13543J[nextInt] = j;
            }
        }
        this.f13542I++;
        if (this.f13542I == 256) {
            m14389e();
        }
    }

    private void m14390f() {
        if (f13512E != null) {
            int i = this.f13542I < 256 ? this.f13542I : 256;
            if (i > 0) {
                f13512E.m14305a(this.f13541H, m14385a(this.f13543J, i), this.f13542I, this.f13544K, this.f13545L, this.f13546M);
            }
        }
        this.f13544K = Long.MIN_VALUE;
        this.f13545L = Long.MAX_VALUE;
        this.f13546M = 0;
        this.f13542I = 0;
    }

    private static long[] m14385a(long[] jArr, int i) {
        int i2 = 0;
        long[] jArr2 = new long[5];
        if (i > 0) {
            long[] copyOf = Arrays.copyOf(jArr, i);
            Arrays.sort(copyOf);
            int i3 = i - 1;
            int[] iArr = new int[]{i3 >> 2, i3 >> 1, i3 - (i3 >> 2), (int) ((((double) i3) * 0.9d) + 0.5d), (int) ((((double) i3) * 0.99d) + 0.5d)};
            while (i2 < 5) {
                jArr2[i2] = copyOf[iArr[i2]];
                i2++;
            }
        }
        return jArr2;
    }
}
