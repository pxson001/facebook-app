package com.facebook.messaging.media.retry;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.content.ActionReceiver;
import javax.inject.Inject;

/* compiled from: saved_photo_index */
public class MediaRetryNetworkReceiver {
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager f3205a;
    public SelfRegistrableReceiverImpl f3206b;

    public final void m3141a(ActionReceiver actionReceiver) {
        if (this.f3206b == null) {
            this.f3206b = this.f3205a.a().a("com.facebook.orca.CONNECTIVITY_CHANGED", actionReceiver).a();
            this.f3206b.b();
        }
    }
}
