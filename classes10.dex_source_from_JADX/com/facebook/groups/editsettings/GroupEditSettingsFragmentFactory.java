package com.facebook.groups.editsettings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.editsettings.fragment.GroupEditSettingsFragment;

/* compiled from: Unknown DeltaJoinableModeHandler joinable mode */
public class GroupEditSettingsFragmentFactory implements IFragmentFactory {
    public final Fragment m22544a(Intent intent) {
        GroupEditSettingsFragment groupEditSettingsFragment = new GroupEditSettingsFragment();
        groupEditSettingsFragment.g(intent.getExtras());
        return groupEditSettingsFragment;
    }
}
