package com.facebook.search.results.filters.loader;

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
import com.facebook.search.model.converter.FilterValueGraphQLModelConverter;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQL.FB4AGraphSearchFilterQueryString;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchFilterQueryModel;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchFilterQueryModel.FilterValuesModel.EdgesModel;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SLIDESHOW_SELECTED */
public class FilterValueLoader {
    private final GraphQLQueryExecutor f22852a;
    private final Resources f22853b;
    private final FilterValueGraphQLModelConverter f22854c;
    public final TasksManager<String> f22855d;
    public final GraphSearchErrorReporter f22856e;
    @Nullable
    public OnFilterValuesFetchedListener f22857f;

    @Inject
    public FilterValueLoader(GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, FilterValueGraphQLModelConverter filterValueGraphQLModelConverter, TasksManager tasksManager, GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f22852a = graphQLQueryExecutor;
        this.f22853b = resources;
        this.f22854c = filterValueGraphQLModelConverter;
        this.f22855d = tasksManager;
        this.f22856e = graphSearchErrorReporter;
    }

    public final void m26509a(final String str, final String str2, final String str3, int i) {
        Preconditions.checkNotNull(this.f22857f);
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        this.f22855d.b("simple_search_loader_filter_value" + str2 + str, m26508a(str, str2, i), new AbstractDisposableFutureCallback<GraphQLResult<FB4AGraphSearchFilterQueryModel>>(this) {
            final /* synthetic */ FilterValueLoader f22851d;

            protected final void m26505a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.d() == null || ((FB4AGraphSearchFilterQueryModel) graphQLResult.d()).m8299j() == null) {
                    this.f22851d.f22856e.a(GraphSearchError.BAD_SUGGESTION, "Needle Filter Value returned null");
                    this.f22851d.f22857f.mo1269a(str2);
                    return;
                }
                ImmutableList a = ((FB4AGraphSearchFilterQueryModel) graphQLResult.d()).m8299j().m8290a();
                Builder builder = ImmutableList.builder();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (edgesModel.m8286a() != null) {
                        try {
                            FilterValue a2 = FilterValueGraphQLModelConverter.m25806a(edgesModel.m8286a());
                            if (!Strings.isNullOrEmpty(a2.m10139c())) {
                                builder.c(a2);
                            }
                        } catch (GraphSearchException e) {
                            this.f22851d.f22856e.a(e);
                        }
                    }
                }
                this.f22851d.f22857f.mo1270a(str, str2, str3, new SearchResponse(builder.b()));
            }

            protected final void m26507a(CancellationException cancellationException) {
                this.f22851d.f22857f.mo1271b(str2);
            }

            protected final void m26506a(Throwable th) {
                this.f22851d.f22857f.mo1269a(str2);
            }
        });
    }

    private ListenableFuture<GraphQLResult<FB4AGraphSearchFilterQueryModel>> m26508a(String str, String str2, int i) {
        GraphQlQueryString a = new FB4AGraphSearchFilterQueryString().a("filterID", str);
        String str3 = "substring";
        if (Strings.isNullOrEmpty(str2)) {
            str2 = null;
        }
        return this.f22852a.a(GraphQLRequest.a(new FB4AGraphSearchFilterQueryString()).a(GraphQLCachePolicy.c).a(a.a(str3, str2).a("count", Integer.valueOf(i)).a("profile_picture_size", Integer.toString(this.f22853b.getDimensionPixelSize(2131431613))).a));
    }
}
