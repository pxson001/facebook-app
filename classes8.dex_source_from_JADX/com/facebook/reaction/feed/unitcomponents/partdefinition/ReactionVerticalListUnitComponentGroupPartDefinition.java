package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
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
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.util.ReactionUnitComponentDividerSelector;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFields;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accountRecoverySearch */
public class ReactionVerticalListUnitComponentGroupPartDefinition<E extends HasContext & HasPositionInformation & CanLaunchReactionIntent & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionVerticalListUnitComponentGroupPartDefinition f20140d;
    private static final Object f20141e = new Object();
    private final ReactionUnitComponentDividerSelector f20142a;
    private final ReactionUnitComponentStyleMapper f20143b;
    private final ReactionUnitValidator f20144c;

    private static ReactionVerticalListUnitComponentGroupPartDefinition m24030b(InjectorLike injectorLike) {
        return new ReactionVerticalListUnitComponentGroupPartDefinition(ReactionUnitComponentDividerSelector.m24379b(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike), ReactionUnitValidator.m22908b(injectorLike));
    }

    public final Object m24031a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitStaticAggregationComponentFields reactionUnitStaticAggregationComponentFields = (ReactionUnitStaticAggregationComponentFields) reactionUnitComponentNode.f18862b;
        ImmutableList b = ReactionUnitComponentUtil.m22902b(reactionUnitComponentNode);
        if (reactionUnitStaticAggregationComponentFields.aG()) {
            baseMultiRowSubParts.a(this.f20142a.f20716a, reactionUnitComponentNode);
        }
        int i = 0;
        while (i < b.size()) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) b.get(i);
            if (reactionUnitStaticAggregationComponentFields.aF() && i > 0) {
                MultiRowPartWithIsNeeded a = this.f20142a.m24380a(((ReactionUnitComponentFields) b.get(i - 1)).a(), reactionUnitComponentFields.a());
                if (a != null) {
                    baseMultiRowSubParts.a(a, reactionUnitComponentNode);
                }
            }
            baseMultiRowSubParts.a(this.f20143b.m22892a(reactionUnitComponentFields.a()), new ReactionUnitComponentNode(reactionUnitComponentFields, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a));
            i++;
        }
        if (reactionUnitStaticAggregationComponentFields.aD()) {
            baseMultiRowSubParts.a(this.f20142a.f20716a, reactionUnitComponentNode);
        }
        return null;
    }

    public final boolean m24032a(Object obj) {
        return "SUCCESS".equals(this.f20144c.m22915a((ReactionUnitComponentNode) obj));
    }

    @Inject
    public ReactionVerticalListUnitComponentGroupPartDefinition(ReactionUnitComponentDividerSelector reactionUnitComponentDividerSelector, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator) {
        this.f20142a = reactionUnitComponentDividerSelector;
        this.f20143b = reactionUnitComponentStyleMapper;
        this.f20144c = reactionUnitValidator;
    }

    public static ReactionVerticalListUnitComponentGroupPartDefinition m24029a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalListUnitComponentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20141e) {
                ReactionVerticalListUnitComponentGroupPartDefinition reactionVerticalListUnitComponentGroupPartDefinition;
                if (a2 != null) {
                    reactionVerticalListUnitComponentGroupPartDefinition = (ReactionVerticalListUnitComponentGroupPartDefinition) a2.a(f20141e);
                } else {
                    reactionVerticalListUnitComponentGroupPartDefinition = f20140d;
                }
                if (reactionVerticalListUnitComponentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24030b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20141e, b3);
                        } else {
                            f20140d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVerticalListUnitComponentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
