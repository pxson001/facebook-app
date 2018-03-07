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
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionSectionHeaderComponent.State;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_background_contactpoint_confirmed */
public class ReactionSectionHeaderPartDefinition<E extends HasReactionSession & CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionSectionHeaderPartDefinition f20056e;
    private static final Object f20057f = new Object();
    private ReactionSectionHeaderComponent f20058c;
    private final ReactionExperimentController f20059d;

    private static ReactionSectionHeaderPartDefinition m23941b(InjectorLike injectorLike) {
        return new ReactionSectionHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionExperimentController.a(injectorLike), ReactionSectionHeaderComponent.m24200a(injectorLike));
    }

    public final /* synthetic */ boolean m23945a(HasContext hasContext) {
        return m23942c();
    }

    public final /* synthetic */ boolean m23946a(AnyEnvironment anyEnvironment) {
        return m23942c();
    }

    public final boolean m23947a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode.f18862b.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentNode.f18862b.bv().a())) ? false : true;
    }

    @Inject
    public ReactionSectionHeaderPartDefinition(Context context, ReactionExperimentController reactionExperimentController, ReactionSectionHeaderComponent reactionSectionHeaderComponent) {
        super(context);
        this.f20058c = reactionSectionHeaderComponent;
        this.f20059d = reactionExperimentController;
    }

    private Component<ReactionSectionHeaderComponent> m23939a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode) {
        State state = new State(this.f20058c);
        Builder builder = (Builder) ReactionSectionHeaderComponent.f20404b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m24197a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f20398a.f20402a = reactionUnitComponentNode.f18862b.bv().a();
        builder2.f20401d.set(0);
        return builder2.d();
    }

    public static ReactionSectionHeaderPartDefinition m23940a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20057f) {
                ReactionSectionHeaderPartDefinition reactionSectionHeaderPartDefinition;
                if (a2 != null) {
                    reactionSectionHeaderPartDefinition = (ReactionSectionHeaderPartDefinition) a2.a(f20057f);
                } else {
                    reactionSectionHeaderPartDefinition = f20056e;
                }
                if (reactionSectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23941b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20057f, b3);
                        } else {
                            f20056e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23948b(Object obj) {
        return null;
    }

    private boolean m23942c() {
        return this.f20059d.d();
    }
}
