package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent;
import com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.header.ReactionPlainHeaderComponent.State;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: airplane_niem */
public class ReactionHeaderUnitComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionHeaderUnitComponentPartDefinition f19765e;
    private static final Object f19766f = new Object();
    private final ReactionPlainHeaderComponent f19767c;
    private final ReactionExperimentController f19768d;

    private static ReactionHeaderUnitComponentPartDefinition m23673b(InjectorLike injectorLike) {
        return new ReactionHeaderUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionExperimentController.a(injectorLike), ReactionPlainHeaderComponent.m24255a(injectorLike));
    }

    public final boolean m23678a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.a() != GraphQLReactionUnitComponentStyle.HEADER || reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    private Component<ReactionPlainHeaderComponent> m23671a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        State state = new State(this.f19767c);
        Builder builder = (Builder) ReactionPlainHeaderComponent.f20491b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m24252a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f20485a.f20489a = reactionUnitComponentFields.bv().a();
        builder2.f20488d.set(0);
        return builder2.d();
    }

    @Inject
    public ReactionHeaderUnitComponentPartDefinition(Context context, ReactionExperimentController reactionExperimentController, ReactionPlainHeaderComponent reactionPlainHeaderComponent) {
        super(context);
        this.f19767c = reactionPlainHeaderComponent;
        this.f19768d = reactionExperimentController;
    }

    public final CacheableEntity m23679b(Object obj) {
        return null;
    }

    public static ReactionHeaderUnitComponentPartDefinition m23672a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHeaderUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19766f) {
                ReactionHeaderUnitComponentPartDefinition reactionHeaderUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionHeaderUnitComponentPartDefinition = (ReactionHeaderUnitComponentPartDefinition) a2.a(f19766f);
                } else {
                    reactionHeaderUnitComponentPartDefinition = f19765e;
                }
                if (reactionHeaderUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23673b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19766f, b3);
                        } else {
                            f19765e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHeaderUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23676a(HasContext hasContext) {
        return this.f19768d.d();
    }
}
