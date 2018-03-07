package com.facebook.maps;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.MapFragment.OnMapReadyListener;
import com.facebook.nearby.places.NearbyMapAreaFragment.12;
import com.facebook.nearby.places.NearbyMapAreaFragment.9;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.ItemizedOverlay.OnFocusChangeListener;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

/* compiled from: wifi_scan_results */
public class GoogleMapFragment extends MapFragment {
    private LocalActivityManager f213a;
    private int al = -1;
    private Location am = null;
    private OnTouchListener an = null;
    private 9 ao;
    private 12 ap;
    private OnMapReadyListener aq;
    private String ar = null;
    private boolean as = false;
    public List<SettableFuture<Location>> at = new CopyOnWriteArrayList();
    private LinkedList<SelectableOverlayItem> au = Lists.b();
    private boolean av = false;
    private boolean aw = true;
    private GoogleEmbeddableMapActivity f214b;
    public FacebookMapView f215c;
    private FrameLayout f216d;
    public FixedMyLocationOverlay f217e = null;
    private AddedOverlaysItemizedOverlay f218f;
    public SelectableOverlayItem f219g;
    public GoogleMapsV1Util f220h;
    private boolean f221i = true;

    /* compiled from: wifi_scan_results */
    class C00321 implements OnFocusChangeListener {
        final /* synthetic */ GoogleMapFragment f199a;

        C00321(GoogleMapFragment googleMapFragment) {
            this.f199a = googleMapFragment;
        }

        public void onFocusChanged(ItemizedOverlay itemizedOverlay, OverlayItem overlayItem) {
            SelectableOverlayItem selectableOverlayItem = (SelectableOverlayItem) overlayItem;
            GoogleMapFragment googleMapFragment = this.f199a;
            if (selectableOverlayItem != null) {
                if (googleMapFragment.f219g != null) {
                    googleMapFragment.f219g.m173b();
                }
                selectableOverlayItem.f210a = true;
                selectableOverlayItem.f211b.m229a();
                googleMapFragment.f219g = selectableOverlayItem;
            } else if (googleMapFragment.f219g != null) {
                googleMapFragment.f219g.m173b();
                googleMapFragment.f219g = null;
            }
            this.f199a.f215c.invalidate();
        }
    }

    /* compiled from: wifi_scan_results */
    class C00354 implements Runnable {
        final /* synthetic */ GoogleMapFragment f204a;

        C00354(GoogleMapFragment googleMapFragment) {
            this.f204a = googleMapFragment;
        }

        public void run() {
            for (SettableFuture a : this.f204a.at) {
                FutureDetour.a(a, this.f204a.f217e.getLastFix(), 311588110);
            }
            this.f204a.at = null;
        }
    }

    /* compiled from: wifi_scan_results */
    public class AddedOverlaysItemizedOverlay extends ItemizedOverlay<OverlayItem> {
        private final boolean f205a;
        public 12 f206b;
        private List<OverlayItem> f207c = Lists.a();

        public AddedOverlaysItemizedOverlay(Drawable drawable, boolean z) {
            super(drawable);
            populate();
            this.f205a = z;
        }

        public final void m168a(OverlayItem overlayItem) {
            this.f207c.add(overlayItem);
            setFocus(null);
            setLastFocusedIndex(-1);
            populate();
        }

        public final void m169b(OverlayItem overlayItem) {
            this.f207c.remove(overlayItem);
            setFocus(null);
            setLastFocusedIndex(-1);
            populate();
        }

        public void draw(Canvas canvas, MapView mapView, boolean z) {
            if (!z || this.f205a) {
                super.draw(canvas, mapView, z);
            }
        }

        public int size() {
            return this.f207c.size();
        }

        protected OverlayItem createItem(int i) {
            return (OverlayItem) this.f207c.get(i);
        }

        protected boolean onTap(int i) {
            super.onTap(i);
            return true;
        }

        public boolean onTap(GeoPoint geoPoint, MapView mapView) {
            if (super.onTap(geoPoint, mapView) || this.f206b == null) {
                return false;
            }
            this.f206b.a.aP.aB.m8664g();
            return true;
        }
    }

