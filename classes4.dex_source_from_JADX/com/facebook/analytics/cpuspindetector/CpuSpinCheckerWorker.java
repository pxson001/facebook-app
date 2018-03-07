package com.facebook.analytics.cpuspindetector;

import android.content.Context;
import android.util.Pair;
import com.facebook.analytics.CpuTimeGetter;
import com.facebook.analytics.CpuUsageData;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.StackTraceDumper;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: messenger_business_wifi_notifications_config */
public class CpuSpinCheckerWorker implements Runnable {
    private static final Class<?> f8041a = CpuSpinCheckerWorker.class;
    private final AbstractFbErrorReporter f8042b;
    private final MonotonicClock f8043c;
    private long f8044d;
    private long f8045e;
    private Map<String, Pair<String, CpuUsageData>> f8046f;
    private CpuUsageData f8047g;
    private final File f8048h;
    private final int f8049i = 50;
    private final int f8050j = 3600;

    @Inject
    public CpuSpinCheckerWorker(@ForAppContext Context context, AbstractFbErrorReporter abstractFbErrorReporter, MonotonicClock monotonicClock) {
        this.f8042b = abstractFbErrorReporter;
        this.f8046f = new HashMap();
        this.f8043c = monotonicClock;
        this.f8044d = this.f8043c.now();
        this.f8048h = new File(context.getDir("traces_cpuspin", 0), SafeUUIDGenerator.a().toString() + ".stacktrace");
    }

    public void run() {
        CpuUsageData a = CpuTimeGetter.a();
        Map b = CpuTimeGetter.b();
        if (a == null || b == null) {
            BLog.a(f8041a, "CPU Usage Data was null. Will wait for next time");
            return;
        }
        long now = this.f8043c.now();
        long j = (now - this.f8044d) / 1000;
        if (j <= 0) {
            BLog.a(f8041a, "Time Elapsed <=0. Current Time: %s, Previous Time: %s", new Object[]{Long.valueOf(now), Long.valueOf(this.f8044d)});
            return;
        }
        this.f8044d = now;
        if (this.f8047g != null) {
            double c = ((a.m8350c() - this.f8047g.m8350c()) / ((double) j)) * 100.0d;
            int max = Math.max(Runtime.getRuntime().availableProcessors(), 1) * 50;
            if (c > ((double) max)) {
                Integer.valueOf(max);
                Integer.valueOf((int) c);
                Long.valueOf(j);
                if (now - this.f8045e > 3600000) {
                    m8340a(m8338a(b, j));
                }
            } else {
                Integer.valueOf(max);
                Integer.valueOf((int) c);
                Long.valueOf(j);
            }
        }
        this.f8047g = a;
        this.f8046f = b;
    }

    private Map<String, Double> m8338a(Map<String, Pair<String, CpuUsageData>> map, long j) {
        Map<String, Double> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            double c = ((CpuUsageData) ((Pair) entry.getValue()).second).m8350c();
            if (this.f8046f.containsKey(str)) {
                hashMap.put(((Pair) entry.getValue()).first, Double.valueOf(((c - ((CpuUsageData) ((Pair) this.f8046f.get(str)).second).m8350c()) / ((double) j)) * 100.0d));
            }
        }
        return hashMap;
    }

    private void m8340a(Map<String, Double> map) {
        Throwable th;
        try {
            OutputStream fileOutputStream = new FileOutputStream(this.f8048h);
            Throwable th2 = null;
            try {
                StackTraceDumper.a(fileOutputStream);
                m8339a(fileOutputStream, (Map) map);
                this.f8048h.getAbsolutePath();
                Long.valueOf(this.f8048h.length());
                this.f8042b.b();
                this.f8045e = this.f8043c.now();
                fileOutputStream.close();
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (th22 != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                fileOutputStream.close();
            }
            throw th;
            throw th;
        } catch (Throwable th5) {
            BLog.b(f8041a, "Error writing cpuspin stacktrace ", th5);
        } catch (Throwable th52) {
            BLog.b(f8041a, "Error writing cpuspin stacktrace ", th52);
        }
    }

    private static void m8339a(OutputStream outputStream, Map<String, Double> map) {
        Throwable th;
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(outputStream);
            try {
                for (Entry entry : map.entrySet()) {
                    printWriter2.append((CharSequence) entry.getKey());
                    printWriter2.append(" : ");
                    printWriter2.append(((Double) entry.getValue()).toString());
                    printWriter2.append(", ");
                }
                printWriter2.flush();
                printWriter2.close();
            } catch (Throwable th2) {
                th = th2;
                printWriter = printWriter2;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (printWriter != null) {
                printWriter.close();
            }
            throw th;
        }
    }
}
