package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.coverphotoreposition.PagesCoverPhotoRepositionFragment;
import com.google.common.base.Preconditions;

/* compiled from: pages_multi_locations_map */
public class PageManagerCoverPhotoFragmentFactory implements IFragmentFactory {
    public final Fragment m4901a(Intent intent) {
        boolean z = true;
        long longExtra = intent.getLongExtra("cover_photo_fbid", 0);
        String stringExtra = intent.getStringExtra("cover_photo_uri");
        long longExtra2 = intent.getLongExtra("profile_id", 0);
        if (longExtra != 0) {
            if (longExtra2 == 0) {
                z = false;
            }
            Preconditions.checkState(z);
            return PagesCoverPhotoRepositionFragment.m2204a(longExtra, stringExtra, longExtra2);
        }
        if (longExtra2 == 0) {
            z = false;
        }
        Preconditions.checkState(z);
        return PagesCoverPhotoRepositionFragment.m2204a(0, stringExtra, longExtra2);
    }
}
