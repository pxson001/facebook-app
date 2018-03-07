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
/* compiled from: before_cursor */
public class ReactionCoreImageTextComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionAnalyticsParams & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionCoreImageTextComponentPartDefinition f18998e;
    private static final Object f18999f = new Object();
    private final ReactionCoreComponentsBuilder f19000c;
    private final ReactionExperimentController f19001d;

    private static ReactionCoreImageTextComponentPartDefinition m23041b(InjectorLike injectorLike) {
        return new ReactionCoreImageTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionCoreComponentsBuilder.m23007a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    public final /* synthetic */ boolean m23045a(HasContext hasContext) {
        return m23042c();
    }

    public final /* synthetic */ boolean m23046a(AnyEnvironment anyEnvironment) {
        return m23042c();
    }

    public final boolean m23047a(Object obj) {
        return ReactionCoreComponentsBuilder.m23008a(((ReactionUnitComponentNode) obj).f18862b);
    }

    @Inject
    public ReactionCoreImageTextComponentPartDefinition(Context context, ReactionCoreComponentsBuilder reactionCoreComponentsBuilder, ReactionExperimentController reactionExperimentController) {
        super(context);
        this.f19000c = reactionCoreComponentsBuilder;
        this.f19001d = reactionExperimentController;
    }

    public static ReactionCoreImageTextComponentPartDefinition m23040a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCoreImageTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18999f) {
                ReactionCoreImageTextComponentPartDefinition reactionCoreImageTextComponentPartDefinition;
                if (a2 != null) {
                    reactionCoreImageTextComponentPartDefinition = (ReactionCoreImageTextComponentPartDefinition) a2.a(f18999f);
                } else {
                    reactionCoreImageTextComponentPartDefinition = f18998e;
                }
                if (reactionCoreImageTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23041b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18999f, b3);
                        } else {
                            f18998e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCoreImageTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m23039a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        return this.f19000c.m23011a(componentContext, reactionUnitComponentNode, e);
    }

    public final CacheableEntity m23048b(Object obj) {
        return null;
    }

    private boolean m23042c() {
        return this.f19001d.d();
    }
}
