package com.facebook.vault.momentsupsell.data;

import android.content.Context;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQuery.MomentsAppPromotionQueryString;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryModels.MomentsAppPromotionFragmentModel;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryModels.MomentsAppPromotionFragmentModel.FacepileUsersModel;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryModels.MomentsAppPromotionQueryModel;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryModels.MomentsAppPromotionQueryModel.MomentsAppSyncedPhotosModel.EdgesModel;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import com.facebook.vault.momentsupsell.model.MomentsAppInterstitialInfo;
import com.facebook.vault.momentsupsell.model.MomentsAppTabInfo;
import com.facebook.vault.momentsupsell.model.MomentsAppTabInfo.Builder;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: threadkey */
public class MomentsUpsellQueryHelper {
    private static volatile MomentsUpsellQueryHelper f1723f;
    public final GraphQLQueryExecutor f1724a;
    public final ExecutorService f1725b;
    public final Context f1726c;
    private final AbstractFbErrorReporter f1727d;
    private final AppsInstallHelper f1728e;

    /* compiled from: threadkey */
    public class C01701 implements Function<GraphQLResult<MomentsAppPromotionQueryModel>, MomentsAppInfo> {
        final /* synthetic */ MomentsUpsellQueryHelper f1722a;

        public C01701(MomentsUpsellQueryHelper momentsUpsellQueryHelper) {
            this.f1722a = momentsUpsellQueryHelper;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            return MomentsUpsellQueryHelper.m1753a(this.f1722a, (MomentsAppPromotionQueryModel) graphQLResult.e);
        }
    }

