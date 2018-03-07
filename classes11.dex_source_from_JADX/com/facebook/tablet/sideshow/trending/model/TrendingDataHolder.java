package com.facebook.tablet.sideshow.trending.model;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLModels.FetchTrendingEntitiesSideshowDataModel;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLModels.FetchTrendingEntitiesSideshowDataModel.TrendingEntitiesModel.EdgesModel;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLModels.FetchTrendingEntitiesSideshowDataModel.TrendingEntitiesModel.EdgesModel.NodeModel;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataRequest;
import com.facebook.tablet.sideshow.trending.ui.TrendingSideshowListAdapter.C06621;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: objectType */
public class TrendingDataHolder {
    public FetchTrendingEntitiesSideshowDataRequest f4892a;
    public final Set<Listener> f4893b = new HashSet();
    public ImmutableList<TrendingRow> f4894c = RegularImmutableList.a;

    /* compiled from: objectType */
    public class C06611 implements FutureCallback<GraphQLResult<FetchTrendingEntitiesSideshowDataModel>> {
        final /* synthetic */ 1 f4890a;
        final /* synthetic */ TrendingDataHolder f4891b;

        public C06611(TrendingDataHolder trendingDataHolder, 1 1) {
            this.f4891b = trendingDataHolder;
            this.f4890a = 1;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                onFailure(null);
                return;
            }
            FetchTrendingEntitiesSideshowDataModel fetchTrendingEntitiesSideshowDataModel = (FetchTrendingEntitiesSideshowDataModel) graphQLResult.e;
            if (fetchTrendingEntitiesSideshowDataModel == null || fetchTrendingEntitiesSideshowDataModel.m6102a() == null) {
                onFailure(null);
                return;
            }
            TrendingDataHolder trendingDataHolder = this.f4891b;
            ImmutableList a = fetchTrendingEntitiesSideshowDataModel.m6102a().m6099a();
            int i = 0;
            List<NodeModel> arrayList = new ArrayList();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i2);
                if (edgesModel.m6095a() != null) {
                    arrayList.add(edgesModel.m6095a());
                }
            }
            Builder builder = ImmutableList.builder();
            for (NodeModel nodeModel : arrayList) {
                if (nodeModel != null) {
                    if (i >= 6) {
                        break;
                    }
                    builder.c(new TrendingRow(nodeModel.m6089j(), nodeModel.m6090k(), nodeModel.m6091l()));
                    i++;
                }
            }
            trendingDataHolder.f4894c = builder.b();
            for (C06621 b : trendingDataHolder.f4893b) {
                b.m6113b();
            }
            if (this.f4890a != null) {
                this.f4890a.a(this.f4891b.f4894c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f4890a != null) {
                this.f4890a.a(this.f4891b.f4894c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS_NO_DATA);
            }
        }
    }

    public TrendingDataHolder(FetchTrendingEntitiesSideshowDataRequest fetchTrendingEntitiesSideshowDataRequest) {
        this.f4892a = fetchTrendingEntitiesSideshowDataRequest;
    }

    public final int m6112a() {
        if (this.f4894c == null) {
            return 0;
        }
        return this.f4894c.size();
    }
}
