package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;

/* compiled from: friend_list_with_new_posts_seen */
public class TimelineHeaderNavtilesAdapterProvider extends AbstractAssistedProvider<TimelineHeaderNavtilesAdapter> {
    public final TimelineHeaderNavtilesAdapter m11458a(Context context, TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData) {
        return new TimelineHeaderNavtilesAdapter(context, timelineUserContext, timelineHeaderUserData, (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
