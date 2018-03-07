package com.facebook.messaging.event.sending;

import com.facebook.android.maps.model.LatLng;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageEventFragmentModel.EventCoordinatesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageEventFragmentModel.EventPlaceModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel.Builder;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.CommonStoryAttachmentFieldsModel.DescriptionModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.location.sending.NearbyPlace;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mSsnLastFour */
public class EventMessageAttachmentCreator {
    public static XMAModel m11450a(String str, @Nullable LatLng latLng, @Nullable NearbyPlace nearbyPlace, boolean z, long j, long j2) {
        if (latLng == null || nearbyPlace == null) {
            Builder builder = new Builder();
            builder.N = str;
            if (latLng != null) {
                builder.K = m11449a(latLng);
            } else if (nearbyPlace != null) {
                EventPlaceModel.Builder builder2 = new EventPlaceModel.Builder();
                builder2.b = nearbyPlace.f11444a;
                builder.M = builder2.a();
                builder.K = m11449a(nearbyPlace.f11447d);
            }
            builder.ac = z;
            builder.bh = j;
            builder.I = j2;
            StoryAttachmentTargetFragmentModel a = builder.a();
            XMAAttachmentStoryFieldsModel.Builder builder3 = new XMAAttachmentStoryFieldsModel.Builder();
            builder3.j = a;
            builder3 = builder3;
            builder3.k = str;
            builder3 = builder3;
            builder3.g = ImmutableList.of(GraphQLStoryAttachmentStyle.MESSAGE_EVENT, GraphQLStoryAttachmentStyle.FALLBACK);
            builder3 = builder3;
            if (!StringUtil.a(null)) {
                DescriptionModel.Builder builder4 = new DescriptionModel.Builder();
                builder4.a = null;
                builder3.d = builder4.a();
            }
            XMAAttachmentStoryFieldsModel a2 = builder3.a();
            XMAModel.Builder builder5 = new XMAModel.Builder();
            builder5.d = a2;
            return builder5.a();
        }
        throw new IllegalArgumentException("You can specify only one of pinned, current or nearby place");
    }

    private static EventCoordinatesModel m11449a(LatLng latLng) {
        EventCoordinatesModel.Builder builder = new EventCoordinatesModel.Builder();
        builder.a = latLng.a;
        builder = builder;
        builder.b = latLng.b;
        return builder.a();
    }
}
