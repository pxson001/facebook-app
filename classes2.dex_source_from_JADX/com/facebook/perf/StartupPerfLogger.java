package com.facebook.perf;

import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Fb4aSequences;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: upload_app_build_number */
public class StartupPerfLogger {
    private static final Class<?> f1714a = StartupPerfLogger.class;
    public final SequenceLogger f1715b;
    public final PerformanceLogger f1716c;
    private final MonotonicClock f1717d;
    public boolean f1718e = false;
    public boolean f1719f = false;
    public boolean f1720g = false;

    public static StartupPerfLogger m3414b(InjectorLike injectorLike) {
        return new StartupPerfLogger(SequenceLoggerImpl.m3464a(injectorLike), DelegatingPerformanceLogger.m2803a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    public static StartupPerfLogger m3406a(InjectorLike injectorLike) {
        return m3414b(injectorLike);
    }

    @Inject
    public StartupPerfLogger(SequenceLogger sequenceLogger, PerformanceLogger performanceLogger, MonotonicClock monotonicClock) {
        this.f1715b = sequenceLogger;
        this.f1716c = performanceLogger;
        this.f1717d = monotonicClock;
    }

    public final StartupPerfLogger m3435a(long j, PerfStats perfStats, boolean z, List<MarkerConfig> list) {
        Preconditions.checkNotNull(list);
        ImmutableList immutableList = Fb4aSequences.f2219d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f1715b.mo514a((AbstractSequenceDefinition) immutableList.get(i), null, null, j, Boolean.valueOf(z));
        }
        for (MarkerConfig markerConfig : list) {
            PerfStats perfStats2 = new PerfStats(perfStats);
            this.f1716c.mo382a(new MarkerConfig(markerConfig).m3381a(j).m3388a("native_newsfeed").m3390b().m3382a(perfStats2).m3392c(z), true);
        }
        return this;
    }

    public final StartupPerfLogger m3438a(List<MarkerConfig> list, long j, PerfStats perfStats) {
        m3419f();
        m3417e();
        Preconditions.checkNotNull(list);
        ImmutableList immutableList = Fb4aSequences.f2223h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f1715b.mo512a((AbstractSequenceDefinition) immutableList.get(i), null, j);
        }
        for (MarkerConfig markerConfig : list) {
            PerfStats perfStats2 = new PerfStats(perfStats);
            PerformanceLogger performanceLogger = this.f1716c;
            MarkerConfig markerConfig2 = new MarkerConfig(markerConfig);
            markerConfig2.f1698g = j;
            MarkerConfig markerConfig3 = markerConfig2.m3388a("native_newsfeed");
            markerConfig3.f1710s = perfStats2;
            performanceLogger.mo382a(markerConfig3, true);
        }
        return this;
    }

