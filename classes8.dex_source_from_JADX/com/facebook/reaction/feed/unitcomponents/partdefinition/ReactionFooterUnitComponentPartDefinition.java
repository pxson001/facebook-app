package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
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
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.footer.ReactionSingleActionFooterComponent;
import com.facebook.reaction.feed.unitcomponents.spec.footer.ReactionSingleActionFooterComponent.State;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: album_detail_view */
public class ReactionFooterUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionFooterUnitComponentPartDefinition f19714f;
    private static final Object f19715g = new Object();
    private final ReactionActionDelegateComponent f19716c;
    private final ReactionSingleActionFooterComponent f19717d;
    private final ReactionExperimentController f19718e;

    private static ReactionFooterUnitComponentPartDefinition m23631b(InjectorLike injectorLike) {
        return new ReactionFooterUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionActionDelegateComponent.m24063a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionSingleActionFooterComponent.m24230a(injectorLike));
    }

    private Component<ReactionActionDelegateComponent> m23629a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        Builder a = this.f19716c.m24066a(componentContext).m24058a(reactionUnitComponentFields.v());
        State state = new State(this.f19717d);
        ReactionSingleActionFooterComponent.Builder builder = (ReactionSingleActionFooterComponent.Builder) ReactionSingleActionFooterComponent.f20452b.a();
        if (builder == null) {
            builder = new ReactionSingleActionFooterComponent.Builder();
        }
        ReactionSingleActionFooterComponent.Builder.m24227a(builder, componentContext, 0, state);
        ReactionSingleActionFooterComponent.Builder builder2 = builder;
        builder2.f20445a.f20450b = true;
        builder2.f20448d.set(1);
        builder2 = builder2;
        builder2.f20445a.f20449a = reactionUnitComponentFields.bv().a();
        builder2.f20448d.set(0);
        return a.m24056a(builder2.d()).m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
    }

    public final /* synthetic */ boolean m23635a(HasContext hasContext) {
        return m23632c();
    }

    public final /* synthetic */ boolean m23636a(AnyEnvironment anyEnvironment) {
        return m23632c();
    }

    public final boolean m23637a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return ((reactionUnitComponentFields.a() != GraphQLReactionUnitComponentStyle.FOOTER && reactionUnitComponentFields.a() != GraphQLReactionUnitComponentStyle.SHORT_FOOTER) || reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    @Inject
    public ReactionFooterUnitComponentPartDefinition(Context context, ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionExperimentController reactionExperimentController, ReactionSingleActionFooterComponent reactionSingleActionFooterComponent) {
        super(context);
        this.f19716c = reactionActionDelegateComponent;
        this.f19717d = reactionSingleActionFooterComponent;
        this.f19718e = reactionExperimentController;
    }

    public static ReactionFooterUnitComponentPartDefinition m23630a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFooterUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19715g) {
                ReactionFooterUnitComponentPartDefinition reactionFooterUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionFooterUnitComponentPartDefinition = (ReactionFooterUnitComponentPartDefinition) a2.a(f19715g);
                } else {
                    reactionFooterUnitComponentPartDefinition = f19714f;
                }
                if (reactionFooterUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23631b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19715g, b3);
                        } else {
                            f19714f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFooterUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23638b(Object obj) {
        return null;
    }

    private boolean m23632c() {
        return this.f19718e.d();
    }
}
