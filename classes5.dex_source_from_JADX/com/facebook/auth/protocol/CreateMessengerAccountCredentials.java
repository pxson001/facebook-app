package com.facebook.auth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: supported_app_stores */
public class CreateMessengerAccountCredentials implements Parcelable {
    public static final Creator<CreateMessengerAccountCredentials> CREATOR = new C01441();
    public final String f2318a;
    public final String f2319b;
    public final String f2320c;

    /* compiled from: supported_app_stores */
    final class C01441 implements Creator<CreateMessengerAccountCredentials> {
        C01441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreateMessengerAccountCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreateMessengerAccountCredentials[i];
        }
    }

    public CreateMessengerAccountCredentials(Parcel parcel) {
        this.f2318a = parcel.readString();
        this.f2319b = parcel.readString();
        this.f2320c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2318a);
        parcel.writeString(this.f2319b);
        parcel.writeString(this.f2320c);
    }
}
