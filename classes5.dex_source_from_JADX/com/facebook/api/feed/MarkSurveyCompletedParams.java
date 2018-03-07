package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: attempt_count */
public class MarkSurveyCompletedParams implements Parcelable {
    public static final Creator<MarkSurveyCompletedParams> CREATOR = new C09461();
    public final String f8715a;
    public final String f8716b;

    /* compiled from: attempt_count */
    final class C09461 implements Creator<MarkSurveyCompletedParams> {
        C09461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarkSurveyCompletedParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarkSurveyCompletedParams[i];
        }
    }

    public MarkSurveyCompletedParams(String str, String str2) {
        this.f8715a = str;
        this.f8716b = str2;
    }

    public MarkSurveyCompletedParams(Parcel parcel) {
        this.f8715a = parcel.readString();
        this.f8716b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8715a);
        parcel.writeString(this.f8716b);
    }

    public int describeContents() {
        return 0;
    }
}
