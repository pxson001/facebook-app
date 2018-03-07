package com.facebook.messaging.media.bandwidth;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.collect.RingBuffer;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mCleanupSync */
public class MediaBandwidthManager {
    private static final Pattern f8727d = Pattern.compile("mobile", 2);
    private static volatile MediaBandwidthManager f8728k;
    private final Cache<String, RingBuffer<QualityLevel>> f8729a;
    public final PrefKey f8730b = ((PrefKey) SharedPrefKeys.a.a("network_bandwidth/"));
    public final PrefKey f8731c = ((PrefKey) SharedPrefKeys.a.a("networks"));
    public final Context f8732e;
    public final Clock f8733f;
    private final FbNetworkManager f8734g;
    public final FbSharedPreferences f8735h;
    public final FbAlarmManagerImpl f8736i;
    private final DefaultAppChoreographer f8737j;

    /* compiled from: mCleanupSync */
    class C04171 implements Runnable {
        final /* synthetic */ MediaBandwidthManager f8738a;

        C04171(MediaBandwidthManager mediaBandwidthManager) {
            this.f8738a = mediaBandwidthManager;
        }

        public void run() {
            MediaBandwidthManager.m9029d(this.f8738a);
        }
    }

    /* compiled from: mCleanupSync */
    class C06552 implements ActionReceiver {
        final /* synthetic */ MediaBandwidthManager f14182a;

        C06552(MediaBandwidthManager mediaBandwidthManager) {
            this.f14182a = mediaBandwidthManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1761057556);
            MediaBandwidthManager mediaBandwidthManager = this.f14182a;
            if (mediaBandwidthManager.f8735h.a(mediaBandwidthManager.f8731c)) {
                String a2 = mediaBandwidthManager.f8735h.a(mediaBandwidthManager.f8731c, "");
                if (!a2.isEmpty()) {
                    String[] split = a2.split(",");
                    Editor edit = mediaBandwidthManager.f8735h.edit();
                    for (String a3 : split) {
                        edit.a((PrefKey) mediaBandwidthManager.f8730b.a(a3));
                    }
                    edit.a(mediaBandwidthManager.f8731c).commit();
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1173742730, a);
        }
    }

