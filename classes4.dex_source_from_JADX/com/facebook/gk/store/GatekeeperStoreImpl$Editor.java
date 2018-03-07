package com.facebook.gk.store;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.common.util.TriState;
import java.util.Arrays;

/* compiled from: zero_rating_interstitial */
public class GatekeeperStoreImpl$Editor implements GatekeeperWriter$Editor {
    final /* synthetic */ GatekeeperStoreImpl f48a;
    private TriState[] f49b;
    private TriState[] f50c;
    private boolean f51d;

    public final GatekeeperWriter$Editor mo4a(boolean[] zArr) {
        int i = 0;
        synchronized (this) {
            boolean z;
            if (zArr.length == this.f49b.length) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.b(z);
            int length = this.f49b.length;
            while (i < length) {
                this.f49b[i] = TriState.valueOf(zArr[i]);
                i++;
            }
        }
        return this;
    }

    public GatekeeperStoreImpl$Editor(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f48a = gatekeeperStoreImpl;
        this.f49b = new TriState[gatekeeperStoreImpl.b.a()];
        this.f50c = new TriState[gatekeeperStoreImpl.b.a()];
    }

    public final GatekeeperWriter$Editor mo1a(int i, boolean z) {
        synchronized (this) {
            this.f49b[i] = TriState.valueOf(z);
        }
        return this;
    }

    private synchronized GatekeeperStoreImpl$Editor m36a(int i, TriState triState) {
        this.f49b[i] = triState;
        return this;
    }

    public final GatekeeperWriter$Editor mo2a(String str, TriState triState) {
        GatekeeperWriter$Editor a;
        synchronized (this) {
            a = m36a(GatekeeperStoreImpl.f(this.f48a, str), triState);
        }
        return a;
    }

    private synchronized GatekeeperStoreImpl$Editor m37b(int i, TriState triState) {
        this.f50c[i] = triState;
        return this;
    }

    private synchronized GatekeeperStoreImpl$Editor m38c(int i, boolean z) {
        return m37b(i, TriState.valueOf(z));
    }

    public final GatekeeperWriter$Editor mo3a(String str, boolean z) {
        GatekeeperWriter$Editor c;
        synchronized (this) {
            c = m38c(GatekeeperStoreImpl.f(this.f48a, str), z);
        }
        return c;
    }

    public final GatekeeperWriter$Editor mo7b() {
        synchronized (this) {
            Arrays.fill(this.f50c, TriState.UNSET);
        }
        return this;
    }

    public final synchronized void mo5a() {
        GatekeeperStoreImpl.a(this.f48a, this.f49b, this.f50c, this.f51d, false);
    }

    public final synchronized void mo6a(boolean z) {
        GatekeeperStoreImpl.a(this.f48a, this.f49b, this.f50c, this.f51d, z);
    }
}
