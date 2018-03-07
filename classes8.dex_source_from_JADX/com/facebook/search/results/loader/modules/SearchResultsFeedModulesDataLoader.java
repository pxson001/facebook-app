package com.facebook.search.results.loader.modules;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.calls.SearchQueryInputQueryArguments.FilteredQueryArguments.Filters;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.executor.RequestSubscription;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionUtil;
import com.facebook.search.abtest.CommerceSearchExperimentHelper;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.EdgeRoutingConfig;
import com.facebook.search.api.EdgeRoutingConfig.Caller;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQueryCommerceModifier;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.constants.SearchResultsFeedDataLoaderParams.SearchExperience;
import com.facebook.search.logging.SearchResultsPerformanceLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.GraphSearchQuerySpecHelper;
import com.facebook.search.model.SearchResultsRequestType;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQL.FetchKeywordSearchResultsString;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchQuery;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchQueryModel.FilteredQueryModel.ModulesModel;
import com.facebook.search.results.filters.model.SearchResultPageMainFilterConverter;
import com.facebook.search.results.fragment.feed.SearchResultsFeedFragment;
import com.facebook.search.results.loader.SearchResultsCallsite;
import com.facebook.search.results.loader.SearchResultsHelper;
import com.facebook.search.results.loader.modules.ResultsOrderReinforcer.Consumer;
import com.facebook.search.results.model.SearchResults;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFiltersFragmentModel;
import com.facebook.search.util.toast.SearchResultsSizeUtil;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SCROLL_FOCUSED_VIEW_TO_RECT */
public class SearchResultsFeedModulesDataLoader {
    private static SearchResultsFeedModulesDataLoader f23294B;
    private static final Object f23295C = new Object();
    public static final Class f23296a = SearchResultsFeedModulesDataLoader.class;
    private ResultsOrderReinforcer<C2510x73e72fcc> f23297A;
    private final Resources f23298b;
    private final GraphQLQueryExecutor f23299c;
    private final TasksManager<String> f23300d;
    public final SearchResultsCollectionGraphQLConverter f23301e;
    private final SearchResultsPerformanceLogger f23302f;
    private final SearchResultsSizeUtil f23303g;
    private final SizeAwareImageUtil f23304h;
    private final FetchReactorsParamBuilderUtil f23305i;
    private final FetchRecentActivityParamBuilderUtil f23306j;
    private final GraphQLStoryHelper f23307k;
    private final ExecutorService f23308l;
    public final QeAccessor f23309m;
    private final GatekeeperStoreImpl f23310n;
    private final FetchVideoChannelParamBuilderUtil f23311o;
    private final Executor f23312p;
    private final Lazy<ReactionUtil> f23313q;
    private final SearchResultPageMainFilterConverter f23314r;
    private final SearchResultsHelper f23315s;
    private final NetworkRequestTimer f23316t = new NetworkRequestTimer(this);
    private final CommerceSearchExperimentHelper f23317u;
    private final EdgeRoutingConfig f23318v;
    private final AtomicBoolean f23319w = new AtomicBoolean(false);
    public SearchResultsFeedFragment f23320x;
    private GraphSearchQuerySpec f23321y;
    private RequestSubscription f23322z;

    /* compiled from: SCROLL_FOCUSED_VIEW_TO_RECT */
    class C25041 implements Consumer<C2510x73e72fcc> {
        final /* synthetic */ SearchResultsFeedModulesDataLoader f23265a;

        C25041(SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader) {
            this.f23265a = searchResultsFeedModulesDataLoader;
        }

        public final void mo1320a(Object obj) {
            try {
                this.f23265a.f23320x.m26686a((C2510x73e72fcc) obj);
            } catch (GraphSearchException e) {
                SearchResultsFeedModulesDataLoader.m26996a(this.f23265a, e);
            }
        }
    }

    /* compiled from: SCROLL_FOCUSED_VIEW_TO_RECT */
    class C25063 implements Runnable {
        final /* synthetic */ SearchResultsFeedModulesDataLoader f23273a;

        C25063(SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader) {
            this.f23273a = searchResultsFeedModulesDataLoader;
        }

        public void run() {
            this.f23273a.f23301e.m26964b();
        }
    }

    /* compiled from: SCROLL_FOCUSED_VIEW_TO_RECT */
    class C25085 implements Consumer<C2510x73e72fcc> {
        final /* synthetic */ SearchResultsFeedModulesDataLoader f23279a;

        C25085(SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader) {
            this.f23279a = searchResultsFeedModulesDataLoader;
        }

