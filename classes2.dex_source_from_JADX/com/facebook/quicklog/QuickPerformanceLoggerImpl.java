package com.facebook.quicklog;

import android.util.SparseArray;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.quicklog.driver.analytics1.DefaultHoneyClientLogger;
import com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy;
import com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy.WrapperHoneySamplingConfig;
import com.facebook.quicklog.driver.analytics1.DefaultStatsLogger;
import com.facebook.quicklog.identifiers.ActionId;
import com.facebook.quicklog.identifiers.DebugUtils;
import com.facebook.quicklog.identifiers.PerformanceEventFields;
import com.facebook.quicklog.module.DalvikGcInfo;
import com.facebook.quicklog.module.SimpleBackgroundExecutor;
import com.facebook.quicklog.module.StandardAppStates;
import com.facebook.quicklog.module.StandardDebugAndTestConfig;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceConfig;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: upsell_use_data_or_stay_free_screen */
public class QuickPerformanceLoggerImpl implements QuickPerformanceLogger {
    public static final String f1560a = QuickPerformanceLoggerImpl.class.getSimpleName();
    private MonotonicClock f1561b;
    private Clock f1562c;
    private MarkersManager f1563d;
    private Provider<HoneyClientLogger> f1564e;
    public DefaultHoneySamplingPolicy f1565f;
    private Provider<StatsLogger> f1566g;
    private PerformanceLoggingEvent f1567h;
    private final Set<Integer> f1568i = new HashSet();
    public final SparseArray<Integer> f1569j = new SparseArray();
    public final StandardDebugAndTestConfig f1570k;
    private StandardAppStates f1571l;
    private SimpleBackgroundExecutor f1572m;
    private TriState f1573n = TriState.UNSET;
    private final PerformanceLoggingEventVisitor[] f1574o;
    private final Random f1575p = new Random();
    private final DalvikGcInfo f1576q;

    public QuickPerformanceLoggerImpl(Provider<HoneyClientLogger> provider, HoneySamplingPolicy honeySamplingPolicy, Provider<StatsLogger> provider2, MonotonicClock monotonicClock, Clock clock, DebugAndTestConfig debugAndTestConfig, AppStates appStates, BackgroundExecution backgroundExecution, @Nullable QuickEventListener[] quickEventListenerArr, @Nullable PerformanceLoggingEventVisitor[] performanceLoggingEventVisitorArr, @Nullable GCInfo gCInfo) {
        this.f1564e = provider;
        this.f1565f = honeySamplingPolicy;
        this.f1566g = provider2;
        this.f1561b = monotonicClock;
        this.f1562c = clock;
        this.f1570k = debugAndTestConfig;
        this.f1571l = appStates;
        this.f1572m = backgroundExecution;
        this.f1574o = performanceLoggingEventVisitorArr;
        this.f1576q = gCInfo;
        this.f1563d = new MarkersManager(this.f1566g, quickEventListenerArr);
    }

    public final void mo451a(int i, Collection<? extends Object> collection) {
        this.f1563d.m3271a(i, 0, (Collection) collection);
    }

    public final void mo443a(int i, int i2, Collection<? extends Object> collection) {
        this.f1563d.m3271a(i, i2, (Collection) collection);
    }

    public final void mo457a(Object obj) {
        List<Long> a = this.f1563d.m3267a(obj);
        boolean a2 = TraceConfig.a(4);
        for (Long l : a) {
            int longValue = (int) (l.longValue() >> 32);
            int longValue2 = (int) (l.longValue() & -1);
            if (a2) {
                Systrace.f(4, m3079g(longValue2), MarkersManager.m3262i(longValue2, longValue));
            }
        }
    }

    public final void mo437a(int i, int i2) {
        this.f1563d.m3285h(i, i2);
    }

    public final void mo463b(int i, int i2) {
        this.f1569j.put(i, Integer.valueOf(i2));
    }

