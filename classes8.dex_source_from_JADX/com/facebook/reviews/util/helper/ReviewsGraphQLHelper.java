package com.facebook.reviews.util.helper;

import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithCreationFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel.PrivacyOptionsModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsModels.FetchSingleReviewQueryModel.RepresentedProfileModel;
import javax.annotation.Nullable;

/* compiled from: profile_video_android_video_too_small */
public class ReviewsGraphQLHelper {
    public static int m4909a(@Nullable ReviewBasicFields reviewBasicFields) {
        return reviewBasicFields == null ? 0 : reviewBasicFields.b();
    }

    @Nullable
    public static String m4911a(ReviewWithCreationFields reviewWithCreationFields) {
        return reviewWithCreationFields.bP_() == null ? null : reviewWithCreationFields.bP_().bL_();
    }

    @Nullable
    public static String m4914b(ReviewWithCreationFields reviewWithCreationFields) {
        return reviewWithCreationFields.bP_() == null ? null : reviewWithCreationFields.bP_().bK_();
    }

    @Nullable
    public static String m4913b(@Nullable ReviewBasicFields reviewBasicFields) {
        return (reviewBasicFields == null || reviewBasicFields.d() == null) ? null : reviewBasicFields.d().a();
    }

    @Nullable
    public static String m4916b(@Nullable EdgesModel edgesModel) {
        return m4910a(m4920d(edgesModel));
    }

    @Nullable
    public static String m4910a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null) {
            return null;
        }
        return graphQLStoryAttachment.z().dp();
    }

    @Nullable
    public static GraphQLPrivacyOption m4917c(@Nullable ReviewBasicFields reviewBasicFields) {
        if (reviewBasicFields == null || reviewBasicFields.c() == null || reviewBasicFields.c().b() == null || reviewBasicFields.c().b().a().isEmpty()) {
            return null;
        }
        return ((PrivacyOptionsModel.EdgesModel) reviewBasicFields.c().b().a().get(0)).b();
    }

    @Nullable
    public static String m4915b(@Nullable ReviewWithFeedback reviewWithFeedback) {
        if (reviewWithFeedback == null) {
            return null;
        }
        return reviewWithFeedback.bN_();
    }

    @Nullable
    public static String m4918c(@Nullable ReviewWithFeedback reviewWithFeedback) {
        if (reviewWithFeedback == null && reviewWithFeedback.bO_() == null) {
            return null;
        }
        return reviewWithFeedback.bO_().z_();
    }

    @Nullable
    public static String m4912a(@Nullable RepresentedProfileModel representedProfileModel) {
        return representedProfileModel == null ? null : representedProfileModel.m4991b();
    }

    @Nullable
    public static GraphQLFeedback m4919d(@Nullable ReviewWithFeedback reviewWithFeedback) {
        if (reviewWithFeedback == null) {
            return null;
        }
        return DefaultGraphQLConversionHelper.a(reviewWithFeedback.bO_());
    }

    @Nullable
    public static GraphQLStoryAttachment m4920d(@Nullable EdgesModel edgesModel) {
        if (edgesModel == null || edgesModel.a() == null || edgesModel.a().a() == null) {
            return null;
        }
        return StoryAttachmentHelper.o(edgesModel.a().a());
    }
}
