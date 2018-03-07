package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class zzc {
    public static <T extends SafeParcelable> T m12260a(byte[] bArr, Creator<T> creator) {
        zzx.a(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
