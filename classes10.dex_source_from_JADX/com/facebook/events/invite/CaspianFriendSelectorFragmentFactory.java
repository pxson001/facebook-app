package com.facebook.events.invite;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.android.camera.NEW_PICTURE */
public class CaspianFriendSelectorFragmentFactory implements IFragmentFactory {
    public final Fragment m17864a(Intent intent) {
        CaspianFriendSelectorFragment caspianFriendSelectorFragment = new CaspianFriendSelectorFragment();
        caspianFriendSelectorFragment.g(intent.getExtras());
        return caspianFriendSelectorFragment;
    }
}
