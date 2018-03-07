package com.facebook.reaction.feed.corecomponents.partdefinition;

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
import com.facebook.reaction.feed.corecomponents.ReactionCoreComponentsBuilder;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bellerophon_empty_result */
public class ReactionCoreButtonComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionAnalyticsParams & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionCoreButtonComponentPartDefinition f18985e;
    private static final Object f18986f = new Object();
    private final ReactionCoreComponentsBuilder f18987c;
    private final ReactionExperimentController f18988d;

    private static ReactionCoreButtonComponentPartDefinition m23014b(InjectorLike injectorLike) {
        return new ReactionCoreButtonComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionCoreComponentsBuilder.m23007a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    public final /* synthetic */ boolean m23018a(HasContext hasContext) {
        return m23015c();
    }

    public final /* synthetic */ boolean m23019a(AnyEnvironment anyEnvironment) {
        return m23015c();
    }

    public final boolean m23020a(Object obj) {
        return ReactionCoreComponentsBuilder.m23008a(((ReactionUnitComponentNode) obj).f18862b);
    }

    @Inject
    public ReactionCoreButtonComponentPartDefinition(Context context, ReactionCoreComponentsBuilder reactionCoreComponentsBuilder, ReactionExperimentController reactionExperimentController) {
        super(context);
        this.f18987c = reactionCoreComponentsBuilder;
        this.f18988d = reactionExperimentController;
    }

    private Component<?> m23012a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        return this.f18987c.m23011a(componentContext, reactionUnitComponentNode, e);
    }

    public final CacheableEntity m23021b(Object obj) {
        return null;
    }

    public static ReactionCoreButtonComponentPartDefinition m23013a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCoreButtonComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18986f) {
                ReactionCoreButtonComponentPartDefinition reactionCoreButtonComponentPartDefinition;
                if (a2 != null) {
                    reactionCoreButtonComponentPartDefinition = (ReactionCoreButtonComponentPartDefinition) a2.a(f18986f);
                } else {
                    reactionCoreButtonComponentPartDefinition = f18985e;
                }
                if (reactionCoreButtonComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23014b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18986f, b3);
                        } else {
                            f18985e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCoreButtonComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private boolean m23015c() {
        return this.f18988d.d();
    }
}
