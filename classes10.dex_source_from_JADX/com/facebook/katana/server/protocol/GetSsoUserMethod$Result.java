package com.facebook.katana.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: total_selected_message_guests */
public class GetSsoUserMethod$Result implements Parcelable {
    public static final Creator<GetSsoUserMethod$Result> CREATOR = new C02001();
    public final String f1172a;
    public final String f1173b;

    /* compiled from: total_selected_message_guests */
    final class C02001 implements Creator<GetSsoUserMethod$Result> {
        C02001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetSsoUserMethod$Result(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new GetSsoUserMethod$Result[0];
        }
    }

    public GetSsoUserMethod$Result(String str, String str2) {
        this.f1172a = str;
        this.f1173b = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1172a);
        parcel.writeString(this.f1173b);
    }
}
