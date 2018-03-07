package com.facebook.messaging.groups.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.groups.links.gatekeepers.JoinableLinksGatekeepers;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: showAlert */
public class GroupJoinableLinksLogger {
    private static volatile GroupJoinableLinksLogger f2477c;
    private final AnalyticsLogger f2478a;
    private final JoinableLinksGatekeepers f2479b;

    public static com.facebook.messaging.groups.logging.GroupJoinableLinksLogger m2486a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2477c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.groups.logging.GroupJoinableLinksLogger.class;
        monitor-enter(r1);
        r0 = f2477c;	 Catch:{ all -> 0x003a }
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
        r0 = m2487b(r0);	 Catch:{ all -> 0x0035 }
        f2477c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2477c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.groups.logging.GroupJoinableLinksLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.groups.logging.GroupJoinableLinksLogger");
    }

    private static GroupJoinableLinksLogger m2487b(InjectorLike injectorLike) {
        return new GroupJoinableLinksLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), JoinableLinksGatekeepers.m2480a(injectorLike));
    }

    @Inject
    public GroupJoinableLinksLogger(AnalyticsLogger analyticsLogger, JoinableLinksGatekeepers joinableLinksGatekeepers) {
        this.f2478a = analyticsLogger;
        this.f2479b = joinableLinksGatekeepers;
    }

    public final void m2490a(ThreadSummary threadSummary, String str) {
        int i = 1;
        if (m2488c(threadSummary)) {
            HoneyClientEventFast a = m2485a("joinable_exposure", threadSummary.a.i());
            if (a.a()) {
                HoneyClientEventFast a2 = a.a("entry_point", str).a("joinable_status", threadSummary.P == GroupType.HIDDEN ? 1 : 0);
                String str2 = "in_rollout";
                if (!this.f2479b.m2484b()) {
                    i = 0;
                }
                a2.a(str2, i);
                a.b();
            }
        }
    }

    public final void m2491a(ThreadSummary threadSummary, boolean z, String str) {
        if (m2488c(threadSummary)) {
            HoneyClientEventFast a = m2485a("joinable_pivot_on", threadSummary.a.i());
            if (a.a()) {
                a.a("entry_point", str).a("action", z ? 1 : 0).a("groupsize", threadSummary.h.size());
                if (threadSummary.a()) {
                    a.a("threadname", threadSummary.g);
                }
                a.b();
            }
        }
    }

    public final void m2493b(ThreadSummary threadSummary, String str) {
        if (m2488c(threadSummary)) {
            HoneyClientEventFast a = m2485a("joinable_share_action", threadSummary.a.i());
            if (a.a()) {
                a.a("action_type", str).a("groupsize", threadSummary.h.size());
                if (threadSummary.a()) {
                    a.a("threadname", threadSummary.g);
                }
                a.b();
            }
        }
    }

    public final void m2494c(ThreadSummary threadSummary, String str) {
        if (m2488c(threadSummary)) {
            HoneyClientEventFast a = m2485a("joinable_share_action", threadSummary.a.i());
            if (a.a()) {
                a.a("action_type", "share_to_app").a("app_shared_to", str);
                if (threadSummary.a()) {
                    a.a("threadname", threadSummary.g);
                }
                a.b();
            }
        }
    }

    public final void m2489a(ThreadSummary threadSummary) {
        if (m2488c(threadSummary)) {
            HoneyClientEventFast a = m2485a("joinable_decline_admin", threadSummary.a.i());
            if (a.a()) {
                a.b();
            }
        }
    }

    public final void m2492b(ThreadSummary threadSummary) {
        if (m2488c(threadSummary)) {
            HoneyClientEventFast a = m2485a("joinable_enabled", threadSummary.a.i());
            if (a.a()) {
                a.b();
            }
        }
    }

    private boolean m2488c(ThreadSummary threadSummary) {
        return threadSummary != null && threadSummary.a.b() && this.f2479b.m2482a();
    }

    private HoneyClientEventFast m2485a(String str, long j) {
        HoneyClientEventFast a = this.f2478a.a(str, false);
        if (a.a()) {
            a.a("tfbid", j);
        }
        return a;
    }
}
