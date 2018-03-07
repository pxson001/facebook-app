package com.facebook.composer.minutiae.protocol;

import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableSuggestionsAtPlaceQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.MinutiaeTaggableObjectsModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.MinutiaeTaggableObjectsModel.Builder;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_based_optin_interstitial */
public class TaggableSuggestionsAtPlaceFetcher {
    public static final String f1737a = "60";
    public static final String f1738b = "10";
    public static final String f1739c = "32";
    private static volatile TaggableSuggestionsAtPlaceFetcher f1740f;
    public final GraphQLQueryExecutor f1741d;
    public final MinutiaeGraphQLVerificationHelper f1742e;

    /* compiled from: time_based_optin_interstitial */
    public class C01691 implements Function<GraphQLResult<FetchTaggableSuggestionsAtPlaceQueryModel>, GraphQLResult<FetchTaggableSuggestionsAtPlaceQueryModel>> {
        final /* synthetic */ TaggableSuggestionsAtPlaceFetcher f1735a;

        public C01691(TaggableSuggestionsAtPlaceFetcher taggableSuggestionsAtPlaceFetcher) {
            this.f1735a = taggableSuggestionsAtPlaceFetcher;
        }

        public Object apply(@Nullable Object obj) {
            return TaggableSuggestionsAtPlaceFetcher.m1710a(this.f1735a, (GraphQLResult) obj);
        }
    }

    /* compiled from: time_based_optin_interstitial */
    class C01702 implements Predicate<TaggableObjectEdgeModel> {
        final /* synthetic */ TaggableSuggestionsAtPlaceFetcher f1736a;

        C01702(TaggableSuggestionsAtPlaceFetcher taggableSuggestionsAtPlaceFetcher) {
            this.f1736a = taggableSuggestionsAtPlaceFetcher;
        }

        public boolean apply(@Nullable Object obj) {
            return this.f1736a.f1742e.m1680a((TaggableObjectEdgeModel) obj);
        }
    }

    public static com.facebook.composer.minutiae.protocol.TaggableSuggestionsAtPlaceFetcher m1709a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1740f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.protocol.TaggableSuggestionsAtPlaceFetcher.class;
        monitor-enter(r1);
        r0 = f1740f;	 Catch:{ all -> 0x003a }
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
        r0 = m1711b(r0);	 Catch:{ all -> 0x0035 }
        f1740f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1740f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.protocol.TaggableSuggestionsAtPlaceFetcher.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.protocol.TaggableSuggestionsAtPlaceFetcher");
    }

    private static TaggableSuggestionsAtPlaceFetcher m1711b(InjectorLike injectorLike) {
        return new TaggableSuggestionsAtPlaceFetcher(GraphQLQueryExecutor.a(injectorLike), MinutiaeGraphQLVerificationHelper.m1679b(injectorLike));
    }

    @Inject
    public TaggableSuggestionsAtPlaceFetcher(GraphQLQueryExecutor graphQLQueryExecutor, MinutiaeGraphQLVerificationHelper minutiaeGraphQLVerificationHelper) {
        this.f1741d = graphQLQueryExecutor;
        this.f1742e = minutiaeGraphQLVerificationHelper;
    }

    public static GraphQLResult m1710a(TaggableSuggestionsAtPlaceFetcher taggableSuggestionsAtPlaceFetcher, GraphQLResult graphQLResult) {
        if (graphQLResult == null) {
            return graphQLResult;
        }
        Iterable c = Iterables.c(((FetchTaggableSuggestionsAtPlaceQueryModel) graphQLResult.e).K().a(), new C01702(taggableSuggestionsAtPlaceFetcher));
        MinutiaeTaggableObjectsModel K = ((FetchTaggableSuggestionsAtPlaceQueryModel) graphQLResult.e).K();
        Builder builder = new Builder();
        builder.a = K.a();
        builder.b = K.j();
        Builder builder2 = builder;
        builder2.a = ImmutableList.copyOf(c);
        builder2 = builder2;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder2.a);
        int a2 = ModelHelper.a(flatBufferBuilder, builder2.b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel = new MinutiaeTaggableObjectsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        GraphQLResult.Builder a3 = GraphQLResult.Builder.a(graphQLResult);
        FetchTaggableSuggestionsAtPlaceQueryModel.Builder builder3 = new FetchTaggableSuggestionsAtPlaceQueryModel.Builder();
        FetchTaggableSuggestionsAtPlaceQueryModel fetchTaggableSuggestionsAtPlaceQueryModel = (FetchTaggableSuggestionsAtPlaceQueryModel) graphQLResult.e;
        FetchTaggableSuggestionsAtPlaceQueryModel.Builder builder4 = new FetchTaggableSuggestionsAtPlaceQueryModel.Builder();
        builder4.a = fetchTaggableSuggestionsAtPlaceQueryModel.s();
        builder4.b = fetchTaggableSuggestionsAtPlaceQueryModel.C();
        builder4.c = fetchTaggableSuggestionsAtPlaceQueryModel.D();
        builder4.d = fetchTaggableSuggestionsAtPlaceQueryModel.j();
        builder4.e = fetchTaggableSuggestionsAtPlaceQueryModel.k();
        builder4.f = fetchTaggableSuggestionsAtPlaceQueryModel.l();
        builder4.g = fetchTaggableSuggestionsAtPlaceQueryModel.m();
        builder4.h = fetchTaggableSuggestionsAtPlaceQueryModel.n();
        builder4.i = fetchTaggableSuggestionsAtPlaceQueryModel.E();
        builder4.j = fetchTaggableSuggestionsAtPlaceQueryModel.F();
        builder4.k = fetchTaggableSuggestionsAtPlaceQueryModel.G();
        builder4.l = fetchTaggableSuggestionsAtPlaceQueryModel.H();
        builder4.m = fetchTaggableSuggestionsAtPlaceQueryModel.I();
        builder4.n = fetchTaggableSuggestionsAtPlaceQueryModel.J();
        builder4.o = fetchTaggableSuggestionsAtPlaceQueryModel.o();
        builder4.p = fetchTaggableSuggestionsAtPlaceQueryModel.p();
        builder4.q = fetchTaggableSuggestionsAtPlaceQueryModel.q();
        builder4.r = fetchTaggableSuggestionsAtPlaceQueryModel.r();
        builder4.s = fetchTaggableSuggestionsAtPlaceQueryModel.K();
        builder3 = builder4;
        builder3.s = minutiaeTaggableObjectsModel;
        a3.k = builder3.a();
        return a3.a();
    }
}
