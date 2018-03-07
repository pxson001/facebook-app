package com.facebook.messaging.tincan.database;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: client_tags */
public class DbTincanPropertyKey extends TypedKey<DbTincanPropertyKey> {
    public DbTincanPropertyKey(String str) {
        super(str);
    }

    private DbTincanPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m17912a(TypedKey typedKey, String str) {
        return new DbTincanPropertyKey(typedKey, str);
    }
}
