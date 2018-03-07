package com.facebook.richdocument.fetcher;

import android.content.Context;
import com.facebook.common.util.SizeUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphql.RichDocumentHTMLNativeAdQueryString;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentHTMLNativeAdFragmentModel;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentHTMLNativeAdFragmentModel.FallbackNativeAdModel;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentNativeAdFragmentModel;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlModels.RichDocumentNativeAdFragmentModel.NativeTypedAdObjectModel;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: presence_acquired_at */
public class NativeAdFetcher {
    private static volatile NativeAdFetcher f5226b;
    public final GraphQLQueryExecutor f5227a;

    /* compiled from: presence_acquired_at */
    public class C06871 implements Function<GraphQLResult<RichDocumentNativeAdFragmentModel>, NativeTypedAdObjectModel> {
        final /* synthetic */ NativeAdFetcher f5224a;

        public C06871(NativeAdFetcher nativeAdFetcher) {
            this.f5224a = nativeAdFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || graphQLResult.e == null) ? null : ((RichDocumentNativeAdFragmentModel) graphQLResult.e).m6760a();
        }
    }

    /* compiled from: presence_acquired_at */
    class C06882 implements Function<GraphQLResult<RichDocumentHTMLNativeAdFragmentModel>, FallbackNativeAdModel> {
        final /* synthetic */ NativeAdFetcher f5225a;

        C06882(NativeAdFetcher nativeAdFetcher) {
            this.f5225a = nativeAdFetcher;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return (graphQLResult == null || graphQLResult.e == null) ? null : ((RichDocumentHTMLNativeAdFragmentModel) graphQLResult.e).m6728a();
        }
    }

    public static com.facebook.richdocument.fetcher.NativeAdFetcher m5165a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5226b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.richdocument.fetcher.NativeAdFetcher.class;
        monitor-enter(r1);
        r0 = f5226b;	 Catch:{ all -> 0x003a }
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
        r0 = m5166b(r0);	 Catch:{ all -> 0x0035 }
        f5226b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5226b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.fetcher.NativeAdFetcher.a(com.facebook.inject.InjectorLike):com.facebook.richdocument.fetcher.NativeAdFetcher");
    }

    private static NativeAdFetcher m5166b(InjectorLike injectorLike) {
        return new NativeAdFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public NativeAdFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f5227a = graphQLQueryExecutor;
    }

    public final ListenableFuture<FallbackNativeAdModel> m5167a(Context context, String str, String str2, int i, int i2) {
        return Futures.a(this.f5227a.a(GraphQLRequest.a((RichDocumentHTMLNativeAdQueryString) new RichDocumentHTMLNativeAdQueryString().a("graphQLID", str).a("placementID", str2).a("imageWidth", Integer.valueOf(i)).a("imageHeight", Integer.valueOf(i2)).a("iconHeight", Integer.valueOf(SizeUtil.a(context, 8.0f))).a("iconWidth", Integer.valueOf(SizeUtil.a(context, 8.0f))).a("scale", ScaleInputPixelRatio.NUMBER_1))), new C06882(this), MoreExecutors.a());
    }
}
