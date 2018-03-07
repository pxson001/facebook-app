package com.facebook.bitmaps;

import java.lang.reflect.UndeclaredThrowableException;

/* compiled from: android_deep_link */
public class BitmapImageSourceException extends BitmapException {
    public BitmapImageSourceException(UndeclaredThrowableException undeclaredThrowableException) {
        super("Image source error while loading", undeclaredThrowableException);
    }
}
