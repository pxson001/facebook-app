package com.facebook.messaging.payment.prefs.transactions;

import android.graphics.Typeface;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: from_instance_id */
public class MessengerPayHistoryStatusViewParams {
    public final Typeface f14383a;
    public final MessengerPayHistoryStatusViewState f14384b;
    public final String f14385c;

    public MessengerPayHistoryStatusViewParams(MessengerPayHistoryStatusViewParamsBuilder messengerPayHistoryStatusViewParamsBuilder) {
        Preconditions.checkNotNull(messengerPayHistoryStatusViewParamsBuilder.f14386a);
        Preconditions.checkNotNull(messengerPayHistoryStatusViewParamsBuilder.f14387b);
        Preconditions.checkNotNull(messengerPayHistoryStatusViewParamsBuilder.f14388c);
        this.f14383a = messengerPayHistoryStatusViewParamsBuilder.f14386a;
        this.f14384b = messengerPayHistoryStatusViewParamsBuilder.f14387b;
        this.f14385c = messengerPayHistoryStatusViewParamsBuilder.f14388c;
    }

    public static MessengerPayHistoryStatusViewParamsBuilder newBuilder() {
        return new MessengerPayHistoryStatusViewParamsBuilder();
    }
}
