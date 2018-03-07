package com.facebook.messaging.payment.pin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.payments.model.PaymentsPin;
import com.facebook.payments.model.SimplePaymentsPin;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PaymentPinDeserializer.class)
@Immutable
/* compiled from: handleFetchThreadList with freshness= */
public class PaymentPin implements Parcelable {
    public static final Creator<PaymentPin> CREATOR = new C15441();
    public static final PaymentPin f13711a = new PaymentPin();
    @JsonProperty("id")
    private final Long mPinId;

    /* compiled from: handleFetchThreadList with freshness= */
    final class C15441 implements Creator<PaymentPin> {
        C15441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentPin(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentPin[i];
        }
    }

    private PaymentPin() {
        this.mPinId = null;
    }

    public PaymentPin(long j) {
        this.mPinId = Long.valueOf(j);
    }

    public PaymentPin(Parcel parcel) {
        String readString = parcel.readString();
        this.mPinId = readString.equals("null") ? null : Long.valueOf(Long.parseLong(readString));
    }

    public final Optional<Long> m14261a() {
        return Optional.fromNullable(this.mPinId);
    }

    public final PaymentsPin m14262b() {
        return m14261a().isPresent() ? new SimplePaymentsPin(String.valueOf(m14261a().get())) : SimplePaymentsPin.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(String.valueOf(this.mPinId));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PaymentPin paymentPin = (PaymentPin) obj;
        if (m14261a().isPresent() != paymentPin.m14261a().isPresent()) {
            return false;
        }
        if (m14261a().isPresent() || paymentPin.m14261a().isPresent()) {
            return ((Long) m14261a().get()).equals(paymentPin.m14261a().get());
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mPinId});
    }
}
