package com.facebook.aldrin.graphql;

import com.facebook.aldrin.graphql.AldrinGraphQLModels.RegionTosRespondMutationModel;
import com.facebook.aldrin.graphql.AldrinGraphQLModels.RegionTosStatusFragmentModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: link_tap */
public final class AldrinGraphQL {

    /* compiled from: link_tap */
    public class FetchRegionTosStatusString extends TypedGraphQlQueryString<RegionTosStatusFragmentModel> {
        public FetchRegionTosStatusString() {
            super(RegionTosStatusFragmentModel.class, false, "FetchRegionTosStatus", "23e5e2daa2291d22344da16ca00346e8", "region_tos_status", "10154575528441729", RegularImmutableSet.a);
        }
    }

    /* compiled from: link_tap */
    public class RegionTosRespondMutationString extends TypedGraphQLMutationString<RegionTosRespondMutationModel> {
        public RegionTosRespondMutationString() {
            super(RegionTosRespondMutationModel.class, false, "RegionTosRespondMutation", "c4933a974628b09b4cf6d0d912bba0c0", "region_tos_respond", "0", "10154678638206729", RegularImmutableSet.a);
        }

        public final String m12129a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FetchRegionTosStatusString m12130a() {
        return new FetchRegionTosStatusString();
    }

    public static final RegionTosRespondMutationString m12131b() {
        return new RegionTosRespondMutationString();
    }
}
