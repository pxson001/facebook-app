package com.facebook.dracula.runtime.guava;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;

/* compiled from: right */
public final class DraculaPreconditions {
    private DraculaPreconditions() {
    }

    public static DraculaReturnValue m4116a(MutableFlatBuffer mutableFlatBuffer, int i, int i2) {
        if (!DraculaRuntime.m4076a(mutableFlatBuffer, i, null, 0)) {
            return DraculaReturnValue.m4065a(mutableFlatBuffer, i, i2);
        }
        throw new NullPointerException();
    }

    public static <T> T m4117a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
