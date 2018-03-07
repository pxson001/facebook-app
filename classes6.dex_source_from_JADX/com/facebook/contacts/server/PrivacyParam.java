package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: packId */
public class PrivacyParam implements Parcelable {
    public static final Creator<PrivacyParam> CREATOR = new C05451();
    public static final PrivacyParam f8458a = new PrivacyParam("MUTUAL_FRIENDS");
    public static final PrivacyParam f8459b = new PrivacyParam("SELF");
    private final String f8460c;

    /* compiled from: packId */
    final class C05451 implements Creator<PrivacyParam> {
        C05451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PrivacyParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new PrivacyParam[i];
        }
    }

    private PrivacyParam(String str) {
        this.f8460c = str;
    }

    public PrivacyParam(Parcel parcel) {
        this.f8460c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8460c);
    }
}
