package com.facebook.productionprompts;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.productionprompts.graphql.ProductionPromptsGraphQLMutationsModels.ProductionPromptCoreMutationFieldsModel;

/* compiled from: require('MPagesPlatformNativeBridge').bootCTA( */
class ProductionPromptsPromptFetcher$3 extends AbstractDisposableFutureCallback<GraphQLResult<ProductionPromptCoreMutationFieldsModel>> {
    final /* synthetic */ ProductionPromptsPromptFetcher f4503a;

    ProductionPromptsPromptFetcher$3(ProductionPromptsPromptFetcher productionPromptsPromptFetcher) {
        this.f4503a = productionPromptsPromptFetcher;
    }

    protected final void m4358a(Object obj) {
        this.f4503a.d();
    }

    protected final void m4359a(Throwable th) {
    }
}
