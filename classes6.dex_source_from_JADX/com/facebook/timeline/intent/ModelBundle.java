package com.facebook.timeline.intent;

import android.os.Bundle;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.groups.constants.GroupIntentBuilder;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.intent.ModelBundleGraphQLModels.ModelBundleExtendedGraphQLModel.Builder;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderCoverPhotoFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderFocusedCoverPhotoFieldsModel;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: deltaMarkFolderSeen */
public class ModelBundle {
    public static void m25599a(Bundle bundle, String str, @Nullable String str2, String str3) {
        m25600a(bundle, str, str2, str3, null, null);
    }

    public static void m25600a(Bundle bundle, String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable DefaultVect2Fields defaultVect2Fields) {
        TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel;
        Builder builder = new Builder();
        builder.f17614d = str;
        builder = builder;
        DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
        builder2.b = str2;
        builder.f17616f = builder2.a();
        builder = builder;
        builder.f17615e = str3;
        Builder builder3 = builder;
        if (str4 == null) {
            timelineHeaderFocusedCoverPhotoFieldsModel = null;
        } else {
            TimelineHeaderCoverPhotoFieldsModel.Builder builder4 = new TimelineHeaderCoverPhotoFieldsModel.Builder();
            DefaultImageFieldsModel.Builder builder5 = new DefaultImageFieldsModel.Builder();
            builder5.b = str4;
            builder4.f17710d = builder5.a();
            TimelineHeaderCoverPhotoFieldsModel a = builder4.m25840a();
            TimelineHeaderFocusedCoverPhotoFieldsModel.Builder builder6 = new TimelineHeaderFocusedCoverPhotoFieldsModel.Builder();
            builder6.f17718b = a;
            TimelineHeaderFocusedCoverPhotoFieldsModel.Builder builder7 = builder6;
            builder7.f17717a = DefaultVect2FieldsModel.a(defaultVect2Fields);
            timelineHeaderFocusedCoverPhotoFieldsModel = builder7.m25853a();
        }
        builder3.f17612b = timelineHeaderFocusedCoverPhotoFieldsModel;
        m25598a(bundle, builder3.m25602a());
    }

    public static void m25598a(Bundle bundle, ModelBundleProfileGraphQL modelBundleProfileGraphQL) {
        Object obj;
        Preconditions.checkNotNull(modelBundleProfileGraphQL);
        if (modelBundleProfileGraphQL.c() == null || modelBundleProfileGraphQL.c().g() != 2479791) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m25601b(bundle, modelBundleProfileGraphQL.g(), modelBundleProfileGraphQL.C_(), modelBundleProfileGraphQL.dB_() != null ? modelBundleProfileGraphQL.dB_().b() : null);
        } else {
            FlatBufferModelHelper.a(bundle, "graphql_profile", modelBundleProfileGraphQL);
        }
    }

    public static void m25601b(Bundle bundle, String str, String str2, String str3) {
        if (str != null) {
            bundle.putString("model_bundle_page_id", str);
        }
        bundle.putString("model_bundle_page_name", str2);
        bundle.putString("model_bundle_page_profile_pic_uri", str3);
    }

    public static void m25597a(Bundle bundle, int i, String str, @Nullable String str2, String str3) {
        switch (i) {
            case 2479791:
                m25601b(bundle, str, str3, str2);
                return;
            case 2645995:
                m25599a(bundle, str, str2, str3);
                return;
            case 69076575:
                GroupIntentBuilder.m17640a(bundle, str, str3, null);
                return;
            default:
                return;
        }
    }
}
