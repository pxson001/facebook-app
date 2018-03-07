package com.facebook.productionprompts;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.productionprompts.graphql.ProductionPromptsGraphQLMutationsModels.ProductionPromptCoreMutationFieldsModel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: require('MPagesPlatformNativeBridge').bootCTA( */
class ProductionPromptsPromptFetcher$2 implements Callable<ListenableFuture<GraphQLResult<ProductionPromptCoreMutationFieldsModel>>> {
    final /* synthetic */ MutationRequest f4501a;
    final /* synthetic */ ProductionPromptsPromptFetcher f4502b;

    ProductionPromptsPromptFetcher$2(ProductionPromptsPromptFetcher productionPromptsPromptFetcher, MutationRequest mutationRequest) {
        this.f4502b = productionPromptsPromptFetcher;
        this.f4501a = mutationRequest;
    }

    public Object call() {
        return this.f4502b.c.a(this.f4501a);
    }
}
