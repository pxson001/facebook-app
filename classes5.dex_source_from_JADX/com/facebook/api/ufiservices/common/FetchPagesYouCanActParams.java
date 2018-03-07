package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: android_page_more_information_suggest_edits */
public class FetchPagesYouCanActParams implements Parcelable {
    public static final Creator<FetchPagesYouCanActParams> CREATOR = new C09911();
    public final String f10306a;

    /* compiled from: android_page_more_information_suggest_edits */
    final class C09911 implements Creator<FetchPagesYouCanActParams> {
        C09911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPagesYouCanActParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPagesYouCanActParams[i];
        }
    }

    public FetchPagesYouCanActParams(Parcel parcel) {
        this.f10306a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10306a);
    }
}
