package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.BadgeTextView;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setMarketplaceId */
public class FooterWithBadgeComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, BadgeTextView> {
    public static final ViewType<BetterTextView> f1842a = ViewType.a(2130906666);
    private static FooterWithBadgeComponentPartDefinition f1843c;
    private static final Object f1844d = new Object();
    private final PagesSurfaceReactionHelper f1845b;

    /* compiled from: setMarketplaceId */
    public class State {
        public String f1839a;
        @Nullable
        public String f1840b;
        public final OnClickListener f1841c;

        public State(String str, String str2, OnClickListener onClickListener) {
            this.f1839a = str;
            this.f1840b = str2;
            this.f1841c = onClickListener;
        }
    }

    private static FooterWithBadgeComponentPartDefinition m2890b(InjectorLike injectorLike) {
        return new FooterWithBadgeComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m2892a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        String str = null;
        if (reactionUnitComponentFields.cO() != null) {
            str = reactionUnitComponentFields.cO().a();
        }
        return new State(reactionUnitComponentFields.bv().a(), str, this.f1845b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m2893a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1338432802);
        m2889a((State) obj2, (CanLaunchReactionIntent) anyEnvironment, (BadgeTextView) view);
        Logger.a(8, EntryType.MARK_POP, -1738125787, a);
    }

    public final boolean m2894a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public final void m2895b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BadgeTextView) view).setOnClickListener(null);
    }

    @Inject
    public FooterWithBadgeComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1845b = pagesSurfaceReactionHelper;
    }

    public static FooterWithBadgeComponentPartDefinition m2888a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FooterWithBadgeComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1844d) {
                FooterWithBadgeComponentPartDefinition footerWithBadgeComponentPartDefinition;
                if (a2 != null) {
                    footerWithBadgeComponentPartDefinition = (FooterWithBadgeComponentPartDefinition) a2.a(f1844d);
                } else {
                    footerWithBadgeComponentPartDefinition = f1843c;
                }
                if (footerWithBadgeComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2890b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1844d, b3);
                        } else {
                            f1843c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = footerWithBadgeComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2891a() {
        return f1842a;
    }

    private static void m2889a(State state, E e, BadgeTextView badgeTextView) {
        badgeTextView.setText(state.f1839a);
        if (StringUtil.a(state.f1840b) || state.f1840b.equals("0")) {
            badgeTextView.setBadgeText("");
        } else {
            badgeTextView.setBadgeText(state.f1840b);
            badgeTextView.setBadgeBackground(2130840410);
            badgeTextView.setBadgeYOffset(0);
            badgeTextView.setBadgePadding(((HasContext) e).getContext().getResources().getDimensionPixelOffset(2131427394));
        }
        badgeTextView.setOnClickListener(state.f1841c);
    }
}
