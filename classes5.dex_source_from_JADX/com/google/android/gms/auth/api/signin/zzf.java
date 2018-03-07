package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzf implements Creator<SignInAccount> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str6 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    str5 = zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str4 = zza.m12224n(parcel, a);
                    break;
                case 5:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 6:
                    uri = (Uri) zza.m12207a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) zza.m12207a(parcel, a, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 9:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInAccount(i, str6, str5, str4, str3, uri, googleSignInAccount, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
