package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: sticker_store_done */
public class EditReviewPrivacyParams implements Parcelable {
    public static final Creator<EditReviewPrivacyParams> CREATOR = new C02321();
    public final long f4133a;
    public final String f4134b;

    /* compiled from: sticker_store_done */
    final class C02321 implements Creator<EditReviewPrivacyParams> {
        C02321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditReviewPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditReviewPrivacyParams[i];
        }
    }

    public EditReviewPrivacyParams(String str, long j) {
        this.f4133a = j;
        this.f4134b = str;
    }

    public EditReviewPrivacyParams(Parcel parcel) {
        this.f4133a = parcel.readLong();
        this.f4134b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4133a);
        parcel.writeString(this.f4134b);
    }
}
