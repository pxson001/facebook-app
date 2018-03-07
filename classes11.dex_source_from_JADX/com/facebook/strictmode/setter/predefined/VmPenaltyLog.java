package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode.VmPolicy.Builder;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NO_NETWORK */
public class VmPenaltyLog extends AbstractStrictModeSetter {
    @TargetApi(9)
    protected final VmPolicy mo368a(Builder builder) {
        builder.penaltyLog();
        return builder.build();
    }

    protected final boolean mo369b() {
        return false;
    }
}
