package com.facebook.reviews.protocol.graphql;

import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel.ValueModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewCreationFieldsModel.CreatorModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewCreationFieldsModel.StoryModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel.ReviewerContextModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel;
import javax.annotation.Nullable;

/* compiled from: setIsFireAndForget */
public class ReviewFragmentsInterfaces {

    /* compiled from: setIsFireAndForget */
    public interface ReviewCreationFields {
    }

    /* compiled from: setIsFireAndForget */
    public interface ReviewWithCreationFields extends ReviewBasicFields, ReviewCreationFields {
        @Nullable
        CreatorModel bP_();
    }

    /* compiled from: setIsFireAndForget */
    public interface ReviewWithFeedback extends ReviewWithCreationFields {
        int mo326b();

        @Nullable
        String bN_();

        @Nullable
        DefaultFeedbackFields bO_();

        @Nullable
        CreatorModel bP_();

        @Nullable
        SelectedPrivacyOptionFieldsModel mo329c();

        @Nullable
        ValueModel mo330d();

        long mo331g();

        @Nullable
        ReviewerContextModel mo332j();

        @Nullable
        StoryModel mo333k();
    }
}
