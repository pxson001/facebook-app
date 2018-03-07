package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi$zza$zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    public final int f6816a;
    public zzi f6817b;
    private TileProvider f6818c;
    public boolean f6819d;
    public float f6820e;
    public boolean f6821f;

    class C03881 implements TileProvider {
        final /* synthetic */ TileOverlayOptions f6814a;
        private final zzi f6815c = this.f6814a.f6817b;

        C03881(TileOverlayOptions tileOverlayOptions) {
            this.f6814a = tileOverlayOptions;
        }
    }

    public TileOverlayOptions() {
        this.f6819d = true;
        this.f6821f = true;
        this.f6816a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        zzi com_google_android_gms_maps_model_internal_zzi;
        this.f6819d = true;
        this.f6821f = true;
        this.f6816a = i;
        if (iBinder == null) {
            com_google_android_gms_maps_model_internal_zzi = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            com_google_android_gms_maps_model_internal_zzi = (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new zzi$zza$zza(iBinder) : (zzi) queryLocalInterface;
        }
        this.f6817b = com_google_android_gms_maps_model_internal_zzi;
        this.f6818c = this.f6817b == null ? null : new C03881(this);
        this.f6819d = z;
        this.f6820e = f;
        this.f6821f = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6816a);
        zzb.a(parcel, 2, this.f6817b.asBinder(), false);
        zzb.a(parcel, 3, this.f6819d);
        zzb.a(parcel, 4, this.f6820e);
        zzb.a(parcel, 5, this.f6821f);
        zzb.c(parcel, a);
    }
}
