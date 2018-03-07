package com.facebook.ipc.editgallery;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* compiled from: leftPercentage */
public class EditGalleryIntentCreator {
    public static Intent m18334a(Context context, String str, EditGalleryLaunchConfiguration editGalleryLaunchConfiguration) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, "com.facebook.photos.editgallery.EditGalleryActivity"));
        intent.putExtra("extra_edit_gallery_launch_settings", editGalleryLaunchConfiguration);
        intent.putExtra("extra_edit_gallery_entry_point_name", str);
        return intent;
    }
}
