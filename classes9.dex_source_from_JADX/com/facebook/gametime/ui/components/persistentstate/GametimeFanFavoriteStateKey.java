package com.facebook.gametime.ui.components.persistentstate;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.reaction.common.ReactionUnitComponentNode;

/* compiled from: Stream Id is empty */
public class GametimeFanFavoriteStateKey implements ContextStateKey<String, GametimeFanFavoriteState> {
    private static final String f25291a = GametimeFanFavoriteStateKey.class.getName();
    private final String f25292b;

    public GametimeFanFavoriteStateKey(ReactionUnitComponentNode reactionUnitComponentNode) {
        this.f25292b = reactionUnitComponentNode.c + f25291a;
    }

    public final Object m27214a() {
        return new GametimeFanFavoriteState();
    }

    public final Object m27215b() {
        return this.f25292b;
    }
}
