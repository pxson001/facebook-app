package com.facebook.topics.data;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.TopicProjectInputTopicProject;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.topics.protocol.TopicFavoritesQuery.TopicFeedListString;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: mExistingReactionSessionId */
public class TopicListFetcher {
    public final GraphQLQueryExecutor f9528a;
    private final TasksManager f9529b;
    public final int f9530c;

    public static TopicListFetcher m11211b(InjectorLike injectorLike) {
        return new TopicListFetcher(ResourcesMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public TopicListFetcher(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f9528a = graphQLQueryExecutor;
        this.f9529b = tasksManager;
        int i = resources.getDisplayMetrics().densityDpi;
        if (i == 120 || i == 160 || i == 240) {
            i = 1;
        } else if (i == 320) {
            i = 2;
        } else {
            i = 3;
        }
        this.f9530c = i;
    }

    public final void m11212a(final TopicProjectInputTopicProject topicProjectInputTopicProject, final GraphQLCachePolicy graphQLCachePolicy, AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        this.f9529b.a("QUERY_TOPIC_FEEDS_FAVORITES_KEY", new Callable<ListenableFuture>(this) {
            final /* synthetic */ TopicListFetcher f9527c;

            public Object call() {
                GraphQlQueryString topicFeedListString = new TopicFeedListString();
                topicFeedListString.a("scale", Integer.valueOf(this.f9527c.f9530c));
                topicFeedListString.a("topic_project", topicProjectInputTopicProject);
                GraphQLRequest a = GraphQLRequest.a(topicFeedListString).a(graphQLCachePolicy).a(900);
                a.b = true;
                return this.f9527c.f9528a.a(a);
            }
        }, abstractDisposableFutureCallback);
    }
}
