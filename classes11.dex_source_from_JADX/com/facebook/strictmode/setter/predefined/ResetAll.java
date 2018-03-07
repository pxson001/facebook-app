package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: Never invoke this for an Utility class! */
public class ResetAll extends StrictModeMultiSetter {
    public ResetAll() {
        super(new ThreadReset(), new VmReset());
    }
}
