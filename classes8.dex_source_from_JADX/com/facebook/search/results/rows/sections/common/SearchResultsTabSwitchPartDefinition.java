package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.environment.tabs.CanSwitchResultPageTab;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_OVERLAY_CLOSED */
public class SearchResultsTabSwitchPartDefinition<E extends HasContext & CanSwitchResultPageTab & HasFeedItemPosition & HasSearchResultsContext> extends BaseSinglePartDefinition<TabSwitchData, OnClickListener, E, View> {
    private static SearchResultsTabSwitchPartDefinition f24041b;
    private static final Object f24042c = new Object();
    private final SearchResultsLogger f24043a;

    /* compiled from: REACTION_OVERLAY_CLOSED */
    public class TabSwitchData {
        public final SearchResultsTab f24038a;
        public final SearchResultsCollectionUnit<?> f24039b;
        public final boolean f24040c;

        public TabSwitchData(SearchResultsTab searchResultsTab, SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
            this(searchResultsTab, searchResultsCollectionUnit, false);
        }

        public TabSwitchData(SearchResultsTab searchResultsTab, SearchResultsCollectionUnit<?> searchResultsCollectionUnit, boolean z) {
            this.f24038a = searchResultsTab;
            this.f24039b = searchResultsCollectionUnit;
            this.f24040c = z;
        }
    }

    private static SearchResultsTabSwitchPartDefinition m27609b(InjectorLike injectorLike) {
        return new SearchResultsTabSwitchPartDefinition(SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m27610a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final TabSwitchData tabSwitchData = (TabSwitchData) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        return new OnClickListener(this) {
            final /* synthetic */ SearchResultsTabSwitchPartDefinition f24037c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1578619191);
                this.f24037c.m27611a(hasContext, tabSwitchData);
                Logger.a(2, EntryType.UI_INPUT_END, -174976864, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m27612a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 358029835);
        m27608a((TabSwitchData) obj, (OnClickListener) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1496416615, a);
    }

    public final void m27613b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        View view2;
        if (((TabSwitchData) obj).f24040c && (view instanceof ContentView)) {
            view2 = ((ContentView) view).a;
        } else {
            view2 = view;
        }
        if (view2 != null) {
            view = view2;
        }
        view.setOnClickListener(null);
    }

    @Inject
    public SearchResultsTabSwitchPartDefinition(SearchResultsLogger searchResultsLogger) {
        this.f24043a = searchResultsLogger;
    }

    public static SearchResultsTabSwitchPartDefinition m27607a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTabSwitchPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24042c) {
                SearchResultsTabSwitchPartDefinition searchResultsTabSwitchPartDefinition;
                if (a2 != null) {
                    searchResultsTabSwitchPartDefinition = (SearchResultsTabSwitchPartDefinition) a2.a(f24042c);
                } else {
                    searchResultsTabSwitchPartDefinition = f24041b;
                }
                if (searchResultsTabSwitchPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27609b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24042c, b3);
                        } else {
                            f24041b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTabSwitchPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m27608a(TabSwitchData tabSwitchData, OnClickListener onClickListener, View view) {
        View view2;
        if (tabSwitchData.f24040c && (view instanceof ContentView)) {
            view2 = ((ContentView) view).a;
        } else {
            view2 = view;
        }
        if (view2 != null) {
            view = view2;
        }
        view.setOnClickListener(onClickListener);
    }

    public final void m27611a(E e, TabSwitchData tabSwitchData) {
        ((CanSwitchResultPageTab) e).mo1258a(tabSwitchData.f24038a);
        this.f24043a.m25483a(((HasSearchResultsContext) e).mo1248s(), tabSwitchData.f24039b.mo1321k(), (String) tabSwitchData.f24039b.mo1322l().orNull(), (GraphQLGraphSearchResultsDisplayStyle) tabSwitchData.f24039b.f23460a.orNull(), ((HasFeedItemPosition) e).mo1245a(tabSwitchData.f24039b), tabSwitchData.f24039b.f23463d.size(), (GraphQLObjectType) tabSwitchData.f24039b.f23465f.orNull());
    }
}
