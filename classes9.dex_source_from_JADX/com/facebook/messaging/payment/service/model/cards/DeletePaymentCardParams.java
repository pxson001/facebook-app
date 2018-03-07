package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: finish_ */
public class DeletePaymentCardParams implements Parcelable {
    public static final Creator<DeletePaymentCardParams> CREATOR = new C16691();
    public static String f14626a = "deletePaymentCardParams";
    public final long f14627b;

    /* compiled from: finish_ */
    final class C16691 implements Creator<DeletePaymentCardParams> {
        C16691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePaymentCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePaymentCardParams[i];
        }
    }

    public DeletePaymentCardParams(long j) {
        this.f14627b = j;
    }

    public DeletePaymentCardParams(Parcel parcel) {
        this.f14627b = parcel.readLong();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("credentialId", this.f14627b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f14627b);
    }
}
