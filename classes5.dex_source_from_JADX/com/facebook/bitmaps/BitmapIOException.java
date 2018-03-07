package com.facebook.bitmaps;

import java.io.IOException;

/* compiled from: android_entity_card_edit_action_button */
public class BitmapIOException extends BitmapException {
    public BitmapIOException(String str, IOException iOException) {
        super("I/O error while loading: " + str, iOException);
    }
}
