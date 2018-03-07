package com.facebook.common.util.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import com.facebook.common.util.ContextUtils;
import com.facebook.ui.drawable.TintedStateListDrawable;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: profile_wizard_upload_photo_from_camera_roll_tap */
public class ActionBarContextUtils {
    public static Drawable m6473a(Context context, int i, int i2, int i3) {
        Optional of;
        Context a = ContextUtils.a(context, 2130771986, i);
        int c = ContextUtils.c(a, 2130772051, i3);
        Drawable a2 = ContextCompat.a(a, i2);
        TypedValue typedValue = new TypedValue();
        if (a.getTheme().resolveAttribute(16842803, typedValue, true)) {
            of = Optional.of(Float.valueOf(typedValue.getFloat()));
        } else {
            of = Absent.INSTANCE;
        }
        return TintedStateListDrawable.a(a2, c, ((Float) of.or(Float.valueOf(0.5f))).floatValue());
    }
}
