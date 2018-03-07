package com.facebook.crudolib.params;

import android.support.v4.util.Pools$SynchronizedPool;

/* compiled from: tap_origin */
public class ParamsCollectionPool {
    public final Pools$SynchronizedPool<ParamsCollectionMap> f3235a;
    public final Pools$SynchronizedPool<ParamsCollectionArray> f3236b;
    private final int f3237c;
    public final int f3238d;

    public static ParamsCollectionPool m5397a() {
        return new ParamsCollectionPool(8, 2, 16, 32);
    }

    private ParamsCollectionPool(int i, int i2, int i3, int i4) {
        this.f3235a = new Pools$SynchronizedPool(i);
        this.f3236b = new Pools$SynchronizedPool(i2);
        this.f3237c = i3;
        this.f3238d = i4;
    }

    public final ParamsCollectionMap m5398b() {
        ParamsCollection paramsCollection = (ParamsCollectionMap) this.f3235a.mo740a();
        if (paramsCollection == null) {
            paramsCollection = new ParamsCollectionMap(this.f3237c);
        }
        paramsCollection.m5437a(this);
        return paramsCollection;
    }

    public final ParamsCollectionArray m5399c() {
        ParamsCollection paramsCollection = (ParamsCollectionArray) this.f3236b.mo740a();
        if (paramsCollection == null) {
            paramsCollection = new ParamsCollectionArray(this.f3237c);
        }
        paramsCollection.m5437a(this);
        return paramsCollection;
    }
}
