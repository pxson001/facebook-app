package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.net.Uri;
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
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponent;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: after_param */
public class ReactionIconMessageSmallTitleComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionIconMessageSmallTitleComponentPartDefinition f19788f;
    private static final Object f19789g = new Object();
    private final ReactionActionDelegateComponent f19790c;
    private final ReactionImageBlockComponent f19791d;
    private final ReactionExperimentController f19792e;

    private static ReactionIconMessageSmallTitleComponentPartDefinition m23698b(InjectorLike injectorLike) {
        return new ReactionIconMessageSmallTitleComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionActionDelegateComponent.m24063a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionImageBlockComponent.m24123a(injectorLike));
    }

    public final /* synthetic */ boolean m23702a(HasContext hasContext) {
        return m23699c();
    }

    public final /* synthetic */ boolean m23703a(AnyEnvironment anyEnvironment) {
        return m23699c();
    }

    public final boolean m23704a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.aP() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aP().b())) ? false : true;
    }

    @Inject
    public ReactionIconMessageSmallTitleComponentPartDefinition(Context context, ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionExperimentController reactionExperimentController, ReactionImageBlockComponent reactionImageBlockComponent) {
        super(context);
        this.f19790c = reactionActionDelegateComponent;
        this.f19791d = reactionImageBlockComponent;
        this.f19792e = reactionExperimentController;
    }

    private Component<ReactionActionDelegateComponent> m23696a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Uri uri;
        String str = null;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        if (reactionUnitComponentFields.an() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.an().b())) {
            uri = null;
        } else {
            uri = Uri.parse(reactionUnitComponentFields.an().b());
        }
        if (!(reactionUnitComponentFields.cG() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cG().a()))) {
            str = reactionUnitComponentFields.cG().a();
        }
        return this.f19790c.m24066a(componentContext).m24056a(this.f19791d.m24125a(componentContext).m24120b(uri).m24116a(Uri.parse(reactionUnitComponentFields.aP().b())).m24118a(reactionUnitComponentFields.bv().a()).m24121b(str).m24117a(reactionUnitComponentFields.a()).d()).m24058a(reactionUnitComponentFields.v()).m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
    }

    public static ReactionIconMessageSmallTitleComponentPartDefinition m23697a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMessageSmallTitleComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19789g) {
                ReactionIconMessageSmallTitleComponentPartDefinition reactionIconMessageSmallTitleComponentPartDefinition;
                if (a2 != null) {
                    reactionIconMessageSmallTitleComponentPartDefinition = (ReactionIconMessageSmallTitleComponentPartDefinition) a2.a(f19789g);
                } else {
                    reactionIconMessageSmallTitleComponentPartDefinition = f19788f;
                }
                if (reactionIconMessageSmallTitleComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23698b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19789g, b3);
                        } else {
                            f19788f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMessageSmallTitleComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m23705b(Object obj) {
        return null;
    }

    private boolean m23699c() {
        return this.f19792e.d();
    }
}
