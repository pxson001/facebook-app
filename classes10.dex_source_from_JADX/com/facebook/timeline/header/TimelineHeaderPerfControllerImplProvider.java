package com.facebook.timeline.header;

import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.logging.TimelinePerformanceLogger;

/* compiled from: friend_list_search_bar_click */
public class TimelineHeaderPerfControllerImplProvider extends AbstractAssistedProvider<TimelineHeaderPerfControllerImpl> {
    public final TimelineHeaderPerfControllerImpl m11468a(TimelineHeaderDataLogger timelineHeaderDataLogger) {
        return new TimelineHeaderPerfControllerImpl(TimelinePerformanceLogger.a(this), TimelineHeaderRenderState.a(this), Handler_ForUiThreadMethodAutoProvider.b(this), timelineHeaderDataLogger);
    }
}
