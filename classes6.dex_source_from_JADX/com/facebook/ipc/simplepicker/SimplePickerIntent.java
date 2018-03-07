package com.facebook.ipc.simplepicker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import javax.annotation.Nullable;

/* compiled from: latLngBounds */
public class SimplePickerIntent extends Intent {
    public static Intent m18370a(Context context, Builder builder) {
        return m18371a(context, builder, null);
    }

    public static Intent m18371a(Context context, Builder builder, @Nullable String str) {
        Intent simplePickerIntent = new SimplePickerIntent();
        simplePickerIntent.setComponent(new ComponentName(context, "com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity"));
        simplePickerIntent.putExtra("extra_simple_picker_launcher_settings", builder.m18390r());
        if (str != null) {
            simplePickerIntent.putExtra("extra_simple_picker_launcher_waterfall_id", str);
        }
        return simplePickerIntent;
    }
}
