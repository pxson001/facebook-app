package com.facebook.events.create.protocol;

import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCreationPageHostsQueryModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contactPointTypeString */
public final class PageEventCreationGraphQL {

    /* compiled from: contactPointTypeString */
    public class PageEventCategoriesQueryString extends TypedGraphQlQueryString<PageEventCategoriesQueryModel> {
        public PageEventCategoriesQueryString() {
            super(PageEventCategoriesQueryModel.class, false, "PageEventCategoriesQuery", "b9c06b81d1229d13f522f3dc47cc4350", "page", "10154405445016729", RegularImmutableSet.a);
        }

        public final String m16676a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: contactPointTypeString */
    public class PageEventCreationPageHostsQueryString extends TypedGraphQlQueryString<PageEventCreationPageHostsQueryModel> {
        public PageEventCreationPageHostsQueryString() {
            super(PageEventCreationPageHostsQueryModel.class, false, "PageEventCreationPageHostsQuery", "ed5444dfb603eaa85b2068cac948b7a8", "viewer", "10154429038136729", RegularImmutableSet.a);
        }

        public final String m16677a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -705314112:
                    return "0";
                case 1831224761:
                    return "1";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: contactPointTypeString */
    public class PageHostInfoQueryString extends TypedGraphQlQueryString<PageHostInfoFragmentModel> {
        public PageHostInfoQueryString() {
            super(PageHostInfoFragmentModel.class, false, "PageHostInfoQuery", "86f1b399db359f0d38a9a9a4986a2e31", "page", "10154598347776729", RegularImmutableSet.a);
        }

        public final String m16678a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -803548981:
                    return "0";
                case 1831224761:
                    return "1";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
