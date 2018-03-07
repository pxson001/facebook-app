package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR = new zzc();
    public final int f7155a;
    public final boolean f7156b;
    public final List<Scope> f7157c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f7155a = i;
        this.f7156b = z;
        this.f7157c = list;
    }

    public CheckServerAuthResult(boolean z, Set<Scope> set) {
        this(1, z, set == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(set)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7155a);
        zzb.m12249a(parcel, 2, this.f7156b);
        zzb.m12259c(parcel, 3, this.f7157c, false);
        zzb.m12258c(parcel, a);
    }
}
