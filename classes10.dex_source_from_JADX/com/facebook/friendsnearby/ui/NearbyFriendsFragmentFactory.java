package com.facebook.friendsnearby.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: WITH_OLDER_AND_NEW_ROWS */
public class NearbyFriendsFragmentFactory implements IFragmentFactory {
    public final Fragment m21990a(Intent intent) {
        FriendsNearbyFragment friendsNearbyFragment = new FriendsNearbyFragment();
        friendsNearbyFragment.g(intent.getExtras());
        return friendsNearbyFragment;
    }
}
