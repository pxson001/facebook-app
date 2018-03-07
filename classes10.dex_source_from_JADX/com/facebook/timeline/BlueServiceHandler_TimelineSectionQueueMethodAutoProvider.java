package com.facebook.timeline;

import com.facebook.composer.publish.ComposerPublishServiceHandler;
import com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.privacy.service.PrivacyCacheServiceHandler;
import com.facebook.timeline.service.TimelineSectionServiceHandler;

/* compiled from: guest_statuses */
public class BlueServiceHandler_TimelineSectionQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    public Object get() {
        return TimelineModule.m10331a(PrivacyCacheServiceHandler.a(this), ComposerPublishDbCacheServiceHandler.a(this), ComposerPublishServiceHandler.b(this), TimelineSectionServiceHandler.m12679b(this));
    }
}
