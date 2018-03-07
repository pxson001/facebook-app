package com.facebook.strictmode.setter.predefined;

import com.facebook.strictmode.setter.StrictModeMultiSetter;

/* compiled from: No asset for verification status  */
public class DetectAll extends StrictModeMultiSetter {
    public DetectAll() {
        super(new ThreadDetectAll(), new VmDetectAll());
    }
}
