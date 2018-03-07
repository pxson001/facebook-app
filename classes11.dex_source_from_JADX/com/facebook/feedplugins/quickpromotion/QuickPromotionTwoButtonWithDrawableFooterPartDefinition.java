package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.TwoButtonWithDrawableFooterView;
import com.facebook.feedplugins.base.footer.ui.TwoButtonWithDrawableFooterView.Button;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonGlyph;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonStyle;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.SecondaryActionButtonGlyph;
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
/* compiled from: card_title */
public class QuickPromotionTwoButtonWithDrawableFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLQuickPromotionFeedUnit, State, HasPositionInformation, TwoButtonWithDrawableFooterView> {
    public static final ViewType f8994a = new C10911();
    public static final Button f8995b = Button.RIGHT;
    public static final Button f8996c = Button.LEFT;
    private static QuickPromotionTwoButtonWithDrawableFooterPartDefinition f8997j;
    private static final Object f8998k = new Object();
    private final OneButtonFooterStylerPartDefinition f8999d;
    public final DefaultQuickPromotionActionHandler f9000e;
    public final Lazy<QuickPromotionLogger> f9001f;
    private final ClickListenerPartDefinition f9002g;
    private final ClickListenerPartDefinition f9003h;
    public final GlyphColorizer f9004i;

    /* compiled from: card_title */
    final class C10911 extends ViewType {
        C10911() {
        }

        public final View m9699a(Context context) {
            return new TwoButtonWithDrawableFooterView(context);
        }
    }

    /* compiled from: card_title */
    public class State {
        public final String f8989a;
        public final String f8990b;
        public final PrimaryActionButtonGlyph f8991c;
        public final SecondaryActionButtonGlyph f8992d;
        public final PrimaryActionButtonStyle f8993e;

        public State(String str, String str2, PrimaryActionButtonGlyph primaryActionButtonGlyph, SecondaryActionButtonGlyph secondaryActionButtonGlyph, PrimaryActionButtonStyle primaryActionButtonStyle) {
            this.f8989a = str;
            this.f8990b = str2;
            this.f8991c = primaryActionButtonGlyph;
            this.f8992d = secondaryActionButtonGlyph;
            this.f8993e = primaryActionButtonStyle;
        }
    }

    private static QuickPromotionTwoButtonWithDrawableFooterPartDefinition m9702b(InjectorLike injectorLike) {
        return new QuickPromotionTwoButtonWithDrawableFooterPartDefinition(OneButtonFooterStylerPartDefinition.a(injectorLike), DefaultQuickPromotionActionHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 3239), ClickListenerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m9704a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        subParts.a(this.f8999d, null);
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        String a = c.p().a().a();
        String a2 = c.q().a().a();
        if (b != null) {
            subParts.a(2131568144, this.f9002g, m9700a(b.k(), c.p(), ActionType.PRIMARY_ACTION));
            subParts.a(2131568143, this.f9003h, m9700a(b.k(), c.q(), ActionType.SECONDARY_ACTION));
        }
        PrimaryActionButtonGlyph primaryActionButtonGlyph = PrimaryActionButtonGlyph.UNKNOWN;
        SecondaryActionButtonGlyph secondaryActionButtonGlyph = SecondaryActionButtonGlyph.UNKNOWN;
        PrimaryActionButtonStyle primaryActionButtonStyle = PrimaryActionButtonStyle.UNKNOWN;
        if (!(b == null || b.l() == null || b.l().j() == null)) {
            primaryActionButtonGlyph = QuickPromotionFeedUnitUtils.m9629c(b.l().j());
            secondaryActionButtonGlyph = QuickPromotionFeedUnitUtils.m9630d(b.l().j());
            primaryActionButtonStyle = QuickPromotionFeedUnitUtils.m9631f(b.l().j());
        }
        return new State(a, a2, primaryActionButtonGlyph, secondaryActionButtonGlyph, primaryActionButtonStyle);
    }

