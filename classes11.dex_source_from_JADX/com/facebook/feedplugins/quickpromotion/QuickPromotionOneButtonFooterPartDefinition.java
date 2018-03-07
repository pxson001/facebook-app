package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonStyle;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionAction;
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
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;
import com.facebook.quickpromotion.action.QuickPromotionActionHandler;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.logger.QuickPromotionLogger.ActionType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: category_selected */
public final class QuickPromotionOneButtonFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLQuickPromotionFeedUnit, Void, HasPositionInformation, View> {
    public static final ViewType f8921a = ViewType.a(2130906552);
    private static QuickPromotionOneButtonFooterPartDefinition f8922h;
    private static final Object f8923i = new Object();
    private final OneButtonFooterStylerPartDefinition f8924b;
    public final DefaultQuickPromotionActionHandler f8925c;
    public final Lazy<QuickPromotionLogger> f8926d;
    private final ClickListenerPartDefinition f8927e;
    private final TextPartDefinition f8928f;
    private final TextAppearancePartDefinition f8929g;

    private static QuickPromotionOneButtonFooterPartDefinition m9656b(InjectorLike injectorLike) {
        return new QuickPromotionOneButtonFooterPartDefinition(OneButtonFooterStylerPartDefinition.a(injectorLike), DefaultQuickPromotionActionHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 3239), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextAppearancePartDefinition.a(injectorLike));
    }

    public final Object m9658a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) obj;
        final GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        final GraphQLQuickPromotionAction p = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit).p();
        subParts.a(this.f8924b, null);
        subParts.a(2131559974, this.f8928f, p.a().a());
        subParts.a(this.f8927e, new OnClickListener(this) {
            final /* synthetic */ QuickPromotionOneButtonFooterPartDefinition f8919c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1948075765);
                this.f8919c.f8925c.a(Uri.parse(p.j()));
                ((QuickPromotionLogger) this.f8919c.f8926d.get()).a(ActionType.PRIMARY_ACTION, b.k());
                Logger.a(2, EntryType.UI_INPUT_END, -175415852, a);
            }
        });
        PrimaryActionButtonStyle primaryActionButtonStyle = PrimaryActionButtonStyle.UNKNOWN;
        if (!(b == null || b.l() == null || b.l().j() == null)) {
            primaryActionButtonStyle = QuickPromotionFeedUnitUtils.m9631f(b.l().j());
        }
        switch (primaryActionButtonStyle) {
            case PRIMARY:
                subParts.a(2131559974, this.f8929g, Integer.valueOf(2131626699));
                break;
            default:
                subParts.a(2131559974, this.f8929g, Integer.valueOf(2131626700));
                break;
        }
        return null;
    }

    public final boolean m9659a(Object obj) {
        return QuickPromotionFeedUnitUtils.m9624a(QuickPromotionFeedUnitHelper.c((GraphQLQuickPromotionFeedUnit) obj));
    }

    @Inject
    public QuickPromotionOneButtonFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, QuickPromotionActionHandler quickPromotionActionHandler, Lazy<QuickPromotionLogger> lazy, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition) {
        this.f8924b = oneButtonFooterStylerPartDefinition;
        this.f8925c = quickPromotionActionHandler;
        this.f8926d = lazy;
        this.f8927e = clickListenerPartDefinition;
        this.f8928f = textPartDefinition;
        this.f8929g = textAppearancePartDefinition;
    }

    public static QuickPromotionOneButtonFooterPartDefinition m9655a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionOneButtonFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8923i) {
                QuickPromotionOneButtonFooterPartDefinition quickPromotionOneButtonFooterPartDefinition;
                if (a2 != null) {
                    quickPromotionOneButtonFooterPartDefinition = (QuickPromotionOneButtonFooterPartDefinition) a2.a(f8923i);
                } else {
                    quickPromotionOneButtonFooterPartDefinition = f8922h;
                }
                if (quickPromotionOneButtonFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9656b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8923i, b3);
                        } else {
                            f8922h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionOneButtonFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9657a() {
        return f8921a;
    }
}
