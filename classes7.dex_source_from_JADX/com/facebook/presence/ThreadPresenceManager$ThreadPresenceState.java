package com.facebook.presence;

/* compiled from: image_block_image */
class ThreadPresenceManager$ThreadPresenceState {
    volatile boolean f11196a;
    volatile int f11197b;
    volatile String f11198c;
    volatile String f11199d;
    volatile long f11200e = -1;

    public ThreadPresenceManager$ThreadPresenceState(String str, String str2, boolean z, long j, int i) {
        this.f11196a = z;
        this.f11199d = str;
        this.f11198c = str2;
        this.f11200e = j;
        this.f11197b = i;
    }
}
