package com.facebook.timeline.header.favphotos.edit;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.header.favphotos.FavoritePhotosUtil;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.TimelineCommonGraphQLModels.TimelinePhotoUriQueryModel;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_sent */
public class FetchFavoritePhotoController {
    private static volatile FetchFavoritePhotoController f11781c;
    public final GraphQLQueryExecutor f11782a;
    public final FavoritePhotosUtil f11783b;

    /* compiled from: fetch_sent */
    public class C16771 implements Function<GraphQLResult<TimelinePhotoUriQueryModel>, FavoritePhoto> {
        final /* synthetic */ String f11779a;
        final /* synthetic */ FetchFavoritePhotoController f11780b;

        public C16771(FetchFavoritePhotoController fetchFavoritePhotoController, String str) {
            this.f11780b = fetchFavoritePhotoController;
            this.f11779a = str;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((TimelinePhotoUriQueryModel) graphQLResult.e).a() == null) {
                return null;
            }
            return FavoritePhotosUtil.m11787a(this.f11779a, ((TimelinePhotoUriQueryModel) graphQLResult.e).a().b());
        }
    }

    public static com.facebook.timeline.header.favphotos.edit.FetchFavoritePhotoController m11845a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11781c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.header.favphotos.edit.FetchFavoritePhotoController.class;
        monitor-enter(r1);
        r0 = f11781c;	 Catch:{ all -> 0x003a }
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
        r0 = m11846b(r0);	 Catch:{ all -> 0x0035 }
        f11781c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11781c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.favphotos.edit.FetchFavoritePhotoController.a(com.facebook.inject.InjectorLike):com.facebook.timeline.header.favphotos.edit.FetchFavoritePhotoController");
    }

    private static FetchFavoritePhotoController m11846b(InjectorLike injectorLike) {
        return new FetchFavoritePhotoController(GraphQLQueryExecutor.a(injectorLike), FavoritePhotosUtil.m11786a(injectorLike));
    }

    @Inject
    public FetchFavoritePhotoController(GraphQLQueryExecutor graphQLQueryExecutor, FavoritePhotosUtil favoritePhotosUtil) {
        this.f11782a = graphQLQueryExecutor;
        this.f11783b = favoritePhotosUtil;
    }
}
