package com.facebook.video.videostreaming;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: sameHashExist */
public class NetworkSpeedTest {
    @DoNotStrip
    public final double bandwidth;
    @DoNotStrip
    public final boolean speedTestPassesThreshold;
    @DoNotStrip
    public final Status state;
    @DoNotStrip
    public final long timeTaken;

    @DoNotStrip
    /* compiled from: sameHashExist */
    public enum Status {
        Failed,
        Succeeded,
        Canceled,
        Ignored
    }

    @DoNotStrip
    public NetworkSpeedTest(int i, double d, long j, boolean z) {
        this.state = Status.values()[i];
        this.bandwidth = d;
        this.timeTaken = j;
        this.speedTestPassesThreshold = z;
    }
}
