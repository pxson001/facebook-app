package com.facebook.search.protocol.awareness;

import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: interstitial= */
public final class SearchAwareness {

    /* compiled from: interstitial= */
    public class UserSearchAwarenessSuggestionSubscriptionString extends TypedGraphQLSubscriptionString<C0774x92053e33> {
        public UserSearchAwarenessSuggestionSubscriptionString() {
            super(C0774x92053e33.class, false, "UserSearchAwarenessSuggestionSubscription", "73b53ad5b8974a9e9f0a3d7880c7c3e5", "user_search_awareness_suggestion_subscribe", "0", "10154640997916729", RegularImmutableSet.f688a);
        }

        public final String mo1605a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final TutorialNuxConfigurationString m27385b() {
        return new TutorialNuxConfigurationString();
    }

    public static final UserSearchAwarenessSuggestionSubscriptionString m27386c() {
        return new UserSearchAwarenessSuggestionSubscriptionString();
    }
}
