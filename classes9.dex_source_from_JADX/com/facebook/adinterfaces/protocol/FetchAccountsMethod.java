package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.FetchAccountsQueryModels.FetchAccountsQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WeakDependency */
public class FetchAccountsMethod {
    public final GraphQLQueryExecutor f22332a;

    /* compiled from: WeakDependency */
    public class C25421 implements Function<GraphQLResult<FetchAccountsQueryModel>, AdAccountsModel> {
        final /* synthetic */ FetchAccountsMethod f22331a;

        public C25421(FetchAccountsMethod fetchAccountsMethod) {
            this.f22331a = fetchAccountsMethod;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchAccountsQueryModel) graphQLResult.e).m24089a() == null) {
                return null;
            }
            return ((FetchAccountsQueryModel) graphQLResult.e).m24089a().m24084a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: WeakDependency */
    public enum Key {
        FETCH_AD_ACCOUNTS
    }

    @Inject
    public FetchAccountsMethod(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f22332a = graphQLQueryExecutor;
    }
}
