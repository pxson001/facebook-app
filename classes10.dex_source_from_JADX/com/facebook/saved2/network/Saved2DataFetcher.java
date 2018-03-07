package com.facebook.saved2.network;

import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.crudolib.dbinsert.FluentInsert;
import com.facebook.crudolib.dbinsert.direct.DirectInsertExecutor;
import com.facebook.crudolib.dbinsert.direct.DirectInsertExecutor.2;
import com.facebook.crudolib.net.CancelTrigger;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineResponse;
import com.facebook.crudolib.netfb.FbGraphQLRequestBuilder;
import com.facebook.crudolib.netfb.FbRequestFactory;
import com.facebook.crudolib.netfb.FlatbufferGraphQLProtocol;
import com.facebook.crudolib.netmodule.FbRequestFactoryMethodAutoProvider;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.common.data.SavedSectionResources;
import com.facebook.saved2.analytics.Saved2StartPerfLogger;
import com.facebook.saved2.bus.Saved2EventBus;
import com.facebook.saved2.bus.Saved2EventBus.FetchSucceededData;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.FetchSaved2ItemsGraphQLModel;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.FetchSaved2ItemsGraphQLModel.SavedItemsModel;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.Saved2DashboardItemFieldsModel;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.Saved2ItemModel;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.Saved2ItemModel.PermalinkNodeModel;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLModels.Saved2ItemsEdgeModel;
import com.facebook.saved2.model.Saved2DatabaseProvider;
import com.facebook.saved2.model.Saved2ItemTable_InsertHelper;
import com.facebook.saved2.model.Saved2UnreadCountsTable_InsertHelper;
import com.facebook.video.downloadmanager.DownloadManager;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: instant_shopping_catalog_view */
public class Saved2DataFetcher {
    private static volatile Saved2DataFetcher f9432i;
    private final Resources f9433a;
    private final FbRequestFactory f9434b;
    public final SavedSectionResources f9435c;
    public final DirectInsertExecutor f9436d;
    public final Lazy<GraphQLLinkExtractor> f9437e;
    public final Saved2StartPerfLogger f9438f;
    public final Saved2DatabaseProvider f9439g;
    public final Lazy<DownloadManager> f9440h;

    /* compiled from: instant_shopping_catalog_view */
    public class C14041 extends Thread {
        final /* synthetic */ Saved2DataFetcher f9428a;

        public C14041(Saved2DataFetcher saved2DataFetcher) {
            this.f9428a = saved2DataFetcher;
        }

