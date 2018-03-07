package com.facebook.common.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: share_message */
public class ParcelablePair<F, S> extends Pair<F, S> implements Parcelable, Iterable<Object> {
    public static final Creator<ParcelablePair> CREATOR = new C01961();

    /* compiled from: share_message */
    final class C01961 implements Creator<ParcelablePair> {
        C01961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ParcelablePair(parcel);
        }

        public final Object[] newArray(int i) {
            return new ParcelablePair[i];
        }
    }

    public ParcelablePair(F f, S s) {
        super(f, s);
    }

    protected ParcelablePair(Parcel parcel) {
        this(m3905a(parcel), m3905a(parcel));
    }

    protected static <T> T m3905a(Parcel parcel) {
        return parcel.readValue(ParcelablePair.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.first);
        parcel.writeValue(this.second);
    }

    public Object[] mo576a() {
        return new Object[]{this.first, this.second};
    }

    public Iterator<Object> iterator() {
        return Iterators.a(mo576a());
    }

    public String toString() {
        return getClass().getSimpleName() + Arrays.toString(mo576a());
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParcelablePair) {
            return Arrays.equals(mo576a(), ((ParcelablePair) obj).mo576a());
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(mo576a());
    }
}
