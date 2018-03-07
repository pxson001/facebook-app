package com.facebook.deeplinking.graphql;

import com.facebook.deeplinking.graphql.DeepLinkingGraphQlQueryFragmentsModels.GetURLInfoModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: photo_hashes */
public final class DeepLinkingGraphQlQueryFragments {

    /* compiled from: photo_hashes */
    public class GetURLInfoString extends TypedGraphQlQueryString<GetURLInfoModel> {
        public GetURLInfoString() {
            super(GetURLInfoModel.class, false, "GetURLInfo", "ca6e646d9944ff94d02a1a0a8b870fd3", "url", "10153154451871729", RegularImmutableSet.a);
        }

        public final String m6920a(String str) {
            switch (str.hashCode()) {
                case 116079:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
