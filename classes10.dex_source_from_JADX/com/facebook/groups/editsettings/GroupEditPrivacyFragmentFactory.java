package com.facebook.groups.editsettings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.editsettings.fragment.GroupEditPrivacyFragment;

/* compiled from: Unknown action button behavior for  */
public class GroupEditPrivacyFragmentFactory implements IFragmentFactory {
    public final Fragment m22524a(Intent intent) {
        GroupEditPrivacyFragment groupEditPrivacyFragment = new GroupEditPrivacyFragment();
        groupEditPrivacyFragment.g(intent.getExtras());
        return groupEditPrivacyFragment;
    }
}
