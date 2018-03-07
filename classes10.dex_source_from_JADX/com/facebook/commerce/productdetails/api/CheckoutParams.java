package com.facebook.commerce.productdetails.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: delete_message_dialog_tag */
public class CheckoutParams implements Parcelable {
    public static final Creator<CheckoutParams> CREATOR = new C21091();
    public final String f15132a;
    public final int f15133b;

    /* compiled from: delete_message_dialog_tag */
    final class C21091 implements Creator<CheckoutParams> {
        C21091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckoutParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CheckoutParams[i];
        }
    }

    public CheckoutParams(String str, int i) {
        this.f15132a = str;
        this.f15133b = i;
    }

    public CheckoutParams(Parcel parcel) {
        this.f15132a = parcel.readString();
        this.f15133b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15132a);
        parcel.writeInt(this.f15133b);
    }
}
