package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.service.model.pay.SendPaymentBankDetails;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: field_setting */
public class NewNetBankingOption implements NewPaymentOption {
    public static final Creator<NewNetBankingOption> CREATOR = new C16751();
    private final String f14650a;
    public final ImmutableList<SendPaymentBankDetails> f14651b;

    /* compiled from: field_setting */
    final class C16751 implements Creator<NewNetBankingOption> {
        C16751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewNetBankingOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewNetBankingOption[i];
        }
    }

    public NewNetBankingOption(@Nullable String str, ImmutableList<SendPaymentBankDetails> immutableList) {
        this.f14650a = str;
        this.f14651b = immutableList;
    }

    public NewNetBankingOption(Parcel parcel) {
        this.f14650a = parcel.readString();
        Collection readArrayList = parcel.readArrayList(SendPaymentBankDetails.class.getClassLoader());
        this.f14651b = readArrayList != null ? ImmutableList.copyOf(readArrayList) : null;
    }

    public final NewPaymentOptionType m15164a() {
        return NewPaymentOptionType.NEW_NET_BANKING;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14650a);
        parcel.writeList(this.f14651b.asList());
    }
}
