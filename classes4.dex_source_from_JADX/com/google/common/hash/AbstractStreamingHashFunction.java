package com.google.common.hash;

import java.nio.charset.Charset;

/* compiled from: stop_reason */
public abstract class AbstractStreamingHashFunction {
    public abstract Hasher mo115a();

    AbstractStreamingHashFunction() {
    }

    public final HashCode m1885a(CharSequence charSequence, Charset charset) {
        return mo115a().mo126a(charSequence, charset).mo116a();
    }
}
