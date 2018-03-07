package com.facebook.spherical.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/* compiled from: eta */
public class GuidedTourParams implements Parcelable {
    public static final Creator<GuidedTourParams> CREATOR = new C11371();
    public final ImmutableList<KeyframeParams> f16159a;

    /* compiled from: eta */
    final class C11371 implements Creator<GuidedTourParams> {
        C11371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GuidedTourParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GuidedTourParams[i];
        }
    }

    /* compiled from: eta */
    public class Builder {
        public List<KeyframeParams> f16158a = Lists.a();
    }

    public GuidedTourParams(Builder builder) {
        this.f16159a = ImmutableList.copyOf(builder.f16158a);
    }

    GuidedTourParams(Parcel parcel) {
        com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
        Iterable arrayList = new ArrayList();
        parcel.readTypedList(arrayList, KeyframeParams.CREATOR);
        builder.b(arrayList);
        this.f16159a = builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f16159a);
    }
}
