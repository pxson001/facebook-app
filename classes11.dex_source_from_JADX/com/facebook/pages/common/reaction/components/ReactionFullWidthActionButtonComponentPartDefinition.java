package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
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
import com.facebook.pages.common.reaction.components.utils.PagesSurfaceReactionHelper;
import com.facebook.pages.common.reaction.ui.FullWidthActionButtonComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selected_guest_count */
public class ReactionFullWidthActionButtonComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, FullWidthActionButtonComponentView> {
    public static final ViewType f2110a = new C02731();
    private static ReactionFullWidthActionButtonComponentPartDefinition f2111d;
    private static final Object f2112e = new Object();
    private final Locales f2113b;
    private final PagesSurfaceReactionHelper<E> f2114c;

    /* compiled from: selected_guest_count */
    final class C02731 extends ViewType {
        C02731() {
        }

        public final View m3134a(Context context) {
            return new FullWidthActionButtonComponentView(context);
        }
    }

    /* compiled from: selected_guest_count */
    public class State {
        public final String f2105a;
        public final String f2106b;
        public final String f2107c;
        public final String f2108d;
        public final OnClickListener f2109e;

        public State(String str, String str2, String str3, String str4, OnClickListener onClickListener) {
            this.f2105a = str;
            this.f2106b = str2;
            this.f2107c = str3;
            this.f2108d = str4;
            this.f2109e = onClickListener;
        }
    }

    private static ReactionFullWidthActionButtonComponentPartDefinition m3136b(InjectorLike injectorLike) {
        return new ReactionFullWidthActionButtonComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike), Locales.a(injectorLike));
    }

    public final Object m3138a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        return new State(reactionUnitComponentFields.bv().a().toUpperCase(this.f2113b.a()), reactionUnitComponentFields.G(), reactionUnitComponentFields.cQ(), reactionUnitComponentFields.M(), this.f2114c.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3139a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1270384871);
        State state = (State) obj2;
        ((FullWidthActionButtonComponentView) view).m3164a(state.f2105a, state.f2106b, state.f2107c, state.f2108d, state.f2109e);
        Logger.a(8, EntryType.MARK_POP, 1285999978, a);
    }

    public final boolean m3140a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public final void m3141b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FullWidthActionButtonComponentView) view).f2139a.setOnClickListener(null);
    }

    public final ViewType m3137a() {
        return f2110a;
    }

    public static ReactionFullWidthActionButtonComponentPartDefinition m3135a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFullWidthActionButtonComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2112e) {
                ReactionFullWidthActionButtonComponentPartDefinition reactionFullWidthActionButtonComponentPartDefinition;
                if (a2 != null) {
                    reactionFullWidthActionButtonComponentPartDefinition = (ReactionFullWidthActionButtonComponentPartDefinition) a2.a(f2112e);
                } else {
                    reactionFullWidthActionButtonComponentPartDefinition = f2111d;
                }
                if (reactionFullWidthActionButtonComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3136b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2112e, b3);
                        } else {
                            f2111d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFullWidthActionButtonComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionFullWidthActionButtonComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper, Locales locales) {
        this.f2114c = pagesSurfaceReactionHelper;
        this.f2113b = locales;
    }
}
