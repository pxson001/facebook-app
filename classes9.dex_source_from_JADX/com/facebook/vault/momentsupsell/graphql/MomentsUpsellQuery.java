package com.facebook.vault.momentsupsell.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.vault.momentsupsell.graphql.MomentsUpsellQueryModels.MomentsAppPromotionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: threadid */
public final class MomentsUpsellQuery {

    /* compiled from: threadid */
    public class MomentsAppPromotionQueryString extends TypedGraphQlQueryString<MomentsAppPromotionQueryModel> {
        public MomentsAppPromotionQueryString() {
            super(MomentsAppPromotionQueryModel.class, false, "MomentsAppPromotionQuery", "a4018c8e50761838ec03138961ee7896", "viewer", "10154358539476729", RegularImmutableSet.a);
        }

        public final String m1761a(String str) {
            switch (str.hashCode()) {
                case 109250890:
                    return "2";
                case 759954292:
                    return "1";
                case 1429210306:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
