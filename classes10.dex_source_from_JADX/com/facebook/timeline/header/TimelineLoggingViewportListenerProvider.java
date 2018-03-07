package com.facebook.timeline.header;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.logging.FeedLoggingUtil;
import com.facebook.feed.photos.FeedUnitImagesStateMapper;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.listview.TimelineAdapter;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.timeline.units.model.TimelineAllSectionsData;

/* compiled from: fragment is null while responding to leave action */
public class TimelineLoggingViewportListenerProvider extends AbstractAssistedProvider<TimelineLoggingViewportListener> {
    public final TimelineLoggingViewportListener m11575a(Long l, TimelineAdapter timelineAdapter, TimelineAllSectionsData timelineAllSectionsData) {
        return new TimelineLoggingViewportListener(l, timelineAdapter, timelineAllSectionsData, TimelineAnalyticsLogger.a(this), UnseenStoryManager.a(this), (Clock) SystemClockMethodAutoProvider.a(this), FeedLoggingUtil.a(this), FeedUnitImagesStateMapper.a(this), TimelineCollapsedProtilesExperimentHelper.m12438a((InjectorLike) this));
    }
}
