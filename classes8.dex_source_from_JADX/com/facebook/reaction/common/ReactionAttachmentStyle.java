package com.facebook.reaction.common;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: bolded_title */
public abstract class ReactionAttachmentStyle {
    private final GraphQLReactionStoryAttachmentsStyle f18835a;

    public abstract ReactionAttachmentHandler mo1147c();

    public ReactionAttachmentStyle(@Nonnull GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        this.f18835a = graphQLReactionStoryAttachmentsStyle;
    }

    @Nullable
    public MultiRowPartWithIsNeeded<ReactionAttachmentNode, ? extends AnyEnvironment> mo1148a() {
        return null;
    }
}
