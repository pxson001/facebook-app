package com.facebook.groups.memberlist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: extra_photo_tab_mode_params */
public class GroupMembershipFragmentFactory implements IFragmentFactory {
    public final Fragment m15920a(Intent intent) {
        MembershipTabsFragment membershipTabsFragment = new MembershipTabsFragment();
        membershipTabsFragment.g(intent.getExtras());
        return membershipTabsFragment;
    }
}
