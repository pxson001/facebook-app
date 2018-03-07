package com.facebook.android.maps;

import android.graphics.Canvas;
import com.facebook.android.maps.ClusterAdapter.ClusterDrawableHolder;
import com.facebook.android.maps.FacebookMap.OnCameraChangeListener;
import com.facebook.android.maps.internal.GrandCentralDispatch;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.RectD;
import com.facebook.android.maps.internal.ValueAnimator;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorListener;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorUpdateListener;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.Marker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: backgroundPlaces */
public class ClusterOverlay<T extends ClusterItem> extends MapDrawable implements OnCameraChangeListener, MarkerInteractionHandler, AnimatorListener, AnimatorUpdateListener {
    private static final RectD f8091D = new RectD(0.0d, 0.0d, 1.0d, 1.0d);
    public final List<Cluster<T>> f8092A;
    public Dispatchable f8093B;
    public Dispatchable f8094C;
    public float f8095E;
    public final ArrayList<ClusterDrawableHolder> f8096F;
    private boolean f8097G;
    private CameraPosition f8098H;
    public ClusterAdapter<T> f8099o;
    public Map<ClusterDrawableHolder, Cluster<T>> f8100p;
    public final Set<Cluster<T>> f8101q;
    private ClusterDrawableHolder f8102r;
    private ClusterDrawableHolder f8103s;
    private OnClusterClickListener<T> f8104t;
    private OnClusterDoubleClickListener<T> f8105u;
    public final RectD f8106v;
    private final RectD f8107w;
    private final double[] f8108x;
    public ValueAnimator f8109y;
    public final List<Cluster<T>> f8110z;

    /* compiled from: backgroundPlaces */
    class C09082 extends Dispatchable {
        final /* synthetic */ ClusterOverlay f8074a;

        C09082(ClusterOverlay clusterOverlay) {
            this.f8074a = clusterOverlay;
        }

        public void run() {
            int i;
            int i2 = 0;
            this.f8074a.f8093B = null;
            this.f8074a.m14231f();
            float f = this.f8074a.f8080e.m14292c().f8547b;
            this.f8074a.f8101q.clear();
            ClusterAdapter clusterAdapter = this.f8074a.f8099o;
            RectD rectD = this.f8074a.f8106v;
            Projection projection = this.f8074a.f8081f;
            Set set = this.f8074a.f8101q;
            this.f8074a.f8110z.clear();
            for (Cluster cluster : this.f8074a.f8100p.values()) {
                for (i = 0; i < cluster.f8053b; i++) {
                    cluster.f8052a[i].f8170e = cluster;
                }
                this.f8074a.f8110z.add(cluster);
            }
            for (Cluster cluster2 : ClusterOverlay.m14245a(this.f8074a, this.f8074a.f8101q)) {
                MapDrawable mapDrawable = cluster2.f8068q;
                if (mapDrawable instanceof Marker) {
                    Cluster cluster3 = cluster2.f8052a[0].f8170e;
                    if (cluster3 == null) {
                        cluster3 = cluster2;
                    }
                    cluster2.f8067p = cluster3;
                    Marker marker = (Marker) mapDrawable;
                    marker.m14582a(0.0f);
                    marker.m14585a(cluster2.f8067p.m14212a());
                    this.f8074a.f8092A.add(cluster2);
                }
            }
            i = this.f8074a.f8110z.size();
            while (i2 < i) {
                ((Cluster) this.f8074a.f8110z.get(i2)).f8067p = null;
                i2++;
            }
            this.f8074a.f8110z.clear();
            if (!this.f8074a.f8092A.isEmpty()) {
                this.f8074a.f8109y = ValueAnimator.m14529a(0.0f, 1.0f);
                this.f8074a.f8109y.m14538a(500);
                this.f8074a.f8109y.m14541a(this.f8074a);
                this.f8074a.f8109y.m14542a(this.f8074a);
                this.f8074a.f8109y.m14543c();
            }
            this.f8074a.f8095E = f;
        }
    }

