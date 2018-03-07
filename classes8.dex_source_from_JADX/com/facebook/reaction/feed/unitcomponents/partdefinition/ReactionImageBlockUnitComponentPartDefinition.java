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
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionActionDelegateComponent.Builder;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionImageBlockComponent;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: admined_pages */
public class ReactionImageBlockUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasIsAsync & HasPersistentState & HasReactionSession> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static ReactionImageBlockUnitComponentPartDefinition f19815f;
    private static final Object f19816g = new Object();
    private final ReactionActionDelegateComponent f19817c;
    private final ReactionImageBlockComponent f19818d;
    private final ReactionExperimentController f19819e;

    private static ReactionImageBlockUnitComponentPartDefinition m23728b(InjectorLike injectorLike) {
        return new ReactionImageBlockUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ReactionActionDelegateComponent.m24063a(injectorLike), ReactionExperimentController.a(injectorLike), ReactionImageBlockComponent.m24123a(injectorLike));
    }

    public final /* synthetic */ boolean m23732a(HasContext hasContext) {
        return m23729c();
    }

    public final /* synthetic */ boolean m23733a(AnyEnvironment anyEnvironment) {
        return m23729c();
    }

    public final boolean m23734a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.aU() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aU().b())) ? false : true;
    }

    @Inject
    public ReactionImageBlockUnitComponentPartDefinition(Context context, ReactionActionDelegateComponent reactionActionDelegateComponent, ReactionExperimentController reactionExperimentController, ReactionImageBlockComponent reactionImageBlockComponent) {
        super(context);
        this.f19817c = reactionActionDelegateComponent;
        this.f19818d = reactionImageBlockComponent;
        this.f19819e = reactionExperimentController;
    }

    public static ReactionImageBlockUnitComponentPartDefinition m23727a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionImageBlockUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19816g) {
                ReactionImageBlockUnitComponentPartDefinition reactionImageBlockUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionImageBlockUnitComponentPartDefinition = (ReactionImageBlockUnitComponentPartDefinition) a2.a(f19816g);
                } else {
                    reactionImageBlockUnitComponentPartDefinition = f19815f;
                }
                if (reactionImageBlockUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23728b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19816g, b3);
                        } else {
                            f19815f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionImageBlockUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<ReactionActionDelegateComponent> m23726a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        Uri parse;
        Builder a;
        String str = null;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ImmutableList cu = reactionUnitComponentFields.cu();
        if (!cu.isEmpty()) {
            ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) cu.get(0);
            if (!(reactionStoryAttachmentActionFragmentModel.d() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionFragmentModel.d().b()))) {
                parse = Uri.parse(reactionStoryAttachmentActionFragmentModel.d().b());
                if (!(parse != null || reactionUnitComponentFields.an() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.an().b()))) {
                    parse = Uri.parse(reactionUnitComponentFields.an().b());
                }
                if (!(reactionUnitComponentFields.cG() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cG().a()))) {
                    str = reactionUnitComponentFields.cG().a();
                }
                a = this.f19817c.m24066a(componentContext).m24056a(this.f19818d.m24125a(componentContext).m24116a(Uri.parse(reactionUnitComponentFields.aU().b())).m24118a(reactionUnitComponentFields.bv().a()).m24121b(str).m24120b(parse).m24117a(reactionUnitComponentFields.a()).d()).m24058a(reactionUnitComponentFields.v());
                a.f20196a.f20203c = reactionUnitComponentFields.V();
                return a.m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
            }
        }
        parse = null;
        parse = Uri.parse(reactionUnitComponentFields.an().b());
        str = reactionUnitComponentFields.cG().a();
        a = this.f19817c.m24066a(componentContext).m24056a(this.f19818d.m24125a(componentContext).m24116a(Uri.parse(reactionUnitComponentFields.aU().b())).m24118a(reactionUnitComponentFields.bv().a()).m24121b(str).m24120b(parse).m24117a(reactionUnitComponentFields.a()).d()).m24058a(reactionUnitComponentFields.v());
        a.f20196a.f20203c = reactionUnitComponentFields.V();
        return a.m24057a((CanLaunchReactionIntent) e).m24060b(reactionUnitComponentNode.f18863c).m24061c(reactionUnitComponentNode.f18864d).d();
    }

    public final CacheableEntity m23735b(Object obj) {
        return null;
    }

    private boolean m23729c() {
        return this.f19819e.d();
    }
}
