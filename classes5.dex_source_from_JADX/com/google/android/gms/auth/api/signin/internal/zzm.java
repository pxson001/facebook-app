package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzm implements Creator<SignInConfiguration> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        FacebookSignInOptions facebookSignInOptions = null;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    emailSignInOptions = (EmailSignInOptions) zza.m12207a(parcel, a, EmailSignInOptions.CREATOR);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) zza.m12207a(parcel, a, GoogleSignInOptions.CREATOR);
                    break;
                case 6:
                    facebookSignInOptions = (FacebookSignInOptions) zza.m12207a(parcel, a, FacebookSignInOptions.CREATOR);
                    break;
                case 7:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInConfiguration(i, str3, str2, emailSignInOptions, googleSignInOptions, facebookSignInOptions, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
