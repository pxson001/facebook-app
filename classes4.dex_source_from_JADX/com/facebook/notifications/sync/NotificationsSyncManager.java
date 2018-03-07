package com.facebook.notifications.sync;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncType;
import com.facebook.notifications.sync.NotificationsSyncHelper.C03766;
import com.facebook.notifications.sync.NotificationsSyncHelper.C03777;
import com.facebook.notifications.sync.NotificationsSyncHelper.C03788;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.today.abtest.TodayExperimentController;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: moments_invite_data */
public class NotificationsSyncManager {
    private static volatile NotificationsSyncManager f7530g;
    private final NotificationsSyncHelper f7531a;
    public final FbSharedPreferences f7532b;
    private final Clock f7533c;
    private final TodayExperimentController f7534d;
    public final Set<Long> f7535e = new HashSet();
    private Optional<String> f7536f = Absent.INSTANCE;

    public static com.facebook.notifications.sync.NotificationsSyncManager m7821a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7530g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.sync.NotificationsSyncManager.class;
        monitor-enter(r1);
        r0 = f7530g;	 Catch:{ all -> 0x003a }
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
        r0 = m7823b(r0);	 Catch:{ all -> 0x0035 }
        f7530g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7530g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.sync.NotificationsSyncManager.a(com.facebook.inject.InjectorLike):com.facebook.notifications.sync.NotificationsSyncManager");
    }

    private static NotificationsSyncManager m7823b(InjectorLike injectorLike) {
        return new NotificationsSyncManager(NotificationsSyncHelper.m7834a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), TodayExperimentController.a(injectorLike));
    }

    @Inject
    public NotificationsSyncManager(NotificationsSyncHelper notificationsSyncHelper, FbSharedPreferences fbSharedPreferences, Clock clock, TodayExperimentController todayExperimentController) {
        this.f7531a = notificationsSyncHelper;
        this.f7532b = fbSharedPreferences;
        this.f7533c = clock;
        this.f7534d = todayExperimentController;
    }

    public final void m7831a(String str) {
        this.f7536f = Optional.of(str);
    }

    public final ListenableFuture<OperationResult> m7829a(ViewerContext viewerContext, SyncSource syncSource) {
        if (this.f7535e.contains(Long.valueOf(Long.parseLong(viewerContext.mUserId)))) {
            return NotificationsSyncConstants.f7692d;
        }
        SyncType syncType = (SyncType) NotificationsSyncConstants.f7691c.get(syncSource);
        if (this.f7534d.v() && syncType == SyncType.FULL) {
            syncType = SyncType.NEW_NOTIFICATIONS;
        }
        if ((syncSource == SyncSource.MQTT_NEW || syncSource == SyncSource.MQTT_FULL) && !m7822a()) {
            return NotificationsSyncConstants.f7692d;
        }
        SyncType syncType2;
        if (!(syncType != SyncType.FULL || syncSource == SyncSource.PULL_TO_REFRESH || m7824b())) {
            syncType = SyncType.NEW_NOTIFICATIONS;
            m7828a(viewerContext);
        }
        if (syncSource != SyncSource.PULL_TO_REFRESH || m7826d() >= 10000) {
            syncType2 = syncType;
        } else {
            syncType2 = SyncType.NEW_NOTIFICATIONS;
        }
        return this.f7531a.m7839a(viewerContext, syncType2, syncSource, null, 10, (String) this.f7536f.orNull());
    }

    public final ListenableFuture<OperationResult> m7828a(ViewerContext viewerContext) {
        NotificationsSyncHelper notificationsSyncHelper = this.f7531a;
        long parseLong = Long.parseLong(viewerContext.mUserId);
        ListenableFuture<OperationResult> listenableFuture = (ListenableFuture) NotificationsSyncHelper.f7538b.get(Long.valueOf(parseLong));
        if (listenableFuture == null) {
            String str;
            if (notificationsSyncHelper.f7552o.v()) {
                str = "fetchNotificationSeenStatesServerOnly";
            } else {
                str = "fecthNotificationSeenStates";
            }
            listenableFuture = Futures.b(notificationsSyncHelper.f7544g.a(new C03766(notificationsSyncHelper, parseLong)), new C03777(notificationsSyncHelper, str), notificationsSyncHelper.f7544g);
            if (NotificationsSyncHelper.f7538b.putIfAbsent(Long.valueOf(parseLong), listenableFuture) == null) {
                Futures.a(listenableFuture, new C03788(notificationsSyncHelper, Long.valueOf(parseLong), NotificationsSyncHelper.f7538b));
            }
        }
        return listenableFuture;
    }

    public final ListenableFuture<OperationResult> m7830a(ViewerContext viewerContext, String str, CallerContext callerContext, int i) {
        FetchGraphQLNotificationsParamsBuilder fetchGraphQLNotificationsParamsBuilder = new FetchGraphQLNotificationsParamsBuilder();
        fetchGraphQLNotificationsParamsBuilder.f7654a = DataFreshnessParam.STALE_DATA_OKAY;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7659f = viewerContext;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7655b = 10;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7657d = str;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7662i = true;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7660g = SyncSource.SCROLL.toString();
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7665l = i;
        FetchGraphQLNotificationsParamsBuilder fetchGraphQLNotificationsParamsBuilder2 = fetchGraphQLNotificationsParamsBuilder;
        if (this.f7536f.isPresent()) {
            fetchGraphQLNotificationsParamsBuilder2.f7667n = true;
            fetchGraphQLNotificationsParamsBuilder2.f7668o = (String) this.f7536f.get();
        }
        return this.f7531a.m7840a(fetchGraphQLNotificationsParamsBuilder2.m8038p(), callerContext);
    }

    public final void m7833c(long j) {
        this.f7535e.remove(Long.valueOf(j));
    }

    private boolean m7822a() {
        return m7825c() > this.f7532b.a(NotificationsSyncConstants.f7690b, 30000);
    }

    private boolean m7824b() {
        return m7826d() > 7200000;
    }

    private long m7825c() {
        return this.f7533c.a() - Math.max(this.f7532b.a(NotificationsPreferenceConstants.f7749z, 0), m7827f());
    }

    private long m7826d() {
        return this.f7533c.a() - m7827f();
    }

    private long m7827f() {
        return this.f7532b.a(NotificationsPreferenceConstants.f7712A, 0);
    }

    public final boolean m7832a(long j) {
        return NotificationsSyncHelper.f7537a.containsKey(Long.valueOf(j));
    }
}
