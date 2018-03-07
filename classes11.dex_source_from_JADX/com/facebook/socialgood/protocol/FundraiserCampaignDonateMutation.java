package com.facebook.socialgood.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.socialgood.protocol.FundraiserCampaignDonateMutationModels.FundraiserCampaignDonateMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Open */
public final class FundraiserCampaignDonateMutation {

    /* compiled from: Open */
    public class FundraiserCampaignDonateMutationString extends TypedGraphQLMutationString<FundraiserCampaignDonateMutationFieldsModel> {
        public FundraiserCampaignDonateMutationString() {
            super(FundraiserCampaignDonateMutationFieldsModel.class, false, "FundraiserCampaignDonateMutation", "5acf8e8a501ed3f793b806332516995c", "fundraiser_campaign_donation_create", "0", "10154343228171729", RegularImmutableSet.a);
        }

        public final String m13273a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
