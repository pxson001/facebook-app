package com.facebook.xconfig.core;

import com.facebook.common.typedkey.TypedKey;
import com.google.common.base.Preconditions;

/* compiled from: share */
public class XConfigName extends TypedKey<XConfigName> {
    public static final XConfigName f5021d = new XConfigName("INTERNAL_ANY_CONFIG");

    public XConfigName(String str) {
        super(str);
        Preconditions.checkArgument(XConfigRegistry.m8938a(str));
    }

    private XConfigName(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey mo317a(TypedKey typedKey, String str) {
        return new XConfigName(typedKey, str);
    }
}
