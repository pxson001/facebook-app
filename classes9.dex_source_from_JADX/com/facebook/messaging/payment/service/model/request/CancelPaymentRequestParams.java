package com.facebook.messaging.payment.service.model.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_first_batch_audiences_task_key */
public class CancelPaymentRequestParams implements Parcelable {
    public static final Creator<CancelPaymentRequestParams> CREATOR = new C16901();
    public static String f14704a = "CancelPaymentRequestParams";
    public final String f14705b;

    /* compiled from: fetch_first_batch_audiences_task_key */
    final class C16901 implements Creator<CancelPaymentRequestParams> {
        C16901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CancelPaymentRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CancelPaymentRequestParams[i];
        }
    }

    public CancelPaymentRequestParams(String str) {
        this.f14705b = str;
    }

    public CancelPaymentRequestParams(Parcel parcel) {
        this.f14705b = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("requestId", this.f14705b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14705b);
    }
}
