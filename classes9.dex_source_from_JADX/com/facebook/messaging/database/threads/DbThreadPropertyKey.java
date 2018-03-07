package com.facebook.messaging.database.threads;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: mcs_item_title */
public class DbThreadPropertyKey extends TypedKey<DbThreadPropertyKey> {
    public DbThreadPropertyKey(String str) {
        super(str);
    }

    private DbThreadPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m11131a(TypedKey typedKey, String str) {
        return new DbThreadPropertyKey(typedKey, str);
    }
}
