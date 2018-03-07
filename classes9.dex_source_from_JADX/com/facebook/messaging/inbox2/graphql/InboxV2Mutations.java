package com.facebook.messaging.inbox2.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsModels.MessengerInbox2UnitActionMutationModel;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsModels.MessengerInboxItemActionMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mSelectedTheme */
public final class InboxV2Mutations {

    /* compiled from: mSelectedTheme */
    public class MessengerInbox2UnitActionMutationString extends TypedGraphQLMutationString<MessengerInbox2UnitActionMutationModel> {
        public MessengerInbox2UnitActionMutationString() {
            super(MessengerInbox2UnitActionMutationModel.class, false, "MessengerInbox2UnitActionMutation", "0d16ab6d40979b34b7b02c7d3b8668e1", "messenger_inbox_unit_record_action", "0", "10154593186681729", RegularImmutableSet.a);
        }

        public final String m11500a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: mSelectedTheme */
    public class MessengerInboxItemActionMutationString extends TypedGraphQLMutationString<MessengerInboxItemActionMutationModel> {
        public MessengerInboxItemActionMutationString() {
            super(MessengerInboxItemActionMutationModel.class, false, "MessengerInboxItemActionMutation", "eface31ddeee6fe78bf06d3504453490", "messenger_inbox_item_record_action", "0", "10154390431191729", RegularImmutableSet.a);
        }

        public final String m11501a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
