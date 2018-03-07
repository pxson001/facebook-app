package com.facebook.livephotos.exoplayer.upstream;

import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.util.Arrays;

/* compiled from: overlay_cta */
public final class DefaultAllocator {
    public final int f7641a;
    private final byte[] f7642b;
    private int f7643c;
    private int f7644d;
    private Allocation[] f7645e;

    public DefaultAllocator(int i) {
        this(i, 0);
    }

    private DefaultAllocator(int i, int i2) {
        boolean z = true;
        int i3 = 0;
        Assertions.m9295a(i > 0);
        if (i2 < 0) {
            z = false;
        }
        Assertions.m9295a(z);
        this.f7641a = i;
        this.f7644d = i2;
        this.f7645e = new Allocation[(i2 + 100)];
        if (i2 > 0) {
            this.f7642b = new byte[(i2 * i)];
            while (i3 < i2) {
                this.f7645e[i3] = new Allocation(this.f7642b, i3 * i);
                i3++;
            }
            return;
        }
        this.f7642b = null;
    }

    public final synchronized Allocation m9263a() {
        Allocation allocation;
        this.f7643c++;
        if (this.f7644d > 0) {
            Allocation[] allocationArr = this.f7645e;
            int i = this.f7644d - 1;
            this.f7644d = i;
            allocation = allocationArr[i];
            this.f7645e[this.f7644d] = null;
        } else {
            allocation = new Allocation(new byte[this.f7641a], 0);
        }
        return allocation;
    }

    public final synchronized void m9265a(Allocation allocation) {
        boolean z = allocation.f7620a == this.f7642b || allocation.f7620a.length == this.f7641a;
        Assertions.m9295a(z);
        this.f7643c--;
        if (this.f7644d == this.f7645e.length) {
            this.f7645e = (Allocation[]) Arrays.copyOf(this.f7645e, this.f7645e.length * 2);
        }
        Allocation[] allocationArr = this.f7645e;
        int i = this.f7644d;
        this.f7644d = i + 1;
        allocationArr[i] = allocation;
        ObjectDetour.c(this, 1315996123);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m9264a(int r8) {
        /*
        r7 = this;
        r2 = 0;
        monitor-enter(r7);
        r0 = r7.f7641a;	 Catch:{ all -> 0x005c }
        r0 = com.facebook.livephotos.exoplayer.util.Util.m9360a(r8, r0);	 Catch:{ all -> 0x005c }
        r1 = 0;
        r3 = r7.f7643c;	 Catch:{ all -> 0x005c }
        r0 = r0 - r3;
        r0 = java.lang.Math.max(r1, r0);	 Catch:{ all -> 0x005c }
        r1 = r7.f7644d;	 Catch:{ all -> 0x005c }
        if (r0 < r1) goto L_0x0016;
    L_0x0014:
        monitor-exit(r7);
        return;
    L_0x0016:
        r1 = r7.f7642b;	 Catch:{  }
        if (r1 == 0) goto L_0x0051;
    L_0x001a:
        r1 = r7.f7644d;	 Catch:{  }
        r1 = r1 + -1;
    L_0x001e:
        if (r2 > r1) goto L_0x0049;
    L_0x0020:
        r3 = r7.f7645e;	 Catch:{  }
        r4 = r3[r2];	 Catch:{  }
        r3 = r4.f7620a;	 Catch:{  }
        r5 = r7.f7642b;	 Catch:{  }
        if (r3 != r5) goto L_0x002d;
    L_0x002a:
        r2 = r2 + 1;
        goto L_0x001e;
    L_0x002d:
        r3 = r7.f7645e;	 Catch:{  }
        r5 = r3[r2];	 Catch:{  }
        r3 = r5.f7620a;	 Catch:{  }
        r6 = r7.f7642b;	 Catch:{  }
        if (r3 == r6) goto L_0x003a;
    L_0x0037:
        r1 = r1 + -1;
        goto L_0x001e;
    L_0x003a:
        r6 = r7.f7645e;	 Catch:{  }
        r3 = r2 + 1;
        r6[r2] = r5;	 Catch:{  }
        r5 = r7.f7645e;	 Catch:{  }
        r2 = r1 + -1;
        r5[r1] = r4;	 Catch:{  }
        r1 = r2;
        r2 = r3;
        goto L_0x001e;
    L_0x0049:
        r0 = java.lang.Math.max(r0, r2);	 Catch:{  }
        r1 = r7.f7644d;	 Catch:{  }
        if (r0 >= r1) goto L_0x0014;
    L_0x0051:
        r1 = r7.f7645e;	 Catch:{  }
        r2 = r7.f7644d;	 Catch:{  }
        r3 = 0;
        java.util.Arrays.fill(r1, r0, r2, r3);	 Catch:{  }
        r7.f7644d = r0;	 Catch:{  }
        goto L_0x0014;
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.upstream.DefaultAllocator.a(int):void");
    }

    private synchronized int m9262c() {
        return this.f7643c * this.f7641a;
    }

    public final synchronized void m9266b(int i) {
        while (m9262c() > i) {
            ObjectDetour.a(this, 116810858);
        }
    }
}
