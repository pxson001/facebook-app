package com.facebook.reaction.feed.unitcomponents.util;

import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionInfoRowDividerPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: You already set the metadata. Can't use deprecated API in combination with new one. */
public class ReactionUnitComponentDividerSelector<P> {
    public final ReactionDividerUnitComponentPartDefinition f20716a;
    private final ReactionInfoRowDividerPartDefinition f20717b;

    public static ReactionUnitComponentDividerSelector m24379b(InjectorLike injectorLike) {
        return new ReactionUnitComponentDividerSelector(ReactionDividerUnitComponentPartDefinition.m22997a(injectorLike), ReactionInfoRowDividerPartDefinition.m23763a(injectorLike));
    }

    @Inject
    public ReactionUnitComponentDividerSelector(ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, ReactionInfoRowDividerPartDefinition reactionInfoRowDividerPartDefinition) {
        this.f20716a = reactionDividerUnitComponentPartDefinition;
        this.f20717b = reactionInfoRowDividerPartDefinition;
    }

    @Nullable
    public final MultiRowPartWithIsNeeded<P, AnyEnvironment> m24380a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle, GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle2) {
        if (m24378a(graphQLReactionUnitComponentStyle) || m24378a(graphQLReactionUnitComponentStyle2)) {
            return null;
        }
        if (graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.INFO_ROW && graphQLReactionUnitComponentStyle2 == GraphQLReactionUnitComponentStyle.INFO_ROW) {
            return this.f20717b;
        }
        return this.f20716a;
    }

    private static boolean m24378a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        return graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.PAGE_MAP || graphQLReactionUnitComponentStyle == GraphQLReactionUnitComponentStyle.HORIZONTAL_ACTION_LIST;
    }
}
