package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLSelectedActionState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPlaceKey;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitCrisisActionWithComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCrisisActionWithComponentFragmentModel.NegativeComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCrisisActionWithComponentFragmentModel.PositiveComponentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_confirmation_code */
public class ReactionVerticalActionWithComponentsPartDefinition<E extends HasContext & HasPersistentState & CanLaunchReactionIntent & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionVerticalActionWithComponentsPartDefinition f20112c;
    private static final Object f20113d = new Object();
    private final ReactionCrisisActionUnitComponentPartDefinition f20114a;
    private final ReactionUnitComponentStyleMapper f20115b;

    private static ReactionVerticalActionWithComponentsPartDefinition m24003b(InjectorLike injectorLike) {
        return new ReactionVerticalActionWithComponentsPartDefinition(ReactionCrisisActionUnitComponentPartDefinition.m23544a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    public final Object m24004a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionUnitCrisisActionWithComponentFragment a = ReactionCrisisActionUnitComponentPartDefinition.m23545a(reactionUnitComponentNode);
        PositiveComponentModel dm = a.dm();
        NegativeComponentModel dk = a.dk();
        Boolean asBooleanObject = ((ReactionActivatableActionPersistentState) ((HasPersistentState) hasContext).a(new ReactionActivatableActionPlaceKey(reactionUnitComponentNode.f18862b.U()), reactionUnitComponentNode)).f19155a.asBooleanObject();
        GraphQLSelectedActionState dn = a.dn();
        if (asBooleanObject != null) {
            if (asBooleanObject.booleanValue()) {
                dn = GraphQLSelectedActionState.POSITIVE;
            } else {
                dn = GraphQLSelectedActionState.NEGATIVE;
            }
        }
        if (dn == null || dn.equals(GraphQLSelectedActionState.UNSELECTED)) {
            baseMultiRowSubParts.a(this.f20114a, reactionUnitComponentNode);
        } else if (dn.equals(GraphQLSelectedActionState.POSITIVE)) {
            baseMultiRowSubParts.a(this.f20115b.m22892a(dm.a()), new ReactionUnitComponentNode(dm, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a));
        } else {
            baseMultiRowSubParts.a(this.f20115b.m22892a(dk.a()), new ReactionUnitComponentNode(dk, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a));
        }
        return null;
    }

    public final boolean m24005a(Object obj) {
        ReactionUnitCrisisActionWithComponentFragment a = ReactionCrisisActionUnitComponentPartDefinition.m23545a((ReactionUnitComponentNode) obj);
        return ((a.dl() == null || a.cF() == null) && a.dm() == null && a.dk() == null) ? false : true;
    }

    @Inject
    public ReactionVerticalActionWithComponentsPartDefinition(ReactionCrisisActionUnitComponentPartDefinition reactionCrisisActionUnitComponentPartDefinition, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f20114a = reactionCrisisActionUnitComponentPartDefinition;
        this.f20115b = reactionUnitComponentStyleMapper;
    }

    public static ReactionVerticalActionWithComponentsPartDefinition m24002a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalActionWithComponentsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20113d) {
                ReactionVerticalActionWithComponentsPartDefinition reactionVerticalActionWithComponentsPartDefinition;
                if (a2 != null) {
                    reactionVerticalActionWithComponentsPartDefinition = (ReactionVerticalActionWithComponentsPartDefinition) a2.a(f20113d);
                } else {
                    reactionVerticalActionWithComponentsPartDefinition = f20112c;
                }
                if (reactionVerticalActionWithComponentsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24003b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20113d, b3);
                        } else {
                            f20112c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVerticalActionWithComponentsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
