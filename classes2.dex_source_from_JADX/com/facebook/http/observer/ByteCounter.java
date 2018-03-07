package com.facebook.http.observer;

import android.annotation.SuppressLint;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;

@SuppressLint({"UsingDefaultJsonDeserializer"})
/* compiled from: numGets */
public class ByteCounter {
    public long f12005a = 0;
    public final ResponseBandwidthManager f12006b;

    public ByteCounter(Optional<ResponseBandwidthManager> optional) {
        this.f12006b = optional.isPresent() ? (ResponseBandwidthManager) optional.get() : null;
    }

    public final void m17703a(long j) {
        this.f12005a = j;
    }

    public final void m17704b(long j) {
        this.f12005a += j;
        if (this.f12006b != null) {
            this.f12006b.m17708a(j);
        }
    }

    @JsonProperty("count")
    public long getCount() {
        return this.f12005a;
    }
}
