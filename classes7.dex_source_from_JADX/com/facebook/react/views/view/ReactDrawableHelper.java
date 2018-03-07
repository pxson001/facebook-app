package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;

/* compiled from: first_time_opened */
public class ReactDrawableHelper {
    private static final TypedValue f11942a = new TypedValue();

    public static Drawable m14202a(Context context, ReadableMap readableMap) {
        String string = readableMap.getString("type");
        if ("ThemeAttrAndroid".equals(string)) {
            Object string2 = readableMap.getString("attribute");
            SoftAssertions.m13549a(string2);
            int identifier = context.getResources().getIdentifier(string2, "attr", "android");
            if (identifier == 0) {
                throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " couldn't be found in the resource list");
            } else if (!context.getTheme().resolveAttribute(identifier, f11942a, true)) {
                throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " couldn't be resolved into a drawable");
            } else if (VERSION.SDK_INT >= 21) {
                return context.getResources().getDrawable(f11942a.resourceId, context.getTheme());
            } else {
                return context.getResources().getDrawable(f11942a.resourceId);
            }
        } else if (!"RippleAndroid".equals(string)) {
            throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + string);
        } else if (VERSION.SDK_INT < 21) {
            throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
        } else {
            int i;
            Drawable drawable;
            if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
                i = readableMap.getInt("color");
            } else if (context.getTheme().resolveAttribute(16843820, f11942a, true)) {
                i = context.getResources().getColor(f11942a.resourceId);
            } else {
                throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
            }
            if (readableMap.hasKey("borderless") && !readableMap.isNull("borderless") && readableMap.getBoolean("borderless")) {
                drawable = null;
            } else {
                drawable = new ColorDrawable(-1);
            }
            return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{i}), null, drawable);
        }
    }
}
