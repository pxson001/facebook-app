package com.facebook.cache.disk;

import java.io.IOException;

/* compiled from: android.intent.extra.EMAIL */
class DefaultDiskStorage$IncompleteFileException extends IOException {
    public final long actual;
    public final long expected;

    public DefaultDiskStorage$IncompleteFileException(long j, long j2) {
        super("File was not written completely. Expected: " + j + ", found: " + j2);
        this.expected = j;
        this.actual = j2;
    }
}
