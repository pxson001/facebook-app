package com.facebook.zero.iptest.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.FetchZeroIPTestModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.ZeroIPTestSubmitMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: events_guest_list_session */
public final class ZeroIPTestGraphQL {

    /* compiled from: events_guest_list_session */
    public class FetchZeroIPTestString extends TypedGraphQlQueryString<FetchZeroIPTestModel> {
        public FetchZeroIPTestString() {
            super(FetchZeroIPTestModel.class, false, "FetchZeroIPTest", "502921ae84506ac7231baecf21cc3785", "viewer", "10154641721196729", RegularImmutableSet.a);
        }

        public final String m13142a(String str) {
            switch (str.hashCode()) {
                case 1577525288:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: events_guest_list_session */
    public class ZeroIPTestSubmitMutationString extends TypedGraphQLMutationString<ZeroIPTestSubmitMutationModel> {
        public ZeroIPTestSubmitMutationString() {
            super(ZeroIPTestSubmitMutationModel.class, false, "ZeroIPTestSubmitMutation", "4686040c0e34d4157b4add481fbf0df6", "zero_ip_test_submit", "0", "10154641772631729", RegularImmutableSet.a);
        }

        public final String m13143a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
