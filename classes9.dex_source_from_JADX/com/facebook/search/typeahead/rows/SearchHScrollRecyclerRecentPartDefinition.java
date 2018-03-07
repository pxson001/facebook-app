package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.HorizontalRecentSearchesUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.results.rows.SearchBackgroundPartDefinition;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_attachment_data */
public class SearchHScrollRecyclerRecentPartDefinition<E extends HasPersistentState & HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<HorizontalRecentSearchesUnit, Void, E, HScrollRecyclerView> {
    private static SearchHScrollRecyclerRecentPartDefinition f443e;
    private static final Object f444f = new Object();
    private final SearchBackgroundPartDefinition f445a;
    private final PersistentRecyclerPartDefinition<Object, E> f446b;
    public final HScrollRecentSearchPagePartDefinition f447c;
    public final PageStyleFactory f448d;

    private static SearchHScrollRecyclerRecentPartDefinition m554b(InjectorLike injectorLike) {
        return new SearchHScrollRecyclerRecentPartDefinition(SearchBackgroundPartDefinition.a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), HScrollRecentSearchPagePartDefinition.m531a(injectorLike), PageStyleFactory.b(injectorLike));
    }

    public final Object m556a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final HorizontalRecentSearchesUnit horizontalRecentSearchesUnit = (HorizontalRecentSearchesUnit) obj;
        subParts.a(this.f445a, new StylingData(FeedProps.c(horizontalRecentSearchesUnit), PaddingStyle.a, Position.MIDDLE));
        subParts.a(this.f446b, new Props(this.f448d.a(78.0f, PaddingStyle.a, true), 0, new SimpleCallbacks<E>(this) {
            final /* synthetic */ SearchHScrollRecyclerRecentPartDefinition f442b;

            public final void m552c(int i) {
            }

            public final void m551a(PageSubParts<E> pageSubParts) {
                ImmutableList f = horizontalRecentSearchesUnit.f();
                int size = f.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f442b.f447c, (NullStateSuggestionTypeaheadUnit) ((TypeaheadUnit) f.get(i)));
                }
            }

            public final int m550a() {
                return horizontalRecentSearchesUnit.f().size();
            }
        }, horizontalRecentSearchesUnit.g(), horizontalRecentSearchesUnit));
        return null;
    }

    @Inject
    public SearchHScrollRecyclerRecentPartDefinition(SearchBackgroundPartDefinition searchBackgroundPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, HScrollRecentSearchPagePartDefinition hScrollRecentSearchPagePartDefinition, PageStyleFactory pageStyleFactory) {
        this.f445a = searchBackgroundPartDefinition;
        this.f446b = persistentRecyclerPartDefinition;
        this.f447c = hScrollRecentSearchPagePartDefinition;
        this.f448d = pageStyleFactory;
    }

    public static SearchHScrollRecyclerRecentPartDefinition m553a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchHScrollRecyclerRecentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f444f) {
                SearchHScrollRecyclerRecentPartDefinition searchHScrollRecyclerRecentPartDefinition;
                if (a2 != null) {
                    searchHScrollRecyclerRecentPartDefinition = (SearchHScrollRecyclerRecentPartDefinition) a2.a(f444f);
                } else {
                    searchHScrollRecyclerRecentPartDefinition = f443e;
                }
                if (searchHScrollRecyclerRecentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m554b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f444f, b3);
                        } else {
                            f443e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchHScrollRecyclerRecentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<HScrollRecyclerView> m555a() {
        return HScrollRecyclerViewRowType.b;
    }

    public final boolean m557a(Object obj) {
        return true;
    }
}
