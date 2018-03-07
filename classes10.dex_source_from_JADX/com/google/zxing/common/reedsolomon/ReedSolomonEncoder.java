package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* compiled from: event_message_inviter_click */
public final class ReedSolomonEncoder {
    private final GenericGF f13524a;
    private final List<GenericGFPoly> f13525b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        if (GenericGF.f13510e.equals(genericGF)) {
            this.f13524a = genericGF;
            this.f13525b = new ArrayList();
            this.f13525b.add(new GenericGFPoly(genericGF, new int[]{1}));
            return;
        }
        throw new IllegalArgumentException("Only QR Code is supported at this time");
    }

    private GenericGFPoly m13724a(int i) {
        if (i >= this.f13525b.size()) {
            GenericGFPoly genericGFPoly = (GenericGFPoly) this.f13525b.get(this.f13525b.size() - 1);
            GenericGFPoly genericGFPoly2 = genericGFPoly;
            for (int size = this.f13525b.size(); size <= i; size++) {
                genericGFPoly2 = genericGFPoly2.m13716b(new GenericGFPoly(this.f13524a, new int[]{1, this.f13524a.m13704a(size - 1)}));
                this.f13525b.add(genericGFPoly2);
            }
        }
        return (GenericGFPoly) this.f13525b.get(i);
    }

    public final void m13725a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly a = m13724a(i);
        Object obj = new int[length];
        System.arraycopy(iArr, 0, obj, 0, length);
        obj = new GenericGFPoly(this.f13524a, obj).m13712a(i, 1).m13719c(a)[1].f13522b;
        int length2 = i - obj.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(obj, 0, iArr, length + length2, obj.length);
    }
}
