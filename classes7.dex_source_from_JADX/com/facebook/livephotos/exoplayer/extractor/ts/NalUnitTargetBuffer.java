package com.facebook.livephotos.exoplayer.extractor.ts;

import com.facebook.livephotos.exoplayer.util.Assertions;
import java.util.Arrays;

/* compiled from: page_edit_review_privacy_error */
public final class NalUnitTargetBuffer {
    public byte[] f7462a;
    public int f7463b;
    private final int f7464c;
    private boolean f7465d;
    public boolean f7466e;

    public NalUnitTargetBuffer(int i, int i2) {
        this.f7464c = i;
        this.f7462a = new byte[(i2 + 3)];
        this.f7462a[2] = (byte) 1;
    }

    public final void m9164a() {
        this.f7465d = false;
        this.f7466e = false;
    }

    public final boolean m9167b() {
        return this.f7466e;
    }

    public final void m9165a(int i) {
        boolean z = true;
        Assertions.m9297b(!this.f7465d);
        if (i != this.f7464c) {
            z = false;
        }
        this.f7465d = z;
        if (this.f7465d) {
            this.f7463b = 3;
            this.f7466e = false;
        }
    }

    public final void m9166a(byte[] bArr, int i, int i2) {
        if (this.f7465d) {
            int i3 = i2 - i;
            if (this.f7462a.length < this.f7463b + i3) {
                this.f7462a = Arrays.copyOf(this.f7462a, (this.f7463b + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f7462a, this.f7463b, i3);
            this.f7463b = i3 + this.f7463b;
        }
    }

    public final boolean m9168b(int i) {
        if (!this.f7465d) {
            return false;
        }
        this.f7463b -= i;
        this.f7465d = false;
        this.f7466e = true;
        return true;
    }
}
