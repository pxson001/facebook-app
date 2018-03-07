package com.facebook.timeline.delegate;

import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.header.TimelineHeaderDataLogger;
import com.facebook.timeline.header.TimelineLoggingViewportListener;
import com.facebook.timeline.listview.TimelineAdapter;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.prefs.TimelineConfig;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Supplier;

/* compiled from: gp */
public class TimelineFragmentScrollDelegateProvider extends AbstractAssistedProvider<TimelineFragmentScrollDelegate> {
    public final TimelineFragmentScrollDelegate m10786a(long j, ScrollingViewProxy scrollingViewProxy, TimelineAdapter timelineAdapter, TimelineConfig timelineConfig, TimelinePerformanceLogger timelinePerformanceLogger, Supplier<TimelineLoggingViewportListener> supplier, TimelineHeaderDataLogger timelineHeaderDataLogger, String str) {
        TimelineFragmentScrollDelegate timelineFragmentScrollDelegate = new TimelineFragmentScrollDelegate(j, scrollingViewProxy, timelineAdapter, timelineConfig, timelinePerformanceLogger, supplier, timelineHeaderDataLogger, str, TimelineHeaderRenderState.a(this), IdBasedSingletonScopeProvider.a(this, 1439), IdBasedProvider.a(this, 11284), IdBasedProvider.a(this, 3266), (FrameRateLoggerProvider) getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), IdBasedProvider.a(this, 820), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
        timelineFragmentScrollDelegate.m10785a(IdBasedSingletonScopeProvider.a(this, 1439), IdBasedSingletonScopeProvider.a(this, 1055), IdBasedProvider.a(this, 11293));
        return timelineFragmentScrollDelegate;
    }
}
