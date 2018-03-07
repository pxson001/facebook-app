package com.facebook.pages.common.coverphotoreposition;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.coverphotoreposition.FetchPageHeaderForCoverPhotoRepositionGraphQLModels.FetchPageHeaderForCoverPhotoRepositionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: southBound */
public final class FetchPageHeaderForCoverPhotoRepositionGraphQL {

    /* compiled from: southBound */
    public class FetchPageHeaderForCoverPhotoRepositionQueryString extends TypedGraphQlQueryString<FetchPageHeaderForCoverPhotoRepositionQueryModel> {
        public FetchPageHeaderForCoverPhotoRepositionQueryString() {
            super(FetchPageHeaderForCoverPhotoRepositionQueryModel.class, false, "FetchPageHeaderForCoverPhotoRepositionQuery", "163dd1a8aa28de9f14845ebee8b7a214", "page", "10154405445376729", RegularImmutableSet.a);
        }

        public final String m2184a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
