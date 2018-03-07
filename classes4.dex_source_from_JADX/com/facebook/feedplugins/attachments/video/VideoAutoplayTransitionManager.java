package com.facebook.feedplugins.attachments.video;

import android.view.View;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.PlayPosition;

/* compiled from: phone_number_by_library */
public interface VideoAutoplayTransitionManager {
    void mo429a();

    void mo430a(FrameRateBlameMarkers frameRateBlameMarkers, EventTriggerType eventTriggerType, PlayPosition playPosition);

    void mo431a(ExitFullScreenResult exitFullScreenResult);

    void mo432a(boolean z);

    void mo433b();

    View mo434c();

    AutoplayStateManager mo435d();

    InlineVideoPersistentState mo436e();

    GraphQLStoryAttachment mo437f();
}
