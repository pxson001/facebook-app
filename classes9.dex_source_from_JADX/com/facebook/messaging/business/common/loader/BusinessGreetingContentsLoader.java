package com.facebook.messaging.business.common.loader;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragments.BusinessGreetingContentsQueryString;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessGreetingContentsQueryModel;
import com.facebook.messaging.business.common.model.BusinessGreetingItem;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: netcheck_state */
public class BusinessGreetingContentsLoader {
    public final GraphQLQueryExecutor f8765a;
    public final Provider<String> f8766b;

    /* compiled from: netcheck_state */
    class C10031 implements Function<BusinessGreetingContentsQueryModel, BusinessGreetingItem> {
        final /* synthetic */ BusinessGreetingContentsLoader f8764a;

        C10031(BusinessGreetingContentsLoader businessGreetingContentsLoader) {
            this.f8764a = businessGreetingContentsLoader;
        }

        public Object apply(Object obj) {
            BusinessGreetingContentsQueryModel businessGreetingContentsQueryModel = (BusinessGreetingContentsQueryModel) obj;
            if (businessGreetingContentsQueryModel == null || businessGreetingContentsQueryModel.m8976j() == null || StringUtil.c(businessGreetingContentsQueryModel.m8976j().m8967j())) {
                return new BusinessGreetingItem(false, null);
            }
            return new BusinessGreetingItem(businessGreetingContentsQueryModel.m8976j().m8966a(), businessGreetingContentsQueryModel.m8976j().m8967j());
        }
    }

    /* compiled from: netcheck_state */
    public class ProcessedMessageGraphQLCallInput extends GraphQlCallInput {
    }

    @Inject
    public BusinessGreetingContentsLoader(GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider) {
        this.f8765a = graphQLQueryExecutor;
        this.f8766b = provider;
    }

    public final ListenableFuture<BusinessGreetingItem> m9024a(String str) {
        GraphQlQueryString businessGreetingContentsQueryString = new BusinessGreetingContentsQueryString();
        ProcessedMessageGraphQLCallInput processedMessageGraphQLCallInput = new ProcessedMessageGraphQLCallInput();
        processedMessageGraphQLCallInput.a("user_id", (String) this.f8766b.get());
        businessGreetingContentsQueryString.a("business_id", str).a("processed_message_params", processedMessageGraphQLCallInput);
        return Futures.a(GraphQLQueryExecutor.a(this.f8765a.a(GraphQLRequest.a(businessGreetingContentsQueryString))), new C10031(this), DirectExecutor.INSTANCE);
    }
}
