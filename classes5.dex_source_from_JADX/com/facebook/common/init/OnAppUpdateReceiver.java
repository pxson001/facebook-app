package com.facebook.common.init;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: souvenir_cover_photo */
public class OnAppUpdateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1073799286);
        Log.i(OnAppUpdateReceiver.class.getName(), "Initialized application after update");
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2012005305, a);
    }
}
