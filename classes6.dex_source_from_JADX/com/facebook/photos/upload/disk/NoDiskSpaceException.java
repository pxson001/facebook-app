package com.facebook.photos.upload.disk;

import com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic;
import com.facebook.photos.base.analytics.InterpretedException;

/* compiled from: graph_search_v2_pulse_phrase_click */
public class NoDiskSpaceException extends InterpretedException {
    public NoDiskSpaceException() {
        super("Not enough disk space", true, Diagnostic.NOT_ENOUGH_DISK_SPACE);
    }
}
