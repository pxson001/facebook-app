package com.facebook.messaging.payment.pin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* compiled from: handleNewMessageResult_null_message */
public class FetchPageInfoParams implements Parcelable {
    public static final Creator<FetchPageInfoParams> CREATOR = new C15431();
    public static String f13709a = "fetchPageInfoParams";
    public final String f13710b;

    /* compiled from: handleNewMessageResult_null_message */
    final class C15431 implements Creator<FetchPageInfoParams> {
        C15431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPageInfoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPageInfoParams[i];
        }
    }

    public FetchPageInfoParams(String str) {
        Preconditions.checkNotNull(str);
        this.f13710b = str;
    }

    public FetchPageInfoParams(Parcel parcel) {
        this.f13710b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13710b);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("pageId", this.f13710b).toString();
    }
}
