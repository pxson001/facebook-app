package com.facebook.offers.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimEnableNotificationsMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimMarkAsUsedMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewRemoveFromWalletMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: current_region */
public final class OfferMutations {

    /* compiled from: current_region */
    public class OfferClaimEnableNotificationsMutationString extends TypedGraphQLMutationString<OfferClaimEnableNotificationsMutationModel> {
        public OfferClaimEnableNotificationsMutationString() {
            super(OfferClaimEnableNotificationsMutationModel.class, false, "OfferClaimEnableNotificationsMutation", "2bb3cf1533829b5189e14ffcd56afb9c", "offer_claim_enable_notifications", "0", "10154648648071729", RegularImmutableSet.a);
        }

        public final String m19044a(String str) {
            switch (str.hashCode()) {
                case -1054754885:
                    return "2";
                case -958703219:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: current_region */
    public class OfferClaimMarkAsUsedMutationString extends TypedGraphQLMutationString<OfferClaimMarkAsUsedMutationModel> {
        public OfferClaimMarkAsUsedMutationString() {
            super(OfferClaimMarkAsUsedMutationModel.class, false, "OfferClaimMarkAsUsedMutation", "15f7240177ede159bcf744c4142dbc99", "offer_claim_mark_as_used", "0", "10154648648061729", RegularImmutableSet.a);
        }

        public final String m19045a(String str) {
            switch (str.hashCode()) {
                case -1054754885:
                    return "2";
                case -958703219:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: current_region */
    public class OfferClaimToWalletMutationString extends TypedGraphQLMutationString<OfferClaimToWalletMutationModel> {
        public OfferClaimToWalletMutationString() {
            super(OfferClaimToWalletMutationModel.class, false, "OfferClaimToWalletMutation", "42e9730e3f83968dbdb9a00c65d2a7ac", "offer_claim_to_wallet", "0", "10154648648086729", RegularImmutableSet.a);
        }

        public final String m19046a(String str) {
            switch (str.hashCode()) {
                case -1054754885:
                    return "2";
                case -958703219:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: current_region */
    public class OfferViewClaimToWalletMutationString extends TypedGraphQLMutationString<OfferViewClaimToWalletMutationModel> {
        public OfferViewClaimToWalletMutationString() {
            super(OfferViewClaimToWalletMutationModel.class, false, "OfferViewClaimToWalletMutation", "db43b5fcb0a1b1c011933e7e23e6fbd0", "offer_view_claim_to_wallet", "0", "10154648648076729", RegularImmutableSet.a);
        }

        public final String m19047a(String str) {
            switch (str.hashCode()) {
                case -1054754885:
                    return "2";
                case -958703219:
                    return "1";
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: current_region */
    public class OfferViewRemoveFromWalletMutationString extends TypedGraphQLMutationString<OfferViewRemoveFromWalletMutationModel> {
        public OfferViewRemoveFromWalletMutationString() {
            super(OfferViewRemoveFromWalletMutationModel.class, false, "OfferViewRemoveFromWalletMutation", "a21f4aa6b9805eb807544171390b05cd", "offer_view_remove_from_wallet", "0", "10154484705666729", RegularImmutableSet.a);
        }

        public final String m19048a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
