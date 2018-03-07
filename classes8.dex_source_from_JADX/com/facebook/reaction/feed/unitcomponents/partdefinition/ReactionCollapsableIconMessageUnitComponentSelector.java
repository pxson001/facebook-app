package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitUtils;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: already_invited_users */
public class ReactionCollapsableIconMessageUnitComponentSelector<E extends HasInvalidate & HasPersistentState & HasContext & CanLaunchReactionIntent & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionCollapsableIconMessageUnitComponentSelector f19578d;
    private static final Object f19579e = new Object();
    private final ReactionCollapsableIconMessageUnitComponentPartDefinition<E> f19580a;
    private final ReactionCollapsedIconMessageUnitComponentPartDefinition<E> f19581b;
    private final C2119x3f1b3967<E> f19582c;

    private static ReactionCollapsableIconMessageUnitComponentSelector m23515b(InjectorLike injectorLike) {
        return new ReactionCollapsableIconMessageUnitComponentSelector(ReactionCollapsableIconMessageUnitComponentPartDefinition.m23508a(injectorLike), ReactionCollapsedIconMessageUnitComponentPartDefinition.m23530a(injectorLike), C2119x3f1b3967.m23518a(injectorLike));
    }

    public static boolean m23514a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        return (reactionUnitComponentFields.bv() == null || TextUtils.isEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public final Object m23516a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        boolean a = ReactionCollapsableUnitUtils.m23183a(reactionUnitComponentNode, (HasPersistentState) ((HasInvalidate) anyEnvironment));
        if (reactionUnitComponentNode.f18862b.a().equals(GraphQLReactionUnitComponentStyle.ICON_MESSAGE_WITH_CARET)) {
            baseMultiRowSubParts.a(this.f19582c, reactionUnitComponentNode);
        } else {
            baseMultiRowSubParts.a(a ? this.f19581b : this.f19580a, reactionUnitComponentNode);
        }
        return null;
    }

    @Inject
    public ReactionCollapsableIconMessageUnitComponentSelector(ReactionCollapsableIconMessageUnitComponentPartDefinition reactionCollapsableIconMessageUnitComponentPartDefinition, ReactionCollapsedIconMessageUnitComponentPartDefinition reactionCollapsedIconMessageUnitComponentPartDefinition, C2119x3f1b3967 c2119x3f1b3967) {
        this.f19580a = reactionCollapsableIconMessageUnitComponentPartDefinition;
        this.f19581b = reactionCollapsedIconMessageUnitComponentPartDefinition;
        this.f19582c = c2119x3f1b3967;
    }

    public static ReactionCollapsableIconMessageUnitComponentSelector m23513a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCollapsableIconMessageUnitComponentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19579e) {
                ReactionCollapsableIconMessageUnitComponentSelector reactionCollapsableIconMessageUnitComponentSelector;
                if (a2 != null) {
                    reactionCollapsableIconMessageUnitComponentSelector = (ReactionCollapsableIconMessageUnitComponentSelector) a2.a(f19579e);
                } else {
                    reactionCollapsableIconMessageUnitComponentSelector = f19578d;
                }
                if (reactionCollapsableIconMessageUnitComponentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23515b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19579e, b3);
                        } else {
                            f19578d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCollapsableIconMessageUnitComponentSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
