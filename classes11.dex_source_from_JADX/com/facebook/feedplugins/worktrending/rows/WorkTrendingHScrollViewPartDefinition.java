package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollUtil;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnit;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnitItem;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.app.LoadedApk */
public class WorkTrendingHScrollViewPartDefinition<E extends HasPositionInformation & HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<FeedProps<? extends GraphQLWorkCommunityTrendingFeedUnit>, Void, E, HScrollRecyclerView> {
    private static WorkTrendingHScrollViewPartDefinition f10021f;
    private static final Object f10022g = new Object();
    private final BackgroundPartDefinition f10023a;
    private final PageStyleFactory f10024b;
    private final PersistentRecyclerPartDefinition<Object, E> f10025c;
    private final HScrollUtil f10026d;
    public final WorkTrendingPagePartDefinition f10027e;

    private static WorkTrendingHScrollViewPartDefinition m10372b(InjectorLike injectorLike) {
        return new WorkTrendingHScrollViewPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), HScrollUtil.a(injectorLike), WorkTrendingPagePartDefinition.m10383a(injectorLike));
    }

    public final Object m10374a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = (GraphQLWorkCommunityTrendingFeedUnit) feedProps.a;
        PaddingStyle paddingStyle = PageStyle.a;
        subParts.a(this.f10023a, new StylingData(feedProps, paddingStyle));
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f10025c;
        PageStyle a = this.f10024b.a(this.f10026d.b(), paddingStyle, true);
        int ac_ = graphQLWorkCommunityTrendingFeedUnit.ac_();
        final ImmutableList o = graphQLWorkCommunityTrendingFeedUnit.o();
        subParts.a(persistentRecyclerPartDefinition, new Props(a, ac_, new SimpleCallbacks<E>(this) {
            final /* synthetic */ WorkTrendingHScrollViewPartDefinition f10020c;

            public final void m10369a(PageSubParts<E> pageSubParts) {
                int size = o.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f10020c.f10027e, new WorkTrendingPagePartDefinition.Props(graphQLWorkCommunityTrendingFeedUnit, (GraphQLWorkCommunityTrendingFeedUnitItem) o.get(i)));
                }
            }

            public final void m10370c(int i) {
                VisibleItemHelper.a(graphQLWorkCommunityTrendingFeedUnit, o, i);
            }
        }, graphQLWorkCommunityTrendingFeedUnit.g(), graphQLWorkCommunityTrendingFeedUnit));
        return null;
    }

    @Inject
    public WorkTrendingHScrollViewPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, HScrollUtil hScrollUtil, WorkTrendingPagePartDefinition workTrendingPagePartDefinition) {
        this.f10023a = backgroundPartDefinition;
        this.f10024b = pageStyleFactory;
        this.f10025c = persistentRecyclerPartDefinition;
        this.f10026d = hScrollUtil;
        this.f10027e = workTrendingPagePartDefinition;
    }

    public static WorkTrendingHScrollViewPartDefinition m10371a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingHScrollViewPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10022g) {
                WorkTrendingHScrollViewPartDefinition workTrendingHScrollViewPartDefinition;
                if (a2 != null) {
                    workTrendingHScrollViewPartDefinition = (WorkTrendingHScrollViewPartDefinition) a2.a(f10022g);
                } else {
                    workTrendingHScrollViewPartDefinition = f10021f;
                }
                if (workTrendingHScrollViewPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10372b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10022g, b3);
                        } else {
                            f10021f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingHScrollViewPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m10375a(Object obj) {
        return false;
    }

    public final ViewType m10373a() {
        return HScrollRecyclerViewRowType.a;
    }
}
