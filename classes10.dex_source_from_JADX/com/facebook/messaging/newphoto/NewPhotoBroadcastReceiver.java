package com.facebook.messaging.newphoto;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: revised sequence is null */
public class NewPhotoBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    public static final String f3359a = NewPhotoBroadcastReceiver.class.getSimpleName();
    public static final NewPhotoReceiver f3360b = new NewPhotoReceiver();

    /* compiled from: revised sequence is null */
    class NewPhotoReceiver implements ActionReceiver {
        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1761883066);
            SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
            String str = NewPhotoBroadcastReceiver.f3359a;
            secureContextHelper.c(new Intent(intent).setComponent(new ComponentName(context, NewPhotoIntentService.class)), context);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1544638357, a);
        }
    }

    public NewPhotoBroadcastReceiver() {
        super(new Builder().b("android.hardware.action.NEW_PICTURE", f3360b).b("com.android.camera.NEW_PICTURE", f3360b).b());
    }
}
