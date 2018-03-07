package com.facebook.prefetch.feed.scheduler;

import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: no_response */
public class NewsFeedPrefetcher implements IHaveUserData {
    public static final String f7079a = NewsFeedPrefetcher.class.getSimpleName();
    private static volatile NewsFeedPrefetcher f7080h;
    public final QeAccessor f7081b;
    private final ListeningExecutorService f7082c;
    public final AtomicBoolean f7083d = new AtomicBoolean(false);
    private final AsyncFeedXConfigReader f7084e;
    public final NewsFeedPrefetchScheduler f7085f;
    private final NewsFeedPrefetchPrediction f7086g;

    /* compiled from: no_response */
    class C03362 implements FutureCallback<Object> {
        final /* synthetic */ NewsFeedPrefetcher f7104a;

        C03362(NewsFeedPrefetcher newsFeedPrefetcher) {
            this.f7104a = newsFeedPrefetcher;
        }

        public void onSuccess(Object obj) {
            this.f7104a.f7083d.set(false);
        }

        public void onFailure(Throwable th) {
            this.f7104a.f7083d.set(false);
            BLog.b(NewsFeedPrefetcher.f7079a, "NewsFeedPrefetcher reports failure.", th);
        }
    }

    public static com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher m7399a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7080h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher.class;
        monitor-enter(r1);
        r0 = f7080h;	 Catch:{ all -> 0x003a }
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
        r0 = m7400b(r0);	 Catch:{ all -> 0x0035 }
        f7080h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7080h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher.a(com.facebook.inject.InjectorLike):com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher");
    }

    private static NewsFeedPrefetcher m7400b(InjectorLike injectorLike) {
        return new NewsFeedPrefetcher((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), AsyncFeedXConfigReader.a(injectorLike), NewsFeedPrefetchScheduler.m7403a(injectorLike), NewsFeedPrefetchPrediction.m7422b(injectorLike));
    }

    @Inject
    public NewsFeedPrefetcher(QeAccessor qeAccessor, ListeningExecutorService listeningExecutorService, AsyncFeedXConfigReader asyncFeedXConfigReader, NewsFeedPrefetchScheduler newsFeedPrefetchScheduler, NewsFeedPrefetchPrediction newsFeedPrefetchPrediction) {
        this.f7081b = qeAccessor;
        this.f7082c = listeningExecutorService;
        this.f7084e = asyncFeedXConfigReader;
        this.f7085f = newsFeedPrefetchScheduler;
        this.f7086g = newsFeedPrefetchPrediction;
    }

    public void clearUserData() {
        this.f7085f.m7409a();
    }

    public final void m7401a() {
        long b;
        if (this.f7081b.a(ExperimentsForNewsFeedAbTestModule.c, false)) {
            this.f7086g.m7427a(this.f7084e.a(NewsFeedPrefetchPrediction.m7420a()));
            b = this.f7086g.m7428b();
        } else {
            b = (long) this.f7084e.a(360);
        }
        int i = this.f7084e.i(60);
        if (b < ((long) i)) {
            b = (long) i;
        }
        m7402a(b);
    }

    public final void m7402a(final long j) {
        if (1 != 0 && !this.f7083d.getAndSet(true)) {
            Futures.a(this.f7082c.a(new Runnable(this) {
                final /* synthetic */ NewsFeedPrefetcher f7103b;

                public void run() {
                    this.f7103b.f7085f.m7409a();
                    this.f7103b.f7085f.m7410a(j);
                }
            }), new C03362(this), this.f7082c);
        }
    }
}
