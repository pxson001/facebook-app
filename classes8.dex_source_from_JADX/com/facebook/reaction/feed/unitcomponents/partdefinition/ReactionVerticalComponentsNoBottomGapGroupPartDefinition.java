package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accountRecoverySendConfirmationCode */
public class ReactionVerticalComponentsNoBottomGapGroupPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static final ImmutableSet<String> f20124e = ImmutableSet.of(GraphQLReactionUnitComponentStyle.A_PLACE_FOR_HEADER_CARD.name(), GraphQLReactionUnitComponentStyle.NOTIFICATIONS_LIST.name(), GraphQLReactionUnitComponentStyle.PHOTO_H_SCROLL.name(), GraphQLReactionUnitComponentStyle.ACORN_HEADER.name(), GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENTS_LIST.name(), GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENT_LIST_INNER_CARD.name(), new String[]{GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENT_LIST_INNER_CARD_W_AUX_ACTION.name(), GraphQLReactionUnitComponentStyle.H_SCROLL_COMPONENTS_LIST.name(), GraphQLReactionUnitComponentStyle.H_SCROLL_COMPONENTS_LIST_WIDE_CARD.name()});
    private static ReactionVerticalComponentsNoBottomGapGroupPartDefinition f20125f;
    private static final Object f20126g = new Object();
    private final ReactionVerticalComponentsGapPartDefinition f20127a;
    private final ReactionVerticalComponentsWithoutHeaderGroupPartDefinition f20128b;
    private final ReactionUnitComponentStyleMapper f20129c;
    private final ReactionUnitValidator f20130d;

    private static ReactionVerticalComponentsNoBottomGapGroupPartDefinition m24017b(InjectorLike injectorLike) {
        return new ReactionVerticalComponentsNoBottomGapGroupPartDefinition(ReactionVerticalComponentsGapPartDefinition.m24007a(injectorLike), ReactionVerticalComponentsWithoutHeaderGroupPartDefinition.m24024a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike), ReactionUnitValidator.m22908b(injectorLike));
    }

    public final Object m24018a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        String d = reactionUnitFragment.d();
        String n = reactionUnitFragment.n();
        String j = reactionUnitFragment.j();
        ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitFragment.s().get(0);
        GraphQLReactionUnitComponentStyle a = reactionUnitComponentModel.a();
        MultiRowPartWithIsNeeded a2 = this.f20129c.m22892a(a);
        if (a2 != null) {
            ReactionUnitComponentNode reactionUnitComponentNode = new ReactionUnitComponentNode(reactionUnitComponentModel, d, n, j);
            int i = (a2.a(reactionUnitComponentNode) || this.f20128b.m24027a(reactionUnitFragment)) ? 1 : 0;
            if (m24016a(a) && i != 0) {
                baseMultiRowSubParts.a(this.f20127a, reactionUnitFragment);
            }
            baseMultiRowSubParts.a(a2, reactionUnitComponentNode);
        }
        baseMultiRowSubParts.a(this.f20128b, reactionUnitFragment);
        return null;
    }

    public final boolean m24019a(Object obj) {
        return "SUCCESS".equals(this.f20130d.m22916a((ReactionUnitFragment) obj));
    }

    @Inject
    public ReactionVerticalComponentsNoBottomGapGroupPartDefinition(ReactionVerticalComponentsGapPartDefinition reactionVerticalComponentsGapPartDefinition, ReactionVerticalComponentsWithoutHeaderGroupPartDefinition reactionVerticalComponentsWithoutHeaderGroupPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator) {
        this.f20127a = reactionVerticalComponentsGapPartDefinition;
        this.f20128b = reactionVerticalComponentsWithoutHeaderGroupPartDefinition;
        this.f20129c = reactionUnitComponentStyleMapper;
        this.f20130d = reactionUnitValidator;
    }

    public static ReactionVerticalComponentsNoBottomGapGroupPartDefinition m24015a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalComponentsNoBottomGapGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20126g) {
                ReactionVerticalComponentsNoBottomGapGroupPartDefinition reactionVerticalComponentsNoBottomGapGroupPartDefinition;
                if (a2 != null) {
                    reactionVerticalComponentsNoBottomGapGroupPartDefinition = (ReactionVerticalComponentsNoBottomGapGroupPartDefinition) a2.a(f20126g);
                } else {
                    reactionVerticalComponentsNoBottomGapGroupPartDefinition = f20125f;
                }
                if (reactionVerticalComponentsNoBottomGapGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24017b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20126g, b3);
                        } else {
                            f20125f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVerticalComponentsNoBottomGapGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m24016a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        return !f20124e.contains(graphQLReactionUnitComponentStyle.name());
    }
}