    public final int mo436a() {
        List<Long> a = this.f1563d.m3265a();
        boolean a2 = TraceConfig.a(4);
        for (Long l : a) {
            int longValue = (int) (l.longValue() >> 32);
            int longValue2 = (int) (l.longValue() & -1);
            if (a2) {
                Systrace.f(4, m3079g(longValue2), MarkersManager.m3262i(longValue2, longValue));
            }
        }
        return a.size();
    }

    public final boolean mo460a(int i) {
        return this.f1563d.m3276a(i, 0);
    }

    public final boolean mo473c(int i, int i2) {
        return this.f1563d.m3276a(i, i2);
    }

    public final long mo475d(int i, int i2) {
        return this.f1563d.m3282e(i, i2);
    }

    public final void mo462b(int i) {
        m3065a(i, 0, -1, null, false, false, null, null);
    }

    public final void mo478e(int i, int i2) {
        m3065a(i, i2, -1, null, false, false, null, null);
    }

    public final void mo441a(int i, int i2, String str) {
        m3065a(i, i2, -1, str, false, false, null, null);
    }

    public final void mo438a(int i, int i2, int i3, String str, long j, boolean z, boolean z2, @Nullable PerfStats perfStats, @Nullable TriState triState) {
        if (!(z2 || i2 != 0 || mo484j(i, i3))) {
            WrapperHoneySamplingConfig a = this.f1565f.m2927a();
            Object obj = ((a == null ? 1 : null) != null || a.m4465a()) ? 1 : null;
            if (!(obj == null || this.f1570k.m2933b())) {
                m3066a(i, i3, str, j, false);
                return;
            }
        }
        if (i2 == 0) {
            m3065a(i, i3, j, str, z, false, perfStats, triState);
        } else {
            m3064a(i, i2, i3, j, str, z, false, perfStats, triState);
        }
    }

    public void markerStart(int i, int i2, long j) {
        m3065a(i, i2, j, null, false, false, null, null);
    }

    public final void mo471c(int i) {
        m3065a(i, 0, -1, null, false, true, null, null);
    }

    public final void mo481g(int i, int i2) {
        m3065a(i, i2, -1, null, false, true, null, null);
    }

    public final void mo440a(int i, int i2, long j, boolean z) {
        m3065a(i, i2, j, null, z, true, null, null);
    }

    private void m3066a(int i, int i2, String str, long j, boolean z) {
        boolean c = m3078c(j);
        long a = m3059a(j);
        m3072a("markerInactiveStarted", i);
        this.f1563d.m3269a(i, i2, str, a, c, z);
        if (TraceConfig.a(4)) {
            Systrace.a(4, m3079g(i), MarkersManager.m3262i(i, i2), m3074b(a));
        }
    }

    private void m3071a(QuickEvent quickEvent, int i, int i2, String str, PerfStats perfStats, TriState triState, long j, boolean z, boolean z2) {
        if (quickEvent != null) {
            m3072a("onMarkerStart", i);
            quickEvent.f469k = str;
            quickEvent.f473o = m3061a(perfStats);
            this.f1563d.m3273a(quickEvent, triState);
        } else {
            m3072a("markerNotStarted", i);
            this.f1563d.m3269a(i, i2, str, j, z, z2);
        }
        if (TraceConfig.a(4)) {
            Systrace.a(4, m3079g(i), MarkersManager.m3262i(i, i2), m3074b(j));
        }
    }

    private boolean m3073a(int i, int i2, long j, boolean z, boolean z2, @Nullable PerfStats perfStats, @Nullable TriState triState) {
        if (mo484j(i, i2)) {
            if (this.f1563d.m3278a(i, i2, j, z, this.f1562c.mo211a(), m3060a(z), m3061a(perfStats), triState, z2)) {
                if (TraceConfig.a(4)) {
                    Systrace.f(4, m3079g(i), m3080k(i, i2));
                    Systrace.a(4, m3079g(i), m3080k(i, i2), m3074b(j));
                }
                return true;
            }
        }
        return false;
    }

