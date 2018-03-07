package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
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
import com.facebook.pages.common.reaction.ui.PageOpenHoursComponentView;
import com.facebook.pages.common.reaction.ui.PageOpenHoursComponentView.C02791;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: setAppAttribution */
public class PageOpenHoursUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PageOpenHoursComponentView> {
    public static final ViewType f1988a = new C02581();
    private static PageOpenHoursUnitComponentPartDefinition f1989c;
    private static final Object f1990d = new Object();
    private final PagesSurfaceReactionHelper<E> f1991b;

    /* compiled from: setAppAttribution */
    final class C02581 extends ViewType {
        C02581() {
        }

        public final View m3029a(Context context) {
            return new PageOpenHoursComponentView(context);
        }
    }

    /* compiled from: setAppAttribution */
    public /* synthetic */ class C02592 {
        public static final /* synthetic */ int[] f1983a = new int[GraphQLPageOpenHoursDisplayDecisionEnum.values().length];

        static {
            try {
                f1983a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1983a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1983a[GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNDETERMINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: setAppAttribution */
    public class State {
        public final OnClickListener f1984a;
        public final String f1985b;
        public final String f1986c;
        public final GraphQLPageOpenHoursDisplayDecisionEnum f1987d;

        public State(String str, String str2, GraphQLPageOpenHoursDisplayDecisionEnum graphQLPageOpenHoursDisplayDecisionEnum, OnClickListener onClickListener) {
            this.f1985b = str;
            this.f1986c = str2;
            this.f1987d = graphQLPageOpenHoursDisplayDecisionEnum;
            this.f1984a = onClickListener;
        }
    }

    private static PageOpenHoursUnitComponentPartDefinition m3031b(InjectorLike injectorLike) {
        return new PageOpenHoursUnitComponentPartDefinition(PagesSurfaceReactionHelper.m3150a(injectorLike));
    }

    public final Object m3033a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String a;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        String a2 = reactionUnitComponentFields.bv().a();
        if (reactionUnitComponentFields.cG() != null) {
            a = reactionUnitComponentFields.cG().a();
        } else {
            a = null;
        }
        return new State(a2, a, reactionUnitComponentFields.aq(), this.f1991b.m3152a(reactionUnitComponentFields.v(), canLaunchReactionIntent, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
    }

    public final /* bridge */ /* synthetic */ void m3034a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1910808470);
        State state = (State) obj2;
        PageOpenHoursComponentView pageOpenHoursComponentView = (PageOpenHoursComponentView) view;
        CharSequence charSequence = state.f1985b;
        CharSequence charSequence2 = state.f1986c;
        GraphQLPageOpenHoursDisplayDecisionEnum graphQLPageOpenHoursDisplayDecisionEnum = state.f1987d;
        Resources resources = pageOpenHoursComponentView.getResources();
        pageOpenHoursComponentView.f2212c.setText(charSequence);
        switch (C02791.f2209a[graphQLPageOpenHoursDisplayDecisionEnum.ordinal()]) {
            case 1:
                pageOpenHoursComponentView.f2212c.setTextColor(resources.getColor(2131362986));
                break;
            case 2:
                pageOpenHoursComponentView.f2212c.setTextColor(resources.getColor(2131362987));
                break;
            case 3:
                pageOpenHoursComponentView.f2212c.setTextColor(resources.getColor(2131362988));
                break;
            default:
                Preconditions.checkState(false, "This shouldn't be hit as the calling part definition ensures it");
                break;
        }
        if (charSequence2 != null) {
            pageOpenHoursComponentView.f2213d.setVisibility(0);
            pageOpenHoursComponentView.f2213d.setText(charSequence2);
        } else {
            pageOpenHoursComponentView.f2213d.setVisibility(8);
        }
        pageOpenHoursComponentView.setOnClickListener(state.f1984a);
        Logger.a(8, EntryType.MARK_POP, 1879745792, a);
    }

    public final boolean m3035a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        if (!(reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a()))) {
            Object obj2;
            switch (C02592.f1983a[reactionUnitComponentFields.aq().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public final void m3036b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((PageOpenHoursComponentView) view).setOnClickListener(null);
    }

    public final ViewType m3032a() {
        return f1988a;
    }

    public static PageOpenHoursUnitComponentPartDefinition m3030a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageOpenHoursUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1990d) {
                PageOpenHoursUnitComponentPartDefinition pageOpenHoursUnitComponentPartDefinition;
                if (a2 != null) {
                    pageOpenHoursUnitComponentPartDefinition = (PageOpenHoursUnitComponentPartDefinition) a2.a(f1990d);
                } else {
                    pageOpenHoursUnitComponentPartDefinition = f1989c;
                }
                if (pageOpenHoursUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3031b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1990d, b3);
                        } else {
                            f1989c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageOpenHoursUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageOpenHoursUnitComponentPartDefinition(PagesSurfaceReactionHelper pagesSurfaceReactionHelper) {
        this.f1991b = pagesSurfaceReactionHelper;
    }
}
