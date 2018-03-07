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
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.header.ReactionFigHeaderComponent;
import com.facebook.reaction.feed.unitcomponents.spec.header.ReactionFigHeaderComponent.State;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: album_permalink */
public class ReactionFigHeaderUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionFigHeaderUnitComponentPartDefinition f19709f;
    private static final Object f19710g = new Object();
    private final ReactionFigHeaderComponent f19711c;
    private final ReactionActionDelegateComponent f19712d;
    private final ReactionExperimentController f19713e;

    private static ReactionFigHeaderUnitComponentPartDefinition m23621b(InjectorLike injectorLike) {
        return new ReactionFigHeaderUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionFigHeaderComponent.m24239a(injectorLike), ReactionActionDelegateComponent.m24063a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    private Component<ReactionActionDelegateComponent> m23619a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        Builder a = this.f19712d.m24066a(componentContext);
        State state = new State(this.f19711c);
        ReactionFigHeaderComponent.Builder builder = (ReactionFigHeaderComponent.Builder) ReactionFigHeaderComponent.f20465b.a();
        if (builder == null) {
            builder = new ReactionFigHeaderComponent.Builder();
        }
        ReactionFigHeaderComponent.Builder.m24236a(builder, componentContext, 0, state);
        ReactionFigHeaderComponent.Builder builder2 = builder;
        builder2.f20459a.f20463a = reactionUnitComponentFields.bv().a();
        builder2.f20462d.set(0);
        return a.m24056a(builder2.d()).m24058a(reactionUnitComponentFields.v()).m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
    }

    public final /* synthetic */ boolean m23625a(HasContext hasContext) {
        return m23622c();
    }

    public final /* synthetic */ boolean m23626a(AnyEnvironment anyEnvironment) {
        return m23622c();
    }

    public final boolean m23627a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    @Inject
    public ReactionFigHeaderUnitComponentPartDefinition(Context context, ReactionFigHeaderComponent reactionFigHeaderComponent, ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionExperimentController reactionExperimentController) {
        super(context);
        this.f19711c = reactionFigHeaderComponent;
        this.f19712d = reactionActionDelegateComponent;
        this.f19713e = reactionExperimentController;
    }

    public static ReactionFigHeaderUnitComponentPartDefinition m23620a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFigHeaderUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19710g) {
                ReactionFigHeaderUnitComponentPartDefinition reactionFigHeaderUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionFigHeaderUnitComponentPartDefinition = (ReactionFigHeaderUnitComponentPartDefinition) a2.a(f19710g);
                } else {
                    reactionFigHeaderUnitComponentPartDefinition = f19709f;
                }
                if (reactionFigHeaderUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23621b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19710g, b3);
                        } else {
                            f19709f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFigHeaderUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23628b(Object obj) {
        return null;
    }

    private boolean m23622c() {
        return this.f19713e.d();
    }
}
