package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NUX_CAN_SHOW */
public class ThreadPenaltyLog extends AbstractStrictModeSetter {
    @TargetApi(9)
    protected final ThreadPolicy mo366a(Builder builder) {
        builder.penaltyLog();
        return builder.build();
    }

    protected final boolean mo367a() {
        return false;
    }
}
