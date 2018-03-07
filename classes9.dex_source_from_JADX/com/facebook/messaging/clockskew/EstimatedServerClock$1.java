package com.facebook.messaging.clockskew;

import com.facebook.messaging.clockskew.EstimatedServerClock.State;

/* compiled from: messenger_pay_entity_type */
/* synthetic */ class EstimatedServerClock$1 {
    static final /* synthetic */ int[] f9769a = new int[State.values().length];

    static {
        try {
            f9769a[State.SKEWED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9769a[State.ACCURATE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9769a[State.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
