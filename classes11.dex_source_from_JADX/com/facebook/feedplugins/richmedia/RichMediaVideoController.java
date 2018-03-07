package com.facebook.feedplugins.richmedia;

import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;

/* compiled from: bundle_wall_collection */
public class RichMediaVideoController extends VideoViewController<RichMediaVideoAttachmentView> {
    private boolean f9243a = false;
    private RichMediaStoryPersistentState f9244b;

    public final void m9887a(Object obj) {
        RichMediaVideoAttachmentView richMediaVideoAttachmentView = (RichMediaVideoAttachmentView) obj;
        if (this.f9243a) {
            this.f9243a = false;
            this.f9244b.f9211a = richMediaVideoAttachmentView.f9231b.getCurrentPositionMs();
            richMediaVideoAttachmentView.f9231b.b(EventTriggerType.BY_AUTOPLAY);
        }
    }

    public final void m9888b(Object obj) {
        RichMediaVideoAttachmentView richMediaVideoAttachmentView = (RichMediaVideoAttachmentView) obj;
        if (!this.f9243a) {
            this.f9243a = true;
            richMediaVideoAttachmentView.f9231b.a(this.f9244b.f9211a, EventTriggerType.BY_AUTOPLAY);
            richMediaVideoAttachmentView.f9231b.a(EventTriggerType.BY_AUTOPLAY);
        }
    }

    public RichMediaVideoController(String str, RichMediaStoryPersistentState richMediaStoryPersistentState) {
        super(str);
        this.f9244b = richMediaStoryPersistentState;
    }
}
