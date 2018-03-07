package com.facebook.groups.editsettings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.editsettings.fragment.GroupEditNameDescriptionFragment;

/* compiled from: Unknown composer id  */
public class GroupEditNameDescFragmentFactory implements IFragmentFactory {
    public final Fragment m22523a(Intent intent) {
        GroupEditNameDescriptionFragment groupEditNameDescriptionFragment = new GroupEditNameDescriptionFragment();
        groupEditNameDescriptionFragment.g(intent.getExtras());
        return groupEditNameDescriptionFragment;
    }
}
