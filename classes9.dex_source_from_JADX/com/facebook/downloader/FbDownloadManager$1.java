package com.facebook.downloader;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.downloader.DownloadRequest.DownloadType;
import com.facebook.downloader.event.DownloadBroadcastEvent;
import com.facebook.downloader.event.DownloadEventBus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;

/* compiled from: The field 'action_result' has been assigned the invalid value  */
class FbDownloadManager$1 implements ActionReceiver {
    final /* synthetic */ FbDownloadManager f24244a;

    FbDownloadManager$1(FbDownloadManager fbDownloadManager) {
        this.f24244a = fbDownloadManager;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1517542226);
        final long j = intent.getExtras().getLong("extra_download_id");
        ExecutorDetour.a(this.f24244a.g, new NamedRunnable(this, "FbDownloadManager", "PostDownloadBroadcastEvent") {
            final /* synthetic */ FbDownloadManager$1 f24243d;

            public void run() {
                String str;
                DownloadEventBus downloadEventBus = this.f24243d.f24244a.h;
                DownloadType a = FbDownloadManager.a(this.f24243d.f24244a, j);
                FbDownloadManager fbDownloadManager = this.f24243d.f24244a;
                long j = j;
                if (fbDownloadManager.l.containsKey(Long.valueOf(j))) {
                    DownloadRequest downloadRequest = (DownloadRequest) fbDownloadManager.l.get(Long.valueOf(j));
                    if (downloadRequest != null) {
                        str = downloadRequest.f24239g;
                        downloadEventBus.a(new DownloadBroadcastEvent(a, str, j));
                    }
                }
                str = null;
                downloadEventBus.a(new DownloadBroadcastEvent(a, str, j));
            }
        }, 95835324);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -610308268, a);
    }
}
