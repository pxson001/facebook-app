package com.facebook.analytics.timespent;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.eventlisteners.AnalyticsEventListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.reporters.FeatureStatusReporter;
import com.facebook.analytics.timespent.TimeSpentBitArray.AppEvent;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_up_bytes */
public class TimeSpentEventReporter implements AnalyticsEventListener, DialtoneStateChangedListener {
    private static volatile TimeSpentEventReporter f13733g;
    private final Lazy<AnalyticsLogger> f13734a;
    public final Clock f13735b;
    public final AuthComponent f13736c = new AuthComponent(this);
    private final TimeSpentBitArray f13737d = new TimeSpentBitArray();
    private final Provider<String> f13738e;
    private final Lazy<FeatureStatusReporter> f13739f;

    @Singleton
    /* compiled from: total_up_bytes */
    public class TimeChangeReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<TimeSpentEventReporter> {
        private static volatile TimeChangeReceiverRegistration f2309a;

        public static com.facebook.analytics.timespent.TimeSpentEventReporter.TimeChangeReceiverRegistration m4491a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2309a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.analytics.timespent.TimeSpentEventReporter.TimeChangeReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2309a;	 Catch:{ all -> 0x003a }
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
            r0 = m4492b(r0);	 Catch:{ all -> 0x0035 }
            f2309a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2309a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.timespent.TimeSpentEventReporter.TimeChangeReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.analytics.timespent.TimeSpentEventReporter$TimeChangeReceiverRegistration");
        }

        private static TimeChangeReceiverRegistration m4492b(InjectorLike injectorLike) {
            return new TimeChangeReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 200));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            TimeSpentEventReporter timeSpentEventReporter = (TimeSpentEventReporter) obj;
            TimeSpentEventReporter.m20165a(timeSpentEventReporter, AppEvent.CLOCK_CHANGE, timeSpentEventReporter.f13735b.mo211a());
        }

        @Inject
        public TimeChangeReceiverRegistration(Lazy<TimeSpentEventReporter> lazy) {
            super(FbBroadcastManagerType.CROSS_PROCESS, (Lazy) lazy, "android.intent.action.TIME_SET");
        }
    }

    @Singleton
    /* compiled from: total_up_bytes */
    public class UserActivityReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<TimeSpentEventReporter> {
        private static volatile UserActivityReceiverRegistration f2310a;

        public static com.facebook.analytics.timespent.TimeSpentEventReporter.UserActivityReceiverRegistration m4493a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2310a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.analytics.timespent.TimeSpentEventReporter.UserActivityReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2310a;	 Catch:{ all -> 0x003a }
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
            r0 = m4494b(r0);	 Catch:{ all -> 0x0035 }
            f2310a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2310a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.timespent.TimeSpentEventReporter.UserActivityReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.analytics.timespent.TimeSpentEventReporter$UserActivityReceiverRegistration");
        }

        private static UserActivityReceiverRegistration m4494b(InjectorLike injectorLike) {
            return new UserActivityReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 200), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            TimeSpentEventReporter timeSpentEventReporter = (TimeSpentEventReporter) obj;
            if (intent.getAction().equals(AppStateManager.f1110b)) {
                TimeSpentEventReporter.m20165a(timeSpentEventReporter, AppEvent.FOREGROUNDED, timeSpentEventReporter.f13735b.mo211a());
            } else {
                TimeSpentEventReporter.m20165a(timeSpentEventReporter, AppEvent.BACKGROUNDED, timeSpentEventReporter.f13735b.mo211a());
            }
        }

        @Inject
        public UserActivityReceiverRegistration(Lazy<TimeSpentEventReporter> lazy, Handler handler) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, handler, AppStateManager.f1110b, AppStateManager.f1111c);
        }
    }

    /* compiled from: total_up_bytes */
    public class AuthComponent extends AbstractAuthComponent {
        final /* synthetic */ TimeSpentEventReporter f13748a;

        AuthComponent(TimeSpentEventReporter timeSpentEventReporter) {
            this.f13748a = timeSpentEventReporter;
        }

        public final void mo2666c() {
            TimeSpentEventReporter.m20165a(this.f13748a, AppEvent.BACKGROUNDED, this.f13748a.f13735b.mo211a());
        }

        public final void mo2665a(@Nullable AuthenticationResult authenticationResult) {
            TimeSpentEventReporter.m20165a(this.f13748a, AppEvent.LOGIN, this.f13748a.f13735b.mo211a());
        }
    }

    public static com.facebook.analytics.timespent.TimeSpentEventReporter m20164a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13733g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.timespent.TimeSpentEventReporter.class;
        monitor-enter(r1);
        r0 = f13733g;	 Catch:{ all -> 0x003a }
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
        r0 = m20166b(r0);	 Catch:{ all -> 0x0035 }
        f13733g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13733g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.timespent.TimeSpentEventReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.timespent.TimeSpentEventReporter");
    }

    private static TimeSpentEventReporter m20166b(InjectorLike injectorLike) {
        return new TimeSpentEventReporter(IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 178), IdBasedProvider.m1811a(injectorLike, 4442), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public TimeSpentEventReporter(Lazy<AnalyticsLogger> lazy, Lazy<FeatureStatusReporter> lazy2, Provider<String> provider, Clock clock) {
        this.f13734a = lazy;
        this.f13735b = clock;
        this.f13738e = provider;
        this.f13739f = lazy2;
    }

    public static synchronized void m20165a(TimeSpentEventReporter timeSpentEventReporter, AppEvent appEvent, long j) {
        synchronized (timeSpentEventReporter) {
            HoneyAnalyticsEvent a = timeSpentEventReporter.f13737d.m20173a(j, appEvent);
            if (a != null) {
                if (timeSpentEventReporter.f13738e.get() == null || appEvent == AppEvent.LOGIN) {
                    a.m5087a("pre_login", true);
                }
                ((FeatureStatusReporter) timeSpentEventReporter.f13739f.get()).a(a);
                ((AnalyticsLogger) timeSpentEventReporter.f13734a.get()).mo533c(a);
            }
        }
    }

    public final void mo2663a(long j) {
        m20165a(this, AppEvent.USER_ACTION, j);
    }

    public final void mo2664b(long j) {
        m20165a(this, AppEvent.USER_ACTION, j);
    }

    public final void iw_() {
        m20165a(this, AppEvent.DIALTONE, this.f13735b.mo211a());
    }

    public final void b_(boolean z) {
    }
}
