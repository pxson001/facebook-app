package com.facebook.common.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: share_detected_topic */
public class Quartet<T1, T2, T3, T4> extends Triplet<T1, T2, T3> implements Parcelable {
    public static final Creator<Quartet> CREATOR = new C01971();
    public final T4 f2782a;

    /* compiled from: share_detected_topic */
    final class C01971 implements Creator<Quartet> {
        C01971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Quartet(parcel);
        }

        public final Object[] newArray(int i) {
            return new Quartet[i];
        }
    }

    public Quartet(T1 t1, T2 t2, T3 t3, T4 t4) {
        super(t1, t2, t3);
        this.f2782a = t4;
    }

    protected Quartet(Parcel parcel) {
        this(ParcelablePair.m3905a(parcel), ParcelablePair.m3905a(parcel), ParcelablePair.m3905a(parcel), ParcelablePair.m3905a(parcel));
    }

    public static <A, B, C, D> Quartet<A, B, C, D> m3908a(A a, B b, C c, D d) {
        return new Quartet(a, b, c, d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.f2782a);
    }

    public final Object[] mo576a() {
        return new Object[]{this.first, this.second, this.f2781b, this.f2782a};
    }
}
