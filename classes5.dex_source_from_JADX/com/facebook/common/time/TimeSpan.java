package com.facebook.common.time;

import java.util.concurrent.TimeUnit;

/* compiled from: should_show_recent_mentions_entry_point */
public class TimeSpan {
    private final long f2736a;

    public TimeSpan(long j, TimeUnit timeUnit) {
        this.f2736a = timeUnit.toNanos(j);
    }

    private long m3852b() {
        return this.f2736a;
    }

    private long m3853c() {
        return TimeUnit.NANOSECONDS.toMicros(this.f2736a);
    }

    public final long m3858a() {
        return TimeUnit.NANOSECONDS.toMillis(this.f2736a);
    }

    private long m3854d() {
        return TimeUnit.NANOSECONDS.toSeconds(this.f2736a);
    }

    private long m3855e() {
        return TimeUnit.NANOSECONDS.toMinutes(this.f2736a);
    }

    private long m3856f() {
        return TimeUnit.NANOSECONDS.toHours(this.f2736a);
    }

    private long m3857g() {
        return TimeUnit.NANOSECONDS.toDays(this.f2736a);
    }

    public String toString() {
        long g = m3857g();
        long f = m3856f() % 24;
        long e = m3855e() % 60;
        long d = m3854d() % 60;
        long a = m3858a() % 1000;
        long c = m3853c() % 1000;
        long b = m3852b() % 1000;
        String str = "";
        StringBuilder stringBuilder = new StringBuilder("TimeSpan{");
        if (g > 0) {
            stringBuilder.append(g).append(" ");
            m3851a(stringBuilder, "Day", g);
            str = ", ";
        }
        if (f > 0) {
            stringBuilder.append(str).append(f).append(" ");
            m3851a(stringBuilder, "Hour", f);
            str = ", ";
        }
        if (e > 0) {
            stringBuilder.append(str).append(e).append(" ");
            m3851a(stringBuilder, "Minute", e);
            str = ", ";
        }
        if (d > 0) {
            stringBuilder.append(str).append(d).append(" ");
            m3851a(stringBuilder, "Second", d);
            str = ", ";
        }
        if (a > 0) {
            stringBuilder.append(str).append(a).append(" ");
            m3851a(stringBuilder, "Milli", a);
            str = ", ";
        }
        if (c > 0) {
            stringBuilder.append(str).append(c).append(" ");
            m3851a(stringBuilder, "Micro", c);
            str = ", ";
        }
        if (b > 0) {
            stringBuilder.append(str).append(b).append(" ");
            m3851a(stringBuilder, "Nano", b);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f2736a != ((TimeSpan) obj).f2736a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (this.f2736a ^ (this.f2736a >>> 32));
    }

    private static final void m3851a(StringBuilder stringBuilder, String str, long j) {
        stringBuilder.append(str);
        if (j > 1) {
            stringBuilder.append("s");
        }
    }
}
