package com.facebook.feed.rows.sections.inlinesurvey;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nullable;

/* compiled from: Unable to dispatch touch to JS as the catalyst instance has not been attached */
public class InlineSurveyFooterPartDefinition$Props implements HasFeedProps {
    public FeedProps<GraphQLStory> f21496a;
    public InlineSurveyPersistentState f21497b;

    public InlineSurveyFooterPartDefinition$Props(FeedProps<GraphQLStory> feedProps, InlineSurveyPersistentState inlineSurveyPersistentState) {
        this.f21496a = feedProps;
        this.f21497b = inlineSurveyPersistentState;
    }

    @Nullable
    public final FeedProps m24151f() {
        return this.f21496a;
    }
}
