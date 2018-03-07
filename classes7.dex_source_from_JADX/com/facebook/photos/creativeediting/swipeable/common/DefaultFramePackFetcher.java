package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.creativeediting.model.FetchFramePacksGraphQL.FetchFramePacksQueryString;
import com.facebook.photos.creativeediting.model.FetchFramePacksGraphQLModels.FetchFramePacksQueryModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mItems */
public class DefaultFramePackFetcher implements FramePackProvider {
    private final GraphQLQueryExecutor f9718a;
    private final ExecutorService f9719b;
    private final QeAccessor f9720c;
    public final FrameAssetsLoader f9721d;

    /* compiled from: mItems */
    class C08001 implements Function<GraphQLResult<FetchFramePacksQueryModel>, ImmutableList<FramePack>> {
        final /* synthetic */ DefaultFramePackFetcher f9717a;

        C08001(DefaultFramePackFetcher defaultFramePackFetcher) {
            this.f9717a = defaultFramePackFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchFramePacksQueryModel) graphQLResult.e).a() == null) {
                return RegularImmutableList.a;
            }
            ImmutableList a = ((FetchFramePacksQueryModel) graphQLResult.e).a().a();
            Builder builder = new Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                FramePackModel framePackModel = (FramePackModel) a.get(i);
                if (SwipeableParamsHelper.m11710a(framePackModel.g(), framePackModel.b())) {
                    builder.c(framePackModel);
                } else {
                    ImmutableList c = framePackModel.c();
                    int size2 = c.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.f9717a.f9721d.m11671a((FrameModel) c.get(i2));
                    }
                }
            }
            return builder.b();
        }
    }

    @Inject
    public DefaultFramePackFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, QeAccessor qeAccessor, FrameAssetsLoader frameAssetsLoader) {
        this.f9718a = graphQLQueryExecutor;
        this.f9719b = executorService;
        this.f9720c = qeAccessor;
        this.f9721d = frameAssetsLoader;
    }

    public final ListenableFuture<ImmutableList<FramePack>> mo508a() {
        if (!this.f9720c.a(ExperimentsForCreativeEditingAbtestModule.e, false)) {
            return Futures.a(RegularImmutableList.a);
        }
        GraphQlQueryString fetchFramePacksQueryString = new FetchFramePacksQueryString();
        fetchFramePacksQueryString.a("frame_scale", GraphQlQueryDefaults.a());
        return Futures.a(this.f9718a.a(GraphQLRequest.a(fetchFramePacksQueryString).a(GraphQLCachePolicy.a).a(3600)), new C08001(this), this.f9719b);
    }
}
