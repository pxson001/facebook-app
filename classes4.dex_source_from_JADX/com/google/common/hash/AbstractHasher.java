package com.google.common.hash;

import java.nio.charset.Charset;

/* compiled from: stop_extra */
abstract class AbstractHasher implements Hasher {
    AbstractHasher() {
    }

    public final Hasher mo126a(CharSequence charSequence, Charset charset) {
        return mo122b(charSequence.toString().getBytes(charset));
    }
}
