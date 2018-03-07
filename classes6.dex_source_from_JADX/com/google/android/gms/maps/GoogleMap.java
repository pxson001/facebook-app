package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.zzf;

public final class GoogleMap {
    private final IGoogleMapDelegate f6633a;
    private UiSettings f6634b;

    public interface OnMarkerClickListener {
        boolean mo40a(Marker marker);
    }

    public interface OnInfoWindowClickListener {
        void mo41a(Marker marker);
    }

    public interface InfoWindowAdapter {
        View mo42a(Marker marker);

        View mo43b(Marker marker);
    }

    public interface CancelableCallback {
        void mo44a();

        void mo45b();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void mo46a(Location location);
    }

    public interface OnMapClickListener {
        void mo47a(LatLng latLng);
    }

    public interface OnCameraChangeListener {
        void mo48a(CameraPosition cameraPosition);
    }

    final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback f6632a;

        zza(CancelableCallback cancelableCallback) {
            this.f6632a = cancelableCallback;
        }

        public final void mo536a() {
            this.f6632a.mo44a();
        }

        public final void mo537b() {
            this.f6632a.mo45b();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f6633a = (IGoogleMapDelegate) zzx.a(iGoogleMapDelegate);
    }

    final IGoogleMapDelegate m9174a() {
        return this.f6633a;
    }

    public final Circle m9175a(CircleOptions circleOptions) {
        try {
            return new Circle(this.f6633a.mo552a(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker m9176a(MarkerOptions markerOptions) {
        try {
            zzf a = this.f6633a.mo554a(markerOptions);
            return a != null ? new Marker(a) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline m9177a(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f6633a.mo551a(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9178a(int i, int i2, int i3, int i4) {
        try {
            this.f6633a.mo558a(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9179a(CameraUpdate cameraUpdate) {
        try {
            this.f6633a.mo560a(cameraUpdate.m9142a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9180a(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.f6633a.mo561a(cameraUpdate.m9142a(), i, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9181a(final InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.f6633a.mo564a(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6633a.mo564a(new com.google.android.gms.maps.internal.zzd.zza(this) {
            final /* synthetic */ GoogleMap f6625b;

            public final zzd mo531a(zzf com_google_android_gms_maps_model_internal_zzf) {
                return zze.a(infoWindowAdapter.mo42a(new Marker(com_google_android_gms_maps_model_internal_zzf)));
            }

            public final zzd mo532b(zzf com_google_android_gms_maps_model_internal_zzf) {
                return zze.a(infoWindowAdapter.mo43b(new Marker(com_google_android_gms_maps_model_internal_zzf)));
            }
        });
    }

    public final void m9182a(final OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.f6633a.mo565a(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6633a.mo565a(new com.google.android.gms.maps.internal.zze.zza(this) {
            final /* synthetic */ GoogleMap f6629b;

            public final void mo534a(CameraPosition cameraPosition) {
                onCameraChangeListener.mo48a(cameraPosition);
            }
        });
    }

    public final void m9183a(final OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.f6633a.mo567a(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6633a.mo567a(new com.google.android.gms.maps.internal.zzg.zza(this) {
            final /* synthetic */ GoogleMap f6623b;

            public final void mo530a(zzf com_google_android_gms_maps_model_internal_zzf) {
                onInfoWindowClickListener.mo41a(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    public final void m9184a(final OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.f6633a.mo568a(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6633a.mo568a(new com.google.android.gms.maps.internal.zzi.zza(this) {
            final /* synthetic */ GoogleMap f6631b;

            public final void mo535a(LatLng latLng) {
                onMapClickListener.mo47a(latLng);
            }
        });
    }

    public final void m9185a(final OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.f6633a.mo572a(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6633a.mo572a(new com.google.android.gms.maps.internal.zzm.zza(this) {
            final /* synthetic */ GoogleMap f6621b;

            public final boolean mo529a(zzf com_google_android_gms_maps_model_internal_zzf) {
                return onMarkerClickListener.mo40a(new Marker(com_google_android_gms_maps_model_internal_zzf));
            }
        });
    }

    @Deprecated
    public final void m9186a(final OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.f6633a.mo575a(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.f6633a.mo575a(new com.google.android.gms.maps.internal.zzp.zza(this) {
            final /* synthetic */ GoogleMap f6627b;

            public final void mo533a(zzd com_google_android_gms_dynamic_zzd) {
                onMyLocationChangeListener.mo46a((Location) zze.a(com_google_android_gms_dynamic_zzd));
            }
        });
    }

    public final void m9187a(boolean z) {
        try {
            this.f6633a.mo586c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition m9188b() {
        try {
            return this.f6633a.mo550a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9189c() {
        try {
            this.f6633a.mo589e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location m9190d() {
        try {
            return this.f6633a.mo594j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings m9191e() {
        try {
            if (this.f6634b == null) {
                this.f6634b = new UiSettings(this.f6633a.mo595k());
            }
            return this.f6634b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection m9192f() {
        try {
            return new Projection(this.f6633a.mo596l());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
