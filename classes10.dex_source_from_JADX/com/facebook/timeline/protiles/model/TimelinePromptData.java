package com.facebook.timeline.protiles.model;

import com.facebook.timeline.data.TimelineDataSource;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptApproximateCountFieldsModel;

/* compiled from: feedDialogActionExecutorVideo */
public class TimelinePromptData extends TimelineDataSource<TimelinePromptSource> {
    public final boolean m12125d() {
        if (this.b != null) {
            TimelinePromptSource timelinePromptSource = (TimelinePromptSource) this.b;
            Object obj = (timelinePromptSource.f12124d == null || (timelinePromptSource.f12122b.isPresent() && ((TimelinePromptApproximateCountFieldsModel) timelinePromptSource.f12122b.get()).a() <= 0)) ? null : 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
