package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: glCreateShader */
public interface ReadableMapKeySetIterator {
    boolean hasNextKey();

    String nextKey();
}
