package com.facebook.messaging.inbox2.data.unitstore;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: sender_profile_image_size */
public class UnitStorePropertyKey extends TypedKey<UnitStorePropertyKey> {
    public UnitStorePropertyKey(String str) {
        super(str);
    }

    private UnitStorePropertyKey(UnitStorePropertyKey unitStorePropertyKey, String str) {
        super(unitStorePropertyKey, str);
    }

    protected final TypedKey m2788a(TypedKey typedKey, String str) {
        return new UnitStorePropertyKey((UnitStorePropertyKey) typedKey, str);
    }
}
