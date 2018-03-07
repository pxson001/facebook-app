package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView.Button;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonStyle;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionAction;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;
import com.facebook.quickpromotion.action.QuickPromotionActionHandler;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.logger.QuickPromotionLogger.ActionType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: carmeraRollPhotoUploaded */
public class QuickPromotionTwoButtonFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLQuickPromotionFeedUnit, State, HasPositionInformation, TwoButtonFooterView> {
    public static final Button f8976a = Button.RIGHT;
    public static final Button f8977b = Button.LEFT;
    private static QuickPromotionTwoButtonFooterPartDefinition f8978h;
    private static final Object f8979i = new Object();
    private final OneButtonFooterStylerPartDefinition f8980c;
    public final DefaultQuickPromotionActionHandler f8981d;
    public final Lazy<QuickPromotionLogger> f8982e;
    private final ClickListenerPartDefinition f8983f;
    private final ClickListenerPartDefinition f8984g;

    /* compiled from: carmeraRollPhotoUploaded */
    public class State {
        public final GraphQLQuickPromotion f8973a;
        public final GraphQLQuickPromotionCreative f8974b;
        public PrimaryActionButtonStyle f8975c;

        public State(GraphQLQuickPromotion graphQLQuickPromotion, GraphQLQuickPromotionCreative graphQLQuickPromotionCreative, PrimaryActionButtonStyle primaryActionButtonStyle) {
            this.f8973a = graphQLQuickPromotion;
            this.f8974b = graphQLQuickPromotionCreative;
            this.f8975c = primaryActionButtonStyle;
        }
    }

    private static QuickPromotionTwoButtonFooterPartDefinition m9693b(InjectorLike injectorLike) {
        return new QuickPromotionTwoButtonFooterPartDefinition(OneButtonFooterStylerPartDefinition.a(injectorLike), DefaultQuickPromotionActionHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 3239), ClickListenerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m9695a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        subParts.a(this.f8980c, null);
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        subParts.a(2131568143, this.f8984g, m9691a(b.k(), c.q(), ActionType.SECONDARY_ACTION));
        subParts.a(2131568144, this.f8983f, m9691a(b.k(), c.p(), ActionType.PRIMARY_ACTION));
        PrimaryActionButtonStyle primaryActionButtonStyle = PrimaryActionButtonStyle.UNKNOWN;
        if (!(b == null || b.l() == null || b.l().j() == null)) {
            primaryActionButtonStyle = QuickPromotionFeedUnitUtils.m9631f(b.l().j());
        }
        return new State(b, c, primaryActionButtonStyle);
    }

    public final /* bridge */ /* synthetic */ void m9696a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1277614436);
        State state = (State) obj2;
        TwoButtonFooterView twoButtonFooterView = (TwoButtonFooterView) view;
        twoButtonFooterView.a(f8977b, state.f8974b.q().a().a());
        twoButtonFooterView.a(f8976a, state.f8974b.p().a().a());
        switch (state.f8975c) {
            case PRIMARY:
                twoButtonFooterView.b(f8976a, 2131361917);
                break;
        }
        Logger.a(8, EntryType.MARK_POP, -663687918, a);
    }

    public final boolean m9697a(Object obj) {
        return QuickPromotionFeedUnitUtils.m9627b(QuickPromotionFeedUnitHelper.c((GraphQLQuickPromotionFeedUnit) obj));
    }

    public final void m9698b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TwoButtonFooterView twoButtonFooterView = (TwoButtonFooterView) view;
        twoButtonFooterView.a(f8976a, null);
        twoButtonFooterView.b(f8976a, 2131361937);
        twoButtonFooterView.a(f8977b, null);
    }

    public static QuickPromotionTwoButtonFooterPartDefinition m9692a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionTwoButtonFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8979i) {
                QuickPromotionTwoButtonFooterPartDefinition quickPromotionTwoButtonFooterPartDefinition;
                if (a2 != null) {
                    quickPromotionTwoButtonFooterPartDefinition = (QuickPromotionTwoButtonFooterPartDefinition) a2.a(f8979i);
                } else {
                    quickPromotionTwoButtonFooterPartDefinition = f8978h;
                }
                if (quickPromotionTwoButtonFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9693b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8979i, b3);
                        } else {
                            f8978h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionTwoButtonFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuickPromotionTwoButtonFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, QuickPromotionActionHandler quickPromotionActionHandler, Lazy<QuickPromotionLogger> lazy, ClickListenerPartDefinition clickListenerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition2) {
        this.f8980c = oneButtonFooterStylerPartDefinition;
        this.f8981d = quickPromotionActionHandler;
        this.f8982e = lazy;
        this.f8983f = clickListenerPartDefinition;
        this.f8984g = clickListenerPartDefinition2;
    }

    public final ViewType m9694a() {
        return TwoButtonFooterView.a;
    }

    private OnClickListener m9691a(final String str, final GraphQLQuickPromotionAction graphQLQuickPromotionAction, final ActionType actionType) {
        return new OnClickListener(this) {
            final /* synthetic */ QuickPromotionTwoButtonFooterPartDefinition f8971d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 205677272);
                this.f8971d.f8981d.a(Uri.parse(graphQLQuickPromotionAction.j()));
                ((QuickPromotionLogger) this.f8971d.f8982e.get()).a(actionType, str);
                Logger.a(2, EntryType.UI_INPUT_END, -1692623857, a);
            }
        };
    }
}
