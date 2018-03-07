package com.facebook.messaging.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;

/* compiled from: title and description are empty for formatted tooltip. */
public class StyleAssociation<SR extends StyleRenderer, SC extends SnippetCreator> {
    public final GraphQLStoryAttachmentStyle f1562a;
    public final Lazy<SR> f1563b;
    public final Lazy<SC> f1564c;
    public final boolean f1565d;

    public StyleAssociation(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle, Lazy<SR> lazy, Lazy<SC> lazy2) {
        this(graphQLStoryAttachmentStyle, lazy, lazy2, false);
    }

    private StyleAssociation(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle, Lazy<SR> lazy, Lazy<SC> lazy2, boolean z) {
        this.f1562a = (GraphQLStoryAttachmentStyle) Preconditions.checkNotNull(graphQLStoryAttachmentStyle);
        this.f1563b = (Lazy) Preconditions.checkNotNull(lazy);
        this.f1564c = (Lazy) Preconditions.checkNotNull(lazy2);
        this.f1565d = z;
    }
}