    public final StartupPerfLogger m3436a(long j, List<MarkerConfig> list) {
        Preconditions.checkNotNull(list);
        m3419f();
        m3417e();
        ImmutableList immutableList = Fb4aSequences.f2224i;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            this.f1715b.mo512a((AbstractSequenceDefinition) immutableList.get(i), null, j);
        }
        for (MarkerConfig markerConfig : list) {
            PerformanceLogger performanceLogger = this.f1716c;
            MarkerConfig markerConfig2 = new MarkerConfig(markerConfig);
            markerConfig2.f1698g = j;
            performanceLogger.mo382a(markerConfig2.m3388a("native_newsfeed"), true);
        }
        return this;
    }

    public final StartupPerfLogger m3434a(int i, String str, boolean z) {
        PerfStats perfStats;
        if (z) {
            perfStats = new PerfStats();
        } else {
            perfStats = null;
        }
        m3432a(i, str, null, null, this.f1717d.now(), perfStats, null);
        return this;
    }

    public final StartupPerfLogger m3429a(int i, String str) {
        m3430a(i, str, this.f1717d.now());
        return this;
    }

    public final StartupPerfLogger m3430a(int i, String str, long j) {
        m3418f(i, str, null, null, j);
        return this;
    }

    private StartupPerfLogger m3418f(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        return m3432a(i, str, str2, (ImmutableMap) immutableMap, j, null, null);
    }

    public final StartupPerfLogger m3432a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable PerfStats perfStats, @Nullable Boolean bool) {
        m3411a(str, str2, (ImmutableMap) immutableMap, j, bool);
        if (m3453d()) {
            MarkerConfig markerConfig = new MarkerConfig(i, str);
            markerConfig.f1696e = str2;
            markerConfig = markerConfig.m3381a(j).m3388a("native_newsfeed").m3390b().m3384a(bool);
            if (perfStats != null) {
                markerConfig.f1710s = perfStats;
            }
            if (immutableMap != null) {
                markerConfig.f1703l = immutableMap;
            }
            this.f1716c.mo382a(markerConfig, true);
        }
        return this;
    }

    private void m3410a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3411a(str, str2, (ImmutableMap) immutableMap, j, null);
    }

    private void m3411a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        ImmutableList immutableList = Fb4aSequences.f2219d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null) {
                SequenceLoggerDetour.a(e, str, str2, immutableMap, j, bool, 845622177);
            }
        }
    }

    public final StartupPerfLogger m3440b(int i, String str) {
        m3431a(i, str, null, null, this.f1717d.now());
        return this;
    }

    public final StartupPerfLogger m3431a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3415b(str, str2, immutableMap, j);
        if (this.f1716c.mo400h(655380, "NNFFreshContentStart")) {
            m3407a(i, str, str2, (ImmutableMap) immutableMap, j, 1.0d, false);
        }
        return this;
    }

    private void m3415b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        ImmutableList immutableList = Fb4aSequences.f2223h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null) {
                SequenceLoggerDetour.a(e, str, str2, immutableMap, j, -272962348);
            }
        }
    }

    public final StartupPerfLogger m3446c(int i, String str) {
        m3441b(i, str, this.f1717d.now());
        return this;
    }

    public final StartupPerfLogger m3441b(int i, String str, long j) {
        m3442b(i, str, null, null, j);
        return this;
    }

    public final StartupPerfLogger m3442b(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        return m3433a(i, str, str2, (ImmutableMap) immutableMap, j, null);
    }

    public final StartupPerfLogger m3433a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        if (m3421g()) {
            m3461k(i, str);
        } else {
            m3408a(i, str, str2, (ImmutableMap) immutableMap, j, bool, Fb4aSequences.f2219d);
        }
        return this;
    }

    private StartupPerfLogger m3420g(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3405a(i, str, str2, (ImmutableMap) immutableMap, j, true);
        return this;
    }

    private StartupPerfLogger m3405a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, boolean z) {
        if (!m3425i()) {
            m3408a(i, str, str2, (ImmutableMap) immutableMap, j, null, Fb4aSequences.f2224i);
        } else if (z) {
            m3427n(i, str);
        }
        return this;
    }

    public final StartupPerfLogger m3450d(int i, String str) {
        m3420g(i, str, null, null, this.f1717d.now());
        return this;
    }

    public final StartupPerfLogger m3456f(int i, String str) {
        m3448c(i, str, null, null, this.f1717d.now());
        return this;
    }

    public final StartupPerfLogger m3451d(int i, String str, long j) {
        m3448c(i, str, null, null, j);
        return this;
    }

    public final StartupPerfLogger m3448c(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3413b(i, str, str2, immutableMap, j, true);
        return this;
    }

    private StartupPerfLogger m3413b(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, boolean z) {
        if (!m3423h()) {
            m3408a(i, str, str2, (ImmutableMap) immutableMap, j, null, Fb4aSequences.f2223h);
        } else if (z) {
            m3426m(i, str);
        }
        return this;
    }

    private void m3408a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool, Iterable<? extends SequenceDefinition> iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) it.next());
            if (e != null) {
                SequenceLoggerDetour.b(e, str, str2, immutableMap, j, bool, 1629472096);
            }
        }
        MarkerConfig markerConfig = new MarkerConfig(i, str);
        markerConfig.m3385a(str2).m3391b(j).m3384a(bool);
        if (immutableMap != null) {
            markerConfig.m3383a((ImmutableMap) immutableMap);
        }
        this.f1716c.mo387b(markerConfig);
    }

    public final StartupPerfLogger m3457g(int i, String str) {
        return m3452d(i, str, null, null, this.f1717d.now());
    }

    public final StartupPerfLogger m3452d(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3422h(i, str, str2, immutableMap, j);
        return this;
    }

    private StartupPerfLogger m3422h(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3409a(i, str, str2, (ImmutableMap) immutableMap, j, Fb4aSequences.f2219d);
        return this;
    }

    private void m3409a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, Iterable<? extends SequenceDefinition> iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) it.next());
            if (e != null) {
                SequenceLoggerDetour.c(e, str, str2, immutableMap, j, -264734104);
            }
        }
        MarkerConfig markerConfig = new MarkerConfig(i, str);
        markerConfig.m3385a(str2).m3391b(j);
        if (immutableMap != null) {
            markerConfig.m3383a((ImmutableMap) immutableMap);
        }
        this.f1716c.mo393d(markerConfig);
    }

    public final StartupPerfLogger m3443b(int i, String str, boolean z) {
        return m3416c(i, str, null, null, this.f1717d.now(), z);
    }

    public final StartupPerfLogger m3458h(int i, String str) {
        return m3455e(i, str, null, null, this.f1717d.now());
    }

    public final StartupPerfLogger m3455e(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3410a(str, str2, (ImmutableMap) immutableMap, j);
        m3415b(str, str2, immutableMap, j);
        m3407a(i, str, str2, (ImmutableMap) immutableMap, j, 1.0d, false);
        return this;
    }

    private StartupPerfLogger m3416c(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, boolean z) {
        m3410a(str, str2, (ImmutableMap) immutableMap, j);
        m3415b(str, str2, immutableMap, j);
        m3407a(i, str, str2, (ImmutableMap) immutableMap, j, 1.0d, z);
        return this;
    }

    private void m3407a(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, double d, boolean z) {
        MarkerConfig markerConfig = new MarkerConfig(i, str);
        markerConfig.f1696e = str2;
        markerConfig = markerConfig;
        markerConfig.f1698g = j;
        markerConfig = markerConfig.m3388a("native_newsfeed");
        if (z) {
            markerConfig.f1710s = new PerfStats();
        }
        if (d != 1.0d) {
            markerConfig.m3380a(d);
        }
        if (immutableMap != null) {
            markerConfig.f1703l = immutableMap;
        }
        this.f1716c.mo382a(markerConfig, true);
    }

    public final StartupPerfLogger m3459i(int i, String str) {
        m3424i(i, str, null, null, this.f1717d.now());
        return this;
    }

    private StartupPerfLogger m3424i(int i, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        m3442b(i, str, str2, immutableMap, j);
        m3413b(i, str, str2, immutableMap, j, false);
        m3405a(i, str, str2, (ImmutableMap) immutableMap, j, false);
        return this;
    }

    public final StartupPerfLogger m3444b(MarkerConfig markerConfig) {
        this.f1716c.mo398f(markerConfig);
        return this;
    }

    public final StartupPerfLogger m3460j(int i, String str) {
        this.f1716c.mo374a(i, str);
        return this;
    }

    public final StartupPerfLogger m3461k(int i, String str) {
        m3428o(i, str);
        ImmutableList immutableList = Fb4aSequences.f2219d;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) immutableList.get(i2));
            if (e != null) {
                SequenceLoggerDetour.d(e, str, 448444908);
            }
        }
        return this;
    }

    private void m3428o(int i, String str) {
        if (m3453d()) {
            this.f1716c.mo374a(i, str);
        }
    }

    public final StartupPerfLogger m3437a(List<MarkerConfig> list) {
        m3412a(Fb4aSequences.f2219d, (List) list);
        return this;
    }

    public final StartupPerfLogger m3445b(List<MarkerConfig> list) {
        m3412a(Fb4aSequences.f2223h, (List) list);
        return this;
    }

    public final StartupPerfLogger m3449c(List<MarkerConfig> list) {
        m3412a(Fb4aSequences.f2224i, (List) list);
        return this;
    }

    private void m3412a(List<? extends SequenceDefinition> list, List<MarkerConfig> list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f1715b.mo523d((AbstractSequenceDefinition) it.next());
        }
        for (MarkerConfig f : list2) {
            this.f1716c.mo398f(f);
        }
    }

    public final boolean m3462l(int i, String str) {
        return this.f1716c.mo400h(i, str);
    }

    private void m3417e() {
        this.f1719f = false;
    }

    private void m3419f() {
        this.f1720g = false;
    }

    private boolean m3421g() {
        return this.f1718e;
    }

    public final void m3439a(AbstractSequenceDefinition abstractSequenceDefinition) {
        if (this.f1718e) {
            this.f1715b.mo523d(abstractSequenceDefinition);
        } else {
            this.f1715b.mo518b(abstractSequenceDefinition);
        }
    }

    public final StartupPerfLogger m3447c(int i, String str, long j) {
        if (this.f1718e) {
            m3428o(i, str);
        } else {
            this.f1716c.mo377a(i, str, null, j);
        }
        return this;
    }

    public final StartupPerfLogger m3454e(int i, String str) {
        if (this.f1718e) {
            m3428o(i, str);
        } else {
            this.f1716c.mo389c(i, str);
        }
        return this;
    }

    private boolean m3423h() {
        return this.f1719f;
    }

    private boolean m3425i() {
        return this.f1720g;
    }

    public final boolean m3453d() {
        return this.f1716c.mo400h(655382, "NNFColdStartTTI") || this.f1716c.mo400h(655437, "NNFColdStartNetwork");
    }

    private StartupPerfLogger m3426m(int i, String str) {
        Object obj;
        if (this.f1716c.mo400h(655379, "NNFWarmStartTTI") || this.f1716c.mo400h(655383, "NNFWarmStartFromNetwork")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f1716c.mo374a(i, str);
        }
        ImmutableList immutableList = Fb4aSequences.f2223h;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) immutableList.get(i2));
            if (e != null) {
                SequenceLoggerDetour.d(e, str, -8591635);
            }
        }
        return this;
    }

    private StartupPerfLogger m3427n(int i, String str) {
        Object obj;
        if (this.f1716c.mo400h(655406, "NNFHotStartTTI") || this.f1716c.mo400h(655404, "NNFHotStartAndFreshRenderTime")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f1716c.mo374a(i, str);
        }
        ImmutableList immutableList = Fb4aSequences.f2224i;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Sequence e = this.f1715b.mo524e((AbstractSequenceDefinition) immutableList.get(i2));
            if (e != null) {
                SequenceLoggerDetour.d(e, str, -1865090498);
            }
        }
        return this;
    }
}
