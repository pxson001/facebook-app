package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REGULAR */
public class CommerceProductCarouselPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<SearchResultsProductItemUnit>>, Void, SearchResultsFeedEnvironment, HScrollRecyclerView> {
    private static final GraphQLObjectType f23898a = new GraphQLObjectType(175920258);
    private static CommerceProductCarouselPartDefinition f23899i;
    private static final Object f23900j = new Object();
    private final QeAccessor f23901b;
    public final CommerceProductItemPartDefinition f23902c;
    private final BackgroundPartDefinition f23903d;
    private final PersistentRecyclerPartDefinition<Object, SearchResultsFeedEnvironment> f23904e;
    private final PageStyleFactory f23905f;
    public final CommerceProductCarouselSeeMorePartDefinition f23906g;
    public final SearchResultsLogger f23907h;

    private static CommerceProductCarouselPartDefinition m27501b(InjectorLike injectorLike) {
        return new CommerceProductCarouselPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CommerceProductItemPartDefinition.m27516a(injectorLike), BackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), CommerceProductCarouselSeeMorePartDefinition.m27506a(injectorLike), SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m27503a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsFeedEnvironmentGenerated searchResultsFeedEnvironmentGenerated = (SearchResultsFeedEnvironmentGenerated) anyEnvironment;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f23903d, new StylingData(feedProps, PaddingStyle.a, Position.MIDDLE));
        subParts.a(this.f23904e, m27499a(searchResultsCollectionUnit, searchResultsFeedEnvironmentGenerated));
        return null;
    }

    public final boolean m27504a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) ((FeedProps) obj).a;
        return !this.f23901b.a(ExperimentsForSearchAbTestModule.c, false) && searchResultsCollectionUnit.f23460a.orNull() == GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL && searchResultsCollectionUnit.f23463d.size() >= 3 && searchResultsCollectionUnit.f23465f.isPresent() && ((GraphQLObjectType) searchResultsCollectionUnit.f23465f.get()).e().equals(f23898a.e());
    }

    @Inject
    public CommerceProductCarouselPartDefinition(QeAccessor qeAccessor, CommerceProductItemPartDefinition commerceProductItemPartDefinition, BackgroundPartDefinition backgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, PageStyleFactory pageStyleFactory, CommerceProductCarouselSeeMorePartDefinition commerceProductCarouselSeeMorePartDefinition, SearchResultsLogger searchResultsLogger) {
        this.f23901b = qeAccessor;
        this.f23902c = commerceProductItemPartDefinition;
        this.f23903d = backgroundPartDefinition;
        this.f23904e = persistentRecyclerPartDefinition;
        this.f23905f = pageStyleFactory;
        this.f23906g = commerceProductCarouselSeeMorePartDefinition;
        this.f23907h = searchResultsLogger;
    }

    public static CommerceProductCarouselPartDefinition m27500a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceProductCarouselPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23900j) {
                CommerceProductCarouselPartDefinition commerceProductCarouselPartDefinition;
                if (a2 != null) {
                    commerceProductCarouselPartDefinition = (CommerceProductCarouselPartDefinition) a2.a(f23900j);
                } else {
                    commerceProductCarouselPartDefinition = f23899i;
                }
                if (commerceProductCarouselPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27501b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23900j, b3);
                        } else {
                            f23899i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceProductCarouselPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<HScrollRecyclerView> m27502a() {
        return HScrollRecyclerViewRowType.b;
    }

    private Props<Object, SearchResultsFeedEnvironment> m27499a(final SearchResultsCollectionUnit<SearchResultsProductItemUnit> searchResultsCollectionUnit, final SearchResultsFeedEnvironment searchResultsFeedEnvironment) {
        return new Props(this.f23905f.a(160.0f, PageStyle.a, true), 0, new SimpleCallbacks<SearchResultsFeedEnvironment>(this) {
            final /* synthetic */ CommerceProductCarouselPartDefinition f23896c;
            private boolean f23897d = false;

            public final void m27497a(PageSubParts<SearchResultsFeedEnvironment> pageSubParts) {
                ImmutableList immutableList = searchResultsCollectionUnit.f23463d;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) immutableList.get(i);
                    CommerceProductItemPartDefinition commerceProductItemPartDefinition = this.f23896c.f23902c;
                    if (CommerceProductItemPartDefinition.m27518a(searchResultsProductItemUnit)) {
                        pageSubParts.a(this.f23896c.f23902c, searchResultsProductItemUnit);
                    }
                }
                pageSubParts.a(this.f23896c.f23906g, FeedProps.c(searchResultsCollectionUnit));
            }

            public final void m27498c(int i) {
                if (i >= 0 && !this.f23897d) {
                    SearchResultsLogger searchResultsLogger = this.f23896c.f23907h;
                    HoneyClientEvent a = SearchResultsLogger.m25459a(Event.COMMERCE_CAROUSEL_INTERACTION, searchResultsFeedEnvironment.mo1248s());
                    searchResultsLogger.f21958c.a(a);
                    if (BLog.b(3)) {
                        String str = a.d;
                        a.u();
                    }
                    this.f23897d = true;
                }
            }

            public final int m27496a() {
                ImmutableList immutableList = searchResultsCollectionUnit.f23463d;
                int size = immutableList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    int i3;
                    SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) immutableList.get(i);
                    CommerceProductItemPartDefinition commerceProductItemPartDefinition = this.f23896c.f23902c;
                    if (CommerceProductItemPartDefinition.m27518a(searchResultsProductItemUnit)) {
                        i3 = i2 + 1;
                    } else {
                        i3 = i2;
                    }
                    i++;
                    i2 = i3;
                }
                return i2 + 1;
            }
        }, ((SearchResultsProductItemUnit) searchResultsCollectionUnit.f23463d.get(0)).f23494a.dp(), searchResultsCollectionUnit);
    }
}
