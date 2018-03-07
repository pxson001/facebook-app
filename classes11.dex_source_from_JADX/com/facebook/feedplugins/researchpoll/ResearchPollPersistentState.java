package com.facebook.feedplugins.researchpoll;

import com.facebook.graphql.model.GraphQLResearchPollMultipleChoiceQuestion;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: calendar_id */
public class ResearchPollPersistentState {
    public final Map<String, Boolean> f9070a = Maps.c();
    public GraphQLResearchPollMultipleChoiceQuestion f9071b;
    public boolean f9072c;
    public String f9073d;
    public boolean f9074e;
    public Integer f9075f = Integer.valueOf(-1);
    public boolean f9076g;
    public boolean f9077h;

    public final GraphQLResearchPollMultipleChoiceQuestion m9766c() {
        return this.f9071b;
    }

    public final boolean m9765b(String str) {
        return this.f9070a.containsKey(str) ? ((Boolean) this.f9070a.get(str)).booleanValue() : false;
    }

    public final void m9767d() {
        this.f9070a.clear();
    }

    public final boolean m9768e() {
        return this.f9070a.containsValue(Boolean.TRUE);
    }
}
