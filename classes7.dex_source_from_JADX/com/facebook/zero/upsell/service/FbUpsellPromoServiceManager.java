package com.facebook.zero.upsell.service;

import android.os.Bundle;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.upsell.model.ZeroPromoParams;
import com.facebook.iorg.common.upsell.server.UpsellPromo;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.service.ZeroHeaderRequestManager;
import com.facebook.zero.upsell.annotations.IsInZeroUpsellGetPromosGraphQLGatekeeper;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQL.ZeroUpsellRecoString;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLModels.ZeroUpsellRecoModel;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLModels.ZeroUpsellRecoModel.MobileCarrierAccountModel;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLModels.ZeroUpsellRecoModel.MobileCarrierAccountModel.CarrierAccountUpsellProductsModel;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLModels.ZeroUpsellRecoModel.MobileCarrierAccountModel.CarrierAccountUpsellProductsModel.EdgesModel;
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLModels.ZeroUpsellRecoModel.MobileCarrierAccountModel.CarrierAccountUpsellProductsModel.EdgesModel.NodeModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: visit_overview_tab */
public class FbUpsellPromoServiceManager {
    private static volatile FbUpsellPromoServiceManager f291i;
    public final DefaultBlueServiceOperationFactory f292a;
    public final ZeroHeaderRequestManager f293b;
    public final Lazy<ExecutorService> f294c;
    public final GraphQLQueryExecutor f295d;
    public final GraphQLCacheManager f296e;
    public final FbSharedPreferences f297f;
    @IsInZeroUpsellGetPromosGraphQLGatekeeper
    private final Provider<Boolean> f298g;
    public String f299h = "";

    /* compiled from: visit_overview_tab */
    public class C00421 implements Function<OperationResult, ZeroRecommendedPromoResult> {
        final /* synthetic */ FbUpsellPromoServiceManager f286a;

        public C00421(FbUpsellPromoServiceManager fbUpsellPromoServiceManager) {
            this.f286a = fbUpsellPromoServiceManager;
        }

        public Object apply(@Nullable Object obj) {
            return (ZeroRecommendedPromoResult) ((OperationResult) obj).h();
        }
    }

    /* compiled from: visit_overview_tab */
    public class C00432 implements Function<GraphQLResult<ZeroUpsellRecoModel>, ZeroRecommendedPromoResult> {
        final /* synthetic */ FbUpsellPromoServiceManager f287a;

        public C00432(FbUpsellPromoServiceManager fbUpsellPromoServiceManager) {
            this.f287a = fbUpsellPromoServiceManager;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FbUpsellPromoServiceManager fbUpsellPromoServiceManager = this.f287a;
            MobileCarrierAccountModel a = ((ZeroUpsellRecoModel) graphQLResult.e).m313a();
            fbUpsellPromoServiceManager.f297f.edit().a(ZeroPrefKeys.v, (long) a.m308a().m294k()).commit();
            return FbUpsellPromoServiceManager.m334a(a);
        }
    }

    /* compiled from: visit_overview_tab */
    public class C00453 implements AsyncFunction<OperationResult, ZeroPromoResult> {
        final /* synthetic */ ZeroPromoParams f289a;
        final /* synthetic */ FbUpsellPromoServiceManager f290b;

        /* compiled from: visit_overview_tab */
        class C00441 implements Function<OperationResult, ZeroPromoResult> {
            final /* synthetic */ C00453 f288a;

            C00441(C00453 c00453) {
                this.f288a = c00453;
            }

            public Object apply(@Nullable Object obj) {
                return (ZeroPromoResult) ((OperationResult) obj).h();
            }
        }

        public C00453(FbUpsellPromoServiceManager fbUpsellPromoServiceManager, ZeroPromoParams zeroPromoParams) {
            this.f290b = fbUpsellPromoServiceManager;
            this.f289a = zeroPromoParams;
        }

