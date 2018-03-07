package com.facebook.groups.events;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: UNKNOWN_RESPONSE */
public class GroupsEventsFragmentFactory implements IFragmentFactory {
    public final Fragment m22980a(Intent intent) {
        GroupEventsTabFragment groupEventsTabFragment = new GroupEventsTabFragment();
        groupEventsTabFragment.g(intent.getExtras());
        return groupEventsTabFragment;
    }
}
