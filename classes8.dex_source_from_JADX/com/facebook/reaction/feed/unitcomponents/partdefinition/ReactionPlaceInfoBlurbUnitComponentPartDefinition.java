package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentPersistentState;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbUnitComponent.State;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: adID */
public class ReactionPlaceInfoBlurbUnitComponentPartDefinition<E extends HasContext & HasInvalidate & HasIsAsync & HasPersistentState & HasReactionInteractionTracker> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionPlaceInfoBlurbUnitComponentPartDefinition f19979f;
    private static final Object f19980g = new Object();
    private final ReactionExpandableActionDelegateComponent f19981c;
    private final ReactionPlaceInfoBlurbUnitComponent f19982d;
    private final ReactionExperimentController f19983e;

    private static ReactionPlaceInfoBlurbUnitComponentPartDefinition m23862b(InjectorLike injectorLike) {
        return new ReactionPlaceInfoBlurbUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionExperimentController.a(injectorLike), ReactionExpandableActionDelegateComponent.m24107a(injectorLike), ReactionPlaceInfoBlurbUnitComponent.m24159a(injectorLike));
    }

    public final boolean m23867a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.bS() == null || reactionUnitComponentNode.f18862b.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.bv().a())) ? false : true;
    }

    @Inject
    public ReactionPlaceInfoBlurbUnitComponentPartDefinition(Context context, ReactionExperimentController reactionExperimentController, ReactionExpandableActionDelegateComponent reactionExpandableActionDelegateComponent, ReactionPlaceInfoBlurbUnitComponent reactionPlaceInfoBlurbUnitComponent) {
        super(context);
        this.f19981c = reactionExpandableActionDelegateComponent;
        this.f19982d = reactionPlaceInfoBlurbUnitComponent;
        this.f19983e = reactionExperimentController;
    }

    private Component<?> m23860a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        boolean z;
        ReactionExpandableComponentPersistentState reactionExpandableComponentPersistentState = (ReactionExpandableComponentPersistentState) ((HasPersistentState) e).a(new ReactionExpandableComponentKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode);
        Builder a = this.f19981c.m24110a(componentContext);
        State state = new State(this.f19982d);
        ReactionPlaceInfoBlurbUnitComponent.Builder builder = (ReactionPlaceInfoBlurbUnitComponent.Builder) ReactionPlaceInfoBlurbUnitComponent.f20329b.a();
        if (builder == null) {
            builder = new ReactionPlaceInfoBlurbUnitComponent.Builder();
        }
        ReactionPlaceInfoBlurbUnitComponent.Builder.m24156a(builder, componentContext, 0, state);
        ReactionPlaceInfoBlurbUnitComponent.Builder builder2 = builder;
        builder2.f20319a.f20325c = reactionUnitComponentNode.f18862b.as();
        builder2 = builder2;
        builder2.f20319a.f20323a = reactionUnitComponentNode.f18862b.bv().a();
        builder2.f20322d.set(0);
        builder2 = builder2;
        builder2.f20319a.f20324b = reactionUnitComponentNode.f18862b.bS();
        builder2.f20322d.set(1);
        builder2 = builder2;
        builder2.f20319a.f20326d = reactionUnitComponentNode.f18862b.cW();
        ReactionPlaceInfoBlurbUnitComponent.Builder builder3 = builder2;
        if (reactionExpandableComponentPersistentState.f19167a) {
            z = false;
        } else {
            z = true;
        }
        builder3.f20319a.f20327e = z;
        return a.m24099a(builder3.d()).m24103a(reactionUnitComponentNode.f18863c).m24105b(reactionUnitComponentNode.f18864d).m24101a(((HasReactionInteractionTracker) e).kE_()).m24100a((HasInvalidate) e).m24102a(reactionExpandableComponentPersistentState).d();
    }

    public static ReactionPlaceInfoBlurbUnitComponentPartDefinition m23861a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPlaceInfoBlurbUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19980g) {
                ReactionPlaceInfoBlurbUnitComponentPartDefinition reactionPlaceInfoBlurbUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPlaceInfoBlurbUnitComponentPartDefinition = (ReactionPlaceInfoBlurbUnitComponentPartDefinition) a2.a(f19980g);
                } else {
                    reactionPlaceInfoBlurbUnitComponentPartDefinition = f19979f;
                }
                if (reactionPlaceInfoBlurbUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23862b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19980g, b3);
                        } else {
                            f19979f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPlaceInfoBlurbUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23868b(Object obj) {
        return null;
    }

    public final boolean m23865a(HasContext hasContext) {
        return this.f19983e.d();
    }
}
