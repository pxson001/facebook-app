package com.facebook.timeline.aboutpage;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQL.AboutSectionsQueryString;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.AboutSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsGraphQLImageHelper;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQL.AppSectionsNodeQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQL.CollectionAppSectionsNodeQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.AboutPageUserFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.AppSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQL.CollectionItemsPageQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQL.FetchTimelineCollectionsSectionViewQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQL.FetchTimelineSingleCollectionViewQueryString;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionsGraphQLModels.FetchTimelineSingleCollectionViewQueryModel;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: NOTIFICATION */
public class CollectionsQueryExecutor {
    private static volatile CollectionsQueryExecutor f13012g;
    public final GraphQLQueryExecutor f13013a;
    private final GraphQLCacheManager f13014b;
    private final CollectionsGraphQLImageHelper f13015c;
    private final StandardCollectionSizes f13016d;
    public final ExecutorService f13017e;
    private final CollectionsQeHelper f13018f;

    /* compiled from: NOTIFICATION */
    public class C15401 implements Function<AboutSectionInfoModel, AboutPageUserFields> {
        final /* synthetic */ CollectionsQueryExecutor f13010a;

        public C15401(CollectionsQueryExecutor collectionsQueryExecutor) {
            this.f13010a = collectionsQueryExecutor;
        }

        public Object apply(Object obj) {
            return (AboutSectionInfoModel) obj;
        }
    }

    /* compiled from: NOTIFICATION */
    class C15412 implements Function<AppSectionInfoModel, AboutPageUserFields> {
        final /* synthetic */ CollectionsQueryExecutor f13011a;

        C15412(CollectionsQueryExecutor collectionsQueryExecutor) {
            this.f13011a = collectionsQueryExecutor;
        }

        public Object apply(Object obj) {
            return (AppSectionInfoModel) obj;
        }
    }