    public static com.facebook.vault.momentsupsell.data.MomentsUpsellQueryHelper m1752a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1723f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.momentsupsell.data.MomentsUpsellQueryHelper.class;
        monitor-enter(r1);
        r0 = f1723f;	 Catch:{ all -> 0x003a }
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
        r0 = m1757b(r0);	 Catch:{ all -> 0x0035 }
        f1723f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1723f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.momentsupsell.data.MomentsUpsellQueryHelper.a(com.facebook.inject.InjectorLike):com.facebook.vault.momentsupsell.data.MomentsUpsellQueryHelper");
    }

    private static MomentsUpsellQueryHelper m1757b(InjectorLike injectorLike) {
        return new MomentsUpsellQueryHelper(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (AppsInstallHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class));
    }

    @Inject
    public MomentsUpsellQueryHelper(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Context context, AbstractFbErrorReporter abstractFbErrorReporter, AppsInstallHelperProvider appsInstallHelperProvider) {
        this.f1724a = graphQLQueryExecutor;
        this.f1725b = executorService;
        this.f1726c = context;
        this.f1727d = abstractFbErrorReporter;
        this.f1728e = appsInstallHelperProvider.a(new MomentsInstallInfo());
    }

    public final ListenableFuture<MomentsAppInfo> m1759a() {
        GraphQlQueryString momentsAppPromotionQueryString = new MomentsAppPromotionQueryString();
        momentsAppPromotionQueryString.a("photo_count", Integer.valueOf(1));
        momentsAppPromotionQueryString.a("thumbnail_size", Integer.valueOf(160));
        return Futures.a(this.f1724a.a(GraphQLRequest.a(momentsAppPromotionQueryString).a(m1756b()).a(GraphQLCachePolicy.a)), new C01701(this), this.f1725b);
    }

    public final boolean m1760a(@Nullable MomentsAppInfo momentsAppInfo) {
        return momentsAppInfo == null || momentsAppInfo.f1772a != m1758c();
    }

    private long m1756b() {
        return m1758c() ? 10800 : 86400;
    }

    private boolean m1758c() {
        return this.f1728e.a();
    }

    public static MomentsAppInfo m1753a(@Nullable MomentsUpsellQueryHelper momentsUpsellQueryHelper, MomentsAppPromotionQueryModel momentsAppPromotionQueryModel) {
        boolean z;
        boolean c = momentsUpsellQueryHelper.m1758c();
        MomentsAppInterstitialInfo a = m1754a(momentsAppPromotionQueryModel, c);
        MomentsAppTabInfo momentsAppTabInfo = null;
        if (!(momentsAppPromotionQueryModel == null || momentsAppPromotionQueryModel.m1871b() == null || momentsAppPromotionQueryModel.m1871b().m1864b() == null || !momentsAppPromotionQueryModel.m1871b().m1864b().m1834k())) {
            ImmutableList immutableList;
            Builder builder = new Builder();
            builder.f1799a = momentsAppPromotionQueryModel.m1871b().m1864b().m1831d();
            builder = builder;
            if (momentsAppPromotionQueryModel == null || momentsAppPromotionQueryModel.m1870a() == null || momentsAppPromotionQueryModel.m1870a().m1848a() == null || momentsAppPromotionQueryModel.m1870a().m1848a().isEmpty()) {
                immutableList = RegularImmutableList.a;
            } else {
                ImmutableList.Builder builder2 = ImmutableList.builder();
                ImmutableList a2 = momentsAppPromotionQueryModel.m1870a().m1848a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a2.get(i);
                    if (!(edgesModel == null || edgesModel.m1844a() == null || edgesModel.m1844a().m1769b() == null || edgesModel.m1844a().m1769b().d() == null)) {
                        builder2.c(edgesModel.m1844a().m1769b().d());
                    }
                }
                immutableList = builder2.b();
            }
            builder.f1800b = immutableList;
            builder = builder;
            builder.f1801c = momentsUpsellQueryHelper.f1726c.getString(2131239340);
            builder = builder;
            builder.f1802d = "moments://";
            momentsAppTabInfo = new MomentsAppTabInfo(builder);
        }
        MomentsAppTabInfo momentsAppTabInfo2 = momentsAppTabInfo;
        MomentsAppInfo.Builder newBuilder = MomentsAppInfo.newBuilder();
        newBuilder.f1765a = c;
        newBuilder = newBuilder;
        newBuilder.f1766b = momentsUpsellQueryHelper.m1755a(momentsAppPromotionQueryModel, a, c);
        MomentsAppInfo.Builder builder3 = newBuilder;
        builder3.f1767c = a;
        MomentsAppInfo.Builder builder4 = builder3;
        if (momentsAppTabInfo2 != null) {
            c = true;
        } else {
            c = false;
        }
        builder4.f1768d = c;
        builder3 = builder4;
        if (momentsAppPromotionQueryModel == null || momentsAppPromotionQueryModel.m1871b() == null || momentsAppPromotionQueryModel.m1871b().m1862a() == null || momentsAppPromotionQueryModel.m1871b().m1862a().m1853a() != 0 || momentsAppPromotionQueryModel.m1871b().m1864b() != null) {
            z = false;
        } else {
            z = true;
        }
        builder3.f1769e = z;
        builder3 = builder3;
        if (momentsAppPromotionQueryModel == null || momentsAppPromotionQueryModel.m1871b() == null || !momentsAppPromotionQueryModel.m1871b().m1865c()) {
            z = false;
        } else {
            z = true;
        }
        builder3.f1770f = z;
        builder3 = builder3;
        builder3.f1771g = momentsAppTabInfo2;
        return builder3.m1903a();
    }

    private boolean m1755a(@Nullable MomentsAppPromotionQueryModel momentsAppPromotionQueryModel, MomentsAppInterstitialInfo momentsAppInterstitialInfo, boolean z) {
        boolean z2;
        boolean z3 = (momentsAppPromotionQueryModel == null || momentsAppPromotionQueryModel.m1871b() == null || momentsAppPromotionQueryModel.m1871b().m1864b() == null || !momentsAppPromotionQueryModel.m1871b().m1864b().m1830c()) ? false : true;
        if (momentsAppInterstitialInfo != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (z3) {
                return true;
            }
            if (z) {
                return false;
            }
            return true;
        } else if (!z3) {
            return false;
        } else {
            this.f1727d.a("MomentsUpsell", "No interstitial data returned, but always show is true");
            return false;
        }
    }

    @Nullable
    private static MomentsAppInterstitialInfo m1754a(@Nullable MomentsAppPromotionQueryModel momentsAppPromotionQueryModel, boolean z) {
        String str = null;
        if (momentsAppPromotionQueryModel == null || momentsAppPromotionQueryModel.m1871b() == null || momentsAppPromotionQueryModel.m1871b().m1864b() == null) {
            return null;
        }
        MomentsAppPromotionFragmentModel b = momentsAppPromotionQueryModel.m1871b().m1864b();
        if (b.m1827a() == null || Strings.isNullOrEmpty(b.m1827a().m1782a()) || Strings.isNullOrEmpty(b.m1827a().m1783b()) || b.m1836m() == null || Strings.isNullOrEmpty(b.m1836m().m1817a()) || b.kl_() == null || Strings.isNullOrEmpty(b.kl_().a()) || b.kj_() == null || Strings.isNullOrEmpty(b.kj_().m1811a())) {
            return null;
        }
        String str2;
        ImmutableList immutableList;
        MomentsAppInterstitialInfo.Builder builder = new MomentsAppInterstitialInfo.Builder();
        builder.f1779a = b.m1836m().m1817a();
        builder = builder;
        builder.f1780b = b.kl_().a();
        builder = builder;
        builder.f1781c = b.kj_().m1811a();
        MomentsAppInterstitialInfo.Builder builder2 = builder;
        if (b.m1835l() == null) {
            str2 = null;
        } else {
            str2 = b.m1835l().a();
        }
        builder2.f1782d = str2;
        builder = builder2;
        if (b == null) {
            immutableList = RegularImmutableList.a;
        } else {
            ImmutableList.Builder builder3 = ImmutableList.builder();
            ImmutableList g = b.m1832g();
            int size = g.size();
            for (int i = 0; i < size; i++) {
                FacepileUsersModel facepileUsersModel = (FacepileUsersModel) g.get(i);
                if (!(facepileUsersModel.m1799b() == null || Strings.isNullOrEmpty(facepileUsersModel.m1799b().m1790a()))) {
                    builder3.c(facepileUsersModel.m1799b().m1790a());
                }
            }
            immutableList = builder3.b();
        }
        builder.f1783e = immutableList;
        builder2 = builder;
        if (z) {
            str2 = b.m1829b().m1775a();
        } else {
            str2 = b.m1827a().m1782a();
        }
        builder2.f1784f = str2;
        builder2 = builder2;
        if (z) {
            str2 = b.m1829b().m1776b();
        } else {
            str2 = b.m1827a().m1783b();
        }
        builder2.f1785g = str2;
        builder2 = builder2;
        builder2.f1786h = b.kk_() != null ? b.kk_().m1805a() : null;
        builder = builder2;
        if (b.kk_() != null) {
            str = b.kk_().m1806b();
        }
        builder.f1787i = str;
        builder = builder;
        builder.f1788j = b.m1833j();
        return new MomentsAppInterstitialInfo(builder);
    }
}
