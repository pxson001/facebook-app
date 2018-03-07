package com.facebook.reaction.feed.unitcomponents.map;

import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: qp/ */
public class EmptyReactionUnitComponentStyleMap implements ReactionUnitComponentStyleMap {
    public static EmptyReactionUnitComponentStyleMap m4772a(InjectorLike injectorLike) {
        return new EmptyReactionUnitComponentStyleMap();
    }

    @Nullable
    public final MultiRowPartWithIsNeeded mo240a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        return null;
    }

    public final ImmutableList<String> mo241a() {
        return RegularImmutableList.a;
    }
}
