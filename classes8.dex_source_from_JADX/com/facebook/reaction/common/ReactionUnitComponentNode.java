package com.facebook.reaction.common;

import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;

/* compiled from: block_index_in_article */
public class ReactionUnitComponentNode extends BaseFeedUnit {
    public final String f18861a;
    public final ReactionUnitComponentFields f18862b;
    public final String f18863c;
    public final String f18864d;

    public ReactionUnitComponentNode(ReactionUnitComponentFields reactionUnitComponentFields, String str, String str2, String str3) {
        this.f18861a = str3;
        this.f18862b = reactionUnitComponentFields;
        this.f18863c = str;
        this.f18864d = str2;
    }

    public final ReactionUnitComponentFields m22885f() {
        return this.f18862b;
    }

    public final String m22887k() {
        return this.f18863c;
    }

    public final String m22888l() {
        return this.f18864d;
    }

    public final String m22886g() {
        return Integer.toString(hashCode());
    }

    public final String m22889m() {
        return this.f18861a;
    }
}
