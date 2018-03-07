package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: No MD5 available! */
public class PenaltyDeathAll extends StrictModeMultiSetter {
    public PenaltyDeathAll() {
        super(new ThreadPenaltyDeath(), new VmPenaltyDeath());
    }
}
