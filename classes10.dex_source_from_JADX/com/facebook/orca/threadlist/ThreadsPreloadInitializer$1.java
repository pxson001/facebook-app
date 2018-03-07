package com.facebook.orca.threadlist;

import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;

/* compiled from: my_location */
class ThreadsPreloadInitializer$1 extends OperationResultFutureCallback {
    final /* synthetic */ ThreadsPreloadInitializer f6753a;

    ThreadsPreloadInitializer$1(ThreadsPreloadInitializer threadsPreloadInitializer) {
        this.f6753a = threadsPreloadInitializer;
    }

    public final void m6434a(Object obj) {
        FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) ((OperationResult) obj).h();
        if (!fetchThreadListResult.c.d() && this.f6753a.b.h.isEmpty()) {
            int min = Math.min(this.f6753a.f.a(MessagingPrefKeys.aw, 10), 15);
            Serializable a = Lists.a();
            ImmutableList immutableList = fetchThreadListResult.c.c;
            int size = immutableList.size();
            int i = 1;
            int i2 = 0;
            while (i2 < size) {
                a.add(((ThreadSummary) immutableList.get(i2)).a);
                int i3 = i + 1;
                if (i == min) {
                    break;
                }
                i2++;
                i = i3;
            }
            Integer.valueOf(a.size());
            this.f6753a.b.k();
            Intent intent = new Intent(MessagesBroadcastIntents.i);
            intent.putExtra("threads", a);
            this.f6753a.c.a(intent);
        }
    }

    protected final void m6433a(ServiceException serviceException) {
        BLog.b("ThreadsPreloadInitializer", "Failed to preload threads", serviceException);
    }
}
