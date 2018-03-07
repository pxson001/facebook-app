package com.facebook.messaging.contextbanner;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryModels.PageContextQueryModel;
import com.facebook.messaging.contextbanner.model.ContextItems;
import com.facebook.messaging.contextbanner.model.PageContextItems;
import com.facebook.messaging.contextbanner.model.PageContextItemsProvider;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.base.Function;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: suggestion_reason */
public class GQLPageContextHelper {
    public final ExecutorService f2191a;
    public final GraphQLQueryExecutor f2192b;
    public final PageContextItemsProvider f2193c;

    /* compiled from: suggestion_reason */
    public class C03661 implements Function<GraphQLResult<PageContextQueryModel>, ContextItems> {
        final /* synthetic */ ThreadSummary f2189a;
        final /* synthetic */ GQLPageContextHelper f2190b;

        public C03661(GQLPageContextHelper gQLPageContextHelper, ThreadSummary threadSummary) {
            this.f2190b = gQLPageContextHelper;
            this.f2189a = threadSummary;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return new PageContextItems((PageContextQueryModel) ((GraphQLResult) obj).e, this.f2189a, ResourcesMethodAutoProvider.a(this.f2190b.f2193c));
        }
    }

    @Inject
    public GQLPageContextHelper(PageContextItemsProvider pageContextItemsProvider, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f2191a = executorService;
        this.f2192b = graphQLQueryExecutor;
        this.f2193c = pageContextItemsProvider;
    }
}
