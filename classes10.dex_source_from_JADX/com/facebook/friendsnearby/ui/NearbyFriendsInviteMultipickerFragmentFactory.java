package com.facebook.friendsnearby.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: WITH_ARTISTS */
public class NearbyFriendsInviteMultipickerFragmentFactory implements IFragmentFactory {
    public final Fragment m21991a(Intent intent) {
        FriendsNearbyInviteMultipickerFragment friendsNearbyInviteMultipickerFragment = new FriendsNearbyInviteMultipickerFragment();
        friendsNearbyInviteMultipickerFragment.g(intent.getExtras());
        return friendsNearbyInviteMultipickerFragment;
    }
}