    private void m3064a(int i, int i2, int i3, long j, String str, boolean z, boolean z2, @Nullable PerfStats perfStats, @Nullable TriState triState) {
        boolean c = m3078c(j);
        long a = m3059a(j);
        if (!m3073a(i, i3, a, c, z2, perfStats, triState)) {
            m3071a(m3062a(i, i2, i3, a, c, z, z2), i, i3, str, perfStats, triState, a, c, z2);
        }
    }

    private void m3065a(int i, int i2, long j, String str, boolean z, boolean z2, @Nullable PerfStats perfStats, @Nullable TriState triState) {
        boolean c = m3078c(j);
        long a = m3059a(j);
        if (!m3073a(i, i2, a, c, z2, perfStats, triState)) {
            m3071a(m3063a(i, i2, a, c, z, z2), i, i2, str, perfStats, triState, a, c, z2);
        }
    }

    public final void mo449a(int i, String str, String str2) {
        mo462b(i);
        mo467b(i, str, str2);
    }

    public final void mo450a(int i, String str, String str2, long j) {
        markerStart(i, 0, j);
        mo467b(i, str, str2);
    }

    public final void mo442a(int i, int i2, String str, String str2) {
        mo478e(i, i2);
        mo465b(i, i2, str, str2);
    }

    public final void mo479f(int i, int i2) {
        m3064a(i, i2, 0, -1, null, false, false, null, null);
    }

    private void m3075b(int i, int i2, int i3) {
        m3064a(i, i2, i3, -1, null, false, false, null, null);
    }

    public final void mo439a(int i, int i2, int i3, String str, String str2) {
        m3075b(i, i2, i3);
        mo465b(i, i3, str, str2);
    }

    public final void mo467b(int i, String str, String str2) {
        mo465b(i, 0, str, str2);
    }

    public final void mo465b(int i, int i2, String str, String str2) {
        this.f1563d.m3270a(i, i2, str, str2);
    }

    public final void mo444a(int i, int i2, Map<String, String> map) {
        this.f1563d.m3272a(i, i2, (Map) map);
    }

    public final void mo448a(int i, String str) {
        this.f1563d.m3268a(i, 0, str);
    }

    public final void mo464b(int i, int i2, String str) {
        this.f1563d.m3268a(i, i2, str);
    }

    public final void mo459a(short s, String str) {
        this.f1563d.m3275a(s, str);
    }

    public final void mo458a(short s) {
        this.f1563d.m3274a(s);
    }

    public final boolean mo482h(int i, int i2) {
        return this.f1563d.m3280c(i, i2);
    }

    public final void mo452a(int i, short s) {
        m3067a(i, 0, s, -1);
    }

    public final void mo445a(int i, int i2, short s) {
        m3067a(i, i2, s, -1);
    }

    public void markerNote(int i, int i2, short s, long j) {
        m3067a(i, i2, s, j);
    }

    public final boolean mo461a(int i, int i2, int i3) {
        return this.f1563d.m3277a(i, i2, i3);
    }

    private void m3067a(int i, int i2, short s, long j) {
        boolean c = m3078c(j);
        int i3 = i;
        int i4 = i2;
        short s2 = s;
        PerformanceLoggingEvent a = this.f1563d.m3264a(i3, i4, s2, m3059a(j), c, m3060a(c), null, null);
        if (a != null) {
            m3072a("markerNote", i);
            m3070a(a);
        }
    }

    public final void mo456a(int i, short s, String str, String str2) {
        m3068a(i, 0, s, str, str2, -1);
    }

    public final void mo447a(int i, int i2, short s, String str, String str2) {
        m3068a(i, i2, s, str, str2, -1);
    }

    private void m3068a(int i, int i2, short s, String str, String str2, long j) {
        boolean c = m3078c(j);
        int i3 = i;
        int i4 = i2;
        short s2 = s;
        PerformanceLoggingEvent a = this.f1563d.m3264a(i3, i4, s2, m3059a(j), c, m3060a(c), str, str2);
        if (a != null) {
            m3072a("markerNoteWithAnnotation", i);
            m3070a(a);
        }
    }

