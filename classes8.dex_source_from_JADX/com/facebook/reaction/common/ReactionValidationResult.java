package com.facebook.reaction.common;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.google.common.collect.ImmutableList;

/* compiled from: birthday_view_start_date */
public class ReactionValidationResult {
    public final ReactionAttachmentHandler f18874a;
    private final GraphQLReactionStoryAttachmentsStyle f18875b;
    public final ImmutableList<ReactionValidationResult> f18876c;
    public final String f18877d;

    public ReactionValidationResult(String str) {
        this(str, null, null, null);
    }

    public ReactionValidationResult(String str, ImmutableList<ReactionValidationResult> immutableList) {
        this(str, null, null, immutableList);
    }

    public ReactionValidationResult(String str, ReactionAttachmentHandler reactionAttachmentHandler, GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        this(str, reactionAttachmentHandler, graphQLReactionStoryAttachmentsStyle, null);
    }

    private ReactionValidationResult(String str, ReactionAttachmentHandler reactionAttachmentHandler, GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle, ImmutableList<ReactionValidationResult> immutableList) {
        this.f18877d = str;
        this.f18874a = reactionAttachmentHandler;
        this.f18875b = graphQLReactionStoryAttachmentsStyle;
        this.f18876c = immutableList;
    }
}
