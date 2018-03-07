package com.facebook.nearby.v2.resultlist.views;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.android.maps.model.BitmapDescriptor;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.android.maps.model.VisibleRegion;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.FbInjector;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMarkerClickListener;
import com.facebook.maps.delegate.MarkerDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewPager;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableBiMap.Builder;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: decline_admin_invite_tap */
public class NearbyPlacesV2MapView extends CustomFrameLayout {
    @Inject
    public SetSearchMapPagerAdapter f15886a;
    private FbMapViewDelegate f15887b;
    private CustomViewPager f15888c;
    private BitmapDescriptor f15889d;
    private BitmapDescriptor f15890e;
    public int f15891f;
    public ImmutableBiMap<MarkerDelegate, NearbyPlacesPlaceModel> f15892g;
    public MarkerDelegate f15893h;
    public OnViewPagerHeightChangeListener f15894i;
    public int f15895j = 0;
    public int f15896k;
    private int f15897l;
    private final OnMapReadyDelegateCallback f15898m = new C16991(this);
    private final OnMapReadyDelegateCallback f15899n = new C17002(this);
    private final OnMapReadyDelegateCallback f15900o = new C17013(this);
    private final OnPageChangeListener f15901p = new C17024(this);

    /* compiled from: decline_admin_invite_tap */
    public interface OnViewPagerHeightChangeListener {
        void x_(int i);
    }

    /* compiled from: decline_admin_invite_tap */
    class C16991 implements OnMapReadyDelegateCallback {
        final /* synthetic */ NearbyPlacesV2MapView f15881a;

        /* compiled from: decline_admin_invite_tap */
        class C16981 implements OnMarkerClickListener {
            final /* synthetic */ C16991 f15880a;

            C16981(C16991 c16991) {
                this.f15880a = c16991;
            }

            public final boolean m18734a(MarkerDelegate markerDelegate) {
                return this.f15880a.f15881a.m18746a(markerDelegate, this.f15880a.f15881a.f15886a.a((NearbyPlacesPlaceModel) this.f15880a.f15881a.f15892g.get(markerDelegate)));
            }
        }

        C16991(NearbyPlacesV2MapView nearbyPlacesV2MapView) {
            this.f15881a = nearbyPlacesV2MapView;
        }

        public final void m18735a(MapDelegate mapDelegate) {
            mapDelegate.a(true);
            NearbyPlacesV2MapView.m18749b(mapDelegate, this.f15881a.f15891f, this.f15881a.f15895j);
            mapDelegate.a(new C16981(this));
        }
    }

    /* compiled from: decline_admin_invite_tap */
    class C17002 implements OnMapReadyDelegateCallback {
        final /* synthetic */ NearbyPlacesV2MapView f15882a;

        C17002(NearbyPlacesV2MapView nearbyPlacesV2MapView) {
            this.f15882a = nearbyPlacesV2MapView;
        }

        public final void m18736a(MapDelegate mapDelegate) {
            NearbyPlacesV2MapView.m18749b(mapDelegate, this.f15882a.f15891f, this.f15882a.f15895j);
        }
    }

    /* compiled from: decline_admin_invite_tap */
    class C17013 implements OnMapReadyDelegateCallback {
        final /* synthetic */ NearbyPlacesV2MapView f15883a;

        C17013(NearbyPlacesV2MapView nearbyPlacesV2MapView) {
            this.f15883a = nearbyPlacesV2MapView;
        }

        public final void m18737a(MapDelegate mapDelegate) {
            this.f15883a.m18740a(mapDelegate);
        }
    }

    /* compiled from: decline_admin_invite_tap */
    class C17024 extends SimpleOnPageChangeListener {
        final /* synthetic */ NearbyPlacesV2MapView f15884a;

        C17024(NearbyPlacesV2MapView nearbyPlacesV2MapView) {
            this.f15884a = nearbyPlacesV2MapView;
        }

        public final void e_(int i) {
            this.f15884a.m18746a((MarkerDelegate) this.f15884a.f15892g.e().get(this.f15884a.f15886a.m18763a(i)), i);
        }
    }

    /* compiled from: decline_admin_invite_tap */
    class C17035 implements OnMapReadyDelegateCallback {
        final /* synthetic */ NearbyPlacesV2MapView f15885a;

        C17035(NearbyPlacesV2MapView nearbyPlacesV2MapView) {
            this.f15885a = nearbyPlacesV2MapView;
        }

        public final void m18738a(MapDelegate mapDelegate) {
            if (mapDelegate.b() != null) {
                VisibleRegion a = mapDelegate.b().a();
                LatLng a2 = this.f15885a.f15893h.a();
                if (!a.e.a(a2)) {
                    mapDelegate.a(CameraUpdateFactoryDelegate.a(a2), this.f15885a.f15896k, null);
                }
            }
        }
    }

    private static <T extends View> void m18744a(Class<T> cls, T t) {
        m18745a((Object) t, t.getContext());
    }

