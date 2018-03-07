package com.facebook.feed.menu.newsfeed;

import com.facebook.graphql.enums.GraphQLGender;

/* compiled from: all_cards_enabled_message */
/* synthetic */ class NewsFeedStoryMenuHelper$12 {
    static final /* synthetic */ int[] f19455a = new int[GraphQLGender.values().length];
    static final /* synthetic */ int[] f19456b = new int[NewsFeedStoryMenuHelper$MenuItemType.values().length];

    static {
        try {
            f19456b[NewsFeedStoryMenuHelper$MenuItemType.NEGATIVE_FEEDBACK_ACTION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19456b[NewsFeedStoryMenuHelper$MenuItemType.SAVE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19456b[NewsFeedStoryMenuHelper$MenuItemType.UN_SEE_FIRST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f19456b[NewsFeedStoryMenuHelper$MenuItemType.HIDE_TOPIC_FROM_USER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f19455a[GraphQLGender.MALE.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f19455a[GraphQLGender.FEMALE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
