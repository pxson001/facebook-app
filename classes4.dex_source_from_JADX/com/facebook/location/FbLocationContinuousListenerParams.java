package com.facebook.location;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: keyAs */
public final class FbLocationContinuousListenerParams {
    public final Priority f9700a;
    public final long f9701b;
    public final long f9702c;
    public final float f9703d;

    /* compiled from: keyAs */
    public enum Priority {
        NO_POWER,
        LOW_POWER,
        BALANCED_POWER_AND_ACCURACY,
        HIGH_ACCURACY
    }

    public FbLocationContinuousListenerParams(Priority priority, long j, long j2, float f) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkNotNull(priority);
        Preconditions.checkArgument(j >= j2);
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (j2 > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (f < 0.0f) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f9700a = priority;
        this.f9701b = j;
        this.f9702c = j2;
        this.f9703d = f;
    }
}
