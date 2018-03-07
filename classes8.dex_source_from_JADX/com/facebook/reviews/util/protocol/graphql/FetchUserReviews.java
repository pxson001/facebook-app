package com.facebook.reviews.util.protocol.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlaceToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.PlacesToReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UpdatedPageReviewModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsModels.FetchSingleReviewQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: profile_video_android_call_to_action_button_impression */
public final class FetchUserReviews {

    /* compiled from: profile_video_android_call_to_action_button_impression */
    public class FetchPlacesToReviewQueryString extends TypedGraphQlQueryString<PlacesToReviewModel> {
        public FetchPlacesToReviewQueryString() {
            super(PlacesToReviewModel.class, false, "FetchPlacesToReviewQuery", "1ede98cad6fdade09548b3445f774e20", "user", "10154661259376729", RegularImmutableSet.a);
        }

        public final TriState m4973g() {
            return TriState.NO;
        }

        public final String m4972a(String str) {
            switch (str.hashCode()) {
                case -147132913:
                    return "0";
                case 16907033:
                    return "2";
                case 94851343:
                    return "3";
                case 1018939763:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: profile_video_android_call_to_action_button_impression */
    public class FetchSingleReviewQueryString extends TypedGraphQlQueryString<FetchSingleReviewQueryModel> {
        public FetchSingleReviewQueryString() {
            super(FetchSingleReviewQueryModel.class, false, "FetchSingleReviewQuery", "49f7944582af0f8edf7c044488e18d7d", "node", "10154686242411729", RegularImmutableSet.a);
        }

        public final TriState m4975g() {
            return TriState.NO;
        }

        public final String m4974a(String str) {
            switch (str.hashCode()) {
                case -1012194872:
                    return "1";
                case 334980221:
                    return "2";
                case 493034338:
                    return "0";
                case 1018939763:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: profile_video_android_call_to_action_button_impression */
    public class FetchUpdatedPageReviewQueryString extends TypedGraphQlQueryString<UpdatedPageReviewModel> {
        public FetchUpdatedPageReviewQueryString() {
            super(UpdatedPageReviewModel.class, false, "FetchUpdatedPageReviewQuery", "8c8741b02a1b44a339cef41812ce19f9", "page", "10154405445706729", RegularImmutableSet.a);
        }

        public final TriState m4977g() {
            return TriState.NO;
        }

        public final String m4976a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case 548553957:
                    return "1";
                case 1018939763:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: profile_video_android_call_to_action_button_impression */
    public class FetchUpdatedPlaceToReviewQueryString extends TypedGraphQlQueryString<PlaceToReviewModel> {
        public FetchUpdatedPlaceToReviewQueryString() {
            super(PlaceToReviewModel.class, false, "FetchUpdatedPlaceToReviewQuery", "cbe4ecd92bb699d73e88c3f856d26e54", "page", "10154661259366729", RegularImmutableSet.a);
        }

        public final TriState m4979g() {
            return TriState.NO;
        }

        public final String m4978a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case 1018939763:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: profile_video_android_call_to_action_button_impression */
    public class FetchUserReviewsQueryString extends TypedGraphQlQueryString<UserReviewsModel> {
        public FetchUserReviewsQueryString() {
            super(UserReviewsModel.class, false, "FetchUserReviewsQuery", "e2952b655faca6364b37e79ba3ab8494", "user", "10154686242481729", RegularImmutableSet.a);
        }

        public final TriState m4981g() {
            return TriState.NO;
        }

        public final String m4980a(String str) {
            switch (str.hashCode()) {
                case -1012194872:
                    return "1";
                case -147132913:
                    return "0";
                case 16907033:
                    return "5";
                case 94851343:
                    return "6";
                case 334980221:
                    return "2";
                case 548553957:
                    return "4";
                case 1018939763:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
