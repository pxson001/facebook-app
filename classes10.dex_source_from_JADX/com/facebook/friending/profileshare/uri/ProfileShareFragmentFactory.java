package com.facebook.friending.profileshare.uri;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.friending.profileshare.ProfileShareImmersiveFragment;

/* compiled from: ad_height */
public class ProfileShareFragmentFactory implements IFragmentFactory {
    public final Fragment m20567a(Intent intent) {
        return new ProfileShareImmersiveFragment();
    }
}
