package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.search.results.environment.HasSearchResultPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESULTS_PHOTO */
public class SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition<E extends HasPersistentState & HasInvalidate & HasSearchResultsContext & HasSearchResultPosition> extends BaseSinglePartDefinition<SearchResultsProps<SearchResultsWikiModulePage>, Void, E, BetterTextView> {
    public static final CacheableEntity f23657c = new C25301();
    private static SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition f23658d;
    private static final Object f23659e = new Object();
    public final SearchResultsLogger f23660a;
    public OnClickListener f23661b = null;

    /* compiled from: RESULTS_PHOTO */
    final class C25301 implements CacheableEntity {
        C25301() {
        }

        public final String m27312g() {
            return null;
        }
    }

    private static SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition m27314b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition(SearchResultsLogger.m25460a(injectorLike));
    }

    public final Object m27315a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        this.f23661b = new OnClickListener(this) {
            final /* synthetic */ SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition f23656c;

            public void onClick(View view) {
                boolean z;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 301689963);
                SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState = (SearchResultsCentralEntityWikiState) hasPersistentState.a(SearchResultsCentralEntityWikiState.m27347a((SearchResultsWikiModulePage) searchResultsProps.f23388a), SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition.f23657c);
                this.f23656c.f23660a.m25479a(((HasSearchResultsContext) hasPersistentState).mo1248s(), ((HasSearchResultPosition) hasPersistentState).mo1246a(searchResultsProps), searchResultsCentralEntityWikiState.m27348a(), (String) searchResultsProps.f23391d.orNull());
                if (searchResultsCentralEntityWikiState.m27348a()) {
                    z = false;
                } else {
                    z = true;
                }
                searchResultsCentralEntityWikiState.f23693a = z;
                ((HasInvalidate) hasPersistentState).hL_();
                LogUtils.a(-274348784, a);
            }
        };
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27316a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 179533426);
        ((BetterTextView) view).setOnClickListener(this.f23661b);
        Logger.a(8, EntryType.MARK_POP, 965913736, a);
    }

    public final void m27317b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((BetterTextView) view).setOnClickListener(null);
    }

    @Inject
    public SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition(SearchResultsLogger searchResultsLogger) {
        this.f23660a = searchResultsLogger;
    }

    public static SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition m27313a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23659e) {
                SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition searchResultsCentralEntityWikiClickBinderConvertedPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiClickBinderConvertedPartDefinition = (SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition) a2.a(f23659e);
                } else {
                    searchResultsCentralEntityWikiClickBinderConvertedPartDefinition = f23658d;
                }
                if (searchResultsCentralEntityWikiClickBinderConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27314b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23659e, b3);
                        } else {
                            f23658d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiClickBinderConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
