package com.facebook.location;

import com.facebook.location.FbLocationStatus.State;

/* compiled from: ₩ */
/* synthetic */ class FbLocationStatus$1 {
    static final /* synthetic */ int[] f19a = new int[State.values().length];

    static {
        try {
            f19a[State.OKAY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19a[State.LOCATION_DISABLED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19a[State.PERMISSION_DENIED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
