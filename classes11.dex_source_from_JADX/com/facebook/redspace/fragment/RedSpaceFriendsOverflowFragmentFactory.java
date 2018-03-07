package com.facebook.redspace.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Payment method has a null or empty label */
public class RedSpaceFriendsOverflowFragmentFactory implements IFragmentFactory {
    public final Fragment m12372a(Intent intent) {
        Bundle extras = intent.getExtras();
        RedSpaceOverflowFriendsFragment redSpaceOverflowFriendsFragment = new RedSpaceOverflowFriendsFragment();
        redSpaceOverflowFriendsFragment.g(extras);
        return redSpaceOverflowFriendsFragment;
    }
}
