package com.facebook.bugreporter.scheduler;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.jobscheduler.compat.DisabledServiceWorkaround;
import com.facebook.content.SecurePendingIntent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.OneoffTask.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ispx_aggregation_stabilization_ms_isac */
public class BugReportRetryScheduler {
    private static final String f9768a = BugReportRetryScheduler.class.getName();
    private static volatile BugReportRetryScheduler f9769d;
    public final Context f9770b;
    public FbAlarmManagerImpl f9771c;

    public static com.facebook.bugreporter.scheduler.BugReportRetryScheduler m10185a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9769d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.scheduler.BugReportRetryScheduler.class;
        monitor-enter(r1);
        r0 = f9769d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10187b(r0);	 Catch:{ all -> 0x0035 }
        f9769d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9769d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.scheduler.BugReportRetryScheduler.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.scheduler.BugReportRetryScheduler");
    }

    private static BugReportRetryScheduler m10187b(InjectorLike injectorLike) {
        return new BugReportRetryScheduler((Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.a(injectorLike));
    }

    @Inject
    public BugReportRetryScheduler(Context context, FbAlarmManagerImpl fbAlarmManagerImpl) {
        this.f9770b = context;
        this.f9771c = fbAlarmManagerImpl;
    }

    public final boolean m10194a(long j) {
        m10186a();
        boolean z = false;
        if (m10193f()) {
            z = m10191d(j);
        }
        if (!z && m10192e()) {
            z = m10189c(j);
        }
        if (z) {
            return z;
        }
        Intent intent = new Intent(this.f9770b, AlarmsBroadcastReceiver.class);
        intent.setAction("com.facebook.bugreporter.scheduler.AlarmsBroadcastReceiver.RETRY_UPLOAD");
        this.f9771c.b(3, SystemClock.elapsedRealtime() + (60000 * j), SecurePendingIntent.m10163b(this.f9770b, 0, intent, 0));
        Long.valueOf(j);
        return true;
    }

    private void m10186a() {
        if (m10193f()) {
            m10190d();
        }
        if (m10192e()) {
            m10188c();
        }
        Intent intent = new Intent(this.f9770b, AlarmsBroadcastReceiver.class);
        intent.setAction("com.facebook.bugreporter.scheduler.AlarmsBroadcastReceiver.RETRY_UPLOAD");
        this.f9771c.a(SecurePendingIntent.m10163b(this.f9770b, 0, intent, 0));
    }

    private boolean m10189c(long j) {
        long j2 = 60 * j;
        OneoffTask b = new Builder().a(GCMBugReportService.class).a("GCMBugReportService").a(j2, 30 + j2).c(true).a(0).a(false).b(false).b();
        try {
            GcmNetworkManager.a(this.f9770b).a(b);
            Long.valueOf(j);
            return true;
        } catch (IllegalArgumentException e) {
            DisabledServiceWorkaround.m7416a(this.f9770b, new ComponentName(this.f9770b, b.a()), e);
            return false;
        }
    }

    @TargetApi(21)
    private boolean m10191d(long j) {
        ComponentName componentName = new ComponentName(this.f9770b, LollipopBugReportService.class);
        try {
            boolean z = ((JobScheduler) this.f9770b.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(2131558606, componentName).setRequiredNetworkType(1).setMinimumLatency(60000 * j).setRequiresDeviceIdle(false).build()) > 0;
            if (!z) {
                return z;
            }
            Long.valueOf(j);
            return z;
        } catch (IllegalArgumentException e) {
            DisabledServiceWorkaround.m7416a(this.f9770b, componentName, e);
            return false;
        } catch (Throwable e2) {
            BLog.c(f9768a, e2, "Unexpected exception while scheduling using post-lollipop scheduler. The mBinder is null for some reason in JobSchedulerImpl.java. t9587579.", new Object[0]);
            return false;
        }
    }

    private void m10188c() {
        try {
            GcmNetworkManager.a(this.f9770b).a(GCMBugReportService.class);
        } catch (Throwable e) {
            BLog.c(f9768a, e, "Unexpected exception while scheduling using GCM scheduler. t9592389.", new Object[0]);
        }
    }

    @TargetApi(21)
    private void m10190d() {
        try {
            ((JobScheduler) this.f9770b.getSystemService("jobscheduler")).cancel(f9768a.hashCode());
        } catch (Throwable e) {
            BLog.c(f9768a, e, "Unexpected exception while canceling using post-lollipop scheduler. t9587579.", new Object[0]);
        } catch (Throwable e2) {
            BLog.c(f9768a, e2, "Unexpected exception while canceling using post-lollipop scheduler. The mBinder is null for some reason in JobSchedulerImpl.java. t9587579.", new Object[0]);
        }
    }

    private boolean m10192e() {
        try {
            GoogleApiAvailability.a();
            if (GoogleApiAvailability.a(this.f9770b) == 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            BLog.c(f9768a, e, "Unexpected exception while scheduling using GCM scheduler. GCM causes Package manager to die sometimes. t9600529.", new Object[0]);
            return false;
        }
    }

    private static boolean m10193f() {
        return VERSION.SDK_INT >= 21;
    }
}
