package com.facebook.feed.rows.sections.inlinesurvey;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: Unable to create temporary file */
public class InlineSurveyQuestionPartDefinition$Props implements HasFeedProps {
    public final boolean f21512a;
    public final FeedProps<GraphQLStory> f21513b;
    public final String f21514c;
    public final ImmutableList<String> f21515d;
    public final InlineSurveyPersistentState f21516e;

    public InlineSurveyQuestionPartDefinition$Props(boolean z, FeedProps<GraphQLStory> feedProps, String str, ImmutableList<String> immutableList, InlineSurveyPersistentState inlineSurveyPersistentState) {
        this.f21512a = z;
        this.f21513b = feedProps;
        this.f21514c = str;
        this.f21515d = immutableList;
        this.f21516e = inlineSurveyPersistentState;
    }

    @Nullable
    public final FeedProps m24155f() {
        return this.f21513b;
    }
}
