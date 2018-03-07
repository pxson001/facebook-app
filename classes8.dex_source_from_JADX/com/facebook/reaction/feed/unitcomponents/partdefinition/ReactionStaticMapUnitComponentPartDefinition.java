package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.maps.FbStaticMapView;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.ReactionMapPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionMapPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_recovery_send_code */
public class ReactionStaticMapUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, FbStaticMapView> {
    public static final ViewType f20077a = new C21491();
    private static ReactionStaticMapUnitComponentPartDefinition f20078d;
    private static final Object f20079e = new Object();
    private final ReactionMapPartDefinition f20080b;
    private final BasicReactionActionPartDefinition f20081c;

    /* compiled from: account_recovery_send_code */
    final class C21491 extends ViewType {
        C21491() {
        }

        public final View m23967a(Context context) {
            FbStaticMapView fbStaticMapView = new FbStaticMapView(context);
            fbStaticMapView.setCenteredMapPinDrawable(context.getResources().getDrawable(2130841143));
            return fbStaticMapView;
        }
    }

    private static ReactionStaticMapUnitComponentPartDefinition m23969b(InjectorLike injectorLike) {
        return new ReactionStaticMapUnitComponentPartDefinition(ReactionMapPartDefinition.m23415a(injectorLike), BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    public final Object m23971a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(this.f20080b, new Props(reactionUnitComponentFields.R(), reactionUnitComponentFields.bt()));
        subParts.a(this.f20081c, new BasicReactionActionPartDefinition.Props(reactionUnitComponentFields.v(), reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        return null;
    }

    public final boolean m23972a(Object obj) {
        return ((ReactionUnitComponentNode) obj).f18862b.R() != null;
    }

    @Inject
    public ReactionStaticMapUnitComponentPartDefinition(ReactionMapPartDefinition reactionMapPartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f20080b = reactionMapPartDefinition;
        this.f20081c = basicReactionActionPartDefinition;
    }

    public static ReactionStaticMapUnitComponentPartDefinition m23968a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStaticMapUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20079e) {
                ReactionStaticMapUnitComponentPartDefinition reactionStaticMapUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionStaticMapUnitComponentPartDefinition = (ReactionStaticMapUnitComponentPartDefinition) a2.a(f20079e);
                } else {
                    reactionStaticMapUnitComponentPartDefinition = f20078d;
                }
                if (reactionStaticMapUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23969b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20079e, b3);
                        } else {
                            f20078d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionStaticMapUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<FbStaticMapView> m23970a() {
        return f20077a;
    }
}
