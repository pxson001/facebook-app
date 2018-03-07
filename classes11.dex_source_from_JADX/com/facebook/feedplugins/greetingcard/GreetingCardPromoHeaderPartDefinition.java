package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
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
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import javax.inject.Inject;

@ContextScoped
/* compiled from: deduplicated_email_address */
public class GreetingCardPromoHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGreetingCardPromotionFeedUnit>, Drawable, E, GreetingCardPromoHeaderView> {
    public static final ViewType f7730a = new C09841();
    private static GreetingCardPromoHeaderPartDefinition f7731f;
    private static final Object f7732g = new Object();
    private final BackgroundPartDefinition f7733b;
    private final MenuButtonPartDefinition f7734c;
    private final DefaultPrivacyScopeResourceResolver f7735d;
    private final GlyphColorizer f7736e;

    /* compiled from: deduplicated_email_address */
    final class C09841 extends ViewType {
        C09841() {
        }

        public final View m8912a(Context context) {
            return new GreetingCardPromoHeaderView(context);
        }
    }

    private static GreetingCardPromoHeaderPartDefinition m8914b(InjectorLike injectorLike) {
        return new GreetingCardPromoHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), DefaultPrivacyScopeResourceResolver.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final Object m8916a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = (GraphQLGreetingCardPromotionFeedUnit) feedProps.a;
        subParts.a(this.f7733b, new StylingData(feedProps, PaddingStyle.i));
        subParts.a(2131562614, this.f7734c, new Props(feedProps, MenuConfig.CLICKABLE));
        return this.f7736e.a(this.f7735d.a(graphQLGreetingCardPromotionFeedUnit.m().s()), -7235677);
    }

    public final /* bridge */ /* synthetic */ void m8917a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1297823534);
        Drawable drawable = (Drawable) obj2;
        GreetingCardPromoHeaderView greetingCardPromoHeaderView = (GreetingCardPromoHeaderView) view;
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = (GraphQLGreetingCardPromotionFeedUnit) ((FeedProps) obj).a;
        greetingCardPromoHeaderView.f7738b.setText(graphQLGreetingCardPromotionFeedUnit.v().a());
        greetingCardPromoHeaderView.f7739c.setText(graphQLGreetingCardPromotionFeedUnit.u().a());
        greetingCardPromoHeaderView.f7740d.setText(graphQLGreetingCardPromotionFeedUnit.m().j());
        greetingCardPromoHeaderView.f7740d.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        Logger.a(8, EntryType.MARK_POP, -11744643, a);
    }

    @Inject
    public GreetingCardPromoHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GlyphColorizer glyphColorizer) {
        this.f7733b = backgroundPartDefinition;
        this.f7734c = menuButtonPartDefinition;
        this.f7735d = defaultPrivacyScopeResourceResolver;
        this.f7736e = glyphColorizer;
    }

    public static GreetingCardPromoHeaderPartDefinition m8913a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7732g) {
                GreetingCardPromoHeaderPartDefinition greetingCardPromoHeaderPartDefinition;
                if (a2 != null) {
                    greetingCardPromoHeaderPartDefinition = (GreetingCardPromoHeaderPartDefinition) a2.a(f7732g);
                } else {
                    greetingCardPromoHeaderPartDefinition = f7731f;
                }
                if (greetingCardPromoHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8914b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7732g, b3);
                        } else {
                            f7731f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m8915a() {
        return f7730a;
    }

    public final boolean m8918a(Object obj) {
        return true;
    }
}
