package com.facebook.feed.menu.base;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackTargetType;

/* compiled from: analytics_extra_data */
/* synthetic */ class BaseFeedStoryMenuHelper$12 {
    static final /* synthetic */ int[] f19372a = new int[GraphQLNegativeFeedbackActionType.values().length];
    static final /* synthetic */ int[] f19373b = new int[GraphQLNegativeFeedbackTargetType.values().length];

    static {
        try {
            f19373b[GraphQLNegativeFeedbackTargetType.PEOPLE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19373b[GraphQLNegativeFeedbackTargetType.GROUP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19373b[GraphQLNegativeFeedbackTargetType.PAGE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f19372a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f19372a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_OWNER.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f19372a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f19372a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f19372a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR.ordinal()] = 5;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f19372a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET.ordinal()] = 6;
        } catch (NoSuchFieldError e9) {
        }
    }
}
