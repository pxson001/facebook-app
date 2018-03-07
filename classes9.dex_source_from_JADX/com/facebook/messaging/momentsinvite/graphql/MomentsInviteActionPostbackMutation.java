package com.facebook.messaging.momentsinvite.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.momentsinvite.graphql.MomentsInviteActionPostbackMutationModels.MomentsInviteActionPostbackMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: j2me */
public final class MomentsInviteActionPostbackMutation {

    /* compiled from: j2me */
    public class MomentsInviteActionPostbackMutationString extends TypedGraphQLMutationString<MomentsInviteActionPostbackMutationModel> {
        public MomentsInviteActionPostbackMutationString() {
            super(MomentsInviteActionPostbackMutationModel.class, false, "MomentsInviteActionPostbackMutation", "e0ddf3f0a1044ce0c439464843445a51", "moments_bot_invite_postback", "0", "10154683402831729", RegularImmutableSet.a);
        }

        public final String m12755a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