        public final void mo1320a(Object obj) {
            try {
                this.f23279a.f23320x.m26686a((C2510x73e72fcc) obj);
            } catch (GraphSearchException e) {
                SearchResultsFeedModulesDataLoader.m26996a(this.f23279a, e);
            }
        }
    }

    /* compiled from: SCROLL_FOCUSED_VIEW_TO_RECT */
    public class NetworkRequestTimer {
        final /* synthetic */ SearchResultsFeedModulesDataLoader f23282a;
        public Handler f23283b = new Handler();
        public Runnable f23284c;
        public boolean f23285d;

        NetworkRequestTimer(final SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader) {
            this.f23282a = searchResultsFeedModulesDataLoader;
            this.f23284c = new Runnable(this) {
                final /* synthetic */ NetworkRequestTimer f23281b;

                public void run() {
                    this.f23281b.f23282a.m27013b();
                    this.f23281b.f23285d = false;
                    if (this.f23281b.f23282a.f23320x != null) {
                        this.f23281b.f23282a.f23320x.A_(25);
                    }
                }
            };
        }

        public static void m26973a(NetworkRequestTimer networkRequestTimer) {
            if (!networkRequestTimer.f23285d) {
                HandlerDetour.b(networkRequestTimer.f23283b, networkRequestTimer.f23284c, 25000, -1993108671);
            }
        }
    }

