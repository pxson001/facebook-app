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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.feed.corecomponents.ReactionCoreComponentsBuilder;
import com.facebook.reaction.feed.corecomponents.spec.ReactionCoreComponent;
import com.facebook.reaction.feed.corecomponents.spec.ReactionHorizontalListComponent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitStaticAggregationComponentFields;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bellerophon_cancel */
public class ReactionCoreHorizontalListComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionAnalyticsParams & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionCoreHorizontalListComponentPartDefinition f18989f;
    private static final Object f18990g = new Object();
    private final ReactionCoreComponent f18991c;
    private final ReactionCoreComponentsBuilder f18992d;
    private final ReactionHorizontalListComponent f18993e;

    private static ReactionCoreHorizontalListComponentPartDefinition m23024b(InjectorLike injectorLike) {
        return new ReactionCoreHorizontalListComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionCoreComponent.m23076a(injectorLike), ReactionCoreComponentsBuilder.m23007a(injectorLike), ReactionHorizontalListComponent.m23133a(injectorLike));
    }

    private Component<?> m23022a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ImmutableList b = ReactionUnitComponentUtil.m22902b(reactionUnitComponentNode);
        Builder builder = ImmutableList.builder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            builder.c(new ReactionUnitComponentNode((ReactionUnitComponentFields) b.get(i), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a));
        }
        return this.f18991c.m23078a(componentContext).m23073a(reactionUnitComponentFields.Y()).m23070a(reactionUnitComponentFields.Z()).m23071a(reactionUnitComponentFields.ac()).m23072a(reactionUnitComponentFields.ad()).m23069a(this.f18993e.m23135a(componentContext).m23130a(builder.b()).m23129a((CanLaunchReactionIntent) e).d()).d();
    }

    public final boolean m23027a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (!(reactionUnitComponentNode.f18862b instanceof ReactionUnitStaticAggregationComponentFields)) {
            return false;
        }
        ImmutableList b = ReactionUnitComponentUtil.m22902b(reactionUnitComponentNode);
        if (b == null || b.isEmpty()) {
            return false;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (!ReactionCoreComponentsBuilder.m23008a((ReactionUnitComponentFields) b.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public ReactionCoreHorizontalListComponentPartDefinition(Context context, ReactionCoreComponent reactionCoreComponent, ReactionCoreComponentsBuilder reactionCoreComponentsBuilder, ReactionHorizontalListComponent reactionHorizontalListComponent) {
        super(context);
        this.f18991c = reactionCoreComponent;
        this.f18992d = reactionCoreComponentsBuilder;
        this.f18993e = reactionHorizontalListComponent;
    }

    public static ReactionCoreHorizontalListComponentPartDefinition m23023a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCoreHorizontalListComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18990g) {
                ReactionCoreHorizontalListComponentPartDefinition reactionCoreHorizontalListComponentPartDefinition;
                if (a2 != null) {
                    reactionCoreHorizontalListComponentPartDefinition = (ReactionCoreHorizontalListComponentPartDefinition) a2.a(f18990g);
                } else {
                    reactionCoreHorizontalListComponentPartDefinition = f18989f;
                }
                if (reactionCoreHorizontalListComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23024b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18990g, b3);
                        } else {
                            f18989f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCoreHorizontalListComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23028b(Object obj) {
        return null;
    }
}
