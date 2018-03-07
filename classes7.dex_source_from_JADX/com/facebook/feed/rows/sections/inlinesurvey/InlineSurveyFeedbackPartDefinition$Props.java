package com.facebook.feed.rows.sections.inlinesurvey;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nullable;

/* compiled from: Unable to extract frame */
public class InlineSurveyFeedbackPartDefinition$Props implements HasFeedProps {
    public FeedProps<GraphQLStory> f21490a;
    public InlineSurveyPersistentState f21491b;

    public InlineSurveyFeedbackPartDefinition$Props(FeedProps<GraphQLStory> feedProps, InlineSurveyPersistentState inlineSurveyPersistentState) {
        this.f21490a = feedProps;
        this.f21491b = inlineSurveyPersistentState;
    }

    @Nullable
    public final FeedProps m24148f() {
        return this.f21490a;
    }
}
