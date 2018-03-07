package com.facebook.common.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: share_cta_label */
public class Triplet<F, S, T> extends ParcelablePair<F, S> implements Parcelable {
    public static final Creator<Triplet> CREATOR = new C02011();
    public final T f2781b;

    /* compiled from: share_cta_label */
    final class C02011 implements Creator<Triplet> {
        C02011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Triplet(parcel);
        }

        public final Object[] newArray(int i) {
            return new Triplet[i];
        }
    }

    public Triplet(F f, S s, T t) {
        super(f, s);
        this.f2781b = t;
    }

    protected Triplet(Parcel parcel) {
        this(ParcelablePair.m3905a(parcel), ParcelablePair.m3905a(parcel), ParcelablePair.m3905a(parcel));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.f2781b);
    }

    public Object[] mo576a() {
        return new Object[]{this.first, this.second, this.f2781b};
    }
}
