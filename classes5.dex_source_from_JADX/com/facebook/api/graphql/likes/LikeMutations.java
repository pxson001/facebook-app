package com.facebook.api.graphql.likes;

import com.facebook.api.graphql.likes.LikeMutationsModels.FBFeedbackLikeCoreMutationFragmentModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.FBFeedbackUnlikeCoreMutationFragmentModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.PageLikeModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.PageUnlikeModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android_search_result_picker_long_press_suggest_edits */
public final class LikeMutations {

    /* compiled from: android_search_result_picker_long_press_suggest_edits */
    public class FBFeedbackLikeCoreMutationString extends TypedGraphQLMutationString<FBFeedbackLikeCoreMutationFragmentModel> {
        public FBFeedbackLikeCoreMutationString() {
            super(FBFeedbackLikeCoreMutationFragmentModel.class, false, "FBFeedbackLikeCoreMutation", "6ab7ad7262c955f2feedf0d05c86ee3c", "feedback_like", "0", "10154354463176729", RegularImmutableSet.a);
        }

        public final String m16691a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: android_search_result_picker_long_press_suggest_edits */
    public class FBFeedbackUnlikeCoreMutationString extends TypedGraphQLMutationString<FBFeedbackUnlikeCoreMutationFragmentModel> {
        public FBFeedbackUnlikeCoreMutationString() {
            super(FBFeedbackUnlikeCoreMutationFragmentModel.class, false, "FBFeedbackUnlikeCoreMutation", "8e3e8a4b4a41c203e11ea6b16f2c5f82", "feedback_unlike", "0", "10154354463181729", RegularImmutableSet.a);
        }

        public final String m16692a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: android_search_result_picker_long_press_suggest_edits */
    public class PageLikeString extends TypedGraphQLMutationString<PageLikeModel> {
        public PageLikeString() {
            super(PageLikeModel.class, false, "PageLike", "0d14e210248e37820513649b771c6f94", "page_like", "0", "10154339187106729", RegularImmutableSet.a);
        }

        public final String m16693a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: android_search_result_picker_long_press_suggest_edits */
    public class PageUnlikeString extends TypedGraphQLMutationString<PageUnlikeModel> {
        public PageUnlikeString() {
            super(PageUnlikeModel.class, false, "PageUnlike", "25f1d663a18c815bb108f1ac31fe164b", "page_unlike", "0", "10154339187116729", RegularImmutableSet.a);
        }

        public final String m16694a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FBFeedbackLikeCoreMutationString m16695a() {
        return new FBFeedbackLikeCoreMutationString();
    }

    public static final FBFeedbackUnlikeCoreMutationString m16696b() {
        return new FBFeedbackUnlikeCoreMutationString();
    }
}