    public final void mo468b(int i, short s) {
        mo446a(i, 0, s, -1, null);
    }

    public final void mo454a(int i, short s, long j) {
        mo446a(i, 0, s, j, null);
    }

    public final void mo466b(int i, int i2, short s) {
        mo446a(i, i2, s, -1, null);
    }

    public void markerEnd(int i, int i2, short s, long j) {
        mo446a(i, i2, s, j, null);
    }

    public final void mo446a(int i, int i2, short s, long j, TriState triState) {
        boolean c = m3078c(j);
        long a = m3059a(j);
        boolean c2 = mo473c(i, i2);
        String b = this.f1563d.m3279b(i, i2);
        PerformanceLoggingEvent a2 = this.f1563d.m3263a(i, i2, s, a, c, m3060a(c), triState);
        if (a2 != null) {
            a2.f7946t = this.f1571l.m3177a();
            m3072a("markerEnd", i);
            m3070a(a2);
        }
        if (TraceConfig.a(4) && c2) {
            String g = m3079g(i);
            String str = b != null ? b : g;
            Systrace.b(4, g, m3080k(i, i2), m3074b(a));
            Systrace.b(4, g, str + "-" + ActionId.a(s), m3080k(i, i2));
        }
    }

    public final void mo476d(int i) {
        this.f1563d.m3284g(i, 0);
        if (TraceConfig.a(4)) {
            Systrace.f(4, m3079g(i), MarkersManager.m3262i(i, 0));
        }
    }

    public void markerCancel(int i, int i2) {
        this.f1563d.m3284g(i, i2);
        if (TraceConfig.a(4)) {
            Systrace.f(4, m3079g(i), MarkersManager.m3262i(i, i2));
        }
    }

    public final void mo483i(int i, int i2) {
        for (Integer intValue : this.f1563d.m3266a(i, this.f1561b.now() - ((long) i2))) {
            mo476d(intValue.intValue());
        }
    }

    public final void mo477e(int i) {
        for (Integer intValue : this.f1563d.m3266a(i, -1)) {
            mo476d(intValue.intValue());
        }
    }

    public final void mo453a(int i, short s, int i2) {
        m3069a(i, s, null, i2, false);
    }

    public final void mo455a(int i, short s, String str, int i2) {
        m3069a(i, s, str, i2, false);
    }

    public final void mo469b(int i, short s, int i2) {
        m3069a(i, s, null, i2, true);
    }

    private void m3069a(int i, short s, String str, int i2, boolean z) {
        Poolable a = m3063a(i, 0, -1, true, false, false);
        if (z) {
            ((DefaultStatsLogger) this.f1566g.get()).a(i, s, (long) i2);
        }
        if (a != null) {
            PerformanceLoggingEvent performanceLoggingEvent = (PerformanceLoggingEvent) PerformanceLoggingEvent.f7929c.m4469b();
            performanceLoggingEvent.f7935i = i2;
            performanceLoggingEvent.f7936j = -1;
            performanceLoggingEvent.m12518a(2);
            performanceLoggingEvent.f7937k = i;
            performanceLoggingEvent.f7941o = s;
            performanceLoggingEvent.f7933g = this.f1562c.mo211a();
            performanceLoggingEvent.f7934h = this.f1561b.now();
            performanceLoggingEvent.f7932f = a.f460b;
            performanceLoggingEvent.f7938l = a.f466h;
            performanceLoggingEvent.f7939m = a.f467i;
            performanceLoggingEvent.f7940n = a.f468j;
            performanceLoggingEvent.f7942p = (short) 1;
            performanceLoggingEvent.f7943q = i2;
            performanceLoggingEvent.f7950x = str;
            QuickEvent.f459a.m4468a(a);
            m3070a(performanceLoggingEvent);
        }
    }

    public final boolean mo480f(int i) {
        return this.f1563d.m3281d(i, 0);
    }

    public final boolean mo484j(int i, int i2) {
        return this.f1563d.m3281d(i, i2);
    }

