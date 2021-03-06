package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode.VmPolicy.Builder;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NO_SCROLL */
public class VmLax extends AbstractStrictModeSetter {
    @TargetApi(9)
    protected final VmPolicy mo368a(Builder builder) {
        return VmPolicy.LAX;
    }
}
