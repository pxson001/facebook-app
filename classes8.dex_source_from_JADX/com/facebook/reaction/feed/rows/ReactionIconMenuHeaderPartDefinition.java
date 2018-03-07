package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.BasicReactionMenuHeaderPartDefinition;
import com.facebook.reaction.feed.rows.subparts.BasicReactionMenuHeaderPartDefinition.Props;
import com.facebook.reaction.feed.rows.ui.ReactionIconMenuHeaderView;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_page_call_to_action_label */
public class ReactionIconMenuHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ReactionIconMenuHeaderView> {
    public static final ViewType f19244a = new C20971();
    private static ReactionIconMenuHeaderPartDefinition f19245d;
    private static final Object f19246e = new Object();
    private final BasicReactionActionPartDefinition f19247b;
    private final BasicReactionMenuHeaderPartDefinition f19248c;

    /* compiled from: arg_page_call_to_action_label */
    final class C20971 extends ViewType {
        C20971() {
        }

        public final View m23255a(Context context) {
            return new ReactionIconMenuHeaderView(context);
        }
    }

    private static ReactionIconMenuHeaderPartDefinition m23258b(InjectorLike injectorLike) {
        return new ReactionIconMenuHeaderPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), BasicReactionMenuHeaderPartDefinition.m23397a(injectorLike));
    }

    public final Object m23260a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        subParts.a(this.f19248c, new Props(fw_, reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n(), reactionCardNode.mo1117k().j()));
        if (fw_.b() != null) {
            subParts.a(this.f19247b, new BasicReactionActionPartDefinition.Props(fw_.b(), fw_.fA_().a(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m23261a(java.lang.Object r4) {
        /*
        r3 = this;
        r4 = (com.facebook.reaction.common.ReactionCardNode) r4;
        r0 = r4.mo1117k();
        r0 = r0.fw_();
        if (r0 == 0) goto L_0x0050;
    L_0x000c:
        r1 = r0.fA_();
        if (r1 == 0) goto L_0x0050;
    L_0x0012:
        r1 = r0.fA_();
        r1 = r1.a();
        r1 = com.google.common.base.Strings.isNullOrEmpty(r1);
        if (r1 != 0) goto L_0x0050;
    L_0x0020:
        r1 = r0.b();
        if (r1 == 0) goto L_0x003e;
    L_0x0026:
        r2 = r0.fA_();
        r2 = m23257a(r2);
        if (r2 != 0) goto L_0x003a;
    L_0x0030:
        r2 = r0.fz_();
        r2 = m23257a(r2);
        if (r2 == 0) goto L_0x0052;
    L_0x003a:
        r2 = 1;
    L_0x003b:
        r1 = r2;
        if (r1 != 0) goto L_0x0050;
    L_0x003e:
        r1 = r0.fy_();
        if (r1 == 0) goto L_0x0050;
    L_0x0044:
        r0 = r0.fy_();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0050;
    L_0x004e:
        r0 = 1;
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = 0;
        goto L_0x004f;
    L_0x0052:
        r2 = 0;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.rows.ReactionIconMenuHeaderPartDefinition.a(java.lang.Object):boolean");
    }

    @Inject
    public ReactionIconMenuHeaderPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, BasicReactionMenuHeaderPartDefinition basicReactionMenuHeaderPartDefinition) {
        this.f19247b = basicReactionActionPartDefinition;
        this.f19248c = basicReactionMenuHeaderPartDefinition;
    }

    public static ReactionIconMenuHeaderPartDefinition m23256a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconMenuHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19246e) {
                ReactionIconMenuHeaderPartDefinition reactionIconMenuHeaderPartDefinition;
                if (a2 != null) {
                    reactionIconMenuHeaderPartDefinition = (ReactionIconMenuHeaderPartDefinition) a2.a(f19246e);
                } else {
                    reactionIconMenuHeaderPartDefinition = f19245d;
                }
                if (reactionIconMenuHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23258b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19246e, b3);
                        } else {
                            f19245d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconMenuHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ReactionIconMenuHeaderView> m23259a() {
        return f19244a;
    }

    public static boolean m23257a(@Nullable LinkableTextWithEntities linkableTextWithEntities) {
        return (linkableTextWithEntities == null || linkableTextWithEntities.b().isEmpty()) ? false : true;
    }
}
