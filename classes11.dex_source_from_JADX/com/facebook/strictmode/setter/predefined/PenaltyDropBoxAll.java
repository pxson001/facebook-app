package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: No Content */
public class PenaltyDropBoxAll extends StrictModeMultiSetter {
    public PenaltyDropBoxAll() {
        super(new ThreadPenaltyDropBox(), new VmPenaltyDropBox());
    }
}
