package com.facebook.orca.notify;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

/* compiled from: new_theme_color */
class UnreadThreadsBadgeCountCalculator$2 implements Runnable {
    final /* synthetic */ UnreadThreadsBadgeCountCalculator f6294a;

    /* compiled from: new_theme_color */
    class C09511 extends OperationResultFutureCallback {
        final /* synthetic */ UnreadThreadsBadgeCountCalculator$2 f6293a;

        C09511(UnreadThreadsBadgeCountCalculator$2 unreadThreadsBadgeCountCalculator$2) {
            this.f6293a = unreadThreadsBadgeCountCalculator$2;
        }

        public final void m5974a(Object obj) {
            FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) ((OperationResult) obj).h();
            UnreadThreadsBadgeCountCalculator unreadThreadsBadgeCountCalculator = this.f6293a.f6294a;
            ImmutableList immutableList = fetchThreadListResult.c.c;
            int size = immutableList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
                if (threadSummary.f()) {
                    Object obj2;
                    if (unreadThreadsBadgeCountCalculator.g.a(threadSummary.a).b()) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        i3 = i2 + 1;
                        i++;
                        i2 = i3;
                    }
                }
                i3 = i2;
                i++;
                i2 = i3;
            }
            this.f6293a.f6294a.f.a(i2);
        }

        protected final void m5973a(ServiceException serviceException) {
            BLog.a(UnreadThreadsBadgeCountCalculator.a, serviceException, "Fetch threads failed", new Object[0]);
        }
    }

    UnreadThreadsBadgeCountCalculator$2(UnreadThreadsBadgeCountCalculator unreadThreadsBadgeCountCalculator) {
        this.f6294a = unreadThreadsBadgeCountCalculator;
    }

    public void run() {
        FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
        newBuilder.a = DataFreshnessParam.DO_NOT_CHECK_SERVER;
        newBuilder = newBuilder;
        newBuilder.b = FolderName.INBOX;
        newBuilder = newBuilder;
        newBuilder.f = 20;
        FetchThreadListParams h = newBuilder.h();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchThreadListParams", h);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f6294a.e, "fetch_thread_list", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(MessengerLauncherBadgesController.class), 1345250709).b(), new C09511(this), this.f6294a.c);
    }
}
