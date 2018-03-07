package com.facebook.performancelogger;

import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.util.TriState;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: upload_attachment_interstitial */
public class MarkerConfig {
    public int f1692a;
    private int f1693b;
    private String f1694c;
    public String f1695d;
    @Nullable
    public String f1696e;
    private double f1697f = 0.0d;
    public long f1698g = -1;
    public long f1699h = -1;
    private boolean f1700i = true;
    private boolean f1701j;
    private Set<String> f1702k;
    public Map<String, String> f1703l;
    private PerfTestConfig f1704m;
    public boolean f1705n = false;
    @Nullable
    public String f1706o;
    @Nullable
    public String f1707p;
    private long f1708q = -1;
    private long f1709r = -1;
    @Nullable
    public PerfStats f1710s;
    private double f1711t;
    public TriState f1712u = TriState.UNSET;

    public MarkerConfig(int i, String str) {
        this.f1695d = str;
        this.f1694c = SafeUUIDGenerator.m2795a().toString();
        this.f1692a = i;
    }

    public MarkerConfig(MarkerConfig markerConfig) {
        this.f1692a = markerConfig.f1692a;
        this.f1693b = markerConfig.f1693b;
        this.f1694c = markerConfig.f1694c;
        this.f1695d = markerConfig.f1695d;
        this.f1696e = markerConfig.f1696e;
        this.f1697f = markerConfig.f1697f;
        this.f1698g = markerConfig.f1698g;
        this.f1699h = markerConfig.f1699h;
        this.f1700i = markerConfig.f1700i;
        this.f1701j = markerConfig.f1701j;
        this.f1702k = markerConfig.f1702k;
        this.f1705n = markerConfig.f1705n;
        this.f1703l = markerConfig.f1703l != null ? new HashMap(markerConfig.f1703l) : null;
        this.f1706o = markerConfig.f1706o;
        this.f1707p = markerConfig.f1707p;
        this.f1710s = markerConfig.f1710s;
        this.f1711t = markerConfig.f1711t;
        this.f1712u = markerConfig.f1712u;
    }

    public final MarkerConfig m3385a(@Nullable String str) {
        this.f1696e = str;
        return this;
    }

    public final MarkerConfig m3388a(String... strArr) {
        this.f1702k = Sets.m1313a();
        for (Object add : strArr) {
            this.f1702k.add(add);
        }
        return this;
    }

    public final Set<String> m3389a() {
        return this.f1702k;
    }

    public final MarkerConfig m3381a(long j) {
        this.f1698g = j;
        return this;
    }

    public final MarkerConfig m3391b(long j) {
        this.f1699h = j;
        return this;
    }

    public final MarkerConfig m3390b() {
        this.f1701j = true;
        return this;
    }

    public final MarkerConfig m3382a(PerfStats perfStats) {
        this.f1710s = perfStats;
        return this;
    }

    public final MarkerConfig m3380a(double d) {
        this.f1711t = d;
        if (this.f1704m == null) {
            this.f1704m = new PerfTestConfig();
        }
        boolean z = PerfTestConfigBase.m2938a() || Math.random() < d;
        this.f1700i = z;
        return this;
    }

    public final String m3393c() {
        return this.f1695d;
    }

    @Nullable
    public final String m3394d() {
        return this.f1696e;
    }

    final boolean m3395e() {
        return this.f1700i;
    }

    public final long m3396f() {
        return this.f1698g;
    }

    public final boolean m3397h() {
        return this.f1701j;
    }

    public final Map<String, String> m3398i() {
        return this.f1703l;
    }

    @Nullable
    public final PerfStats m3399j() {
        return this.f1710s;
    }

    public final MarkerConfig m3383a(ImmutableMap<String, String> immutableMap) {
        this.f1703l = immutableMap;
        return this;
    }

    public final MarkerConfig m3387a(Map<String, String> map) {
        if (map == null) {
            this.f1703l = null;
        } else if (map instanceof ImmutableMap) {
            this.f1703l = (ImmutableMap) map;
        } else {
            this.f1703l = Maps.m813a((Map) map);
        }
        return this;
    }

    public final MarkerConfig m3386a(@Nullable String str, @Nullable String str2) {
        this.f1706o = str;
        this.f1707p = str2;
        return this;
    }

    @Nullable
    public final String m3400k() {
        return this.f1706o;
    }

    @Nullable
    public final String m3401l() {
        return this.f1707p;
    }

    public final int m3402m() {
        return this.f1692a;
    }

    public final int m3403n() {
        return this.f1693b;
    }

    public final TriState m3404o() {
        return this.f1712u;
    }

    public final MarkerConfig m3392c(boolean z) {
        return m3379a(TriState.valueOf(z));
    }

    public final MarkerConfig m3384a(Boolean bool) {
        return m3379a(TriState.valueOf(bool));
    }

    private MarkerConfig m3379a(TriState triState) {
        if (this.f1712u != TriState.YES) {
            if (triState == null) {
                triState = TriState.UNSET;
            }
            this.f1712u = triState;
        }
        return this;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("id", this.f1694c).add("name", this.f1695d).add("namespace", this.f1696e).toString();
    }
}
