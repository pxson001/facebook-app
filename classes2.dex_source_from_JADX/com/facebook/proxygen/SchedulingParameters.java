package com.facebook.proxygen;

/* compiled from: ps_flt */
public class SchedulingParameters {
    public final int mUpperBoundHighPri;
    public final int mUpperBoundLowPri;
    public final int mUpperBoundMidPri;

    public SchedulingParameters(int i, int i2, int i3) {
        this.mUpperBoundLowPri = i;
        this.mUpperBoundMidPri = i2;
        this.mUpperBoundHighPri = i3;
    }
}
