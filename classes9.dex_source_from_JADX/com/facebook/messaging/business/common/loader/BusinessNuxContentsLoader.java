package com.facebook.messaging.business.common.loader;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragments.BusinessNuxContentsQueryString;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessNuxContentsQueryModel;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessNuxContentsQueryModel.CommercePageNuxContentsModel;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessNuxContentsQueryModel.CommercePageNuxContentsModel.NuxContentItemsModel;
import com.facebook.messaging.business.common.model.BusinessNuxItem;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: net_banking_info */
public class BusinessNuxContentsLoader {
    private final ExecutorService f8768a;
    private final GraphQLQueryExecutor f8769b;

    /* compiled from: net_banking_info */
    class C10041 implements Function<GraphQLResult<BusinessNuxContentsQueryModel>, BusinessNuxItem> {
        final /* synthetic */ BusinessNuxContentsLoader f8767a;

        C10041(BusinessNuxContentsLoader businessNuxContentsLoader) {
            this.f8767a = businessNuxContentsLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String str = null;
            if (graphQLResult == null || graphQLResult.e == null || ((BusinessNuxContentsQueryModel) graphQLResult.e).m9002j() == null || ((BusinessNuxContentsQueryModel) graphQLResult.e).m9002j().m8991a() == null || ((BusinessNuxContentsQueryModel) graphQLResult.e).m9002j().m8991a().isEmpty()) {
                return null;
            }
            CommercePageNuxContentsModel j = ((BusinessNuxContentsQueryModel) graphQLResult.e).m9002j();
            if (j.m8992j() != null) {
                str = j.m8992j().m8988a();
            }
            int size = j.m8991a().size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = ((NuxContentItemsModel) j.m8991a().get(i)).m8982a();
            }
            return new BusinessNuxItem(str, strArr);
        }
    }

    @Inject
    public BusinessNuxContentsLoader(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f8768a = executorService;
        this.f8769b = graphQLQueryExecutor;
    }

    public final ListenableFuture<BusinessNuxItem> m9025a(String str) {
        GraphQlQueryString businessNuxContentsQueryString = new BusinessNuxContentsQueryString();
        businessNuxContentsQueryString.a("business_id", str);
        GraphQLRequest a = GraphQLRequest.a(businessNuxContentsQueryString).a(GraphQLCachePolicy.a).a(86400);
        a.f = CallerContext.a(getClass());
        return Futures.a(this.f8769b.a(a), new C10041(this), this.f8768a);
    }
}
