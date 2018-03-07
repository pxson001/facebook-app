package com.facebook.timeline;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.timeline.coverphoto.UserCoverPhotoRepositionFragment;
import com.google.common.base.Preconditions;

/* compiled from: groupthreadfbid */
public class CoverPhotoFragmentFactory implements IFragmentFactory {
    public final Fragment m10249a(Intent intent) {
        boolean z = false;
        long longExtra = intent.getLongExtra("cover_photo_fbid", 0);
        String stringExtra = intent.getStringExtra("cover_photo_uri");
        long longExtra2 = intent.getLongExtra("profile_id", 0);
        boolean booleanExtra = intent.getBooleanExtra("cover_photo_refresh_header", false);
        if (longExtra2 != 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return UserCoverPhotoRepositionFragment.m10483a(longExtra, stringExtra, longExtra2, booleanExtra);
    }
}
