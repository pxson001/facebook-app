package com.facebook.groups.feed.integration;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.feed.ui.GroupsYourPostsFeedsFragment;

/* compiled from: TimelineHeader */
public class GroupYourPostFragmentFactory implements IFragmentFactory {
    public final Fragment m23119a(Intent intent) {
        GroupsYourPostsFeedsFragment groupsYourPostsFeedsFragment = new GroupsYourPostsFeedsFragment();
        groupsYourPostsFeedsFragment.g(intent.getExtras());
        return groupsYourPostsFeedsFragment;
    }
}
