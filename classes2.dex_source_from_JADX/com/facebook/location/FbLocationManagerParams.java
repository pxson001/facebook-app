package com.facebook.location;

import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: request_body_size */
public class FbLocationManagerParams {
    public final Priority f17827a;
    public final Optional<Long> f17828b;
    public final Optional<Float> f17829c;
    public final Optional<Long> f17830d;
    public final long f17831e;
    public final float f17832f;
    public final long f17833g;
    public final float f17834h;

    /* compiled from: request_body_size */
    public enum Priority {
        LOW_POWER,
        BALANCED_POWER_AND_ACCURACY,
        HIGH_ACCURACY
    }

    /* compiled from: request_body_size */
    public class Builder {
        public final Priority f17819a;
        public Optional<Long> f17820b = Absent.INSTANCE;
        public Optional<Float> f17821c = Absent.INSTANCE;
        public Optional<Long> f17822d = Optional.of(Long.valueOf(10000));
        public long f17823e = 5000;
        public float f17824f = 50.0f;
        public long f17825g = 120000;
        public float f17826h = 0.6666667f;

        public Builder(Priority priority) {
            this.f17819a = priority;
        }
    }

    public FbLocationManagerParams(Builder builder) {
        this.f17827a = builder.f17819a;
        this.f17828b = builder.f17820b;
        this.f17829c = builder.f17821c;
        this.f17830d = builder.f17822d;
        this.f17831e = builder.f17823e;
        this.f17832f = builder.f17824f;
        this.f17833g = builder.f17825g;
        this.f17834h = builder.f17826h;
    }
}
