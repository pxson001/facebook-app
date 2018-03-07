package com.facebook.common.iolite;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* compiled from: user_disabled_providers */
public class Closeables {
    public static void m2789a(@Nullable Closeable closeable, boolean z) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (!z) {
                    throw e;
                }
            }
        }
    }

    public static void m2790a(@Nullable InputStream inputStream) {
        try {
            m2789a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
