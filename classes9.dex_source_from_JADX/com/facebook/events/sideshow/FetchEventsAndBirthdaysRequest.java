package com.facebook.events.sideshow;

import com.facebook.common.time.SystemClock;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TYPE_GROUP */
public class FetchEventsAndBirthdaysRequest {
    public GraphQLQueryExecutor f24451a;
    public ListeningExecutorService f24452b;
    public SystemClock f24453c = SystemClock.a;

    /* compiled from: TYPE_GROUP */
    public class C29361 implements FutureCallback<GraphQLResult<SideshowEventsBirthdaysQueryModel>> {
        final /* synthetic */ FutureCallback f24449a;
        final /* synthetic */ FetchEventsAndBirthdaysRequest f24450b;

        public C29361(FetchEventsAndBirthdaysRequest fetchEventsAndBirthdaysRequest, FutureCallback futureCallback) {
            this.f24450b = fetchEventsAndBirthdaysRequest;
            this.f24449a = futureCallback;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f24449a != null) {
                this.f24449a.onSuccess(graphQLResult);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f24449a != null) {
                this.f24449a.onFailure(th);
            }
        }
    }

    @Inject
    public FetchEventsAndBirthdaysRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f24451a = graphQLQueryExecutor;
        this.f24452b = listeningExecutorService;
    }
}
