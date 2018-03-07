package com.facebook.search.results.loader;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters.Action;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.SupportedExperiences;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.SupportedRoles;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.api.EdgeRoutingConfig;
import com.facebook.search.api.EdgeRoutingConfig.Caller;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.facebook.search.results.protocol.SearchResultsGraphQL.SearchResultsGraphQLString;
import com.facebook.search.results.protocol.SearchResultsGraphQLModels.SearchResultsGraphQLModel;
import com.facebook.search.util.ResultsFiltersUtil;
import com.facebook.search.util.toast.SearchResultsSizeUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SCRUBBER_OPENED */
public class SearchResultsLoader {
    private static volatile SearchResultsLoader f23238f;
    private final GraphQLQueryExecutor f23239a;
    private final SearchResultsSizeUtil f23240b;
    private final QeAccessor f23241c;
    private final EdgeRoutingConfig f23242d;
    private final Resources f23243e;

    public static com.facebook.search.results.loader.SearchResultsLoader m26945a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23238f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.results.loader.SearchResultsLoader.class;
        monitor-enter(r1);
        r0 = f23238f;	 Catch:{ all -> 0x003a }
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
        r0 = m26949b(r0);	 Catch:{ all -> 0x0035 }
        f23238f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23238f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.loader.SearchResultsLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.results.loader.SearchResultsLoader");
    }

    private static SearchResultsLoader m26949b(InjectorLike injectorLike) {
        return new SearchResultsLoader(GraphQLQueryExecutor.a(injectorLike), SearchResultsSizeUtil.m10684a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), EdgeRoutingConfig.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SearchResultsLoader(GraphQLQueryExecutor graphQLQueryExecutor, SearchResultsSizeUtil searchResultsSizeUtil, QeAccessor qeAccessor, EdgeRoutingConfig edgeRoutingConfig, Resources resources) {
        this.f23239a = graphQLQueryExecutor;
        this.f23240b = searchResultsSizeUtil;
        this.f23241c = qeAccessor;
        this.f23242d = edgeRoutingConfig;
        this.f23243e = resources;
    }

    public final ListenableFuture<GraphQLResult<SearchResultsGraphQLModel>> m26950a(SearchResultsContext searchResultsContext, @Nullable String str, ImmutableList<Filters> immutableList) {
        String b = searchResultsContext.mo1212b();
        GraphQLGraphSearchResultsDisplayStyle l = searchResultsContext.m27098l();
        SearchResultsCallsite fromDisplayStyle = SearchResultsCallsite.fromDisplayStyle(l);
        String str2 = searchResultsContext.f23369d.b;
        SearchQueryInputQueryArguments searchQueryInputQueryArguments = new SearchQueryInputQueryArguments();
        SearchResultsGraphQLString searchResultsGraphQLString = new SearchResultsGraphQLString();
        FilteredQueryArguments filteredQueryArguments = new FilteredQueryArguments();
        filteredQueryArguments.a("callsite", fromDisplayStyle.toString());
        GraphQlCallInput graphQlCallInput = filteredQueryArguments;
        graphQlCallInput.a("tsid", str2);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("supported_roles", m26946a());
        filteredQueryArguments = graphQlCallInput;
        Builder builder = new Builder();
        m26948a(builder, filteredQueryArguments, searchResultsGraphQLString, immutableList, l);
        m26947a(searchResultsGraphQLString, l);
        ImmutableList b2 = builder.b();
        if (!b2.isEmpty()) {
            filteredQueryArguments.a("supported_experiences", b2);
        }
        searchQueryInputQueryArguments.a("bqf", b);
        searchQueryInputQueryArguments.a("filtered_query_arguments", filteredQueryArguments);
        searchResultsGraphQLString.a("search_query", searchQueryInputQueryArguments);
        searchResultsGraphQLString.a("end_cursor", str);
        searchResultsGraphQLString.a("profile_image_size", String.valueOf(this.f23240b.m10687b()));
        GraphQLRequest a = GraphQLRequest.a(searchResultsGraphQLString).a(GraphQLCachePolicy.c).a(60);
        this.f23242d.a(Caller.SERP, a);
        return this.f23239a.a(a);
    }

    private static ImmutableList<SupportedRoles> m26946a() {
        Builder builder = new Builder();
        builder.b(new SupportedRoles[]{SupportedRoles.CENTRAL, SupportedRoles.FEED_VIDEOS, SupportedRoles.NEWS_MODULE, SupportedRoles.PROMOTED_ENTITY_MEDIA, SupportedRoles.RELATED_SHARES_WITH_POSTS, SupportedRoles.WIKIPEDIA_CARD});
        return builder.b();
    }

    private void m26948a(Builder<SupportedExperiences> builder, FilteredQueryArguments filteredQueryArguments, SearchResultsGraphQLString searchResultsGraphQLString, ImmutableList<Filters> immutableList, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        QeAccessor qeAccessor = this.f23241c;
        boolean z = false;
        if (ResultsFiltersUtil.f8911a.contains(graphQLGraphSearchResultsDisplayStyle) && qeAccessor.a(ExperimentsForSearchAbTestModule.U, false)) {
            z = true;
        }
        if (z) {
            searchResultsGraphQLString.a("filters_enabled", Boolean.valueOf(true));
            builder.c(SupportedExperiences.FILTERS).c(SupportedExperiences.FAST_FILTERS);
            if (immutableList != null && !immutableList.isEmpty()) {
                Builder builder2 = new Builder();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    Map b = ((Filters) immutableList.get(i)).b();
                    Preconditions.checkArgument("add".equals(b.get("action")));
                    builder2.c(new Filters().a(Action.ADD).b((String) b.get("handle")).a((String) b.get("name")).c((String) b.get("value")));
                }
                filteredQueryArguments.a("filters", builder2.b());
                return;
            }
            return;
        }
        searchResultsGraphQLString.a("filters_enabled", Boolean.valueOf(false));
    }

    private void m26947a(SearchResultsGraphQLString searchResultsGraphQLString, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.VIDEOS || graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.VIDEO_STATE) {
            searchResultsGraphQLString.a("video_thumbnail_width", Integer.valueOf(this.f23243e.getDimensionPixelSize(2131432641))).a("video_thumbnail_height", Integer.valueOf(this.f23243e.getDimensionPixelSize(2131432642)));
        }
    }
}
