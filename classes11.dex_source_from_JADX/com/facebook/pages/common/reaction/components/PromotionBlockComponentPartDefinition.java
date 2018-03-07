package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
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
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.PromotionBlockComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selected_option_ids */
public class PromotionBlockComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession & HasPersistentState> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PromotionBlockComponentView> {
    public static final ViewType f2101a = new C02721();
    private static PromotionBlockComponentPartDefinition f2102c;
    private static final Object f2103d = new Object();
    private final PagesSurfaceReactionHelper<E> f2104b;

    /* compiled from: selected_option_ids */
    final class C02721 extends ViewType {
        C02721() {
        }

        public final View m3124a(Context context) {
            return new PromotionBlockComponentView(context);
        }
    }

    /* compiled from: selected_option_ids */
    public class State {
        public final GraphQLBoostedComponentStatus f2090a;
        public final String f2091b;
        public final String f2092c;
        public final String f2093d;
        public final String f2094e;
        public final String f2095f;
        public final String f2096g;
        public final String f2097h;
        public final String f2098i;
        public final String f2099j;
        public final OnClickListener f2100k;

        public State(GraphQLBoostedComponentStatus graphQLBoostedComponentStatus, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, OnClickListener onClickListener) {
            this.f2090a = graphQLBoostedComponentStatus;
            this.f2091b = str;
            this.f2092c = str2;
            this.f2093d = str3;
            this.f2094e = str4;
            this.f2095f = str5;
            this.f2096g = str6;
            this.f2097h = str7;
            this.f2098i = str8;
            this.f2099j = str9;
            this.f2100k = onClickListener;
        }
    }

    private static PromotionBlockComponentPartDefinition m3128b(InjectorLike injectorLike) {
        return new PromotionBlockComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m3130a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m3125a((ReactionUnitComponentNode) obj, (CanLaunchReactionIntent) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m3131a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1350182713);
        m3127a((State) obj2, (PromotionBlockComponentView) view);
        Logger.a(8, EntryType.MARK_POP, 2014208275, a);
    }

    public final boolean m3132a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.aS() == null || reactionUnitComponentFields.aH() == null) ? false : true;
    }

    public final void m3133b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PromotionBlockComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3129a() {
        return f2101a;
    }

    public static PromotionBlockComponentPartDefinition m3126a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PromotionBlockComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2103d) {
                PromotionBlockComponentPartDefinition promotionBlockComponentPartDefinition;
                if (a2 != null) {
                    promotionBlockComponentPartDefinition = (PromotionBlockComponentPartDefinition) a2.a(f2103d);
                } else {
                    promotionBlockComponentPartDefinition = f2102c;
                }
                if (promotionBlockComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3128b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2103d, b3);
                        } else {
                            f2102c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = promotionBlockComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PromotionBlockComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f2104b = pagesSurfaceReactionHelper;
    }

    private State m3125a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ReactionUnitComponentFields f = reactionUnitComponentNode.f();
        return new State(f.L(), f.aS() != null ? f.aS().b() : null, f.aH() != null ? f.aH().a() : null, f.cH() != null ? f.cH().a() : null, f.cB() != null ? f.cB().a() : null, f.ay() != null ? f.ay().a() : null, f.az() != null ? f.az().a() : null, f.cs() != null ? f.cs().a() : null, f.ct() != null ? f.ct().a() : null, f.K() != null ? f.K().a() : null, this.f2104b.m3152a(f.v(), e, reactionUnitComponentNode.k(), reactionUnitComponentNode.l()));
    }

    private static void m3127a(State state, PromotionBlockComponentView promotionBlockComponentView) {
        promotionBlockComponentView.m3185a(state.f2090a, state.f2091b, state.f2092c, state.f2093d, state.f2094e, state.f2095f, state.f2096g, state.f2097h, state.f2098i, state.f2099j);
        promotionBlockComponentView.setOnClickListener(state.f2100k);
    }
}
