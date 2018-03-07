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
/* compiled from: bellerophon */
public class ReactionCoreImageComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionAnalyticsParams & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionCoreImageComponentPartDefinition f18994e;
    private static final Object f18995f = new Object();
    private final ReactionCoreComponentsBuilder f18996c;
    private final ReactionExperimentController f18997d;

    private static ReactionCoreImageComponentPartDefinition m23031b(InjectorLike injectorLike) {
        return new ReactionCoreImageComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionCoreComponentsBuilder.m23007a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    public final /* synthetic */ boolean m23035a(HasContext hasContext) {
        return m23032c();
    }

    public final /* synthetic */ boolean m23036a(AnyEnvironment anyEnvironment) {
        return m23032c();
    }

    public final boolean m23037a(Object obj) {
        return ReactionCoreComponentsBuilder.m23008a(((ReactionUnitComponentNode) obj).f18862b);
    }

    @Inject
    public ReactionCoreImageComponentPartDefinition(Context context, ReactionCoreComponentsBuilder reactionCoreComponentsBuilder, ReactionExperimentController reactionExperimentController) {
        super(context);
        this.f18996c = reactionCoreComponentsBuilder;
        this.f18997d = reactionExperimentController;
    }

    private Component<?> m23029a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        return this.f18996c.m23011a(componentContext, reactionUnitComponentNode, e);
    }

    public final CacheableEntity m23038b(Object obj) {
        return null;
    }

    public static ReactionCoreImageComponentPartDefinition m23030a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCoreImageComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18995f) {
                ReactionCoreImageComponentPartDefinition reactionCoreImageComponentPartDefinition;
                if (a2 != null) {
                    reactionCoreImageComponentPartDefinition = (ReactionCoreImageComponentPartDefinition) a2.a(f18995f);
                } else {
                    reactionCoreImageComponentPartDefinition = f18994e;
                }
                if (reactionCoreImageComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23031b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18995f, b3);
                        } else {
                            f18994e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCoreImageComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private boolean m23032c() {
        return this.f18997d.d();
    }
}
