package com.facebook.checkin.socialsearch.conversion;

import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.StoryConversionDetailsModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: delta_wall_time_to_last_geofence_ms */
public class StoryConversionInfoFetcher {
    public final GraphQLQueryExecutor f15106a;
    public final TasksManager f15107b;

    /* compiled from: delta_wall_time_to_last_geofence_ms */
    public class C21011 extends AbstractDisposableFutureCallback<GraphQLResult<StoryConversionDetailsModel>> {
        final /* synthetic */ FutureCallback f15104a;
        final /* synthetic */ StoryConversionInfoFetcher f15105b;

        public C21011(StoryConversionInfoFetcher storyConversionInfoFetcher, FutureCallback futureCallback) {
            this.f15105b = storyConversionInfoFetcher;
            this.f15104a = futureCallback;
        }

        public final void m15629a(@Nullable Object obj) {
            this.f15104a.onSuccess((GraphQLResult) obj);
        }

        public final void m15630a(Throwable th) {
            this.f15104a.onFailure(th);
        }
    }

    @Inject
    public StoryConversionInfoFetcher(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f15106a = graphQLQueryExecutor;
        this.f15107b = tasksManager;
    }
}
