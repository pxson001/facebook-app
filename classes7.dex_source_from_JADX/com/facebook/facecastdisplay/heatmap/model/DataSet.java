package com.facebook.facecastdisplay.heatmap.model;

import java.util.ArrayList;

/* compiled from: asset_type */
public class DataSet {
    public final ArrayList<DataPoint> f19085a = new ArrayList();
    public float f19086b;

    public final DataPoint m22647a(int i) {
        return (DataPoint) this.f19085a.get(i);
    }

    public final int m22646a() {
        return this.f19085a.size();
    }

    public final boolean m22648b() {
        return this.f19085a.isEmpty();
    }

    public String toString() {
        return this.f19085a.toString();
    }
}
