package com.facebook.ipc.slideshow;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* compiled from: unhandled url image attribute =  */
public class SlideshowEditIntentCreator {
    public static Intent m1400a(Context context, SlideshowEditConfiguration slideshowEditConfiguration) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, "com.facebook.slideshow.SlideshowEditActivity"));
        intent.putExtra("extra_slideshow_configuration", slideshowEditConfiguration);
        return intent;
    }
}
