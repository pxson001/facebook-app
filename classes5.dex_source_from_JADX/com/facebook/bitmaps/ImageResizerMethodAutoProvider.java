package com.facebook.bitmaps;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: android.webkit. */
public class ImageResizerMethodAutoProvider extends AbstractProvider<ImageResizer> {
    public static ImageResizer m18454b(InjectorLike injectorLike) {
        return BitmapsModule.m18442a(IdBasedProvider.a(injectorLike, 4976), IdBasedProvider.a(injectorLike, 4977), IdBasedProvider.a(injectorLike, 4979));
    }

    public Object get() {
        return BitmapsModule.m18442a(IdBasedProvider.a(this, 4976), IdBasedProvider.a(this, 4977), IdBasedProvider.a(this, 4979));
    }

    public static ImageResizer m18453a(InjectorLike injectorLike) {
        return m18454b(injectorLike);
    }
}
