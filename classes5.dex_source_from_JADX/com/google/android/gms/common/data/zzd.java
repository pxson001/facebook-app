package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] f6491b = new String[]{"data"};
    private final Creator<T> f6492c;

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.f6492c = creator;
    }

    public final Object mo739a(int i) {
        byte[] f = this.f6461a.m12168f("data", i, this.f6461a.m12161a(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.f6492c.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
