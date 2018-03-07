package com.facebook.crowdsourcing.postactionvote.graphql;

import com.facebook.crowdsourcing.postactionvote.graphql.CrowdsourcingCurrentValueVoteMutationModels.CrowdsourcingCurrentValueVoteMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: com.facebook.contacts.CONTACT_BULK_DELETE */
public final class CrowdsourcingCurrentValueVoteMutation {

    /* compiled from: com.facebook.contacts.CONTACT_BULK_DELETE */
    public class CrowdsourcingCurrentValueVoteMutationString extends TypedGraphQLMutationString<CrowdsourcingCurrentValueVoteMutationModel> {
        public CrowdsourcingCurrentValueVoteMutationString() {
            super(CrowdsourcingCurrentValueVoteMutationModel.class, false, "CrowdsourcingCurrentValueVoteMutation", "fc2cb580c6ebf18fd085d34732460285", "crowdsourcing_current_value_vote", "0", "10154278988311729", RegularImmutableSet.a);
        }

        public final String m21449a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
