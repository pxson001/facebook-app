package com.facebook.friending.center.ui;

import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.EmptyConnectionState;
import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.friending.center.model.FriendsCenterListItemModel.Builder;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel.MutualFriendsModel;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;

/* compiled from: add_person */
public class FriendsCenterConnectionAdapter extends FriendsCenterBaseAdapter {
    private ConnectionState<FriendsCenterDefaultNodeModel> f20171c = EmptyConnectionState.a;

    @Inject
    public FriendsCenterConnectionAdapter(FriendsCenterCommonBinder friendsCenterCommonBinder) {
        super(friendsCenterCommonBinder);
    }

    public final void m20484a(ConnectionState<FriendsCenterDefaultNodeModel> connectionState) {
        this.f20171c = connectionState;
        AdapterDetour.a(this, 45249364);
    }

    public int getCount() {
        int d = this.f20171c.d();
        int i = (!this.f20124a || d <= 0) ? 0 : 1;
        return i + d;
    }

    public final FriendsCenterListItemModel mo900a(int i) {
        String str = null;
        Object obj = (this.f20124a && i == getCount() - 1) ? 1 : null;
        if (obj != null) {
            return null;
        }
        int a;
        FriendsCenterDefaultNodeModel friendsCenterDefaultNodeModel = (FriendsCenterDefaultNodeModel) this.f20171c.a(i);
        long parseLong = Long.parseLong(friendsCenterDefaultNodeModel.m20200k());
        DefaultImageFieldsModel n = friendsCenterDefaultNodeModel.m20203n();
        MutualFriendsModel l = friendsCenterDefaultNodeModel.m20201l();
        Builder builder = new Builder();
        builder.f19993a = parseLong;
        Builder builder2 = builder;
        if (n != null) {
            str = n.b();
        }
        builder2.f19994b = str;
        Builder builder3 = builder2;
        builder3.f19995c = friendsCenterDefaultNodeModel.m20202m();
        Builder builder4 = builder3;
        if (l != null) {
            a = l.m20188a();
        } else {
            a = 0;
        }
        builder4.f19996d = a;
        builder3 = builder4;
        builder3.f19997e = FriendingLocation.FRIENDS_CENTER_FRIENDS;
        builder3 = builder3;
        builder3.f19998f = friendsCenterDefaultNodeModel.m20199j();
        return builder3.mo892b();
    }

    protected final int mo899a(long j) {
        int i = 0;
        int d = this.f20171c != null ? this.f20171c.d() : 0;
        while (i < d) {
            if (Long.parseLong(((FriendsCenterDefaultNodeModel) this.f20171c.a(i)).m20200k()) == j) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
