package com.facebook.location.write;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: logVideoPlayerUnPausedEvent */
public class LocationMutationModelCreatorParams {
    public final boolean f16464a;
    public final int f16465b;
    public final int f16466c;

    /* compiled from: logVideoPlayerUnPausedEvent */
    public class Builder {
        public boolean f16288a = false;
        public int f16289b = Integer.MAX_VALUE;
        public int f16290c = Integer.MIN_VALUE;
    }

    public LocationMutationModelCreatorParams(boolean z, int i, int i2) {
        this.f16464a = z;
        this.f16465b = i;
        this.f16466c = i2;
    }
}
