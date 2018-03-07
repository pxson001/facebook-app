package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.collect.ImmutableList;

/* compiled from: cover_photo_portrait_uri */
public class FetchMoreSpacesResult extends BaseResult implements Parcelable {
    public static final Creator<FetchMoreSpacesResult> CREATOR = new C20181();
    private final long f17079a;
    private final ImmutableList<ThreadSummary> f17080b;

    /* compiled from: cover_photo_portrait_uri */
    final class C20181 implements Creator<FetchMoreSpacesResult> {
        C20181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreSpacesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreSpacesResult[i];
        }
    }

    public static FetchMoreSpacesResultBuilder newBuilder() {
        return new FetchMoreSpacesResultBuilder();
    }

    protected FetchMoreSpacesResult(Parcel parcel) {
        super(parcel);
        this.f17079a = parcel.readLong();
        this.f17080b = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadSummary.CREATOR));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f17079a);
        parcel.writeTypedList(this.f17080b);
    }
}
