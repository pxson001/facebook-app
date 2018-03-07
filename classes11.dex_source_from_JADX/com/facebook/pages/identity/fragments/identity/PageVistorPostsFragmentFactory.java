package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.identity.timeline.PageIdentityPostsByOthersFragment;

/* compiled from: pages_browser_like_succesful */
public class PageVistorPostsFragmentFactory implements IFragmentFactory {
    public final Fragment m4909a(Intent intent) {
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
        String stringExtra = intent.getStringExtra("extra_page_name");
        PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment = new PageIdentityPostsByOthersFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", longExtra);
        bundle.putString("extra_page_name", stringExtra);
        pageIdentityPostsByOthersFragment.g(bundle);
        return pageIdentityPostsByOthersFragment;
    }
}
