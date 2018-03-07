package com.facebook.api.feedtype.newsfeed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: return_to_caller */
public class NewsFeedTypeValue implements Parcelable {
    public static final Creator<NewsFeedTypeValue> CREATOR = new 1();
    public String f6725a;
    public String f6726b;

    public NewsFeedTypeValue(String str, String str2) {
        this.f6725a = str;
        this.f6726b = str2;
    }

    public NewsFeedTypeValue(Parcel parcel) {
        this.f6725a = parcel.readString();
        this.f6726b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6725a);
        parcel.writeString(this.f6726b);
    }

    public int describeContents() {
        return 0;
    }
}
