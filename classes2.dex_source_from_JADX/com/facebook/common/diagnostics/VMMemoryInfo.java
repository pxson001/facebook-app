package com.facebook.common.diagnostics;

import com.facebook.common.stringformat.StringFormatUtil;
import java.text.DecimalFormat;

/* compiled from: video_home/guide */
public class VMMemoryInfo {
    private static DecimalFormat f1195b = new DecimalFormat("##0.0");
    public final long f1196a;
    private final long f1197c;
    public final long f1198d;
    public final long f1199e;
    private long f1200f = -1;
    private long f1201g = -1;

    public VMMemoryInfo(Runtime runtime) {
        this.f1196a = runtime.totalMemory() - runtime.freeMemory();
        this.f1199e = runtime.maxMemory();
        this.f1198d = this.f1199e - this.f1196a;
        this.f1197c = this.f1199e;
    }

    private static String m2305a(long j, long j2) {
        double d = (((double) j) * 1.0d) / 1048576.0d;
        double d2 = (((double) j2) * 1.0d) / 1048576.0d;
        return StringFormatUtil.formatStrLocaleSafe("Max: %sM Used: %sM %s%%", f1195b.format(d), f1195b.format(d2), f1195b.format((d2 * 100.0d) / d));
    }

    public final boolean m2306a() {
        return this.f1199e <= 45088768;
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("Memory: JAVA [%s]  NATIVE [%s]", m2305a(this.f1199e, this.f1196a), m2305a(this.f1197c, this.f1200f));
    }
}
