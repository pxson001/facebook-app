package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.business.common.model.BusinessNuxItem;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: popup_nux */
public class RowBusinessNuxItem implements RowItem {
    public final ListenableFuture<BusinessNuxItem> f4725a;
    public final ThreadKey f4726b;

    public RowBusinessNuxItem(ListenableFuture<BusinessNuxItem> listenableFuture, ThreadKey threadKey) {
        this.f4725a = listenableFuture;
        this.f4726b = threadKey;
    }

    public final RowType mo131b() {
        return RowType.BUSINESS_NUX;
    }

    public final long m4287a() {
        return Long.MIN_VALUE;
    }
}
