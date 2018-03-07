package com.google.android.gms.location.places;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.location.places.personalized.zzd;

public class zzl extends com.google.android.gms.location.places.internal.zzi.zza {
    private static final String f6609a = zzl.class.getSimpleName();
    private final zzd f6610b;
    private final zza f6611c;
    private final zze f6612d;
    private final zzf f6613e;
    private final zzc f6614f;
    private final Context f6615g;

    public abstract class zzb<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.internal.zzlx.zza<R, A> {
        public zzb(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }
    }

    public abstract class zzc<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected final Result m9018c(Status status) {
            return new PlaceBuffer(DataHolder.b(status.g), null);
        }
    }

    public abstract class zza<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected final Result m9020c(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.b(status.g));
        }
    }

    public zzl(zza com_google_android_gms_location_places_zzl_zza) {
        this.f6610b = null;
        this.f6611c = com_google_android_gms_location_places_zzl_zza;
        this.f6612d = null;
        this.f6613e = null;
        this.f6614f = null;
        this.f6615g = null;
    }

    public zzl(zzc com_google_android_gms_location_places_zzl_zzc, Context context) {
        this.f6610b = null;
        this.f6611c = null;
        this.f6612d = null;
        this.f6613e = null;
        this.f6614f = com_google_android_gms_location_places_zzl_zzc;
        this.f6615g = context.getApplicationContext();
    }

    public final void mo522a(Status status) {
        this.f6613e.a(status);
    }

    public final void mo523a(DataHolder dataHolder) {
        zzx.a(this.f6610b != null, "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(f6609a, 6)) {
                Log.e(f6609a, "onPlaceEstimated received null DataHolder: " + zznz.a());
            }
            this.f6610b.a(Status.c);
            return;
        }
        this.f6610b.a(new PlaceLikelihoodBuffer(dataHolder, 100, this.f6615g));
    }

    public final void mo524b(DataHolder dataHolder) {
        if (dataHolder == null) {
            if (Log.isLoggable(f6609a, 6)) {
                Log.e(f6609a, "onAutocompletePrediction received null DataHolder: " + zznz.a());
            }
            this.f6611c.a(Status.c);
            return;
        }
        this.f6611c.a(new AutocompletePredictionBuffer(dataHolder));
    }

    public final void mo525c(DataHolder dataHolder) {
        if (dataHolder == null) {
            if (Log.isLoggable(f6609a, 6)) {
                Log.e(f6609a, "onPlaceUserDataFetched received null DataHolder: " + zznz.a());
            }
            this.f6612d.a(Status.c);
            return;
        }
        this.f6612d.a(new zzd(dataHolder));
    }

    public final void mo526d(DataHolder dataHolder) {
        this.f6614f.a(new PlaceBuffer(dataHolder, this.f6615g));
    }
}
