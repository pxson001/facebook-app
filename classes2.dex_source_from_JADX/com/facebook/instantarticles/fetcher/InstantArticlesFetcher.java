package com.facebook.instantarticles.fetcher;

import android.content.Context;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.fetcher.BaseLocalCachingFetcher;
import com.facebook.richdocument.fetcher.RichDocumentFeedbackFetcher;
import com.facebook.richdocument.fetcher.RichDocumentImagePrefetcher;
import com.facebook.richdocument.fonts.RichDocumentFontManager;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentEdgeModel.CoverMediaModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel.RichDocumentSectionModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSlideModel;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import com.facebook.richdocument.utils.PrefetchUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_top_contacts_by_cfphat_coefficient */
public class InstantArticlesFetcher extends BaseLocalCachingFetcher<RichDocumentMasterModel> {
    private static volatile InstantArticlesFetcher f23858i;
    public final GatekeeperStoreImpl f23859a;
    public final Lazy<RichDocumentFontManager> f23860b;
    public final PrefetchUtils f23861c;
    public final RichDocumentFeedbackFetcher f23862d;
    public final QeAccessor f23863e;
    public final ConnectionQualityMonitor f23864f;
    public final Cache<String, Boolean> f23865g = CacheBuilder.newBuilder().m1123a(900, TimeUnit.SECONDS).m1148q();
    public final RichDocumentImagePrefetcher f23866h;

    public static com.facebook.instantarticles.fetcher.InstantArticlesFetcher m32251a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23858i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantarticles.fetcher.InstantArticlesFetcher.class;
        monitor-enter(r1);
        r0 = f23858i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m32256b(r0);	 Catch:{ all -> 0x0035 }
        f23858i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23858i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantarticles.fetcher.InstantArticlesFetcher.a(com.facebook.inject.InjectorLike):com.facebook.instantarticles.fetcher.InstantArticlesFetcher");
    }

    private static InstantArticlesFetcher m32256b(InjectorLike injectorLike) {
        return new InstantArticlesFetcher(GraphQLQueryExecutor.m10435a(injectorLike), KeyFactory.m10333b(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedLazy.m1808a(injectorLike, 10307), PrefetchUtils.m32264b(injectorLike), RichDocumentFeedbackFetcher.m32269a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), ConnectionQualityMonitor.m32271a(injectorLike), RichDocumentImagePrefetcher.m32275a(injectorLike));
    }

    static /* synthetic */ boolean m32254a(InstantArticlesFetcher instantArticlesFetcher, CoverMediaModel coverMediaModel) {
        boolean z = false;
        if (!(coverMediaModel == null || coverMediaModel.if_() != GraphQLDocumentElementType.VIDEO || coverMediaModel == null || coverMediaModel.ig_() == null || coverMediaModel.ig_().m() == null)) {
            z = true;
        }
        return z;
    }

    @Inject
    public InstantArticlesFetcher(GraphQLQueryExecutor graphQLQueryExecutor, KeyFactory keyFactory, MonotonicClock monotonicClock, GatekeeperStore gatekeeperStore, Lazy<RichDocumentFontManager> lazy, PrefetchUtils prefetchUtils, RichDocumentFeedbackFetcher richDocumentFeedbackFetcher, QeAccessor qeAccessor, ConnectionQualityMonitor connectionQualityMonitor, RichDocumentImagePrefetcher richDocumentImagePrefetcher) {
        super(graphQLQueryExecutor, keyFactory, gatekeeperStore, monotonicClock, 1, TimeUnit.DAYS);
        this.f23859a = gatekeeperStore;
        this.f23860b = lazy;
        this.f23861c = prefetchUtils;
        this.f23862d = richDocumentFeedbackFetcher;
        this.f23863e = qeAccessor;
        this.f23864f = connectionQualityMonitor;
        this.f23866h = richDocumentImagePrefetcher;
    }

    public final PrefetchMonitor m32258a(Context context, String str) {
        if (Boolean.TRUE.equals(this.f23865g.mo110a((Object) str))) {
            return new FauxPrefetchMonitor(this);
        }
        InstantArticlesFetchParams instantArticlesFetchParams = new InstantArticlesFetchParams(context, str);
        instantArticlesFetchParams.i = 900;
        instantArticlesFetchParams.o = true;
        PrefetchMonitor prefetchMonitorImpl = new PrefetchMonitorImpl(this, str);
        this.f23865g.mo114a((Object) str, Boolean.valueOf(true));
        mo3508a(instantArticlesFetchParams, new 1(this, str, prefetchMonitorImpl, context));
        return prefetchMonitorImpl;
    }

    public static void m32253a(InstantArticlesFetcher instantArticlesFetcher, Context context, String str, RichDocumentSectionModel richDocumentSectionModel, ScreenWidthResolutionImageTarget screenWidthResolutionImageTarget) {
        if (richDocumentSectionModel.k() == GraphQLDocumentElementType.PHOTO && m32255a((RichDocumentPhoto) richDocumentSectionModel)) {
            instantArticlesFetcher.f23866h.m32276a(context, m32252a((RichDocumentPhoto) richDocumentSectionModel, screenWidthResolutionImageTarget), str);
        } else if (richDocumentSectionModel.k() == GraphQLDocumentElementType.SLIDESHOW) {
            ImmutableList a = richDocumentSectionModel.B().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                RichDocumentPhoto richDocumentPhoto = (RichDocumentSlideModel) a.get(i);
                if (richDocumentPhoto.g() == GraphQLDocumentElementType.PHOTO && m32255a(richDocumentPhoto)) {
                    instantArticlesFetcher.f23866h.m32276a(context, m32252a(richDocumentPhoto, screenWidthResolutionImageTarget), str);
                    return;
                }
            }
        }
    }

    private static boolean m32255a(RichDocumentPhoto richDocumentPhoto) {
        return (richDocumentPhoto.n() == null || richDocumentPhoto.n().c() == null || richDocumentPhoto.n().c().d() == null) ? false : true;
    }

    public static boolean m32257b(InstantArticlesFetcher instantArticlesFetcher) {
        return instantArticlesFetcher.f23863e.mo596a(ExperimentsForRichDocumentAbtestModule.f24090c, false);
    }

    public static String m32252a(RichDocumentPhoto richDocumentPhoto, ScreenWidthResolutionImageTarget screenWidthResolutionImageTarget) {
        if (screenWidthResolutionImageTarget == ScreenWidthResolutionImageTarget.NONE) {
            return null;
        }
        return screenWidthResolutionImageTarget == ScreenWidthResolutionImageTarget.FINAL_IMAGE ? richDocumentPhoto.n().c().d() : richDocumentPhoto.n().d().d();
    }
}
