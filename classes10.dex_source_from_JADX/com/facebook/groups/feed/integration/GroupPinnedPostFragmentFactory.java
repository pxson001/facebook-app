package com.facebook.groups.feed.integration;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.feed.ui.GroupsPinnedPostsFragment;

/* compiled from: TimelineHeaderCachedDataRead */
public class GroupPinnedPostFragmentFactory implements IFragmentFactory {
    public final Fragment m23118a(Intent intent) {
        GroupsPinnedPostsFragment groupsPinnedPostsFragment = new GroupsPinnedPostsFragment();
        groupsPinnedPostsFragment.g(intent.getExtras());
        return groupsPinnedPostsFragment;
    }
}
