package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.business.common.model.BusinessGreetingItem;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: popup_state */
public class RowBusinessGreetingItem implements RowItem {
    public final ListenableFuture<BusinessGreetingItem> f4723a;
    private final String f4724b;

    public RowBusinessGreetingItem(ListenableFuture<BusinessGreetingItem> listenableFuture, String str) {
        this.f4723a = listenableFuture;
        this.f4724b = str;
    }

    public final RowType mo131b() {
        return RowType.BUSINESS_GREETING;
    }

    public final long m4285a() {
        return Long.parseLong(this.f4724b);
    }
}
