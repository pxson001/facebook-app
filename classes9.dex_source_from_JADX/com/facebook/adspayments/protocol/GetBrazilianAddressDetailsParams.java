package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: USE_CHAT_HEADS */
public class GetBrazilianAddressDetailsParams implements Parcelable {
    public static final Creator<GetBrazilianAddressDetailsParams> CREATOR = new C28641();
    public String f23698a;

    /* compiled from: USE_CHAT_HEADS */
    final class C28641 implements Creator<GetBrazilianAddressDetailsParams> {
        C28641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetBrazilianAddressDetailsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetBrazilianAddressDetailsParams[i];
        }
    }

    public GetBrazilianAddressDetailsParams(String str) {
        this.f23698a = str;
    }

    public GetBrazilianAddressDetailsParams(Parcel parcel) {
        this.f23698a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23698a);
    }
}
