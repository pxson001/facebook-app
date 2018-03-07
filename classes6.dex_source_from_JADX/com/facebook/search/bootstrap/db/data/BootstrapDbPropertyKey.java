package com.facebook.search.bootstrap.db.data;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: extensible_message_admin_text_type */
public class BootstrapDbPropertyKey extends TypedKey<BootstrapDbPropertyKey> {
    public BootstrapDbPropertyKey(String str) {
        super(str);
    }

    private BootstrapDbPropertyKey(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m23410a(TypedKey typedKey, String str) {
        return new BootstrapDbPropertyKey(typedKey, str);
    }
}
