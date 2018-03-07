package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;

/* compiled from: TREEHOUSE_GROUP_PROFILE_MORE */
public interface AnimatedDrawableCachingBackend extends AnimatedDrawableBackend {
    void mo1260a(StringBuilder stringBuilder);

    AnimatedDrawableCachingBackend mo1261b(Rect rect);

    CloseableReference<Bitmap> mo1262g(int i);

    CloseableReference<Bitmap> mo1263l();
}
