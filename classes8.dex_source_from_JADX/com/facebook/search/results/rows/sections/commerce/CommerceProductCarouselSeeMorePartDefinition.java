package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.search.results.rows.sections.collection.SearchResultsSeeMorePartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition.TabSwitchData;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REFRESH_PAGE_CARDS */
public class CommerceProductCarouselSeeMorePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<SearchResultsProductItemUnit>>, Void, SearchResultsFeedEnvironment, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f23908a = new C25481();
    private static CommerceProductCarouselSeeMorePartDefinition f23909e;
    private static final Object f23910f = new Object();
    private final SearchResultsTabSwitchPartDefinition f23911b;
    private final SearchResultsSeeMoreClickListenerPartDefinition f23912c;
    private final QeAccessor f23913d;

    /* compiled from: REFRESH_PAGE_CARDS */
    final class C25481 extends ViewType<CustomFrameLayout> {
        C25481() {
        }

        public final View m27505a(Context context) {
            return (CustomFrameLayout) LayoutInflater.from(context).inflate(2130906978, null);
        }
    }

    private static CommerceProductCarouselSeeMorePartDefinition m27507b(InjectorLike injectorLike) {
        return new CommerceProductCarouselSeeMorePartDefinition(SearchResultsTabSwitchPartDefinition.m27607a(injectorLike), SearchResultsSeeMoreClickListenerPartDefinition.m27600a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27509a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (this.f23913d.a(ExperimentsForSearchAbTestModule.w, false)) {
            subParts.a(this.f23912c, new SeeMoreData((SearchResultsSeeMoreFeedUnit) feedProps.a, SearchResultsSeeMorePartDefinition.f23839b, 2131239062));
        } else {
            subParts.a(this.f23911b, new TabSwitchData(SearchResultsTab.MARKETPLACE, (SearchResultsCollectionUnit) feedProps.a));
        }
        return null;
    }

    @Inject
    public CommerceProductCarouselSeeMorePartDefinition(SearchResultsTabSwitchPartDefinition searchResultsTabSwitchPartDefinition, SearchResultsSeeMoreClickListenerPartDefinition searchResultsSeeMoreClickListenerPartDefinition, QeAccessor qeAccessor) {
        this.f23911b = searchResultsTabSwitchPartDefinition;
        this.f23912c = searchResultsSeeMoreClickListenerPartDefinition;
        this.f23913d = qeAccessor;
    }

    public final ViewType<CustomFrameLayout> m27508a() {
        return f23908a;
    }

    public static CommerceProductCarouselSeeMorePartDefinition m27506a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceProductCarouselSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23910f) {
                CommerceProductCarouselSeeMorePartDefinition commerceProductCarouselSeeMorePartDefinition;
                if (a2 != null) {
                    commerceProductCarouselSeeMorePartDefinition = (CommerceProductCarouselSeeMorePartDefinition) a2.a(f23910f);
                } else {
                    commerceProductCarouselSeeMorePartDefinition = f23909e;
                }
                if (commerceProductCarouselSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27507b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23910f, b3);
                        } else {
                            f23909e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceProductCarouselSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27510a(Object obj) {
        return true;
    }
}
