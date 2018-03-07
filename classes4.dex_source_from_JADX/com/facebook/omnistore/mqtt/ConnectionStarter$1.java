package com.facebook.omnistore.mqtt;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.mqtt.external.PushStateEvent;

/* compiled from: fb_server_registered */
public class ConnectionStarter$1 implements ActionReceiver {
    final /* synthetic */ ConnectionStarter this$0;
    final /* synthetic */ OmnistoreMqttJniHandler$1 val$callback;

    public ConnectionStarter$1(ConnectionStarter connectionStarter, OmnistoreMqttJniHandler$1 omnistoreMqttJniHandler$1) {
        this.this$0 = connectionStarter;
        this.val$callback = omnistoreMqttJniHandler$1;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 411306593);
        OmnistoreMqttJniHandler$1 omnistoreMqttJniHandler$1 = this.val$callback;
        if (PushStateEvent.CHANNEL_CONNECTED.equals(PushStateEvent.fromValue(intent.getIntExtra("event", PushStateEvent.UNKNOWN.toValue())))) {
            omnistoreMqttJniHandler$1.onConnectionEstablished();
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1793222018, a);
    }
}
