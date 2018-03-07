package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.contextbanner.model.ContextItems;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.ui.name.ThreadNameViewData;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: play_tapped */
public class RowSocialContextItem implements RowItem {
    public final ListenableFuture<ContextItems> f4766a;
    public final ThreadKey f4767b;
    public boolean f4768c;
    public ThreadNameViewData f4769d;
    public ThreadTileViewData f4770e;

    public RowSocialContextItem(ListenableFuture<ContextItems> listenableFuture, ThreadKey threadKey, boolean z, ThreadNameViewData threadNameViewData, ThreadTileViewData threadTileViewData) {
        this.f4766a = listenableFuture;
        this.f4767b = threadKey;
        this.f4768c = z;
        this.f4769d = threadNameViewData;
        this.f4770e = threadTileViewData;
    }

    public final RowType mo131b() {
        return RowType.SOCIAL_CONTEXT;
    }

    public final long m4323a() {
        return Long.MIN_VALUE;
    }

    public String toString() {
        return "RowSocialContextItem";
    }
}
