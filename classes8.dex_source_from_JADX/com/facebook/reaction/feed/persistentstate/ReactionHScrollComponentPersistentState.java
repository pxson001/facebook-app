package com.facebook.reaction.feed.persistentstate;

import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import java.util.HashSet;
import javax.annotation.Nullable;

/* compiled from: attachment_style */
public class ReactionHScrollComponentPersistentState {
    @Nullable
    public ReactionStoryAttachmentActionFragmentModel f19171a;
    public int f19172b = 0;
    public int f19173c = 0;
    private HashSet<String> f19174d = new HashSet();
    public int f19175e;
    public int f19176f = 0;
    public boolean f19177g = false;

    public final void m23190a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : str.split(":")) {
            stringBuilder.append(append);
            this.f19174d.add(stringBuilder.toString());
            stringBuilder.append(":");
        }
    }

    public final boolean m23191b(String str) {
        return this.f19174d.contains(str);
    }
}
