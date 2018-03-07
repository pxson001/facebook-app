package com.facebook.today.notifications;

import android.app.Activity;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.notifications.util.NotificationsFetchCountHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.prefs.TodayPrefKeys;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: typeaheadUnit */
public class TodayNotificationsUtil {
    private static volatile TodayNotificationsUtil f1214k;
    public final Clock f1215a;
    private final AbstractFbErrorReporter f1216b;
    public final FbSharedPreferences f1217c;
    private final JewelCounters f1218d;
    private final NotificationsFetchCountHelper f1219e;
    private final DefaultNotificationsRenderer f1220f;
    private final NotificationsSyncManager f1221g;
    private final NotificationsUtils f1222h;
    private final TodayExperimentController f1223i;
    private final ViewerContextManager f1224j;

    public static com.facebook.today.notifications.TodayNotificationsUtil m1372a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1214k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.today.notifications.TodayNotificationsUtil.class;
        monitor-enter(r1);
        r0 = f1214k;	 Catch:{ all -> 0x003a }
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
        r0 = m1375b(r0);	 Catch:{ all -> 0x0035 }
        f1214k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1214k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.today.notifications.TodayNotificationsUtil.a(com.facebook.inject.InjectorLike):com.facebook.today.notifications.TodayNotificationsUtil");
    }

    private static TodayNotificationsUtil m1375b(InjectorLike injectorLike) {
        return new TodayNotificationsUtil((Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), JewelCounters.a(injectorLike), NotificationsFetchCountHelper.a(injectorLike), DefaultNotificationsRenderer.a(injectorLike), NotificationsSyncManager.a(injectorLike), NotificationsUtils.a(injectorLike), TodayExperimentController.a(injectorLike), ViewerContextManagerProvider.b(injectorLike));
    }

    @Inject
    public TodayNotificationsUtil(Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, JewelCounters jewelCounters, NotificationsFetchCountHelper notificationsFetchCountHelper, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsSyncManager notificationsSyncManager, NotificationsUtils notificationsUtils, TodayExperimentController todayExperimentController, ViewerContextManager viewerContextManager) {
        this.f1215a = clock;
        this.f1216b = abstractFbErrorReporter;
        this.f1217c = fbSharedPreferences;
        this.f1218d = jewelCounters;
        this.f1219e = notificationsFetchCountHelper;
        this.f1220f = defaultNotificationsRenderer;
        this.f1221g = notificationsSyncManager;
        this.f1222h = notificationsUtils;
        this.f1223i = todayExperimentController;
        this.f1224j = viewerContextManager;
    }

    public final boolean m1382a(int i) {
        boolean z = i != -1;
        if (!z) {
            this.f1216b.a(SoftError.b("Today Fragment does not contain NotificationCardShell", "Though we gracefully handle when this unit is not avilable, it is assumed that there should always be a unit with a GraphQLReactionUnitComponentStyle of NOTIFICATIONS_LIST"));
        }
        return z;
    }

    public final int m1376a(Activity activity, int i) {
        int a = this.f1219e.a(activity, activity.getWindowManager().getDefaultDisplay(), this.f1220f);
        int b = m1383b();
        if (b > 0) {
            i += b;
        }
        if (this.f1223i.C()) {
            b = this.f1223i.b.a(ExperimentsForTodayAbTestModule.p, 10);
        } else {
            b = 10;
        }
        return b + Math.max(a, i + 1);
    }

    public final void m1381a(List<NotificationsEdgeFields> list, int i) {
        if (this.f1223i.G()) {
            int a = this.f1223i.b.a(ExperimentsForTodayAbTestModule.I, 12);
            int b = m1383b();
            if (b > 0 || (a == 0 && !list.isEmpty())) {
                m1373a(b, i);
                return;
            }
            int i2 = 0;
            while (i2 + a <= list.size()) {
                int i3 = (a + i2) - 1;
                if (list.get(i2) == null || ((NotificationsEdgeFields) list.get(i2)).k() == null || list.get(i3) == null || ((NotificationsEdgeFields) list.get(i3)).k() == null || ((NotificationsEdgeFields) list.get(i2)).k().V() - ((NotificationsEdgeFields) list.get(i3)).k().V() > this.f1223i.l()) {
                    i2++;
                } else {
                    m1373a(b, i);
                    return;
                }
            }
        }
    }

    public final void m1377a() {
        if (this.f1223i.G()) {
            m1374a(0, 0);
        }
    }

    public final int m1383b() {
        if (!this.f1223i.G() || this.f1217c.a(TodayPrefKeys.f1240l, 0) <= 0) {
            return 0;
        }
        return this.f1217c.a(TodayPrefKeys.f1239k, 0);
    }

    public final void m1378a(long j) {
        if (this.f1223i.G()) {
            long a = this.f1217c.a(TodayPrefKeys.f1240l, 0);
            if (a > 0) {
                this.f1217c.edit().a(TodayPrefKeys.f1240l, a - j).commit();
            }
        }
    }

    public final void m1380a(AbstractReactionRecyclerViewAdapter abstractReactionRecyclerViewAdapter, boolean z, boolean z2) {
        if (abstractReactionRecyclerViewAdapter != null && abstractReactionRecyclerViewAdapter.d() != 0 && z && z2) {
            ViewerContext d = this.f1224j.d();
            if (d != null) {
                this.f1222h.a(d);
            }
        }
    }

    public final void m1379a(SyncSource syncSource) {
        this.f1221g.a(this.f1224j.d(), syncSource);
    }

    public final int m1384d() {
        return this.f1218d.a(Jewel.NOTIFICATIONS);
    }

    @VisibleForTesting
    private void m1373a(int i, int i2) {
        long a = this.f1217c.a(TodayPrefKeys.f1240l, 0);
        long a2 = ((long) i2) * (((long) this.f1223i.b.a(ExperimentsForTodayAbTestModule.J, 2)) * 1000);
        if (a < this.f1223i.m()) {
            m1374a(a2, i2);
        } else {
            m1374a(Math.max(a2, a), Math.max(i2, i));
        }
    }

    private void m1374a(long j, int i) {
        this.f1217c.edit().a(TodayPrefKeys.f1240l, Math.min(j, ((long) this.f1223i.b.a(ExperimentsForTodayAbTestModule.L, 6)) * 60000)).a(TodayPrefKeys.f1239k, i).commit();
    }
}
