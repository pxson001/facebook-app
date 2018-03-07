package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;

/* compiled from: attachment_add_photo */
public class ReactionSavePlaceKey implements ContextStateKey<String, ReactionSavePlacePersistentState> {
    private static final String f19178a = ReactionSavePlaceKey.class.getSimpleName();
    private final String f19179b;

    public ReactionSavePlaceKey(ReactionProfileFields reactionProfileFields) {
        this.f19179b = f19178a + reactionProfileFields.eL_();
    }

    public final Object m23194a() {
        return new ReactionSavePlacePersistentState();
    }

    public final Object m23195b() {
        return this.f19179b;
    }
}
