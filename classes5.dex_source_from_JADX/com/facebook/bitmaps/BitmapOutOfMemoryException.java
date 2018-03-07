package com.facebook.bitmaps;

/* compiled from: android_context_row_suggest_edits */
public class BitmapOutOfMemoryException extends BitmapException {
    public BitmapOutOfMemoryException(OutOfMemoryError outOfMemoryError) {
        super("Out of memory", outOfMemoryError);
    }
}
