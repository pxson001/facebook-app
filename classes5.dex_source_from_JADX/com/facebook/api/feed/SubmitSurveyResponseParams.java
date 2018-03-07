package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: attachment_file_names */
public class SubmitSurveyResponseParams implements Parcelable {
    public static final Creator<SubmitSurveyResponseParams> CREATOR = new C09541();
    public final String f8754a;
    public final String f8755b;
    public final String f8756c;
    public final String f8757d;

    /* compiled from: attachment_file_names */
    final class C09541 implements Creator<SubmitSurveyResponseParams> {
        C09541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SubmitSurveyResponseParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SubmitSurveyResponseParams[i];
        }
    }

    public SubmitSurveyResponseParams(String str, String str2, String str3, String str4) {
        this.f8754a = str;
        this.f8755b = str2;
        this.f8756c = str3;
        this.f8757d = str4;
    }

    public SubmitSurveyResponseParams(Parcel parcel) {
        this.f8754a = parcel.readString();
        this.f8755b = parcel.readString();
        this.f8756c = parcel.readString();
        this.f8757d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8754a);
        parcel.writeString(this.f8755b);
        parcel.writeString(this.f8756c);
        parcel.writeString(this.f8757d);
    }

    public int describeContents() {
        return 0;
    }
}
