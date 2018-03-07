package com.facebook.groups.fb4a.addtogroups;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: x-iorg-test-keyword */
public class FB4AAddToGroupsFragmentFactory implements IFragmentFactory {
    public final Fragment m309a(Intent intent) {
        FB4AAddToGroupsFragment fB4AAddToGroupsFragment = new FB4AAddToGroupsFragment();
        fB4AAddToGroupsFragment.g(intent.getExtras());
        return fB4AAddToGroupsFragment;
    }
}
