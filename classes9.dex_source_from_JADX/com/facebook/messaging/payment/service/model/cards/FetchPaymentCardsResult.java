package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.model.PaymentCard;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: findfriends/browse.* */
public class FetchPaymentCardsResult implements Parcelable {
    public static final Creator<FetchPaymentCardsResult> CREATOR = new C16711();
    public static final FetchPaymentCardsResult f14634a = new FetchPaymentCardsResult(null, RegularImmutableList.a);
    public final PaymentCard f14635b;
    public final ImmutableList<PaymentCard> f14636c;

    /* compiled from: findfriends/browse.* */
    final class C16711 implements Creator<FetchPaymentCardsResult> {
        C16711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaymentCardsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaymentCardsResult[i];
        }
    }

    public FetchPaymentCardsResult(@Nullable PaymentCard paymentCard, List<PaymentCard> list) {
        this.f14635b = paymentCard;
        this.f14636c = ImmutableList.copyOf(list);
    }

    public FetchPaymentCardsResult(Parcel parcel) {
        this.f14635b = (PaymentCard) parcel.readParcelable(PaymentCard.class.getClassLoader());
        this.f14636c = ImmutableList.copyOf(parcel.readArrayList(PaymentCard.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14635b, i);
        parcel.writeList(this.f14636c);
    }
}
