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
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ImageBlockLayoutIconPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.InactiveTextWithEntitiesPartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: articleID */
public class ReactionIconHeaderWithActionPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19227a = ViewType.a(2130906625);
    private static ReactionIconHeaderWithActionPartDefinition f19228e;
    private static final Object f19229f = new Object();
    private final BasicReactionActionPartDefinition f19230b;
    private final ImageBlockLayoutIconPartDefinition f19231c;
    private final InactiveTextWithEntitiesPartDefinition f19232d;

    private static ReactionIconHeaderWithActionPartDefinition m23242b(InjectorLike injectorLike) {
        return new ReactionIconHeaderWithActionPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ImageBlockLayoutIconPartDefinition.m22994a(injectorLike), InactiveTextWithEntitiesPartDefinition.m23402a(injectorLike));
    }

    public final Object m23244a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        subParts.a(2131566648, this.f19232d, fw_.fA_());
        if (fw_.fz_() == null || Strings.isNullOrEmpty(fw_.fz_().a())) {
            obj2 = null;
        } else {
            obj2 = fw_.fz_();
        }
        subParts.a(2131566653, this.f19232d, obj2);
        if (!(fw_.d() == null || Strings.isNullOrEmpty(fw_.d().b()))) {
            subParts.a(this.f19231c, fw_.d().b());
        }
        subParts.a(this.f19230b, new Props(fw_.b(), fw_.fA_().a(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
        return null;
    }

    public final boolean m23245a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()) || fw_.b() == null) ? false : true;
    }

    @Inject
    public ReactionIconHeaderWithActionPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition, InactiveTextWithEntitiesPartDefinition inactiveTextWithEntitiesPartDefinition) {
        this.f19230b = basicReactionActionPartDefinition;
        this.f19231c = imageBlockLayoutIconPartDefinition;
        this.f19232d = inactiveTextWithEntitiesPartDefinition;
    }

    public final ViewType m23243a() {
        return f19227a;
    }

    public static ReactionIconHeaderWithActionPartDefinition m23241a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconHeaderWithActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19229f) {
                ReactionIconHeaderWithActionPartDefinition reactionIconHeaderWithActionPartDefinition;
                if (a2 != null) {
                    reactionIconHeaderWithActionPartDefinition = (ReactionIconHeaderWithActionPartDefinition) a2.a(f19229f);
                } else {
                    reactionIconHeaderWithActionPartDefinition = f19228e;
                }
                if (reactionIconHeaderWithActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23242b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19229f, b3);
                        } else {
                            f19228e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconHeaderWithActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
