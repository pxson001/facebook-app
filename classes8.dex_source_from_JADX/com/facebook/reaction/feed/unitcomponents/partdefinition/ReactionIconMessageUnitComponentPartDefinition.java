package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
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
/* compiled from: ae72a39ddf577b594bfd1fc2461f6ad0 */
public class ReactionIconMessageUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19793a = ViewType.a(2130906625);
    private static ReactionIconMessageUnitComponentPartDefinition f19794e;
    private static final Object f19795f = new Object();
    private final BasicReactionActionPartDefinition<E> f19796b;
    private final ImageBlockLayoutIconPartDefinition f19797c;
    private final TextPartDefinition f19798d;

    private static ReactionIconMessageUnitComponentPartDefinition m23707b(InjectorLike injectorLike) {
        return new ReactionIconMessageUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23709a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131566648, this.f19798d, reactionUnitComponentFields.bv().a());
        if (!(reactionUnitComponentFields.aP() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aP().b()))) {
            subParts.a(this.f19797c, reactionUnitComponentFields.aP().b());
        }
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            subParts.a(this.f19796b, new Props(v, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m23710a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 370151530);
        ((ImageBlockLayout) view).findViewById(2131566653).setVisibility(8);
        Logger.a(8, EntryType.MARK_POP, -1894824015, a);
    }

    public final boolean m23711a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    @Inject
    public ReactionIconMessageUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, TextPartDefinition textPartDefinition) {
        this.f19796b = basicReactionActionPartDefinition;
        this.f19797c = imageBlockLayoutIconPartDefinition;
        this.f19798d = textPartDefinition;
    }

    public static ReactionIconMessageUnitComponentPartDefinition m23706a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMessageUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19795f) {
                ReactionIconMessageUnitComponentPartDefinition reactionIconMessageUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionIconMessageUnitComponentPartDefinition = (ReactionIconMessageUnitComponentPartDefinition) a2.a(f19795f);
                } else {
                    reactionIconMessageUnitComponentPartDefinition = f19794e;
                }
                if (reactionIconMessageUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23707b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19795f, b3);
                        } else {
                            f19794e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMessageUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23708a() {
        return f19793a;
    }
}