    public static com.facebook.timeline.aboutpage.CollectionsQueryExecutor m13769a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13012g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.CollectionsQueryExecutor.class;
        monitor-enter(r1);
        r0 = f13012g;	 Catch:{ all -> 0x003a }
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
        r0 = m13770b(r0);	 Catch:{ all -> 0x0035 }
        f13012g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13012g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.CollectionsQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.CollectionsQueryExecutor");
    }

    private static CollectionsQueryExecutor m13770b(InjectorLike injectorLike) {
        return new CollectionsQueryExecutor(GraphQLQueryExecutor.a(injectorLike), GraphQLCacheManager.a(injectorLike), CollectionsGraphQLImageHelper.m14198a(injectorLike), StandardCollectionSizes.m13827a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), CollectionsQeHelper.m13763b(injectorLike));
    }

    @Inject
    public CollectionsQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLCacheManager graphQLCacheManager, CollectionsGraphQLImageHelper collectionsGraphQLImageHelper, StandardCollectionSizes standardCollectionSizes, ExecutorService executorService, CollectionsQeHelper collectionsQeHelper) {
        this.f13013a = graphQLQueryExecutor;
        this.f13014b = graphQLCacheManager;
        this.f13015c = collectionsGraphQLImageHelper;
        this.f13016d = standardCollectionSizes;
        this.f13017e = executorService;
        this.f13018f = collectionsQeHelper;
    }

    public final AboutSectionsQueryString m13771a(String str, String str2) {
        GraphQlQueryString aboutSectionsQueryString = new AboutSectionsQueryString();
        aboutSectionsQueryString.a("profile_id", str).a("num_mutual_friends", "4").a("facepile_image_size", String.valueOf(this.f13015c.m14202c())).a("profile_field_sections_after", str2);
        return aboutSectionsQueryString;
    }

    public static GraphQLCachePolicy m13767a(boolean z) {
        return z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a;
    }

    public final FetchTimelineCollectionsSectionViewQueryString m13774a(String str, int i, int i2, String str2) {
        GraphQlQueryString fetchTimelineCollectionsSectionViewQueryString = new FetchTimelineCollectionsSectionViewQueryString();
        fetchTimelineCollectionsSectionViewQueryString.a("app_section_id", str).a("collection_list_item_image_size", String.valueOf(this.f13015c.m14201b())).a("collection_table_item_image_size", String.valueOf(this.f13015c.m14200a())).a("default_image_scale", GraphQlQueryDefaults.a()).a("facepile_image_size", String.valueOf(this.f13015c.m14202c())).a("items_per_collection", String.valueOf(i)).a("suggestions_after", null).a("items_after", str2).a("suggestions_per_collection", String.valueOf(i2));
        return fetchTimelineCollectionsSectionViewQueryString;
    }

    public final CollectionItemsPageQueryString m13773a(String str, String str2, int i) {
        GraphQlQueryString collectionItemsPageQueryString = new CollectionItemsPageQueryString();
        collectionItemsPageQueryString.a("collection_id", str).a("collection_list_item_image_size", String.valueOf(this.f13015c.m14201b())).a("collection_table_item_image_size", String.valueOf(this.f13015c.m14200a())).a("default_image_scale", GraphQlQueryDefaults.a()).a("facepile_image_size", String.valueOf(this.f13015c.m14202c())).a("items_after", str2).a("items_per_collection", String.valueOf(i));
        return collectionItemsPageQueryString;
    }

    public final AppSectionsNodeQueryString m13779c(String str, int i, boolean z, String str2) {
        return (AppSectionsNodeQueryString) m13768a((GraphQlQueryString) new AppSectionsNodeQueryString(), str, i, z, Optional.fromNullable(str2));
    }

    public final FetchTimelineSingleCollectionViewQueryString m13775a(String str, String str2, int i, int i2) {
        GraphQlQueryString fetchTimelineSingleCollectionViewQueryString = new FetchTimelineSingleCollectionViewQueryString();
        fetchTimelineSingleCollectionViewQueryString.a("app_section_id", str).a("collection_id", str2).a("collection_list_item_image_size", String.valueOf(this.f13015c.m14201b())).a("collection_table_item_image_size", String.valueOf(this.f13015c.m14200a())).a("default_image_scale", GraphQlQueryDefaults.a()).a("facepile_image_size", String.valueOf(this.f13015c.m14202c())).a("items_per_collection", String.valueOf(i)).a("suggestions_per_collection", String.valueOf(i2)).a("suggestions_after", null);
        return fetchTimelineSingleCollectionViewQueryString;
    }

    public final ListenableFuture<AboutPageUserFields> m13776a(boolean z, String str, int i, boolean z2, String str2) {
        GraphQLRequest a = GraphQLRequest.a(m13779c(str, i, z2, str2)).a(86400).a(m13767a(z));
        if (1 != 0) {
            a.q = null;
        }
        return Futures.a(GraphQLQueryExecutor.a(this.f13013a.a(a)), new C15412(this), this.f13017e);
    }

    private GraphQlQueryString m13768a(GraphQlQueryString graphQlQueryString, String str, int i, boolean z, Optional<String> optional) {
        graphQlQueryString.a("collection_list_item_image_size", String.valueOf(this.f13015c.m14201b())).a("collection_table_item_image_size", String.valueOf(this.f13015c.m14200a())).a("collections", String.valueOf(i)).a("collections_after", (String) optional.orNull()).a("collections_per_app", "1").a("default_image_scale", GraphQlQueryDefaults.a()).a("facepile_image_size", String.valueOf(this.f13015c.m14202c())).a("is_requestable_fields_enabled", String.valueOf(z)).a("items_per_collection", String.valueOf(this.f13016d.m13829h())).a("num_collections", "2").a("num_mutual_friends", "4").a("profile_id", str).a("suggestions_after", null).a("suggestions_per_collection", String.valueOf(4));
        return graphQlQueryString;
    }

    public final CollectionAppSectionsNodeQueryString m13772a(String str, int i, boolean z, @Nullable String str2) {
        return (CollectionAppSectionsNodeQueryString) m13768a((GraphQlQueryString) new CollectionAppSectionsNodeQueryString(), str, i, z, Optional.fromNullable(str2));
    }

    public final ListenableFuture<FetchTimelineSingleCollectionViewQueryModel> m13777a(boolean z, String str, String str2, int i, int i2) {
        GraphQLRequest a = GraphQLRequest.a(m13775a(str, str2, i, i2)).a(86400).a(m13767a(z));
        if (1 != 0) {
            a.q = null;
        }
        return GraphQLQueryExecutor.a(this.f13013a.a(a));
    }

    public final void m13778a(String str) {
        this.f13014b.a(ImmutableSet.of(str));
    }
}