    public static com.facebook.messaging.media.bandwidth.MediaBandwidthManager m9026a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8728k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.bandwidth.MediaBandwidthManager.class;
        monitor-enter(r1);
        r0 = f8728k;	 Catch:{ all -> 0x003a }
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
        r0 = m9028b(r0);	 Catch:{ all -> 0x0035 }
        f8728k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8728k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.bandwidth.MediaBandwidthManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.bandwidth.MediaBandwidthManager");
    }

    private static MediaBandwidthManager m9028b(InjectorLike injectorLike) {
        return new MediaBandwidthManager((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbAlarmManagerImpl.a(injectorLike), DefaultAppChoreographer.a(injectorLike));
    }

    @Inject
    public MediaBandwidthManager(Context context, Clock clock, FbNetworkManager fbNetworkManager, FbSharedPreferences fbSharedPreferences, FbAlarmManagerImpl fbAlarmManagerImpl, DefaultAppChoreographer defaultAppChoreographer) {
        this.f8732e = context;
        this.f8733f = clock;
        this.f8734g = fbNetworkManager;
        this.f8735h = fbSharedPreferences;
        this.f8736i = fbAlarmManagerImpl;
        this.f8737j = defaultAppChoreographer;
        this.f8729a = CacheBuilder.newBuilder().a(15, TimeUnit.DAYS).a(1000).q();
        this.f8737j.a("SetupPurgeNetworkBandwidthSharedPrefsBroadcastReceiver", new C04171(this), Priority.APPLICATION_LOADED_LOW_PRIORITY, ThreadType.BACKGROUND);
    }

    public static void m9029d(MediaBandwidthManager mediaBandwidthManager) {
        mediaBandwidthManager.f8732e.registerReceiver(new DynamicSecureBroadcastReceiver("com.facebook.orca.media.bandwidth.ACTION_PURGE_NETWORKS_IN_SHARED_PREFS", new C06552(mediaBandwidthManager)), new IntentFilter("com.facebook.orca.media.bandwidth.ACTION_PURGE_NETWORKS_IN_SHARED_PREFS"));
        Calendar instance = Calendar.getInstance();
        instance.add(5, (7 - instance.get(7)) + 2);
        instance.set(10, 1);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        mediaBandwidthManager.f8736i.a(0, instance.getTimeInMillis(), 604800000, SecurePendingIntent.m10163b(mediaBandwidthManager.f8732e, 1, new Intent("com.facebook.orca.media.bandwidth.ACTION_PURGE_NETWORKS_IN_SHARED_PREFS"), 134217728));
    }

    @VisibleForTesting
    private String m9030h() {
        CharSequence k = this.f8734g.k();
        if (k != null) {
            if (k.equalsIgnoreCase("WIFI")) {
                WifiInfo o = this.f8734g.o();
                return "W" + (o != null ? o.getSSID() : "");
            } else if (f8727d.matcher(k).matches()) {
                return "M" + this.f8734g.b.getNetworkOperatorName();
            }
        }
        return "N";
    }

    private synchronized RingBuffer<QualityLevel> m9024a(String str) {
        RingBuffer<QualityLevel> ringBuffer;
        ringBuffer = (RingBuffer) this.f8729a.a(str);
        if (ringBuffer == null) {
            RingBuffer<QualityLevel> ringBuffer2 = new RingBuffer(15);
            if (this.f8735h.a((PrefKey) this.f8730b.a(str))) {
                String[] split = this.f8735h.a((PrefKey) this.f8730b.a(str), "").split(",");
                for (String parseInt : split) {
                    ringBuffer2.a(QualityLevel.values()[Integer.parseInt(parseInt)]);
                }
            }
            this.f8729a.a(str, ringBuffer2);
            ringBuffer = ringBuffer2;
        }
        return ringBuffer;
    }

    public final void m9031a() {
        String h = m9030h();
        synchronized (this) {
            m9024a(h).a(QualityLevel.FAILING);
        }
    }

    @VisibleForTesting
    final void m9032a(long j, long j2) {
        double d = ((((double) j) * 1.0d) / ((double) j2)) * 8.0d;
        String h = m9030h();
        synchronized (this) {
            RingBuffer a = m9024a(h);
            a.a(m9025a(d));
            m9027a(a, h);
        }
    }

    private void m9027a(RingBuffer<QualityLevel> ringBuffer, String str) {
        if (!this.f8735h.a((PrefKey) this.f8730b.a(str))) {
            this.f8735h.edit().a(this.f8731c, this.f8735h.a(this.f8731c, "").concat(str + ",")).commit();
        }
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(((QualityLevel) ringBuffer.a(0)).ordinal()));
        for (int i = 1; i < ringBuffer.b().size(); i++) {
            stringBuilder.append("," + Integer.toString(((QualityLevel) ringBuffer.a(i)).ordinal()));
        }
        this.f8735h.edit().a((PrefKey) this.f8730b.a(str), stringBuilder.toString()).commit();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.messaging.media.bandwidth.MediaBandwidthManager.ConnectionQualityMeasurement m9033b() {
        /*
        r12 = this;
        r10 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = 0;
        r0 = r12.m9030h();
        monitor-enter(r12);
        r0 = r12.m9024a(r0);	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r1 = r0.d();	 Catch:{ all -> 0x0058 }
        if (r1 != 0) goto L_0x0020;
    L_0x0014:
        r0 = new com.facebook.messaging.media.bandwidth.MediaBandwidthManager$ConnectionQualityMeasurement;	 Catch:{ all -> 0x0058 }
        r1 = com.facebook.messaging.media.bandwidth.MediaBandwidthManager.QualityLevel.UNKNOWN;	 Catch:{ all -> 0x0058 }
        r2 = com.facebook.messaging.media.bandwidth.MediaBandwidthManager.ConfidenceLevel.UNKNOWN;	 Catch:{ all -> 0x0058 }
        r3 = 0;
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0058 }
        monitor-exit(r12);	 Catch:{ all -> 0x0058 }
    L_0x001f:
        return r0;
    L_0x0020:
        r5 = r0.b();	 Catch:{ all -> 0x0058 }
        monitor-exit(r12);	 Catch:{ all -> 0x0058 }
        java.util.Collections.sort(r5);
        r4 = com.facebook.messaging.media.bandwidth.MediaBandwidthManager.ConfidenceLevel.LOW;
        r0 = r5.size();
        r0 = r0 / 2;
        r0 = r5.get(r0);
        r0 = (com.facebook.messaging.media.bandwidth.MediaBandwidthManager.QualityLevel) r0;
        r6 = r5.iterator();
        r2 = r3;
    L_0x003b:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x005b;
    L_0x0041:
        r1 = r6.next();
        r1 = (com.facebook.messaging.media.bandwidth.MediaBandwidthManager.QualityLevel) r1;
        r7 = r0.ordinal();
        r1 = r1.ordinal();
        r1 = r7 - r1;
        r1 = java.lang.Math.abs(r1);
        r1 = r1 + r2;
        r2 = r1;
        goto L_0x003b;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{  }
        throw r0;
    L_0x005b:
        r1 = r5.size();
        r6 = 1;
        if (r1 <= r6) goto L_0x0077;
    L_0x0062:
        r6 = (double) r2;
        r6 = r6 * r10;
        r1 = r5.size();
        r8 = (double) r1;
        r6 = r6 / r8;
        r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r1 > 0) goto L_0x0077;
    L_0x006e:
        r1 = com.facebook.messaging.media.bandwidth.MediaBandwidthManager.ConfidenceLevel.HIGH;
    L_0x0070:
        r2 = new com.facebook.messaging.media.bandwidth.MediaBandwidthManager$ConnectionQualityMeasurement;
        r2.<init>(r0, r1);
        r0 = r2;
        goto L_0x001f;
    L_0x0077:
        r1 = r4;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.bandwidth.MediaBandwidthManager.b():com.facebook.messaging.media.bandwidth.MediaBandwidthManager$ConnectionQualityMeasurement");
    }

    private static QualityLevel m9025a(double d) {
        if (d < 150.0d) {
            return QualityLevel.POOR;
        }
        if (d < 550.0d) {
            return QualityLevel.MODERATE;
        }
        if (d < 2000.0d) {
            return QualityLevel.GOOD;
        }
        return QualityLevel.EXCELLENT;
    }

    public final boolean m9034c() {
        if (this.f8734g.h()) {
            return false;
        }
        ConnectionQualityMeasurement b = m9033b();
        ConfidenceLevel confidenceLevel = b.b;
        QualityLevel qualityLevel = b.a;
        if (confidenceLevel == ConfidenceLevel.HIGH && qualityLevel == QualityLevel.EXCELLENT) {
            return true;
        }
        return false;
    }
}
