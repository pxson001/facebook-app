package com.facebook.feedplugins.pymk;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.interstitial.manager.InterstitialTrigger;

/* compiled from: TOP_PHONE_CONTACT */
public class PeopleYouMayKnowPersistentState {

    /* compiled from: TOP_PHONE_CONTACT */
    public class FriendshipContextStateKey implements ContextStateKey<String, FriendshipPersistentState> {
        private final String f24681a;
        private final GraphQLFriendshipStatus f24682b;

        public FriendshipContextStateKey(String str, GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f24681a = FriendshipContextStateKey.class.getSimpleName() + str;
            this.f24682b = graphQLFriendshipStatus;
        }

        public final Object m26566a() {
            return new FriendshipPersistentState(this.f24682b);
        }

        public final Object m26567b() {
            return this.f24681a;
        }
    }

    /* compiled from: TOP_PHONE_CONTACT */
    public class FriendshipPersistentState {
        public final GraphQLFriendshipStatus f24683a;
        public final boolean f24684b;

        public FriendshipPersistentState(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f24683a = graphQLFriendshipStatus;
            this.f24684b = false;
        }

        public FriendshipPersistentState(GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
            this.f24683a = graphQLFriendshipStatus;
            this.f24684b = z;
        }
    }

    /* compiled from: TOP_PHONE_CONTACT */
    public class PageSwitcherContextStateKey implements ContextStateKey<String, Boolean> {
        private final String f24685a;

        public PageSwitcherContextStateKey(String str) {
            this.f24685a = PageSwitcherContextStateKey.class.getSimpleName() + str;
        }

        public final Object m26568a() {
            return Boolean.valueOf(false);
        }

        public final Object m26569b() {
            return this.f24685a;
        }
    }

    /* compiled from: TOP_PHONE_CONTACT */
    public class QPContextStateKey implements ContextStateKey<String, QPPersistentState> {
        private String f24686a;
        private QPPersistentState f24687b;

        public QPContextStateKey(String str, QPPersistentState qPPersistentState) {
            this.f24686a = QPContextStateKey.class.getSimpleName() + str;
            this.f24687b = qPPersistentState;
        }

        public final Object m26570a() {
            return this.f24687b;
        }

        public final Object m26571b() {
            return this.f24686a;
        }
    }

    /* compiled from: TOP_PHONE_CONTACT */
    public class QPPersistentState {
        public boolean f24688a;
        public InterstitialTrigger f24689b;

        public QPPersistentState(boolean z, InterstitialTrigger interstitialTrigger) {
            this.f24688a = z;
            this.f24689b = interstitialTrigger;
        }
    }
}
