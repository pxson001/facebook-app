package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
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
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponent.State;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: adChoicesIconWidth */
public class ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionInteractionTracker & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition f19984d;
    private static final Object f19985e = new Object();
    private final ReactionPlaceInfoBlurbWithBreadcrumbsComponent f19986c;

    private static ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition m23871b(InjectorLike injectorLike) {
        return new ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionPlaceInfoBlurbWithBreadcrumbsComponent.m24169a(injectorLike));
    }

    public final boolean m23874a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (!CollectionUtil.b(reactionUnitComponentFields.bR()) || reactionUnitComponentFields.bP() == null || TextUtils.isEmpty(reactionUnitComponentFields.bP().a())) ? false : true;
    }

    private Component<?> m23869a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionPlaceInfoBlurbWithBreadcrumbsComponent reactionPlaceInfoBlurbWithBreadcrumbsComponent = this.f19986c;
        State state = new State(reactionPlaceInfoBlurbWithBreadcrumbsComponent);
        Builder builder = (Builder) reactionPlaceInfoBlurbWithBreadcrumbsComponent.f20357c.a();
        if (builder == null) {
            builder = new Builder(reactionPlaceInfoBlurbWithBreadcrumbsComponent);
        }
        Builder.m24166a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f20339a.f20344a = reactionUnitComponentFields.bR();
        builder2.f20343e.set(0);
        builder2 = builder2;
        builder2.f20339a.f20345b = reactionUnitComponentFields.bP().a();
        builder2.f20343e.set(1);
        builder2 = builder2;
        builder2.f20339a.f20346c = reactionUnitComponentFields.aN();
        builder2.f20343e.set(2);
        builder2 = builder2;
        builder2.f20339a.f20347d = reactionUnitComponentFields.bX();
        builder2.f20343e.set(3);
        builder2 = builder2;
        builder2.f20339a.f20348e = reactionUnitComponentFields.bT();
        builder2.f20343e.set(4);
        builder2 = builder2;
        builder2.f20339a.f20349f = reactionUnitComponentFields.cg();
        builder2.f20343e.set(5);
        builder2 = builder2;
        builder2.f20339a.f20350g = reactionUnitComponentFields.cT();
        builder2.f20343e.set(6);
        Builder builder3 = builder2;
        builder3.f20339a.f20351h = e;
        builder3.f20343e.set(7);
        builder3 = builder3;
        builder3.f20339a.f20352i = reactionUnitComponentNode.f18863c;
        builder3.f20343e.set(8);
        builder3 = builder3;
        builder3.f20339a.f20353j = reactionUnitComponentNode.f18864d;
        builder3.f20343e.set(9);
        return builder3.d();
    }

    @Inject
    public ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition(Context context, ReactionPlaceInfoBlurbWithBreadcrumbsComponent reactionPlaceInfoBlurbWithBreadcrumbsComponent) {
        super(context);
        this.f19986c = reactionPlaceInfoBlurbWithBreadcrumbsComponent;
    }

    public static ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition m23870a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19985e) {
                ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition reactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition = (ReactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition) a2.a(f19985e);
                } else {
                    reactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition = f19984d;
                }
                if (reactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23871b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19985e, b3);
                        } else {
                            f19984d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPlaceInfoBlurbWithBreadcrumbsUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23875b(Object obj) {
        return null;
    }
}
