package com.facebook.device_id;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: threads. */
public class UniqueDeviceId {
    public final String f3013a;
    public final long f3014b;

    public UniqueDeviceId(String str, long j) {
        this.f3013a = str;
        this.f3014b = j;
    }

    public final String m4994a() {
        return this.f3013a;
    }

    public final long m4995b() {
        return this.f3014b;
    }

    public String toString() {
        return "UniqueDeviceId{id=" + this.f3013a + ", timestamp=" + this.f3014b + "}";
    }
}
