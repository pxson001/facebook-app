package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
/* compiled from: user_disabled_providers */
public final class Closeables {
    @VisibleForTesting
    static final Logger f15035a = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void m21581a(@Nullable Closeable closeable, boolean z) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                if (z) {
                    f15035a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
                    return;
                }
                throw e;
            }
        }
    }

    public static void m21582a(@Nullable InputStream inputStream) {
        try {
            m21581a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static void m21583a(@Nullable Reader reader) {
        try {
            m21581a(reader, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
