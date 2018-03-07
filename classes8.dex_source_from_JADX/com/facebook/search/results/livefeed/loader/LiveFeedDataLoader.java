package com.facebook.search.results.livefeed.loader;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQL.FetchLiveFeedStoriesGraphQLString;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLInterfaces.LiveFeedQuery;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLModels.FetchLiveFeedStoriesGraphQLModel;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLModels.LiveFeedNodeModel;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLModels.LiveFeedQueryModel;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLModels.LiveFeedQueryModel.ResultsModel;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SEARCH_VIEWED */
public class LiveFeedDataLoader {
    private final GraphQLQueryExecutor f23203a;
    public final TasksManager<String> f23204b;
    public final LiveFeedDataHandler f23205c;
    public final SearchResultsMutableContext f23206d;

    /* compiled from: SEARCH_VIEWED */
    class C24952 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveFeedStoriesGraphQLModel>> {
        final /* synthetic */ LiveFeedDataLoader f23198a;

        C24952(LiveFeedDataLoader liveFeedDataLoader) {
            this.f23198a = liveFeedDataLoader;
        }

        protected final void m26900a(Object obj) {
            LiveFeedQueryModel a = ((FetchLiveFeedStoriesGraphQLModel) ((GraphQLResult) obj).e).m9397a();
            if (a == null) {
                m26901a(new Exception("filtered_query was null"));
            } else {
                this.f23198a.f23205c.mo1296a(LiveFeedDataLoader.m26907d(a), Optional.fromNullable(LiveFeedDataLoader.m26906c(a)), a.m9417c(), a.m9418d(), a.m9415a());
            }
        }

        protected final void m26901a(Throwable th) {
            this.f23198a.f23205c.mo1295a(new GraphSearchException(GraphSearchError.LIVE_CONVERSATION_FETCH_FAIL, th));
        }
    }

    /* compiled from: SEARCH_VIEWED */
    public class C24963 implements Callable<ListenableFuture<GraphQLResult<FetchLiveFeedStoriesGraphQLModel>>> {
        final /* synthetic */ String f23199a;
        final /* synthetic */ int f23200b;
        final /* synthetic */ LiveFeedDataLoader f23201c;

        public C24963(LiveFeedDataLoader liveFeedDataLoader, String str, int i) {
            this.f23201c = liveFeedDataLoader;
            this.f23199a = str;
            this.f23200b = i;
        }

        public Object call() {
            return this.f23201c.m26905a("android:live-feed:tail", this.f23201c.f23206d, null, this.f23199a, Integer.valueOf(this.f23200b));
        }
    }

    /* compiled from: SEARCH_VIEWED */
    public class C24974 extends AbstractDisposableFutureCallback<GraphQLResult<FetchLiveFeedStoriesGraphQLModel>> {
        final /* synthetic */ LiveFeedDataLoader f23202a;

        public C24974(LiveFeedDataLoader liveFeedDataLoader) {
            this.f23202a = liveFeedDataLoader;
        }

        protected final void m26902a(Object obj) {
            LiveFeedQueryModel a = ((FetchLiveFeedStoriesGraphQLModel) ((GraphQLResult) obj).e).m9397a();
            if (a == null) {
                m26903a(new Exception("filtered_query was null"));
            } else {
                this.f23202a.f23205c.mo1297b(LiveFeedDataLoader.m26907d(a), Optional.fromNullable(LiveFeedDataLoader.m26906c(a)), a.m9417c(), a.m9418d(), a.m9415a());
            }
        }

        protected final void m26903a(Throwable th) {
            this.f23202a.f23205c.mo1295a(new GraphSearchException(GraphSearchError.LIVE_CONVERSATION_FETCH_FAIL, th));
        }
    }

    @Inject
    public LiveFeedDataLoader(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted LiveFeedDataHandler liveFeedDataHandler) {
        this.f23203a = graphQLQueryExecutor;
        this.f23204b = tasksManager;
        this.f23206d = searchResultsMutableContext;
        this.f23205c = liveFeedDataHandler;
    }

    public final void m26908a(@Nullable final String str, @Nullable final Integer num) {
        this.f23204b.a("fetch_live_conversations_headload", new Callable<ListenableFuture<GraphQLResult<FetchLiveFeedStoriesGraphQLModel>>>(this) {
            final /* synthetic */ LiveFeedDataLoader f23197c;

            public Object call() {
                return this.f23197c.m26905a("android:live-feed:head", this.f23197c.f23206d, str, null, num);
            }
        }, new C24952(this));
    }

    @Nullable
    public static DefaultPageInfoFields m26906c(LiveFeedQueryModel liveFeedQueryModel) {
        if (liveFeedQueryModel != null) {
            ResultsModel b = liveFeedQueryModel.m9416b();
            if (b != null) {
                return b.m9410b();
            }
        }
        return null;
    }

    public static ImmutableList<GraphQLStory> m26907d(LiveFeedQuery liveFeedQuery) {
        Builder builder = new Builder();
        if (liveFeedQuery != null) {
            ResultsModel b = liveFeedQuery.m9416b();
            if (b != null) {
                ImmutableList a = b.m9409a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    GraphQLStory a2 = ((LiveFeedNodeModel) a.get(i)).m9401a();
                    if (a2 != null) {
                        builder.c(a2);
                    }
                }
            }
        }
        return builder.b();
    }

    private ListenableFuture<GraphQLResult<FetchLiveFeedStoriesGraphQLModel>> m26905a(String str, SearchResultsContext searchResultsContext, @Nullable String str2, @Nullable String str3, Integer num) {
        GraphQlQueryString fetchLiveFeedStoriesGraphQLString = new FetchLiveFeedStoriesGraphQLString();
        fetchLiveFeedStoriesGraphQLString.a("call_site", str).a("query_function", searchResultsContext.mo1212b()).a("before_cursor", str2).a("after_cursor", str3).a("tsid", searchResultsContext.f23369d.b);
        if (num != null) {
            fetchLiveFeedStoriesGraphQLString.a("count", num);
        }
        return this.f23203a.a(GraphQLRequest.a(fetchLiveFeedStoriesGraphQLString).a(GraphQLCachePolicy.c).a(60));
    }
}
