package com.facebook.feed.awesomizer.ui;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;

/* compiled from: handle_composer_publish */
public class AwesomizerProfileViewBinder {
    public static void m13877a(AwesomizerGridItemView awesomizerGridItemView, String str, String str2, int i, CallerContext callerContext) {
        awesomizerGridItemView.setAvatarNameViewText(str);
        if (str2 == null && i == 69076575) {
            awesomizerGridItemView.setAvatarImageViewDrawable(2130837743);
        } else if (str2 == null && i == 2479791) {
            awesomizerGridItemView.setAvatarImageViewDrawable(2130843309);
        } else {
            awesomizerGridItemView.m13850a(Uri.parse(str2), callerContext);
        }
    }
}
