package com.facebook.backgroundworklog;

import com.facebook.inject.AbstractProvider;

/* compiled from: select_longitude */
public class BackgroundWorkRecorderAutoProvider extends AbstractProvider<BackgroundWorkRecorder> {
    public Object get() {
        return new BackgroundWorkRecorder();
    }
}
