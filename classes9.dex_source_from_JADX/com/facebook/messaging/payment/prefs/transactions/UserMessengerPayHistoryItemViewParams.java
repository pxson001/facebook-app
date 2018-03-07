package com.facebook.messaging.payment.prefs.transactions;

import com.facebook.messaging.payment.model.PaymentUser;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: friend_watcher_name */
public class UserMessengerPayHistoryItemViewParams implements MessengerPayHistoryItemViewParams {
    public final PaymentUser f14418a;
    public final MessengerPayHistoryItemViewCommonParams f14419b;

    public UserMessengerPayHistoryItemViewParams(UserMessengerPayHistoryItemViewParamsBuilder userMessengerPayHistoryItemViewParamsBuilder) {
        Preconditions.checkNotNull(userMessengerPayHistoryItemViewParamsBuilder.f14420a);
        Preconditions.checkNotNull(userMessengerPayHistoryItemViewParamsBuilder.f14421b);
        this.f14418a = userMessengerPayHistoryItemViewParamsBuilder.f14420a;
        this.f14419b = userMessengerPayHistoryItemViewParamsBuilder.f14421b;
    }

    public final MessengerPayHistoryItemViewCommonParams m14811a() {
        return this.f14419b;
    }

    public static UserMessengerPayHistoryItemViewParamsBuilder newBuilder() {
        return new UserMessengerPayHistoryItemViewParamsBuilder();
    }
}
