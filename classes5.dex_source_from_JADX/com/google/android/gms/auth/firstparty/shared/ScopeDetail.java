package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f6431a;
    public String f6432b;
    public String f6433c;
    public String f6434d;
    public String f6435e;
    public String f6436f;
    public List<String> f6437g;
    public FACLData f6438h;

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List<String> list, FACLData fACLData) {
        this.f6431a = i;
        this.f6432b = str;
        this.f6433c = str2;
        this.f6434d = str3;
        this.f6435e = str4;
        this.f6436f = str5;
        this.f6437g = list;
        this.f6438h = fACLData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6431a);
        zzb.m12247a(parcel, 2, this.f6432b, false);
        zzb.m12247a(parcel, 3, this.f6433c, false);
        zzb.m12247a(parcel, 4, this.f6434d, false);
        zzb.m12247a(parcel, 5, this.f6435e, false);
        zzb.m12247a(parcel, 6, this.f6436f, false);
        zzb.m12257b(parcel, 7, this.f6437g, false);
        zzb.m12245a(parcel, 8, this.f6438h, i, false);
        zzb.m12258c(parcel, a);
    }
}
