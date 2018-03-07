package com.facebook.messaging.contactsyoumayknow.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsModels.AddCYMKSuggestionModel;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsModels.HideCYMKSuggestionModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: switch_page */
public final class ContactsYouMayKnowMutations {

    /* compiled from: switch_page */
    public class AddCYMKSuggestionString extends TypedGraphQLMutationString<AddCYMKSuggestionModel> {
        public AddCYMKSuggestionString() {
            super(AddCYMKSuggestionModel.class, false, "AddCYMKSuggestion", "0a1840fa830e129893060d89edd194dc", "cymk_suggestion_contact_add", "0", "10154571233211729", RegularImmutableSet.a);
        }

        public final String m1946a(String str) {
            switch (str.hashCode()) {
                case -1906025967:
                    return "2";
                case -1439844555:
                    return "3";
                case 100358090:
                    return "0";
                case 693548892:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: switch_page */
    public class HideCYMKSuggestionString extends TypedGraphQLMutationString<HideCYMKSuggestionModel> {
        public HideCYMKSuggestionString() {
            super(HideCYMKSuggestionModel.class, false, "HideCYMKSuggestion", "738a1001b5fd8da67b5a9e1fe71bd5de", "messenger_cymk_suggestion_hide", "0", "10154559475676729", RegularImmutableSet.a);
        }

        public final String m1947a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
