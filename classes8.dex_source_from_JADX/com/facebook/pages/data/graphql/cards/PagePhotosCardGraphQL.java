package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.OwnedPagePhotosQueryModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.UnownedLocalPagePhotosQueryModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.UnownedNonLocalPagePhotosQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: content ID cannot be null or empty */
public final class PagePhotosCardGraphQL {

    /* compiled from: content ID cannot be null or empty */
    public class OwnedPagePhotosQueryString extends TypedGraphQlQueryString<OwnedPagePhotosQueryModel> {
        public OwnedPagePhotosQueryString() {
            super(OwnedPagePhotosQueryModel.class, false, "OwnedPagePhotosQuery", "e6133917c8c80cd9d72a130627bf31a1", "page", "10154439284286729", RegularImmutableSet.a);
        }

        public final String m20582a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "6";
                case -1745741354:
                    return "8";
                case -1663499699:
                    return "4";
                case -1150725321:
                    return "7";
                case -803548981:
                    return "0";
                case -461877888:
                    return "5";
                case -317710003:
                    return "10";
                case 169846802:
                    return "3";
                case 176687133:
                    return "1";
                case 557908192:
                    return "9";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: content ID cannot be null or empty */
    public class UnownedLocalPagePhotosQueryString extends TypedGraphQlQueryString<UnownedLocalPagePhotosQueryModel> {
        public UnownedLocalPagePhotosQueryString() {
            super(UnownedLocalPagePhotosQueryModel.class, false, "UnownedLocalPagePhotosQuery", "3dea2b20785ea5c6d8486947b1309ad3", "page", "10154439284291729", RegularImmutableSet.a);
        }

        public final String m20583a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "7";
                case -1745741354:
                    return "9";
                case -1663499699:
                    return "5";
                case -1150725321:
                    return "8";
                case -803548981:
                    return "0";
                case -461877888:
                    return "6";
                case -317710003:
                    return "11";
                case 169846802:
                    return "4";
                case 176687133:
                    return "1";
                case 557908192:
                    return "10";
                case 1598177384:
                    return "2";
                case 1939875509:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: content ID cannot be null or empty */
    public class UnownedNonLocalPagePhotosQueryString extends TypedGraphQlQueryString<UnownedNonLocalPagePhotosQueryModel> {
        public UnownedNonLocalPagePhotosQueryString() {
            super(UnownedNonLocalPagePhotosQueryModel.class, false, "UnownedNonLocalPagePhotosQuery", "ed16356e5c74e92a83c9daa40cf19eac", "page", "10154439284281729", RegularImmutableSet.a);
        }

        public final String m20584a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "7";
                case -1745741354:
                    return "9";
                case -1663499699:
                    return "5";
                case -1150725321:
                    return "8";
                case -803548981:
                    return "0";
                case -461877888:
                    return "6";
                case -317710003:
                    return "11";
                case 169846802:
                    return "4";
                case 176687133:
                    return "1";
                case 557908192:
                    return "10";
                case 1598177384:
                    return "2";
                case 1939875509:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
