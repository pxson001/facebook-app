package com.facebook.friendlist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.fragment.FriendPageFragment;
import com.google.common.base.Preconditions;

/* compiled from: adPositionY */
public class FriendListFragmentFactory implements IFragmentFactory {
    public final Fragment m20571a(Intent intent) {
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
        String stringExtra = intent.getStringExtra("profile_name");
        String stringExtra2 = intent.getStringExtra("first_name");
        String stringExtra3 = intent.getStringExtra("friendship_status");
        String stringExtra4 = intent.getStringExtra("subscribe_status");
        FriendListType valueOf = FriendListType.valueOf(intent.getStringExtra("target_tab_name"));
        String stringExtra5 = intent.getStringExtra("source_ref");
        Preconditions.checkArgument(longExtra > 0, "Missing profile ID!");
        return FriendPageFragment.m20606a(Long.toString(longExtra), stringExtra, stringExtra2, stringExtra3, stringExtra4, valueOf, stringExtra5);
    }
}
