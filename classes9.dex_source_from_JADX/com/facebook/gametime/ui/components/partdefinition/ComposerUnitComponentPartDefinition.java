package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.user.model.User;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: TBType; */
public class ComposerUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    static final CallerContext f25093a = CallerContext.a(ComposerUnitComponentPartDefinition.class, "gametime");
    public static final ViewType f25094b = ViewType.a(2130904571);
    private static ComposerUnitComponentPartDefinition f25095g;
    private static final Object f25096h = new Object();
    private final BasicReactionActionPartDefinition f25097c;
    private final FbDraweePartDefinition f25098d;
    private final TextPartDefinition f25099e;
    private final Provider<User> f25100f;

    private static ComposerUnitComponentPartDefinition m27087b(InjectorLike injectorLike) {
        return new ComposerUnitComponentPartDefinition(BasicReactionActionPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    public final Object m27089a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        subParts.a(this.f25097c, new Props(reactionUnitComponentNode.b.v(), reactionUnitComponentNode.c, reactionUnitComponentNode.d));
        FbDraweePartDefinition fbDraweePartDefinition = this.f25098d;
        Builder a = new Builder().a(((User) this.f25100f.get()).x());
        a.c = f25093a;
        subParts.a(2131561283, fbDraweePartDefinition, a.a());
        subParts.a(2131561284, this.f25099e, reactionUnitComponentNode.b.cd());
        return null;
    }

    public final boolean m27090a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        if (this.f25100f.get() == null || Strings.isNullOrEmpty(((User) this.f25100f.get()).x())) {
            return false;
        }
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentNode.b.v();
        if (v == null || v.u() == null) {
            return (v == null || v.p() == null || Strings.isNullOrEmpty(v.p().b()) || v.p().d() == null || v.p().c() == null || Strings.isNullOrEmpty(v.p().c().c())) ? false : true;
        } else {
            return true;
        }
    }

    @Inject
    public ComposerUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, Provider<User> provider) {
        this.f25097c = basicReactionActionPartDefinition;
        this.f25098d = fbDraweePartDefinition;
        this.f25099e = textPartDefinition;
        this.f25100f = provider;
    }

    public static ComposerUnitComponentPartDefinition m27086a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ComposerUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25096h) {
                ComposerUnitComponentPartDefinition composerUnitComponentPartDefinition;
                if (a2 != null) {
                    composerUnitComponentPartDefinition = (ComposerUnitComponentPartDefinition) a2.a(f25096h);
                } else {
                    composerUnitComponentPartDefinition = f25095g;
                }
                if (composerUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27087b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25096h, b3);
                        } else {
                            f25095g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = composerUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m27088a() {
        return f25094b;
    }
}
