package com.facebook.goodwill.feed.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.goodwill.abtest.ExperimentsForGoodwillAbTestModule;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLModels.ThrowbackSettingsSubscriptionMutationModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: VOIP_TURN */
public class ThrowbackSettingsManager {
    private static volatile ThrowbackSettingsManager f21113h;
    public List<SubmitSubscriptionListener> f21114a = new ArrayList();
    Clock f21115b;
    ThrowbackSettingsProtocol f21116c;
    FbSharedPreferences f21117d;
    QeAccessor f21118e;
    AbstractDisposableFutureCallback<GraphQLResult<ThrowbackSettingsSubscriptionMutationModel>> f21119f = new C30041(this);
    public ThrowbackSubscriptionStatus f21120g;

    /* compiled from: VOIP_TURN */
    class C30041 extends AbstractDisposableFutureCallback<GraphQLResult<ThrowbackSettingsSubscriptionMutationModel>> {
        final /* synthetic */ ThrowbackSettingsManager f21112a;

        C30041(ThrowbackSettingsManager throwbackSettingsManager) {
            this.f21112a = throwbackSettingsManager;
        }

        protected final void m22060a(Object obj) {
            ThrowbackSettingsManager throwbackSettingsManager = this.f21112a;
            for (SubmitSubscriptionListener a : throwbackSettingsManager.f21114a) {
                a.mo950a();
            }
            throwbackSettingsManager.f21114a.clear();
        }

        protected final void m22061a(Throwable th) {
            ThrowbackSettingsManager throwbackSettingsManager = this.f21112a;
            for (SubmitSubscriptionListener b : throwbackSettingsManager.f21114a) {
                b.mo951b();
            }
            throwbackSettingsManager.f21114a.clear();
        }
    }

    /* compiled from: VOIP_TURN */
    public interface SubmitSubscriptionListener {
        void mo950a();

        void mo951b();
    }

    /* compiled from: VOIP_TURN */
    public enum ThrowbackSubscriptionStatus {
        STATUS_UNKNOW,
        STATUS_UNSUBSCRIBED,
        STATUS_SUBSCRIBED_ALL,
        STATUS_SUBSCRIBED_HIGHLIGHTS
    }

    public static com.facebook.goodwill.feed.data.ThrowbackSettingsManager m22064a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21113h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.goodwill.feed.data.ThrowbackSettingsManager.class;
        monitor-enter(r1);
        r0 = f21113h;	 Catch:{ all -> 0x003a }
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
        r0 = m22065b(r0);	 Catch:{ all -> 0x0035 }
        f21113h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21113h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.goodwill.feed.data.ThrowbackSettingsManager.a(com.facebook.inject.InjectorLike):com.facebook.goodwill.feed.data.ThrowbackSettingsManager");
    }

    private static ThrowbackSettingsManager m22065b(InjectorLike injectorLike) {
        return new ThrowbackSettingsManager(new ThrowbackSettingsProtocol(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike)), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThrowbackSettingsManager(ThrowbackSettingsProtocol throwbackSettingsProtocol, FbSharedPreferences fbSharedPreferences, Clock clock, QeAccessor qeAccessor) {
        this.f21116c = throwbackSettingsProtocol;
        this.f21117d = fbSharedPreferences;
        this.f21115b = clock;
        this.f21118e = qeAccessor;
    }

    public final synchronized void m22066a(boolean z, SubmitSubscriptionListener submitSubscriptionListener) {
        this.f21114a.add(submitSubscriptionListener);
        this.f21116c.m22071a(this.f21119f, z);
    }

    public final synchronized void m22067b() {
        this.f21117d.edit().a(ThrowbackFeedPrefKeys.f21082b, this.f21115b.a()).commit();
    }

    public final synchronized boolean m22068c() {
        return this.f21117d.a(ThrowbackFeedPrefKeys.f21082b, Long.MIN_VALUE) < this.f21115b.a() - 2592000000L;
    }

    public final boolean m22069e() {
        return this.f21120g == ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_ALL || this.f21120g == ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_HIGHLIGHTS;
    }

    public final boolean m22070f() {
        return this.f21118e.a(ExperimentsForGoodwillAbTestModule.g, false);
    }
}
