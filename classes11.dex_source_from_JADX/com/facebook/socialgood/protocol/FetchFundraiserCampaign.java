package com.facebook.socialgood.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.FetchDonationPaymentMethodsQueryModel;
import com.facebook.socialgood.protocol.FetchFundraiserCampaignModels.FundraiserCampaignFragmentModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: OptimisticBadgeStore */
public final class FetchFundraiserCampaign {

    /* compiled from: OptimisticBadgeStore */
    public class FetchDonationPaymentMethodsQueryString extends TypedGraphQlQueryString<FetchDonationPaymentMethodsQueryModel> {
        public FetchDonationPaymentMethodsQueryString() {
            super(FetchDonationPaymentMethodsQueryModel.class, false, "FetchDonationPaymentMethodsQuery", "6f40d78000f7ee927fc08f577b1326b9", "viewer", "10153900097376729", RegularImmutableSet.a);
        }
    }

    /* compiled from: OptimisticBadgeStore */
    public class FetchFundraiserCampaignQueryString extends TypedGraphQlQueryString<FundraiserCampaignFragmentModel> {
        public FetchFundraiserCampaignQueryString() {
            super(FundraiserCampaignFragmentModel.class, false, "FetchFundraiserCampaignQuery", "6411534e6e4c64fa8fcbf5ef559878de", "node", "10154429040136729", RegularImmutableSet.a);
        }

        public final String m13217a(String str) {
            switch (str.hashCode()) {
                case 1598177384:
                    return "1";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
