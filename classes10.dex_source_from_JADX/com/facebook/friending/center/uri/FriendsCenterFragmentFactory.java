package com.facebook.friending.center.uri;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.friending.center.FriendsCenterHomeFragment;

/* compiled from: add_members_to_group */
public class FriendsCenterFragmentFactory implements IFragmentFactory {
    public final Fragment m20489a(Intent intent) {
        FriendsCenterHomeFragment friendsCenterHomeFragment = new FriendsCenterHomeFragment();
        friendsCenterHomeFragment.g(intent.getExtras());
        return friendsCenterHomeFragment;
    }
}
