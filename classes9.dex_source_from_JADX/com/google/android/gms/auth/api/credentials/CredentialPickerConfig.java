package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzb();
    public final int f3599a;
    public final boolean f3600b;
    public final boolean f3601c;
    public final boolean f3602d;

    public class Builder {
        public boolean f3596a = false;
        public boolean f3597b = true;
        public boolean f3598c = false;

        public final CredentialPickerConfig m3373a() {
            return new CredentialPickerConfig(this);
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3) {
        this.f3599a = i;
        this.f3600b = z;
        this.f3601c = z2;
        this.f3602d = z3;
    }

    public CredentialPickerConfig(Builder builder) {
        this(1, builder.f3596a, builder.f3597b, builder.f3598c);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3600b);
        zzb.a(parcel, 1000, this.f3599a);
        zzb.a(parcel, 2, this.f3601c);
        zzb.a(parcel, 3, this.f3602d);
        zzb.c(parcel, a);
    }
}
