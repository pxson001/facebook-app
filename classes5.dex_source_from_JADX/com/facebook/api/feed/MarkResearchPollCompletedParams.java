package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: attending_activity */
public class MarkResearchPollCompletedParams implements Parcelable {
    public static final Creator<MarkResearchPollCompletedParams> CREATOR = new C09451();
    public final String f8713a;
    public final String f8714b;

    /* compiled from: attending_activity */
    final class C09451 implements Creator<MarkResearchPollCompletedParams> {
        C09451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkResearchPollCompletedParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkResearchPollCompletedParams[i];
        }
    }

    public MarkResearchPollCompletedParams(String str, String str2) {
        this.f8713a = str;
        this.f8714b = str2;
    }

    public MarkResearchPollCompletedParams(Parcel parcel) {
        this.f8713a = parcel.readString();
        this.f8714b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8713a);
        parcel.writeString(this.f8714b);
    }

    public int describeContents() {
        return 0;
    }
}
