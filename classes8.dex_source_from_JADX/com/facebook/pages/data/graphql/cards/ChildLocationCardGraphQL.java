package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationQueryWithViewerLocationModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationQueryWithoutViewerLocationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: cookies_url */
public final class ChildLocationCardGraphQL {

    /* compiled from: cookies_url */
    public class ChildLocationQueryWithViewerLocationString extends TypedGraphQlQueryString<ChildLocationQueryWithViewerLocationModel> {
        public ChildLocationQueryWithViewerLocationString() {
            super(ChildLocationQueryWithViewerLocationModel.class, false, "ChildLocationQueryWithViewerLocation", "47cf7837472c16b05590a1c21d397408", "page", "10154429179151729", RegularImmutableSet.a);
        }

        public final String m20223a(String str) {
            switch (str.hashCode()) {
                case -1351465184:
                    return "3";
                case -803548981:
                    return "0";
                case -704493630:
                    return "2";
                case -220209159:
                    return "1";
                case -107659943:
                    return "4";
                default:
                    return str;
            }
        }
    }

    /* compiled from: cookies_url */
    public class ChildLocationQueryWithoutViewerLocationString extends TypedGraphQlQueryString<ChildLocationQueryWithoutViewerLocationModel> {
        public ChildLocationQueryWithoutViewerLocationString() {
            super(ChildLocationQueryWithoutViewerLocationModel.class, false, "ChildLocationQueryWithoutViewerLocation", "9979564f6d5f667abebc15203536c54e", "page", "10154429039306729", RegularImmutableSet.a);
        }

        public final String m20224a(String str) {
            switch (str.hashCode()) {
                case -1351465184:
                    return "1";
                case -803548981:
                    return "0";
                case -107659943:
                    return "2";
                default:
                    return str;
            }
        }
    }

    public static final ChildLocationQueryWithViewerLocationString m20225a() {
        return new ChildLocationQueryWithViewerLocationString();
    }

    public static final ChildLocationQueryWithoutViewerLocationString m20226b() {
        return new ChildLocationQueryWithoutViewerLocationString();
    }
}
