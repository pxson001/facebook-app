package com.facebook.messaging.blocking.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.blocking.graphql.BlockingMutationsModels.MessengerCommerceUserControlActionModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: onCancel */
public final class BlockingMutations {

    /* compiled from: onCancel */
    public class MessengerCommerceUserControlActionString extends TypedGraphQLMutationString<MessengerCommerceUserControlActionModel> {
        public MessengerCommerceUserControlActionString() {
            super(MessengerCommerceUserControlActionModel.class, false, "MessengerCommerceUserControlAction", "8aec5f8aa312dfe93d6af84699f2419c", "messenger_commerce_user_control_action", "0", "10154204803951729", RegularImmutableSet.a);
        }

        public final String m8561a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
