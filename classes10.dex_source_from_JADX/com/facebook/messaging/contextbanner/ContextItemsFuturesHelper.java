package com.facebook.messaging.contextbanner;

import com.facebook.debug.log.BLog;
import com.facebook.messaging.contextbanner.model.ContextItems;
import com.facebook.messaging.contextbanner.model.PageContextItems;
import com.facebook.messaging.contextbanner.ui.ContextBannerView;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.ui.name.ThreadNameViewComputer;
import com.facebook.messaging.ui.name.ThreadNameViewData;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: supported_section_types */
public class ContextItemsFuturesHelper {
    ThreadNameViewComputer f2185a;
    private ExecutorService f2186b;
    @Nullable
    public ListenableFuture<ContextItems> f2187c;
    @Nullable
    public ThreadKey f2188d;

    @Inject
    public ContextItemsFuturesHelper(ExecutorService executorService, ThreadNameViewComputer threadNameViewComputer) {
        this.f2186b = executorService;
        this.f2185a = threadNameViewComputer;
    }

    public final void m2009a(ThreadKey threadKey, final ContextBannerView contextBannerView, ListenableFuture<ContextItems> listenableFuture, ThreadNameViewData threadNameViewData, final ThreadTileViewData threadTileViewData) {
        Preconditions.checkNotNull(threadKey);
        if (!threadKey.equals(this.f2188d) || this.f2188d.a != Type.ONE_TO_ONE) {
            if (this.f2187c != null) {
                this.f2187c.cancel(true);
            }
            if (!threadKey.equals(this.f2188d)) {
                contextBannerView.setVisibility(8);
            }
            if (threadNameViewData == null || listenableFuture == null) {
                this.f2188d = null;
                this.f2187c = null;
                return;
            }
            this.f2187c = listenableFuture;
            this.f2188d = threadKey;
            final String charSequence = this.f2185a.a(threadNameViewData, 3).toString();
            Futures.a(listenableFuture, new FutureCallback<ContextItems>(this) {
                final /* synthetic */ ContextItemsFuturesHelper f2184d;

                public void onSuccess(@Nullable Object obj) {
                    ContextItems contextItems = (ContextItems) obj;
                    if (contextItems != null) {
                        int i = -1;
                        if ((contextItems instanceof PageContextItems) && ((PageContextItems) contextItems).m2094d()) {
                            i = 2130843878;
                        }
                        contextBannerView.m2110a(charSequence, contextItems.mo60a(), contextItems.mo61b(), contextItems.mo62c(), i, threadTileViewData, this.f2184d.f2188d);
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b("ContextItemsFuturesHelper", "Failed to fetch context data", th);
                }
            }, this.f2186b);
        }
    }
}
