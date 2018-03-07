package com.facebook.binaryresource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: android_feather_suggest_edits_upsell */
public class ByteArrayBinaryResource implements BinaryResource {
    private final byte[] f10354a;

    public final long m18438c() {
        return (long) this.f10354a.length;
    }

    public final InputStream m18436a() {
        return new ByteArrayInputStream(this.f10354a);
    }

    public final byte[] m18437b() {
        return this.f10354a;
    }
}