    private void m3070a(PerformanceLoggingEvent performanceLoggingEvent) {
        if (this.f1574o != null) {
            for (PerformanceLoggingEventVisitor a : this.f1574o) {
                a.mo494a(performanceLoggingEvent);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = performanceLoggingEvent.f7949w;
        int size = list.size();
        int i = size;
        for (String append : list) {
            stringBuilder.append(append);
            if (i > 1) {
                stringBuilder.append(",");
            }
            i--;
        }
        if (stringBuilder.length() > 0) {
            performanceLoggingEvent.f7948v.add("trace_tags");
            performanceLoggingEvent.f7948v.add(stringBuilder.toString());
        }
        m3077c(this, performanceLoggingEvent);
    }

    private void m3076b(final PerformanceLoggingEvent performanceLoggingEvent) {
        SimpleBackgroundExecutor simpleBackgroundExecutor = this.f1572m;
        simpleBackgroundExecutor.f1580b.schedule(new Runnable(this) {
            final /* synthetic */ QuickPerformanceLoggerImpl f23067b;

            public void run() {
                QuickPerformanceLoggerImpl.m3077c(this.f23067b, performanceLoggingEvent);
            }
        }, 5000, TimeUnit.MILLISECONDS);
        if (1 == 0) {
            PerformanceLoggingEvent.f7929c.m4468a(performanceLoggingEvent);
            this.f1567h = null;
        }
    }

    public static void m3077c(QuickPerformanceLoggerImpl quickPerformanceLoggerImpl, PerformanceLoggingEvent performanceLoggingEvent) {
        if (performanceLoggingEvent.f7930d) {
            TriState a = quickPerformanceLoggerImpl.f1571l.m3177a();
            if (a == TriState.YES) {
                PerformanceLoggingEvent.f7929c.m4468a(performanceLoggingEvent);
                quickPerformanceLoggerImpl.f1567h = null;
                return;
            } else if (a == TriState.UNSET) {
                quickPerformanceLoggerImpl.m3076b(performanceLoggingEvent);
                return;
            }
        }
        boolean contains = quickPerformanceLoggerImpl.f1568i.contains(Integer.valueOf(performanceLoggingEvent.f7937k));
        if (quickPerformanceLoggerImpl.mo470b()) {
            String str;
            String str2;
            StringBuilder stringBuilder = new StringBuilder();
            if (contains) {
                stringBuilder.append(" [SUPPRESSED]");
            }
            if (performanceLoggingEvent.f7950x != null) {
                stringBuilder.append(" ID=" + performanceLoggingEvent.m12525e());
            }
            if (performanceLoggingEvent.f7948v.size() > 0) {
                str = null;
                int i = 0;
                for (String str22 : performanceLoggingEvent.f7948v) {
                    i++;
                    if (i % 2 == 0) {
                        stringBuilder.append(", ");
                        stringBuilder.append(str);
                        stringBuilder.append("=");
                        stringBuilder.append(str22);
                    } else {
                        str = str22;
                    }
                }
            }
            str = f1560a;
            String str3 = "QPLSent - %s %s %d[ms] %s (1:%d) %s";
            Object[] objArr = new Object[6];
            if (performanceLoggingEvent.f7950x != null) {
                str22 = performanceLoggingEvent.f7950x;
            } else {
                str22 = performanceLoggingEvent.m12525e();
            }
            objArr[0] = str22;
            objArr[1] = ActionId.a(performanceLoggingEvent.f7941o);
            objArr[2] = Integer.valueOf(performanceLoggingEvent.f7935i);
            objArr[3] = PerformanceEventFields.m12724a(performanceLoggingEvent.f7940n, performanceLoggingEvent.f7939m);
            objArr[4] = Integer.valueOf(performanceLoggingEvent.f7938l);
            objArr[5] = stringBuilder.toString();
            BLog.a(str, str3, objArr);
        }
        if (!contains) {
            StandardDebugAndTestConfig standardDebugAndTestConfig = quickPerformanceLoggerImpl.f1570k;
            if (!PerfTestConfigBase.f1506a) {
                performanceLoggingEvent.f7944r = (DefaultHoneyClientLogger) quickPerformanceLoggerImpl.f1564e.get();
                ExecutorDetour.a(quickPerformanceLoggerImpl.f1572m.f1579a, performanceLoggingEvent, -780376341);
                quickPerformanceLoggerImpl.f1567h = performanceLoggingEvent;
            }
        }
        PerformanceLoggingEvent.f7929c.m4468a(performanceLoggingEvent);
        quickPerformanceLoggerImpl.f1567h = performanceLoggingEvent;
    }

    private QuickEvent m3063a(int i, int i2, long j, boolean z, boolean z2, boolean z3) {
        WrapperHoneySamplingConfig a = this.f1565f.m2927a();
        boolean z4 = a == null;
        boolean z5 = z4 || a.m4465a() || mo470b() || this.f1570k.m2933b();
        int a2 = m3058a(i, a, z5);
        if (a2 == Integer.MAX_VALUE) {
            return null;
        }
        return QuickEvent.m998a(i, i2, this.f1575p.nextInt(Integer.MAX_VALUE), a2, z5, z4, z3, j, z, this.f1562c.mo211a(), m3060a(z), z2);
    }

    private QuickEvent m3062a(int i, int i2, int i3, long j, boolean z, boolean z2, boolean z3) {
        long f = this.f1563d.m3283f(i2, i3);
        int i4 = (int) (-1 & f);
        if (i4 == Integer.MAX_VALUE) {
            return null;
        }
        WrapperHoneySamplingConfig a = this.f1565f.m2927a();
        boolean z4 = a == null;
        boolean z5 = z4 || a.m4465a() || mo470b() || this.f1570k.m2933b();
        return QuickEvent.m998a(i, i3, (int) (f >> 32), i4, z5, z4, z3, j, z, this.f1562c.mo211a(), m3060a(z), z2);
    }

    private int m3058a(int i, WrapperHoneySamplingConfig wrapperHoneySamplingConfig, boolean z) {
        if (!z) {
            return this.f1565f.m2926a(wrapperHoneySamplingConfig.m4464a(i));
        }
        Object obj;
        int a;
        if (wrapperHoneySamplingConfig == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!this.f1570k.m2933b() || this.f1570k.m2934d()) {
            Integer num = (Integer) this.f1569j.get(i);
            a = num != null ? this.f1565f.m2926a(num.intValue()) : obj != null ? this.f1565f.m2926a(100) : 1;
        } else {
            a = 1;
        }
        return a;
    }

    private long m3059a(long j) {
        if (j == -1) {
            return this.f1561b.now();
        }
        return j;
    }

    private static PerfStats m3061a(PerfStats perfStats) {
        if (perfStats == null) {
            return null;
        }
        if (perfStats.b) {
            return perfStats;
        }
        perfStats.m();
        return perfStats;
    }

    private long m3060a(boolean z) {
        return (this.f1576q == null || !z) ? -1 : this.f1576q.a.a();
    }

    public final boolean mo470b() {
        if (this.f1573n == TriState.UNSET) {
            this.f1573n = this.f1570k.m2932a();
        }
        return this.f1573n.asBoolean(false);
    }

    public long currentMonotonicTimestamp() {
        return this.f1561b.now();
    }

    public final boolean mo472c() {
        WrapperHoneySamplingConfig a = this.f1565f.m2927a();
        return a != null && a.m4465a();
    }

    private void m3072a(String str, int i) {
        Object obj;
        if (mo470b() && BLog.b(3)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            Integer.valueOf(i);
        }
    }

    private static String m3079g(int i) {
        return StringFormatUtil.formatStrLocaleSafe(DebugUtils.a(i));
    }

    private static int m3080k(int i, int i2) {
        return MarkersManager.m3262i(i, i2);
    }

    private static long m3074b(long j) {
        return TimeUnit.MILLISECONDS.toNanos(j);
    }

    private static boolean m3078c(long j) {
        return j == -1;
    }
}