    /* compiled from: wifi_scan_results */
    public class GoogleMapOverlayElement {
        public final /* synthetic */ GoogleMapFragment f208a;
        public SelectableOverlayItem f209b;

        public GoogleMapOverlayElement(GoogleMapFragment googleMapFragment, SelectableOverlayItem selectableOverlayItem) {
            this.f208a = googleMapFragment;
            this.f209b = selectableOverlayItem;
        }

        public final void m171a(MapFragment$MapOverlayElement$OnSelectedListener mapFragment$MapOverlayElement$OnSelectedListener) {
            this.f209b.f211b = mapFragment$MapOverlayElement$OnSelectedListener;
        }

        public final void m170a(DraweeHolder<GenericDraweeHierarchy> draweeHolder) {
            this.f209b.f212c = draweeHolder;
        }

        public final void m172b() {
            SelectableOverlayItem selectableOverlayItem = this.f209b;
            if (selectableOverlayItem.f212c != null) {
                selectableOverlayItem.f212c.d();
            }
        }
    }

    /* compiled from: wifi_scan_results */
    public class SelectableOverlayItem extends OverlayItem {
        public boolean f210a = false;
        public MapFragment$MapOverlayElement$OnSelectedListener f211b;
        public DraweeHolder<GenericDraweeHierarchy> f212c;

        public SelectableOverlayItem(GeoPoint geoPoint, Drawable drawable, String str, String str2) {
            super(geoPoint, str, str2);
            setMarker(drawable);
        }

        public final void m173b() {
            this.f210a = false;
            this.f211b.m230b();
        }

        public Drawable getMarker(int i) {
            int i2 = ((i & 4) == 0 && (i & 2) == 0) ? 0 : 1;
            if (i2 == 0 || this.f210a) {
                return super.getMarker(i);
            }
            return super.getMarker(0);
        }
    }

    public static void m190a(Object obj, Context context) {
        ((GoogleMapFragment) obj).f220h = GoogleMapsV1Util.m213b(FbInjector.get(context));
    }