    private static void m18745a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NearbyPlacesV2MapView) obj).f15886a = new SetSearchMapPagerAdapter(DefaultAndroidThreadUtil.b(fbInjector), SetSearchPlaceViewBinder.m18783a(fbInjector));
    }

    public static void m18749b(MapDelegate mapDelegate, int i, int i2) {
        mapDelegate.a(i, i, i, i + i2);
    }

    private void m18743a(SetSearchMapPagerAdapter setSearchMapPagerAdapter) {
        this.f15886a = setSearchMapPagerAdapter;
    }

    public NearbyPlacesV2MapView(Context context) {
        super(context);
        m18754g();
    }

    public NearbyPlacesV2MapView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m18754g();
    }

    public NearbyPlacesV2MapView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18754g();
    }

    private void m18754g() {
        m18744a(NearbyPlacesV2MapView.class, (View) this);
        Context context = getContext();
        Resources resources = context.getResources();
        this.f15896k = resources.getInteger(17694721);
        this.f15897l = resources.getDimensionPixelOffset(2131430932) + resources.getDimensionPixelOffset(2131430933);
        BitmapDescriptorFactory.a(context);
        this.f15889d = BitmapDescriptorFactory.a(2130841595);
        this.f15890e = BitmapDescriptorFactory.a(2130841596);
        this.f15891f = resources.getDimensionPixelOffset(2131430933);
        setContentView(2130905397);
        this.f15887b = (FbMapViewDelegate) c(2131564125);
        this.f15888c = (CustomViewPager) c(2131564126);
        this.f15888c.setOffscreenPageLimit(2);
        this.f15888c.setPageMargin(resources.getDimensionPixelOffset(2131427416) * -3);
        this.f15888c.setOnPageChangeListener(this.f15901p);
        this.f15888c.setAdapter(this.f15886a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int height = this.f15888c.getHeight();
        if (this.f15895j != height) {
            this.f15895j = height;
            if (this.f15887b != null) {
                this.f15887b.a(this.f15899n);
            }
            if (this.f15894i != null) {
                this.f15894i.x_(this.f15895j);
            }
        }
    }

    public final void m18756a(Bundle bundle) {
        this.f15887b.a(bundle);
        this.f15887b.a(this.f15898m);
    }

    public final void m18755a() {
        this.f15887b.d();
    }

    public final void m18758b() {
        this.f15887b.c();
    }

    public final void m18760e() {
        this.f15887b.a();
    }

    public final void m18759b(Bundle bundle) {
        this.f15887b.b(bundle);
    }

    public final void m18761f() {
        this.f15887b.b();
    }

    public void setOnViewPagerHeightChangeListener(@Nullable OnViewPagerHeightChangeListener onViewPagerHeightChangeListener) {
        this.f15894i = onViewPagerHeightChangeListener;
    }

    public final void m18757a(NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        SetSearchMapPagerAdapter setSearchMapPagerAdapter = this.f15886a;
        if (nearbyPlacesResultListModel == null || nearbyPlacesResultListModel.f15863c == null || nearbyPlacesResultListModel.f15863c.m18703i() == null) {
            setSearchMapPagerAdapter.f15904b = null;
            setSearchMapPagerAdapter.f15905c = null;
        } else {
            setSearchMapPagerAdapter.f15904b = nearbyPlacesResultListModel.f15863c.m18703i();
            int size = setSearchMapPagerAdapter.f15904b.size();
            setSearchMapPagerAdapter.f15905c = new HashMap(size);
            for (int i = 0; i < size; i++) {
                setSearchMapPagerAdapter.f15905c.put(setSearchMapPagerAdapter.f15904b.get(i), Integer.valueOf(i));
            }
        }
        setSearchMapPagerAdapter.kR_();
        this.f15887b.a(this.f15900o);
    }

    private void m18740a(MapDelegate mapDelegate) {
        mapDelegate.a();
        Builder d = ImmutableBiMap.d();
        m18749b(mapDelegate, this.f15891f, this.f15895j);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int b = this.f15886a.b();
        int i = 0;
        while (i < b) {
            NearbyPlacesPlaceModel a = this.f15886a.m18763a(i);
            if (a != null) {
                Location f = a.m17742f();
                BitmapDescriptor bitmapDescriptor = i == 0 ? this.f15890e : this.f15889d;
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.b = new LatLng(f.getLatitude(), f.getLongitude());
                MarkerOptions markerOptions2 = markerOptions;
                markerOptions2.h = a.m17737a();
                markerOptions2 = markerOptions2;
                markerOptions2.c = bitmapDescriptor;
                MarkerOptions a2 = markerOptions2.a(0.5f, 0.5f);
                MarkerDelegate a3 = mapDelegate.a(a2);
                d.a(a3, a);
                builder.a(a2.g());
                if (i == 0) {
                    this.f15893h = a3;
                }
            }
            i++;
        }
        this.f15892g = d.a();
        mapDelegate.a(CameraUpdateFactoryDelegate.a(builder.a(), this.f15897l));
    }

    private boolean m18746a(@Nullable MarkerDelegate markerDelegate, int i) {
        if (markerDelegate == this.f15893h) {
            return false;
        }
        if (this.f15893h != null) {
            this.f15893h.a(this.f15889d);
            this.f15893h.e();
        }
        this.f15893h = markerDelegate;
        if (this.f15893h == null) {
            return true;
        }
        this.f15893h.a(this.f15890e);
        this.f15893h.d();
        this.f15888c.a(i, false);
        this.f15887b.a(new C17035(this));
        return true;
    }
}
