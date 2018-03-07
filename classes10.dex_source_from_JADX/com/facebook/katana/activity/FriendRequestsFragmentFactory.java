package com.facebook.katana.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.friending.jewel.FriendRequestsFragment;

/* compiled from: SDK_CAPABILITY */
public class FriendRequestsFragmentFactory implements IFragmentFactory {
    public final Fragment m25513a(Intent intent) {
        return new FriendRequestsFragment();
    }
}
