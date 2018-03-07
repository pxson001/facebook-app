package com.facebook.auth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: suggestionMechanism */
public class SuggestedFacebookAccountInfo implements Parcelable {
    public static final Creator<CreateMessengerAccountCredentials> CREATOR = new C01541();
    public final String f2368a;
    public final String f2369b;
    public final String f2370c;
    public final String f2371d;

    /* compiled from: suggestionMechanism */
    final class C01541 implements Creator<CreateMessengerAccountCredentials> {
        C01541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreateMessengerAccountCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreateMessengerAccountCredentials[i];
        }
    }

    public SuggestedFacebookAccountInfo(String str, String str2, String str3, String str4) {
        this.f2368a = str;
        this.f2369b = str2;
        this.f2370c = str3;
        this.f2371d = str4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2368a);
        parcel.writeString(this.f2369b);
        parcel.writeString(this.f2370c);
        parcel.writeString(this.f2371d);
    }
}
