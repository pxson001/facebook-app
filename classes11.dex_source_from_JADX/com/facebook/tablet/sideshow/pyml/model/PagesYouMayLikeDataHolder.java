package com.facebook.tablet.sideshow.pyml.model;

import android.text.TextUtils;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowModels.FetchPagesYouMayLikeSideshowModel;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowModels.FetchPagesYouMayLikeSideshowModel.PagesYouMayLikeModel.NodesModel;
import com.facebook.tablet.sideshow.pyml.ui.PagesYouMayLikeListAdapter.C06551;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: on started */
public class PagesYouMayLikeDataHolder {
    public FetchPagesYouMayLikeSideshowDataRequest f4837a;
    public final Set<Listener> f4838b = new HashSet();
    public ImmutableList<PagesYouMayLikeRow> f4839c = RegularImmutableList.a;
    public final Map<String, Integer> f4840d = new HashMap();

    /* compiled from: on started */
    public class C06541 implements FutureCallback<GraphQLResult<FetchPagesYouMayLikeSideshowModel>> {
        final /* synthetic */ 1 f4835a;
        final /* synthetic */ PagesYouMayLikeDataHolder f4836b;

        public C06541(PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder, 1 1) {
            this.f4836b = pagesYouMayLikeDataHolder;
            this.f4835a = 1;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                onFailure(null);
                return;
            }
            FetchPagesYouMayLikeSideshowModel fetchPagesYouMayLikeSideshowModel = (FetchPagesYouMayLikeSideshowModel) graphQLResult.e;
            if (fetchPagesYouMayLikeSideshowModel == null || fetchPagesYouMayLikeSideshowModel.m6041a() == null) {
                onFailure(null);
                return;
            }
            PagesYouMayLikeDataHolder.m6053a(this.f4836b, fetchPagesYouMayLikeSideshowModel.m6041a().m6037a());
            if (this.f4835a != null) {
                this.f4835a.a(this.f4836b.f4839c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f4835a != null) {
                this.f4835a.a(this.f4836b.f4839c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS_NO_DATA);
            }
        }
    }

    public PagesYouMayLikeDataHolder(FetchPagesYouMayLikeSideshowDataRequest fetchPagesYouMayLikeSideshowDataRequest) {
        this.f4837a = fetchPagesYouMayLikeSideshowDataRequest;
    }

    public static void m6053a(PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder, ImmutableList immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            NodesModel nodesModel = (NodesModel) immutableList.get(i);
            if (nodesModel != null && nodesModel.m6026j()) {
                Object obj;
                if (TextUtils.isEmpty(nodesModel.m6031o()) || nodesModel.m6029m() == null || nodesModel.m6033q() == null || nodesModel.m6032p() == null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    if (i2 >= 6) {
                        break;
                    }
                    builder.c(new PagesYouMayLikeRow(nodesModel.m6030n(), nodesModel.m6031o(), nodesModel.m6027k(), nodesModel.m6029m().m6006a(), nodesModel.m6033q().m6017a(), nodesModel.m6028l(), nodesModel.m6032p().m6009a()));
                    i3 = i2 + 1;
                    i++;
                    i2 = i3;
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        pagesYouMayLikeDataHolder.m6054b(builder.b());
    }

    private void m6054b(ImmutableList<PagesYouMayLikeRow> immutableList) {
        this.f4839c = immutableList;
        for (int i = 0; i < this.f4839c.size(); i++) {
            this.f4840d.put(((PagesYouMayLikeRow) this.f4839c.get(i)).f4841a, Integer.valueOf(i));
        }
        for (C06551 b : this.f4838b) {
            b.m6056b();
        }
    }

    public final int m6055a() {
        if (this.f4839c == null) {
            return 0;
        }
        return this.f4839c.size();
    }
}
