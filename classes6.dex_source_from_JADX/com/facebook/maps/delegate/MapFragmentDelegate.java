package com.facebook.maps.delegate;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.MapView;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.ReportButtonDrawable;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.delegate.MapViewDelegate.InstantiationException;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: zł */
public class MapFragmentDelegate extends Fragment {
    protected FacebookMapOptions f133a;
    protected Boolean f134b;
    protected int f135c = 0;
    private MapView f136d;
    private com.google.android.gms.maps.MapView f137e;
    public MapDelegate f138f;
    private GoogleMapOptions f139g;
    public Queue<OnMapReadyDelegateCallback> f140h;

    /* compiled from: zł */
    class C00503 implements OnMapReadyCallback {
        final /* synthetic */ MapFragmentDelegate f390a;

        C00503(MapFragmentDelegate mapFragmentDelegate) {
            this.f390a = mapFragmentDelegate;
        }

        public final void m344a(FacebookMap facebookMap) {
            if (this.f390a.f138f == null) {
                this.f390a.f138f = new MapDelegate(facebookMap);
            }
            while (true) {
                OnMapReadyDelegateCallback onMapReadyDelegateCallback = (OnMapReadyDelegateCallback) this.f390a.f140h.poll();
                if (onMapReadyDelegateCallback != null) {
                    onMapReadyDelegateCallback.mo9a(this.f390a.f138f);
                } else {
                    this.f390a.f140h = null;
                    return;
                }
            }
        }
    }

    /* compiled from: zł */
    class C00514 implements OnMapReadyCallback {
        final /* synthetic */ MapFragmentDelegate f391a;

        C00514(MapFragmentDelegate mapFragmentDelegate) {
            this.f391a = mapFragmentDelegate;
        }

        public final void m345a(FacebookMap facebookMap) {
            facebookMap.a(this.f391a.mo2a(facebookMap)).a(true);
        }
    }

    /* compiled from: zł */
    class C00525 implements com.google.android.gms.maps.OnMapReadyCallback {
        final /* synthetic */ MapFragmentDelegate f392a;

        C00525(MapFragmentDelegate mapFragmentDelegate) {
            this.f392a = mapFragmentDelegate;
        }

        public final void mo49a(GoogleMap googleMap) {
            this.f392a.f138f = new MapDelegate(googleMap);
            while (true) {
                OnMapReadyDelegateCallback onMapReadyDelegateCallback = (OnMapReadyDelegateCallback) this.f392a.f140h.poll();
                if (onMapReadyDelegateCallback != null) {
                    onMapReadyDelegateCallback.mo9a(this.f392a.f138f);
                } else {
                    this.f392a.f140h = null;
                    return;
                }
            }
        }
    }

    @Deprecated
    public final MapDelegate m98a() {
        if (this.f138f == null) {
            if (this.f136d != null && this.f136d.v != null) {
                this.f138f = new MapDelegate(this.f136d.v);
            } else if (!(this.f137e == null || this.f137e.getMap() == null)) {
                this.f138f = new MapDelegate(this.f137e.getMap());
            }
        }
        return this.f138f;
    }

    public final void m100a(final OnMapReadyDelegateCallback onMapReadyDelegateCallback) {
        if (this.f136d != null) {
            this.f136d.a(new OnMapReadyCallback(this) {
                final /* synthetic */ MapFragmentDelegate f387b;

                public final void m341a(FacebookMap facebookMap) {
                    if (this.f387b.f138f == null) {
                        this.f387b.f138f = new MapDelegate(facebookMap);
                    }
                    onMapReadyDelegateCallback.mo9a(this.f387b.f138f);
                }
            });
        } else if (this.f137e != null) {
            this.f137e.m9210a(new com.google.android.gms.maps.OnMapReadyCallback(this) {
                final /* synthetic */ MapFragmentDelegate f389b;

                public final void mo49a(GoogleMap googleMap) {
                    this.f389b.f138f = new MapDelegate(googleMap);
                    onMapReadyDelegateCallback.mo9a(this.f389b.f138f);
                }
            });
        } else {
            if (this.f140h == null) {
                this.f140h = new LinkedList();
            }
            this.f140h.add(onMapReadyDelegateCallback);
        }
    }

    public final View m96a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1821153171);
        if (bundle != null) {
            this.f134b = Boolean.valueOf(bundle.getBoolean("isOxygenEnabled"));
            this.f135c = bundle.getInt("state_report_button_position");
        }
        if (this.f134b == null) {
            InstantiationException instantiationException = new InstantiationException("You MUST set a MapLibrarySelector on the MapFragmentDelegate before the MapView is initialized.");
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1939511700, a);
            throw instantiationException;
        } else if (this.f134b.booleanValue()) {
            if (this.f133a != null) {
                this.f136d = new MapView(getContext(), this.f133a);
            } else {
                this.f136d = new MapView(getContext());
            }
            if (this.f140h != null) {
                this.f136d.a(new C00503(this));
            }
            this.f136d.a(new C00514(this));
            this.f136d.a(bundle);
            MapView mapView = this.f136d;
            LogUtils.f(-624964780, a);
            return mapView;
        } else {
            if (this.f133a != null) {
                this.f139g = MapUtils.m350a(this.f133a);
                this.f137e = new com.google.android.gms.maps.MapView(getContext(), this.f139g);
            } else {
                this.f137e = new com.google.android.gms.maps.MapView(getContext());
            }
            if (this.f140h != null) {
                this.f137e.m9210a(new C00525(this));
            }
            this.f137e.m9209a(bundle);
            MapsInitializer.m9215a(getContext().getApplicationContext());
            View view = this.f137e;
            LogUtils.f(-1838418971, a);
            return view;
        }
    }

    public final void m99a(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.a(context, attributeSet, bundle);
        int a = MapUtils.m347a(attributeSet);
        if (a != 2) {
            this.f134b = Boolean.valueOf(a == 0);
        }
        Integer b = MapUtils.m355b(attributeSet);
        if (b != null) {
            this.f135c = b.intValue();
        }
        this.f133a = FacebookMapOptions.a(context, attributeSet);
    }

    public final void m101e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("isOxygenEnabled", this.f134b.booleanValue());
        bundle.putInt("state_report_button_position", this.f135c);
        if (this.f134b.booleanValue()) {
            this.f136d.b(bundle);
        } else {
            this.f137e.m9212b(bundle);
        }
    }

    public final void m93G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1379083036);
        super.G();
        if (!this.f134b.booleanValue()) {
            this.f137e.m9208a();
        }
        LogUtils.f(1128844795, a);
    }

    public final void m94H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 578619214);
        super.H();
        if (!this.f134b.booleanValue()) {
            this.f137e.m9211b();
        }
        LogUtils.f(-920697466, a);
    }

    public final void m95I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -169365215);
        super.I();
        if (this.f134b.booleanValue() && this.f136d != null) {
            this.f136d = null;
        } else if (this.f137e != null) {
            this.f137e.m9213c();
            this.f137e = null;
        }
        this.f138f = null;
        LogUtils.f(591329471, a);
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.f134b.booleanValue()) {
            this.f136d.b();
        } else {
            this.f137e.m9214d();
        }
    }

    protected MapDrawable mo2a(FacebookMap facebookMap) {
        return new ReportButtonDrawable(getContext(), facebookMap, this.f135c);
    }
}
