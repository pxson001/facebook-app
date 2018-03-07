package com.facebook.location;

import com.google.common.base.Preconditions;

/* compiled from: is_pin_set */
public class FbLocationManagerException extends Exception {
    public final Type type;

    /* compiled from: is_pin_set */
    public enum Type {
        LOCATION_UNAVAILABLE,
        TIMEOUT,
        UNKNOWN_ERROR,
        PERMISSION_DENIED
    }

    public FbLocationManagerException(Type type) {
        super("Location error: " + type);
        this.type = (Type) Preconditions.checkNotNull(type);
    }
}
