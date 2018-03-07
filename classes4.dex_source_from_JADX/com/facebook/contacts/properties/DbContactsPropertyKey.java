package com.facebook.contacts.properties;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: enabled */
public class DbContactsPropertyKey extends TypedKey<DbContactsPropertyKey> {
    public DbContactsPropertyKey(String str) {
        super(str);
    }

    private DbContactsPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m13925a(TypedKey typedKey, String str) {
        return new DbContactsPropertyKey(typedKey, str);
    }
}
