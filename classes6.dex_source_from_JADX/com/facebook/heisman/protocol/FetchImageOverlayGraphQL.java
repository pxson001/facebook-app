package com.facebook.heisman.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mMemeUrls */
public final class FetchImageOverlayGraphQL {

    /* compiled from: mMemeUrls */
    public class ImageOverlayCameraTitleQueryString extends TypedGraphQlQueryString<ImageOverlayCameraTitleFieldsModel> {
        public ImageOverlayCameraTitleQueryString() {
            super(ImageOverlayCameraTitleFieldsModel.class, false, "ImageOverlayCameraTitleQuery", "6c5b36562d41a991b5afcbd686ac7364", "node", "10154491466291729", RegularImmutableSet.a);
        }

        public final String m17708a(String str) {
            switch (str.hashCode()) {
                case 680583374:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: mMemeUrls */
    public class ImageOverlayUriQueryString extends TypedGraphQlQueryString<ImageOverlayFieldsModel> {
        public ImageOverlayUriQueryString() {
            super(ImageOverlayFieldsModel.class, false, "ImageOverlayUriQuery", "7b9ec31264ff4f8d6acfd2b7663ea5cf", "node", "10154447383346729", RegularImmutableSet.a);
        }

        public final String m17709a(String str) {
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
