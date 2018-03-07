package com.facebook.messaging.payment.service.model.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_entity_remote_typeahead */
public class DeclinePaymentRequestParams implements Parcelable {
    public static final Creator<DeclinePaymentRequestParams> CREATOR = new C16921();
    public static String f14714a = "DeclinePaymentRequestParams";
    public final String f14715b;

    /* compiled from: fetch_entity_remote_typeahead */
    final class C16921 implements Creator<DeclinePaymentRequestParams> {
        C16921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeclinePaymentRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeclinePaymentRequestParams[i];
        }
    }

    public DeclinePaymentRequestParams(String str) {
        this.f14715b = str;
    }

    public DeclinePaymentRequestParams(Parcel parcel) {
        this.f14715b = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("requestId", this.f14715b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14715b);
    }
}
