package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.fb4a.videohub.fragments.VideoHubPermalinkFragment;

/* compiled from: pages_browser_unlike_succesful */
public class PageVideoHubFragmentFactory implements IFragmentFactory {
    public final Fragment m4906a(Intent intent) {
        return VideoHubPermalinkFragment.m4082a(Long.parseLong(intent.getStringExtra("com.facebook.katana.profile.id")), false);
    }
}
