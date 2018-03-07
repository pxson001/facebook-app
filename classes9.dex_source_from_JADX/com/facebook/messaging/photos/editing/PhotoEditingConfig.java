package com.facebook.messaging.photos.editing;

/* compiled from: disconnectedMqttEarliestRetryMs= */
public class PhotoEditingConfig {
    public final boolean f16070a;
    public final boolean f16071b;
    public final boolean f16072c;
    public final boolean f16073d;

    public PhotoEditingConfig(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f16070a = z;
        this.f16071b = z2;
        this.f16072c = z3;
        this.f16073d = z4;
    }

    public final boolean m16227b() {
        return this.f16070a || this.f16071b || this.f16072c;
    }
}
