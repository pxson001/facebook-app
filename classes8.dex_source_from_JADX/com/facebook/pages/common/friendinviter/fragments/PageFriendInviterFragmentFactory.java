package com.facebook.pages.common.friendinviter.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: cta_leadgen_view */
public class PageFriendInviterFragmentFactory implements IFragmentFactory {
    public final Fragment m19533a(Intent intent) {
        PageFriendInviterFragment pageFriendInviterFragment = new PageFriendInviterFragment();
        pageFriendInviterFragment.g(intent.getExtras());
        return pageFriendInviterFragment;
    }
}
