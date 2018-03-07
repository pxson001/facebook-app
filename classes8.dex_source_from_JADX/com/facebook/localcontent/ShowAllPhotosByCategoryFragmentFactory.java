package com.facebook.localcontent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.localcontent.photos.PhotosByCategoryTabPagerFragment;

/* compiled from: ed16356e5c74e92a83c9daa40cf19eac */
public class ShowAllPhotosByCategoryFragmentFactory implements IFragmentFactory {
    public final Fragment m17406a(Intent intent) {
        PhotosByCategoryTabPagerFragment photosByCategoryTabPagerFragment = new PhotosByCategoryTabPagerFragment();
        photosByCategoryTabPagerFragment.g(intent.getExtras());
        return photosByCategoryTabPagerFragment;
    }
}
