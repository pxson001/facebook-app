package com.facebook.reaction.common;

import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;

/* compiled from: boolean_filter_root */
public class ReactionAttachmentNode extends BaseFeedUnit {
    public final ReactionStoryAttachmentFragmentModel f18832a;
    public final String f18833b;
    public final String f18834c;

    public ReactionAttachmentNode(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, String str, String str2) {
        this.f18832a = reactionStoryAttachmentFragmentModel;
        this.f18833b = str;
        this.f18834c = str2;
    }

    public final String m22860g() {
        return Integer.toString(hashCode());
    }
}
