package com.facebook.events.feed.data;

import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.auth.login */
public class EventFeedPagerProtocol {
    public static final Function<OperationResult, EventFeedStories> f17365a = new C24511();
    public final Executor f17366b;
    public DefaultBlueServiceOperationFactory f17367c;
    public int f17368d;
    public FeedType f17369e;
    public FeedFetchContext f17370f;

    /* compiled from: com.facebook.auth.login */
    final class C24511 implements Function<OperationResult, EventFeedStories> {
        C24511() {
        }

        public final Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            FetchFeedResult fetchFeedResult = (FetchFeedResult) operationResult.k();
            GraphQLFeedHomeStories graphQLFeedHomeStories = fetchFeedResult.b;
            return new EventFeedStories(graphQLFeedHomeStories.k(), graphQLFeedHomeStories.n(), fetchFeedResult.freshness);
        }
    }

    public static EventFeedPagerProtocol m17677a(InjectorLike injectorLike) {
        return new EventFeedPagerProtocol((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public EventFeedPagerProtocol(ExecutorService executorService, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f17366b = executorService;
        this.f17367c = defaultBlueServiceOperationFactory;
    }
}
