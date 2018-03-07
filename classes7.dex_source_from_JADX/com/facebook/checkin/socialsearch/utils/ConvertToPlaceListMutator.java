package com.facebook.checkin.socialsearch.utils;

import com.facebook.checkin.socialsearch.graphql.PlaceListMutationsModels.ConvertToPlaceListStoryMutationCallModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: uTransformMatrix */
public class ConvertToPlaceListMutator {
    public final GraphQLQueryExecutor f1146a;
    public final TasksManager f1147b;

    /* compiled from: uTransformMatrix */
    public class C01091 extends AbstractDisposableFutureCallback<GraphQLResult<ConvertToPlaceListStoryMutationCallModel>> {
        final /* synthetic */ FutureCallback f1144a;
        final /* synthetic */ ConvertToPlaceListMutator f1145b;

        public C01091(ConvertToPlaceListMutator convertToPlaceListMutator, FutureCallback futureCallback) {
            this.f1145b = convertToPlaceListMutator;
            this.f1144a = futureCallback;
        }

        public final void m1238a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f1144a != null) {
                this.f1144a.onSuccess(graphQLResult);
            }
        }

        public final void m1239a(Throwable th) {
            if (this.f1144a != null) {
                this.f1144a.onFailure(th);
            }
        }
    }

    @Inject
    public ConvertToPlaceListMutator(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f1146a = graphQLQueryExecutor;
        this.f1147b = tasksManager;
    }
}
