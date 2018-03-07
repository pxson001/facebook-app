package com.facebook.pages.common.editpage;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQuery.FetchEditPageQueryString;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.FetchEditPageQueryModel;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: single */
public class EditPageFetcher {
    private final GraphQLQueryExecutor f1531a;

    public static EditPageFetcher m2223b(InjectorLike injectorLike) {
        return new EditPageFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public EditPageFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f1531a = graphQLQueryExecutor;
    }

    public final ListenableFuture<FetchEditPageQueryModel> m2224a(long j) {
        Preconditions.checkArgument(j > 0);
        return GraphQLQueryExecutor.a(this.f1531a.a(GraphQLRequest.a((FetchEditPageQueryString) new FetchEditPageQueryString().a("page_id", String.valueOf(j)))));
    }
}
