package com.facebook.groups.memberlist;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.graphql.enums.GraphQLGroupAdminType;

/* compiled from: extra_navigation_source */
public class MembershipPagerAdapter extends FragmentPagerAdapter {
    private Resources f14413a;
    public Bundle f14414b;
    private int f14415c;

    public MembershipPagerAdapter(FragmentManager fragmentManager, Bundle bundle, Resources resources) {
        super(fragmentManager);
        this.f14414b = bundle;
        this.f14413a = resources;
        GraphQLGroupAdminType fromString = GraphQLGroupAdminType.fromString(this.f14414b.getString("group_admin_type"));
        if (GraphQLGroupAdminType.ADMIN == fromString || GraphQLGroupAdminType.MODERATOR == fromString) {
            this.f14415c = 3;
        } else {
            this.f14415c = 2;
        }
    }

    public final Fragment m15953a(int i) {
        Fragment groupMemberListFragment;
        switch (i) {
            case 0:
                groupMemberListFragment = new GroupMemberListFragment();
                groupMemberListFragment.g(this.f14414b);
                return groupMemberListFragment;
            case 1:
                groupMemberListFragment = new GroupAdminListFragment();
                groupMemberListFragment.g(this.f14414b);
                return groupMemberListFragment;
            case 2:
                groupMemberListFragment = new GroupBlockedListFragment();
                groupMemberListFragment.g(this.f14414b);
                return groupMemberListFragment;
            default:
                return null;
        }
    }

    public final CharSequence J_(int i) {
        switch (i) {
            case 0:
                return this.f14413a.getString(2131239492);
            case 1:
                return this.f14413a.getString(2131239493);
            case 2:
                return this.f14413a.getString(2131239494);
            default:
                return "";
        }
    }

    public final int m15954b() {
        return this.f14415c;
    }
}
