package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NearbyTiles */
public class ThreadDetectAll extends AbstractStrictModeSetter {
    @TargetApi(9)
    protected final ThreadPolicy mo366a(Builder builder) {
        builder.detectAll();
        return builder.build();
    }
}
