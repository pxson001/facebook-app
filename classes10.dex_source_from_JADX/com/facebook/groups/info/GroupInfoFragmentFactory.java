package com.facebook.groups.info;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: ThreadItemView.onLayout */
public class GroupInfoFragmentFactory implements IFragmentFactory {
    public final Fragment m23664a(Intent intent) {
        GroupInfoFragment groupInfoFragment = new GroupInfoFragment();
        groupInfoFragment.g(intent.getExtras());
        return groupInfoFragment;
    }
}
