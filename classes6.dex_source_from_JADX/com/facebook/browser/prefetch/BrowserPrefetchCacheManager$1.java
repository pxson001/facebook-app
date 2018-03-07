package com.facebook.browser.prefetch;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: processPhoto Exception */
class BrowserPrefetchCacheManager$1 implements ActionReceiver {
    final /* synthetic */ BrowserPrefetchCacheManager f7410a;

    BrowserPrefetchCacheManager$1(BrowserPrefetchCacheManager browserPrefetchCacheManager) {
        this.f7410a = browserPrefetchCacheManager;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 531181146);
        BrowserPrefetchCacheManager.f(this.f7410a);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 874934841, a);
    }
}
