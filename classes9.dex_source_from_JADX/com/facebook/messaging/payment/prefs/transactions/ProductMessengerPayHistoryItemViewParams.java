package com.facebook.messaging.payment.prefs.transactions;

import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: friends_only_feed */
public class ProductMessengerPayHistoryItemViewParams implements MessengerPayHistoryItemViewParams {
    public final String f14408a;
    public final int f14409b;
    public final MessengerPayHistoryItemViewCommonParams f14410c;

    public ProductMessengerPayHistoryItemViewParams(ProductMessengerPayHistoryItemViewParamsBuilder productMessengerPayHistoryItemViewParamsBuilder) {
        boolean z;
        if (productMessengerPayHistoryItemViewParamsBuilder.f14411a == null && productMessengerPayHistoryItemViewParamsBuilder.f14412b == 0) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotNull(productMessengerPayHistoryItemViewParamsBuilder.f14413c);
        this.f14408a = productMessengerPayHistoryItemViewParamsBuilder.f14411a;
        this.f14409b = productMessengerPayHistoryItemViewParamsBuilder.f14412b;
        this.f14410c = productMessengerPayHistoryItemViewParamsBuilder.f14413c;
    }

    public final MessengerPayHistoryItemViewCommonParams m14792a() {
        return this.f14410c;
    }

    public static ProductMessengerPayHistoryItemViewParamsBuilder newBuilder() {
        return new ProductMessengerPayHistoryItemViewParamsBuilder();
    }
}
