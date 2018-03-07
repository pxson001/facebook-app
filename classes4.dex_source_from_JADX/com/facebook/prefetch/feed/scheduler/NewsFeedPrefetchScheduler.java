package com.facebook.prefetch.feed.scheduler;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.jobscheduler.compat.DisabledServiceWorkaround;
import com.facebook.inject.InjectorLike;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.OneoffTask.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: no_ref */
public class NewsFeedPrefetchScheduler {
    private static volatile NewsFeedPrefetchScheduler f7087c;
    public final Context f7088a;
    public FbAlarmManagerImpl f7089b;

    public static com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchScheduler m7403a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7087c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchScheduler.class;
        monitor-enter(r1);
        r0 = f7087c;	 Catch:{ all -> 0x003a }
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
        r0 = m7404b(r0);	 Catch:{ all -> 0x0035 }
        f7087c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7087c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchScheduler.a(com.facebook.inject.InjectorLike):com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchScheduler");
    }

    private static NewsFeedPrefetchScheduler m7404b(InjectorLike injectorLike) {
        return new NewsFeedPrefetchScheduler((Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.a(injectorLike));
    }

    @Inject
    public NewsFeedPrefetchScheduler(Context context, FbAlarmManagerImpl fbAlarmManagerImpl) {
        this.f7088a = context;
        this.f7089b = fbAlarmManagerImpl;
    }

    public final void m7409a() {
        if (m7408f()) {
            ((JobScheduler) this.f7088a.getSystemService("jobscheduler")).cancel("NewsFeedPrefetchScheduler".hashCode());
        }
        if (m7407e()) {
            GcmNetworkManager.a(this.f7088a).a(NewsFeedPrefetchGCMService.class);
        }
        Intent intent = new Intent(this.f7088a, NewsFeedPrefetchBroadcastReceiver.class);
        intent.setAction("com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchBroadcastReceiver.INITIATE_BACKGROUND_FETCH");
        this.f7089b.a(PendingIntent.getBroadcast(this.f7088a, 0, intent, 0));
    }

    public final boolean m7410a(long j) {
        boolean z = false;
        if (m7408f()) {
            z = m7406d(j);
        }
        if (!z && m7407e()) {
            z = m7405c(j);
        }
        if (z) {
            return z;
        }
        Intent intent = new Intent(this.f7088a, NewsFeedPrefetchBroadcastReceiver.class);
        intent.setAction("com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchBroadcastReceiver.INITIATE_BACKGROUND_FETCH");
        this.f7089b.b(3, SystemClock.elapsedRealtime() + (60000 * j), PendingIntent.getBroadcast(this.f7088a, 0, intent, 0));
        Long.valueOf(j);
        return true;
    }

    private boolean m7405c(long j) {
        Builder builder = new Builder();
        builder.a(NewsFeedPrefetchGCMService.class);
        builder.a("NewsFeedPrefetchScheduler");
        long j2 = 60 * j;
        builder.a(j2, 30 + j2);
        builder.c(true);
        builder.a(0);
        builder.a(false);
        builder.b(true);
        GcmNetworkManager a = GcmNetworkManager.a(this.f7088a);
        OneoffTask b = builder.b();
        try {
            a.a(b);
        } catch (IllegalArgumentException e) {
            DisabledServiceWorkaround.m7416a(this.f7088a, new ComponentName(this.f7088a, b.a()), e);
        }
        Long.valueOf(j);
        return true;
    }

    @TargetApi(21)
    private boolean m7406d(long j) {
        boolean z;
        ComponentName componentName = new ComponentName(this.f7088a, NewsFeedPrefetchLollipopService.class);
        try {
            z = ((JobScheduler) this.f7088a.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(2131558769, componentName).setRequiredNetworkType(1).setMinimumLatency(60000 * j).setRequiresDeviceIdle(false).setPersisted(true).build()) > 0;
        } catch (IllegalArgumentException e) {
            DisabledServiceWorkaround.m7416a(this.f7088a, componentName, e);
            z = false;
        }
        if (z) {
            Long.valueOf(j);
        }
        return z;
    }

    private boolean m7407e() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.b;
        return GoogleApiAvailability.a(this.f7088a) == 0;
    }

    private static boolean m7408f() {
        return VERSION.SDK_INT >= 21;
    }
}
