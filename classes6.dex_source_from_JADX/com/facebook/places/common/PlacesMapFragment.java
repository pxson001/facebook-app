package com.facebook.places.common;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.IdBasedProvider;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.maps.MapFragment;
import com.facebook.maps.MapFragmentFactory;

/* compiled from: frame_offset */
public class PlacesMapFragment extends FbFragment {
    public static MapListener f14676g;
    private static final StaticMapOptions f14677h = new StaticMapOptions("suggest_edits");
    public MapFragment f14678a;
    private FbStaticMapView f14679b;
    public ImmutableLocation f14680c;
    private ImmutableLocation f14681d;
    private boolean f14682e;
    public View f14683f;

    /* compiled from: frame_offset */
    class C09371 implements OnTouchListener {
        final /* synthetic */ PlacesMapFragment f14675a;

        C09371(PlacesMapFragment placesMapFragment) {
            this.f14675a = placesMapFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (this.f14675a.f14683f.getVisibility() == 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), 2130968703);
                loadAnimation.setDuration(300);
                loadAnimation.setStartOffset(500);
                this.f14675a.f14683f.setAnimation(loadAnimation);
                this.f14675a.f14683f.setVisibility(4);
            }
            if (PlacesMapFragment.f14676g != null) {
                PlacesMapFragment.f14676g.m22230b();
            }
            this.f14675a.f14680c = ImmutableLocation.a(this.f14675a.f14678a.mo31b());
            return false;
        }
    }

    /* compiled from: frame_offset */
    public interface MapListener {
        void m22230b();
    }

    public static void m22233a(MapListener mapListener) {
        f14676g = mapListener;
    }

    public final void m22239c(Bundle bundle) {
        super.c(bundle);
        this.f14682e = ((Boolean) IdBasedProvider.a(an(), 4034).get()).booleanValue();
    }

    public final View m22235a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 118798545);
        View inflate = layoutInflater.inflate(2130906269, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -656470024, a);
        return inflate;
    }

    public final void m22237a(ImmutableLocation immutableLocation) {
        this.f14681d = immutableLocation;
        this.f14680c = immutableLocation;
        ar();
    }

    public final boolean m22238b() {
        return this.f14680c.l().distanceTo(this.f14681d.l()) > 5.0f;
    }

    private void ar() {
        if (!this.f14682e) {
            if (this.f14678a == null) {
                this.f14679b.setMapOptions(f14677h.a().a(this.f14680c.a(), this.f14680c.b(), "red").a(13));
                this.f14683f.setVisibility(4);
                return;
            }
            this.f14678a.mo14a(this.f14680c.l());
            this.f14678a.mo12a(17.0d);
            this.f14678a.mo15a(new C09371(this));
        }
    }

    public final ImmutableLocation m22240e() {
        return this.f14680c;
    }

    public final void m22236a(View view, Bundle bundle) {
        if (this.f14682e) {
            this.T.setVisibility(8);
            return;
        }
        this.f14683f = this.T.findViewById(2131566021);
        MapFragmentFactory b = MapFragmentFactory.m232b(an());
        if (b.f256b.m214a()) {
            FragmentTransaction a = this.D.a();
            this.f14678a = b.m233a(true);
            a.a(2131559301, this.f14678a);
            a.b();
        } else {
            ((ViewStub) view.findViewById(2131566017)).inflate();
            this.f14679b = (FbStaticMapView) view.findViewById(2131566018);
            view.findViewById(2131559301).setVisibility(8);
            view.findViewById(2131563553).setVisibility(8);
            this.f14679b.setVisibility(0);
            this.f14683f.setVisibility(8);
        }
        if (bundle != null) {
            m22237a((ImmutableLocation) bundle.getParcelable("location"));
        }
    }

    public final void m22241e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("location", this.f14680c);
    }
}
