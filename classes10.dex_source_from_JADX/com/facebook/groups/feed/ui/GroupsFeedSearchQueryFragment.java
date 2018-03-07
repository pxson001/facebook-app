package com.facebook.groups.feed.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.groups.feed.data.GroupsGraphSearchHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerStatus;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.inject.FbInjector;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.search.util.GraphSearchConfig;
import javax.inject.Inject;

/* compiled from: TimelineGetNotifiedButtonClick */
public abstract class GroupsFeedSearchQueryFragment extends BaseFeedFragment implements GraphSearchQueryProvider {
    private FetchGroupInformationModel f21997a;
    @Inject
    public GraphSearchConfig ap;
    private String f21998b;

    public static void m23125a(Object obj, Context context) {
        ((GroupsFeedSearchQueryFragment) obj).ap = GraphSearchConfig.a(FbInjector.get(context));
    }

    public void mo973c(Bundle bundle) {
        super.c(bundle);
        this.f21997a = (FetchGroupInformationModel) FlatBufferModelHelper.a(this.s, "group_feed_model");
        this.f21998b = (String) this.s.get("group_feed_id");
        Class cls = GroupsFeedSearchQueryFragment.class;
        m23125a(this, getContext());
    }

    public final GraphSearchQuery m23127q() {
        return GroupsGraphSearchHelper.b(this.f21997a, av(), false, this.ap);
    }

    public final String av() {
        if (this.f21998b != null) {
            return this.f21998b;
        }
        return (this.f21997a == null || this.f21997a.gW_() == null) ? null : this.f21997a.gW_();
    }

    public final GroupViewerStatus aw() {
        return this.f21997a != null ? this.f21997a : null;
    }
}
