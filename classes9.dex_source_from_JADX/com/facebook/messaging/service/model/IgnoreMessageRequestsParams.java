package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

/* compiled from: continueSearch */
public class IgnoreMessageRequestsParams implements Parcelable {
    public static final Creator<IgnoreMessageRequestsParams> CREATOR = new C20351();
    public static String f17194a = "ignoreMessageRequestsParams";
    public final ImmutableList<Long> f17195b;

    /* compiled from: continueSearch */
    final class C20351 implements Creator<IgnoreMessageRequestsParams> {
        C20351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new IgnoreMessageRequestsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new IgnoreMessageRequestsParams[i];
        }
    }

    public IgnoreMessageRequestsParams(ImmutableList<Long> immutableList) {
        this.f17195b = immutableList;
    }

    public IgnoreMessageRequestsParams(Parcel parcel) {
        this.f17195b = ImmutableList.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17195b);
    }
}
