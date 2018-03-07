package com.facebook.android.maps;

import android.content.Context;
import android.graphics.Matrix;
import android.location.Location;
import com.facebook.android.maps.internal.CompassDrawable;
import com.facebook.android.maps.internal.MapTileOverlay;
import com.facebook.android.maps.internal.MapTileProvider;
import com.facebook.android.maps.internal.MyLocationButtonDrawable;
import com.facebook.android.maps.internal.MyLocationDrawable;
import com.facebook.android.maps.internal.MyLocationHelper;
import com.facebook.android.maps.internal.ValueAnimator;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorListener;
import com.facebook.android.maps.internal.ValueAnimator.AnimatorUpdateListener;
import com.facebook.android.maps.internal.ZoomControlsDrawable;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.Marker;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.maps.delegate.MapDelegate.13;
import com.facebook.maps.delegate.MapDelegate.17;
import com.facebook.maps.delegate.MapDelegate.19;
import com.facebook.maps.delegate.MapDelegate.3;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.storelocator.StoreLocatorActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: background */
public final class FacebookMap implements MarkerInteractionHandler, AnimatorListener, AnimatorUpdateListener {
    public MapView f8112A;
    public final int f8113B;
    private final float[] f8114C = new float[2];
    private final Matrix f8115D = new Matrix();
    public final UiSettings f8116E;
    private 19 f8117F;
    private boolean f8118G = false;
    private ValueAnimator f8119H;
    private ValueAnimator f8120I;
    private ValueAnimator f8121J;
    private ValueAnimator f8122K;
    private float f8123L;
    private float f8124M;
    public 17 f8125N;
    public OnMyLocationChangeListener f8126O;
    public float f8127a = 19.0f;
    public float f8128b = 2.0f;
    public int f8129c;
    public int f8130d;
    public int f8131e;
    public int f8132f;
    public OnCameraChangeListener f8133g;
    public final ArrayList<OnCameraChangeListener> f8134h = new ArrayList();
    final List<MapDrawable> f8135i = new ArrayList();
    public final MyLocationHelper f8136j;
    public final Projection f8137k;
    final MapTileOverlay f8138l;
    public OnMarkerClickListener f8139m;
    OnMarkerDoubleClickListener f8140n;
    public 13 f8141o;
    public 3 f8142p;
    OnMapLongClickListener f8143q;
    OnMapDoubleClickListener f8144r;
    public StoreLocatorActivity.3 f8145s;
    OnMapLoadedCallback f8146t;
    ZoomControlsDrawable f8147u;
    MyLocationButtonDrawable f8148v;
    public MyLocationDrawable f8149w;
    CompassDrawable f8150x;
    private MapDrawable f8151y;
    public final Context f8152z;

    /* compiled from: background */
    public interface OnCameraChangeListener {
        void mo1034a(CameraPosition cameraPosition);
    }

    /* compiled from: background */
    public interface OnMyLocationChangeListener {
        void mo1046a(Location location);
    }

    /* compiled from: background */
    class C09091 implements OnMyLocationChangeListener {
        final /* synthetic */ FacebookMap f8111a;

        C09091(FacebookMap facebookMap) {
            this.f8111a = facebookMap;
        }

        public final void mo1046a(Location location) {
            this.f8111a.m14308s();
            if (this.f8111a.f8126O != null) {
                this.f8111a.f8126O.mo1046a(location);
            }
        }
    }

    /* compiled from: background */
    public interface OnMapDoubleClickListener {
        boolean m14270a();
    }

    /* compiled from: background */
    public interface OnMapLoadedCallback {
        void m14271a();
    }

    /* compiled from: background */
    public interface OnMapLongClickListener {
    }

    /* compiled from: background */
    public interface OnMarkerClickListener {
        boolean m14272a(Marker marker);
    }

    /* compiled from: background */
    public interface OnMarkerDoubleClickListener {
        boolean m14273a();
    }

