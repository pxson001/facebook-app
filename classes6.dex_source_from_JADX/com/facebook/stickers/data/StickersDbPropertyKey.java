package com.facebook.stickers.data;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: email_public_hash */
public class StickersDbPropertyKey extends TypedKey<StickersDbPropertyKey> {
    protected StickersDbPropertyKey(String str) {
        super(str);
    }

    private StickersDbPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m23960a(TypedKey typedKey, String str) {
        return new StickersDbPropertyKey(typedKey, str);
    }
}
