package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_albums */
public class FetchPaymentEligibleContactsParams implements Parcelable {
    public static final Creator<FetchPaymentEligibleContactsParams> CREATOR = new C05441();
    public final String f8456a;
    public final int f8457b;

    /* compiled from: page_albums */
    final class C05441 implements Creator<FetchPaymentEligibleContactsParams> {
        C05441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaymentEligibleContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaymentEligibleContactsParams[i];
        }
    }

    public FetchPaymentEligibleContactsParams(String str, int i) {
        this.f8456a = str;
        this.f8457b = i;
    }

    public FetchPaymentEligibleContactsParams(Parcel parcel) {
        this.f8456a = parcel.readString();
        this.f8457b = parcel.readInt();
    }

    public static boolean m12295a(CharSequence charSequence) {
        return !StringUtil.c(charSequence) && charSequence.toString().length() > 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8456a);
        parcel.writeInt(this.f8457b);
    }
}
