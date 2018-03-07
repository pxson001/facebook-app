package com.facebook.common.io;

import com.facebook.common.iolite.Closeables;
import com.facebook.debug.log.BLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.Writer;
import javax.annotation.Nullable;

/* compiled from: last_bundle_index */
public class FbCloseables {
    public static void m25417a(@Nullable ByteArrayOutputStream byteArrayOutputStream) {
        try {
            Closeables.m2789a(byteArrayOutputStream, true);
        } catch (Throwable e) {
            BLog.a(FbCloseables.class, "IOException should not have been thrown.", e);
        }
    }

    public static void m25418a(@Nullable Closeable closeable) {
        if ((closeable instanceof OutputStream) || (closeable instanceof Writer)) {
            BLog.c(FbCloseables.class, "Should not swallow exceptions when writing");
        }
        try {
            Closeables.m2789a(closeable, true);
        } catch (Throwable e) {
            BLog.a(FbCloseables.class, "IOException should not have been thrown.", e);
        }
    }
}
