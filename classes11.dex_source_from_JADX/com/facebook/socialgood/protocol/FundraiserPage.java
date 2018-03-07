package com.facebook.socialgood.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserInviteSuggestionsQueryModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderQueryModel;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserSendInvitesMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: OTHERS_OVERFLOW */
public final class FundraiserPage {

    /* compiled from: OTHERS_OVERFLOW */
    public class FundraiserInviteSuggestionsQueryString extends TypedGraphQlQueryString<FundraiserInviteSuggestionsQueryModel> {
        public FundraiserInviteSuggestionsQueryString() {
            super(FundraiserInviteSuggestionsQueryModel.class, false, "FundraiserInviteSuggestionsQuery", "98d13a14d5be7b219a1ff6097dadfac5", "node", "10154538265126729", RegularImmutableSet.a);
        }

        public final String m13288a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "2";
                case 94851343:
                    return "1";
                case 2083788458:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: OTHERS_OVERFLOW */
    public class FundraiserPageHeaderQueryString extends TypedGraphQlQueryString<FundraiserPageHeaderQueryModel> {
        public FundraiserPageHeaderQueryString() {
            super(FundraiserPageHeaderQueryModel.class, false, "FundraiserPageHeaderQuery", "35e15feb9ca7d63af2107792917a14f7", "node", "10154680556536729", RegularImmutableSet.a);
        }

        public final String m13289a(String str) {
            switch (str.hashCode()) {
                case 810737919:
                    return "1";
                case 1598177384:
                    return "2";
                case 2083788458:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m13290a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: OTHERS_OVERFLOW */
    public class FundraiserSendInvitesMutationString extends TypedGraphQLMutationString<FundraiserSendInvitesMutationFieldsModel> {
        public FundraiserSendInvitesMutationString() {
            super(FundraiserSendInvitesMutationFieldsModel.class, false, "FundraiserSendInvitesMutation", "032baebf8214bd7c4cfdfb679a1ee1ac", "fundraiser_send_invites", "0", "10154409979181729", RegularImmutableSet.a);
        }

        public final String m13291a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
