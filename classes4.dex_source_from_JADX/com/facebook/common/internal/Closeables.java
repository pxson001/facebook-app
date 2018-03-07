package com.facebook.common.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: second_fbid_creation_path */
public final class Closeables {
    @VisibleForTesting
    static final Logger f2934a = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void m3176a(@Nullable Closeable closeable, boolean z) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                if (z) {
                    f2934a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
                    return;
                }
                throw e;
            }
        }
    }

    public static void m3177a(@Nullable InputStream inputStream) {
        try {
            m3176a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
