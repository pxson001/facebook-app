package com.facebook.instantshopping.fetcher;

import android.content.Context;
import android.util.LruCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.DataSource;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingPhotoElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingDocumentFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingFontObjectFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.ShoppingDocumentElementsEdgeModel.NodeModel;
import com.facebook.instantshopping.utils.InstantShoppingDocumentUtils;
import com.facebook.instantshopping.utils.InstantShoppingFetchParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.fetcher.BaseRichDocumentFetcher;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import com.facebook.richdocument.fonts.RichDocumentFontManager;
import com.facebook.richdocument.fonts.RichDocumentFonts;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.richdocument.utils.PrefetchUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: upload_photo_menu_photos_selected */
public class InstantShoppingDocumentFetcher<T> extends BaseRichDocumentFetcher<T> {
    public static final String f857a = InstantShoppingDocumentFetcher.class.getSimpleName();
    private static volatile InstantShoppingDocumentFetcher f858m;
    private final GraphQLQueryExecutor f859b;
    public final Map<String, Long> f860c = new HashMap();
    public final LruCache<String, String> f861d = new LruCache(16);
    public final PrefetchUtils f862e;
    private final MonotonicClock f863f;
    public final AbstractFbErrorReporter f864g;
    public final RichDocumentFontManager f865h;
    public final RichDocumentFonts f866i;
    private final QeAccessor f867j;
    private final AutoQESpecForInstantShoppingAbtestModule f868k;
    private boolean f869l = true;

    /* compiled from: upload_photo_menu_photos_selected */
    public class PrefetchMonitor {
        public final /* synthetic */ InstantShoppingDocumentFetcher f853a;
        public DataSource f854b;
        private final String f855c;
        public FBVideo f856d;

        public PrefetchMonitor(InstantShoppingDocumentFetcher instantShoppingDocumentFetcher, InstantShoppingFetchParams instantShoppingFetchParams) {
            this.f853a = instantShoppingDocumentFetcher;
            StringBuilder stringBuilder = new StringBuilder(instantShoppingFetchParams.getClass().getSimpleName());
            stringBuilder.append('/');
            stringBuilder.append("catalogId=");
            stringBuilder.append(instantShoppingFetchParams.f1115c);
            stringBuilder.append("&productId=");
            stringBuilder.append(instantShoppingFetchParams.f1113a);
            stringBuilder.append("&productView=");
            stringBuilder.append(instantShoppingFetchParams.f1114b);
            stringBuilder.append("&prefetch=");
            stringBuilder.append(Boolean.toString(instantShoppingFetchParams.f1119g));
            this.f855c = stringBuilder.toString();
        }
    }

