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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionMessageAndBreadcrumbsComponent.State;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_more_cards_tap */
public class ReactionMessageAndBreadcrumbsUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionMessageAndBreadcrumbsUnitComponentPartDefinition f19885e;
    private static final Object f19886f = new Object();
    private final ReactionMessageAndBreadcrumbsComponent f19887c;
    private final ReactionExperimentController f19888d;

    private static ReactionMessageAndBreadcrumbsUnitComponentPartDefinition m23791b(InjectorLike injectorLike) {
        return new ReactionMessageAndBreadcrumbsUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionExperimentController.a(injectorLike), ReactionMessageAndBreadcrumbsComponent.m24138a(injectorLike));
    }

    private Component<?> m23789a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionMessageAndBreadcrumbsComponent reactionMessageAndBreadcrumbsComponent = this.f19887c;
        State state = new State(reactionMessageAndBreadcrumbsComponent);
        Builder builder = (Builder) reactionMessageAndBreadcrumbsComponent.f20299c.a();
        if (builder == null) {
            builder = new Builder(reactionMessageAndBreadcrumbsComponent);
        }
        Builder.m24135a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f20286a.f20292b = reactionUnitComponentFields.O();
        builder2.f20290e.set(1);
        builder2 = builder2;
        builder2.f20286a.f20293c = e;
        builder2 = builder2;
        builder2.f20286a.f20291a = reactionUnitComponentFields.bv().a();
        builder2.f20290e.set(0);
        Builder builder3 = builder2;
        builder3.f20286a.f20294d = reactionUnitComponentNode.f18863c;
        builder3 = builder3;
        builder3.f20286a.f20295e = reactionUnitComponentNode.f18864d;
        return builder3.d();
    }

    public final /* synthetic */ boolean m23795a(HasContext hasContext) {
        return m23792c();
    }

    public final /* synthetic */ boolean m23796a(AnyEnvironment anyEnvironment) {
        return m23792c();
    }

    public final boolean m23797a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.bv().a())) ? false : true;
    }

    @Inject
    public ReactionMessageAndBreadcrumbsUnitComponentPartDefinition(Context context, ReactionExperimentController reactionExperimentController, ReactionMessageAndBreadcrumbsComponent reactionMessageAndBreadcrumbsComponent) {
        super(context);
        this.f19887c = reactionMessageAndBreadcrumbsComponent;
        this.f19888d = reactionExperimentController;
    }

    public static ReactionMessageAndBreadcrumbsUnitComponentPartDefinition m23790a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionMessageAndBreadcrumbsUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19886f) {
                ReactionMessageAndBreadcrumbsUnitComponentPartDefinition reactionMessageAndBreadcrumbsUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionMessageAndBreadcrumbsUnitComponentPartDefinition = (ReactionMessageAndBreadcrumbsUnitComponentPartDefinition) a2.a(f19886f);
                } else {
                    reactionMessageAndBreadcrumbsUnitComponentPartDefinition = f19885e;
                }
                if (reactionMessageAndBreadcrumbsUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23791b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19886f, b3);
                        } else {
                            f19885e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionMessageAndBreadcrumbsUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23798b(Object obj) {
        return null;
    }

    private boolean m23792c() {
        return this.f19888d.d();
    }
}
