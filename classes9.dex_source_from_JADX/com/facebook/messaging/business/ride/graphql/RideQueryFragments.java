package com.facebook.messaging.business.ride.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideEstimateQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePaymentQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RidePromoShareQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideProvidersQueryModel;
import com.facebook.messaging.business.ride.graphql.RideQueryFragmentsModels.RideTypesInfoQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: montage_composer */
public final class RideQueryFragments {

    /* compiled from: montage_composer */
    public class RideEstimateQueryString extends TypedGraphQlQueryString<RideEstimateQueryModel> {
        public RideEstimateQueryString() {
            super(RideEstimateQueryModel.class, false, "RideEstimateQuery", "97df3c69c3769ee0e2aa56cd23238cce", "me", "10154358537781729", RegularImmutableSet.a);
        }

        public final String m9421a(String str) {
            switch (str.hashCode()) {
                case -1583658627:
                    return "4";
                case -987494927:
                    return "0";
                case -40977887:
                    return "1";
                case -21754178:
                    return "5";
                case 582895243:
                    return "3";
                case 1622434832:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: montage_composer */
    public class RidePaymentQueryString extends TypedGraphQlQueryString<RidePaymentQueryModel> {
        public RidePaymentQueryString() {
            super(RidePaymentQueryModel.class, false, "RidePaymentQuery", "f2059fdd2bdbde10a6be9c94bc6cd552", "me", "10154579700251729", RegularImmutableSet.a);
        }

        public final String m9422a(String str) {
            switch (str.hashCode()) {
                case -987494927:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: montage_composer */
    public class RidePromoShareQueryString extends TypedGraphQlQueryString<RidePromoShareQueryModel> {
        public RidePromoShareQueryString() {
            super(RidePromoShareQueryModel.class, false, "RidePromoShareQuery", "600c0df5a6075aade75a4767b594f600", "me", "10154553541876729", RegularImmutableSet.a);
        }

        public final String m9423a(String str) {
            switch (str.hashCode()) {
                case -987494927:
                    return "0";
                case 974663898:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: montage_composer */
    public class RideProvidersQueryString extends TypedGraphQlQueryString<RideProvidersQueryModel> {
        public RideProvidersQueryString() {
            super(RideProvidersQueryModel.class, false, "RideProvidersQuery", "5bfb298f1bab2782ab4a166f83261c45", "me", "10154661407481729", RegularImmutableSet.a);
        }

        public final String m9424a(String str) {
            switch (str.hashCode()) {
                case 213793868:
                    return "2";
                case 582895243:
                    return "1";
                case 1622434832:
                    return "0";
                case 1899647841:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: montage_composer */
    public class RideTypesInfoQueryString extends TypedGraphQlQueryString<RideTypesInfoQueryModel> {
        public RideTypesInfoQueryString() {
            super(RideTypesInfoQueryModel.class, false, "RideTypesInfoQuery", "a39dd9db1eebdcf38bfb5c8087547423", "me", "10154405018121729", RegularImmutableSet.a);
        }

        public final String m9425a(String str) {
            switch (str.hashCode()) {
                case -1439978388:
                    return "1";
                case -987494927:
                    return "0";
                case 102976443:
                    return "3";
                case 137365935:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
