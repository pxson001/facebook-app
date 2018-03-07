package com.facebook.oxygen.preloads.integration.tosacceptance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: textShadowColor */
public class TosAcceptedFlagComponent extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1650817207, Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 185339135));
    }
}
