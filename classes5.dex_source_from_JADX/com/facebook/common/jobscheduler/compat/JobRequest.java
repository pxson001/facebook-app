package com.facebook.common.jobscheduler.compat;

import com.facebook.common.persistablebundle.compat.PersistableBundleCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

/* compiled from: social_snippet */
public class JobRequest {
    public final int f2661a;
    public final int f2662b;
    public final boolean f2663c;
    public final long f2664d;
    public final long f2665e;
    public final long f2666f;
    public final long f2667g;
    @Nullable
    public final PersistableBundleCompat f2668h;

    /* compiled from: social_snippet */
    public class Builder {
        public final int f2653a;
        public int f2654b = 0;
        public boolean f2655c = false;
        public long f2656d = -1;
        public long f2657e = -1;
        public long f2658f = -1;
        @Nullable
        public PersistableBundleCompat f2659g;
        public long f2660h = -1;

        public Builder(int i) {
            this.f2653a = i;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: social_snippet */
    public @interface NetworkConnection {
    }

    public JobRequest(Builder builder) {
        this.f2661a = builder.f2653a;
        this.f2662b = builder.f2654b;
        this.f2663c = builder.f2655c;
        this.f2664d = builder.f2656d;
        this.f2665e = builder.f2657e;
        this.f2666f = builder.f2658f;
        this.f2667g = builder.f2660h;
        this.f2668h = builder.f2659g;
        if (this.f2665e <= 0 || this.f2666f <= 0) {
            if (this.f2664d > 0) {
                if (this.f2665e < 0 && this.f2666f < 0) {
                    throw new IllegalArgumentException("You must call setSoftMaximumLatencyMs(long) or setHardMaximumLatencyMs(long)");
                } else if (this.f2665e > 0 && this.f2665e <= this.f2664d) {
                    throw new IllegalArgumentException("setSoftMaximumLatencyMs(long) <= setMinimumLatencyMs(long)");
                } else if (this.f2666f > 0 && this.f2666f <= this.f2664d) {
                    throw new IllegalArgumentException("setHardMaximumLatencyMs(long) <= setMinimumLatencyMs(long)");
                }
            }
            if (this.f2665e > 0 && this.f2664d < 0) {
                throw new IllegalArgumentException("setSoftMaximumLatencyMs(long) <= setMinimumLatencyMs(long)");
            } else if (this.f2666f <= 0 || this.f2664d >= 0) {
                if (this.f2666f > 0) {
                    if (this.f2663c) {
                        throw new IllegalArgumentException("setRequiresCharging(boolean) cannot be called if you are using setHardMaximumLatencyMs(long)");
                    } else if (this.f2662b != 0) {
                        throw new IllegalArgumentException("setRequiredNetwork(int) cannot be called with anything other than NETWORK_CONNECTION_ANY if you are call setHardMaximumLatencyMs(long)");
                    }
                }
                if (this.f2667g < 0) {
                    return;
                }
                if (this.f2664d >= 0) {
                    throw new IllegalArgumentException("setMinimumLatencyMs(long) and setPeriod(long) cant both be called");
                } else if (this.f2665e > 0) {
                    throw new IllegalArgumentException("setSoftMaximumLatencyMs(long) and setPeriod(long) cant both be called");
                } else if (this.f2666f > 0) {
                    throw new IllegalArgumentException("setHardMaximumLatencyMs(long) and setPeriod(long) cant both be called");
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("setHardMaximumLatencyMs(long) <= setMinimumLatencyMs(long)");
            }
        }
        throw new IllegalArgumentException("setSoftMaximumLatencyMs(long) and setHardMaximumLatencyMs(long) were both called. You must use one or the other");
    }
}
