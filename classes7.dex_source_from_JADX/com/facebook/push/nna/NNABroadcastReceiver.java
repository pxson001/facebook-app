package com.facebook.push.nna;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: header_image100 */
public class NNABroadcastReceiver extends DynamicSecureBroadcastReceiver {
    private static final Class<?> f11314a = NNABroadcastReceiver.class;

    /* compiled from: header_image100 */
    class NNAActionReceiver implements ActionReceiver {
        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1177424117);
            intent.getAction();
            NNAServiceHelperClass.m13217b(FbInjector.get(context)).m13218a(intent);
            broadcastReceiverLike.setResult(-1, null, null);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1598186666, a);
        }
    }

    public NNABroadcastReceiver() {
        super(new Builder().b("com.nokia.pushnotifications.intent.REGISTRATION", new NNAActionReceiver()).b("com.nokia.pushnotifications.intent.RECEIVE", new NNAActionReceiver()).b());
    }
}