    public static com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher m846a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f858m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher.class;
        monitor-enter(r1);
        r0 = f858m;	 Catch:{ all -> 0x003a }
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
        r0 = m848b(r0);	 Catch:{ all -> 0x0035 }
        f858m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f858m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher.a(com.facebook.inject.InjectorLike):com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher");
    }

    private static InstantShoppingDocumentFetcher m848b(InjectorLike injectorLike) {
        return new InstantShoppingDocumentFetcher(GraphQLQueryExecutor.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), PrefetchUtils.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), RichDocumentFontManager.m5204a(injectorLike), RichDocumentFonts.m5213a(injectorLike), AutoQESpecForInstantShoppingAbtestModule.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InstantShoppingDocumentFetcher(GraphQLQueryExecutor graphQLQueryExecutor, MonotonicClock monotonicClock, PrefetchUtils prefetchUtils, AbstractFbErrorReporter abstractFbErrorReporter, RichDocumentFontManager richDocumentFontManager, RichDocumentFonts richDocumentFonts, AutoQESpecForInstantShoppingAbtestModule autoQESpecForInstantShoppingAbtestModule, QeAccessor qeAccessor) {
        super(graphQLQueryExecutor);
        this.f863f = monotonicClock;
        this.f859b = graphQLQueryExecutor;
        this.f862e = prefetchUtils;
        this.f864g = abstractFbErrorReporter;
        this.f865h = richDocumentFontManager;
        this.f866i = richDocumentFonts;
        this.f867j = qeAccessor;
        this.f868k = autoQESpecForInstantShoppingAbtestModule;
        this.f869l = this.f868k.b().f848a.a("image_optimization_enabled", true);
    }

    public final void m853a(@Nullable RichDocumentFetchParams<GraphQLRequest<T>> richDocumentFetchParams, @Nullable DisposableFutureCallback<GraphQLResult<T>> disposableFutureCallback) {
        if (richDocumentFetchParams instanceof InstantShoppingFetchParams) {
            InstantShoppingFetchParams instantShoppingFetchParams = (InstantShoppingFetchParams) richDocumentFetchParams;
            if (!StringUtil.a(instantShoppingFetchParams.f1113a) && !StringUtil.a(instantShoppingFetchParams.f1114b)) {
                this.f861d.put(instantShoppingFetchParams.f1113a, "instantshopping_document_fetch_query?product_id=" + instantShoppingFetchParams.f1113a + "&product_view=" + instantShoppingFetchParams.f1114b);
            } else if (!StringUtil.a(instantShoppingFetchParams.f1115c) && !StringUtil.a(instantShoppingFetchParams.f1118f)) {
                this.f861d.put(instantShoppingFetchParams.f1115c, "instantshopping_document_fetch_query?catalog_id=" + instantShoppingFetchParams.f1115c + "&catalog_view=" + instantShoppingFetchParams.f1118f);
            } else if (StringUtil.a(instantShoppingFetchParams.f1116d)) {
                this.f861d.put("instantshopping_document_fetch_query", "instantshopping_document_fetch_query");
            } else {
                this.f861d.put(instantShoppingFetchParams.f1116d, "instantshopping_document_fetch_query?native_document_id=" + instantShoppingFetchParams.f1116d);
            }
            String str = !StringUtil.a(instantShoppingFetchParams.f1113a) ? (String) this.f861d.get(instantShoppingFetchParams.f1113a) : !StringUtil.a(instantShoppingFetchParams.f1115c) ? (String) this.f861d.get(instantShoppingFetchParams.f1115c) : !StringUtil.a(instantShoppingFetchParams.f1116d) ? (String) this.f861d.get(instantShoppingFetchParams.f1116d) : (String) this.f861d.get("instantshopping_document_fetch_query");
            instantShoppingFetchParams.f1117e = str;
            instantShoppingFetchParams.f1120h = this.f869l;
        }
        super.a(richDocumentFetchParams, disposableFutureCallback);
    }

    public final String m852a(String str) {
        return (String) this.f861d.get(str);
    }

    public final PrefetchMonitor m850a(Context context, String str, String str2) {
        InstantShoppingFetchParams instantShoppingFetchParams = new InstantShoppingFetchParams(context, str);
        instantShoppingFetchParams.f1119g = true;
        return m844a(context, str, str2, null, null, instantShoppingFetchParams);
    }

    public final PrefetchMonitor m851a(Context context, String str, String str2, String str3) {
        InstantShoppingFetchParams instantShoppingFetchParams = new InstantShoppingFetchParams(context, str);
        instantShoppingFetchParams.f1119g = true;
        return m844a(context, str, null, str2, str3, instantShoppingFetchParams);
    }

    private PrefetchMonitor m844a(Context context, String str, String str2, String str3, String str4, InstantShoppingFetchParams instantShoppingFetchParams) {
        if (!this.f867j.a(ExperimentsForInstantShoppingAbtestModule.f840m, false)) {
            return null;
        }
        InstantShoppingFetchParams instantShoppingFetchParams2 = new InstantShoppingFetchParams(context, str);
        instantShoppingFetchParams2.f1118f = str2;
        instantShoppingFetchParams2.f1113a = str3;
        instantShoppingFetchParams2.f1114b = str4;
        instantShoppingFetchParams2.f1124l = instantShoppingFetchParams.f1124l;
        instantShoppingFetchParams2.f1123k = instantShoppingFetchParams.f1123k;
        instantShoppingFetchParams2.f1119g = true;
        return m845a(str, instantShoppingFetchParams2);
    }

    public final PrefetchMonitor m849a(Context context, String str) {
        InstantShoppingFetchParams instantShoppingFetchParams = new InstantShoppingFetchParams(context);
        instantShoppingFetchParams.f1116d = str;
        instantShoppingFetchParams.f1119g = true;
        return m845a(str, instantShoppingFetchParams);
    }

    private PrefetchMonitor m845a(final String str, InstantShoppingFetchParams instantShoppingFetchParams) {
        final int a = this.f867j.a(ExperimentsForInstantShoppingAbtestModule.f835h, 5);
        final PrefetchMonitor prefetchMonitor = new PrefetchMonitor(this, instantShoppingFetchParams);
        a(instantShoppingFetchParams, new InstantShoppingFetchCallback<T>(this) {
            final /* synthetic */ InstantShoppingDocumentFetcher f852d;

            public final void mo24b(T t) {
                InstantShoppingDocumentFragmentModel a = InstantShoppingDocumentUtils.m1346a(t);
                if (a != null && a.m1030k() != null) {
                    ImmutableList a2 = a.m1030k().m966a();
                    InstantShoppingDocumentFetcher.m847a(this.f852d, a);
                    int size = a2.size();
                    int i = 0;
                    int i2 = 0;
                    while (i < size) {
                        ShoppingDocumentElementsEdgeModel shoppingDocumentElementsEdgeModel = (ShoppingDocumentElementsEdgeModel) a2.get(i);
                        if (i2 != a) {
                            int i3;
                            InstantShoppingDocumentFetcher instantShoppingDocumentFetcher = this.f852d;
                            NodeModel a3 = shoppingDocumentElementsEdgeModel.m1275a();
                            PrefetchMonitor prefetchMonitor = prefetchMonitor;
                            Object obj = null;
                            if (a3.mo43c() == GraphQLInstantShoppingDocumentElementType.PHOTO && a3.mo40n() != null) {
                                prefetchMonitor.f854b = instantShoppingDocumentFetcher.f862e.a(a3.mo40n().d());
                            } else if (a3.mo43c() == GraphQLInstantShoppingDocumentElementType.SLIDESHOW) {
                                ImmutableList w = a3.m1268w();
                                int size2 = w.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    InstantShoppingPhotoElementFragment instantShoppingPhotoElementFragment = (InstantShoppingPhotoElementFragment) w.get(i4);
                                    if (instantShoppingPhotoElementFragment.mo40n() != null) {
                                        prefetchMonitor.f854b = instantShoppingDocumentFetcher.f862e.a(instantShoppingPhotoElementFragment.mo40n().d());
                                    }
                                }
                            } else {
                                if (a3.mo43c() == GraphQLInstantShoppingDocumentElementType.VIDEO && a3.m1270y() != null) {
                                    instantShoppingDocumentFetcher.f862e.b(a3.m1270y().mo326m());
                                    prefetchMonitor.f856d = a3.m1270y();
                                }
                                if (obj == null) {
                                    i3 = i2 + 1;
                                } else {
                                    i3 = i2;
                                }
                                i++;
                                i2 = i3;
                            }
                            obj = 1;
                            if (obj == null) {
                                i3 = i2;
                            } else {
                                i3 = i2 + 1;
                            }
                            i++;
                            i2 = i3;
                        } else {
                            return;
                        }
                    }
                }
            }

            public final void mo23b(ServiceException serviceException) {
                AbstractFbErrorReporter abstractFbErrorReporter = this.f852d.f864g;
                SoftErrorBuilder a = SoftError.a(InstantShoppingDocumentFetcher.f857a + ".prefetchArticleBlocks", "Error attempting to prefetch IS. Catalog id(" + str + ")");
                a.c = serviceException;
                abstractFbErrorReporter.a(a.g());
            }
        });
        return prefetchMonitor;
    }

    public static void m847a(InstantShoppingDocumentFetcher instantShoppingDocumentFetcher, InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel) {
        if (!instantShoppingDocumentFragmentModel.m1029j().isEmpty()) {
            ImmutableList j = instantShoppingDocumentFragmentModel.m1029j();
            Set hashSet = new HashSet();
            Builder builder = new Builder();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                builder.c(new InstantShoppingFontResourceWrapper((InstantShoppingFontObjectFragmentModel) j.get(i)));
            }
            Map a = instantShoppingDocumentFetcher.f865h.m5211a(builder.b(), hashSet, true);
            if (!(a == null || a.isEmpty())) {
                instantShoppingDocumentFetcher.f866i.f5279a = RichDocumentFontManager.m5207a(a.keySet(), a);
            }
        }
    }
}
