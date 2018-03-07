package com.facebook.messaging.payment.prefs.transactions;

import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.PaymentTransactionType;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fullscreen */
public class MessengerPayHistoryItemViewCommonParams {
    public final PaymentTransactionType f14338a;
    public final String f14339b;
    public final Amount f14340c;
    public final MessengerPayHistoryStatusViewParams f14341d;
    public final boolean f14342e;

    public MessengerPayHistoryItemViewCommonParams(MessengerPayHistoryItemViewCommonParamsBuilder messengerPayHistoryItemViewCommonParamsBuilder) {
        Preconditions.checkNotNull(messengerPayHistoryItemViewCommonParamsBuilder.f14343a);
        Preconditions.checkNotNull(messengerPayHistoryItemViewCommonParamsBuilder.f14344b);
        Preconditions.checkNotNull(messengerPayHistoryItemViewCommonParamsBuilder.f14345c);
        Preconditions.checkNotNull(messengerPayHistoryItemViewCommonParamsBuilder.f14346d);
        Preconditions.checkNotNull(messengerPayHistoryItemViewCommonParamsBuilder.f14347e);
        this.f14338a = messengerPayHistoryItemViewCommonParamsBuilder.f14343a;
        this.f14339b = messengerPayHistoryItemViewCommonParamsBuilder.f14344b;
        this.f14340c = messengerPayHistoryItemViewCommonParamsBuilder.f14345c;
        this.f14341d = messengerPayHistoryItemViewCommonParamsBuilder.f14346d;
        this.f14342e = messengerPayHistoryItemViewCommonParamsBuilder.f14347e.booleanValue();
    }

    public static MessengerPayHistoryItemViewCommonParamsBuilder newBuilder() {
        return new MessengerPayHistoryItemViewCommonParamsBuilder();
    }
}
