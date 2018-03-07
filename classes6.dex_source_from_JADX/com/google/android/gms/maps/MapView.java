package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private final zzb f6659a;
    private GoogleMap f6660b;

    public class zza implements MapLifecycleDelegate {
        private final ViewGroup f6651a;
        private final IMapViewDelegate f6652b;
        private View f6653c;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f6652b = (IMapViewDelegate) zzx.a(iMapViewDelegate);
            this.f6651a = (ViewGroup) zzx.a(viewGroup);
        }

        public final View m9195a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public final void m9196a() {
            try {
                this.f6652b.mo624b();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9197a(Bundle bundle) {
            try {
                this.f6652b.mo622a(bundle);
                this.f6653c = (View) zze.a(this.f6652b.mo630f());
                this.f6651a.removeAllViews();
                this.f6651a.addView(this.f6653c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9198a(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f6652b.mo623a(new com.google.android.gms.maps.internal.zzl.zza(this) {
                    final /* synthetic */ zza f6650b;

                    public final void mo538a(IGoogleMapDelegate iGoogleMapDelegate) {
                        onMapReadyCallback.mo49a(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9199b() {
            try {
                this.f6652b.mo626c();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9200b(Bundle bundle) {
            try {
                this.f6652b.mo625b(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9201c() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public final void m9202d() {
            try {
                this.f6652b.mo628d();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9203e() {
            try {
                this.f6652b.mo629e();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final IMapViewDelegate m9204f() {
            return this.f6652b;
        }
    }

    public class zzb extends com.google.android.gms.dynamic.zza<zza> {
        protected zzf<zza> f6654a;
        private final ViewGroup f6655b;
        private final Context f6656c;
        private final GoogleMapOptions f6657d;
        public final List<OnMapReadyCallback> f6658e = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f6655b = viewGroup;
            this.f6656c = context;
            this.f6657d = googleMapOptions;
        }

        protected final void m9205a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza) {
            this.f6654a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza;
            m9206g();
        }

        public final void m9206g() {
            if (this.f6654a != null && a() == null) {
                try {
                    MapsInitializer.m9215a(this.f6656c);
                    IMapViewDelegate a = zzy.m9641a(this.f6656c).mo696a(zze.a(this.f6656c), this.f6657d);
                    if (a != null) {
                        this.f6654a.a(new zza(this.f6655b, a));
                        for (OnMapReadyCallback a2 : this.f6658e) {
                            ((zza) a()).m9198a(a2);
                        }
                        this.f6658e.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f6659a = new zzb(this, context, null);
        m9207e();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f6659a = new zzb(this, context, googleMapOptions);
        m9207e();
    }

    private void m9207e() {
        setClickable(true);
    }

    public final void m9208a() {
        this.f6659a.b();
    }

    public final void m9209a(Bundle bundle) {
        this.f6659a.a(bundle);
        if (this.f6659a.a == null) {
            com.google.android.gms.dynamic.zza.a(this);
        }
    }

    public final void m9210a(OnMapReadyCallback onMapReadyCallback) {
        zzx.b("getMapAsync() must be called on the main thread");
        zzb com_google_android_gms_maps_MapView_zzb = this.f6659a;
        if (com_google_android_gms_maps_MapView_zzb.a != null) {
            ((zza) com_google_android_gms_maps_MapView_zzb.a).m9198a(onMapReadyCallback);
        } else {
            com_google_android_gms_maps_MapView_zzb.f6658e.add(onMapReadyCallback);
        }
    }

    public final void m9211b() {
        this.f6659a.c();
    }

    public final void m9212b(Bundle bundle) {
        this.f6659a.b(bundle);
    }

    public final void m9213c() {
        this.f6659a.e();
    }

    public final void m9214d() {
        this.f6659a.f();
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.f6660b != null) {
            return this.f6660b;
        }
        this.f6659a.m9206g();
        if (this.f6659a.a() == null) {
            return null;
        }
        try {
            this.f6660b = new GoogleMap(((zza) this.f6659a.a()).m9204f().mo621a());
            return this.f6660b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
