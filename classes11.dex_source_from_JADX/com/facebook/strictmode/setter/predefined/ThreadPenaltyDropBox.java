package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NUX_DISMISSED */
public class ThreadPenaltyDropBox extends AbstractStrictModeSetter {
    @TargetApi(9)
    protected final ThreadPolicy mo366a(Builder builder) {
        builder.penaltyDropBox();
        return builder.build();
    }
}
