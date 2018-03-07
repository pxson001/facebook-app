package com.facebook.groups.events;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.facebook.groups.adapter.AbstractFragmentHolderFragmentPagerAdapter;

/* compiled from: UPC_A */
public class GroupEventsPagerAdapter extends AbstractFragmentHolderFragmentPagerAdapter {
    private Resources f21853a;
    private String f21854b;

    public GroupEventsPagerAdapter(FragmentManager fragmentManager, String str, Resources resources) {
        super(fragmentManager);
        this.f21854b = str;
        this.f21853a = resources;
    }

    public final Fragment m22945a(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("group_feed_id", this.f21854b);
        Fragment groupUpcomingEventsFragment;
        switch (i) {
            case 0:
                groupUpcomingEventsFragment = new GroupUpcomingEventsFragment();
                groupUpcomingEventsFragment.g(bundle);
                return groupUpcomingEventsFragment;
            case 1:
                groupUpcomingEventsFragment = new GroupPastEventsFragment();
                groupUpcomingEventsFragment.g(bundle);
                return groupUpcomingEventsFragment;
            default:
                return null;
        }
    }

    public final CharSequence J_(int i) {
        switch (i) {
            case 0:
                return this.f21853a.getString(2131242092);
            case 1:
                return this.f21853a.getString(2131242093);
            default:
                return "";
        }
    }

    public final int m22946b() {
        return 2;
    }
}
