package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceWithMetadataComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceWithMetadataComponent.State;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: adChoicesIconHeight */
public class ReactionPlaceWithMetadataUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionPlaceWithMetadataUnitComponentPartDefinition f19987e;
    private static final Object f19988f = new Object();
    private final ReactionActionDelegateComponent f19989c;
    private final ReactionPlaceWithMetadataComponent f19990d;

    private static ReactionPlaceWithMetadataUnitComponentPartDefinition m23878b(InjectorLike injectorLike) {
        return new ReactionPlaceWithMetadataUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionActionDelegateComponent.m24063a(injectorLike), ReactionPlaceWithMetadataComponent.m24191a(injectorLike));
    }

    public final boolean m23881a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.bU() == null || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.bU().eD_()) || reactionUnitComponentNode.f18862b.bv() == null || reactionUnitComponentNode.f18862b.bv().a() == null) ? false : true;
    }

    @Inject
    public ReactionPlaceWithMetadataUnitComponentPartDefinition(Context context, ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionPlaceWithMetadataComponent reactionPlaceWithMetadataComponent) {
        super(context);
        this.f19989c = reactionActionDelegateComponent;
        this.f19990d = reactionPlaceWithMetadataComponent;
    }

    private Component<?> m23876a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Builder a = this.f19989c.m24066a(componentContext).m24058a(reactionUnitComponentNode.f18862b.v());
        State state = new State(this.f19990d);
        ReactionPlaceWithMetadataComponent.Builder builder = (ReactionPlaceWithMetadataComponent.Builder) ReactionPlaceWithMetadataComponent.f20390b.a();
        if (builder == null) {
            builder = new ReactionPlaceWithMetadataComponent.Builder();
        }
        ReactionPlaceWithMetadataComponent.Builder.m24188a(builder, componentContext, 0, state);
        ReactionPlaceWithMetadataComponent.Builder builder2 = builder;
        builder2.f20382a.f20386a = reactionUnitComponentNode.f18862b.bv().a();
        builder2.f20385d.set(0);
        builder2 = builder2;
        builder2.f20382a.f20387b = reactionUnitComponentNode.f18862b.bU();
        builder2.f20385d.set(1);
        return a.m24055a((Component.Builder) builder2).m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
    }

    public static ReactionPlaceWithMetadataUnitComponentPartDefinition m23877a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPlaceWithMetadataUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19988f) {
                ReactionPlaceWithMetadataUnitComponentPartDefinition reactionPlaceWithMetadataUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPlaceWithMetadataUnitComponentPartDefinition = (ReactionPlaceWithMetadataUnitComponentPartDefinition) a2.a(f19988f);
                } else {
                    reactionPlaceWithMetadataUnitComponentPartDefinition = f19987e;
                }
                if (reactionPlaceWithMetadataUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23878b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19988f, b3);
                        } else {
                            f19987e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPlaceWithMetadataUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23882b(Object obj) {
        return null;
    }
}
