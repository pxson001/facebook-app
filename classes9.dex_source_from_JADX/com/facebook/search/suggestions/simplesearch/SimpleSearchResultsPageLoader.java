package com.facebook.search.suggestions.simplesearch;

import android.content.res.Resources;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.FilterType;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.model.converter.EntitySuggestionGraphQLModelConverter;
import com.facebook.search.model.converter.FilterGraphQLModelConverter;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQL.FB4AGraphSearchUserWithFiltersQueryString;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchFilterInfoFragmentModel;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchUserWithFiltersQueryModel;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchUserWithFiltersQueryModel.FilteredQueryModel.ResultsModel;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQL.FetchSimpleSearchEntitiesQueryString;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLModels.FetchSimpleSearchEntitiesQueryModel;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLModels.FetchSimpleSearchEntitiesQueryModel.SearchResultsModel.EdgesModel;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLModels.FetchSimpleSearchEntitiesQueryModel.SearchResultsModel.PageInfoModel;
import com.facebook.search.results.fragment.pps.SimpleAndGraphSearchFetchHelper.ResultsListener;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.favorites */
public class SimpleSearchResultsPageLoader {
    private final GraphQLQueryExecutor f277a;
    private final Resources f278b;
    public final EntitySuggestionGraphQLModelConverter f279c;
    public final FilterGraphQLModelConverter f280d;
    public final TasksManager<String> f281e;
    public final GraphSearchErrorReporter f282f;

    @Inject
    public SimpleSearchResultsPageLoader(GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, EntitySuggestionGraphQLModelConverter entitySuggestionGraphQLModelConverter, FilterGraphQLModelConverter filterGraphQLModelConverter, TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f277a = graphQLQueryExecutor;
        this.f278b = resources;
        this.f279c = entitySuggestionGraphQLModelConverter;
        this.f280d = filterGraphQLModelConverter;
        this.f281e = tasksManager;
        this.f282f = graphSearchErrorReporter;
    }

    public final void m410a(String str, int i, FilterType filterType, @Nullable String str2, final ResultsListener resultsListener, @Nullable String str3) {
        Preconditions.checkState(str != null);
        this.f281e.b("simple_search_loader_key" + filterType, m407a(str, i, str2, filterType, str3), new AbstractDisposableFutureCallback<GraphQLResult<FetchSimpleSearchEntitiesQueryModel>>(this) {
            final /* synthetic */ SimpleSearchResultsPageLoader f274b;

            protected final void m401a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.d() == null || ((FetchSimpleSearchEntitiesQueryModel) graphQLResult.d()).a() == null || ((FetchSimpleSearchEntitiesQueryModel) graphQLResult.d()).a().a() == null) {
                    this.f274b.f282f.a(GraphSearchError.FETCH_GRAPH_SEARCH_RESULT_DATA_FAIL, "See more remote fetch returned null data");
                    resultsListener.a();
                } else if (((FetchSimpleSearchEntitiesQueryModel) graphQLResult.d()).a().j() == null) {
                    this.f274b.f282f.a(GraphSearchError.FETCH_GRAPH_SEARCH_RESULT_DATA_FAIL, "Failed to grab page info");
                    resultsListener.a();
                } else {
                    ImmutableList a = ((FetchSimpleSearchEntitiesQueryModel) graphQLResult.d()).a().a();
                    Builder builder = ImmutableList.builder();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        try {
                            builder.c(EntitySuggestionGraphQLModelConverter.a((EdgesModel) a.get(i)));
                        } catch (GraphSearchException e) {
                            this.f274b.f282f.a(e);
                        }
                    }
                    ImmutableList b = builder.b();
                    PageInfoModel j = ((FetchSimpleSearchEntitiesQueryModel) graphQLResult.d()).a().j();
                    resultsListener.a(b, null, j.a(), j.k(), j.j());
                }
            }

            protected final void m403a(CancellationException cancellationException) {
                resultsListener.b();
            }

