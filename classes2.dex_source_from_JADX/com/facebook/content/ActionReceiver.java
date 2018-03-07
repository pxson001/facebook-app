package com.facebook.content;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectableComponentWithoutContext;

/* compiled from: upload_crash_monitor */
public interface ActionReceiver extends InjectableComponentWithoutContext {
    void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike);
}