    protected FacebookMap(MapView mapView, FacebookMapOptions facebookMapOptions) {
        this.f8112A = mapView;
        this.f8152z = mapView.getContext().getApplicationContext();
        this.f8137k = new Projection(this);
        this.f8116E = new UiSettings(this);
        MapsInitializer.m14383a(this.f8152z);
        this.f8113B = this.f8152z.getResources().getDisplayMetrics().densityDpi >= 320 ? 512 : 256;
        this.f8138l = (MapTileOverlay) m14277a(new MapTileOverlay(this, new MapTileProvider(this.f8152z, this.f8113B, this.f8113B)));
        this.f8136j = new MyLocationHelper(this.f8112A.getContext());
        MyLocationHelper myLocationHelper = this.f8136j;
        myLocationHelper.f = new C09091(this);
        if (!(myLocationHelper.f == null || myLocationHelper.d == null || !myLocationHelper.e)) {
            myLocationHelper.f.mo1046a(myLocationHelper.d);
        }
        if (facebookMapOptions != null) {
            this.f8116E.m14411a(facebookMapOptions.f8154b);
            this.f8116E.f8283b = facebookMapOptions.f8156d;
            this.f8116E.f8284c = facebookMapOptions.f8157e;
            this.f8116E.f8285d = facebookMapOptions.f8158f;
            this.f8116E.m14413f(facebookMapOptions.f8161i);
            this.f8116E.f8286e = facebookMapOptions.f8162j;
            this.f8127a = m14274c(facebookMapOptions.f8164l);
            this.f8128b = m14274c(facebookMapOptions.f8163k);
            MapDrawable mapDrawable = this.f8138l;
            int i = facebookMapOptions.f8155c;
            if (i != mapDrawable.f8444D) {
                mapDrawable.f8444D = i;
                if (i == 0) {
                    mapDrawable.mo1064a(false);
                    return;
                }
                if (!mapDrawable.f8084i) {
                    mapDrawable.mo1064a(true);
                }
                MapTileProvider mapTileProvider = mapDrawable.f8441A;
                if (i == 5) {
                    mapTileProvider.f8448g = "live_maps";
                } else {
                    mapTileProvider.f8448g = null;
                }
                mapDrawable.f8080e.m14309t();
                mapDrawable.f8080e.f8112A.invalidate();
            }
        }
    }

    public final Marker m14278a(MarkerOptions markerOptions) {
        Marker marker = (Marker) m14277a(new Marker(this, markerOptions));
        marker.f8591H = this;
        return marker;
    }

    public final <T extends MapDrawable> T m14277a(T t) {
        int binarySearch = Collections.binarySearch(this.f8135i, t, MapDrawable.f8075a);
        if (binarySearch <= 0) {
            this.f8135i.add(-1 - binarySearch, t);
            t.mo1036b();
            m14308s();
        }
        return t;
    }

    public final void m14289b(MapDrawable mapDrawable) {
        mapDrawable.mo1043d();
        this.f8135i.remove(mapDrawable);
        m14308s();
    }

