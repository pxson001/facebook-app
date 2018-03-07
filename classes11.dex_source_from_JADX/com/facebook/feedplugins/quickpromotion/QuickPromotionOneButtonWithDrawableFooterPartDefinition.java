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
import com.facebook.feedplugins.base.footer.ui.OneButtonWithDrawableFooterView;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonGlyph;
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
/* compiled from: category_search_time_to_interaction */
public class QuickPromotionOneButtonWithDrawableFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLQuickPromotionFeedUnit, State, HasPositionInformation, OneButtonWithDrawableFooterView> {
    public static final ViewType f8936a = new C10851();
    private static QuickPromotionOneButtonWithDrawableFooterPartDefinition f8937g;
    private static final Object f8938h = new Object();
    private final OneButtonFooterStylerPartDefinition f8939b;
    public final DefaultQuickPromotionActionHandler f8940c;
    public final Lazy<QuickPromotionLogger> f8941d;
    private final ClickListenerPartDefinition f8942e;
    public final GlyphColorizer f8943f;

    /* compiled from: category_search_time_to_interaction */
    final class C10851 extends ViewType {
        C10851() {
        }

        public final View m9660a(Context context) {
            return new OneButtonWithDrawableFooterView(context);
        }
    }

    /* compiled from: category_search_time_to_interaction */
    public class State {
        public final String f8933a;
        public PrimaryActionButtonStyle f8934b;
        public PrimaryActionButtonGlyph f8935c;

        public State(String str, PrimaryActionButtonStyle primaryActionButtonStyle, PrimaryActionButtonGlyph primaryActionButtonGlyph) {
            this.f8933a = str;
            this.f8934b = primaryActionButtonStyle;
            this.f8935c = primaryActionButtonGlyph;
        }
    }

