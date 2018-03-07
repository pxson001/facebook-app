package com.facebook.photos.data.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.data.protocol.FetchBestAvailableImageUriQueryModels.FetchBestAvailableImageUriQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: suggestionTime */
public final class FetchBestAvailableImageUriQuery {

    /* compiled from: suggestionTime */
    public class FetchBestAvailableImageUriQueryString extends TypedGraphQlQueryString<FetchBestAvailableImageUriQueryModel> {
        public FetchBestAvailableImageUriQueryString() {
            super(FetchBestAvailableImageUriQueryModel.class, false, "FetchBestAvailableImageUriQuery", "3e9b10a3ba79488f04ab3299b7736d63", "node", "10153994346216729", RegularImmutableSet.a);
        }

        public final String m4752a(String str) {
            switch (str.hashCode()) {
                case 3386882:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
