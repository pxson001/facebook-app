package com.facebook.android.maps.model;

/* compiled from: audio_channels */
public final class VisibleRegion {
    public final LatLng f8676a;
    public final LatLng f8677b;
    public final LatLng f8678c;
    public final LatLng f8679d;
    public final LatLngBounds f8680e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f8676a = latLng;
        this.f8677b = latLng2;
        this.f8678c = latLng3;
        this.f8679d = latLng4;
        this.f8680e = latLngBounds;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.facebook.android.maps.model.VisibleRegion;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r5 = (com.facebook.android.maps.model.VisibleRegion) r5;
        r2 = r4.f8676a;
        if (r2 != 0) goto L_0x0037;
    L_0x0011:
        r2 = r5.f8676a;
        if (r2 != 0) goto L_0x0035;
    L_0x0015:
        r2 = r4.f8677b;
        if (r2 != 0) goto L_0x0042;
    L_0x0019:
        r2 = r5.f8677b;
        if (r2 != 0) goto L_0x0035;
    L_0x001d:
        r2 = r4.f8678c;
        if (r2 != 0) goto L_0x004d;
    L_0x0021:
        r2 = r5.f8678c;
        if (r2 != 0) goto L_0x0035;
    L_0x0025:
        r2 = r4.f8679d;
        if (r2 != 0) goto L_0x0058;
    L_0x0029:
        r2 = r5.f8679d;
        if (r2 != 0) goto L_0x0035;
    L_0x002d:
        r2 = r4.f8680e;
        if (r2 != 0) goto L_0x0063;
    L_0x0031:
        r2 = r5.f8680e;
        if (r2 == 0) goto L_0x0004;
    L_0x0035:
        r0 = r1;
        goto L_0x0004;
    L_0x0037:
        r2 = r4.f8676a;
        r3 = r5.f8676a;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0035;
    L_0x0041:
        goto L_0x0015;
    L_0x0042:
        r2 = r4.f8677b;
        r3 = r5.f8677b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0035;
    L_0x004c:
        goto L_0x001d;
    L_0x004d:
        r2 = r4.f8678c;
        r3 = r5.f8678c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0035;
    L_0x0057:
        goto L_0x0025;
    L_0x0058:
        r2 = r4.f8679d;
        r3 = r5.f8679d;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0035;
    L_0x0062:
        goto L_0x002d;
    L_0x0063:
        r2 = r4.f8680e;
        r3 = r5.f8680e;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0035;
    L_0x006d:
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.android.maps.model.VisibleRegion.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = ((this.f8676a != null ? this.f8676a.hashCode() : 0) + 527) * 31;
        if (this.f8677b != null) {
            hashCode = this.f8677b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f8678c != null) {
            hashCode = this.f8678c.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f8679d != null) {
            hashCode = this.f8679d.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.f8680e != null) {
            i = this.f8680e.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return getClass().getSimpleName() + "{nearLeft=" + this.f8676a + ", nearRight=" + this.f8677b + ", farLeft=" + this.f8678c + ", farRight=" + this.f8679d + ", latLngBounds=" + this.f8680e + "}";
    }
}