    public final void m14282a(CameraUpdate cameraUpdate, int i, 19 19) {
        if (!this.f8112A.f8221q) {
            double b;
            if (i != 0) {
                this.f8138l.m14406b(true);
            }
            m14279a();
            this.f8118G = true;
            float k = m14303k();
            float l = m14304l();
            float zoom = this.f8112A.getZoom();
            this.f8123L = k;
            this.f8124M = l;
            if (cameraUpdate.f8039b != -2.14748365E9f) {
                zoom = cameraUpdate.f8039b;
            } else if (cameraUpdate.f8040c != -2.14748365E9f) {
                zoom += cameraUpdate.f8040c;
                if (!(cameraUpdate.f8041d == -2.14748365E9f && cameraUpdate.f8042e == -2.14748365E9f)) {
                    this.f8123L = cameraUpdate.f8041d;
                    this.f8124M = cameraUpdate.f8042e;
                }
            } else if (cameraUpdate.f8046i != null) {
                LatLngBounds latLngBounds = cameraUpdate.f8046i;
                int u = cameraUpdate.f8047j > 0 ? cameraUpdate.f8047j : m14275u();
                int v = cameraUpdate.f8048k > 0 ? cameraUpdate.f8048k : m14276v();
                if (u == 0 && v == 0) {
                    throw new IllegalStateException("Error using newLatLngBounds(LatLngBounds, int): Map size can't be 0. Most likely, layout has not yet occured for the map view.  Either wait until layout has occurred or use newLatLngBounds(LatLngBounds, int, int, int) which allows you to specify the map's dimensions.");
                }
                int i2 = cameraUpdate.f8049l * 2;
                if (u + i2 > m14275u()) {
                    u = m14275u() - i2;
                }
                if (v + i2 > m14276v()) {
                    v = m14276v() - i2;
                }
                zoom = Math.min((float) (Math.log((double) ((((float) Math.max(0, u)) / Math.abs(Projection.d(latLngBounds.f8576b.f8569b) - Projection.d(latLngBounds.f8577c.f8569b))) / ((float) this.f8113B))) / MapView.f8184a), (float) (Math.log((double) ((((float) Math.max(0, v)) / Math.abs(Projection.b(latLngBounds.f8577c.f8568a) - Projection.b(latLngBounds.f8576b.f8568a))) / ((float) this.f8113B))) / MapView.f8184a));
            }
            float max = Math.max(this.f8128b, Math.min(this.f8127a, zoom));
            double d = this.f8112A.f8217m;
            double d2 = this.f8112A.f8218n;
            if (cameraUpdate.f8038a != null || cameraUpdate.f8046i != null) {
                LatLng latLng;
                if (cameraUpdate.f8038a != null) {
                    latLng = cameraUpdate.f8038a;
                } else {
                    latLng = cameraUpdate.f8046i.m14573b();
                }
                d2 = (double) Projection.d(latLng.f8569b);
                b = (double) Projection.b(latLng.f8568a);
                this.f8114C[0] = this.f8112A.f8209e - k;
                this.f8114C[1] = this.f8112A.f8210f - l;
                if (!(this.f8114C[0] == 0.0f && this.f8114C[1] == 0.0f)) {
                    int i3 = (1 << ((int) max)) * this.f8113B;
                    float f = (max % 1.0f) + 1.0f;
                    this.f8115D.setScale(f, f);
                    this.f8115D.postRotate(this.f8112A.f8214j);
                    this.f8115D.invert(this.f8115D);
                    this.f8115D.mapVectors(this.f8114C);
                    d2 += (double) (this.f8114C[0] / ((float) i3));
                    b += (double) (this.f8114C[1] / ((float) i3));
                }
            } else if (cameraUpdate.f8043f == -2.14748365E9f && cameraUpdate.f8044g == -2.14748365E9f) {
                b = d2;
                d2 = d;
            } else {
                b = ((double) (cameraUpdate.f8044g != -2.14748365E9f ? cameraUpdate.f8044g / ((float) this.f8112A.f8222r) : 0.0f)) + d2;
                d2 = d + ((double) (cameraUpdate.f8043f != -2.14748365E9f ? cameraUpdate.f8043f / ((float) this.f8112A.f8222r) : 0.0f));
            }
            float f2 = this.f8112A.f8214j;
            if (cameraUpdate.f8045h != -2.14748365E9f) {
                f2 = cameraUpdate.f8045h % 360.0f;
                if (this.f8112A.f8214j - f2 > 180.0f) {
                    f2 += 360.0f;
                } else if (f2 - this.f8112A.f8214j > 180.0f) {
                    f2 -= 360.0f;
                }
            }
            d2 = MapView.m14336a(d2);
            double a = this.f8112A.m14358a(b, (long) ((1 << ((int) max)) * this.f8113B));
            if (i <= 0) {
                if (max != this.f8112A.getZoom()) {
                    this.f8112A.m14372c(max, this.f8123L, this.f8124M);
                }
                if (!(d2 == this.f8112A.f8217m && a == this.f8112A.f8218n)) {
                    this.f8112A.m14359a(d2, a);
                }
                if (f2 != this.f8112A.f8214j) {
                    this.f8112A.m14374d(f2, k, l);
                }
                m14308s();
                m14307q();
            } else {
                this.f8117F = 19;
                if (max != this.f8112A.getZoom()) {
                    this.f8121J = ValueAnimator.m14529a(this.f8112A.getZoom(), max);
                    this.f8121J.m14541a((AnimatorListener) this);
                    this.f8121J.m14542a((AnimatorUpdateListener) this);
                    this.f8121J.m14538a((long) i);
                }
                if (d2 != this.f8112A.f8217m) {
                    b = d2 - this.f8112A.f8217m;
                    b = b > 0.5d ? d2 - 1.0d : b < -0.5d ? 1.0d + d2 : d2;
                    this.f8119H = ValueAnimator.m14529a((float) this.f8112A.f8217m, (float) b);
                    this.f8119H.m14541a((AnimatorListener) this);
                    this.f8119H.m14542a((AnimatorUpdateListener) this);
                    this.f8119H.m14538a((long) i);
                }
                if (a != this.f8112A.f8218n) {
                    this.f8120I = ValueAnimator.m14529a((float) this.f8112A.f8218n, (float) a);
                    this.f8120I.m14541a((AnimatorListener) this);
                    this.f8120I.m14542a((AnimatorUpdateListener) this);
                    this.f8120I.m14538a((long) i);
                }
                if (f2 != this.f8112A.f8214j) {
                    this.f8122K = ValueAnimator.m14529a(this.f8112A.f8214j, f2);
                    this.f8122K.m14541a((AnimatorListener) this);
                    this.f8122K.m14542a((AnimatorUpdateListener) this);
                    this.f8122K.m14538a((long) i);
                }
                if (this.f8119H != null) {
                    this.f8119H.m14543c();
                }
                if (this.f8120I != null) {
                    this.f8120I.m14543c();
                }
                if (this.f8121J != null) {
                    this.f8121J.m14543c();
                }
                if (this.f8122K != null) {
                    this.f8122K.m14543c();
                }
            }
            if (this.f8119H == null && this.f8120I == null && this.f8121J == null && this.f8122K == null && 19 != null) {
                this.f8117F = null;
                19.b();
            }
        }
    }

