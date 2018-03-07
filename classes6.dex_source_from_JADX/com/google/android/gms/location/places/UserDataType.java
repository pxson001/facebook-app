package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzng;
import java.util.Collections;
import java.util.Set;

public final class UserDataType implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public static final UserDataType f6477a = m8973a("test_type", 1);
    public static final UserDataType f6478b = m8973a("labeled_place", 6);
    public static final UserDataType f6479c = m8973a("here_content", 7);
    public static final Set<UserDataType> f6480d;
    public final int f6481e;
    public final String f6482f;
    public final int f6483g;

    static {
        UserDataType userDataType = f6477a;
        UserDataType userDataType2 = f6478b;
        UserDataType userDataType3 = f6479c;
        zzng com_google_android_gms_internal_zzng = new zzng(3);
        com_google_android_gms_internal_zzng.add(userDataType);
        com_google_android_gms_internal_zzng.add(userDataType2);
        com_google_android_gms_internal_zzng.add(userDataType3);
        f6480d = Collections.unmodifiableSet(com_google_android_gms_internal_zzng);
    }

    UserDataType(int i, String str, int i2) {
        zzx.a(str);
        this.f6481e = i;
        this.f6482f = str;
        this.f6483g = i2;
    }

    private static UserDataType m8973a(String str, int i) {
        return new UserDataType(0, str, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) obj;
        return this.f6482f.equals(userDataType.f6482f) && this.f6483g == userDataType.f6483g;
    }

    public final int hashCode() {
        return this.f6482f.hashCode();
    }

    public final String toString() {
        return this.f6482f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6482f, false);
        zzb.a(parcel, 1000, this.f6481e);
        zzb.a(parcel, 2, this.f6483g);
        zzb.c(parcel, a);
    }
}
