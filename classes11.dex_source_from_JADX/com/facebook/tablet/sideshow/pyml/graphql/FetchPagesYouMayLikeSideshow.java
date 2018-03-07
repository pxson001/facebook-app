package com.facebook.tablet.sideshow.pyml.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowModels.FetchPagesYouMayLikeSideshowModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: onBlur */
public final class FetchPagesYouMayLikeSideshow {

    /* compiled from: onBlur */
    public class FetchPagesYouMayLikeSideshowString extends TypedGraphQlQueryString<FetchPagesYouMayLikeSideshowModel> {
        public FetchPagesYouMayLikeSideshowString() {
            super(FetchPagesYouMayLikeSideshowModel.class, false, "FetchPagesYouMayLikeSideshow", "c00967d33dd0bd9d7ff87d43f7929b5c", "viewer", "10153688469276729", RegularImmutableSet.a);
        }

        public final String m5996a(String str) {
            switch (str.hashCode()) {
                case 94851343:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
