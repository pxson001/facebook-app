package com.facebook.livephotos.exoplayer;

import com.facebook.livephotos.exoplayer.util.Assertions;

/* compiled from: pandora_albums_grid */
public abstract class TrackRenderer {
    public int f6748a;

    protected abstract MediaFormat mo364a(int i);

    protected abstract void mo366a(long j, long j2);

    protected abstract boolean mo367b(long j);

    protected abstract void mo368c(long j);

    protected abstract boolean mo380e();

    protected abstract boolean mo381f();

    protected abstract long mo370n();

    protected abstract long mo371o();

    protected abstract void mo372p();

    protected abstract int mo374r();

    protected MediaClock mo389b() {
        return null;
    }

    protected final int m8620s() {
        return this.f6748a;
    }

    final int m8610d(long j) {
        boolean z;
        int i = 1;
        if (this.f6748a == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.m9297b(z);
        if (!mo367b(j)) {
            i = 0;
        }
        this.f6748a = i;
        return this.f6748a;
    }

    public void mo365a(int i, long j, boolean z) {
    }

    final void m8621t() {
        Assertions.m9297b(this.f6748a == 2);
        this.f6748a = 3;
        mo378c();
    }

    protected void mo378c() {
    }

    public void mo379d() {
    }

    public void mo369g() {
    }

    final void m8622w() {
        boolean z = (this.f6748a == 2 || this.f6748a == 3 || this.f6748a == -1) ? false : true;
        Assertions.m9297b(z);
        this.f6748a = -1;
        mo373q();
    }

    protected void mo373q() {
    }

    public void mo384a(int i, Object obj) {
    }
}
