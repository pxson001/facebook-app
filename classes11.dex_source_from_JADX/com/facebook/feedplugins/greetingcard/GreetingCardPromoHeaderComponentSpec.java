package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.graphics.Typeface;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Container;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.HeaderMenuComponentLayouts;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.ui.api.FeedMenuHelper;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: deep_link */
public class GreetingCardPromoHeaderComponentSpec {
    private static GreetingCardPromoHeaderComponentSpec f7725d;
    private static final Object f7726e = new Object();
    private final HeaderMenuComponentLayouts f7727a;
    private final DefaultPrivacyScopeResourceResolver f7728b;
    private final GlyphColorizerDrawableReference f7729c;

    private static GreetingCardPromoHeaderComponentSpec m8910b(InjectorLike injectorLike) {
        return new GreetingCardPromoHeaderComponentSpec(HeaderMenuComponentLayouts.b(injectorLike), DefaultPrivacyScopeResourceResolver.a(injectorLike), GlyphColorizerDrawableReference.a(injectorLike));
    }

    @Inject
    public GreetingCardPromoHeaderComponentSpec(HeaderMenuComponentLayouts headerMenuComponentLayouts, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GlyphColorizerDrawableReference glyphColorizerDrawableReference) {
        this.f7727a = headerMenuComponentLayouts;
        this.f7728b = defaultPrivacyScopeResourceResolver;
        this.f7729c = glyphColorizerDrawableReference;
    }

    public static GreetingCardPromoHeaderComponentSpec m8909a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7726e) {
                GreetingCardPromoHeaderComponentSpec greetingCardPromoHeaderComponentSpec;
                if (a2 != null) {
                    greetingCardPromoHeaderComponentSpec = (GreetingCardPromoHeaderComponentSpec) a2.a(f7726e);
                } else {
                    greetingCardPromoHeaderComponentSpec = f7725d;
                }
                if (greetingCardPromoHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8910b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7726e, b3);
                        } else {
                            f7725d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ComponentLayout m8911a(ComponentContext componentContext, FeedProps<GraphQLGreetingCardPromotionFeedUnit> feedProps, FeedMenuHelper feedMenuHelper) {
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = (GraphQLGreetingCardPromotionFeedUnit) feedProps.a;
        return Container.a(componentContext).C(2).E(1).a(Container.a(componentContext).b(1.0f).E(1).a(Text.a(componentContext).a(graphQLGreetingCardPromotionFeedUnit.v().a()).o(2131430351).f(16842806, 2131362048).q(2131430350).a(false).a(Typeface.DEFAULT_BOLD).c().g(1, 2131428829).c(6, 2131428854).c(7, 2131427602).j()).a(Text.a(componentContext).a(graphQLGreetingCardPromotionFeedUnit.u().a()).o(2131428834).f(16842808, 2131362048).c().c(5, 2131428854).j()).a(m8908a(componentContext, graphQLGreetingCardPromotionFeedUnit.m()))).a(this.f7727a.a(componentContext, feedProps, MenuConfig.CLICKABLE, feedMenuHelper)).j();
    }

    private InternalNode m8908a(ComponentContext componentContext, GraphQLPrivacyScope graphQLPrivacyScope) {
        return Container.a(componentContext).C(2).a(Image.a(componentContext).a(this.f7729c.a(componentContext).h(this.f7728b.a(graphQLPrivacyScope.s())).i(-7235677).b()).c().d(7, 6).j()).a(Text.a(componentContext).a(graphQLPrivacyScope.j()).o(2131428835).f(16843282, 2131362048)).o(1, 2).o(3, 3).j(5, 2131428854).j();
    }
}
