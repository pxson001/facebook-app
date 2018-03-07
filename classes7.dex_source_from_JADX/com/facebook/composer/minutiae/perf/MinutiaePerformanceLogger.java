package com.facebook.composer.minutiae.perf;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.base.Preconditions;
import java.util.Map;

/* compiled from: titleText is empty or null */
public abstract class MinutiaePerformanceLogger {
    public final PerformanceLogger f1604a;
    private final Map<String, String> f1605b;
    private final Map<Integer, Integer> f1606c;

    protected MinutiaePerformanceLogger(PerformanceLogger performanceLogger, Map<String, String> map, Map<Integer, Integer> map2) {
        this.f1604a = (PerformanceLogger) Preconditions.checkNotNull(performanceLogger);
        this.f1605b = (Map) Preconditions.checkNotNull(map);
        this.f1606c = (Map) Preconditions.checkNotNull(map2);
    }

    public final void m1652a(int i, String str) {
        this.f1604a.a(i, str);
        if (this.f1605b.containsKey(str)) {
            this.f1604a.a(((Integer) this.f1606c.get(Integer.valueOf(i))).intValue(), (String) this.f1605b.get(str));
        }
    }

    public final void m1654b(int i, String str) {
        this.f1604a.c(i, str);
        if (this.f1605b.containsKey(str)) {
            this.f1604a.a(((Integer) this.f1606c.get(Integer.valueOf(i))).intValue(), (String) this.f1605b.get(str));
        }
    }

    public final void m1655c(int i, String str) {
        this.f1604a.d(i, str);
        if (this.f1605b.containsKey(str)) {
            this.f1604a.d(((Integer) this.f1606c.get(Integer.valueOf(i))).intValue(), (String) this.f1605b.get(str));
        }
    }

    public final void m1653a(int i, String str, DataFreshnessResult dataFreshnessResult) {
        if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
            this.f1604a.c(i, str);
            this.f1604a.a(((Integer) this.f1606c.get(Integer.valueOf(i))).intValue(), (String) this.f1605b.get(str));
            return;
        }
        this.f1604a.a(i, str);
        this.f1604a.c(((Integer) this.f1606c.get(Integer.valueOf(i))).intValue(), (String) this.f1605b.get(str));
    }
}
