package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

/* compiled from: created_for_group_name */
public class AcceptMessageRequestsParams implements Parcelable {
    public static final Creator<AcceptMessageRequestsParams> CREATOR = new C19881();
    public static String f17003a = "acceptMessageRequestsParams";
    public final ImmutableList<Long> f17004b;

    /* compiled from: created_for_group_name */
    final class C19881 implements Creator<AcceptMessageRequestsParams> {
        C19881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AcceptMessageRequestsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AcceptMessageRequestsParams[i];
        }
    }

    public AcceptMessageRequestsParams(ImmutableList<Long> immutableList) {
        this.f17004b = immutableList;
    }

    public AcceptMessageRequestsParams(Parcel parcel) {
        this.f17004b = ImmutableList.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17004b);
    }
}
