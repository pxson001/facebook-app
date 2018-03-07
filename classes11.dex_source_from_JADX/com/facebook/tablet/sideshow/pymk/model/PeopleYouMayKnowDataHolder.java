package com.facebook.tablet.sideshow.pymk.model;

import android.text.TextUtils;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowDataRequest;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowModels.FetchPeopleYouMayKnowSideshowModel;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowModels.FetchPeopleYouMayKnowSideshowModel.PeopleYouMayKnowModel.NodesModel;
import com.facebook.tablet.sideshow.pymk.ui.PeopleYouMayKnowListAdapter.C06471;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: onEOM */
public class PeopleYouMayKnowDataHolder {
    public FetchPeopleYouMayKnowSideshowDataRequest f4768a;
    public final Set<Listener> f4769b = new HashSet();
    public ImmutableList<PeopleYouMayKnowRow> f4770c = RegularImmutableList.a;
    public final Map<String, Integer> f4771d = new HashMap();

    /* compiled from: onEOM */
    public class C06461 implements FutureCallback<GraphQLResult<FetchPeopleYouMayKnowSideshowModel>> {
        final /* synthetic */ 1 f4766a;
        final /* synthetic */ PeopleYouMayKnowDataHolder f4767b;

        public C06461(PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder, 1 1) {
            this.f4767b = peopleYouMayKnowDataHolder;
            this.f4766a = 1;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                onFailure(null);
                return;
            }
            FetchPeopleYouMayKnowSideshowModel fetchPeopleYouMayKnowSideshowModel = (FetchPeopleYouMayKnowSideshowModel) graphQLResult.e;
            if (fetchPeopleYouMayKnowSideshowModel == null || fetchPeopleYouMayKnowSideshowModel.m5959a() == null) {
                onFailure(null);
                return;
            }
            PeopleYouMayKnowDataHolder.m5971a(this.f4767b, fetchPeopleYouMayKnowSideshowModel.m5959a().m5955a());
            if (this.f4766a != null) {
                this.f4766a.a(this.f4767b.f4770c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f4766a != null) {
                this.f4766a.a(this.f4767b.f4770c.isEmpty() ? LoadResult.ERROR : LoadResult.SUCCESS_NO_DATA);
            }
        }
    }

    public PeopleYouMayKnowDataHolder(FetchPeopleYouMayKnowSideshowDataRequest fetchPeopleYouMayKnowSideshowDataRequest) {
        this.f4768a = fetchPeopleYouMayKnowSideshowDataRequest;
    }

    public static void m5971a(PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder, ImmutableList immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            NodesModel nodesModel = (NodesModel) immutableList.get(i);
            if (nodesModel != null) {
                Object obj;
                if (TextUtils.isEmpty(nodesModel.m5950n()) || nodesModel.m5951o() == null || nodesModel.m5949m() == null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    if (nodesModel.m5947k() == GraphQLFriendshipStatus.CAN_REQUEST) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        if (i2 >= 6) {
                            break;
                        }
                        String str;
                        if (nodesModel.m5946j() == null) {
                            str = null;
                        } else {
                            str = nodesModel.m5946j().m5926a();
                        }
                        builder.c(new PeopleYouMayKnowRow(nodesModel.m5948l(), nodesModel.m5950n(), str, nodesModel.m5951o().m5938a(), nodesModel.m5949m().m5930a(), nodesModel.m5947k()));
                        i3 = i2 + 1;
                        i++;
                        i2 = i3;
                    }
                }
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        peopleYouMayKnowDataHolder.m5972b(builder.b());
    }

    private void m5972b(ImmutableList<PeopleYouMayKnowRow> immutableList) {
        this.f4770c = immutableList;
        for (int i = 0; i < this.f4770c.size(); i++) {
            this.f4771d.put(((PeopleYouMayKnowRow) this.f4770c.get(i)).f4772a, Integer.valueOf(i));
        }
        for (C06471 b : this.f4769b) {
            b.m5974b();
        }
    }

    public final int m5973a() {
        if (this.f4770c == null) {
            return 0;
        }
        return this.f4770c.size();
    }
}
