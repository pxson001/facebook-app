package com.facebook.photos.local;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: hashtag */
public class LocalMediaCursorMethodAutoProvider extends AbstractProvider<LocalMediaCursor> {
    public static LocalMediaCursorImp m20422b(InjectorLike injectorLike) {
        return PhotosLocalModule.m20433a(IdBasedSingletonScopeProvider.a(injectorLike, 9342));
    }

    public Object get() {
        return PhotosLocalModule.m20433a(IdBasedSingletonScopeProvider.a(this, 9342));
    }

    public static LocalMediaCursorImp m20421a(InjectorLike injectorLike) {
        return m20422b(injectorLike);
    }
}
