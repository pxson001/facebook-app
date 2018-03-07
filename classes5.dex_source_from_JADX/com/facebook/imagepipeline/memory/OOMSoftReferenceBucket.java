package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: TOUR_COMPANY */
class OOMSoftReferenceBucket<V> extends Bucket<V> {
    private LinkedList<OOMSoftReference<V>> f13716d = new LinkedList();

    public OOMSoftReferenceBucket(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public final V m23062d() {
        V v;
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.c.poll();
        if (oOMSoftReference.f11101a == null) {
            v = null;
        } else {
            v = oOMSoftReference.f11101a.get();
        }
        V v2 = v;
        oOMSoftReference.m19099b();
        this.f13716d.add(oOMSoftReference);
        return v2;
    }

    final void m23061b(V v) {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.f13716d.poll();
        if (oOMSoftReference == null) {
            oOMSoftReference = new OOMSoftReference();
        }
        oOMSoftReference.f11101a = new SoftReference(v);
        oOMSoftReference.f11102b = new SoftReference(v);
        oOMSoftReference.f11103c = new SoftReference(v);
        this.c.add(oOMSoftReference);
    }
}
