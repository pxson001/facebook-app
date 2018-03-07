package com.facebook.feed.menu.base;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;

/* compiled from: all_cards_enabled_submessage */
public class StoryMenuIconUtil {

    /* compiled from: all_cards_enabled_submessage */
    /* synthetic */ class C16801 {
        static final /* synthetic */ int[] f19446a = new int[GraphQLNegativeFeedbackActionType.values().length];

        static {
            try {
                f19446a[GraphQLNegativeFeedbackActionType.UNTAG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.DONT_LIKE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE_TOPIC_MISCLASSIFICATION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE_ADVERTISER.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE_APP.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f19446a[GraphQLNegativeFeedbackActionType.HIDE_RESEARCH_POLLS.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private StoryMenuIconUtil() {
    }

    public static int m22824a(GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        switch (C16801.f19446a[graphQLNegativeFeedbackActionType.ordinal()]) {
            case 1:
                return 2130840123;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return 2130839920;
            case 7:
                return 2130840081;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 2130840145;
            default:
                return 0;
        }
    }

    public static int m22825c() {
        return 2130839905;
    }

    public static int m22826n() {
        return 2130839920;
    }
}
