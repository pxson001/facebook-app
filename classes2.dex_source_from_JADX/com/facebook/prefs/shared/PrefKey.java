package com.facebook.prefs.shared;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: vnd.android.cursor.item/vnd.com.facebook.katana.provider.friends */
public class PrefKey extends TypedKey<PrefKey> {
    public PrefKey(String str) {
        super(str);
    }

    public PrefKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey mo317a(TypedKey typedKey, String str) {
        return new PrefKey(typedKey, str);
    }
}
