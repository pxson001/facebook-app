package com.facebook.photos.photoset.ui.permalink.futures;

import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: click_source */
public class AlbumPermalinkFuturesGenerator {
    private static volatile AlbumPermalinkFuturesGenerator f17894f;
    public final Lazy<GraphQLQueryExecutor> f17895a;
    public final Lazy<GraphQLImageHelper> f17896b;
    private final GraphQLStoryHelper f17897c;
    public final FetchReactorsParamBuilderUtil f17898d;
    public final QeAccessor f17899e;

    public static com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator m21855a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17894f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator.class;
        monitor-enter(r1);
        r0 = f17894f;	 Catch:{ all -> 0x003a }
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
        r0 = m21856b(r0);	 Catch:{ all -> 0x0035 }
        f17894f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17894f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator.a(com.facebook.inject.InjectorLike):com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator");
    }

    private static AlbumPermalinkFuturesGenerator m21856b(InjectorLike injectorLike) {
        return new AlbumPermalinkFuturesGenerator(IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 2199), GraphQLStoryHelper.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AlbumPermalinkFuturesGenerator(Lazy<GraphQLQueryExecutor> lazy, Lazy<GraphQLImageHelper> lazy2, GraphQLStoryHelper graphQLStoryHelper, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, QeAccessor qeAccessor) {
        this.f17895a = lazy;
        this.f17896b = lazy2;
        this.f17897c = graphQLStoryHelper;
        this.f17898d = fetchReactorsParamBuilderUtil;
        this.f17899e = qeAccessor;
    }
}
