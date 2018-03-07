package com.facebook.localcontent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.localcontent.menus.PagePhotoMenuFragment;

/* compiled from: edeea1a5f168d381e62aea435570270d */
public class PagePhotoMenuFragmentFactory implements IFragmentFactory {
    public final Fragment m17405a(Intent intent) {
        PagePhotoMenuFragment pagePhotoMenuFragment = new PagePhotoMenuFragment();
        pagePhotoMenuFragment.g(intent.getExtras());
        return pagePhotoMenuFragment;
    }
}
