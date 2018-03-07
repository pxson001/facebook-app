package com.facebook.privacy.checkup.protocol;

import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckup.FetchProfilePhotoCheckupMediaOnlyQueryString;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.FetchProfilePhotoCheckupMediaOnlyQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckup.FetchGenericPrivacyReviewQueryString;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: page/%s/notifications */
public class PrivacyCheckupClient {
    private static volatile PrivacyCheckupClient f4547e;
    public final GraphQLQueryExecutor f4548a;
    public final SizeAwareImageUtil f4549b;
    public final FetchReactorsParamBuilderUtil f4550c;
    public final FetchRecentActivityParamBuilderUtil f4551d;

    public static com.facebook.privacy.checkup.protocol.PrivacyCheckupClient m5808a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4547e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.checkup.protocol.PrivacyCheckupClient.class;
        monitor-enter(r1);
        r0 = f4547e;	 Catch:{ all -> 0x003a }
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
        r0 = m5809b(r0);	 Catch:{ all -> 0x0035 }
        f4547e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4547e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.protocol.PrivacyCheckupClient.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.protocol.PrivacyCheckupClient");
    }

    private static PrivacyCheckupClient m5809b(InjectorLike injectorLike) {
        return new PrivacyCheckupClient(GraphQLQueryExecutor.a(injectorLike), SizeAwareImageUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike));
    }

    @Inject
    public PrivacyCheckupClient(GraphQLQueryExecutor graphQLQueryExecutor, SizeAwareImageUtil sizeAwareImageUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil) {
        this.f4548a = graphQLQueryExecutor;
        this.f4549b = sizeAwareImageUtil;
        this.f4550c = fetchReactorsParamBuilderUtil;
        this.f4551d = fetchRecentActivityParamBuilderUtil;
    }

    public final ListenableFuture<GraphQLResult<FetchGenericPrivacyReviewQueryModel>> m5810a(int i, String str, @Nullable String str2, int i2, @Nullable String str3) {
        GraphQLRequest a = GraphQLRequest.a(FetchPrivacyCheckup.m5523d());
        a.a(new FetchGenericPrivacyReviewQueryString().a("max_num_steps", Integer.valueOf(i)).a("privacy_review_type", str).a("review_id", str3).a("item_count", String.valueOf(i2)).a("after", str2).a("image_scale", GraphQlQueryDefaults.a()).a);
        a.a(RequestPriority.INTERACTIVE);
        a.a(GraphQLCachePolicy.c);
        a.a(0);
        return this.f4548a.a(a);
    }

    public final ListenableFuture<GraphQLResult<FetchProfilePhotoCheckupMediaOnlyQueryModel>> m5811a(String str, String str2, int i) {
        GraphQLRequest a = GraphQLRequest.a(new FetchProfilePhotoCheckupMediaOnlyQueryString());
        GraphQlQueryString a2 = new FetchProfilePhotoCheckupMediaOnlyQueryString().a("first_count", String.valueOf(i)).a("after_cursor", str2).a("checkup_type", str);
        this.f4549b.a(a2);
        this.f4550c.a(a2);
        this.f4551d.a(a2);
        a.a(a2.a);
        return this.f4548a.a(a);
    }
}
