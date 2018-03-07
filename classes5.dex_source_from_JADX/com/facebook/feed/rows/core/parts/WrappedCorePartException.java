package com.facebook.feed.rows.core.parts;

import com.google.common.base.Throwables;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WWW_SOCIAL_WIFI */
public class WrappedCorePartException extends RuntimeException {
    public final Throwable originalException;
    public final List<String> parts = new ArrayList();
    public final String stage;

    private WrappedCorePartException(String str, String str2, Throwable th) {
        this.originalException = th;
        this.stage = str;
        this.parts.add(str2);
        initCause(th);
    }

    public static void m20296a(String str, String str2, Throwable th) {
        if (th instanceof WrappedCorePartException) {
            ((WrappedCorePartException) th).parts.add(str);
        }
        Throwables.propagateIfInstanceOf(th, WrappedCorePartException.class);
        throw new WrappedCorePartException(str2, str, th);
    }
}