    /* compiled from: backgroundPlaces */
    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean m14216a();
    }

    /* compiled from: backgroundPlaces */
    public interface OnClusterDoubleClickListener<T extends ClusterItem> {
        boolean m14217a();
    }

    public final void mo1032a(Canvas canvas) {
        if (this.f8097G) {
            this.f8097G = false;
            final float f = this.f8080e.m14292c().f8547b;
            this.f8081f.a(this.f8107w);
            if (this.f8095E == f && this.f8106v.d(this.f8107w)) {
                m14247b(canvas);
                return;
            }
            if (f <= 5.0f) {
                this.f8106v.b = f8091D.b;
                this.f8106v.a = f8091D.a;
                this.f8106v.c = f8091D.c;
                this.f8106v.d = f8091D.d;
            } else {
                double d = this.f8107w.d - this.f8107w.c;
                double d2 = this.f8107w.b - this.f8107w.a;
                double d3 = this.f8107w.c - (d / 2.0d);
                d = (d / 2.0d) + this.f8107w.d;
                if (d - d3 >= 1.0d) {
                    this.f8106v.c = 0.0d;
                    this.f8106v.d = 1.0d;
                } else {
                    this.f8106v.c = Cluster.m14207a(d3);
                    this.f8106v.d = Cluster.m14207a(d);
                }
                this.f8106v.a = Math.max(0.0d, this.f8107w.a - (d2 / 2.0d));
                this.f8106v.b = Math.min(1.0d, (d2 / 2.0d) + this.f8107w.b);
            }
            if (this.f8095E == -1.0f || f <= this.f8095E) {
                if (this.f8109y != null) {
                    this.f8109y.m14544d();
                }
                if (this.f8093B != null) {
                    GrandCentralDispatch.d(this.f8093B);
                    this.f8093B = null;
                }
                if (this.f8094C == null) {
                    this.f8094C = new Dispatchable(this) {
                        final /* synthetic */ ClusterOverlay f8073b;

                        public void run() {
                            this.f8073b.f8094C = null;
                            this.f8073b.f8101q.clear();
                            ClusterAdapter clusterAdapter = this.f8073b.f8099o;
                            RectD rectD = this.f8073b.f8106v;
                            Projection projection = this.f8073b.f8081f;
                            Set set = this.f8073b.f8101q;
                            ClusterOverlay.m14245a(this.f8073b, this.f8073b.f8101q);
                            this.f8073b.f8095E = f;
                        }
                    };
                    GrandCentralDispatch.b(this.f8094C, 150);
                }
            } else {
                if (this.f8094C != null) {
                    GrandCentralDispatch.d(this.f8094C);
                    this.f8094C = null;
                }
                if (this.f8109y == null && this.f8093B == null) {
                    this.f8093B = new C09082(this);
                    GrandCentralDispatch.b(this.f8093B, 400);
                }
            }
            m14247b(canvas);
            return;
        }
        m14247b(canvas);
    }

    public static Set m14245a(ClusterOverlay clusterOverlay, Set set) {
        Iterator it = clusterOverlay.f8100p.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ClusterDrawableHolder clusterDrawableHolder = (ClusterDrawableHolder) entry.getKey();
            Cluster cluster = (Cluster) entry.getValue();
            cluster.m14213a(clusterOverlay.f8108x);
            if (!clusterOverlay.f8106v.a(clusterOverlay.f8108x[0], clusterOverlay.f8108x[1]) || !set.remove(cluster)) {
                it.remove();
                if (clusterDrawableHolder == clusterOverlay.f8102r) {
                    clusterOverlay.m14246a(null);
                }
                if (clusterDrawableHolder.f8069a instanceof Marker) {
                    ((Marker) clusterDrawableHolder.f8069a).f8591H = null;
                }
                if (clusterDrawableHolder.f8071c) {
                    clusterOverlay.f8096F.add(clusterDrawableHolder);
                }
            }
        }
        for (Cluster cluster2 : set) {
            cluster2.m14213a(clusterOverlay.f8108x);
            double d = clusterOverlay.f8108x[0];
            double d2 = clusterOverlay.f8108x[1];
            if (cluster2.f8053b != 0 && clusterOverlay.f8106v.a(d, d2)) {
                int a = clusterOverlay.f8099o.m14214a();
                if (!clusterOverlay.f8096F.isEmpty()) {
                    for (int size = clusterOverlay.f8096F.size() - 1; size >= 0; size--) {
                        clusterDrawableHolder = (ClusterDrawableHolder) clusterOverlay.f8096F.get(size);
                        if (clusterDrawableHolder.f8070b == a) {
                            clusterOverlay.f8096F.remove(size);
                            break;
                        }
                    }
                }
                clusterDrawableHolder = null;
                if (clusterDrawableHolder == null) {
                    clusterDrawableHolder = clusterOverlay.f8099o.m14215b();
                }
                cluster2.f8068q = clusterDrawableHolder.f8069a;
                clusterOverlay.f8100p.put(clusterDrawableHolder, cluster2);
                if (clusterDrawableHolder.f8069a instanceof Marker) {
                    ((Marker) clusterDrawableHolder.f8069a).f8591H = clusterOverlay;
                }
                clusterDrawableHolder.f8069a.mo1036b();
            }
        }
        return set;
    }

    private void m14247b(Canvas canvas) {
        for (ClusterDrawableHolder clusterDrawableHolder : this.f8100p.keySet()) {
            if (clusterDrawableHolder != this.f8102r && clusterDrawableHolder.f8069a.f8084i) {
                clusterDrawableHolder.f8069a.mo1032a(canvas);
            }
        }
        if (this.f8102r != null && this.f8102r.f8069a.f8084i) {
            this.f8102r.f8069a.mo1032a(canvas);
        }
    }

    public final void mo1033a(ValueAnimator valueAnimator) {
        int size = this.f8092A.size();
        for (int i = 0; i < size; i++) {
            Cluster cluster = (Cluster) this.f8092A.get(i);
            Marker marker = (Marker) cluster.f8068q;
            LatLng a = cluster.f8067p.m14212a();
            LatLng a2 = cluster.m14212a();
            float f = valueAnimator.f8503C;
            marker.m14585a(new LatLng(((a2.f8568a - a.f8568a) * ((double) f)) + a.f8568a, Cluster.m14208b((Cluster.m14208b(a2.f8569b - a.f8569b) * ((double) f)) + a.f8569b)));
            marker.m14582a(f);
        }
    }

    public final void mo1037b(ValueAnimator valueAnimator) {
        m14248d(valueAnimator);
    }

    public final void mo1040c(ValueAnimator valueAnimator) {
        m14248d(valueAnimator);
    }

    private void m14248d(ValueAnimator valueAnimator) {
        int size = this.f8092A.size();
        for (int i = 0; i < size; i++) {
            Cluster cluster = (Cluster) this.f8092A.get(i);
            Marker marker = (Marker) cluster.f8068q;
            marker.m14585a(cluster.m14212a());
            marker.m14582a(1.0f);
            cluster.f8067p = null;
        }
        this.f8092A.clear();
        valueAnimator.m14539a();
        this.f8109y = null;
    }

    public final void mo1036b() {
        for (ClusterDrawableHolder clusterDrawableHolder : this.f8100p.keySet()) {
            clusterDrawableHolder.f8069a.mo1036b();
        }
    }

    public final int mo1031a(float f, float f2) {
        this.f8103s = null;
        int i = 0;
        for (ClusterDrawableHolder clusterDrawableHolder : this.f8100p.keySet()) {
            int i2;
            if (clusterDrawableHolder.f8069a.f8084i) {
                int a = clusterDrawableHolder.f8069a.mo1031a(f, f2);
                if (a == 2) {
                    this.f8103s = clusterDrawableHolder;
                    return 2;
                } else if (a > i) {
                    this.f8103s = clusterDrawableHolder;
                    i2 = a;
                    i = i2;
                }
            }
            i2 = i;
            i = i2;
        }
        return i;
    }

    public final void mo1034a(CameraPosition cameraPosition) {
        if (!cameraPosition.equals(this.f8098H)) {
            this.f8097G = true;
        }
        this.f8098H = cameraPosition;
    }

    public final void mo1043d() {
        this.f8080e.f8134h.remove(this);
    }

    public final boolean mo1038b(float f, float f2) {
        if (this.f8103s == null || !this.f8103s.f8069a.mo1038b(f, f2)) {
            return false;
        }
        m14246a(this.f8103s);
        return true;
    }

    public final void mo1045e() {
        m14246a(null);
    }

    public final boolean mo1041c(float f, float f2) {
        return this.f8103s != null && this.f8103s.f8069a.mo1041c(f, f2);
    }

    public final boolean mo1035a(Marker marker) {
        return false;
    }

    public final boolean mo1039b(Marker marker) {
        if (this.f8104t != null) {
            OnClusterClickListener onClusterClickListener = this.f8104t;
            this.f8100p.get(this.f8103s);
            if (onClusterClickListener.m14216a()) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo1042c(Marker marker) {
        if (this.f8105u != null) {
            OnClusterDoubleClickListener onClusterDoubleClickListener = this.f8105u;
            this.f8100p.get(this.f8103s);
            if (onClusterDoubleClickListener.m14217a()) {
                return true;
            }
        }
        return false;
    }

    public final void mo1044d(Marker marker) {
        m14231f();
    }

    private void m14246a(ClusterDrawableHolder clusterDrawableHolder) {
        if (!(this.f8102r == null || this.f8102r == clusterDrawableHolder)) {
            this.f8102r.f8069a.mo1045e();
        }
        this.f8102r = clusterDrawableHolder;
    }
}
