package com.facebook.photos.creativeediting.model;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.creativeediting.model.FetchFramePacksGraphQLModels.FetchFramePacksQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: symbol */
public final class FetchFramePacksGraphQL {

    /* compiled from: symbol */
    public class FetchFramePacksQueryString extends TypedGraphQlQueryString<FetchFramePacksQueryModel> {
        public FetchFramePacksQueryString() {
            super(FetchFramePacksQueryModel.class, false, "FetchFramePacksQuery", "a3c448ca65388dd3729e9bf6dfae5e91", "viewer", "10154599969691729", RegularImmutableSet.a);
        }

        public final String m4499a(String str) {
            switch (str.hashCode()) {
                case 202805240:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
