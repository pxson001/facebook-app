package com.facebook.graphql.model.mutator;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.modelutil.BaseModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: TT4; */
public class FeedUnitMutator {
    private final FeedUnit f13496a;

    protected FeedUnitMutator(FeedUnit feedUnit) {
        this.f13496a = feedUnit;
    }

    public static FeedUnitMutator m22616a(FeedUnit feedUnit) {
        Preconditions.checkNotNull(feedUnit);
        if (feedUnit instanceof GraphQLStory) {
            return GraphQLStoryMutator.m22634a((GraphQLStory) feedUnit);
        }
        if (feedUnit instanceof BaseModel) {
            return new FeedUnitMutator((FeedUnit) ((BaseModel) feedUnit).f());
        }
        throw new RuntimeException("Should only use FeedUnitMutator for feedunits deriving from BaseModel:" + feedUnit.getClass().getSimpleName());
    }

    public FeedUnit mo1233a() {
        return this.f13496a;
    }

    public final FeedUnitMutator m22625a(ImmutableList<String> immutableList) {
        FeedUnitExtra j = this.f13496a.j();
        if (immutableList != j.a) {
            j.a = immutableList;
            j.c();
        }
        return this;
    }

    public final FeedUnitMutator m22627b(ImmutableList<String> immutableList) {
        FeedUnitExtra j = this.f13496a.j();
        if (immutableList != j.c) {
            j.c = immutableList;
            j.c();
        }
        return this;
    }

    public final FeedUnitMutator m22624a(StoryVisibility storyVisibility) {
        if (this.f13496a instanceof HideableUnit) {
            m22618a((HideableUnit) this.f13496a, storyVisibility);
            return this;
        }
        throw new RuntimeException("Should only call setStoryVisibility on a HideableUnit:" + this.f13496a.getClass().getSimpleName());
    }

    public final FeedUnitMutator m22621a(int i) {
        if (this.f13496a instanceof HideableUnit) {
            m22617a((HideableUnit) this.f13496a, i);
            return this;
        }
        throw new RuntimeException("Should only call setVisibleHeight on a HideableUnit:" + this.f13496a.getClass().getSimpleName());
    }

    public final FeedUnitMutator m22622a(long j, StoryVisibility storyVisibility, int i) {
        FetchTimeMsHelper.a(this.f13496a, j);
        m22624a(storyVisibility);
        m22621a(i);
        return this;
    }

    public final FeedUnitMutator m22626a(boolean z) {
        if ((this.f13496a instanceof GraphQLSurveyFeedUnit) || (this.f13496a instanceof GraphQLResearchPollFeedUnit)) {
            boolean z2;
            FeedUnitExtra j = this.f13496a.j();
            if (this.f13496a.j().b || z) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 != j.b) {
                j.b = z2;
                j.c();
            }
            return this;
        }
        throw new RuntimeException("setCompleted called on wrong type of feedunit:" + this.f13496a.getClass().getSimpleName());
    }

    public final FeedUnitMutator m22623a(GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        if (this.f13496a instanceof NegativeFeedbackActionsUnit) {
            m22619a((NegativeFeedbackActionsUnit) this.f13496a, graphQLNegativeFeedbackActionType);
            return this;
        }
        throw new RuntimeException("setLastNegativeFeedbackActionType called on wrong feedunit type:" + this.f13496a.getClass().getSimpleName());
    }

    public static void m22618a(HideableUnit hideableUnit, StoryVisibility storyVisibility) {
        try {
            hideableUnit.a("local_story_visibility", storyVisibility == null ? null : storyVisibility.name(), false);
        } catch (CloneNotSupportedException e) {
        }
    }

    public static void m22617a(HideableUnit hideableUnit, int i) {
        try {
            hideableUnit.a("local_story_visible_height", Integer.valueOf(i), false);
        } catch (CloneNotSupportedException e) {
        }
    }

    private static void m22619a(NegativeFeedbackActionsUnit negativeFeedbackActionsUnit, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        try {
            negativeFeedbackActionsUnit.a("local_last_negative_feedback_action_type", graphQLNegativeFeedbackActionType == null ? null : graphQLNegativeFeedbackActionType.name(), false);
        } catch (CloneNotSupportedException e) {
        }
    }
}