    public final void m209c(Bundle bundle) {
        super.c(bundle);
        Class cls = GoogleMapFragment.class;
        m190a((Object) this, getContext());
        this.ar = (String) Preconditions.checkNotNull(this.s.getString("apiKey"), "Must call #setMapApiKey with a valid key before instantiating the fragment");
        this.aw = this.s.getBoolean("overlayShadowDrawingEnabled");
        Bundle bundle2 = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("activityManagerSavedInstanceState");
            this.f221i = bundle.getBoolean("clickable");
            this.as = bundle.getBoolean("showLocation");
            this.al = bundle.getInt("latestMapZoom");
            this.am = (Location) bundle.getParcelable("latestMapCenter");
            bundle2 = bundle3;
        }
        this.f213a = new LocalActivityManager(ao(), false);
        this.f213a.dispatchCreate(bundle2);
    }

    public final View m194a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1156577609);
        this.f216d = new FrameLayout(getContext());
        aA();
        View view = this.f216d;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2033239737, a);
        return view;
    }

    public final void m212e(Bundle bundle) {
        super.e(bundle);
        bundle.putBundle("activityManagerSavedInstanceState", this.f213a.saveInstanceState());
        bundle.putBoolean("clickable", this.f221i);
        bundle.putBoolean("showLocation", this.as);
        bundle.putInt("latestMapZoom", this.f215c == null ? this.al : this.f215c.getZoomLevel());
        bundle.putParcelable("latestMapCenter", this.f215c == null ? this.am : Locations.m227a(this.f215c.getMapCenter()));
    }

    public final void m191G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -44320384);
        super.G();
        this.av = true;
        if (this.f217e != null) {
            this.f217e.enableMyLocation();
        }
        if (!this.K) {
            aA();
            this.f213a.dispatchResume();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 61461891, a);
    }

    public final void m192H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2051643927);
        super.H();
        this.av = false;
        if (this.f217e != null) {
            this.f217e.disableMyLocation();
        }
        if (!this.K) {
            this.f213a.dispatchPause(ao().isFinishing());
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 814239332, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 555059897);
        super.mj_();
        this.f213a.dispatchStop();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1533064402, a);
    }

    public final void m193I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1000211157);
        super.I();
        if (this.f218f != null) {
            this.f218f.setOnFocusChangeListener(null);
        }
        this.f213a.dispatchDestroy(ao().isFinishing());
        this.at = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1842193160, a);
    }

    private void aA() {
        if (this.f214b == null && this.f220h.m214a()) {
            Intent intent = new Intent().setClass(getContext(), GoogleEmbeddableMapActivity.class);
            intent.putExtra("API_KEY", this.ar);
            Window startActivity = this.f213a.startActivity("map", intent);
            this.f214b = (GoogleEmbeddableMapActivity) this.f213a.getActivity("map");
            this.f215c = this.f214b.f197b;
            this.f218f = new AddedOverlaysItemizedOverlay(jW_().getDrawable(2130842093), this.aw);
            Iterator it = this.au.iterator();
            while (it.hasNext()) {
                m189a((SelectableOverlayItem) it.next());
            }
            this.f218f.setOnFocusChangeListener(new C00321(this));
            this.au.clear();
            this.au = null;
            this.f215c.getOverlays().add(this.f218f);
            this.f216d.addView(startActivity.getDecorView());
            mo20a(this.f221i);
            if (this.al != -1) {
                mo12a((double) this.al);
            }
            if (this.am != null) {
                mo14a(this.am);
            }
            if (this.an != null) {
                mo15a(this.an);
            }
            if (this.as) {
                mo34b(true);
            }
            if (this.ao != null) {
                this.f215c.f126b = this.ao;
            }
            if (this.ap != null) {
                this.f218f.f206b = this.ap;
            }
            if (this.aq != null) {
                this.f215c.f127c = this.aq;
            }
        }
    }

    public final Location mo31b() {
        if (this.f214b == null) {
            return this.am;
        }
        return Locations.m227a(this.f215c.getMapCenter());
    }

    public final double mo35e() {
        if (this.f214b == null) {
            return (double) this.al;
        }
        return (double) this.f215c.getZoomLevel();
    }

    @Nullable
    public final Location aq() {
        if (this.f214b == null || this.f217e == null) {
            return null;
        }
        return this.f217e.getLastFix();
    }

    public final ListenableFuture<Location> ar() {
        if (this.f217e == null) {
            SettableFuture f = SettableFuture.f();
            this.at.add(f);
            return f;
        }
        Location lastFix = this.f217e.getLastFix();
        if (lastFix != null) {
            return Futures.a(lastFix);
        }
        final ListenableFuture<Location> f2 = SettableFuture.f();
        this.f217e.runOnFirstFix(new Runnable(this) {
            final /* synthetic */ GoogleMapFragment f201b;

            public void run() {
                FutureDetour.a(f2, this.f201b.f217e.getLastFix(), -978717740);
            }
        });
        return f2;
    }

    public final void as() {
        if (this.f214b != null) {
            this.f215c.getController().zoomIn();
        }
    }

    public final void mo14a(Location location) {
        if (this.f214b == null) {
            this.am = location;
        } else {
            this.f215c.getController().setCenter(Locations.m228a(location));
        }
    }

    public final ListenableFuture<Void> mo32b(Location location) {
        Preconditions.checkNotNull(location);
        if (this.f214b == null) {
            this.am = location;
            return Futures.a(null);
        }
        final ListenableFuture<Void> f = SettableFuture.f();
        this.f215c.getController().animateTo(Locations.m228a(location), new Runnable(this) {
            final /* synthetic */ GoogleMapFragment f203b;

            public void run() {
                FutureDetour.a(f, null, -1371750888);
            }
        });
        return f;
    }

    public final void mo13a(int i, int i2) {
        this.f215c.getController().zoomToSpan(i, i2);
    }

    public final void mo12a(double d) {
        int i = (int) d;
        if (this.f214b == null) {
            this.al = i;
        } else {
            this.f215c.getController().setZoom(i);
        }
    }

    public final void mo20a(boolean z) {
        if (this.f214b == null) {
            this.f221i = z;
        } else {
            this.f215c.setClickable(z);
        }
    }

    public final void mo34b(boolean z) {
        if (this.f214b == null) {
            this.as = z;
        } else if (z) {
            this.f217e = new FixedMyLocationOverlay(this.f214b, this.f215c);
            if (this.at != null && this.at.size() > 0) {
                this.f217e.runOnFirstFix(new C00354(this));
            }
            this.f215c.getOverlays().add(this.f217e);
            this.f215c.postInvalidate();
            if (this.av) {
                this.f217e.enableMyLocation();
            }
        } else if (this.f217e != null) {
            if (this.av) {
                this.f217e.disableMyLocation();
            }
            this.f217e = null;
        }
    }

    public final Location at() {
        if (this.f214b == null) {
            return null;
        }
        return Locations.m227a(this.f215c.getProjection().fromPixels(0, 0));
    }

    public final Location au() {
        if (this.f214b == null) {
            return null;
        }
        return Locations.m227a(this.f215c.getProjection().fromPixels(this.f215c.getRight(), 0));
    }

    public final Location av() {
        if (this.f214b == null) {
            return null;
        }
        return Locations.m227a(this.f215c.getProjection().fromPixels(0, this.f215c.getHeight()));
    }

    public final Location aw() {
        if (this.f214b == null) {
            return null;
        }
        return Locations.m227a(this.f215c.getProjection().fromPixels(this.f215c.getWidth(), this.f215c.getHeight()));
    }

    public final RectF ax() {
        Location at = at();
        Location aw = aw();
        return new RectF((float) at.getLongitude(), (float) at.getLatitude(), (float) aw.getLongitude(), (float) aw.getLatitude());
    }

    public final Projection ay() {
        return this.f215c.getProjection();
    }

    public final void mo15a(OnTouchListener onTouchListener) {
        this.an = onTouchListener;
        if (this.f214b != null) {
            this.f215c.setOnTouchListener(this.an);
        }
    }

    public final void mo17a(OnMapReadyListener onMapReadyListener) {
        this.aq = onMapReadyListener;
        if (this.f214b != null) {
            this.f215c.f127c = onMapReadyListener;
        }
    }

    public final void mo18a(12 12) {
        this.ap = 12;
        if (this.f214b != null) {
            this.f218f.f206b = this.ap;
        }
    }

    public final void mo19a(9 9) {
        this.ao = 9;
        if (this.f214b != null) {
            this.f215c.f126b = this.ao;
        }
    }

    public final void mo16a(@Nullable GoogleMapOverlayElement googleMapOverlayElement) {
        if (googleMapOverlayElement == null) {
            this.f218f.setFocus(null);
            return;
        }
        this.f218f.setFocus(googleMapOverlayElement.f209b);
    }

    public final GoogleMapOverlayElement mo11a(double d, double d2, Drawable drawable) {
        return m189a(new SelectableOverlayItem(Locations.m228a(Locations.m226a(d, d2)), drawable, null, null));
    }

    private GoogleMapOverlayElement m189a(SelectableOverlayItem selectableOverlayItem) {
        if (this.f214b != null) {
            this.f218f.m168a(selectableOverlayItem);
            this.f215c.invalidate();
        } else {
            this.au.add(selectableOverlayItem);
        }
        return new GoogleMapOverlayElement(this, selectableOverlayItem);
    }

    public final void mo33b(GoogleMapOverlayElement googleMapOverlayElement) {
        SelectableOverlayItem selectableOverlayItem = googleMapOverlayElement.f209b;
        if (this.f214b != null) {
            this.f218f.m169b(selectableOverlayItem);
            this.f215c.invalidate();
        } else {
            this.au.remove(selectableOverlayItem);
        }
        googleMapOverlayElement.m171a(null);
    }

    public final boolean az() {
        return this.f215c != null && this.f215c.f131g;
    }

    public final void m210c(boolean z) {
        if (!this.y) {
            return;
        }
        if (z) {
            this.f213a.dispatchPause(false);
            return;
        }
        aA();
        this.f213a.dispatchResume();
    }
}
