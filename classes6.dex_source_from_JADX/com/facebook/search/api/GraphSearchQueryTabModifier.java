package com.facebook.search.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: extra_requires_initial_fetch */
public class GraphSearchQueryTabModifier implements Parcelable {
    public static final Creator<GraphSearchQueryTabModifier> CREATOR = new C11001();
    public boolean f15481a;

    /* compiled from: extra_requires_initial_fetch */
    final class C11001 implements Creator<GraphSearchQueryTabModifier> {
        C11001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            Builder builder = new Builder();
            builder.f15480a = zArr[0];
            return builder.m23109a();
        }

        public final Object[] newArray(int i) {
            return new GraphSearchQueryTabModifier[i];
        }
    }

    /* compiled from: extra_requires_initial_fetch */
    public class Builder {
        public boolean f15480a;

        public final GraphSearchQueryTabModifier m23109a() {
            return new GraphSearchQueryTabModifier(this);
        }
    }

    public GraphSearchQueryTabModifier(Builder builder) {
        this.f15481a = builder.f15480a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f15481a});
    }
}
