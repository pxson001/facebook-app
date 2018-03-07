package com.facebook.socialgood.guestlist;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserDonorsConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserIncrementPersonalUpdatesCountMutationModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserInvitedUsersConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserNonDonorsConnectionQueryModel;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserSharersConnectionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: PAUSED */
public final class FundraiserGuestList {

    /* compiled from: PAUSED */
    public class FundraiserDonorsConnectionQueryString extends TypedGraphQlQueryString<FundraiserDonorsConnectionQueryModel> {
        public FundraiserDonorsConnectionQueryString() {
            super(FundraiserDonorsConnectionQueryModel.class, false, "FundraiserDonorsConnectionQuery", "b11b50cf30cc1584cdd070529c228791", "node", "10154666005031729", RegularImmutableSet.a);
        }

        public final String m13028a(String str) {
            switch (str.hashCode()) {
                case -1318255061:
                    return "0";
                case -1101600581:
                    return "3";
                case -230346670:
                    return "1";
                case 537332207:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: PAUSED */
    public class FundraiserIncrementPersonalUpdatesCountMutationString extends TypedGraphQLMutationString<FundraiserIncrementPersonalUpdatesCountMutationModel> {
        public FundraiserIncrementPersonalUpdatesCountMutationString() {
            super(FundraiserIncrementPersonalUpdatesCountMutationModel.class, false, "FundraiserIncrementPersonalUpdatesCountMutation", "d24876fc1d5d96c6d6000669dd789142", "fundraiser_increment_personal_updates_count", "0", "10154624535681729", RegularImmutableSet.a);
        }

        public final String m13029a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: PAUSED */
    public class FundraiserInvitedUsersConnectionQueryString extends TypedGraphQlQueryString<FundraiserInvitedUsersConnectionQueryModel> {
        public FundraiserInvitedUsersConnectionQueryString() {
            super(FundraiserInvitedUsersConnectionQueryModel.class, false, "FundraiserInvitedUsersConnectionQuery", "7dee720c4fdebbf23c6610fdca7205c5", "node", "10154666005046729", RegularImmutableSet.a);
        }

        public final String m13030a(String str) {
            switch (str.hashCode()) {
                case -1318255061:
                    return "0";
                case -1101600581:
                    return "3";
                case -230346670:
                    return "1";
                case 537332207:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: PAUSED */
    public class FundraiserNonDonorsConnectionQueryString extends TypedGraphQlQueryString<FundraiserNonDonorsConnectionQueryModel> {
        public FundraiserNonDonorsConnectionQueryString() {
            super(FundraiserNonDonorsConnectionQueryModel.class, false, "FundraiserNonDonorsConnectionQuery", "98df7d95aaa90ba170bed5fa4c78ab29", "node", "10154666005011729", RegularImmutableSet.a);
        }

        public final String m13031a(String str) {
            switch (str.hashCode()) {
                case -1318255061:
                    return "0";
                case -1101600581:
                    return "3";
                case -230346670:
                    return "1";
                case 537332207:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: PAUSED */
    public class FundraiserSharersConnectionQueryString extends TypedGraphQlQueryString<FundraiserSharersConnectionQueryModel> {
        public FundraiserSharersConnectionQueryString() {
            super(FundraiserSharersConnectionQueryModel.class, false, "FundraiserSharersConnectionQuery", "58589a1c49ba84e6e1a36b50c3023be2", "node", "10154666005026729", RegularImmutableSet.a);
        }

        public final String m13032a(String str) {
            switch (str.hashCode()) {
                case -1318255061:
                    return "0";
                case -1101600581:
                    return "3";
                case -230346670:
                    return "1";
                case 537332207:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
