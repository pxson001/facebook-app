package com.facebook.fbui.widget.text.layoutbuilder;

/* compiled from: messenger_custom_nicknames */
public class HashCodeBuilder {
    public static int m29738a(int i, int i2) {
        return (i * 31) + i2;
    }

    public static int m29740a(int i, boolean z) {
        return m29738a(i, z ? 1 : 0);
    }

    public static int m29737a(int i, float f) {
        return m29738a(i, Float.floatToIntBits(f));
    }

    public static int m29739a(int i, Object obj) {
        return m29738a(i, obj == null ? 0 : obj.hashCode());
    }
}