    private static SearchResultsFeedModulesDataLoader m27002b(InjectorLike injectorLike) {
        return new SearchResultsFeedModulesDataLoader(ResourcesMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.a(injectorLike), SearchResultsCollectionGraphQLConverter.m26954a(injectorLike), SearchResultsPerformanceLogger.m25495a(injectorLike), SearchResultsSizeUtil.m10684a(injectorLike), SizeAwareImageUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), GraphQLStoryHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9839), SearchResultPageMainFilterConverter.m26515a(injectorLike), SearchResultsHelper.m26942a(injectorLike), CommerceSearchExperimentHelper.a(injectorLike), EdgeRoutingConfig.a(injectorLike));
    }

    public static SearchResultsFeedModulesDataLoader m26987a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFeedModulesDataLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23295C) {
                SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader;
                if (a2 != null) {
                    searchResultsFeedModulesDataLoader = (SearchResultsFeedModulesDataLoader) a2.a(f23295C);
                } else {
                    searchResultsFeedModulesDataLoader = f23294B;
                }
                if (searchResultsFeedModulesDataLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27002b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23295C, b3);
                        } else {
                            f23294B = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFeedModulesDataLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsFeedModulesDataLoader(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, SearchResultsCollectionGraphQLConverter searchResultsCollectionGraphQLConverter, SearchResultsPerformanceLogger searchResultsPerformanceLogger, SearchResultsSizeUtil searchResultsSizeUtil, SizeAwareImageUtil sizeAwareImageUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, GraphQLStoryHelper graphQLStoryHelper, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, ExecutorService executorService, Executor executor, Lazy<ReactionUtil> lazy, SearchResultPageMainFilterConverter searchResultPageMainFilterConverter, SearchResultsHelper searchResultsHelper, CommerceSearchExperimentHelper commerceSearchExperimentHelper, EdgeRoutingConfig edgeRoutingConfig) {
        this.f23298b = resources;
        this.f23299c = graphQLQueryExecutor;
        this.f23300d = tasksManager;
        this.f23301e = searchResultsCollectionGraphQLConverter;
        this.f23302f = searchResultsPerformanceLogger;
        this.f23303g = searchResultsSizeUtil;
        this.f23304h = sizeAwareImageUtil;
        this.f23305i = fetchReactorsParamBuilderUtil;
        this.f23306j = fetchRecentActivityParamBuilderUtil;
        this.f23307k = graphQLStoryHelper;
        this.f23309m = qeAccessor;
        this.f23310n = gatekeeperStore;
        this.f23311o = fetchVideoChannelParamBuilderUtil;
        this.f23308l = executorService;
        this.f23312p = executor;
        this.f23313q = lazy;
        this.f23314r = searchResultPageMainFilterConverter;
        this.f23315s = searchResultsHelper;
        this.f23317u = commerceSearchExperimentHelper;
        this.f23318v = edgeRoutingConfig;
    }

    public final void m27013b() {
        m27007h();
        this.f23300d.c("keyword_search_result_loader_key");
        this.f23300d.c("keyword_search_result_loader_more_key");
        m27015d();
    }

    public final void m27010a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, boolean z) {
        m27011a(graphSearchQuerySpec, str, searchResultsSource, z, null);
    }

    public final void m27011a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, boolean z, @Nullable ImmutableList<Filters> immutableList) {
        if (!m27001a(graphSearchQuerySpec)) {
            this.f23321y = graphSearchQuerySpec;
            m27015d();
            this.f23301e.m26963a();
            if (this.f23309m.a(ExperimentsForSearchAbTestModule.bC, false) && (!this.f23309m.a(ExperimentsForSearchAbTestModule.bB, false) || !this.f23315s.m26944a(graphSearchQuerySpec))) {
                m26995a(graphSearchQuerySpec, str, searchResultsSource, z, (ImmutableList) immutableList, true);
            } else if (this.f23315s.m26944a(graphSearchQuerySpec) || this.f23309m.a(ExperimentsForSearchAbTestModule.bD, false)) {
                m27004b(graphSearchQuerySpec, str, searchResultsSource, z, immutableList);
            } else {
                m27000a("keyword_search_result_loader_key", graphSearchQuerySpec, null, str, searchResultsSource, SearchResultsRequestType.SINGLE, null, z, (ImmutableList) immutableList);
            }
        }
    }

    public final void m27012a(GraphSearchQuerySpec graphSearchQuerySpec, String str, @Nullable String str2, @Nullable SearchResultsSource searchResultsSource, SearchResultsFeedLoadMoreRequestType searchResultsFeedLoadMoreRequestType, ImmutableList<Filters> immutableList) {
        if (!m27014c()) {
            m27000a("keyword_search_result_loader_more_key", graphSearchQuerySpec, str, str2, searchResultsSource, SearchResultsRequestType.SINGLE, searchResultsFeedLoadMoreRequestType, false, (ImmutableList) immutableList);
        }
    }

    private void m27004b(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, boolean z, ImmutableList<Filters> immutableList) {
        this.f23297A = new ResultsOrderReinforcer(SearchResultsRequestType.PARALLEL_PRIMARY.name(), new C25041(this));
        graphSearchQuerySpec.mo1212b();
        TypedGraphQlQueryString a = m26986a(graphSearchQuerySpec, str, searchResultsSource, (ImmutableList) immutableList);
        a.a("top_modules_only", Boolean.valueOf(true));
        a.a("top_modules_already_shown", Boolean.valueOf(false));
        if (z) {
            a.a("update_activity_log", Boolean.valueOf(true));
        }
        m26998a("keyword_search_result_loader_key", m26983a(a), graphSearchQuerySpec, null, searchResultsSource, SearchResultsRequestType.PARALLEL_PRIMARY, null);
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.bB, false)) {
            m26995a(graphSearchQuerySpec, str, searchResultsSource, z, (ImmutableList) immutableList, false);
            return;
        }
        a = m26986a(graphSearchQuerySpec, str, searchResultsSource, (ImmutableList) immutableList);
        a.a("top_modules_only", Boolean.valueOf(false));
        a.a("top_modules_already_shown", Boolean.valueOf(true));
        m26998a("keyword_search_result_loader_key", m26983a(a), graphSearchQuerySpec, null, searchResultsSource, SearchResultsRequestType.PARALLEL_SECONDARY, null);
    }

    public final boolean m27014c() {
        return this.f23322z != null || this.f23300d.a("keyword_search_result_loader_key") || this.f23300d.a("keyword_search_result_loader_more_key");
    }

    public final void m27015d() {
        RequestSubscription requestSubscription = this.f23322z;
        if (requestSubscription != null) {
            requestSubscription.a();
        }
        this.f23322z = null;
    }

    private void m27000a(String str, GraphSearchQuerySpec graphSearchQuerySpec, String str2, @Nullable String str3, @Nullable SearchResultsSource searchResultsSource, SearchResultsRequestType searchResultsRequestType, @Nullable SearchResultsFeedLoadMoreRequestType searchResultsFeedLoadMoreRequestType, boolean z, @Nullable ImmutableList<Filters> immutableList) {
        TypedGraphQlQueryString a = m26986a(graphSearchQuerySpec, str3, searchResultsSource, (ImmutableList) immutableList);
        a.a("after_cursor", str2);
        if (z) {
            a.a("update_activity_log", Boolean.valueOf(true));
        }
        m26998a(str, m26983a(a), graphSearchQuerySpec, str2, searchResultsSource, searchResultsRequestType, searchResultsFeedLoadMoreRequestType);
    }

    private void m26998a(String str, GraphQLRequest graphQLRequest, GraphSearchQuerySpec graphSearchQuerySpec, String str2, @Nullable SearchResultsSource searchResultsSource, SearchResultsRequestType searchResultsRequestType, SearchResultsFeedLoadMoreRequestType searchResultsFeedLoadMoreRequestType) {
        if (searchResultsFeedLoadMoreRequestType == null) {
            NetworkRequestTimer.m26973a(this.f23316t);
        }
        final String name = searchResultsRequestType.name();
        this.f23302f.m25511a(graphSearchQuerySpec, Strings.isNullOrEmpty(str2), name);
        final String str3 = str;
        final GraphSearchQuerySpec graphSearchQuerySpec2 = graphSearchQuerySpec;
        final String str4 = str2;
        final SearchResultsRequestType searchResultsRequestType2 = searchResultsRequestType;
        final SearchResultsSource searchResultsSource2 = searchResultsSource;
        this.f23300d.c(str, m26991a(graphQLRequest), new AbstractDisposableFutureCallback<GraphQLResult<KeywordSearchQuery>>(this) {
            final /* synthetic */ SearchResultsFeedModulesDataLoader f23272g;

            protected final void m26966a(Object obj) {
                this.f23272g.m26999a(str3, graphSearchQuerySpec2, str4, (KeywordSearchQueryModel) ((GraphQLResult) obj).e, searchResultsRequestType2, searchResultsSource2, name);
            }

            protected final void m26967a(Throwable th) {
                SearchResultsFeedModulesDataLoader.m26996a(this.f23272g, new GraphSearchException(GraphSearchError.RESULTS_DATA_LOADER_ERROR, th));
            }

            protected final void m26968a(CancellationException cancellationException) {
                SearchResultsFeedModulesDataLoader.m26996a(this.f23272g, new GraphSearchException(GraphSearchError.RESULTS_DATA_LOADER_ERROR, cancellationException));
            }
        });
        m27005f();
    }

    private void m27005f() {
        if (this.f23310n.a(SearchAbTestGatekeepers.x, false) && !this.f23319w.getAndSet(true)) {
            ExecutorDetour.a(this.f23308l, new C25063(this), -1725081983);
        }
    }

    private void m26995a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, boolean z, ImmutableList<Filters> immutableList, boolean z2) {
        int[] g = m27006g();
        graphSearchQuerySpec.mo1212b();
        TypedGraphQlQueryString a = m26986a(graphSearchQuerySpec, str, searchResultsSource, (ImmutableList) immutableList);
        if (z) {
            a.a("update_activity_log", Boolean.valueOf(true));
        }
        GraphQLRequest a2 = m26983a(a);
        NetworkRequestTimer.m26973a(this.f23316t);
        RequestObserver a3 = m26984a(graphSearchQuerySpec, g.length, searchResultsSource);
        Set hashSet = new HashSet();
        GraphQLBatchRequest a4 = m26982a(g, graphSearchQuerySpec, a2, a3, str, searchResultsSource, (ImmutableList) immutableList, hashSet, z2);
        this.f23302f.m25510a(graphSearchQuerySpec, true, new ArrayList(hashSet));
        this.f23299c.a(a4, this.f23308l);
    }

    private RequestObserver<GraphQLResult<KeywordSearchQuery>> m26984a(final GraphSearchQuerySpec graphSearchQuerySpec, final int i, final SearchResultsSource searchResultsSource) {
        return new RequestObserver<GraphQLResult<KeywordSearchQuery>>(this) {
            int f23274a = (i + 1);
            final /* synthetic */ SearchResultsFeedModulesDataLoader f23278e;

            public final void m26970a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f23274a--;
                this.f23278e.m26999a("batch_request_task_key_not_used", graphSearchQuerySpec, null, (KeywordSearchQueryModel) graphQLResult.e, SearchResultsRequestType.STREAMING, searchResultsSource, graphQLResult.i);
                Class cls = SearchResultsFeedModulesDataLoader.f23296a;
                Integer.valueOf(((KeywordSearchQueryModel) graphQLResult.e).m8635a().m8589c().m8573c().size());
            }

            public final void m26969a() {
                this.f23278e.m27015d();
                this.f23278e.f23320x.bs = true;
            }

            public final void m26971a(Throwable th) {
                SearchResultsFeedModulesDataLoader.m26996a(this.f23278e, new GraphSearchException(GraphSearchError.RESULTS_DATA_LOADER_ERROR, th));
            }
        };
    }

    private int[] m27006g() {
        int[] a = FetchNewsFeedMethod.a(this.f23309m.a(ExperimentsForSearchAbTestModule.bE, ""));
        if (a != null && a.length != 0) {
            return a;
        }
        return new int[]{1};
    }

    private GraphQLBatchRequest m26982a(int[] iArr, GraphSearchQuerySpec graphSearchQuerySpec, GraphQLRequest graphQLRequest, RequestObserver<GraphQLResult<KeywordSearchQuery>> requestObserver, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, ImmutableList<Filters> immutableList, Set<String> set, boolean z) {
        Object obj;
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(graphQLRequest.b().c());
        GraphQlQueryString a = m26985a(0, graphSearchQuerySpec, str, searchResultsSource, true, graphQLRequest.b().c(), (ImmutableList) immutableList, true);
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.bF, false)) {
            obj = null;
        } else {
            obj = 1;
        }
        RequestObservable requestObservable = null;
        if (z && obj != null) {
            GraphQLRequest a2 = GraphQLRequest.a(a, graphQLRequest.n());
            requestObservable = graphQLBatchRequest.a(a2);
            set.add(a2.a());
            this.f23297A = new ResultsOrderReinforcer(a2.a(), new C25085(this));
        }
        int i = 0;
        RequestObservable requestObservable2 = requestObservable;
        GraphQLRequest graphQLRequest2 = null;
        while (i < iArr.length) {
            boolean z2;
            int i2 = iArr[i];
            String c = graphQLRequest.b().c();
            if (obj == null && z) {
                z2 = false;
            } else {
                z2 = true;
            }
            GraphQlQueryString a3 = m26985a(i2, graphSearchQuerySpec, str, searchResultsSource, false, c, (ImmutableList) immutableList, z2);
            if (i > 0) {
                a3.a("after_cursor", graphQLRequest2.a("end_cursor", BatchQueryFanOutStyle.FIRST, FallbackStyle.SKIP));
            }
            GraphQLRequest a4 = GraphQLRequest.a(a3, graphQLRequest.n());
            RequestObservable a5 = graphQLBatchRequest.a(a4);
            set.add(a4.a());
            if (requestObservable2 != null) {
                a5 = requestObservable2.a(a5);
            }
            i++;
            requestObservable2 = a5;
            graphQLRequest2 = a4;
        }
        this.f23322z = requestObservable2.a(this.f23312p).a(requestObserver);
        return graphQLBatchRequest;
    }

    private GraphQlQueryString m26985a(int i, GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, boolean z, String str2, ImmutableList<Filters> immutableList, boolean z2) {
        TypedGraphQlQueryString a = m26986a(graphSearchQuerySpec, str, searchResultsSource, (ImmutableList) immutableList);
        a.a("callsite", str2);
        if (z) {
            a.a("top_modules_only", Boolean.valueOf(true));
            a.a("top_modules_already_shown", Boolean.valueOf(false));
            a.a("first_unit_only", Boolean.valueOf(true));
        } else {
            if (z2) {
                a.a("top_modules_only", Boolean.valueOf(false));
                a.a("top_modules_already_shown", Boolean.valueOf(true));
            }
            a.a("modules_count", Integer.valueOf(i));
            if (i == 1) {
                a.a("first_unit_only", Boolean.valueOf(true));
            }
        }
        return a;
    }

    private void m26999a(String str, GraphSearchQuerySpec graphSearchQuerySpec, String str2, KeywordSearchQueryModel keywordSearchQueryModel, SearchResultsRequestType searchResultsRequestType, SearchResultsSource searchResultsSource, String str3) {
        Boolean.valueOf(this.f23300d.a(str));
        try {
            SearchResults a = this.f23301e.m26962a(keywordSearchQueryModel, searchResultsRequestType, searchResultsSource, graphSearchQuerySpec);
            m27007h();
            if (this.f23320x != null) {
                ImmutableList immutableList;
                String jC_;
                String d;
                boolean b;
                FilteredQueryModel a2 = keywordSearchQueryModel.m8635a();
                ModulesModel c = a2 != null ? a2.m8589c() : null;
                String jB_ = c != null ? c.jB_() : null;
                if (a2 == null || a2.m8588b().isEmpty()) {
                    immutableList = null;
                } else {
                    immutableList = ((SearchResultPageFiltersFragmentModel) a2.m8588b().get(0)).m10175a();
                }
                this.f23302f.m25509a(graphSearchQuerySpec, Strings.isNullOrEmpty(str2), keywordSearchQueryModel, str3, jB_);
                if (c != null) {
                    jC_ = c.jC_();
                } else {
                    jC_ = null;
                }
                if (a2 != null) {
                    d = a2.m8590d();
                } else {
                    d = null;
                }
                if (c != null) {
                    b = c.m8572b();
                } else {
                    b = false;
                }
                C2510x73e72fcc c2510x73e72fcc = new C2510x73e72fcc(a, jB_, jC_, d, str3, b, keywordSearchQueryModel.m8636b(), SearchResultPageMainFilterConverter.m26516a(immutableList));
                if (this.f23297A != null) {
                    this.f23297A.m26953a(str3, c2510x73e72fcc);
                } else {
                    this.f23320x.m26686a(c2510x73e72fcc);
                }
                Integer.valueOf(a.m27024a().size());
            }
        } catch (GraphSearchException e) {
            m26996a(this, e);
        }
    }

    public static void m26996a(SearchResultsFeedModulesDataLoader searchResultsFeedModulesDataLoader, GraphSearchException graphSearchException) {
        searchResultsFeedModulesDataLoader.m27007h();
        searchResultsFeedModulesDataLoader.f23302f.m25516c();
        if (searchResultsFeedModulesDataLoader.f23320x != null) {
            searchResultsFeedModulesDataLoader.f23320x.m26684a(graphSearchException);
        }
    }

    private void m27007h() {
        this.f23321y = null;
        this.f23297A = null;
        NetworkRequestTimer networkRequestTimer = this.f23316t;
        networkRequestTimer.f23285d = false;
        HandlerDetour.a(networkRequestTimer.f23283b, networkRequestTimer.f23284c);
    }

    private boolean m27001a(GraphSearchQuerySpec graphSearchQuerySpec) {
        return this.f23321y != null && this.f23321y.mo1212b().equals(graphSearchQuerySpec.mo1212b());
    }

    private static void m26993a(TypedGraphQlQueryString typedGraphQlQueryString, ImmutableMap<String, Parcelable> immutableMap) {
        typedGraphQlQueryString.a("for_sale", ((GraphSearchQueryCommerceModifier) immutableMap.get(ModifierKeys.GROUP_COMMERCE.name())).a);
    }

    private <T> ListenableFuture<GraphQLResult<T>> m26991a(GraphQLRequest graphQLRequest) {
        return this.f23299c.a(graphQLRequest);
    }

    private ImmutableList<String> m27003b(GraphSearchQuerySpec graphSearchQuerySpec) {
        Builder builder = new Builder();
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.ai, false)) {
            builder.c(SearchExperience.I18N_POST_SEARCH_EXPANSION);
        } else if (this.f23309m.a(ExperimentsForSearchAbTestModule.ak, false)) {
            builder.c(SearchExperience.I18N_POST_SEARCH_USER_EXPANSION);
        }
        if (this.f23310n.a(SearchAbTestGatekeepers.t, false)) {
            builder.c(SearchExperience.ATTACHED_HEADERS);
        }
        if (SearchQueryFunctions.c(graphSearchQuerySpec.mo1212b())) {
            builder.c(SearchExperience.FAST_FILTERS);
            builder.c(SearchExperience.FILTERS);
        }
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = graphSearchQuerySpec.mo1215f().size() > 0 ? (GraphQLGraphSearchResultsDisplayStyle) graphSearchQuerySpec.mo1215f().get(0) : null;
        if ((graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.BLENDED && this.f23309m.a(ExperimentsForSearchAbTestModule.t, false)) || (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.STORIES && this.f23309m.a(ExperimentsForSearchAbTestModule.s, false))) {
            builder.c(SearchExperience.DENSE_RESULT_PAGE);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.u, false)) {
            builder.c(SearchExperience.POST_SETS);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.q, false)) {
            builder.c(SearchExperience.DISAMBIGUATION_NON_BLENDER_ENTITY_MODULES);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.o, false)) {
            builder.c(SearchExperience.DISAMBIGUATION_MULTIPLE_POSTS_PER_MODULE);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.n, false)) {
            builder.c(SearchExperience.DISAMBIGUATION_INFINITE_SCROLL);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.D, false)) {
            builder.c(SearchExperience.DISAMBIGUATION_SEND_EMPTY_MODULES);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.C, false)) {
            builder.c(SearchExperience.DISAMBIGUATION_HIDE_LOW_QUALITY_ENTITY_MODULES);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.v, false)) {
            builder.c(SearchExperience.DISAMBIGUATION_TABLE_OF_CONTENTS_POST_MODULE);
        }
        if (GraphSearchQuerySpecHelper.m25630c(graphSearchQuerySpec) && this.f23309m.a(ExperimentsForSearchAbTestModule.bQ, false)) {
            builder.c(SearchExperience.TRENDING_FINITE_SERP);
        }
        ImmutableList b = builder.b();
        Builder builder2 = new Builder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            builder2.c(((SearchExperience) b.get(i)).serverValue);
        }
        String a = this.f23309m.a(ExperimentsForSearchAbTestModule.j, "");
        if (!(a == null || a.equals(""))) {
            for (Object c : a.split(",")) {
                builder2.c(c);
            }
        }
        return builder2.b();
    }

    private ImmutableList<GraphQLGraphSearchResultRole> m26990a(boolean z, GraphSearchQuerySpec graphSearchQuerySpec) {
        Builder builder = new Builder();
        builder.b(new GraphQLGraphSearchResultRole[]{GraphQLGraphSearchResultRole.CENTRAL, GraphQLGraphSearchResultRole.NEWS_MODULE, GraphQLGraphSearchResultRole.WIKIPEDIA_CARD, GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA, GraphQLGraphSearchResultRole.RELATED_SHARES_WITH_POSTS});
        if (SearchQueryFunctions.c(graphSearchQuerySpec.mo1212b())) {
            builder.c(GraphQLGraphSearchResultRole.COMMERCE_COMBINED);
        } else if (this.f23309m.a(ExperimentsForSearchAbTestModule.a, false)) {
            builder.c(GraphQLGraphSearchResultRole.COMMERCE_C2C);
            builder.c(GraphQLGraphSearchResultRole.COMMERCE_B2C);
        } else if (this.f23317u.a()) {
            builder.c(GraphQLGraphSearchResultRole.COMMERCE_COMBINED);
        }
        if (z) {
            builder.c(GraphQLGraphSearchResultRole.REACTION_UNIT);
        }
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.O, false)) {
            builder.c(GraphQLGraphSearchResultRole.NAVIGATIONAL_LINKS);
        }
        return builder.b();
    }

    private static int m27008i() {
        return GraphQlQueryDefaults.a().equals(ScaleInputPixelRatio.NUMBER_4) ? 96 : 48;
    }

    private static ScaleInputPixelRatio m27009j() {
        return GraphQlQueryDefaults.a().equals(ScaleInputPixelRatio.NUMBER_4) ? ScaleInputPixelRatio.NUMBER_2 : GraphQlQueryDefaults.a();
    }

    private static ImmutableList<ObjectNode> m26988a(int i) {
        return ImmutableList.of(new ObjectNode(JsonNodeFactory.a).a("role", "grammar").a("type", "photo").a("size", i), new ObjectNode(JsonNodeFactory.a).a("role", "none").a("type", "photo").a("size", i), new ObjectNode(JsonNodeFactory.a).a("role", GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA.toString()).a("type", "photo").a("size", i));
    }

    private TypedGraphQlQueryString m26986a(GraphSearchQuerySpec graphSearchQuerySpec, @Nullable String str, @Nullable SearchResultsSource searchResultsSource, ImmutableList<Filters> immutableList) {
        String searchResultsSource2;
        String b = graphSearchQuerySpec.mo1212b();
        ExactMatchInputExactMatch e = graphSearchQuerySpec.mo1214e();
        ImmutableMap jJ_ = graphSearchQuerySpec.jJ_();
        TypedGraphQlQueryString fetchKeywordSearchResultsString = new FetchKeywordSearchResultsString();
        GraphSearchQueryCommerceModifier graphSearchQueryCommerceModifier = (GraphSearchQueryCommerceModifier) jJ_.get(ModifierKeys.GROUP_COMMERCE.name());
        if (graphSearchQueryCommerceModifier != null && graphSearchQueryCommerceModifier.b()) {
            m26993a(fetchKeywordSearchResultsString, jJ_);
        }
        boolean a = this.f23309m.a(ExperimentsForSearchAbTestModule.N, false);
        if (a) {
            m26994a(fetchKeywordSearchResultsString, graphSearchQuerySpec.jH_());
        }
        GraphQlQueryString a2 = fetchKeywordSearchResultsString.a("query", b);
        String str2 = "query_source";
        if (searchResultsSource != null) {
            searchResultsSource2 = searchResultsSource.toString();
        } else {
            searchResultsSource2 = null;
        }
        a2.a(str2, searchResultsSource2).a("exact_match", e).a("profile_image_size", Integer.valueOf(this.f23298b.getDimensionPixelSize(2131431577))).a("facepile_image_size", Integer.valueOf(this.f23303g.m10688c())).a("facepile_count", Integer.valueOf(4)).a("default_image_scale", GraphQlQueryDefaults.a()).a("image_large_aspect_height", this.f23307k.z()).a("image_large_aspect_width", this.f23307k.y()).a("cover_photo_height", this.f23303g.m10690f()).a("cover_photo_fullscreen_long_dimen", this.f23303g.m10691g()).a("cover_photo_fullscreen_short_dimen", this.f23303g.m10692h()).a("articles_thumbnail_size", Integer.valueOf(this.f23303g.m10686a())).a("emotional_icon_scale", m27009j()).a("emotional_icon_size", Integer.valueOf(m27008i())).a("page_cta_enabled", Boolean.valueOf(this.f23309m.a(ExperimentsForSearchAbTestModule.bA, false))).a("module_sizes", m26988a(9)).a("supported_experiences", m27003b(graphSearchQuerySpec)).a("supported_roles", m26990a(a, graphSearchQuerySpec)).a("feed_story_attachments_location", "search_results_page").a("load_redundant_fields", Boolean.valueOf(false)).a("remove_attachment_feedback", Boolean.valueOf(true)).a("disable_story_menu_actions", Boolean.valueOf(true)).a("tsid", str).a("central_photo_blur_radius", Integer.valueOf(50)).a("trending_chaining_enabled", Boolean.valueOf(this.f23309m.a(ExperimentsForSearchAbTestModule.ba, false))).a("chaining_image_size", Integer.valueOf(this.f23298b.getDimensionPixelSize(2131431807))).a("enable_download", Boolean.toString(this.f23309m.a(ExperimentsForVideoAbTestModule.cW, false)));
        if (SearchQueryFunctions.a(b) && this.f23309m.a(ExperimentsForSearchAbTestModule.ba, false)) {
            fetchKeywordSearchResultsString.a("pivot_type", "NEXT_TRENDING");
        }
        if (SearchQueryFunctions.c(graphSearchQuerySpec.mo1212b())) {
            fetchKeywordSearchResultsString.a("callsite", SearchResultsCallsite.COMMERCE_SEARCH.toString());
        }
        if (this.f23317u.a() || this.f23309m.a(ExperimentsForSearchAbTestModule.a, false)) {
            fetchKeywordSearchResultsString.a("product_item_image_size", Integer.valueOf(this.f23298b.getDimensionPixelSize(2131432609)));
        }
        if (SearchQueryFunctions.c(graphSearchQuerySpec.mo1212b())) {
            fetchKeywordSearchResultsString.a("product_seller_profile_photo_size", Integer.valueOf(this.f23298b.getDimensionPixelSize(2131432621)));
        }
        fetchKeywordSearchResultsString.a("commerce_filters_enabled", Boolean.valueOf(SearchQueryFunctions.c(graphSearchQuerySpec.mo1212b())));
        if (immutableList != null) {
            fetchKeywordSearchResultsString.a("filters", m26989a((ImmutableList) immutableList));
        }
        this.f23304h.a(fetchKeywordSearchResultsString, null);
        this.f23306j.a(fetchKeywordSearchResultsString);
        this.f23311o.a(fetchKeywordSearchResultsString, EntryPointInputVideoChannelEntryPoint.SEARCH);
        return fetchKeywordSearchResultsString;
    }

    private GraphQLRequest m26983a(TypedGraphQlQueryString typedGraphQlQueryString) {
        GraphQLRequest a = GraphQLRequest.a(typedGraphQlQueryString).a(GraphQLCachePolicy.c).a(60);
        this.f23318v.a(Caller.SERP, a);
        if (this.f23309m.a(ExperimentsForSearchAbTestModule.aP, false)) {
            a.q = null;
        }
        return a;
    }

    private void m26994a(TypedGraphQlQueryString typedGraphQlQueryString, String str) {
        if ("content".equals(str) || "scoped".equals(str)) {
            ((ReactionUtil) this.f23313q.get()).m22659a((GraphQlQueryString) typedGraphQlQueryString, Surface.ANDROID_GPS_LOCATION_SUGGESTION);
            typedGraphQlQueryString.a("reaction_context", ((ReactionUtil) this.f23313q.get()).m22655a(Surface.ANDROID_GPS_LOCATION_SUGGESTION));
        }
    }

    private static ImmutableList<String> m26989a(ImmutableList<Filters> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(m26992a((Filters) immutableList.get(i)));
        }
        return builder.b();
    }

    private static String m26992a(Filters filters) {
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        Builder builder = new Builder();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            Map b = filters.b();
            a.f();
            a.a("name", b.get("name").toString());
            a.a("action", b.get("action").toString());
            a.a("value", b.get("value").toString());
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (Throwable e) {
            throw new RuntimeException("Unable to convert filters to json string", e);
        }
    }
}
