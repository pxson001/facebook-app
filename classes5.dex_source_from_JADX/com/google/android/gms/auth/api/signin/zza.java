package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;

public class zza implements Creator<EmailSignInOptions> {
    public Object createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        String str = null;
        Uri uri = null;
        int i = 0;
        Uri uri2 = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.m12207a(parcel, a, Uri.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.m12207a(parcel, a, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EmailSignInOptions(i, uri, str, uri2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new EmailSignInOptions[i];
    }
}
