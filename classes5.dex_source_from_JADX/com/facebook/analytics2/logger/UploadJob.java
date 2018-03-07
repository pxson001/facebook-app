package com.facebook.analytics2.logger;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: textOnlyPlace */
public class UploadJob {
    private final Priority f2037a;
    private final Tier f2038b;
    private final BatchPayload f2039c;

    /* compiled from: textOnlyPlace */
    public enum Tier {
        DEFAULT,
        BOOTSTRAP
    }

    UploadJob(Priority priority, Tier tier, BatchPayload batchPayload) {
        this.f2037a = priority;
        this.f2038b = tier;
        this.f2039c = batchPayload;
    }

    public final Priority m2740a() {
        return this.f2037a;
    }

    public final Tier m2741b() {
        return this.f2038b;
    }

    public final BatchPayload m2742c() {
        return this.f2039c;
    }
}
