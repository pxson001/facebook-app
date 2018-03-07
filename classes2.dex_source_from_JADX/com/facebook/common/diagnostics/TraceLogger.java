package com.facebook.common.diagnostics;

import android.os.SystemClock;
import com.facebook.common.stringformat.StringFormatUtil;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: typing */
public class TraceLogger {
    public static final Class<?> f2095a = TraceLogger.class;
    public static int f2096b = 0;
    protected final int f2097c;
    protected final int f2098d;
    protected boolean f2099e;
    private Queue<TraceLogLine> f2100f;
    private int f2101g;

    /* compiled from: typing */
    public class TraceLogLine {
        public final String f5951a;
        public final long f5952b;

        TraceLogLine(String str, long j) {
            this.f5951a = str;
            this.f5952b = j;
        }
    }

    public TraceLogger(int i, int i2) {
        if (i <= 0 || i >= 30) {
            this.f2097c = i;
            this.f2098d = i2;
            this.f2099e = false;
            m4283a();
            return;
        }
        throw new IllegalArgumentException("trace size limit must be at least " + 30 + " chars long");
    }

    public final void m4284a(String str) {
        synchronized (this) {
            if (this.f2098d > 0) {
                while (this.f2100f.size() + 1 > this.f2098d) {
                    m4281b();
                }
            }
            if (this.f2097c > 0) {
                if (str.length() > this.f2097c) {
                    str = "overly large log entry skipped";
                }
                while (this.f2101g + str.length() > this.f2097c) {
                    m4281b();
                }
            }
            m4282b(str);
        }
        if (this.f2099e) {
            new StringBuilder().append(f2095a).append("-copy");
        }
    }

    public final void m4285a(String str, Object... objArr) {
        m4284a(StringFormatUtil.a(str, objArr));
    }

    public synchronized String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder(this.f2101g + (this.f2100f.size() * 30));
        Object obj = 1;
        for (TraceLogLine traceLogLine : this.f2100f) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append('\n');
            }
            stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("[%d] %s", Long.valueOf(traceLogLine.f5952b), traceLogLine.f5951a));
        }
        return stringBuilder.toString();
    }

    public final synchronized void m4283a() {
        this.f2100f = new LinkedList();
        this.f2101g = 0;
    }

    private TraceLogLine m4281b() {
        TraceLogLine traceLogLine = (TraceLogLine) this.f2100f.remove();
        this.f2101g -= traceLogLine.f5951a.length();
        return traceLogLine;
    }

    private void m4282b(String str) {
        this.f2100f.offer(new TraceLogLine(str, SystemClock.uptimeMillis()));
        this.f2101g += str.length();
    }
}
