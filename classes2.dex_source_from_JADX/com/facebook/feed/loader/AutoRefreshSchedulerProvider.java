package com.facebook.feed.loader;

import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.feed.loader.AutoRefreshScheduler.RefreshSchedulerCallback;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: send_message_response */
public class AutoRefreshSchedulerProvider extends AbstractAssistedProvider<AutoRefreshScheduler> {
    public final AutoRefreshScheduler m9625a(RefreshSchedulerCallback refreshSchedulerCallback) {
        return new AutoRefreshScheduler(Handler_ForUiThreadMethodAutoProvider.m1701b(this), refreshSchedulerCallback);
    }
}
