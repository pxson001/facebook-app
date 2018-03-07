package com.facebook.feedplugins.hpp;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelPagePartDefinition;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelPagePartDefinition$Props;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelSeeAllPagesPartDefinition;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnit;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnitItem;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: customization_type_selection */
public class MobilePageAdminPanelBodyPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLMobilePageAdminPanelFeedUnit>, Void, E, HScrollRecyclerView> {
    private static final PaddingStyle f7778a = PageStyle.a;
    private static MobilePageAdminPanelBodyPartDefinition f7779h;
    private static final Object f7780i = new Object();
    public final MobilePageAdminPanelPagePartDefinition f7781b;
    public final MobilePageAdminPanelSeeAllPagesPartDefinition f7782c;
    private final BackgroundPartDefinition f7783d;
    private final PersistentRecyclerPartDefinition<MobilePageAdminPanelPagePartDefinition$Props, E> f7784e;
    public final FeedLoggingViewportEventListener f7785f;
    private final PageStyleFactory f7786g;

    private static MobilePageAdminPanelBodyPartDefinition m8951b(InjectorLike injectorLike) {
        return new MobilePageAdminPanelBodyPartDefinition(MobilePageAdminPanelPagePartDefinition.a(injectorLike), MobilePageAdminPanelSeeAllPagesPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m8953a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = (GraphQLMobilePageAdminPanelFeedUnit) feedProps.a;
        subParts.a(this.f7783d, new StylingData(feedProps, f7778a));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f7784e;
        PageStyle a = this.f7786g.a(f7778a);
        int ac_ = graphQLMobilePageAdminPanelFeedUnit.ac_();
        final ImmutableList a2 = ScrollableItemListFeedUnitImpl.a(graphQLMobilePageAdminPanelFeedUnit);
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new Callbacks<MobilePageAdminPanelPagePartDefinition$Props, E>(this) {
            final /* synthetic */ MobilePageAdminPanelBodyPartDefinition f7777c;

            public final Object m8948b(int i) {
                if (i == a2.size()) {
                    return new MobilePageAdminPanelPagePartDefinition$Props(null, null);
                }
                return new MobilePageAdminPanelPagePartDefinition$Props(graphQLMobilePageAdminPanelFeedUnit, (GraphQLMobilePageAdminPanelFeedUnitItem) a2.get(i));
            }

            public final SinglePartDefinitionWithViewType<MobilePageAdminPanelPagePartDefinition$Props, ?, ? super E, ?> m8947a(int i) {
                if (i == a2.size()) {
                    return this.f7777c.f7782c;
                }
                return this.f7777c.f7781b;
            }

            public final void m8949c(int i) {
                this.f7777c.f7785f.a(graphQLMobilePageAdminPanelFeedUnit, i);
                VisibleItemHelper.a(graphQLMobilePageAdminPanelFeedUnit, a2, i);
            }

            public final int m8946a() {
                if (a2.size() > 1) {
                    MobilePageAdminPanelSeeAllPagesPartDefinition mobilePageAdminPanelSeeAllPagesPartDefinition = this.f7777c.f7782c;
                    GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = graphQLMobilePageAdminPanelFeedUnit;
                    Object obj = 1;
                    if (graphQLMobilePageAdminPanelFeedUnit.p().isEmpty() || graphQLMobilePageAdminPanelFeedUnit.p().size() <= 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        return a2.size() + 1;
                    }
                }
                return a2.size();
            }
        }, graphQLMobilePageAdminPanelFeedUnit.g(), graphQLMobilePageAdminPanelFeedUnit));
        return null;
    }

    public final boolean m8954a(Object obj) {
        return !((GraphQLMobilePageAdminPanelFeedUnit) ((FeedProps) obj).a).p().isEmpty();
    }

    @Inject
    public MobilePageAdminPanelBodyPartDefinition(MobilePageAdminPanelPagePartDefinition mobilePageAdminPanelPagePartDefinition, MobilePageAdminPanelSeeAllPagesPartDefinition mobilePageAdminPanelSeeAllPagesPartDefinition, BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, FeedLoggingViewportEventListener feedLoggingViewportEventListener, PageStyleFactory pageStyleFactory) {
        this.f7781b = mobilePageAdminPanelPagePartDefinition;
        this.f7782c = mobilePageAdminPanelSeeAllPagesPartDefinition;
        this.f7783d = backgroundPartDefinition;
        this.f7784e = persistentRecyclerPartDefinition;
        this.f7785f = feedLoggingViewportEventListener;
        this.f7786g = pageStyleFactory;
    }

    public static MobilePageAdminPanelBodyPartDefinition m8950a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MobilePageAdminPanelBodyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7780i) {
                MobilePageAdminPanelBodyPartDefinition mobilePageAdminPanelBodyPartDefinition;
                if (a2 != null) {
                    mobilePageAdminPanelBodyPartDefinition = (MobilePageAdminPanelBodyPartDefinition) a2.a(f7780i);
                } else {
                    mobilePageAdminPanelBodyPartDefinition = f7779h;
                }
                if (mobilePageAdminPanelBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8951b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7780i, b3);
                        } else {
                            f7779h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mobilePageAdminPanelBodyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m8952a() {
        return HScrollRecyclerViewRowType.a;
    }
}
