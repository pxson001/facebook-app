package com.facebook.location;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: ₱ */
public class FbLocationContinuousListenerException extends Exception {
    public final Type type;

    /* compiled from: ₱ */
    public enum Type {
        LOCATION_UNAVAILABLE,
        TEMPORARY_ERROR,
        PERMISSION_DENIED,
        LOCATION_UNSUPPORTED
    }

    public FbLocationContinuousListenerException(Type type) {
        this(type, null);
    }

    public FbLocationContinuousListenerException(Type type, @Nullable Throwable th) {
        super("Location error: " + type, th);
        this.type = (Type) Preconditions.checkNotNull(type);
    }
}
