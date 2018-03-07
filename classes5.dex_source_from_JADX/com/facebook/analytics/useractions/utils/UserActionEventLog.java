package com.facebook.analytics.useractions.utils;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.random.LazySecureRandom;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.security.SecureRandom;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: throwback_subtitle */
public class UserActionEventLog {
    private static volatile UserActionEventLog f1930e;
    private final AnalyticsLogger f1931a;
    public final MonotonicClock f1932b;
    public final SecureRandom f1933c;
    private long f1934d;

    public static com.facebook.analytics.useractions.utils.UserActionEventLog m2609a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1930e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.useractions.utils.UserActionEventLog.class;
        monitor-enter(r1);
        r0 = f1930e;	 Catch:{ all -> 0x003a }
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
        r0 = m2611b(r0);	 Catch:{ all -> 0x0035 }
        f1930e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1930e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.useractions.utils.UserActionEventLog.a(com.facebook.inject.InjectorLike):com.facebook.analytics.useractions.utils.UserActionEventLog");
    }

    private static UserActionEventLog m2611b(InjectorLike injectorLike) {
        return new UserActionEventLog(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), LazySecureRandom.m3839a(injectorLike));
    }

    @Inject
    public UserActionEventLog(AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock, SecureRandom secureRandom) {
        this.f1931a = analyticsLogger;
        this.f1932b = monotonicClock;
        this.f1933c = secureRandom;
    }

    public final void m2612a() {
        this.f1934d = (long) (((float) this.f1932b.now()) * this.f1933c.nextFloat());
        m2610a(new UserActionEvent(UserActionType.SESSION_STARTED));
    }

    private void m2610a(UserActionEvent userActionEvent) {
        userActionEvent.a("user_actions_session_id", this.f1934d);
        this.f1931a.a(userActionEvent);
        userActionEvent.toString();
    }

    public final void m2613a(UserActionType userActionType) {
        Preconditions.checkNotNull(userActionType);
        m2610a(new UserActionEvent(userActionType));
    }

    public final void m2614a(UserActionType userActionType, String str) {
        m2610a(new UserActionEvent(userActionType, str));
    }
}
