package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingFeatherMutationsModels.CrowdsourcingFeatherOverlayShownMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tap_minutiae */
public final class CrowdsourcingFeatherMutations {

    /* compiled from: tap_minutiae */
    public class CrowdsourcingFeatherOverlayShownMutationString extends TypedGraphQLMutationString<CrowdsourcingFeatherOverlayShownMutationModel> {
        public CrowdsourcingFeatherOverlayShownMutationString() {
            super(CrowdsourcingFeatherOverlayShownMutationModel.class, false, "CrowdsourcingFeatherOverlayShownMutation", "c7eb9496c4ea761616e01079cfe358f2", "feather_overlay_shown", "0", "10154595187686729", RegularImmutableSet.a);
        }

        public final String m2237a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
