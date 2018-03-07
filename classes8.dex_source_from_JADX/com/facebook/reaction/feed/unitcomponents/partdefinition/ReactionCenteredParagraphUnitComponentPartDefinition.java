package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
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
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentPersistentState;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionCenteredParagraphUnitComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionExpandableActionDelegateComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponent;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionTruncatedParagraphUnitComponent.Builder;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: am_football */
public class ReactionCenteredParagraphUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasInvalidate & HasIsAsync & HasPersistentState & HasReactionInteractionTracker> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionCenteredParagraphUnitComponentPartDefinition f19562h;
    private static final Object f19563i = new Object();
    private final ReactionActionDelegateComponent f19564c;
    private final ReactionCenteredParagraphUnitComponent f19565d;
    private final ReactionExpandableActionDelegateComponent f19566e;
    private final ReactionExperimentController f19567f;
    private final ReactionTruncatedParagraphUnitComponent f19568g;

    private static ReactionCenteredParagraphUnitComponentPartDefinition m23500b(InjectorLike injectorLike) {
        return new ReactionCenteredParagraphUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionActionDelegateComponent.m24063a(injectorLike), ReactionCenteredParagraphUnitComponent.m24091a(injectorLike), ReactionExpandableActionDelegateComponent.m24107a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionTruncatedParagraphUnitComponent.m24211a(injectorLike));
    }

    private Component<?> m23498a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Component d;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionExpandableComponentPersistentState reactionExpandableComponentPersistentState = (ReactionExpandableComponentPersistentState) ((HasPersistentState) e).a(new ReactionExpandableComponentKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode);
        if (reactionExpandableComponentPersistentState.f19167a) {
            d = this.f19565d.m24093a(componentContext).m24087a(new SpannableStringBuilder(reactionUnitComponentFields.bv().a())).m24088a(reactionUnitComponentFields.a()).d();
        } else {
            Builder a = this.f19568g.m24213a(componentContext).m24207a(new SpannableStringBuilder(reactionUnitComponentFields.bv().a()));
            a.f20411a.f20416b = reactionExpandableComponentPersistentState.f19168b;
            a = a.m24208a(reactionUnitComponentFields.cW());
            a.f20411a.f20418d = reactionUnitComponentFields.a();
            d = a.d();
        }
        if (reactionUnitComponentFields.v() != null) {
            return this.f19564c.m24066a(componentContext).m24056a(d).m24058a(reactionUnitComponentFields.v()).m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
        }
        return this.f19566e.m24110a(componentContext).m24099a(d).m24103a(reactionUnitComponentNode.f18863c).m24105b(reactionUnitComponentNode.f18864d).m24101a(((HasReactionInteractionTracker) e).kE_()).m24100a((HasInvalidate) e).m24102a(reactionExpandableComponentPersistentState).d();
    }

    public final /* synthetic */ boolean m23504a(HasContext hasContext) {
        return m23501c();
    }

    public final /* synthetic */ boolean m23505a(AnyEnvironment anyEnvironment) {
        return m23501c();
    }

    public final boolean m23506a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public static ReactionCenteredParagraphUnitComponentPartDefinition m23499a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCenteredParagraphUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19563i) {
                ReactionCenteredParagraphUnitComponentPartDefinition reactionCenteredParagraphUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionCenteredParagraphUnitComponentPartDefinition = (ReactionCenteredParagraphUnitComponentPartDefinition) a2.a(f19563i);
                } else {
                    reactionCenteredParagraphUnitComponentPartDefinition = f19562h;
                }
                if (reactionCenteredParagraphUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23500b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19563i, b3);
                        } else {
                            f19562h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCenteredParagraphUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionCenteredParagraphUnitComponentPartDefinition(Context context, ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionCenteredParagraphUnitComponent reactionCenteredParagraphUnitComponent, ReactionExpandableActionDelegateComponent reactionExpandableActionDelegateComponent, ReactionExperimentController reactionExperimentController, ReactionTruncatedParagraphUnitComponent reactionTruncatedParagraphUnitComponent) {
        super(context);
        this.f19564c = reactionActionDelegateComponent;
        this.f19565d = reactionCenteredParagraphUnitComponent;
        this.f19566e = reactionExpandableActionDelegateComponent;
        this.f19567f = reactionExperimentController;
        this.f19568g = reactionTruncatedParagraphUnitComponent;
    }

    public final CacheableEntity m23507b(Object obj) {
        return null;
    }

    private boolean m23501c() {
        return this.f19567f.d();
    }
}
