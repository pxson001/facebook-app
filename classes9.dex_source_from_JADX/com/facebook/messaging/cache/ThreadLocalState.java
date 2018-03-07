package com.facebook.messaging.cache;

import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: messengerbot_command_suggestion */
class ThreadLocalState {
    private static final Class<?> f9555a = ThreadLocalState.class;
    private final ThreadKey f9556b;
    private long f9557c = -1;
    private long f9558d = -1;
    private boolean f9559e;
    private long f9560f;

    ThreadLocalState(ThreadKey threadKey) {
        this.f9556b = threadKey;
    }

    public final boolean m10146a() {
        return this.f9559e;
    }

    public final void m10147b() {
        this.f9559e = true;
    }

    public final void m10149c() {
        this.f9559e = false;
    }

    public final long m10151d() {
        return this.f9557c;
    }

    public final void m10145a(long j) {
        this.f9557c = j;
        if (j > this.f9558d) {
            this.f9558d = -1;
        }
    }

    public final long m10152e() {
        return this.f9558d;
    }

    public final void m10148b(long j) {
        if (j > this.f9557c || j == 0) {
            this.f9558d = j;
        } else {
            this.f9558d = -1;
        }
    }

    public final long m10153f() {
        if (this.f9558d > -1) {
            return this.f9558d;
        }
        return this.f9557c;
    }

    public final long m10154g() {
        return this.f9560f;
    }

    public final void m10150c(long j) {
        this.f9560f = j;
    }
}
