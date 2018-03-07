package com.facebook.reaction.attachment;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: border_config */
public class EmptyReactionAttachmentStyleMap implements ReactionAttachmentStyleMap {
    public static EmptyReactionAttachmentStyleMap m22837a(InjectorLike injectorLike) {
        return new EmptyReactionAttachmentStyleMap();
    }

    @Nullable
    public final ReactionAttachmentStyle mo1114a(GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        return null;
    }

    public final ImmutableList<String> mo1115a() {
        return RegularImmutableList.a;
    }
}
