package com.facebook.feed.rows.sections.attachments.linkshare;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: View/Change Native feed settings for debugging */
public class InstantPreviewKey implements ContextStateKey<String, InstantPreviewState> {
    private static final String f20973a = InstantPreviewKey.class.getName();
    private final String f20974b;

    public InstantPreviewKey(GraphQLStory graphQLStory) {
        this.f20974b = graphQLStory.g() + f20973a;
    }

    public final Object m23883a() {
        return new InstantPreviewState();
    }

    public final Object m23884b() {
        return this.f20974b;
    }
}
