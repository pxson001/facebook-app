package com.facebook.groups.editsettings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.editsettings.fragment.GroupEditPurposeFragment;

/* compiled from: Unknown View Type */
public class GroupEditPurposeFragmentFactory implements IFragmentFactory {
    public final Fragment m22525a(Intent intent) {
        GroupEditPurposeFragment groupEditPurposeFragment = new GroupEditPurposeFragment();
        groupEditPurposeFragment.g(intent.getExtras());
        return groupEditPurposeFragment;
    }
}