    public final void m14281a(CameraUpdate cameraUpdate) {
        m14282a(cameraUpdate, 1500, null);
    }

    public final void m14279a() {
        if (this.f8119H != null) {
            this.f8119H.m14544d();
        }
        if (this.f8120I != null) {
            this.f8120I.m14544d();
        }
        if (this.f8121J != null) {
            this.f8121J.m14544d();
        }
        if (this.f8122K != null) {
            this.f8122K.m14544d();
        }
    }

    public final void m14287b() {
        Iterator it = this.f8135i.iterator();
        while (it.hasNext()) {
            MapDrawable mapDrawable = (MapDrawable) it.next();
            if (mapDrawable.f8085j == 1 || mapDrawable.f8085j == 2) {
                it.remove();
            }
        }
        m14308s();
    }

    public final CameraPosition m14292c() {
        this.f8114C[0] = this.f8112A.f8209e - m14303k();
        this.f8114C[1] = this.f8112A.f8210f - m14304l();
        this.f8112A.f8216l.mapVectors(this.f8114C);
        return new CameraPosition(new LatLng(Projection.a(this.f8112A.f8218n - ((double) (this.f8114C[1] / ((float) this.f8112A.f8222r)))), Projection.c(this.f8112A.f8217m - ((double) (this.f8114C[0] / ((float) this.f8112A.f8222r))))), this.f8112A.getZoom(), 0.0f, this.f8112A.f8214j);
    }

    public final int m14296d() {
        return this.f8113B;
    }

    public final Location m14298e() {
        return this.f8136j.d;
    }

    public final Context m14299f() {
        return this.f8152z;
    }

    public final MapView m14300g() {
        return this.f8112A;
    }

    public final Projection m14301h() {
        return this.f8137k;
    }

    public final boolean m14302j() {
        return this.f8149w != null;
    }

    public final void m14285a(boolean z) {
        this.f8136j.a(z);
        if (z && this.f8149w == null) {
            this.f8149w = new MyLocationDrawable(this);
            m14277a(this.f8149w);
            MyLocationDrawable myLocationDrawable = this.f8149w;
            if (!myLocationDrawable.f8471r.f8519s) {
                myLocationDrawable.f8471r.m14543c();
            }
        } else if (!(z || this.f8149w == null)) {
            this.f8149w.m14511p();
            m14289b(this.f8149w);
            this.f8149w = null;
        }
        this.f8116E.m14412e();
    }

    public final void m14288b(CameraUpdate cameraUpdate) {
        m14282a(cameraUpdate, 0, null);
    }

    public final void m14280a(int i, int i2, int i3, int i4) {
        this.f8112A.m14359a(this.f8112A.f8217m + ((double) (((long) ((this.f8129c - this.f8131e) - (i - i3))) / (this.f8112A.f8222r << 1))), this.f8112A.f8218n + ((double) (((long) ((this.f8130d - this.f8132f) - (i2 - i4))) / (this.f8112A.f8222r << 1))));
        this.f8129c = i;
        this.f8130d = i2;
        this.f8131e = i3;
        this.f8132f = i4;
        this.f8112A.requestLayout();
        m14308s();
    }

    private int m14275u() {
        return (this.f8112A.f8207c - this.f8129c) - this.f8131e;
    }

    private int m14276v() {
        return (this.f8112A.f8208d - this.f8130d) - this.f8132f;
    }

    public final float m14303k() {
        return ((float) this.f8129c) + (((float) m14275u()) / 2.0f);
    }

    public final float m14304l() {
        return ((float) this.f8130d) + (((float) m14276v()) / 2.0f);
    }

