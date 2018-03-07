package com.facebook.android.maps;

import android.support.annotation.Nullable;
import com.facebook.android.maps.model.LatLng;
import java.util.Comparator;

/* compiled from: b1 */
public final class InternalClusterItem<T extends ClusterItem> implements Comparable<InternalClusterItem<T>> {
    double f8166a;
    double f8167b;
    @Nullable
    private final Comparator<T> f8168c;
    public final T f8169d;
    public Cluster<T> f8170e;
    private LatLng f8171f;

    public final int compareTo(Object obj) {
        InternalClusterItem internalClusterItem = (InternalClusterItem) obj;
        if (this.f8168c != null) {
            return this.f8168c.compare(this.f8169d, internalClusterItem.f8169d);
        }
        if (this.f8169d instanceof Comparable) {
            return ((Comparable) this.f8169d).compareTo(internalClusterItem.f8169d);
        }
        m14312c();
        internalClusterItem.m14312c();
        if (this.f8166a != internalClusterItem.f8166a) {
            if (this.f8166a <= internalClusterItem.f8166a) {
                return -1;
            }
            return 1;
        } else if (this.f8167b != internalClusterItem.f8167b) {
            if (this.f8167b <= internalClusterItem.f8167b) {
                return -1;
            }
            return 1;
        } else if (hashCode() == internalClusterItem.hashCode()) {
            return 0;
        } else {
            if (hashCode() <= internalClusterItem.hashCode()) {
                return -1;
            }
            return 1;
        }
    }

    public final void m14313a(double[] dArr) {
        m14312c();
        dArr[0] = this.f8166a;
        dArr[1] = this.f8167b;
    }

    private void m14312c() {
        LatLng a = this.f8169d.mo1081a();
        if (!a.equals(this.f8171f)) {
            this.f8171f = a;
            this.f8166a = Cluster.m14207a((double) Projection.d(this.f8171f.f8569b));
            this.f8167b = (double) Projection.b(this.f8171f.f8568a);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalClusterItem)) {
            return false;
        }
        return this.f8169d.equals(((InternalClusterItem) obj).f8169d);
    }

    public final int hashCode() {
        return this.f8169d.hashCode();
    }
}
