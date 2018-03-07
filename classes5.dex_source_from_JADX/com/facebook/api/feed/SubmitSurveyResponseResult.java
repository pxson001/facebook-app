package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: attachment */
public class SubmitSurveyResponseResult implements Parcelable {
    public static final Creator<SubmitSurveyResponseResult> CREATOR = new C09551();
    public final String f8758a;
    public final String f8759b;

    /* compiled from: attachment */
    final class C09551 implements Creator<SubmitSurveyResponseResult> {
        C09551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SubmitSurveyResponseResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SubmitSurveyResponseResult[i];
        }
    }

    public SubmitSurveyResponseResult(String str, String str2) {
        this.f8758a = str;
        this.f8759b = str2;
    }

    public SubmitSurveyResponseResult(Parcel parcel) {
        this.f8758a = parcel.readString();
        this.f8759b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8758a);
        parcel.writeString(this.f8759b);
    }
}
