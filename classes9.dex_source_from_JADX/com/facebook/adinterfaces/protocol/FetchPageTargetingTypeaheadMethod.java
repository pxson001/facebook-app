package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadGraphQLModels.FetchPageTargetingTypeaheadInterestQueryModel;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadGraphQLModels.FetchPageTargetingTypeaheadLocationQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VideoTrimOperation_Exception */
public class FetchPageTargetingTypeaheadMethod {
    public final GraphQLQueryExecutor f22380a;

    /* compiled from: VideoTrimOperation_Exception */
    public class C25471 implements Function<GraphQLResult<FetchPageTargetingTypeaheadLocationQueryModel>, List<GeoLocationModel>> {
        final /* synthetic */ FetchPageTargetingTypeaheadMethod f22378a;

        public C25471(FetchPageTargetingTypeaheadMethod fetchPageTargetingTypeaheadMethod) {
            this.f22378a = fetchPageTargetingTypeaheadMethod;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchPageTargetingTypeaheadLocationQueryModel) graphQLResult.e).m24206a() == null || ((FetchPageTargetingTypeaheadLocationQueryModel) graphQLResult.e).m24206a().m24201a() == null) {
                return RegularImmutableList.a;
            }
            return ((FetchPageTargetingTypeaheadLocationQueryModel) graphQLResult.e).m24206a().m24201a().m24198a();
        }
    }

    /* compiled from: VideoTrimOperation_Exception */
    public class C25482 implements Function<GraphQLResult<FetchPageTargetingTypeaheadInterestQueryModel>, List<InterestModel>> {
        final /* synthetic */ FetchPageTargetingTypeaheadMethod f22379a;

        public C25482(FetchPageTargetingTypeaheadMethod fetchPageTargetingTypeaheadMethod) {
            this.f22379a = fetchPageTargetingTypeaheadMethod;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchPageTargetingTypeaheadInterestQueryModel) graphQLResult.e).m24191a() == null || ((FetchPageTargetingTypeaheadInterestQueryModel) graphQLResult.e).m24191a().m24186a() == null) {
                return RegularImmutableList.a;
            }
            return ((FetchPageTargetingTypeaheadInterestQueryModel) graphQLResult.e).m24191a().m24186a().m24183a();
        }
    }

    public static FetchPageTargetingTypeaheadMethod m24218b(InjectorLike injectorLike) {
        return new FetchPageTargetingTypeaheadMethod(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public FetchPageTargetingTypeaheadMethod(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f22380a = graphQLQueryExecutor;
    }
}
