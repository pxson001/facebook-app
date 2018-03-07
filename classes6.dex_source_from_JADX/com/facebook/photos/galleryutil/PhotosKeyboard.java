package com.facebook.photos.galleryutil;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

/* compiled from: hierarchy_result_tapped */
public class PhotosKeyboard {
    public static void m20356a(Window window) {
        window.setSoftInputMode(32);
    }

    public static void m20355a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
