package com.facebook.maps.delegate;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.MapReporterLauncher;
import com.facebook.android.maps.MapView;
import com.facebook.android.maps.OnMapReadyCallback;
import com.facebook.android.maps.ReportButtonDrawable;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;

/* compiled from: zero_communication_rank */
public class MapViewDelegate extends FrameLayout {
    public int f150a;
    protected int f151b;
    public MapView f152c;
    public com.google.android.gms.maps.MapView f153d;
    public MapDelegate f154e;
    public final FacebookMapOptions f155f;
    public ReportButtonDrawable f156g;
    public MapReporterLauncher f157h;

    /* compiled from: zero_communication_rank */
    public class C00553 implements OnMapReadyCallback {
        final /* synthetic */ MapViewDelegate f397a;

        public C00553(MapViewDelegate mapViewDelegate) {
            this.f397a = mapViewDelegate;
        }

        public final void m358a(FacebookMap facebookMap) {
            if (this.f397a.f156g == null) {
                this.f397a.f156g = this.f397a.mo3a(facebookMap);
            }
            if (this.f397a.f157h != null) {
                this.f397a.f156g.y = this.f397a.f157h;
            }
            ((ReportButtonDrawable) facebookMap.a(this.f397a.f156g)).a(true);
        }
    }

    /* compiled from: zero_communication_rank */
    public class InstantiationException extends RuntimeException {
        public InstantiationException(String str) {
            super(str);
        }
    }

    public MapViewDelegate(Context context) {
        super(context);
        this.f150a = 2;
        this.f151b = 0;
        this.f155f = null;
    }

    public MapViewDelegate(Context context, FacebookMapOptions facebookMapOptions) {
        super(context);
        this.f150a = 2;
        this.f151b = 0;
        this.f155f = facebookMapOptions;
    }

    public MapViewDelegate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f150a = 2;
        this.f151b = 0;
        this.f155f = FacebookMapOptions.a(context, attributeSet);
        Integer b = MapUtils.m355b(attributeSet);
        if (b != null) {
            this.f151b = b.intValue();
        }
        this.f150a = MapUtils.m347a(attributeSet);
    }

    public void setMapReporterLauncher(MapReporterLauncher mapReporterLauncher) {
        this.f157h = mapReporterLauncher;
        if (this.f156g != null) {
            this.f156g.y = mapReporterLauncher;
        }
    }

    public final void m115a(Bundle bundle) {
        if (this.f150a == 2 && bundle != null) {
            this.f150a = bundle.getInt("state_map_source", 2);
        }
        View view = null;
        if (this.f152c == null && this.f153d == null) {
            MapView mapView;
            if (this.f150a == 0) {
                if (this.f155f != null) {
                    this.f152c = new MapView(getContext(), this.f155f);
                } else {
                    this.f152c = new MapView(getContext());
                }
                mapView = this.f152c;
            } else {
                if (this.f155f != null) {
                    this.f153d = new com.google.android.gms.maps.MapView(getContext(), MapUtils.m350a(this.f155f));
                } else {
                    this.f153d = new com.google.android.gms.maps.MapView(getContext());
                }
                mapView = this.f153d;
            }
            view = mapView;
        }
        if (this.f152c != null) {
            this.f152c.a(bundle);
            this.f152c.a(new C00553(this));
        } else if (this.f153d != null) {
            this.f153d.m9209a(bundle);
            MapsInitializer.m9215a(getContext().getApplicationContext());
        } else {
            throw new InstantiationException("You MUST set a MapLibrarySelector on the MapViewDelegate before the MapView is created!");
        }
        if (view != null) {
            addView(view);
        }
    }

    public final void m118b(Bundle bundle) {
        bundle.putInt("state_map_source", this.f150a);
        if (this.f152c != null) {
            this.f152c.b(bundle);
        } else {
            this.f153d.m9212b(bundle);
        }
    }

    public final void m114a() {
        if (this.f152c == null) {
            this.f153d.m9213c();
        }
    }

    public final void m117b() {
        if (this.f152c != null) {
            this.f152c.b();
        } else {
            this.f153d.m9214d();
        }
    }

    public final void m119c() {
        if (this.f152c == null) {
            this.f153d.m9211b();
        }
    }

    public final void m120d() {
        if (this.f152c == null) {
            this.f153d.m9208a();
        }
    }

    public void mo4a(final OnMapReadyDelegateCallback onMapReadyDelegateCallback) {
        if (this.f152c != null) {
            this.f152c.a(new OnMapReadyCallback(this) {
                final /* synthetic */ MapViewDelegate f394b;

                public final void m356a(FacebookMap facebookMap) {
                    if (this.f394b.f154e == null) {
                        this.f394b.f154e = new MapDelegate(facebookMap);
                    }
                    onMapReadyDelegateCallback.mo9a(this.f394b.f154e);
                }
            });
        } else if (this.f153d != null) {
            this.f153d.m9210a(new com.google.android.gms.maps.OnMapReadyCallback(this) {
                final /* synthetic */ MapViewDelegate f396b;

                public final void mo49a(GoogleMap googleMap) {
                    this.f396b.f154e = new MapDelegate(googleMap);
                    onMapReadyDelegateCallback.mo9a(this.f396b.f154e);
                }
            });
        }
    }

    public void setEnabled(boolean z) {
        if (z) {
            if (this.f153d != null) {
                this.f153d.setVisibility(0);
            } else if (this.f152c != null) {
                this.f152c.setVisibility(0);
            }
        } else if (this.f153d != null) {
            this.f153d.setVisibility(8);
        } else if (this.f152c != null) {
            this.f152c.setVisibility(8);
        }
    }

    public boolean isEnabled() {
        return (this.f153d != null && this.f153d.getVisibility() == 0) || (this.f152c != null && this.f152c.getVisibility() == 0);
    }

    protected ReportButtonDrawable mo3a(FacebookMap facebookMap) {
        return new ReportButtonDrawable(getContext(), facebookMap, this.f151b);
    }
}
