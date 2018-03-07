package com.facebook.messaging.payment.service.model.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_cached_feedback_permalink */
public class FetchPaymentRequestParams implements Parcelable {
    public static final Creator<FetchPaymentRequestParams> CREATOR = new C16931();
    public static String f14716a = "FetchPaymentRequestParams";
    public final String f14717b;

    /* compiled from: fetch_cached_feedback_permalink */
    final class C16931 implements Creator<FetchPaymentRequestParams> {
        C16931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaymentRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaymentRequestParams[i];
        }
    }

    public FetchPaymentRequestParams(String str) {
        Preconditions.checkNotNull(str);
        this.f14717b = str;
    }

    public FetchPaymentRequestParams(Parcel parcel) {
        this.f14717b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14717b);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("requestId", this.f14717b).toString();
    }
}
