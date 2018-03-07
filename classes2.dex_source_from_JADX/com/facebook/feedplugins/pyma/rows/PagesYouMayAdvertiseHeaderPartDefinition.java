package com.facebook.feedplugins.pyma.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler$Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.pyma.PYMAAnalyticsHelper;
import com.facebook.feedplugins.pyma.PYMADataModelHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HashCodeEqualsUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_aldrin_enabled_fb4a */
public class PagesYouMayAdvertiseHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, Void, E, TextWithMenuButtonView> {
    public static final ViewType f19268a = new 1();
    private static PagesYouMayAdvertiseHeaderPartDefinition f19269g;
    private static final Object f19270h = new Object();
    private final BackgroundPartDefinition f19271b;
    private final MenuButtonPartDefinition f19272c;
    private final TextPartDefinition f19273d;
    private final PYMADataModelHelper f19274e;
    private final PYMAAnalyticsHelper f19275f;

    private static PagesYouMayAdvertiseHeaderPartDefinition m26984b(InjectorLike injectorLike) {
        return new PagesYouMayAdvertiseHeaderPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), MenuButtonPartDefinition.m26324a(injectorLike), TextPartDefinition.m19379a(injectorLike), PYMADataModelHelper.a(injectorLike), PYMAAnalyticsHelper.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.f13444a;
        subParts.mo2756a(this.f19271b, new StylingData(feedProps, PaddingStyle.f13080j, BackgroundStyler$Position.DIVIDER_BOTTOM));
        subParts.mo2755a(2131562876, this.f19273d, graphQLPagesYouMayAdvertiseFeedUnit.m25623u().m23513j());
        subParts.mo2755a(2131560877, this.f19272c, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    @Inject
    public PagesYouMayAdvertiseHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, TextPartDefinition textPartDefinition, PYMADataModelHelper pYMADataModelHelper, PYMAAnalyticsHelper pYMAAnalyticsHelper) {
        this.f19271b = backgroundPartDefinition;
        this.f19272c = menuButtonPartDefinition;
        this.f19273d = textPartDefinition;
        this.f19274e = pYMADataModelHelper;
        this.f19275f = pYMAAnalyticsHelper;
    }

    public static PagesYouMayAdvertiseHeaderPartDefinition m26983a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayAdvertiseHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19270h) {
                PagesYouMayAdvertiseHeaderPartDefinition pagesYouMayAdvertiseHeaderPartDefinition;
                if (a2 != null) {
                    pagesYouMayAdvertiseHeaderPartDefinition = (PagesYouMayAdvertiseHeaderPartDefinition) a2.mo818a(f19270h);
                } else {
                    pagesYouMayAdvertiseHeaderPartDefinition = f19269g;
                }
                if (pagesYouMayAdvertiseHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26984b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19270h, b3);
                        } else {
                            f19269g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayAdvertiseHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return f19268a;
    }

    public final boolean m26987a(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps) {
        if (((GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.f13444a).m25623u() != null) {
            return true;
        }
        this.f19275f.a((GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.f13444a, "PYMA header hidden because of NULL Privacy Scope");
        return false;
    }

    public final boolean m26988a(FeedUnit feedUnit, FeedUnit feedUnit2) {
        if (feedUnit == null || !(feedUnit instanceof GraphQLPagesYouMayAdvertiseFeedUnit)) {
            return false;
        }
        FeedProps b = this.f19274e.b(FeedProps.m19802c((GraphQLPagesYouMayAdvertiseFeedUnit) feedUnit), false);
        if (b != null) {
            return HashCodeEqualsUtil.a((GraphQLStory) b.f13444a, feedUnit2);
        }
        return false;
    }
}
