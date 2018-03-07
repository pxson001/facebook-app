package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
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
import com.facebook.pages.common.reaction.ui.PageInsightsOverviewCardMetricComponentView;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.resources.ui.FbTextView;

@ContextScoped
/* compiled from: setDrawerElevation */
public class PageInsightsOverviewCardMetricUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageInsightsOverviewCardMetricComponentView> {
    public static final ViewType f1953a = new C02551();
    private static PageInsightsOverviewCardMetricUnitComponentPartDefinition f1954b;
    private static final Object f1955c = new Object();

    /* compiled from: setDrawerElevation */
    final class C02551 extends ViewType {
        C02551() {
        }

        public final View m3000a(Context context) {
            return new PageInsightsOverviewCardMetricComponentView(context);
        }
    }

    /* compiled from: setDrawerElevation */
    public class State {
        public final String f1950a;
        public final String f1951b;
        public final String f1952c;

        public State(String str, String str2, String str3) {
            this.f1950a = str;
            this.f1951b = str2;
            this.f1952c = str3;
        }
    }

    private static PageInsightsOverviewCardMetricUnitComponentPartDefinition m3003b() {
        return new PageInsightsOverviewCardMetricUnitComponentPartDefinition();
    }

    public final Object m3005a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        return new State(reactionUnitComponentFields.cG().a(), reactionUnitComponentFields.bv().a(), reactionUnitComponentFields.v().fU_().a());
    }

    public final /* bridge */ /* synthetic */ void m3006a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -495950072);
        m3002a((State) obj2, (PageInsightsOverviewCardMetricComponentView) view);
        Logger.a(8, EntryType.MARK_POP, 454128646, a);
    }

    public final boolean m3007a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return (reactionUnitComponentNode == null || reactionUnitComponentNode.b == null || reactionUnitComponentNode.b.cG() == null || reactionUnitComponentNode.b.bv() == null || reactionUnitComponentNode.b.v() == null || reactionUnitComponentNode.b.v().fU_() == null || StringUtil.a(reactionUnitComponentNode.b.v().fU_().a())) ? false : true;
    }

    public final /* bridge */ /* synthetic */ void m3008b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
    }

    public final ViewType m3004a() {
        return f1953a;
    }

    public static PageInsightsOverviewCardMetricUnitComponentPartDefinition m3001a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageInsightsOverviewCardMetricUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1955c) {
                PageInsightsOverviewCardMetricUnitComponentPartDefinition pageInsightsOverviewCardMetricUnitComponentPartDefinition;
                if (a2 != null) {
                    pageInsightsOverviewCardMetricUnitComponentPartDefinition = (PageInsightsOverviewCardMetricUnitComponentPartDefinition) a2.a(f1955c);
                } else {
                    pageInsightsOverviewCardMetricUnitComponentPartDefinition = f1954b;
                }
                if (pageInsightsOverviewCardMetricUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m3003b();
                        if (a2 != null) {
                            a2.a(f1955c, b3);
                        } else {
                            f1954b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageInsightsOverviewCardMetricUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m3002a(State state, PageInsightsOverviewCardMetricComponentView pageInsightsOverviewCardMetricComponentView) {
        CharSequence charSequence = state.f1950a;
        CharSequence charSequence2 = state.f1951b;
        String str = state.f1952c;
        pageInsightsOverviewCardMetricComponentView.f2173b.setText(charSequence);
        pageInsightsOverviewCardMetricComponentView.f2174c.setText(charSequence2);
        pageInsightsOverviewCardMetricComponentView.f2175d.setText(str);
        boolean startsWith = str.startsWith("-");
        boolean startsWith2 = str.startsWith("0");
        int color = pageInsightsOverviewCardMetricComponentView.getResources().getColor(startsWith ? 2131361918 : 2131361919);
        pageInsightsOverviewCardMetricComponentView.f2175d.setTextColor(color);
        Drawable a = startsWith ? pageInsightsOverviewCardMetricComponentView.f2172a.a(2130843760, color) : pageInsightsOverviewCardMetricComponentView.f2172a.a(2130840137, color);
        a.setBounds(0, 0, a.getIntrinsicHeight(), a.getIntrinsicHeight());
        FbTextView fbTextView = pageInsightsOverviewCardMetricComponentView.f2175d;
        if (startsWith2) {
            a = null;
        }
        fbTextView.setCompoundDrawables(a, null, null, null);
    }
}
