package com.facebook.photos.upload.uploaders;

import com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic;
import com.facebook.photos.base.analytics.InterpretedException;

/* compiled from: friends_locations_feedstory_v2_tap_profile */
public class MissingMediaFileException extends InterpretedException {
    public MissingMediaFileException(String str) {
        super("Missing media: " + str, false, Diagnostic.MISSING_MEDIA_FILE);
    }
}
