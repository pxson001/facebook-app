package com.facebook.push.mqtt.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.mqtt.service.MqttPushHelperService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: something to write */
public class BootCompleteBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    public static final Class<?> f4278a = BootCompleteBroadcastReceiver.class;
    private static final ActionReceiver f4279b = new InternalReceiver();
    private static final Map<String, ActionReceiver> f4280c;

    /* compiled from: something to write */
    class InternalReceiver implements ActionReceiver {
        public final void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -844840816);
            Class cls = BootCompleteBroadcastReceiver.f4278a;
            context.startService(new Intent(intent).setComponent(new ComponentName(context, MqttPushHelperService.class)));
            cls = BootCompleteBroadcastReceiver.f4278a;
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -114100682, a);
        }
    }

    static {
        Map hashMap = new HashMap();
        f4280c = hashMap;
        hashMap.put("android.intent.action.BOOT_COMPLETED", f4279b);
        f4280c.put("android.intent.action.MY_PACKAGE_REPLACED", f4279b);
    }

    public BootCompleteBroadcastReceiver() {
        super(f4280c);
    }
}
