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
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.BasicReactionHeaderPartDefinition;
import com.facebook.reaction.feed.rows.subparts.BasicReactionHeaderPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article_aggregate_load_time */
public class ReactionIconHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19218a = ViewType.a(2130906625);
    private static ReactionIconHeaderPartDefinition f19219c;
    private static final Object f19220d = new Object();
    private final BasicReactionHeaderPartDefinition f19221b;

    private static ReactionIconHeaderPartDefinition m23233b(InjectorLike injectorLike) {
        return new ReactionIconHeaderPartDefinition(BasicReactionHeaderPartDefinition.m23394a(injectorLike));
    }

    public final Object m23235a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment k = ((ReactionCardNode) obj).mo1117k();
        subParts.a(this.f19221b, new Props(k.fw_(), k.d(), k.n()));
        return null;
    }

    public final boolean m23236a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a())) ? false : true;
    }

    @Inject
    public ReactionIconHeaderPartDefinition(BasicReactionHeaderPartDefinition basicReactionHeaderPartDefinition) {
        this.f19221b = basicReactionHeaderPartDefinition;
    }

    public final ViewType m23234a() {
        return f19218a;
    }

    public static ReactionIconHeaderPartDefinition m23232a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19220d) {
                ReactionIconHeaderPartDefinition reactionIconHeaderPartDefinition;
                if (a2 != null) {
                    reactionIconHeaderPartDefinition = (ReactionIconHeaderPartDefinition) a2.a(f19220d);
                } else {
                    reactionIconHeaderPartDefinition = f19219c;
                }
                if (reactionIconHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23233b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19220d, b3);
                        } else {
                            f19219c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
