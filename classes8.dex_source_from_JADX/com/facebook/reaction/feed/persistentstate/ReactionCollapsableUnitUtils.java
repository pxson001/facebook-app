package com.facebook.reaction.feed.persistentstate;

import com.facebook.feed.environment.HasPersistentState;
import com.facebook.reaction.common.ReactionUnitComponentNode;

/* compiled from: attributes */
public class ReactionCollapsableUnitUtils {
    public static boolean m23183a(ReactionUnitComponentNode reactionUnitComponentNode, HasPersistentState hasPersistentState) {
        ReactionCollapsableUnitPersistentState reactionCollapsableUnitPersistentState = (ReactionCollapsableUnitPersistentState) hasPersistentState.a(new ReactionCollapsableUnitKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode);
        return reactionCollapsableUnitPersistentState.f19161b && reactionCollapsableUnitPersistentState.f19160a;
    }
}
