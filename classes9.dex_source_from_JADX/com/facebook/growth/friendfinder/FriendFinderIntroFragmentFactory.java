package com.facebook.growth.friendfinder;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.ipc.katana.findfriends.CIFlow;

/* compiled from: pass */
public class FriendFinderIntroFragmentFactory implements IFragmentFactory {
    public final Fragment m7525a(Intent intent) {
        return FriendFinderIntroFragment.m7514a(CIFlow.FRIENDS_CENTER, CIFlow.FRIENDS_CENTER.value);
    }
}