            protected final void m402a(Throwable th) {
                resultsListener.a();
            }
        });
    }

    public final void m411a(String str, int i, FilterType filterType, @Nullable String str2, @Nullable ImmutableList<NeedleFilter> immutableList, final OnResultsFetchedListener onResultsFetchedListener) {
        Preconditions.checkNotNull(str);
        Preconditions.checkState(filterType == FilterType.People);
        this.f281e.b("simple_search_loader_key" + filterType, m408a(str, i, str2, immutableList), new AbstractDisposableFutureCallback<GraphQLResult<FB4AGraphSearchUserWithFiltersQueryModel>>(this) {
            final /* synthetic */ SimpleSearchResultsPageLoader f276b;

            protected final void m404a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                int i = 0;
                if (graphQLResult == null || graphQLResult.d() == null || ((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a() == null || ((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a().k() == null || ((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a().k().a() == null) {
                    this.f276b.f282f.a(GraphSearchError.FETCH_GRAPH_SEARCH_RESULT_DATA_FAIL, "See more remote fetch returned null data");
                    onResultsFetchedListener.a();
                } else if (((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a().k().j() == null) {
                    this.f276b.f282f.a(GraphSearchError.FETCH_GRAPH_SEARCH_RESULT_DATA_FAIL, "Failed to grab page info");
                    onResultsFetchedListener.a();
                } else {
                    ImmutableList a = ((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a().k().a();
                    Builder builder = ImmutableList.builder();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            builder.c(this.f276b.f279c.a((ResultsModel.EdgesModel) a.get(i2)));
                        } catch (GraphSearchException e) {
                            this.f276b.f282f.a(e);
                        }
                    }
                    ImmutableList b = builder.b();
                    a = ((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a().j();
                    builder = ImmutableList.builder();
                    size = a.size();
                    while (i < size) {
                        FB4AGraphSearchFilterInfoFragmentModel fB4AGraphSearchFilterInfoFragmentModel = (FB4AGraphSearchFilterInfoFragmentModel) a.get(i);
                        if (fB4AGraphSearchFilterInfoFragmentModel.a() != null) {
                            try {
                                builder.c(this.f276b.f280d.a(fB4AGraphSearchFilterInfoFragmentModel.a()));
                            } catch (GraphSearchException e2) {
                                this.f276b.f282f.a(e2);
                            }
                        }
                        i++;
                    }
                    ImmutableList b2 = builder.b();
                    if (b2.isEmpty()) {
                        this.f276b.f282f.a(GraphSearchError.FETCH_NEEDLE_FILTERS_FAIL, "No needle filters received, filter bar will disappear!");
                    }
                    ResultsModel.PageInfoModel j = ((FB4AGraphSearchUserWithFiltersQueryModel) graphQLResult.d()).a().k().j();
                    onResultsFetchedListener.a(b, b2, j.a(), j.k(), j.j());
                }
            }

            protected final void m406a(CancellationException cancellationException) {
                onResultsFetchedListener.b();
            }

            protected final void m405a(Throwable th) {
                onResultsFetchedListener.a();
            }
        });
    }

    private ListenableFuture<GraphQLResult<FetchSimpleSearchEntitiesQueryModel>> m407a(String str, int i, @Nullable String str2, FilterType filterType, @Nullable String str3) {
        return this.f277a.a(GraphQLRequest.a(new FetchSimpleSearchEntitiesQueryString()).a(GraphQLCachePolicy.c).a(new FetchSimpleSearchEntitiesQueryString().a("query", str).a("count", String.valueOf(i)).a("after", str2).a("type", filterType.toString()).a("profile_picture_size", this.f278b.getDimensionPixelSize(2131427460)).a("session_id", str3).a));
    }

    private ListenableFuture<GraphQLResult<FB4AGraphSearchUserWithFiltersQueryModel>> m408a(String str, int i, @Nullable String str2, ImmutableList<NeedleFilter> immutableList) {
        ImmutableList immutableList2;
        GraphQlQueryString a = new FB4AGraphSearchUserWithFiltersQueryString().a("query", "users-named(" + str + ")").a("count", Integer.valueOf(i)).a("after", str2).a("device", "android");
        String str3 = "filter";
        if (immutableList == null || immutableList.isEmpty()) {
            immutableList2 = null;
        } else {
            Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (int i2 = 0; i2 < size; i2++) {
                NeedleFilter needleFilter = (NeedleFilter) immutableList.get(i2);
                if (needleFilter.d != null) {
                    builder.c(m409a(needleFilter));
                }
            }
            immutableList2 = builder.b();
        }
        return this.f277a.a(GraphQLRequest.a(new FB4AGraphSearchUserWithFiltersQueryString()).a(GraphQLCachePolicy.c).a(a.a(str3, immutableList2).a("profile_picture_size", Integer.toString(this.f278b.getDimensionPixelSize(2131427460))).a));
    }

    public static String m409a(NeedleFilter needleFilter) {
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            a.f();
            a.a("name", needleFilter.b());
            a.a("action", "add");
            a.a("value", needleFilter.d().b());
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (Throwable e) {
            throw new RuntimeException("Unable to convert filters to json string", e);
        }
    }
}
