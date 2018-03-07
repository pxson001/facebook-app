package com.facebook.goodfriends.audience;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: fetch_mode */
public class AudienceFragmentFactory implements IFragmentFactory {
    public final Fragment m15038a(Intent intent) {
        AudienceFragment audienceFragment = new AudienceFragment();
        audienceFragment.g(intent.getExtras());
        return audienceFragment;
    }
}
