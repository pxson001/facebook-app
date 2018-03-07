package com.facebook.photos.creativeediting.swipeable.prompt;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.swipeable.common.FramePackProvider;
import com.facebook.productionprompts.common.ProductionPromptsQueryFetchingHelper;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.ProductionPromptsInfoModel;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: south_latitude */
public class PromptsFramePackProvider implements FramePackProvider {
    public final ProductionPromptsQueryFetchingHelper f2321a;
    private GraphQLQueryExecutor f2322b;

    /* compiled from: south_latitude */
    class C02771 implements Function<GraphQLResult<FetchProductionPromptsQueryModel>, ImmutableList<FramePack>> {
        final /* synthetic */ PromptsFramePackProvider f2320a;

        C02771(PromptsFramePackProvider promptsFramePackProvider) {
            this.f2320a = promptsFramePackProvider;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ImmutableList a = ProductionPromptsQueryFetchingHelper.a((GraphQLResult) obj);
            Builder builder = new Builder();
            if (a != null) {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    ProductionPrompt a2 = ProductionPrompt.a((ProductionPromptsInfoModel) a.get(i));
                    if (a2.m() != null && this.f2320a.f2321a.a(a2)) {
                        builder.c(a2.m());
                    }
                }
            }
            return builder.b();
        }
    }

    @Inject
    public PromptsFramePackProvider(ProductionPromptsQueryFetchingHelper productionPromptsQueryFetchingHelper, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f2321a = productionPromptsQueryFetchingHelper;
        this.f2322b = graphQLQueryExecutor;
    }

    public final ListenableFuture<ImmutableList<FramePack>> m2439a() {
        return Futures.a(this.f2322b.a(this.f2321a.a()), new C02771(this));
    }
}
