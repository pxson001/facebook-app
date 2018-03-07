package com.facebook.strictmode.setter.predefined;

import android.annotation.TargetApi;
import android.os.StrictMode;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode.VmPolicy.Builder;
import android.util.Log;
import com.facebook.strictmode.setter.AbstractStrictModeSetter;

/* compiled from: NO_INTERNET */
public class VmSnapshot extends AbstractStrictModeSetter {
    private static final String f12993a = VmSnapshot.class.getSimpleName();
    private Object f12994b;

    @TargetApi(9)
    public VmSnapshot() {
        try {
            this.f12994b = StrictMode.getVmPolicy();
        } catch (Throwable th) {
            Log.e(f12993a, "Unable to retrieve current vm policy.", th);
        }
    }

    @TargetApi(9)
    protected final VmPolicy mo368a(Builder builder) {
        if (this.f12994b != null) {
            return m13712a((VmPolicy) this.f12994b).build();
        }
        return builder.build();
    }

    protected final boolean mo369b() {
        return !m13717b((VmPolicy) this.f12994b);
    }
}
