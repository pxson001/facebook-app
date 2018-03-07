package com.facebook.payments.checkout.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineState;
import com.facebook.payments.model.PaymentsPin;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingOption;
import com.facebook.payments.util.PaymentsParcelableUtil;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: canonical_thread_profile */
public class SimpleCheckoutData implements CheckoutData {
    public static final Creator<SimpleCheckoutData> CREATOR = new C21451();
    private final CheckoutParams f18490a;
    private final boolean f18491b;
    private final CheckoutItemPrice f18492c;
    private final PaymentsPin f18493d;
    private final String f18494e;
    private final Optional<MailingAddress> f18495f;
    private final ImmutableList<MailingAddress> f18496g;
    private final Optional<ShippingOption> f18497h;
    private final ImmutableList<ShippingOption> f18498i;
    private final Flattenable f18499j;
    private final CheckoutStateMachineState f18500k;
    private final Optional<PaymentMethod> f18501l;
    private final ImmutableList<PaymentMethod> f18502m;

    /* compiled from: canonical_thread_profile */
    final class C21451 implements Creator<SimpleCheckoutData> {
        C21451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleCheckoutData(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleCheckoutData[i];
        }
    }

    public static SimpleCheckoutDataBuilder newBuilder() {
        return new SimpleCheckoutDataBuilder();
    }

    public SimpleCheckoutData(SimpleCheckoutDataBuilder simpleCheckoutDataBuilder) {
        this.f18490a = simpleCheckoutDataBuilder.f18503a;
        this.f18491b = simpleCheckoutDataBuilder.f18504b;
        this.f18492c = simpleCheckoutDataBuilder.f18505c;
        this.f18493d = simpleCheckoutDataBuilder.f18506d;
        this.f18494e = simpleCheckoutDataBuilder.f18507e;
        this.f18495f = simpleCheckoutDataBuilder.f18508f;
        this.f18496g = simpleCheckoutDataBuilder.f18509g;
        this.f18497h = simpleCheckoutDataBuilder.f18510h;
        this.f18498i = simpleCheckoutDataBuilder.f18511i;
        this.f18499j = simpleCheckoutDataBuilder.f18512j;
        this.f18500k = (CheckoutStateMachineState) Preconditions.checkNotNull(simpleCheckoutDataBuilder.f18513k);
        this.f18501l = simpleCheckoutDataBuilder.f18514l;
        this.f18502m = simpleCheckoutDataBuilder.f18515m;
    }

    public SimpleCheckoutData(Parcel parcel) {
        this.f18490a = (CheckoutParams) parcel.readParcelable(CheckoutParams.class.getClassLoader());
        this.f18491b = ParcelUtil.a(parcel);
        this.f18492c = (CheckoutItemPrice) parcel.readParcelable(CheckoutItemPrice.class.getClassLoader());
        this.f18493d = (PaymentsPin) parcel.readParcelable(PaymentsPin.class.getClassLoader());
        this.f18494e = parcel.readString();
        this.f18495f = PaymentsParcelableUtil.b(parcel, MailingAddress.class);
        this.f18496g = PaymentsParcelableUtil.a(parcel, MailingAddress.class);
        this.f18497h = PaymentsParcelableUtil.b(parcel, ShippingOption.class);
        this.f18498i = PaymentsParcelableUtil.a(parcel, ShippingOption.class);
        this.f18499j = FlatBufferModelHelper.a(parcel);
        this.f18500k = (CheckoutStateMachineState) ParcelUtil.c(parcel, CheckoutStateMachineState.class);
        this.f18501l = PaymentsParcelableUtil.b(parcel, PaymentMethod.class);
        this.f18502m = PaymentsParcelableUtil.a(parcel, PaymentMethod.class);
    }

    public final CheckoutParams mo717a() {
        return this.f18490a;
    }

    public final boolean mo718b() {
        return this.f18491b;
    }

    @Nullable
    public final CheckoutItemPrice mo719c() {
        return this.f18492c;
    }

    @Nullable
    public final PaymentsPin mo720d() {
        return this.f18493d;
    }

    @Nullable
    public final String mo721e() {
        return this.f18494e;
    }

    @Nullable
    public final Optional<MailingAddress> mo722f() {
        return this.f18495f;
    }

    @Nullable
    public final ImmutableList<MailingAddress> mo723g() {
        return this.f18496g;
    }

    @Nullable
    public final Optional<ShippingOption> mo724h() {
        return this.f18497h;
    }

    @Nullable
    public final ImmutableList<ShippingOption> mo725i() {
        return this.f18498i;
    }

    @Nullable
    public final Flattenable mo726j() {
        return this.f18499j;
    }

    public final CheckoutStateMachineState mo727k() {
        return this.f18500k;
    }

    @Nullable
    public final Optional<PaymentMethod> mo728l() {
        return this.f18501l;
    }

    public final ImmutableList<PaymentMethod> mo729m() {
        return this.f18502m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f18490a, i);
        ParcelUtil.a(parcel, this.f18491b);
        parcel.writeParcelable(this.f18492c, i);
        parcel.writeParcelable(this.f18493d, i);
        parcel.writeString(this.f18494e);
        PaymentsParcelableUtil.a(this.f18495f, parcel, i);
        parcel.writeList(this.f18496g);
        PaymentsParcelableUtil.a(this.f18497h, parcel, i);
        parcel.writeList(this.f18498i);
        FlatBufferModelHelper.a(parcel, this.f18499j);
        ParcelUtil.a(parcel, this.f18500k);
        PaymentsParcelableUtil.a(this.f18501l, parcel, i);
        parcel.writeList(this.f18502m);
    }
}
