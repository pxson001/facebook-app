package com.facebook.push.mqtt.external;

import android.os.Bundle;

/* compiled from: fetch_image_success_ratio */
public class PublishedPayloadDescriptor {
    public final String f11644a;
    public final byte[] f11645b;
    public final long f11646c;
    public long f11647d;
    public long f11648e;

    public PublishedPayloadDescriptor(String str, byte[] bArr, long j) {
        this.f11644a = str;
        this.f11645b = bArr;
        this.f11646c = j;
    }

    public PublishedPayloadDescriptor(Bundle bundle) {
        this(bundle.getString("topic_name"), bundle.getByteArray("payload"), bundle.getLong("received_time_ms", 0));
        this.f11647d = bundle.getLong("before_ipc_time_ms", 0);
        this.f11648e = bundle.getLong("before_broadcast_time_ms", 0);
    }

    public final String m12191b() {
        return this.f11644a;
    }

    public final byte[] m12192c() {
        return this.f11645b;
    }

    public final long m12193d() {
        return this.f11646c;
    }
}
