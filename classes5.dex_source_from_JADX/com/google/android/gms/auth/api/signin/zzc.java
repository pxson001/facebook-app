package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzc implements Creator<GoogleSignInAccount> {
    private static GoogleSignInAccount m12122a(Parcel parcel) {
        List list = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
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
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 8:
                    j = zza.m12218g(parcel, a);
                    break;
                case 9:
                    str = zza.m12224n(parcel, a);
                    break;
                case 10:
                    list = zza.m12215c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str6, str5, str4, str3, uri, str2, j, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12122a(parcel);
    }

    public Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
