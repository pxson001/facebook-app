package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: added_users */
public class ReactionInfoRowUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19860a = ViewType.a(2130906643);
    private static ReactionInfoRowUnitComponentPartDefinition f19861e;
    private static final Object f19862f = new Object();
    private final BasicReactionActionPartDefinition f19863b;
    private final ImageBlockLayoutIconPartDefinition f19864c;
    private final TextOrHiddenPartDefinition f19865d;

    private static ReactionInfoRowUnitComponentPartDefinition m23768b(InjectorLike injectorLike) {
        return new ReactionInfoRowUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m23770a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            subParts.a(this.f19863b, new Props(v, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        subParts.a(2131566677, this.f19865d, reactionUnitComponentFields.cU().a());
        if (reactionUnitComponentFields.cL() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cL().a())) {
            obj2 = null;
        } else {
            obj2 = reactionUnitComponentFields.cL().a();
        }
        subParts.a(2131566678, this.f19865d, obj2);
        subParts.a(this.f19864c, reactionUnitComponentFields.bY().a().b());
        return null;
    }

    public final boolean m23771a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.cU() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cU().a()) || reactionUnitComponentFields.bY() == null || reactionUnitComponentFields.bY().a() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bY().a().b())) ? false : true;
    }

    public final ViewType m23769a() {
        return f19860a;
    }

    @Inject
    public ReactionInfoRowUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f19863b = basicReactionActionPartDefinition;
        this.f19864c = imageBlockLayoutIconPartDefinition;
        this.f19865d = textOrHiddenPartDefinition;
    }

    public static ReactionInfoRowUnitComponentPartDefinition m23767a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionInfoRowUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19862f) {
                ReactionInfoRowUnitComponentPartDefinition reactionInfoRowUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionInfoRowUnitComponentPartDefinition = (ReactionInfoRowUnitComponentPartDefinition) a2.a(f19862f);
                } else {
                    reactionInfoRowUnitComponentPartDefinition = f19861e;
                }
                if (reactionInfoRowUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23768b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19862f, b3);
                        } else {
                            f19861e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionInfoRowUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
