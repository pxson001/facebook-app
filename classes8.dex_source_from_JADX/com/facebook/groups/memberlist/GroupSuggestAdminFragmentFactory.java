package com.facebook.groups.memberlist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: extra_photo_set_fb_id_array */
public class GroupSuggestAdminFragmentFactory implements IFragmentFactory {
    public final Fragment m15921a(Intent intent) {
        GroupSuggestAdminMemberListFragment groupSuggestAdminMemberListFragment = new GroupSuggestAdminMemberListFragment();
        groupSuggestAdminMemberListFragment.g(intent.getExtras());
        return groupSuggestAdminMemberListFragment;
    }
}
