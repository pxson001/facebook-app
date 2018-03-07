package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.feedtype.FeedType;

/* compiled from: attached_action_links */
public class ValidateAgainstIdListParams implements Parcelable {
    public static final Creator<ValidateAgainstIdListParams> CREATOR = new C09571();
    private final FeedType f8761a;
    private final int f8762b;

    /* compiled from: attached_action_links */
    final class C09571 implements Creator<ValidateAgainstIdListParams> {
        C09571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ValidateAgainstIdListParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ValidateAgainstIdListParams[i];
        }
    }

    public ValidateAgainstIdListParams(Parcel parcel) {
        this.f8761a = (FeedType) parcel.readParcelable(FeedType.class.getClassLoader());
        this.f8762b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8761a, i);
        parcel.writeInt(this.f8762b);
    }
}