        public void run() {
            2 a = this.f9428a.f9436d.a(new Saved2UnreadCountsTable_InsertHelper());
            try {
                ImmutableList a2 = this.f9428a.f9435c.a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    a.a().a(0, ((SavedDashboardSection) a2.get(i)).a().name()).a(1, Integer.valueOf(0)).a();
                }
            } finally {
                a.b();
                this.f9428a.f9438f.m9535j();
            }
        }
    }

    /* compiled from: instant_shopping_catalog_view */
    public class FetchFreshSavedItemsCallback {
        final /* synthetic */ Saved2DataFetcher f9429a;
        public final String f9430b;
        private final boolean f9431c;

        public FetchFreshSavedItemsCallback(Saved2DataFetcher saved2DataFetcher, String str, boolean z) {
            this.f9429a = saved2DataFetcher;
            this.f9430b = str;
            this.f9431c = z;
        }

        public final void m9706a(FbHttpEngineResponse fbHttpEngineResponse) {
            Integer.valueOf(fbHttpEngineResponse.a());
            try {
                m9705a(fbHttpEngineResponse.c());
            } catch (SQLiteException e) {
                throw e;
            } catch (Throwable e2) {
                IOException iOException = new IOException();
                iOException.initCause(e2);
                throw iOException;
            }
        }

        private void m9705a(InputStream inputStream) {
            int i = 0;
            SavedItemsModel a = ((FetchSaved2ItemsGraphQLModel) new MutableFlatBuffer(FlatbufferGraphQLProtocol.a(inputStream), null, null, false, null).a(FetchSaved2ItemsGraphQLModel.class)).m9553a();
            2 a2 = this.f9429a.f9436d.a(new Saved2ItemTable_InsertHelper());
            try {
                if (this.f9431c) {
                    this.f9429a.f9439g.a().delete("item", "section_name=? AND is_download_client=?", new String[]{this.f9430b, "0"});
                }
                ImmutableList a3 = a.m9549a();
                int size = a3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String a4;
                    Saved2ItemsEdgeModel saved2ItemsEdgeModel = (Saved2ItemsEdgeModel) a3.get(i2);
                    i++;
                    FluentInsert a5 = a2.a();
                    a5.a(0, this.f9430b);
                    a5.a(3, saved2ItemsEdgeModel.m9671a());
                    Saved2ItemModel k = saved2ItemsEdgeModel.m9673k();
                    Assertions.b(k);
                    a5.a(2, Long.valueOf(k.m9653j() * 1000));
                    if (saved2ItemsEdgeModel.m9672j() != null) {
                        a5.a(4, saved2ItemsEdgeModel.m9672j().m9667a());
                    }
                    if (k.m9660q() != null) {
                        a5.a(6, k.m9660q().m9646a());
                    }
                    if (k.m9659p() != null) {
                        a5.a(7, k.m9659p().m9641a());
                    }
                    if (k.m9649a() != null) {
                        a5.a(8, k.m9649a().m9589a());
                    }
                    if (k.m9657n() != null) {
                        PermalinkNodeModel n = k.m9657n();
                        if (!(n.m9619k() == null || n.m9618j() == null || n.m9618j().g() != 80218325)) {
                            a5.a(12, k.m9657n().m9619k());
                        }
                    }
                    if (k.m9658o() != null) {
                        a5.a(13, k.m9658o().m9636j());
                    }
                    if (k.m9655l() != null) {
                        a5.a(5, k.m9655l().b());
                    }
                    if (!(k.m9654k() == null || k.m9654k().m9609j() == null)) {
                        a5.a(21, k.m9654k().m9609j().m9602j());
                        if (k.m9654k().m9609j().m9603k() != null) {
                            a5.a(22, k.m9654k().m9609j().m9603k().m9597a());
                        }
                    }
                    Saved2DashboardItemFieldsModel m = k.m9656m();
                    String str = "0";
                    if (m != null) {
                        a5.a(1, m.m9571m());
                        a5.a(17, m.m9571m());
                        a5.a(15, Boolean.valueOf(m.m9575q()));
                        if (m.m9575q() && ((DownloadManager) this.f9429a.f9440h.get()).e(m.m9571m())) {
                            str = "1";
                        }
                        a5.a(16, m.m9577s());
                        a5.a(36, Integer.valueOf(m.m9583y()));
                        a5.a(24, Boolean.valueOf(m.m9576r()));
                        a5.a(25, Integer.valueOf(m.m9582x()));
                        a5.a(26, Double.valueOf(m.m9578t()));
                        a5.a(28, m.m9581w());
                        a5.a(29, m.m9580v());
                        a5.a(27, Double.valueOf(m.m9579u()));
                        a5.a(30, Integer.valueOf(m.m9572n()));
                        a5.a(31, Integer.valueOf(m.m9573o()));
                        a5.a(32, Integer.valueOf(m.m9574p()));
                        if (m.m9568j() != null) {
                            a5.a(18, Integer.valueOf(m.m9568j().g()));
                            a4 = ((GraphQLLinkExtractor) this.f9429a.f9437e.get()).a(m.m9568j(), m.m9571m());
                        } else {
                            a4 = null;
                        }
                        if (m.m9584z() != null) {
                            a5.a(10, m.m9584z().toString());
                        }
                        if (m.m9570l() != null) {
                            a5.a(19, m.m9570l().m9429j());
                            a5.a(20, Integer.valueOf(m.m9570l().jK_()));
                        }
                        if (m.m9569k() != null) {
                            a5.a(23, Boolean.valueOf(m.m9569k().m9423a()));
                        }
                    } else {
                        a4 = null;
                    }
                    if (a4 == null) {
                        a4 = k.m9661r();
                    }
                    a5.a(11, a4);
                    a5.a(9);
                    a5.a(33, this.f9430b);
                    a5.a(34, Integer.valueOf(0));
                    a5.a(35, Integer.valueOf(0));
                    a5.a(37, str);
                    a5.a();
                }
            } finally {
                a2.b();
                Saved2EventBus.f9369b.b(new FetchSucceededData(this.f9430b, i));
            }
        }
    }

    public static com.facebook.saved2.network.Saved2DataFetcher m9708a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9432i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved2.network.Saved2DataFetcher.class;
        monitor-enter(r1);
        r0 = f9432i;	 Catch:{ all -> 0x003a }
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
        r0 = m9709b(r0);	 Catch:{ all -> 0x0035 }
        f9432i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9432i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved2.network.Saved2DataFetcher.a(com.facebook.inject.InjectorLike):com.facebook.saved2.network.Saved2DataFetcher");
    }

    private static Saved2DataFetcher m9709b(InjectorLike injectorLike) {
        return new Saved2DataFetcher(ResourcesMethodAutoProvider.a(injectorLike), FbRequestFactoryMethodAutoProvider.a(injectorLike), SavedSectionResources.a(injectorLike), Saved2DatabaseProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2189), Saved2StartPerfLogger.m9519a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 11622));
    }

    @Inject
    public Saved2DataFetcher(Resources resources, FbRequestFactory fbRequestFactory, SavedSectionResources savedSectionResources, Saved2DatabaseProvider saved2DatabaseProvider, Lazy<GraphQLLinkExtractor> lazy, Saved2StartPerfLogger saved2StartPerfLogger, Lazy<DownloadManager> lazy2) {
        this.f9433a = resources;
        this.f9434b = fbRequestFactory;
        this.f9435c = savedSectionResources;
        this.f9436d = new DirectInsertExecutor(saved2DatabaseProvider);
        this.f9437e = lazy;
        this.f9438f = saved2StartPerfLogger;
        this.f9439g = saved2DatabaseProvider;
        this.f9440h = lazy2;
    }

    public final void m9710a(String str, @Nullable String str2) {
        boolean z = false;
        int dimensionPixelSize = this.f9433a.getDimensionPixelSize(2131434028);
        FbGraphQLRequestBuilder a = this.f9434b.a(0);
        a.b.a("response_format", "flatbuffer");
        FbGraphQLRequestBuilder a2 = a.a(m9707a("0"), str).a(m9707a("1"), str2).a(m9707a("2"), Integer.valueOf(20)).a(m9707a("3"), Integer.valueOf(dimensionPixelSize)).a(m9707a("4"), Integer.valueOf(dimensionPixelSize));
        if (str2 == null) {
            z = true;
        }
        a2.b.a.c.e = new FetchFreshSavedItemsCallback(this, str, z);
        FbGraphQLRequestBuilder fbGraphQLRequestBuilder = a2;
        if (fbGraphQLRequestBuilder.c != null) {
            fbGraphQLRequestBuilder.c.a(ParamsJsonEncoder.a());
            fbGraphQLRequestBuilder.c.f();
            fbGraphQLRequestBuilder.b.a("query_params", fbGraphQLRequestBuilder.c);
        }
        CancelTrigger a3 = fbGraphQLRequestBuilder.b.a();
    }

    private static long m9707a(String str) {
        return (long) ((0 << 32) | Integer.parseInt(str));
    }
}