    private static QuickPromotionOneButtonWithDrawableFooterPartDefinition m9662b(InjectorLike injectorLike) {
        return new QuickPromotionOneButtonWithDrawableFooterPartDefinition(OneButtonFooterStylerPartDefinition.a(injectorLike), DefaultQuickPromotionActionHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 3239), ClickListenerPartDefinition.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m9664a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        final GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        final GraphQLQuickPromotionAction p = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit).p();
        subParts.a(this.f8939b, null);
        subParts.a(this.f8942e, new OnClickListener(this) {
            final /* synthetic */ QuickPromotionOneButtonWithDrawableFooterPartDefinition f8932c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1975339704);
                this.f8932c.f8940c.a(Uri.parse(p.j()));
                ((QuickPromotionLogger) this.f8932c.f8941d.get()).a(ActionType.PRIMARY_ACTION, b.k());
                Logger.a(2, EntryType.UI_INPUT_END, -1390990953, a);
            }
        });
        return new State(p.a().a(), QuickPromotionFeedUnitUtils.m9631f(b.l().j()), QuickPromotionFeedUnitUtils.m9629c(b.l().j()));
    }

    public final /* bridge */ /* synthetic */ void m9665a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1709975169);
        State state = (State) obj2;
        OneButtonWithDrawableFooterView oneButtonWithDrawableFooterView = (OneButtonWithDrawableFooterView) view;
        oneButtonWithDrawableFooterView.setFooterText(state.f8933a);
        GlyphColorizer glyphColorizer;
        if (state.f8934b == PrimaryActionButtonStyle.PRIMARY) {
            if (state.f8935c == PrimaryActionButtonGlyph.DISCLOSURE) {
                glyphColorizer = this.f8943f;
                oneButtonWithDrawableFooterView.a.setTextColor(oneButtonWithDrawableFooterView.getResources().getColor(2131361917));
                oneButtonWithDrawableFooterView.c.setImageDrawable(glyphColorizer.a(2130838066, -10972929));
                oneButtonWithDrawableFooterView.c.setVisibility(0);
            } else if (state.f8935c == PrimaryActionButtonGlyph.SHARE) {
                glyphColorizer = this.f8943f;
                oneButtonWithDrawableFooterView.a.setTextColor(oneButtonWithDrawableFooterView.getResources().getColor(2131361917));
                oneButtonWithDrawableFooterView.b.setImageDrawable(glyphColorizer.a(2130840098, -10972929));
                oneButtonWithDrawableFooterView.b.setVisibility(0);
            }
        } else if (state.f8935c == PrimaryActionButtonGlyph.DISCLOSURE) {
            glyphColorizer = this.f8943f;
            oneButtonWithDrawableFooterView.a.setTextColor(oneButtonWithDrawableFooterView.getResources().getColor(2131361974));
            oneButtonWithDrawableFooterView.c.setImageDrawable(glyphColorizer.a(2130838066, -7235677));
            oneButtonWithDrawableFooterView.c.setVisibility(0);
        } else if (state.f8935c == PrimaryActionButtonGlyph.SHARE) {
            glyphColorizer = this.f8943f;
            oneButtonWithDrawableFooterView.a.setTextColor(oneButtonWithDrawableFooterView.getResources().getColor(2131361974));
            oneButtonWithDrawableFooterView.b.setImageDrawable(glyphColorizer.a(2130840098, -7235677));
            oneButtonWithDrawableFooterView.b.setVisibility(0);
        }
        Logger.a(8, EntryType.MARK_POP, 395485295, a);
    }

    public final boolean m9666a(Object obj) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        if (graphQLQuickPromotionFeedUnit == null) {
            return false;
        }
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        if (QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit) == null || b == null || b.l() == null || !QuickPromotionFeedUnitUtils.m9624a(c) || QuickPromotionFeedUnitUtils.m9629c(b.l().j()) == PrimaryActionButtonGlyph.UNKNOWN) {
            return false;
        }
        return true;
    }

    public final void m9667b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        OneButtonWithDrawableFooterView oneButtonWithDrawableFooterView = (OneButtonWithDrawableFooterView) view;
        oneButtonWithDrawableFooterView.setFooterText(null);
        GlyphColorizer glyphColorizer = this.f8943f;
        oneButtonWithDrawableFooterView.a.setTextColor(oneButtonWithDrawableFooterView.getResources().getColor(2131361974));
        oneButtonWithDrawableFooterView.b.setImageDrawable(glyphColorizer.a(2130840098, -7235677));
        oneButtonWithDrawableFooterView.c.setImageDrawable(glyphColorizer.a(2130838066, -7235677));
        oneButtonWithDrawableFooterView.b.setVisibility(8);
        oneButtonWithDrawableFooterView.c.setVisibility(8);
    }

    @Inject
    public QuickPromotionOneButtonWithDrawableFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, QuickPromotionActionHandler quickPromotionActionHandler, Lazy<QuickPromotionLogger> lazy, ClickListenerPartDefinition clickListenerPartDefinition, GlyphColorizer glyphColorizer) {
        this.f8939b = oneButtonFooterStylerPartDefinition;
        this.f8940c = quickPromotionActionHandler;
        this.f8941d = lazy;
        this.f8942e = clickListenerPartDefinition;
        this.f8943f = glyphColorizer;
    }

    public static QuickPromotionOneButtonWithDrawableFooterPartDefinition m9661a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionOneButtonWithDrawableFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8938h) {
                QuickPromotionOneButtonWithDrawableFooterPartDefinition quickPromotionOneButtonWithDrawableFooterPartDefinition;
                if (a2 != null) {
                    quickPromotionOneButtonWithDrawableFooterPartDefinition = (QuickPromotionOneButtonWithDrawableFooterPartDefinition) a2.a(f8938h);
                } else {
                    quickPromotionOneButtonWithDrawableFooterPartDefinition = f8937g;
                }
                if (quickPromotionOneButtonWithDrawableFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9662b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8938h, b3);
                        } else {
                            f8937g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionOneButtonWithDrawableFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9663a() {
        return f8936a;
    }
}
