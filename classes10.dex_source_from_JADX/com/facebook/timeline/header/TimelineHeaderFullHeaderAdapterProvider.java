package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;

/* compiled from: friendsNearbyDeleteInviteParams */
public class TimelineHeaderFullHeaderAdapterProvider extends AbstractAssistedProvider<TimelineHeaderFullHeaderAdapter> {
    public final TimelineHeaderFullHeaderAdapter m11450a(Context context, TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData, TimelineContextualInfoData timelineContextualInfoData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineHeaderDataLogger timelineHeaderDataLogger, Boolean bool) {
        return new TimelineHeaderFullHeaderAdapter(context, timelineUserContext, timelineHeaderUserData, timelineContextualInfoData, timelineTaggedMediaSetData, timelineHeaderDataLogger, bool, (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
