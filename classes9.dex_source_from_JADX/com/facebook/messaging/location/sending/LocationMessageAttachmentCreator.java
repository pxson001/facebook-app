package com.facebook.messaging.location.sending;

import android.content.res.Resources;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MessageLocationFragmentModel.CoordinatesModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel.Builder;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.CommonStoryAttachmentFieldsModel.DescriptionModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPathRegex */
public class LocationMessageAttachmentCreator {
    public final Resources f11382a;

    @Inject
    public LocationMessageAttachmentCreator(Resources resources) {
        this.f11382a = resources;
    }

    public final XMAModel m11971a(LatLng latLng) {
        return m11968a(latLng, true);
    }

    public final XMAModel m11972b(LatLng latLng) {
        return m11968a(latLng, false);
    }

    private XMAModel m11968a(LatLng latLng, boolean z) {
        CoordinatesModel c = m11970c(latLng);
        Builder builder = new Builder();
        builder.u = c;
        builder = builder;
        builder.ad = z;
        return m11969a(m11967a(builder.a(), z ? this.f11382a.getString(2131241012) : this.f11382a.getString(2131241013), null));
    }

    public static CoordinatesModel m11970c(LatLng latLng) {
        CoordinatesModel.Builder builder = new CoordinatesModel.Builder();
        builder.a = latLng.a;
        builder = builder;
        builder.b = latLng.b;
        return builder.a();
    }

    public static XMAAttachmentStoryFieldsModel m11967a(StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel, String str, @Nullable String str2) {
        XMAAttachmentStoryFieldsModel.Builder builder = new XMAAttachmentStoryFieldsModel.Builder();
        builder.j = storyAttachmentTargetFragmentModel;
        builder = builder;
        builder.k = str;
        builder = builder;
        builder.g = ImmutableList.of(GraphQLStoryAttachmentStyle.MESSAGE_LOCATION, GraphQLStoryAttachmentStyle.FALLBACK);
        builder = builder;
        if (!StringUtil.a(str2)) {
            DescriptionModel.Builder builder2 = new DescriptionModel.Builder();
            builder2.a = str2;
            builder.d = builder2.a();
        }
        return builder.a();
    }

    public static XMAModel m11969a(XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel) {
        XMAModel.Builder builder = new XMAModel.Builder();
        builder.d = xMAAttachmentStoryFieldsModel;
        return builder.a();
    }
}
