package com.facebook.composer.publish.cache.pendingstory;

import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: photos_of_ */
class PendingStoryStore$2 extends OperationResultFutureCallback2 {
    final /* synthetic */ String f8029a;
    final /* synthetic */ PendingStoryStore f8030b;

    PendingStoryStore$2(PendingStoryStore pendingStoryStore, String str) {
        this.f8030b = pendingStoryStore;
        this.f8029a = str;
    }

    protected final void m11582a(OperationResult operationResult) {
        ((ComposerAnalyticsLogger) this.f8030b.e.get()).m11143a(Events.COMPOSER_DELETE_STORY_FROM_DB, this.f8029a);
    }

    protected final void m11584a(Throwable th) {
        ((ComposerAnalyticsLogger) this.f8030b.e.get()).m11143a(Events.COMPOSER_DELETE_STORY_FROM_DB_FAILED, this.f8029a);
        this.f8030b.f.a("pending_story_delete_failed", "failed to delete pending story, sessionId=" + this.f8029a, th);
    }
}
