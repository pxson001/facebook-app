package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
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
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.collection.SearchResultsSeeMorePartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsTabSwitchPartDefinition.TabSwitchData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Presence callback onFailure */
public class SearchResultsTitleActionPartDefinition<E extends HasPositionInformation & HasContext> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<?>>, Drawable, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24397a = ViewType.a(2130907016);
    private static final PaddingStyle f24398b;
    private static SearchResultsTitleActionPartDefinition f24399j;
    private static final Object f24400k = new Object();
    private final QeAccessor f24401c;
    private final GlyphColorizer f24402d;
    private final ContentViewTitlePartDefinition f24403e;
    private final TextPartDefinition f24404f;
    private final Lazy<SearchResultsTabSwitchPartDefinition> f24405g;
    private final Lazy<SearchResultsSeeMoreClickListenerPartDefinition> f24406h;
    private final BackgroundPartDefinition f24407i;

    private static SearchResultsTitleActionPartDefinition m27885b(InjectorLike injectorLike) {
        return new SearchResultsTitleActionPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), ContentViewTitlePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 10673), IdBasedLazy.a(injectorLike, 10672), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27887a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f24407i, new StylingData(null, f24398b, Position.TOP));
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        boolean a = m27884a(searchResultsCollectionUnit);
        subParts.a(this.f24403e, searchResultsCollectionUnit.f23462c.or(""));
        subParts.a(2131559198, this.f24404f, a ? ((HasContext) hasPositionInformation).getContext().getString(2131239046) : "");
        SearchResultsTab b = SearchResultsSeeMorePartDefinition.m27458b(this.f24401c, searchResultsCollectionUnit);
        if (b != null) {
            subParts.a((SinglePartDefinition) this.f24405g.get(), new TabSwitchData(b, searchResultsCollectionUnit, a));
        } else {
            subParts.a((SinglePartDefinition) this.f24406h.get(), new SeeMoreData(searchResultsCollectionUnit, SearchResultsSeeMorePartDefinition.f23839b, 2131239062, a));
        }
        Integer a2 = SearchResultsTitlePartDefinition.m27891a(searchResultsCollectionUnit.mo1321k(), (GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.f23460a.or(GraphQLGraphSearchResultsDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE));
        if (a2 != null) {
            return this.f24402d.a(a2.intValue(), ((Integer) SearchResultsTitlePartDefinition.f24412b.get(a2)).intValue());
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27888a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1781384477);
        ((ContentViewWithButton) view).setThumbnailDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, -149537305, a);
    }

    public final boolean m27889a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) ((FeedProps) obj).a;
        boolean z = SearchResultsSeeMorePartDefinition.m27456a(this.f24401c, searchResultsCollectionUnit) && this.f24401c.a(ExperimentsForSearchAbTestModule.p, false);
        if (m27884a(searchResultsCollectionUnit) || z) {
            return true;
        }
        return false;
    }

    static {
        Builder a = Builder.a();
        a.b = 2.0f;
        f24398b = a.i();
    }

    public static SearchResultsTitleActionPartDefinition m27883a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTitleActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24400k) {
                SearchResultsTitleActionPartDefinition searchResultsTitleActionPartDefinition;
                if (a2 != null) {
                    searchResultsTitleActionPartDefinition = (SearchResultsTitleActionPartDefinition) a2.a(f24400k);
                } else {
                    searchResultsTitleActionPartDefinition = f24399j;
                }
                if (searchResultsTitleActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27885b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24400k, b3);
                        } else {
                            f24399j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTitleActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsTitleActionPartDefinition(QeAccessor qeAccessor, GlyphColorizer glyphColorizer, ContentViewTitlePartDefinition contentViewTitlePartDefinition, TextPartDefinition textPartDefinition, Lazy<SearchResultsTabSwitchPartDefinition> lazy, Lazy<SearchResultsSeeMoreClickListenerPartDefinition> lazy2, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24401c = qeAccessor;
        this.f24402d = glyphColorizer;
        this.f24403e = contentViewTitlePartDefinition;
        this.f24404f = textPartDefinition;
        this.f24405g = lazy;
        this.f24406h = lazy2;
        this.f24407i = backgroundPartDefinition;
    }

    public final ViewType<ContentViewWithButton> m27886a() {
        return f24397a;
    }

    private boolean m27884a(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        if (searchResultsCollectionUnit.f23460a.isPresent() && searchResultsCollectionUnit.f23460a.get() == GraphQLGraphSearchResultsDisplayStyle.USERS && this.f24401c.a(ExperimentsForSearchAbTestModule.V, false)) {
            return true;
        }
        return false;
    }
}
