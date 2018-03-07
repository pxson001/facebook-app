package com.facebook.appupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: UNKNOWN_STATUS */
public class DownloadCompleteReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1407846465);
        long longExtra = intent.getLongExtra("extra_download_id", -1);
        if (longExtra == -1) {
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -499804266, a);
            return;
        }
        Intent intent2 = new Intent(context, AppUpdateService.class);
        intent2.setAction("download_complete");
        intent2.putExtra("download_id", longExtra);
        context.startService(intent2);
        LogUtils.a(intent, 1740211613, a);
    }
}
