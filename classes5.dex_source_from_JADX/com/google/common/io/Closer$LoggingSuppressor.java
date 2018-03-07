package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.Closer.Suppressor;
import java.io.Closeable;
import java.util.logging.Level;

@VisibleForTesting
/* compiled from: bug_report_attachment_retry_upload_success */
final class Closer$LoggingSuppressor implements Suppressor {
    static final Closer$LoggingSuppressor f7651a = new Closer$LoggingSuppressor();

    Closer$LoggingSuppressor() {
    }

    public final void m13817a(Closeable closeable, Throwable th, Throwable th2) {
        Closeables.a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
    }
}
