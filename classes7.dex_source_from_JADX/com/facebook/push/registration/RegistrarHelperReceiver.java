package com.facebook.push.registration;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: has_photo */
public class RegistrarHelperReceiver extends DynamicSecureBroadcastReceiver {
    public static final Class<?> f11344a = RegistrarHelperReceiver.class;

    /* compiled from: has_photo */
    public class LocalActionReceiver implements ActionReceiver {
        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -347073938);
            if (intent != null && "com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY".equals(intent.getAction()) && intent.hasExtra("serviceType")) {
                context.startService(new Intent(intent).setComponent(new ComponentName(context, RegistrarHelperService.class)));
                LogUtils.e(-276142052, a);
                return;
            }
            BLog.a(RegistrarHelperReceiver.f11344a, "Incorrect intent %s", new Object[]{intent});
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 279973730, a);
        }
    }

    public RegistrarHelperReceiver() {
        super("com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY", new LocalActionReceiver());
    }
}
