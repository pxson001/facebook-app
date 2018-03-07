package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESULTS_PAGED */
public class SearchResultsCentralEntityWikiClickBinderPartDefinition<E extends HasPersistentState & HasInvalidate & HasSearchResultsContext & HasFeedItemPosition> extends BaseSinglePartDefinition<SearchResultsCentralWikiUnit, Void, E, BetterTextView> {
    private static SearchResultsCentralEntityWikiClickBinderPartDefinition f23665c;
    private static final Object f23666d = new Object();
    public final SearchResultsLogger f23667a;
    public OnClickListener f23668b = null;

    private static SearchResultsCentralEntityWikiClickBinderPartDefinition m27319b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiClickBinderPartDefinition(SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m27320a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsCentralWikiUnit searchResultsCentralWikiUnit = (SearchResultsCentralWikiUnit) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        this.f23668b = new OnClickListener(this) {
            final /* synthetic */ SearchResultsCentralEntityWikiClickBinderPartDefinition f23664c;

            public void onClick(View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1210439131);
                SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState = (SearchResultsCentralEntityWikiState) hasPersistentState.a(SearchResultsCentralEntityWikiState.m27346a(searchResultsCentralWikiUnit), searchResultsCentralWikiUnit);
                this.f23664c.f23667a.m25479a(((HasSearchResultsContext) hasPersistentState).mo1248s(), ((HasFeedItemPosition) hasPersistentState).mo1245a(searchResultsCentralWikiUnit), searchResultsCentralEntityWikiState.m27348a(), (String) searchResultsCentralWikiUnit.mo1322l().orNull());
                if (searchResultsCentralEntityWikiState.m27348a()) {
                    z = false;
                } else {
                    z = true;
                }
                searchResultsCentralEntityWikiState.f23693a = z;
                ((HasInvalidate) hasPersistentState).hL_();
                LogUtils.a(-715568816, a);
            }
        };
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27321a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 695246626);
        ((BetterTextView) view).setOnClickListener(this.f23668b);
        Logger.a(8, EntryType.MARK_POP, -1277062319, a);
    }

    public final void m27322b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BetterTextView) view).setOnClickListener(null);
    }

    @Inject
    public SearchResultsCentralEntityWikiClickBinderPartDefinition(SearchResultsLogger searchResultsLogger) {
        this.f23667a = searchResultsLogger;
    }

    public static SearchResultsCentralEntityWikiClickBinderPartDefinition m27318a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiClickBinderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23666d) {
                SearchResultsCentralEntityWikiClickBinderPartDefinition searchResultsCentralEntityWikiClickBinderPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiClickBinderPartDefinition = (SearchResultsCentralEntityWikiClickBinderPartDefinition) a2.a(f23666d);
                } else {
                    searchResultsCentralEntityWikiClickBinderPartDefinition = f23665c;
                }
                if (searchResultsCentralEntityWikiClickBinderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27319b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23666d, b3);
                        } else {
                            f23665c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiClickBinderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
