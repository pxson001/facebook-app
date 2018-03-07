package com.facebook.tablet.sideshow.ads.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: on_composer_entered */
public final class FetchAppAdsSideshowData {

    /* compiled from: on_composer_entered */
    public class FetchAppAdsSideshowDataString extends TypedGraphQlQueryString<GraphQLViewer> {
        public FetchAppAdsSideshowDataString() {
            super(GraphQLViewer.class, false, "FetchAppAdsSideshowData", "e420c05a17677dc7f51ba3f0b7dc4816", "viewer", "10154658546326729", RegularImmutableSet.a);
        }

        public final TriState m5852g() {
            return TriState.NO;
        }

        public final String m5851a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "1";
                case -1335157162:
                    return "0";
                case 94851343:
                    return "3";
                case 421050507:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
