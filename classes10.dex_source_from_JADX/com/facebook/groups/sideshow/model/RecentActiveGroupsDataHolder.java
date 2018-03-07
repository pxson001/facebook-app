package com.facebook.groups.sideshow.model;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLModels.FetchRecentActiveGroupsQueryModel;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLModels.FetchRecentActiveGroupsQueryModel.GroupsModel.NodesModel;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest;
import com.facebook.groups.sideshow.ui.RecentActiveGroupsListAdapter.C00611;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.C14851;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: wear */
public class RecentActiveGroupsDataHolder {
    public FetchRecentActiveGroupsRequest f346a;
    public final Set<Listener> f347b = new HashSet();
    public ImmutableList<RecentActiveGroupRow> f348c = RegularImmutableList.a;

    /* compiled from: wear */
    public class C00601 implements FutureCallback<GraphQLResult<FetchRecentActiveGroupsQueryModel>> {
        final /* synthetic */ C14851 f344a;
        final /* synthetic */ RecentActiveGroupsDataHolder f345b;

        public C00601(RecentActiveGroupsDataHolder recentActiveGroupsDataHolder, C14851 c14851) {
            this.f345b = recentActiveGroupsDataHolder;
            this.f344a = c14851;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                onFailure(null);
                return;
            }
            FetchRecentActiveGroupsQueryModel fetchRecentActiveGroupsQueryModel = (FetchRecentActiveGroupsQueryModel) graphQLResult.e;
            if (fetchRecentActiveGroupsQueryModel == null || fetchRecentActiveGroupsQueryModel.m457a() == null) {
                onFailure(null);
                return;
            }
            RecentActiveGroupsDataHolder.m475a(this.f345b, fetchRecentActiveGroupsQueryModel.m457a().m453a());
            if (this.f344a != null) {
                this.f344a.m10184a(this.f345b.f348c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f344a != null) {
                this.f344a.m10184a(this.f345b.f348c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS_NO_DATA);
            }
        }
    }

    public RecentActiveGroupsDataHolder(FetchRecentActiveGroupsRequest fetchRecentActiveGroupsRequest) {
        this.f346a = fetchRecentActiveGroupsRequest;
    }

    public static void m475a(RecentActiveGroupsDataHolder recentActiveGroupsDataHolder, ImmutableList immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) immutableList.get(i);
            if (nodesModel != null) {
                int a;
                if (nodesModel.m447k() != null) {
                    a = nodesModel.m447k().m435a();
                } else {
                    a = 0;
                }
                if (a != 0) {
                    String str = null;
                    if (!(nodesModel.m446j() == null || nodesModel.m446j().m431a() == null || nodesModel.m446j().m431a().m427a() == null)) {
                        str = nodesModel.m446j().m431a().m427a().m423a();
                    }
                    builder.c(new RecentActiveGroupRow(nodesModel.m448l(), nodesModel.m449m(), a, str));
                }
            }
        }
        recentActiveGroupsDataHolder.f348c = builder.b();
        for (C00611 b : recentActiveGroupsDataHolder.f347b) {
            b.m477b();
        }
    }

    public final int m476a() {
        if (this.f348c == null) {
            return 0;
        }
        return this.f348c.size();
    }
}
