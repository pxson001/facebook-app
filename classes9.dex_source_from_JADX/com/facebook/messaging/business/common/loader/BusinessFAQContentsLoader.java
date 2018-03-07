package com.facebook.messaging.business.common.loader;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessFAQContentsQueryModel;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsModels.BusinessFAQContentsQueryModel.CommercePageFaqContentsModel.ContentModel;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_connected */
public class BusinessFAQContentsLoader {
    public final ExecutorService f8762a;
    public final GraphQLQueryExecutor f8763b;

    /* compiled from: network_connected */
    public class C10021 implements Function<GraphQLResult<BusinessFAQContentsQueryModel>, ImmutableList<String>> {
        final /* synthetic */ BusinessFAQContentsLoader f8761a;

        public C10021(BusinessFAQContentsLoader businessFAQContentsLoader) {
            this.f8761a = businessFAQContentsLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((BusinessFAQContentsQueryModel) graphQLResult.e).m8959j() == null || ((BusinessFAQContentsQueryModel) graphQLResult.e).m8959j().m8949a() == null) {
                return null;
            }
            ImmutableList a = ((BusinessFAQContentsQueryModel) graphQLResult.e).m8959j().m8949a();
            Builder builder = new Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                ContentModel contentModel = (ContentModel) a.get(i);
                if (!Strings.isNullOrEmpty(contentModel.m8944a())) {
                    builder.c(contentModel.m8944a());
                }
            }
            return builder.b();
        }
    }

    @Inject
    public BusinessFAQContentsLoader(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f8762a = executorService;
        this.f8763b = graphQLQueryExecutor;
    }
}
