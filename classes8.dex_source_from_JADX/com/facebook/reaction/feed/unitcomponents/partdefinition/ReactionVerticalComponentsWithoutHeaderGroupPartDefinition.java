package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.reaction.feed.unitcomponents.util.ReactionUnitComponentDividerSelector;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accountRecoverySearchAccountParamsKey */
public class ReactionVerticalComponentsWithoutHeaderGroupPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, E> {
    private static ReactionVerticalComponentsWithoutHeaderGroupPartDefinition f20135d;
    private static final Object f20136e = new Object();
    private final ReactionUnitComponentDividerSelector f20137a;
    private final ReactionUnitValidator f20138b;
    private final ReactionUnitComponentStyleMapper f20139c;

    private static ReactionVerticalComponentsWithoutHeaderGroupPartDefinition m24025b(InjectorLike injectorLike) {
        return new ReactionVerticalComponentsWithoutHeaderGroupPartDefinition(ReactionUnitComponentDividerSelector.m24379b(injectorLike), ReactionUnitValidator.m22908b(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    public final Object m24026a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        int size = reactionUnitFragment.s().size();
        String d = reactionUnitFragment.d();
        String n = reactionUnitFragment.n();
        String j = reactionUnitFragment.j();
        for (int i = 1; i < size; i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitFragment.s().get(i);
            GraphQLReactionUnitComponentStyle a = reactionUnitComponentModel.a();
            MultiRowPartWithIsNeeded a2 = this.f20139c.m22892a(a);
            ReactionUnitComponentNode reactionUnitComponentNode = new ReactionUnitComponentNode(reactionUnitComponentModel, d, n, j);
            if (a2 != null) {
                if (reactionUnitFragment.q()) {
                    MultiRowPartWithIsNeeded a3 = this.f20137a.m24380a(((ReactionUnitComponentModel) reactionUnitFragment.s().get(i - 1)).a(), a);
                    if (a3 != null) {
                        baseMultiRowSubParts.a(a3, reactionUnitComponentNode);
                    }
                }
                baseMultiRowSubParts.a(a2, reactionUnitComponentNode);
            }
        }
        return null;
    }

    @Inject
    public ReactionVerticalComponentsWithoutHeaderGroupPartDefinition(ReactionUnitComponentDividerSelector reactionUnitComponentDividerSelector, ReactionUnitValidator reactionUnitValidator, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f20137a = reactionUnitComponentDividerSelector;
        this.f20138b = reactionUnitValidator;
        this.f20139c = reactionUnitComponentStyleMapper;
    }

    public static ReactionVerticalComponentsWithoutHeaderGroupPartDefinition m24024a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalComponentsWithoutHeaderGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20136e) {
                ReactionVerticalComponentsWithoutHeaderGroupPartDefinition reactionVerticalComponentsWithoutHeaderGroupPartDefinition;
                if (a2 != null) {
                    reactionVerticalComponentsWithoutHeaderGroupPartDefinition = (ReactionVerticalComponentsWithoutHeaderGroupPartDefinition) a2.a(f20136e);
                } else {
                    reactionVerticalComponentsWithoutHeaderGroupPartDefinition = f20135d;
                }
                if (reactionVerticalComponentsWithoutHeaderGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24025b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20136e, b3);
                        } else {
                            f20135d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVerticalComponentsWithoutHeaderGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m24027a(ReactionUnitFragment reactionUnitFragment) {
        return "SUCCESS".equals(this.f20138b.m22916a((Object) reactionUnitFragment)) && reactionUnitFragment.s().size() > 1;
    }
}
