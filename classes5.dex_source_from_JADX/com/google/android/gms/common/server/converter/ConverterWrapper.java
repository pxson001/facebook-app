package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int f6595a;
    public final StringToIntConverter f6596b;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.f6595a = i;
        this.f6596b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.f6595a = 1;
        this.f6596b = stringToIntConverter;
    }

    public static ConverterWrapper m12403a(zza<?, ?> com_google_android_gms_common_server_response_FastJsonResponse_zza___) {
        if (com_google_android_gms_common_server_response_FastJsonResponse_zza___ instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) com_google_android_gms_common_server_response_FastJsonResponse_zza___);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final zza<?, ?> m12404c() {
        if (this.f6596b != null) {
            return this.f6596b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6595a);
        zzb.m12245a(parcel, 2, (Parcelable) this.f6596b, i, false);
        zzb.m12258c(parcel, a);
    }
}
