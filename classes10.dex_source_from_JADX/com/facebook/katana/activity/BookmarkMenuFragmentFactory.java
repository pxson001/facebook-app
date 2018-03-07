package com.facebook.katana.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.katana.ui.bookmark.BookmarkMenuFragment;

/* compiled from: SECONDARY_NAVIGATION */
public class BookmarkMenuFragmentFactory implements IFragmentFactory {
    public final Fragment m25498a(Intent intent) {
        return new BookmarkMenuFragment();
    }
}
