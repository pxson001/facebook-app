package com.facebook.feedplugins.survey;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;

/* compiled from: android_bluetooth_support_detection */
public class SurveyStoryKey implements ContextStateKey<String, SurveyPersistentState> {
    private final String f9930a;

    public SurveyStoryKey(GraphQLSurveyFeedUnit graphQLSurveyFeedUnit) {
        this.f9930a = graphQLSurveyFeedUnit.s() != null ? graphQLSurveyFeedUnit.s().k() : null;
    }

    public final Object m10294b() {
        return this.f9930a;
    }

    public final Object m10293a() {
        return new SurveyPersistentState();
    }
}
