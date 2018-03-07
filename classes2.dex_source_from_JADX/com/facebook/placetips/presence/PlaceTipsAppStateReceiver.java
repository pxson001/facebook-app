package com.facebook.placetips.presence;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.bootstrap.PlaceTipsEnabledFuture;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

/* compiled from: total_conns_started */
public class PlaceTipsAppStateReceiver extends INeedInitForBroadcastReceiverRegistration<PagePresenceManagerFuture> {
    private final Lazy<PlaceTipsEnabledFuture> f2373a;

    protected void onReceive(Context context, Intent intent, Object obj) {
        Futures.m2458a((PagePresenceManagerFuture) obj, new 2(this), MoreExecutors.m1813a());
    }

    @Inject
    public PlaceTipsAppStateReceiver(Lazy<PlaceTipsEnabledFuture> lazy, Lazy<PagePresenceManagerFuture> lazy2) {
        super(FbBroadcastManagerType.LOCAL, (Lazy) lazy2, AppStateManager.f1111c);
        this.f2373a = lazy;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2086123585);
        if (AppStateManager.f1111c.equals(intent == null ? null : intent.getAction())) {
            Futures.m2458a((ListenableFuture) this.f2373a.get(), new 1(this, context, intent, broadcastReceiverLike), MoreExecutors.m1813a());
            LogUtils.e(-1073565638, a);
            return;
        }
        LogUtils.e(-1838280383, a);
    }
}
