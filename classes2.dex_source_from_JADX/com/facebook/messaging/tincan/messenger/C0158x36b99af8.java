package com.facebook.messaging.tincan.messenger;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: total_pings_sent */
public class C0158x36b99af8 extends INeedInitForBroadcastReceiverRegistration<AttachmentUploadRetryColStartTrigger> {
    protected void onReceive(Context context, Intent intent, Object obj) {
        AttachmentUploadRetryColStartTrigger.c((AttachmentUploadRetryColStartTrigger) obj);
    }

    @Inject
    public C0158x36b99af8(Lazy<AttachmentUploadRetryColStartTrigger> lazy) {
        super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, "com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE");
    }
}
