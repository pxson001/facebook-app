package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Log;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NULL_STATE_VIEW */
public class ThreadSnapshot extends AbstractStrictModeSetter {
    private static final String f12991a = ThreadSnapshot.class.getSimpleName();
    private Object f12992b;

    @TargetApi(9)
    public ThreadSnapshot() {
        try {
            this.f12992b = StrictMode.getThreadPolicy();
        } catch (Throwable th) {
            Log.e(f12991a, "Unable to retrieve current thread policy.", th);
        }
    }

    @TargetApi(9)
    protected final ThreadPolicy mo366a(Builder builder) {
        if (this.f12992b != null) {
            return new Builder((ThreadPolicy) this.f12992b).build();
        }
        return builder.build();
    }

    protected final boolean mo367a() {
        return !m13715a((ThreadPolicy) this.f12992b);
    }
}
