package com.facebook.dialtone.services;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.dialtone.DialtonePhotoCapController;
import com.facebook.dialtone.protocol.DialtoneGraphQL;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel;
import com.facebook.dialtone.protocol.DialtonePhotoQuotaAPIHandler;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.zero.common.constants.FbZeroTokenType;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: total_skipped_frames */
public class DialtonePhotoCapReminder {
    private static final Class<?> f16237a = DialtonePhotoCapReminder.class;
    private final Context f16238b;
    public final Provider<Boolean> f16239c;
    private final DialtonePhotoCapController f16240d;
    public final AppStateManager f16241e;
    public final DialtonePhotoQuotaAPIHandler f16242f;
    public final Lazy<FbErrorReporter> f16243g;
    public final TasksManager f16244h;
    private final Lazy<Toaster> f16245i;
    private final AnalyticsLogger f16246j;
    private final Lazy<FbSharedPreferences> f16247k;

    @Singleton
    /* compiled from: total_skipped_frames */
    public class LocalDialtonePhotoCapReminderReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<DialtonePhotoCapReminder> {
        private static volatile LocalDialtonePhotoCapReminderReceiverRegistration f2321a;

        public static com.facebook.dialtone.services.DialtonePhotoCapReminder.LocalDialtonePhotoCapReminderReceiverRegistration m4505a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2321a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.dialtone.services.DialtonePhotoCapReminder.LocalDialtonePhotoCapReminderReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2321a;	 Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
        L_0x000b:
            if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
        L_0x000d:
            r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
            r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
            r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
            r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
            r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
            r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
            r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
            r0 = m4506b(r0);	 Catch:{ all -> 0x0035 }
            f2321a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2321a;
            return r0;
        L_0x0035:
            r0 = move-exception;
            com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
            throw r0;	 Catch:{ all -> 0x0035 }
        L_0x003a:
            r0 = move-exception;
            r2.m1505c(r3);	 Catch:{ all -> 0x003a }
            throw r0;	 Catch:{ all -> 0x003a }
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003a }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.services.DialtonePhotoCapReminder.LocalDialtonePhotoCapReminderReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.services.DialtonePhotoCapReminder$LocalDialtonePhotoCapReminderReceiverRegistration");
        }

        private static LocalDialtonePhotoCapReminderReceiverRegistration m4506b(InjectorLike injectorLike) {
            return new LocalDialtonePhotoCapReminderReceiverRegistration(IdBasedLazy.m1808a(injectorLike, 1104));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            DialtonePhotoCapReminder dialtonePhotoCapReminder = (DialtonePhotoCapReminder) obj;
            if ("com.facebook.zero.ZERO_RATING_STATE_CHANGED".equals(intent.getAction()) && ((Boolean) dialtonePhotoCapReminder.f16239c.get()).booleanValue() && dialtonePhotoCapReminder.f16241e.m2264l()) {
                DialtonePhotoQuotaAPIHandler dialtonePhotoQuotaAPIHandler = dialtonePhotoCapReminder.f16242f;
                dialtonePhotoCapReminder.f16244h.m14553a(null, dialtonePhotoQuotaAPIHandler.f16258a.m10446a(GraphQLRequest.m11587a(DialtoneGraphQL.a())), new 1(dialtonePhotoCapReminder));
            }
        }

        @Inject
        public LocalDialtonePhotoCapReminderReceiverRegistration(Lazy<DialtonePhotoCapReminder> lazy) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, "com.facebook.zero.ZERO_RATING_STATE_CHANGED");
        }
    }

    public static DialtonePhotoCapReminder m23073b(InjectorLike injectorLike) {
        return new DialtonePhotoCapReminder((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 3958), DialtonePhotoCapController.m23074a(injectorLike), AppStateManager.m2245a(injectorLike), DialtonePhotoQuotaAPIHandler.m23080b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), TasksManager.m14550b(injectorLike), IdBasedLazy.m1808a(injectorLike, 3588), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078));
    }

    @Inject
    public DialtonePhotoCapReminder(Context context, Provider<Boolean> provider, DialtonePhotoCapController dialtonePhotoCapController, AppStateManager appStateManager, DialtonePhotoQuotaAPIHandler dialtonePhotoQuotaAPIHandler, Lazy<FbErrorReporter> lazy, TasksManager tasksManager, Lazy<Toaster> lazy2, AnalyticsLogger analyticsLogger, Lazy<FbSharedPreferences> lazy3) {
        this.f16238b = context;
        this.f16239c = provider;
        this.f16240d = dialtonePhotoCapController;
        this.f16241e = appStateManager;
        this.f16242f = dialtonePhotoQuotaAPIHandler;
        this.f16243g = lazy;
        this.f16244h = tasksManager;
        this.f16245i = lazy2;
        this.f16246j = analyticsLogger;
        this.f16247k = lazy3;
    }

    public static void m23071a(DialtonePhotoCapReminder dialtonePhotoCapReminder, DialtonePhotoQuotaModel dialtonePhotoQuotaModel) {
        long j = dialtonePhotoCapReminder.f16240d.f16256h;
        long a = dialtonePhotoQuotaModel.a();
        dialtonePhotoCapReminder.f16240d.m23078a(dialtonePhotoQuotaModel);
        if (j != 0 && a > j) {
            int k = dialtonePhotoQuotaModel.k();
            ((Toaster) dialtonePhotoCapReminder.f16245i.get()).m6456b(new ToastBuilder(dialtonePhotoCapReminder.f16238b.getResources().getQuantityString(2131689507, k, new Object[]{Integer.valueOf(k)})));
            dialtonePhotoCapReminder.m23072a("dialtone_photocapping_cap_reminder_toast_impression");
        }
    }

    private void m23072a(String str) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "dialtone";
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.m5090b("carrier_id", ((FbSharedPreferences) this.f16247k.get()).mo278a(FbZeroTokenType.NORMAL.getCarrierIdKey(), ""));
        this.f16246j.mo526a(honeyAnalyticsEvent);
    }
}
