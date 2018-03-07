package com.facebook.tablet.sideshow.ads.model;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.platformads.AppAdsInvalidator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAppAdStoriesSideFeedConnection;
import com.facebook.graphql.model.GraphQLAppAdStoriesSideFeedEdge;
import com.facebook.graphql.model.GraphQLSideFeedConnection;
import com.facebook.graphql.model.GraphQLSideFeedEdge;
import com.facebook.graphql.model.GraphQLSideFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.tablet.sideshow.ads.AdsSideshowUnit.C06325;
import com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest;
import com.facebook.tablet.sideshow.ads.util.AppAdsSideshowStoryAccessor;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.LoadResultCallback;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: onTextInput */
public class AppAdsSideshowDataHolder {
    public final FetchAppAdsSideshowDataRequest f4644a;
    private final AppAdsInvalidator f4645b;
    public final Set<Listener> f4646c = new HashSet();
    public ImmutableList<AppAdsSideshowRow> f4647d = RegularImmutableList.a;
    public int f4648e;
    public List<LoadResultCallback> f4649f;
    public boolean f4650g = false;
    public LoadResult f4651h = LoadResult.ERROR;

    /* compiled from: onTextInput */
    public class C06341 implements FutureCallback<GraphQLResult<GraphQLViewer>> {
        final /* synthetic */ AppAdsSideshowDataHolder f4643a;

        public C06341(AppAdsSideshowDataHolder appAdsSideshowDataHolder) {
            this.f4643a = appAdsSideshowDataHolder;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                onFailure(null);
                return;
            }
            GraphQLViewer graphQLViewer = (GraphQLViewer) graphQLResult.e;
            if (graphQLViewer == null) {
                onFailure(null);
                return;
            }
            GraphQLSideFeedConnection D = graphQLViewer.D();
            if (D == null) {
                onFailure(null);
                return;
            }
            GraphQLAppAdStoriesSideFeedConnection j;
            ImmutableList a = D.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLSideFeedUnit a2 = ((GraphQLSideFeedEdge) a.get(i)).a();
                if (a2 != null) {
                    j = a2.j();
                    if (j != null) {
                        break;
                    }
                }
            }
            j = null;
            GraphQLAppAdStoriesSideFeedConnection graphQLAppAdStoriesSideFeedConnection = j;
            if (graphQLAppAdStoriesSideFeedConnection == null) {
                onFailure(null);
                return;
            }
            LoadResult loadResult;
            this.f4643a.m5857a(graphQLAppAdStoriesSideFeedConnection.a());
            AppAdsSideshowDataHolder appAdsSideshowDataHolder = this.f4643a;
            if (this.f4643a.f4647d.isEmpty()) {
                loadResult = LoadResult.ERROR;
            } else {
                loadResult = LoadResult.SUCCESS;
            }
            appAdsSideshowDataHolder.f4651h = loadResult;
            this.f4643a.f4650g = true;
            this.f4643a.m5858c();
        }

        public void onFailure(Throwable th) {
            LoadResult loadResult;
            AppAdsSideshowDataHolder appAdsSideshowDataHolder = this.f4643a;
            if (this.f4643a.f4647d.isEmpty()) {
                loadResult = LoadResult.ERROR;
            } else {
                loadResult = LoadResult.SUCCESS_NO_DATA;
            }
            appAdsSideshowDataHolder.f4651h = loadResult;
            this.f4643a.m5858c();
        }
    }

    public AppAdsSideshowDataHolder(FetchAppAdsSideshowDataRequest fetchAppAdsSideshowDataRequest, AppAdsInvalidator appAdsInvalidator) {
        this.f4644a = fetchAppAdsSideshowDataRequest;
        this.f4645b = appAdsInvalidator;
        this.f4649f = new ArrayList();
    }

    public final void m5858c() {
        for (1 a : this.f4649f) {
            a.a(this.f4651h);
        }
    }

    public final void m5857a(ImmutableList<GraphQLAppAdStoriesSideFeedEdge> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStory a = ((GraphQLAppAdStoriesSideFeedEdge) immutableList.get(i)).a();
            FeedProps c = FeedProps.c(a);
            if (!(a == null || this.f4645b.a(AppAdsSideshowStoryAccessor.m5867g(a), TrackableFeedProps.a(c), a.getType()))) {
                builder.c(new AppAdsSideshowRow(FeedProps.c(a)));
            }
        }
        this.f4647d = builder.b();
        this.f4648e = this.f4647d.size();
        m5855h();
    }

    public final void m5856a(AppAdsSideshowRow appAdsSideshowRow) {
        if (this.f4647d != null) {
            Builder builder = ImmutableList.builder();
            for (int i = 0; i < this.f4647d.size(); i++) {
                if (!((AppAdsSideshowRow) this.f4647d.get(i)).equals(appAdsSideshowRow)) {
                    builder.c(this.f4647d.get(i));
                }
            }
            this.f4647d = builder.b();
            if (this.f4647d.size() == 0) {
                for (C06325 c06325 : this.f4646c) {
                    View view = c06325.f4624a;
                    SideshowExpandableListView sideshowExpandableListView = c06325.f4625b;
                    ((ViewGroup) sideshowExpandableListView.getParent()).removeView(sideshowExpandableListView);
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                return;
            }
            m5855h();
        }
    }

    public final int m5859e() {
        return this.f4647d.size();
    }

    private void m5855h() {
        for (C06325 b : this.f4646c) {
            b.m5839b();
        }
    }
}
