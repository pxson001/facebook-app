package com.facebook.timeline.cursor;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.datafetcher.TimelineDataFetcher.C15321;
import com.facebook.timeline.datafetcher.TimelineSectionQueryBuilder;
import com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryBuilder;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;

/* compiled from: group_events_page_cursor */
public class TimelineSelfFirstUnitsBatchConfigurationProvider extends AbstractAssistedProvider<TimelineSelfFirstUnitsBatchConfiguration> {
    public final TimelineSelfFirstUnitsBatchConfiguration m10516a(FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext, C15321 c15321) {
        return new TimelineSelfFirstUnitsBatchConfiguration(fetchTimelineFirstUnitsParams, callerContext, c15321, (TimelineFirstUnitsSelfConfigurationProvider) getOnDemandAssistedProviderForStaticDi(TimelineFirstUnitsSelfConfigurationProvider.class), new TimelineSectionUnitsConfiguration(TimelineSectionQueryBuilder.m10657a(this)), TimelineSelfFirstUnitsQueryBuilder.m10667b(this));
    }
}
