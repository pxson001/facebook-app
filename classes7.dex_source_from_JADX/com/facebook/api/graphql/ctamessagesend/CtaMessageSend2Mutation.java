package com.facebook.api.graphql.ctamessagesend;

import com.facebook.api.graphql.ctamessagesend.CtaMessageSend2MutationModels.CtaMessageSendMutation2Model;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_model */
public final class CtaMessageSend2Mutation {

    /* compiled from: video_model */
    public class CtaMessageSendMutation2String extends TypedGraphQLMutationString<CtaMessageSendMutation2Model> {
        public CtaMessageSendMutation2String() {
            super(CtaMessageSendMutation2Model.class, false, "CtaMessageSendMutation2", "7975a7544c416fcfae3fcae211aa9244", "cta_ad_message_send2", "0", "10154681264996729", RegularImmutableSet.a);
        }

        public final String m576a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
