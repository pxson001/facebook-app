package com.facebook.timeline.navtiles;

import android.os.Bundle;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLModels.TimelineTaggedMediaSetFieldsModel;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;

/* compiled from: feed_type_arguments_key */
public class TimelinePhotosTabParamsUtil {
    public static void m12084a(TimelineTaggedMediaSetData timelineTaggedMediaSetData, Bundle bundle) {
        if (timelineTaggedMediaSetData.d()) {
            TimelineTaggedMediaSetFieldsModel timelineTaggedMediaSetFieldsModel = (TimelineTaggedMediaSetFieldsModel) timelineTaggedMediaSetData.a().get();
            boolean z = (timelineTaggedMediaSetFieldsModel.a() == null || timelineTaggedMediaSetFieldsModel.a().a().isEmpty()) ? false : true;
            bundle.putBoolean("has_tagged_mediaset", z);
            return;
        }
        bundle.putBoolean("has_tagged_mediaset", true);
        bundle.putBoolean("land_on_uploads_tab", true);
    }
}
