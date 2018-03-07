package com.google.common.hash;

import com.google.common.annotations.Beta;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@Beta
/* compiled from: story_header */
public final class Hashing {
    private static final int f1655a = ((int) System.currentTimeMillis());

    /* compiled from: story_header */
    class Sha1Holder {
        static final AbstractStreamingHashFunction f1656a = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    }

    public static AbstractStreamingHashFunction m1880a() {
        return Md5Holder.a;
    }

    public static AbstractStreamingHashFunction m1881b() {
        return Sha1Holder.f1656a;
    }

    private Hashing() {
    }
}
