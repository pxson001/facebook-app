package com.facebook.timeline.datafetcher.section;

import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams.Builder;
import com.facebook.timeline.logging.TimelinePerformanceLogger.UnitsFetchTrigger;
import com.facebook.timeline.units.model.TimelineSectionData.ScrollLoadTrigger;

/* compiled from: graphEventCreate */
public class TimelineSectionFetchParamsHelper {
    public static TimelineSectionFetchParams m10749a(boolean z) {
        Builder builder = new Builder();
        builder.f10690b = null;
        builder = builder;
        builder.f10694f = z;
        builder = builder;
        builder.f10695g = 2;
        builder = builder;
        builder.f10689a = UnitsFetchTrigger.AUTO_INITIAL;
        return builder.m10745b();
    }

    public static <T> TimelineSectionFetchParams m10747a(GraphQLRequest<T> graphQLRequest, boolean z) {
        Builder builder = new Builder();
        builder.f10691c = graphQLRequest.a("section_id", BatchQueryFanOutStyle.FIRST, FallbackStyle.SKIP);
        builder.f10690b = null;
        builder = builder;
        builder.f10694f = z;
        builder = builder.m10743b(graphQLRequest.a("end_cursor", BatchQueryFanOutStyle.FIRST, FallbackStyle.SKIP));
        builder.f10689a = UnitsFetchTrigger.AUTO_INITIAL;
        return builder.m10745b();
    }

    public static TimelineSectionFetchParams m10748a(ScrollLoadTrigger scrollLoadTrigger) {
        Builder b = new Builder().m10742a(scrollLoadTrigger.f12778a).m10744b(scrollLoadTrigger.f12779b);
        b.f10695g = scrollLoadTrigger.f12780c - 1;
        b = b;
        b.f10689a = UnitsFetchTrigger.AUTO_SCROLL;
        return b.m10745b();
    }
}
