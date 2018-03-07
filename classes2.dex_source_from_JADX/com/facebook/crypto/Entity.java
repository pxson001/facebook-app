package com.facebook.crypto;

import java.nio.charset.Charset;

/* compiled from: openFile */
public class Entity {
    private static final Charset f10984a = Charset.forName("UTF-16");
    private static final Charset f10985b = Charset.forName("UTF-8");
    public final byte[] f10986c;

    @Deprecated
    public Entity(String str) {
        this.f10986c = str.getBytes(f10984a);
    }

    private Entity(byte[] bArr) {
        this.f10986c = bArr;
    }

    public static Entity m16303a(String str) {
        return new Entity(str.getBytes(f10985b));
    }
}
