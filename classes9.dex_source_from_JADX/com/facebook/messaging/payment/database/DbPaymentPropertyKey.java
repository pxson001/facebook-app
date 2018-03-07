package com.facebook.messaging.payment.database;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: install_launch_timestamp */
public class DbPaymentPropertyKey extends TypedKey<DbPaymentPropertyKey> {
    public DbPaymentPropertyKey(String str) {
        super(str);
    }

    private DbPaymentPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m13205a(TypedKey typedKey, String str) {
        return new DbPaymentPropertyKey(typedKey, str);
    }
}
