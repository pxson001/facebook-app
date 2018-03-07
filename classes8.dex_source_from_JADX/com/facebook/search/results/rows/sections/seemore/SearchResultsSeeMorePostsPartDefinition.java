package com.facebook.search.results.rows.sections.seemore;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition.IconData;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.HasSearchResultsPerformanceLogger;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsSeeMorePostsUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreLogger;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PREVIEW_CLOSED */
public class SearchResultsSeeMorePostsPartDefinition<E extends HasPositionInformation & HasContext & HasFeedItemPosition & HasSearchResultsContext & HasSearchResultsPerformanceLogger> extends MultiRowSinglePartDefinition<SearchResultsSeeMorePostsUnit, Void, E, LinearLayout> {
    public static final ViewType<LinearLayout> f24978a = ViewType.a(2130907049);
    private static final PaddingStyle f24979b;
    private static final SearchResultsSeeMoreLogger f24980c = new C26271();
    private static SearchResultsSeeMorePostsPartDefinition f24981h;
    private static final Object f24982i = new Object();
    private final TextPartDefinition f24983d;
    private final PaddingPartDefinition f24984e;
    private final SearchResultsSeeMoreClickListenerPartDefinition<E> f24985f;
    private final ImageWithTextViewDrawablePartDefinition f24986g;

    /* compiled from: PREVIEW_CLOSED */
    final class C26271 implements SearchResultsSeeMoreLogger {
        C26271() {
        }

        public final <E extends HasSearchResultsContext & HasFeedItemPosition> void mo1334a(SearchResultsLogger searchResultsLogger, E e, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit) {
            SearchResultsSeeMorePostsUnit searchResultsSeeMorePostsUnit = (SearchResultsSeeMorePostsUnit) searchResultsSeeMoreFeedUnit;
            searchResultsLogger.m25481a(e.mo1248s(), searchResultsSeeMorePostsUnit.mo1321k(), (String) searchResultsSeeMorePostsUnit.mo1322l().orNull(), ((HasFeedItemPosition) e).mo1245a(searchResultsSeeMorePostsUnit));
        }
    }

    private static SearchResultsSeeMorePostsPartDefinition m28326b(InjectorLike injectorLike) {
        return new SearchResultsSeeMorePostsPartDefinition(TextPartDefinition.a(injectorLike), PaddingPartDefinition.a(injectorLike), SearchResultsSeeMoreClickListenerPartDefinition.m27600a(injectorLike), ImageWithTextViewDrawablePartDefinition.a(injectorLike));
    }

    public final Object m28328a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsSeeMorePostsUnit searchResultsSeeMorePostsUnit = (SearchResultsSeeMorePostsUnit) obj;
        subParts.a(this.f24984e, new PaddingData(searchResultsSeeMorePostsUnit, PaddingStyle.a, Position.MIDDLE, 0));
        subParts.a(2131558956, this.f24984e, new PaddingData(searchResultsSeeMorePostsUnit, f24979b, Position.MIDDLE, 0));
        subParts.a(2131558956, this.f24983d, searchResultsSeeMorePostsUnit.f23512b);
        subParts.a(this.f24985f, new SeeMoreData(searchResultsSeeMorePostsUnit, f24980c, 2131239044));
        subParts.a(2131558956, this.f24986g, new IconData(2130843295, Integer.valueOf(-12887656)));
        return null;
    }

    public final boolean m28329a(Object obj) {
        return ((SearchResultsSeeMorePostsUnit) obj).f23512b != null;
    }

    static {
        Builder c = Builder.c();
        c.b = 4.0f;
        c = c;
        c.d = 8.0f;
        c = c;
        c.c = 4.0f;
        f24979b = c.i();
    }

    public static SearchResultsSeeMorePostsPartDefinition m28325a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMorePostsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24982i) {
                SearchResultsSeeMorePostsPartDefinition searchResultsSeeMorePostsPartDefinition;
                if (a2 != null) {
                    searchResultsSeeMorePostsPartDefinition = (SearchResultsSeeMorePostsPartDefinition) a2.a(f24982i);
                } else {
                    searchResultsSeeMorePostsPartDefinition = f24981h;
                }
                if (searchResultsSeeMorePostsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28326b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24982i, b3);
                        } else {
                            f24981h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMorePostsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsSeeMorePostsPartDefinition(TextPartDefinition textPartDefinition, PaddingPartDefinition paddingPartDefinition, SearchResultsSeeMoreClickListenerPartDefinition searchResultsSeeMoreClickListenerPartDefinition, ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition) {
        this.f24983d = textPartDefinition;
        this.f24984e = paddingPartDefinition;
        this.f24985f = searchResultsSeeMoreClickListenerPartDefinition;
        this.f24986g = imageWithTextViewDrawablePartDefinition;
    }

    public final ViewType<LinearLayout> m28327a() {
        return f24978a;
    }
}
