package com.facebook.facecast.plugin.creativetools;

import android.graphics.Color;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: before updateTexImage */
public class CreativeToolsColorDoodle {
    public final int f18671a;

    private CreativeToolsColorDoodle(int i) {
        this.f18671a = i;
    }

    @Nullable
    public static CreativeToolsColorDoodle m22261a(@Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        if (str.codePointAt(0) != 35) {
            str = "#" + str;
        }
        try {
            return new CreativeToolsColorDoodle(Color.parseColor(str));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String toString() {
        return "ColorDoodle: #" + Integer.toHexString(this.f18671a);
    }
}
