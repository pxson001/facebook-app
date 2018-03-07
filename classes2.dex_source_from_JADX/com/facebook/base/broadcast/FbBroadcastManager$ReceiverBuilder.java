package com.facebook.base.broadcast;

import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.content.ActionReceiver;

/* compiled from: upload_crash_monitor_temp */
public interface FbBroadcastManager$ReceiverBuilder {
    SelfRegistrableReceiverImpl mo503a();

    FbBroadcastManager$ReceiverBuilder mo504a(IntentFilter intentFilter);

    FbBroadcastManager$ReceiverBuilder mo505a(Handler handler);

    FbBroadcastManager$ReceiverBuilder mo506a(String str, ActionReceiver actionReceiver);
}
