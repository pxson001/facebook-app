package com.facebook.timeline;

import com.facebook.timeline.actionbar.TimelineActionBarController;
import com.facebook.timeline.contextual.TimelineContextualInfoController;
import com.facebook.timeline.header.TimelineHeaderDataLogger;
import com.facebook.timeline.header.TimelineHeaderPerfController;
import com.facebook.timeline.header.controllers.TimelineCoverPhotoController;
import com.facebook.timeline.header.controllers.TimelineProfileImageController;
import com.facebook.timeline.navtiles.TimelineNavtileController;
import com.facebook.timeline.publisher.TimelinePublishController;
import javax.annotation.Nullable;

/* compiled from: groupsize */
public interface ProfileController {
    void mo470e();

    @Nullable
    TimelineHeaderDataLogger mo471f();

    TimelineProfileImageController mo473l();

    TimelineActionBarController mo474m();

    TimelineNavtileController mm_();

    void mn_();

    void mo_();

    void mp_();

    void mq_();

    TimelineContextualInfoController mo482r();

    TimelineCoverPhotoController mo483t();

    TimelineHeaderPerfController mo484u();

    TimelinePublishController mo485v();
}
