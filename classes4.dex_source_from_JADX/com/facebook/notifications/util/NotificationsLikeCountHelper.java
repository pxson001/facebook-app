package com.facebook.notifications.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: modifier */
public class NotificationsLikeCountHelper {
    private static volatile NotificationsLikeCountHelper f7566f;
    private final QeAccessor f7567a;
    public final Lazy<GraphQLQueryExecutor> f7568b;
    private final ListeningExecutorService f7569c;
    public final GraphQLNotificationsContentProviderHelper f7570d;
    public final AbstractFbErrorReporter f7571e;

    public static com.facebook.notifications.util.NotificationsLikeCountHelper m7851a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7566f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsLikeCountHelper.class;
        monitor-enter(r1);
        r0 = f7566f;	 Catch:{ all -> 0x003a }
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
        r0 = m7852b(r0);	 Catch:{ all -> 0x0035 }
        f7566f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7566f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsLikeCountHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsLikeCountHelper");
    }

    private static NotificationsLikeCountHelper m7852b(InjectorLike injectorLike) {
        return new NotificationsLikeCountHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2164), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLNotificationsContentProviderHelper.m7861a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public NotificationsLikeCountHelper(QeAccessor qeAccessor, Lazy<GraphQLQueryExecutor> lazy, ListeningExecutorService listeningExecutorService, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, FbErrorReporter fbErrorReporter) {
        this.f7567a = qeAccessor;
        this.f7568b = lazy;
        this.f7569c = listeningExecutorService;
        this.f7570d = graphQLNotificationsContentProviderHelper;
        this.f7571e = fbErrorReporter;
    }

    public final boolean m7854a() {
        return this.f7567a.a(ExperimentsForNotificationsAbtestModule.f7784w, false);
    }

    public static int m7850a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        if (PropertyHelper.f(graphQLStory) > 0) {
            return PropertyHelper.f(graphQLStory);
        }
        if (graphQLStory.aa_() > 0) {
            return graphQLStory.aa_();
        }
        if (graphQLStory.L() == null || graphQLStory.L().aa_() <= 0) {
            return 0;
        }
        return graphQLStory.L().aa_();
    }

    public final void m7853a(long j) {
        Futures.a(Futures.b(this.f7569c.a(new 1(this, j)), new 2(this), this.f7569c), new 3(this), this.f7569c);
    }
}
