package com.facebook.feed.rows.sections.inlinesurvey;

import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unable to dispatch keyboard events in JS as the react instance has not been attached */
public class InlineSurveyKey implements ContextStateKey<String, InlineSurveyPersistentState> {
    private String f21498a;

    public InlineSurveyKey(GraphQLStory graphQLStory) {
        this.f21498a = getClass() + StoryKeyUtil.a(graphQLStory);
    }

    public final Object m24152a() {
        return new InlineSurveyPersistentState();
    }

    public final Object m24153b() {
        return this.f21498a;
    }
}
