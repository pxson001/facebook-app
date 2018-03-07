package com.facebook.heisman.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: polite */
public final class PageProfilePictureOverlaysGraphQL {

    /* compiled from: polite */
    public class PageProfilePictureOverlaysQueryString extends TypedGraphQlQueryString<ImageOverlayWithSwipeableOverlaysModel> {
        public PageProfilePictureOverlaysQueryString() {
            super(ImageOverlayWithSwipeableOverlaysModel.class, false, "PageProfilePictureOverlaysQuery", "f41d1b1b445dfb523afd183e8f5d7533", "node", "10154533078111729", RegularImmutableSet.a);
        }

        public final String m7947a(String str) {
            switch (str.hashCode()) {
                case -1663499699:
                    return "1";
                case 680583374:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
