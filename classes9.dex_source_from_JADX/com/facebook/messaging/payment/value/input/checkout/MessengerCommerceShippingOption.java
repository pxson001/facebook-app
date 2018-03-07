package com.facebook.messaging.payment.value.input.checkout;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.payments.shipping.model.ShippingOption;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: encodeTexture failed */
public class MessengerCommerceShippingOption implements ShippingOption {
    public static final Creator<MessengerCommerceShippingOption> CREATOR = new C18561();
    public PaymentShippingOptionModel f15783a;

    /* compiled from: encodeTexture failed */
    final class C18561 implements Creator<MessengerCommerceShippingOption> {
        C18561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessengerCommerceShippingOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessengerCommerceShippingOption[i];
        }
    }

    public MessengerCommerceShippingOption(PaymentShippingOptionModel paymentShippingOptionModel) {
        this.f15783a = paymentShippingOptionModel;
    }

    public MessengerCommerceShippingOption(Parcel parcel) {
        this.f15783a = (PaymentShippingOptionModel) FlatBufferModelHelper.a(parcel);
    }

    public final String mo646a() {
        return this.f15783a.m13825b();
    }

    public final String mo647b() {
        return this.f15783a.lz_();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f15783a);
    }
}
