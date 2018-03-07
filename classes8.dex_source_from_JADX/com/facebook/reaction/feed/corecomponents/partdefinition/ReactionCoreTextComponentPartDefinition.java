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
/* compiled from: beforeCursor */
public class ReactionCoreTextComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionAnalyticsParams & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionCoreTextComponentPartDefinition f19002e;
    private static final Object f19003f = new Object();
    private final ReactionCoreComponentsBuilder f19004c;
    private final ReactionExperimentController f19005d;

    private static ReactionCoreTextComponentPartDefinition m23051b(InjectorLike injectorLike) {
        return new ReactionCoreTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionCoreComponentsBuilder.m23007a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    public final /* synthetic */ boolean m23055a(HasContext hasContext) {
        return m23052c();
    }

    public final /* synthetic */ boolean m23056a(AnyEnvironment anyEnvironment) {
        return m23052c();
    }

    public final boolean m23057a(Object obj) {
        return ReactionCoreComponentsBuilder.m23008a(((ReactionUnitComponentNode) obj).f18862b);
    }

    @Inject
    public ReactionCoreTextComponentPartDefinition(Context context, ReactionCoreComponentsBuilder reactionCoreComponentsBuilder, ReactionExperimentController reactionExperimentController) {
        super(context);
        this.f19004c = reactionCoreComponentsBuilder;
        this.f19005d = reactionExperimentController;
    }

    private Component<?> m23049a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        return this.f19004c.m23011a(componentContext, reactionUnitComponentNode, e);
    }

    public static ReactionCoreTextComponentPartDefinition m23050a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCoreTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19003f) {
                ReactionCoreTextComponentPartDefinition reactionCoreTextComponentPartDefinition;
                if (a2 != null) {
                    reactionCoreTextComponentPartDefinition = (ReactionCoreTextComponentPartDefinition) a2.a(f19003f);
                } else {
                    reactionCoreTextComponentPartDefinition = f19002e;
                }
                if (reactionCoreTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23051b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19003f, b3);
                        } else {
                            f19002e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCoreTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23058b(Object obj) {
        return null;
    }

    private boolean m23052c() {
        return this.f19005d.d();
    }
}