    public final /* bridge */ /* synthetic */ void m9705a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int a = Logger.a(8, EntryType.MARK_PUSH, 506408771);
        State state = (State) obj2;
        TwoButtonWithDrawableFooterView twoButtonWithDrawableFooterView = (TwoButtonWithDrawableFooterView) view;
        CharSequence charSequence = state.f8990b;
        SecondaryActionButtonGlyph secondaryActionButtonGlyph = state.f8992d;
        twoButtonWithDrawableFooterView.a(f8996c, charSequence);
        if (secondaryActionButtonGlyph == SecondaryActionButtonGlyph.DISCLOSURE) {
            twoButtonWithDrawableFooterView.a(f8996c, this.f9004i.a(2130838066, -7235677));
        } else if (secondaryActionButtonGlyph == SecondaryActionButtonGlyph.SHARE) {
            twoButtonWithDrawableFooterView.b(f8996c, this.f9004i.a(2130840098, -7235677));
        }
        charSequence = state.f8989a;
        PrimaryActionButtonGlyph primaryActionButtonGlyph = state.f8991c;
        PrimaryActionButtonStyle primaryActionButtonStyle = state.f8993e;
        twoButtonWithDrawableFooterView.a(f8995b, charSequence);
        if (primaryActionButtonStyle == PrimaryActionButtonStyle.PRIMARY) {
            i = -10972929;
            twoButtonWithDrawableFooterView.a(f8995b, 2131361917);
        } else {
            i = -7235677;
            twoButtonWithDrawableFooterView.a(f8995b, 2131361974);
        }
        if (primaryActionButtonGlyph == PrimaryActionButtonGlyph.DISCLOSURE) {
            twoButtonWithDrawableFooterView.a(f8995b, this.f9004i.a(2130838066, i));
        } else if (primaryActionButtonGlyph == PrimaryActionButtonGlyph.SHARE) {
            twoButtonWithDrawableFooterView.b(f8995b, this.f9004i.a(2130840098, i));
        }
        Logger.a(8, EntryType.MARK_POP, -2023530079, a);
    }

    public final boolean m9706a(Object obj) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        if (graphQLQuickPromotionFeedUnit == null) {
            return false;
        }
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        if (!QuickPromotionFeedUnitUtils.m9627b(QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit)) || b == null || b.l() == null || b.l().j() == null) {
            return false;
        }
        if (QuickPromotionFeedUnitUtils.m9629c(b.l().j()) == PrimaryActionButtonGlyph.UNKNOWN && QuickPromotionFeedUnitUtils.m9630d(b.l().j()) == SecondaryActionButtonGlyph.UNKNOWN) {
            return false;
        }
        return true;
    }

    public final void m9707b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TwoButtonWithDrawableFooterView twoButtonWithDrawableFooterView = (TwoButtonWithDrawableFooterView) view;
        twoButtonWithDrawableFooterView.a(f8995b, null);
        twoButtonWithDrawableFooterView.a(f8996c, null);
        twoButtonWithDrawableFooterView.a(f8995b, null);
        twoButtonWithDrawableFooterView.a(f8996c, null);
        twoButtonWithDrawableFooterView.b(f8995b, null);
        twoButtonWithDrawableFooterView.b(f8996c, null);
        twoButtonWithDrawableFooterView.a(f8995b, 2131361974);
    }

    public static QuickPromotionTwoButtonWithDrawableFooterPartDefinition m9701a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionTwoButtonWithDrawableFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8998k) {
                QuickPromotionTwoButtonWithDrawableFooterPartDefinition quickPromotionTwoButtonWithDrawableFooterPartDefinition;
                if (a2 != null) {
                    quickPromotionTwoButtonWithDrawableFooterPartDefinition = (QuickPromotionTwoButtonWithDrawableFooterPartDefinition) a2.a(f8998k);
                } else {
                    quickPromotionTwoButtonWithDrawableFooterPartDefinition = f8997j;
                }
                if (quickPromotionTwoButtonWithDrawableFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9702b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8998k, b3);
                        } else {
                            f8997j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionTwoButtonWithDrawableFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuickPromotionTwoButtonWithDrawableFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, QuickPromotionActionHandler quickPromotionActionHandler, Lazy<QuickPromotionLogger> lazy, ClickListenerPartDefinition clickListenerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition2, GlyphColorizer glyphColorizer) {
        this.f8999d = oneButtonFooterStylerPartDefinition;
        this.f9000e = quickPromotionActionHandler;
        this.f9001f = lazy;
        this.f9002g = clickListenerPartDefinition;
        this.f9003h = clickListenerPartDefinition2;
        this.f9004i = glyphColorizer;
    }

    public final ViewType m9703a() {
        return f8994a;
    }

    private OnClickListener m9700a(final String str, final GraphQLQuickPromotionAction graphQLQuickPromotionAction, final ActionType actionType) {
        return new OnClickListener(this) {
            final /* synthetic */ QuickPromotionTwoButtonWithDrawableFooterPartDefinition f8988d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -822370967);
                this.f8988d.f9000e.a(Uri.parse(graphQLQuickPromotionAction.j()));
                ((QuickPromotionLogger) this.f8988d.f9001f.get()).a(actionType, str);
                Logger.a(2, EntryType.UI_INPUT_END, 220057552, a);
            }
        };
    }
}
