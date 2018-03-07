package com.facebook.timeline.header.util;

import android.content.Context;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.ipc.profile.TimelineContext.TimelineType;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderFocusedCoverPhotoFieldsModel;
import javax.annotation.Nullable;

/* compiled from: fb4a_ccu */
public class TimelineHeaderViewHelper {
    public static float m18521a(Context context) {
        return context.getResources().getConfiguration().orientation == 1 ? 2.0f : 4.0f;
    }

    public static boolean m18522a(TimelineContext timelineContext, boolean z) {
        return TimelineType.USER.equals(timelineContext.e) && z;
    }

    public static boolean m18523a(@Nullable TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel) {
        boolean z;
        if (timelineHeaderFocusedCoverPhotoFieldsModel == null || timelineHeaderFocusedCoverPhotoFieldsModel.b() == null || timelineHeaderFocusedCoverPhotoFieldsModel.b().du_() == null) {
            z = false;
        } else {
            z = true;
        }
        if (z || m18524b(timelineHeaderFocusedCoverPhotoFieldsModel)) {
            return true;
        }
        return false;
    }

    public static boolean m18524b(TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel) {
        return (timelineHeaderFocusedCoverPhotoFieldsModel == null || timelineHeaderFocusedCoverPhotoFieldsModel.b() == null || timelineHeaderFocusedCoverPhotoFieldsModel.b().g() == null) ? false : true;
    }
}
