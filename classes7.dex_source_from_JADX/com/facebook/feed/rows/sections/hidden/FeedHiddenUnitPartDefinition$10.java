package com.facebook.feed.rows.sections.hidden;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackTargetType;
import com.facebook.graphql.enums.StoryVisibility;

/* compiled from: Unable to provide an image due to stuck input/output */
public /* synthetic */ class FeedHiddenUnitPartDefinition$10 {
    public static final /* synthetic */ int[] f21430a = new int[StoryVisibility.values().length];
    static final /* synthetic */ int[] f21431b = new int[GraphQLNegativeFeedbackActionType.values().length];
    static final /* synthetic */ int[] f21432c = new int[GraphQLNegativeFeedbackTargetType.values().length];

    static {
        try {
            f21432c[GraphQLNegativeFeedbackTargetType.PAGE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f21432c[GraphQLNegativeFeedbackTargetType.GROUP.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f21432c[GraphQLNegativeFeedbackTargetType.PEOPLE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f21432c[GraphQLNegativeFeedbackTargetType.EVENT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f21432c[GraphQLNegativeFeedbackTargetType.APP.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.NEWSFEED_SETTINGS.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.HIDE_TOPIC.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_OWNER.ordinal()] = 5;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE.ordinal()] = 6;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER.ordinal()] = 7;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR.ordinal()] = 8;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f21431b[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET.ordinal()] = 9;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f21430a[StoryVisibility.GONE.ordinal()] = 1;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f21430a[StoryVisibility.CONTRACTING.ordinal()] = 2;
        } catch (NoSuchFieldError e16) {
        }
    }
}
