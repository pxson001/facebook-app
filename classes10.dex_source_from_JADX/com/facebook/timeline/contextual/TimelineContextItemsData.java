package com.facebook.timeline.contextual;

import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineContextItemsPageInfo;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineContextListItemFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.IntroCardContextListItemsConnectionFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextItemsPageInfoModel;
import com.google.common.collect.ImmutableList;

/* compiled from: group_thread_participants */
public class TimelineContextItemsData {
    public final ImmutableList<? extends TimelineContextListItemFields> f10311a;
    public final TimelineContextItemsPageInfoModel f10312b;

    public TimelineContextItemsData(ImmutableList<? extends TimelineContextListItemFields> immutableList, TimelineContextItemsPageInfo timelineContextItemsPageInfo) {
        this.f10311a = immutableList;
        this.f10312b = timelineContextItemsPageInfo;
    }

    public static TimelineContextItemsData m10452a(IntroCardContextListItemsConnectionFieldsModel introCardContextListItemsConnectionFieldsModel) {
        if (introCardContextListItemsConnectionFieldsModel == null) {
            return null;
        }
        return new TimelineContextItemsData(introCardContextListItemsConnectionFieldsModel.a(), introCardContextListItemsConnectionFieldsModel.b());
    }
}
