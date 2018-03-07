package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsQueryModels.FetchBudgetRecommendationsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: WEBRTC */
public final class FetchBudgetRecommendationsQuery {

    /* compiled from: WEBRTC */
    public class FetchBudgetRecommendationsQueryString extends TypedGraphQlQueryString<FetchBudgetRecommendationsQueryModel> {
        public FetchBudgetRecommendationsQueryString() {
            super(FetchBudgetRecommendationsQueryModel.class, false, "FetchBudgetRecommendationsQuery", "09c948bcdf698ee85e828b38a78e613a", "page", "10154405445026729", RegularImmutableSet.a);
        }

        public final String m24151a(String str) {
            switch (str.hashCode()) {
                case -1992012396:
                    return "4";
                case -899242647:
                    return "5";
                case -815566671:
                    return "8";
                case -803548981:
                    return "0";
                case 36967363:
                    return "10";
                case 209914905:
                    return "9";
                case 914102582:
                    return "7";
                case 975628804:
                    return "6";
                case 1706754015:
                    return "2";
                case 1717754021:
                    return "3";
                case 1913029129:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
