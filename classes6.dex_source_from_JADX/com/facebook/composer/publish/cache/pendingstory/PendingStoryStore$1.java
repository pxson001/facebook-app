package com.facebook.composer.publish.cache.pendingstory;

import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: photos_of_ */
class PendingStoryStore$1 extends OperationResultFutureCallback2 {
    final /* synthetic */ Events f8026a;
    final /* synthetic */ String f8027b;
    final /* synthetic */ PendingStoryStore f8028c;

    PendingStoryStore$1(PendingStoryStore pendingStoryStore, Events events, String str) {
        this.f8028c = pendingStoryStore;
        this.f8026a = events;
        this.f8027b = str;
    }

    protected final void m11579a(OperationResult operationResult) {
        ((ComposerAnalyticsLogger) this.f8028c.e.get()).m11143a(this.f8026a, this.f8027b);
    }

    protected final void m11581a(Throwable th) {
        ((ComposerAnalyticsLogger) this.f8028c.e.get()).m11143a(Events.COMPOSER_SAVE_STORY_TO_DB_FAILED, this.f8027b);
        this.f8028c.f.a("pending_story_save_failed", "failed to save pending story, sessionId=" + this.f8027b, th);
    }
}
