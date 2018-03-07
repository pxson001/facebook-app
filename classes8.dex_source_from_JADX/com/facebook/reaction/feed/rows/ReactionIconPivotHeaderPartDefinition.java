package com.facebook.reaction.feed.rows;

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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_page_call_to_action_fields */
public class ReactionIconPivotHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f19249a = ViewType.a(2130906678);
    private static ReactionIconPivotHeaderPartDefinition f19250e;
    private static final Object f19251f = new Object();
    private final BasicReactionActionPartDefinition f19252b;
    private final ImageBlockLayoutIconPartDefinition f19253c;
    private final TextPartDefinition f19254d;

    private static ReactionIconPivotHeaderPartDefinition m23263b(InjectorLike injectorLike) {
        return new ReactionIconPivotHeaderPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23265a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        String d = reactionCardNode.mo1117k().d();
        String n = reactionCardNode.mo1117k().n();
        String a = fw_.fA_().a();
        Object b = fw_.d() != null ? fw_.d().b() : null;
        subParts.a(this.f19252b, new Props(fw_.b(), d, n));
        subParts.a(2131566727, this.f19254d, a);
        if (b != null) {
            subParts.a(this.f19253c, b);
        }
        return null;
    }

    public final boolean m23266a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()) || fw_.b() == null) ? false : true;
    }

    @Inject
    public ReactionIconPivotHeaderPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, TextPartDefinition textPartDefinition) {
        this.f19252b = basicReactionActionPartDefinition;
        this.f19253c = imageBlockLayoutIconPartDefinition;
        this.f19254d = textPartDefinition;
    }

    public static ReactionIconPivotHeaderPartDefinition m23262a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconPivotHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19251f) {
                ReactionIconPivotHeaderPartDefinition reactionIconPivotHeaderPartDefinition;
                if (a2 != null) {
                    reactionIconPivotHeaderPartDefinition = (ReactionIconPivotHeaderPartDefinition) a2.a(f19251f);
                } else {
                    reactionIconPivotHeaderPartDefinition = f19250e;
                }
                if (reactionIconPivotHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23263b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19251f, b3);
                        } else {
                            f19250e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconPivotHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ImageBlockLayout> m23264a() {
        return f19249a;
    }
}
