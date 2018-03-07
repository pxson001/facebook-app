package com.facebook.groups.settings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: THREAD_VIEW_INVITE_BUTTON */
public class GroupSubscriptionFragmentFactory implements IFragmentFactory {
    public final Fragment m24455a(Intent intent) {
        GroupSubscriptionFragment groupSubscriptionFragment = new GroupSubscriptionFragment();
        groupSubscriptionFragment.g(intent.getExtras());
        return groupSubscriptionFragment;
    }
}