        public final ListenableFuture m333a(Object obj) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("zeroBuyPromoParams", this.f289a);
            return Futures.a(BlueServiceOperationFactoryDetour.a(this.f290b.f292a, "zero_buy_promo", bundle, -2124381697).a(), new C00441(this), (Executor) this.f290b.f294c.get());
        }
    }

    public static com.facebook.zero.upsell.service.FbUpsellPromoServiceManager m335a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f291i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.upsell.service.FbUpsellPromoServiceManager.class;
        monitor-enter(r1);
        r0 = f291i;	 Catch:{ all -> 0x003a }
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
        r0 = m336b(r0);	 Catch:{ all -> 0x0035 }
        f291i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f291i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.upsell.service.FbUpsellPromoServiceManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.upsell.service.FbUpsellPromoServiceManager");
    }

    private static FbUpsellPromoServiceManager m336b(InjectorLike injectorLike) {
        return new FbUpsellPromoServiceManager(DefaultBlueServiceOperationFactory.b(injectorLike), ZeroHeaderRequestManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3834), GraphQLQueryExecutor.a(injectorLike), GraphQLCacheManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4396));
    }

    @Inject
    public FbUpsellPromoServiceManager(BlueServiceOperationFactory blueServiceOperationFactory, ZeroHeaderRequestManager zeroHeaderRequestManager, Lazy<ExecutorService> lazy, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        this.f292a = blueServiceOperationFactory;
        this.f293b = zeroHeaderRequestManager;
        this.f294c = lazy;
        this.f295d = graphQLQueryExecutor;
        this.f296e = graphQLCacheManager;
        this.f297f = fbSharedPreferences;
        this.f298g = provider;
    }

    public final ListenableFuture<ZeroRecommendedPromoResult> m337a(ZeroRecommendedPromoParams zeroRecommendedPromoParams) {
        if (((Boolean) this.f298g.get()).booleanValue()) {
            GraphQlQueryParamSet graphQlQueryParamSet = new ZeroUpsellRecoString().a("location", zeroRecommendedPromoParams.a()).a("feature", zeroRecommendedPromoParams.b()).a("size", "MEGAPHONE_2X").a;
            long a = this.f297f.a(ZeroPrefKeys.v, 3600);
            GraphQLRequest a2 = GraphQLRequest.a(new ZeroUpsellRecoString());
            a2.e = ImmutableSet.of("ZeroUpsellRequest");
            GraphQLRequest a3 = a2.a(graphQlQueryParamSet).a(GraphQLCachePolicy.a).a(a);
            String a4 = this.f297f.a(ZeroPrefKeys.j, "");
            if (!a4.equals(this.f299h)) {
                this.f296e.a(ImmutableSet.of("ZeroUpsellRequest"));
                this.f299h = a4;
            }
            return Futures.a(this.f295d.a(a3), new C00432(this), (Executor) this.f294c.get());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("zeroBuyPromoParams", zeroRecommendedPromoParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f292a, "zero_get_recommended_promo", bundle, 1106102602).a(), new C00421(this), (Executor) this.f294c.get());
    }

    public static ZeroRecommendedPromoResult m334a(MobileCarrierAccountModel mobileCarrierAccountModel) {
        CarrierAccountUpsellProductsModel a = mobileCarrierAccountModel.m308a();
        String a2 = mobileCarrierAccountModel.m309j().m304a();
        String m = a.m296m();
        String n = a.m297n();
        String a3 = a.m291a();
        String l = a.m295l();
        ImmutableList j = a.m293j();
        Collection arrayList = new ArrayList();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) j.get(i);
            NodeModel a4 = edgesModel.m286a();
            arrayList.add(new UpsellPromo(a4.m281l(), "", a4.m281l(), a4.m280k(), edgesModel.m287j(), false, "", "", a4.m279j().equals(""), "", true, true, edgesModel.m287j(), "", ImmutableList.of()));
        }
        return new ZeroRecommendedPromoResult(m, n, a2, null, null, null, null, null, 0, null, null, 0, ImmutableList.copyOf(arrayList), null, null, 0, 0, ImmutableList.of(), null, null, false, null, null, null, null, null, null, null, a3, l);
    }
}
