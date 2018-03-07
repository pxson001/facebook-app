package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;

/* compiled from: attachments_visible */
public class ReactionDelayedActionKey implements ContextStateKey<String, ReactionDelayedActionPersistentState> {
    private static final String f19162a = ReactionSavePlaceKey.class.getSimpleName();
    private final String f19163b;

    public ReactionDelayedActionKey(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel) {
        this.f19163b = f19162a + reactionStoryAttachmentActionFragmentModel.hashCode();
    }

    public final Object m23184a() {
        return new ReactionDelayedActionPersistentState();
    }

    public final Object m23185b() {
        return this.f19163b;
    }
}
