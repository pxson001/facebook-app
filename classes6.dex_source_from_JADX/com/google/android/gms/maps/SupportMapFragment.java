package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private final zzb f6681a = new zzb(this);
    private GoogleMap f6682b;

    public class zza implements MapLifecycleDelegate {
        private final Fragment f6675a;
        public final IMapFragmentDelegate f6676b;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f6676b = (IMapFragmentDelegate) zzx.a(iMapFragmentDelegate);
            this.f6675a = (Fragment) zzx.a(fragment);
        }

        public final View m9220a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.a(this.f6676b.mo607a(zze.a(layoutInflater), zze.a(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9221a() {
            try {
                this.f6676b.mo612b();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9222a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle mt_ = this.f6675a.mt_();
            if (mt_ != null && mt_.containsKey("MapOptions")) {
                com.google.android.gms.maps.internal.zzx.m9640a(bundle, "MapOptions", mt_.getParcelable("MapOptions"));
            }
            this.f6676b.mo609a(bundle);
        }

        public final void m9223a(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f6676b.mo611a(new com.google.android.gms.maps.internal.zzl.zza(this) {
                    final /* synthetic */ zza f6674b;

                    public final void mo538a(IGoogleMapDelegate iGoogleMapDelegate) {
                        onMapReadyCallback.mo49a(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9224b() {
            try {
                this.f6676b.mo614c();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9225b(Bundle bundle) {
            try {
                this.f6676b.mo613b(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9226c() {
            try {
                this.f6676b.mo616d();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9227d() {
            try {
                this.f6676b.mo617e();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m9228e() {
            try {
                this.f6676b.mo618f();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final IMapFragmentDelegate m9229f() {
            return this.f6676b;
        }
    }

    class zzb extends com.google.android.gms.dynamic.zza<zza> {
        protected zzf<zza> f6677a;
        private final Fragment f6678b;
        private Activity f6679c;
        private final List<OnMapReadyCallback> f6680d = new ArrayList();

        zzb(Fragment fragment) {
            this.f6678b = fragment;
        }

        private void m9230a(Activity activity) {
            this.f6679c = activity;
            m9233g();
        }

        protected final void m9232a(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportMapFragment_zza) {
            this.f6677a = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportMapFragment_zza;
            m9233g();
        }

        public final void m9233g() {
            if (this.f6679c != null && this.f6677a != null && a() == null) {
                try {
                    MapsInitializer.m9215a(this.f6679c);
                    IMapFragmentDelegate b = zzy.m9641a(this.f6679c).mo700b(zze.a(this.f6679c));
                    if (b != null) {
                        this.f6677a.a(new zza(this.f6678b, b));
                        for (OnMapReadyCallback a : this.f6680d) {
                            ((zza) a()).m9223a(a);
                        }
                        this.f6680d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    private IMapFragmentDelegate m9234b() {
        this.f6681a.m9233g();
        return this.f6681a.a == null ? null : ((zza) this.f6681a.a).f6676b;
    }

    public final void m9235G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1215923510);
        super.G();
        this.f6681a.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1126662268, a);
    }

    public final void m9236H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2021159508);
        this.f6681a.c();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -221592097, a);
    }

    public final void m9237I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1646729694);
        this.f6681a.e();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1974435987, a);
    }

    public final View m9238a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -669134491);
        View a2 = this.f6681a.a(layoutInflater, viewGroup, bundle);
        a2.setClickable(true);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2003241440, a);
        return a2;
    }

    @Deprecated
    public final GoogleMap m9239a() {
        IMapFragmentDelegate b = m9234b();
        if (b == null) {
            return null;
        }
        try {
            IGoogleMapDelegate a = b.mo608a();
            if (a == null) {
                return null;
            }
            if (this.f6682b == null || this.f6682b.m9174a().asBinder() != a.asBinder()) {
                this.f6682b = new GoogleMap(a);
            }
            return this.f6682b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9240a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1529510201);
        super.a(activity);
        this.f6681a.m9230a(activity);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 435286567, a);
    }

    public final void m9241a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1849015173);
        super.a(bundle);
        this.f6681a.a(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -454174341, a);
    }

    public final void m9242d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2056545427);
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1384916570, a);
    }

    public final void m9243e(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.e(bundle);
        this.f6681a.b(bundle);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1156615359);
        this.f6681a.d();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -329822292, a);
    }

    public void onLowMemory() {
        this.f6681a.f();
        super.onLowMemory();
    }
}
