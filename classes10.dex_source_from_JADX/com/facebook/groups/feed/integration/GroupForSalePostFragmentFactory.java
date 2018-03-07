package com.facebook.groups.feed.integration;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.feed.ui.GroupsForSalePostsFragment;

/* compiled from: TimelineNonSelfFirstUnits */
public class GroupForSalePostFragmentFactory implements IFragmentFactory {
    public final Fragment m23116a(Intent intent) {
        GroupsForSalePostsFragment groupsForSalePostsFragment = new GroupsForSalePostsFragment();
        groupsForSalePostsFragment.g(intent.getExtras());
        return groupsForSalePostsFragment;
    }
}
