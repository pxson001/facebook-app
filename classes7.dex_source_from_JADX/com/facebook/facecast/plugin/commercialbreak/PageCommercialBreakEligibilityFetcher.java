package com.facebook.facecast.plugin.commercialbreak;

import com.facebook.facecast.protocol.FetchPageCommercialBreakEligibilityQueryModels.FetchPageCommercialBreakEligibilityQueryModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: byline */
public class PageCommercialBreakEligibilityFetcher {
    public static final String f18638a = PageCommercialBreakEligibilityFetcher.class.getSimpleName();
    public final GraphQLQueryExecutor f18639b;
    @Nullable
    public ListenableFuture<GraphQLResult<FetchPageCommercialBreakEligibilityQueryModel>> f18640c;

    /* compiled from: byline */
    public interface PageCommercialBreakEligibilityModelListener {
        void mo1389c(boolean z);
    }

    /* compiled from: byline */
    public class C16091 implements FutureCallback<GraphQLResult<FetchPageCommercialBreakEligibilityQueryModel>> {
        final /* synthetic */ PageCommercialBreakEligibilityModelListener f18636a;
        final /* synthetic */ PageCommercialBreakEligibilityFetcher f18637b;

        public void onFailure(Throwable th) {
            String str = PageCommercialBreakEligibilityFetcher.f18638a;
            this.f18636a.mo1389c(false);
        }

        public C16091(PageCommercialBreakEligibilityFetcher pageCommercialBreakEligibilityFetcher, PageCommercialBreakEligibilityModelListener pageCommercialBreakEligibilityModelListener) {
            this.f18637b = pageCommercialBreakEligibilityFetcher;
            this.f18636a = pageCommercialBreakEligibilityModelListener;
        }

        public void onSuccess(@Nullable Object obj) {
            boolean z;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || !((FetchPageCommercialBreakEligibilityQueryModel) graphQLResult.e).m22399a()) {
                z = false;
            } else {
                z = true;
            }
            this.f18636a.mo1389c(z);
        }
    }

    public static PageCommercialBreakEligibilityFetcher m22229a(InjectorLike injectorLike) {
        return new PageCommercialBreakEligibilityFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public PageCommercialBreakEligibilityFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f18639b = graphQLQueryExecutor;
    }
}
