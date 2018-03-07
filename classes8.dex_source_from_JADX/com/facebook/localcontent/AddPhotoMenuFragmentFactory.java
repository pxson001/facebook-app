package com.facebook.localcontent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.localcontent.menus.AddPhotoMenuFragment;

/* compiled from: edit */
public class AddPhotoMenuFragmentFactory implements IFragmentFactory {
    public final Fragment m17402a(Intent intent) {
        AddPhotoMenuFragment addPhotoMenuFragment = new AddPhotoMenuFragment();
        addPhotoMenuFragment.g(intent.getExtras());
        return addPhotoMenuFragment;
    }
}
