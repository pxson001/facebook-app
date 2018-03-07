package com.facebook.friendsnearby.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel.RequestableFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel.RequestableFieldsModel.RequestableFieldsEdgesModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel.RequestableFieldsModel.RequestableFieldsEdgesModel.RequestableFieldsEdgesNodeModel;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: a5985aebd32600a9b66364c114347454 */
public class FriendsNearbyInviteRow implements FriendsNearbyRow {
    private final String f20467a;
    private final String f20468b;
    private final String f20469c;
    public final String f20470d;
    public InviteState f20471e;

    /* compiled from: a5985aebd32600a9b66364c114347454 */
    public enum InviteState {
        NOT_INVITED,
        UNINVITING,
        INVITING,
        INVITED
    }

    @Nullable
    public static FriendsNearbyInviteRow m20843a(NodeModel nodeModel, String str) {
        String str2 = null;
        if (nodeModel == null) {
            return null;
        }
        RequestableFieldsModel n = nodeModel.m21487n();
        if (n == null) {
            return null;
        }
        ImmutableList a = n.m21473a();
        if (a.isEmpty()) {
            return null;
        }
        RequestableFieldsEdgesNodeModel a2 = ((RequestableFieldsEdgesModel) a.get(0)).m21468a();
        if (a2 == null) {
            return null;
        }
        GraphQLInfoRequestFieldStatus a3 = a2.m21464a();
        if (a3 == null) {
            return null;
        }
        InviteState inviteState;
        if (a3 == GraphQLInfoRequestFieldStatus.REQUESTABLE) {
            inviteState = InviteState.NOT_INVITED;
        } else if (a3 != GraphQLInfoRequestFieldStatus.REQUESTED) {
            return null;
        } else {
            inviteState = InviteState.INVITED;
        }
        if (nodeModel.m21483j() == null) {
            return null;
        }
        if (nodeModel.m21486m() != null) {
            str2 = nodeModel.m21486m().b();
        }
        return new FriendsNearbyInviteRow(nodeModel.m21483j(), str2, nodeModel.m21484k(), inviteState, str);
    }

    private FriendsNearbyInviteRow(String str, String str2, String str3, InviteState inviteState, String str4) {
        this.f20467a = str;
        this.f20468b = str2;
        this.f20470d = str3;
        this.f20471e = inviteState;
        this.f20469c = str4;
    }

    public final String mo908a() {
        return this.f20467a;
    }

    @Nullable
    public final Uri mo911b() {
        if (this.f20468b == null) {
            return null;
        }
        return Uri.parse(this.f20468b);
    }

    @Nullable
    public final String mo909a(Context context) {
        switch (this.f20471e) {
            case NOT_INVITED:
                return "";
            case UNINVITING:
                return context.getString(2131242011);
            case INVITING:
                return context.getString(2131242010);
            case INVITED:
                return context.getString(2131242012);
            default:
                throw new IllegalStateException("Unknown invite state: " + this.f20471e);
        }
    }

    @Nullable
    public final String mo915d() {
        return null;
    }

    public final String mo916e() {
        return "invite";
    }

    public final boolean mo917f() {
        switch (this.f20471e) {
            case NOT_INVITED:
            case INVITED:
                return true;
            default:
                return false;
        }
    }

    public final boolean mo918g() {
        switch (this.f20471e) {
            case UNINVITING:
            case INVITING:
                return false;
            default:
                return true;
        }
    }

    public final Drawable mo907a(Resources resources) {
        return null;
    }

    public final Drawable mo910b(Resources resources) {
        switch (this.f20471e) {
            case NOT_INVITED:
                return resources.getDrawable(2130840448);
            default:
                return resources.getDrawable(2130840449);
        }
    }

    public final String mo912b(Context context) {
        switch (this.f20471e) {
            case NOT_INVITED:
                return context.getString(2131242025);
            default:
                return context.getString(2131230753);
        }
    }

    public final Theme mo919h() {
        switch (this.f20471e) {
            case NOT_INVITED:
                return Theme.SPECIAL;
            default:
                return Theme.GRAY;
        }
    }

    public final String mo914c(Context context) {
        return context.getString(2131241991, new Object[]{this.f20470d});
    }

    public final String mo920i() {
        return this.f20469c;
    }

    public final String mo913c() {
        return this.f20470d;
    }
}
