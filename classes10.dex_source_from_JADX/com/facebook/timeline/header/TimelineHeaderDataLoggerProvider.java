package com.facebook.timeline.header;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;

/* compiled from: friends_center_friends_tab_impression */
public class TimelineHeaderDataLoggerProvider extends AbstractAssistedProvider<TimelineHeaderDataLogger> {
    public final TimelineHeaderDataLogger m11444a(String str, Long l, TimelineHeaderUserData timelineHeaderUserData) {
        return new TimelineHeaderDataLogger(str, l, timelineHeaderUserData, TimelineAnalyticsLogger.a(this), TimelineHeaderRenderState.a(this), ScreenUtil.a(this), (Clock) SystemClockMethodAutoProvider.a(this), IntroCardSuggestedPhotosExperimentController.m11801a(this));
    }
}
