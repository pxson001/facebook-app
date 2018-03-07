package com.facebook.groups.react;

import android.app.Activity;
import com.facebook.feedback.ui.CommentPhotoPickerUtil;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.Callback;
import javax.inject.Inject;

/* compiled from: payment_expiry_year */
public class PhotoPickerLauncher {
    public static final String f7037a = PhotoPickerLauncher.class.getName();
    public final Activity f7038b;
    public final CommentPhotoPickerUtil f7039c;
    public Callback f7040d;

    @Inject
    public PhotoPickerLauncher(@Assisted Activity activity, CommentPhotoPickerUtil commentPhotoPickerUtil) {
        this.f7038b = activity;
        this.f7039c = commentPhotoPickerUtil;
    }
}
