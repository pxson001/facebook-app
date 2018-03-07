package com.facebook.orca.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;

/* compiled from: pageProps */
class FetchThreadsIntoMemoryCacheBackgroundTask$1 extends BroadcastReceiver {
    final /* synthetic */ FetchThreadsIntoMemoryCacheBackgroundTask f5249a;

    FetchThreadsIntoMemoryCacheBackgroundTask$1(FetchThreadsIntoMemoryCacheBackgroundTask fetchThreadsIntoMemoryCacheBackgroundTask) {
        this.f5249a = fetchThreadsIntoMemoryCacheBackgroundTask;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -242519900);
        Object parcelableArrayListExtra = intent.getParcelableArrayListExtra("threads");
        FetchThreadsIntoMemoryCacheBackgroundTask fetchThreadsIntoMemoryCacheBackgroundTask = this.f5249a;
        Integer.valueOf(parcelableArrayListExtra == null ? -1 : parcelableArrayListExtra.size());
        if (parcelableArrayListExtra == null) {
            fetchThreadsIntoMemoryCacheBackgroundTask.h = new ArrayList();
        } else {
            fetchThreadsIntoMemoryCacheBackgroundTask.h = new ArrayList(parcelableArrayListExtra);
        }
        fetchThreadsIntoMemoryCacheBackgroundTask.g();
        if (parcelableArrayListExtra != null) {
            if (parcelableArrayListExtra.size() > (((Boolean) fetchThreadsIntoMemoryCacheBackgroundTask.m.get()).booleanValue() ? 29 : 15)) {
                BLog.c("ThreadsInViewTooLarge", "Too many threads are in mThreadsInView: %d %s", new Object[]{Integer.valueOf(parcelableArrayListExtra.size()), parcelableArrayListExtra});
            }
        }
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -815971447, a);
    }
}
