package com.facebook.analytics.reporters;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.appstatelogger.AppStateLogParser;
import com.facebook.analytics.appstatelogger.AppStateLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.analytics.util.ErrnoExtractor;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_ads_impression_logging_config */
public class AppStateReporter implements INeedInit {
    public static final String f8065a = AppStateReporter.class.getSimpleName();
    private final AnalyticsLogger f8066b;
    public final AnalyticsLoggingPolicy f8067c;
    public final ScheduledExecutorService f8068d;
    private final AppStateLogParser f8069e = m8355b();
    private final ReportAppStateRunnable f8070f = new ReportAppStateRunnable(this);
    public final Provider<String> f8071g;

    /* compiled from: messenger_ads_impression_logging_config */
    class ReportAppStateRunnable implements Runnable {
        final /* synthetic */ AppStateReporter f8072a;

        public ReportAppStateRunnable(AppStateReporter appStateReporter) {
            this.f8072a = appStateReporter;
        }

        public void run() {
            String str;
            TriState a = this.f8072a.f8067c.a("fbandroid_cold_start");
            if (((String) this.f8072a.f8071g.get()) == null) {
                str = "User not logged in";
            } else if (a == TriState.UNSET) {
                str = "Sampling config not available";
            } else {
                str = null;
            }
            if ((str != null ? 1 : null) != null) {
                String str2 = AppStateReporter.f8065a;
                Long.valueOf(1);
                this.f8072a.f8068d.schedule(this, 1, TimeUnit.MINUTES);
                return;
            }
            AppStateReporter.m8357c(this.f8072a);
        }
    }

    public static AppStateReporter m8356b(InjectorLike injectorLike) {
        return new AppStateReporter(AnalyticsLoggerMethodAutoProvider.a(injectorLike), AnalyticsLoggingPolicy.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public AppStateReporter(AnalyticsLogger analyticsLogger, AnalyticsLoggingPolicy analyticsLoggingPolicy, ScheduledExecutorService scheduledExecutorService, Provider<String> provider) {
        this.f8066b = analyticsLogger;
        this.f8067c = analyticsLoggingPolicy;
        this.f8068d = scheduledExecutorService;
        this.f8071g = provider;
    }

    @Nullable
    private static AppStateLogParser m8355b() {
        try {
            return new AppStateLogParser();
        } catch (Throwable e) {
            BLog.b(f8065a, "Error instantiating app state log parser", e);
            return null;
        }
    }

    public void init() {
        if (this.f8069e != null && AppStateLogger.c()) {
            ExecutorDetour.a(this.f8068d, this.f8070f, -297456540);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m8357c(com.facebook.analytics.reporters.AppStateReporter r15) {
        /*
        r4 = com.facebook.analytics.appstatelogger.AppStateLogger.d();
        r0 = r4.getParentFile();
        r0.getAbsolutePath();
        r5 = r0.listFiles();
        if (r5 != 0) goto L_0x0023;
    L_0x0011:
        r1 = f8065a;
        r2 = "No app state log files found in app state log directory: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r0.getAbsolutePath();
        r3[r4] = r0;
        com.facebook.debug.log.BLog.b(r1, r2, r3);
    L_0x0022:
        return;
    L_0x0023:
        r6 = r5.length;
        r0 = 0;
        r3 = r0;
    L_0x0026:
        if (r3 >= r6) goto L_0x0022;
    L_0x0028:
        r7 = r5[r3];
        r0 = r4.equals(r7);
        if (r0 == 0) goto L_0x0037;
    L_0x0030:
        r4.getAbsolutePath();
    L_0x0033:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0026;
    L_0x0037:
        r8 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x007d }
        r0 = "rw";
        r8.<init>(r7, r0);	 Catch:{ Exception -> 0x007d }
        r2 = 0;
        r9 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x00ae, all -> 0x00c5 }
        r0 = r8.getFD();	 Catch:{ Throwable -> 0x00ae, all -> 0x00c5 }
        r9.<init>(r0);	 Catch:{ Throwable -> 0x00ae, all -> 0x00c5 }
        r1 = 0;
        r0 = r8.getChannel();	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r0 = m8354a(r0);	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        if (r0 == 0) goto L_0x00ba;
    L_0x0053:
        r7.getAbsolutePath();	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r0 = r7.getName();	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r0 = m8353a(r0);	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r10 = r15.f8069e;	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r12 = r7.lastModified();	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r0 = r10.a(r9, r0, r12);	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r10 = r15.f8066b;	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r10.a(r0);	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        r0 = r7.delete();	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
        if (r0 == 0) goto L_0x0090;
    L_0x0073:
        r7.getAbsolutePath();	 Catch:{ Throwable -> 0x00a2, all -> 0x00be }
    L_0x0076:
        r9.close();	 Catch:{  }
        r8.close();	 Catch:{  }
        goto L_0x0033;
    L_0x007d:
        r0 = move-exception;
        r1 = f8065a;
        r2 = "Error reporting on app state log file: %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r7 = r7.getAbsolutePath();
        r8[r9] = r7;
        com.facebook.debug.log.BLog.b(r1, r0, r2, r8);
        goto L_0x0033;
    L_0x0090:
        r0 = f8065a;	 Catch:{  }
        r10 = "Failed to delete app state log file path: %s";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{  }
        r12 = 0;
        r13 = r7.getAbsolutePath();	 Catch:{  }
        r11[r12] = r13;	 Catch:{  }
        com.facebook.debug.log.BLog.b(r0, r10, r11);	 Catch:{  }
        goto L_0x0076;
    L_0x00a2:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00a4 }
    L_0x00a4:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x00a8:
        if (r1 == 0) goto L_0x00c8;
    L_0x00aa:
        r9.close();	 Catch:{ Throwable -> 0x00c0, all -> 0x00c5 }
    L_0x00ad:
        throw r0;	 Catch:{  }
    L_0x00ae:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00b0 }
    L_0x00b0:
        r1 = move-exception;
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x00b4:
        if (r1 == 0) goto L_0x00d1;
    L_0x00b6:
        r8.close();	 Catch:{ Throwable -> 0x00cc }
    L_0x00b9:
        throw r0;	 Catch:{  }
    L_0x00ba:
        r7.getAbsolutePath();	 Catch:{  }
        goto L_0x0076;
    L_0x00be:
        r0 = move-exception;
        goto L_0x00a8;
    L_0x00c0:
        r9 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r9);	 Catch:{  }
        goto L_0x00ad;
    L_0x00c5:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00b4;
    L_0x00c8:
        r9.close();	 Catch:{  }
        goto L_0x00ad;
    L_0x00cc:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);	 Catch:{  }
        goto L_0x00b9;
    L_0x00d1:
        r8.close();	 Catch:{  }
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.reporters.AppStateReporter.c(com.facebook.analytics.reporters.AppStateReporter):void");
    }

    @Nullable
    private static FileLock m8354a(FileChannel fileChannel) {
        FileLock fileLock = null;
        try {
            fileLock = fileChannel.tryLock();
        } catch (IOException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            } else if (ErrnoExtractor.a(cause) != 11) {
                throw e;
            }
        } catch (Throwable e2) {
            BLog.b(f8065a, e2, "Error acquiring lock", new Object[0]);
        }
        return fileLock;
    }

    private static String m8353a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(0, lastIndexOf);
    }
}