    public final void m14283a(OnMapLoadedCallback onMapLoadedCallback) {
        this.f8146t = onMapLoadedCallback;
        if (this.f8112A.f8206b) {
            m14306p();
        }
    }

    public final void mo1033a(ValueAnimator valueAnimator) {
        if (valueAnimator == this.f8119H) {
            this.f8112A.m14359a((double) this.f8119H.f8503C, this.f8112A.f8218n);
            m14308s();
        } else if (valueAnimator == this.f8120I) {
            this.f8112A.m14359a(this.f8112A.f8217m, (double) this.f8120I.f8503C);
            m14308s();
        } else if (valueAnimator == this.f8121J) {
            this.f8112A.m14372c(valueAnimator.f8503C, this.f8123L, this.f8124M);
            m14308s();
        } else if (valueAnimator == this.f8122K) {
            this.f8112A.m14374d(valueAnimator.f8503C, m14303k(), m14304l());
            m14308s();
        }
    }

    public final void mo1037b(ValueAnimator valueAnimator) {
        if (valueAnimator == this.f8119H) {
            this.f8119H = null;
        } else if (valueAnimator == this.f8120I) {
            this.f8120I = null;
        } else if (valueAnimator == this.f8121J) {
            this.f8121J = null;
        } else if (valueAnimator == this.f8122K) {
            this.f8122K = null;
        }
        valueAnimator.m14539a();
        if (this.f8118G && this.f8119H == null && this.f8120I == null && this.f8121J == null && this.f8122K == null) {
            this.f8118G = false;
            if (this.f8117F != null) {
                19 19 = this.f8117F;
                this.f8117F = null;
                19.b();
            }
            m14307q();
        }
    }

    public final void mo1040c(ValueAnimator valueAnimator) {
        if (valueAnimator == this.f8119H) {
            this.f8119H = null;
        } else if (valueAnimator == this.f8120I) {
            this.f8120I = null;
        } else if (valueAnimator == this.f8121J) {
            this.f8121J = null;
        } else if (valueAnimator == this.f8122K) {
            this.f8122K = null;
        }
        valueAnimator.m14539a();
        if (this.f8119H == null && this.f8120I == null && this.f8121J == null && this.f8122K == null) {
            this.f8118G = false;
            if (this.f8117F != null) {
                19 19 = this.f8117F;
                this.f8117F = null;
                19.a.a();
            }
            m14307q();
        }
    }

    final void m14305n() {
        this.f8128b = Math.max(this.f8128b, this.f8112A.f8213i);
    }

    final void m14306p() {
        if (this.f8146t != null) {
            this.f8146t.m14271a();
            this.f8146t = null;
        }
    }

    final void m14307q() {
        if (this.f8133g != null || !this.f8134h.isEmpty()) {
            CameraPosition c = m14292c();
            if (this.f8133g != null) {
                this.f8133g.mo1034a(c);
            }
            if (!this.f8134h.isEmpty()) {
                Iterator it = this.f8134h.iterator();
                while (it.hasNext()) {
                    ((OnCameraChangeListener) it.next()).mo1034a(c);
                }
            }
        }
    }

    public final boolean mo1035a(Marker marker) {
        if (this.f8141o == null) {
            return false;
        }
        this.f8141o.a.a(MarkerDelegate.a(marker));
        return true;
    }

    public final boolean mo1039b(Marker marker) {
        return this.f8139m != null && this.f8139m.m14272a(marker);
    }

    public final boolean mo1042c(Marker marker) {
        return this.f8140n != null && this.f8140n.m14273a();
    }

    public final void mo1044d(Marker marker) {
        m14289b((MapDrawable) marker);
        m14277a((MapDrawable) marker);
    }

    protected final void m14308s() {
        this.f8112A.invalidate();
    }

    public static float m14274c(float f) {
        return Math.min(Math.max(f, 2.0f), 19.0f);
    }

    public final void m14309t() {
        int size = this.f8135i.size();
        for (int i = 0; i < size; i++) {
            MapDrawable mapDrawable = (MapDrawable) this.f8135i.get(i);
            if (mapDrawable instanceof TiledMapDrawable) {
                ((TiledMapDrawable) mapDrawable).mo1072p();
            } else if (mapDrawable instanceof ClusterOverlay) {
                ((ClusterOverlay) mapDrawable).f8096F.clear();
            }
        }
    }

    public final void m14293c(MapDrawable mapDrawable) {
        if (!(this.f8151y == null || this.f8151y == mapDrawable)) {
            this.f8151y.mo1045e();
        }
        this.f8151y = mapDrawable;
    }
}
