package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInsightsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Video segment transcode upload failed.  */
public final class FetchStoryPromotionInsightsQuery {

    /* compiled from: Video segment transcode upload failed.  */
    public class FetchStoryPromotionInsightsQueryString extends TypedGraphQlQueryString<StoryPromotionInsightsModel> {
        public FetchStoryPromotionInsightsQueryString() {
            super(StoryPromotionInsightsModel.class, false, "FetchStoryPromotionInsightsQuery", "76509084331f34a2f653f489df1b8766", "node", "10154339186801729", RegularImmutableSet.a);
        }

        public final String m24239a(String str) {
            switch (str.hashCode()) {
                case -1012194872:
                    return "1";
                case 1717754021:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
