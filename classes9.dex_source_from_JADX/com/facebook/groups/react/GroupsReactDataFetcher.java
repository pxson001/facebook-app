package com.facebook.groups.react;

import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.react.bridge.ReactContext;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payment_pin_db */
public class GroupsReactDataFetcher {
    private final ReactContext f7019a;
    public final TasksManager f7020b;
    public Lazy<FeedbackLoader> f7021c;

    /* compiled from: payment_pin_db */
    public enum Tasks {
        FETCH_HEADER,
        FETCH_PERMALINK_STORY
    }

    public final void m7317a(final String str, final FetchType fetchType, final FutureCallback<GraphQLStory> futureCallback) {
        this.f7020b.c(Tasks.FETCH_HEADER);
        this.f7020b.c(Tasks.FETCH_PERMALINK_STORY);
        this.f7019a.a(new Runnable(this) {
            final /* synthetic */ GroupsReactDataFetcher f7018d;

            /* compiled from: payment_pin_db */
            class C07351 implements Callable<ListenableFuture<GraphQLResult<GraphQLStory>>> {
                final /* synthetic */ C07371 f7013a;

                C07351(C07371 c07371) {
                    this.f7013a = c07371;
                }

                public Object call() {
                    return ((FeedbackLoader) this.f7013a.f7018d.f7021c.get()).a(str, fetchType, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
                }
            }

            /* compiled from: payment_pin_db */
            class C07362 extends AbstractDisposableFutureCallback<GraphQLResult<GraphQLStory>> {
                final /* synthetic */ C07371 f7014a;

                C07362(C07371 c07371) {
                    this.f7014a = c07371;
                }

                protected final void m7315a(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null) {
                        futureCallback.onFailure(null);
                        return;
                    }
                    GraphQLStory graphQLStory = (GraphQLStory) graphQLResult.e;
                    if (graphQLStory == null) {
                        futureCallback.onFailure(null);
                    } else {
                        futureCallback.onSuccess(graphQLStory);
                    }
                }

                protected final void m7316a(Throwable th) {
                    futureCallback.onFailure(th);
                }
            }

            public void run() {
                this.f7018d.f7020b.a(Tasks.FETCH_PERMALINK_STORY, new C07351(this), new C07362(this));
            }
        });
    }

    @Inject
    public GroupsReactDataFetcher(@Assisted ReactContext reactContext, TasksManager tasksManager, Lazy<FeedbackLoader> lazy) {
        this.f7019a = reactContext;
        this.f7020b = tasksManager;
        this.f7021c = lazy;
    }
}
