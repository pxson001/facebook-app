package com.facebook.messaging.business.commerce.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceOrderReceiptModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommercePaginatedRetailItemsModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShipmentDetailsModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShoppingTrendingQueryModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.MessengerCommerceFetchProductGroupQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: videouploader */
public final class CommerceQueryFragments {

    /* compiled from: videouploader */
    public class CommerceOrderReceiptItemPaginatedQueryString extends TypedGraphQlQueryString<CommercePaginatedRetailItemsModel> {
        public CommerceOrderReceiptItemPaginatedQueryString() {
            super(CommercePaginatedRetailItemsModel.class, false, "CommerceOrderReceiptItemPaginatedQuery", "70099450624e757f9c61bc92bac73d90", "node", "10154675626526729", RegularImmutableSet.a);
        }

        public final String m402a(String str) {
            switch (str.hashCode()) {
                case -1966910237:
                    return "2";
                case -529660397:
                    return "0";
                case 1852162245:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videouploader */
    public class CommerceOrderReceiptQueryString extends TypedGraphQlQueryString<CommerceOrderReceiptModel> {
        public CommerceOrderReceiptQueryString() {
            super(CommerceOrderReceiptModel.class, false, "CommerceOrderReceiptQuery", "aef009887e6250428400caeb8324768d", "node", "10154675626546729", RegularImmutableSet.a);
        }

        public final String m403a(String str) {
            switch (str.hashCode()) {
                case -1966910237:
                    return "2";
                case -529660397:
                    return "0";
                case 1852162245:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videouploader */
    public class CommerceReceiptListQueryString extends TypedGraphQlQueryString<CommerceReceiptListQueryModel> {
        public CommerceReceiptListQueryString() {
            super(CommerceReceiptListQueryModel.class, false, "CommerceReceiptListQuery", "5155aaa05251935e2a97fda89b0e6b01", "me", "10154675626516729", RegularImmutableSet.a);
        }

        public final String m404a(String str) {
            switch (str.hashCode()) {
                case -1966910237:
                    return "3";
                case -760459840:
                    return "1";
                case 394632264:
                    return "2";
                case 1225234938:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videouploader */
    public class CommerceShipmentQueryString extends TypedGraphQlQueryString<CommerceShipmentDetailsModel> {
        public CommerceShipmentQueryString() {
            super(CommerceShipmentDetailsModel.class, false, "CommerceShipmentQuery", "8bc6871b1028b60339e2a830e276d3d4", "node", "10154675626551729", RegularImmutableSet.a);
        }

        public final String m405a(String str) {
            switch (str.hashCode()) {
                case -1966910237:
                    return "1";
                case -1681104416:
                    return "0";
                case 434916138:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videouploader */
    public class CommerceShoppingTrendingQueryString extends TypedGraphQlQueryString<CommerceShoppingTrendingQueryModel> {
        public CommerceShoppingTrendingQueryString() {
            super(CommerceShoppingTrendingQueryModel.class, false, "CommerceShoppingTrendingQuery", "c3711c4b149898814965797450ac3dd1", "page", "10154658596186729", RegularImmutableSet.a);
        }

        public final String m406a(String str) {
            switch (str.hashCode()) {
                case -1249512767:
                    return "1";
                case 1225234938:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videouploader */
    public class MessengerCommerceFetchProductGroupQueryString extends TypedGraphQlQueryString<MessengerCommerceFetchProductGroupQueryModel> {
        public MessengerCommerceFetchProductGroupQueryString() {
            super(MessengerCommerceFetchProductGroupQueryModel.class, false, "MessengerCommerceFetchProductGroupQuery", "1bf7f9fbc2a6988e78a7a5b891a6f068", "node", "10154343225441729", RegularImmutableSet.a);
        }

        public final String m407a(String str) {
            switch (str.hashCode()) {
                case 261607031:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
